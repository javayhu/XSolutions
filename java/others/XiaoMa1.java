import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * hujiawei - 15/3/25.
 */
public class XiaoMa1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next().trim();//0000007f000100000000660002ab02

        List<Message> messageList = new ArrayList<Message>();
        int start = 0, size = str.length(), len;
        String tag, length, value;
        while (start < size) {
            if (msgerr(size - start, 8)) return;
            tag = str.substring(start, start + 8);
            start += 8;

            if (msgerr(size - start, 4)) return;
            length = str.substring(start, start + 4);
            start += 4;

            len = Integer.parseInt(length, 16);
            if (msgerr(size - start, len * 2)) return;
            value = str.substring(start, start + len * 2);
            start += len * 2;

            messageList.add(new Message(tag, length, value));
        }

        Collections.sort(messageList);

        StringBuilder builder = new StringBuilder();
        for (Message message : messageList) {
            builder.append(message.tag).append(message.length).append(message.value);
        }
        System.out.println(builder.toString());
    }

    private static boolean msgerr(int size, int limit) {
        if (size < limit) {//长度不够了
            System.out.println("msgerr");
            return true;
        }
        return false;
    }

    static class Message implements Comparable<Message> {
        String tag;
        String length;
        String value;

        public Message(String tag, String length, String value) {
            this.tag = tag;
            this.length = length;
            this.value = value;
        }

        @Override
        public int compareTo(Message o) {
            return this.tag.compareTo(o.tag);
        }
    }

}
