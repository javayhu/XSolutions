import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {

    public static void main(String[] args) {
        //Pattern pattern = Pattern.compile("^[aaba]{2,}$");
        //Matcher matcher = pattern.matcher("aabaabaa");
        //System.out.println(matcher.matches());

        System.out.println("aabaaaba".startsWith("aaba", 4));

        //System.out.println(matcher.groupCount());
        //while (matcher.find()) {
        //    System.out.println(matcher.group() + " " + matcher.start() + " " + matcher.end());
        //}
        //boolean found = false;
        //while (matcher.find()) {
        //    System.out.println("I found the text" + matcher.group() + " starting at " +
        //            "index " + matcher.start() + " and ending at index " + matcher.end() + "\n");
        //    found = true;
        //}
        //if (!found) {
        //    System.out.println("No match found.%n");
        //}
    }
}