import org.apache.hadoop.io.Text;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * hujiawei - 14/11/6.
 */
public class UserName {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/user_simple_all.json"));
        JSONObject js = null;
        String line = null;
        String name = null;
        char[] chars;
        boolean flag;
        while ((line = reader.readLine()) != null) {
            js = new JSONObject(line.toString());
            if (js.has("name")) {
                flag = false;
                name = js.getString("name");
                //chars = name.toCharArray();
                //for (int i = 0; i < chars.length; i++) {
                //    if (Character.isLetter(chars[i])) {
                //        flag = false;
                //        break;
                //    }
                //}
                if (name.equalsIgnoreCase("")) {
                    flag = true;
                    break;
                }
                if (flag) {
                    System.out.println("name is " + name);//name is 18--18
                    break;
                }
            }
        }
        reader.close();
    }


}
