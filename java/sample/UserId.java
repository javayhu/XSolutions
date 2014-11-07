import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * hujiawei - 14/11/7.
 */
public class UserId {

    public static void main(String[] args) throws Exception {
        //userNotInList();

        maxWeiboCount();


    }

    private static void maxWeiboCount() throws Exception {
        int count;
        String name = null;
        String line = null;
        StringTokenizer tokenizer;
        int max = Integer.MIN_VALUE;
        BufferedReader creader = new BufferedReader(new FileReader("src/main/resources/count.txt"));
        while ((line = creader.readLine()) != null) {
            tokenizer = new StringTokenizer(line);
            name = tokenizer.nextToken();
            if (tokenizer.hasMoreTokens()) {
                if ((count = Integer.parseInt(tokenizer.nextToken())) > max) {
                    max = count;
                }
            }
        }
        System.out.println(max);//3397
        creader.close();
    }

    private static void maxWeiboCounttemp() throws Exception {
        int count;
        String name = null;
        String line = null;
        StringTokenizer tokenizer;
        int max = Integer.MIN_VALUE;
        BufferedReader creader = new BufferedReader(new FileReader("src/main/resources/counttemp.txt"));
        while ((line = creader.readLine()) != null) {
            tokenizer = new StringTokenizer(line);
            name = tokenizer.nextToken();
            if (tokenizer.hasMoreTokens()) {
                if ((count = Integer.parseInt(tokenizer.nextToken())) > max) {
                    max = count;
                }
            }
        }
        System.out.println(max);//3397
        creader.close();
    }

    private static void userNotInList() throws Exception {
        //{"$numberLong":"2682084083"}	1 (2)
        //1635958394	1 (2)
        Map<String, Integer> usernames = new HashMap<String, Integer>();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/names.txt"));
        String line = null;
        StringTokenizer tokenizer;
        //while ((line = reader.readLine()) != null) {
        //    tokenizer = new StringTokenizer(line);
        //    usernames.put(tokenizer.nextToken(), Integer.parseInt(tokenizer.nextToken()));
        //}
        //reader.close();

        //System.out.println(usernames.containsKey("2255610963"));//false

        String name;
        BufferedReader creader = new BufferedReader(new FileReader("src/main/resources/count.txt"));
        while ((line = creader.readLine()) != null) {
            tokenizer = new StringTokenizer(line);
            //usernames.put(tokenizer.nextToken(), Integer.parseInt(tokenizer.nextToken()));
            name = tokenizer.nextToken();
            if (!usernames.containsKey(name)) {
                System.out.println(name);
            }
        }
        creader.close();
    }

}
