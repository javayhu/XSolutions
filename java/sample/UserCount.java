import java.io.IOException;
import java.util.StringTokenizer;

import org.json.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class UserCount {

    public static class CountMapper extends Mapper<Object, Text, Text, Text> {

        private Text userid = new Text();
        private Text name = new Text();

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            //implement here
            //使用IntWritable.set(int)和Text.set(String)来对IntWritable和Text的object赋值
            //可以参考http://wiki.apache.org/hadoop/WordCount来写程序
            JSONObject js = null;
            try {
                js = new JSONObject(value.toString());
                if (js.has("user_id")) {//形式如 { "_id" : { "$numberLong" : "3480773598705367" }, "text" : "今天去了广州动物园哈！", "user_id" : 1794171824, "created_at" : "Sun Aug 19 16:22:36 +0800 2012" }
                    userid.set(getUserIdString(js, "user_id"));
                    name.set("1");
                    context.write(userid, name);// (user_id,1)
                } else if (js.has("name") && js.has("_id")) {//形式如 { "_id" : 1763150092, "name" : "Creamy_CHT" }
                    userid.set(getUserIdString(js, "_id"));
                    name.set(js.getString("name"));
                    context.write(userid, name);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public String getUserIdString(JSONObject js, String label) throws JSONException {
            JSONObject jsid = null;
            String strid = js.getString(label);
            if (strid.indexOf("$") > 0) {//形式如 "_id" : { "$numberLong" : "2348374473" }
                jsid = new JSONObject(strid);
                if (jsid.has("$numberLong")) {
                    return jsid.getString("$numberLong");
                }
            }
            return strid;//形式如 "_id" : 1783610855 或者 "user_id" : 1794171824
        }

    }

    public static class CountReducer extends Reducer<Text, Text, Text, IntWritable> {

        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            //implement here
            int sum = 0;
            String name = null;//only one reducer，这里一定能够看到name
            String value = null;//如果name最终是null的话，说明用户列表中没有这个人，那么不输出它的结果
            for (Text text : values) {
                value = text.toString();
                if (value.matches("^[0-9]{1,8}$")) {//为了屏蔽掉那些name全是数字的用户，限制发微博的数目不要超过8位数
                    sum += Integer.parseInt(text.toString());//text may not be '1' -> "2255610963"
                } else {
                    name = value;//otherwise the value is the user's name
                }
            }
            if (name != null) {//发了这些数目微博的这个user存在
                context.write(new Text(name), new IntWritable(sum));//username count
            }
        }
    }

    public static class SortMapper extends Mapper<Object, Text, IntWritable, Text> {

        private IntWritable count = new IntWritable(1);
        private Text name = new Text();

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            //implement here
            String line = value.toString();
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                name.set(tokenizer.nextToken());
                if (tokenizer.hasMoreTokens()){//java.util.NoSuchElementException
                    count.set(Integer.parseInt(tokenizer.nextToken()));
                    context.write(count, name);//count username
                }
            }
        }
    }

    public static class SortReducer extends Reducer<IntWritable, Text, IntWritable, Text> {

        public void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            //implement here
            for (Text text : values) {
                context.write(key, text);
            }
        }
    }

    private static class IntDecreasingComparator extends IntWritable.Comparator {
        //注意默认的comparator是Increasing的，所以你完全没有必要明白下面两个method的意义
        //返回值为-1,0,1中的一个
        public int compare(WritableComparable a, WritableComparable b) {
            //implement here
            return -super.compare(a, b);
        }

        public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
            //implement here
            return -super.compare(b1, s1, l1, b2, s2, l2);
        }
    }


    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = new Job(conf, "UserCountJob");
        job.setJarByClass(UserCount.class);//TODO why?
        //job.setNumReduceTasks(1);//

        job.setMapperClass(CountMapper.class);
        //job.setCombinerClass(CountReducer.class);//do not do this
        job.setReducerClass(CountReducer.class);

        job.setOutputKeyClass(Text.class);//使用setMapOutputKeyClass会报错
        job.setOutputValueClass(Text.class);

        Path tempDir = new Path("counttemp");
        FileInputFormat.addInputPath(job, new Path("/input-user"));//
        FileOutputFormat.setOutputPath(job, tempDir);

        //在这里你可以加入你的另一个job来进行排序
        //可以使用“job.waitForCompletion(true)“，该方法会开始job并等待job结束，返回值是true代表job成功，否则代表job失败
        //在SortJob中使用“sortJob.setSortComparatorClass(IntDecreasingComparator.class)”来把你的输出排序方式设置为你自己写的IntDecreasingComparator

        Path sorttempDir = new Path("sorttemp");
        if (job.waitForCompletion(true)) {
            Job sortJob = new Job(conf, "UserCountSortJob");
            sortJob.setJarByClass(UserCount.class);
            sortJob.setMapperClass(SortMapper.class);
            sortJob.setReducerClass(SortReducer.class);
            sortJob.setSortComparatorClass(IntDecreasingComparator.class);

            FileInputFormat.addInputPath(sortJob, tempDir);
            FileOutputFormat.setOutputPath(sortJob, sorttempDir);

            sortJob.setOutputKeyClass(IntWritable.class);
            sortJob.setOutputValueClass(Text.class);
            System.exit(sortJob.waitForCompletion(true) ? 0 : 1);
        }

        //System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
