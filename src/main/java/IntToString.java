public class IntToString {

    static int numLength(int num) {
        int count = 0;
        while(num != 0) {
            num /= 10;
            count += 1;
        }
        return count;
    }

    static String intToString(int num) {
        var sb = new StringBuilder();
        char[] charArr = new char[numLength(num)];
        for(int i = charArr.length-1; i>=0; i--){
            charArr[i] = (char)(num % 10 + 48);
            num /= 10;
        }
        return new String(charArr);
    }
}
