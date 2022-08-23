package hackerrank.weekprep1;

import java.io.*;

/**
 * Given a time in -hour AM/PM format, convert it to military (24-hour) time.

Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
 */
public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = timeConversion(s);

        System.out.println(result);

        bufferedReader.close();

    }

    public static String timeConversion(String s) {
        var amOrPm = s.substring(s.length() - 2);
        var hours = s.substring(0, 2);
        var minutes = s.substring(3, 5);
        var seconds = s.substring(6, 8);
        if (amOrPm.equals("PM")) {
            var h = Integer.parseInt(hours);
            if(h != 12)
            hours = String.valueOf(h + 12);
    
        } else {
            var h = Integer.parseInt(hours);
            if (h == 12) {
                hours = "00";
            }
        }
        return String.format("%s:%s:%s", hours, minutes, seconds);
    }
}
