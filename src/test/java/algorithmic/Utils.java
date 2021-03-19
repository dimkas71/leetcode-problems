package algorithmic;

public class Utils {
    public static String add(String s1, String s2) {

        String longest = new StringBuilder(s1).reverse().toString();
        String shortest = new StringBuilder(s2).reverse().toString();

        if (s1.length() < s2.length()) {
            longest = new StringBuilder(s2).reverse().toString();
            shortest = new StringBuilder(s1).reverse().toString();
        }

        int[] collector = new int[longest.length() + 1];

        int accumulator = 0;

        for (int i = 0; i < longest.length(); i++) {

            int firstDigit = Integer.parseInt(String.valueOf(longest.charAt(i)));
            int secondDigit = 0;

            if (i < shortest.length()) {
                secondDigit = Integer.parseInt(String.valueOf(shortest.charAt(i)));
            }

            int result = firstDigit + secondDigit + accumulator;

            if (result > 9) {
                accumulator = 1;
                result = result - 10;
            } else {
                accumulator = 0;
            }

            collector[i] = result;
        }

        int arraySize = longest.length();

        if (accumulator > 0) {
            collector[longest.length()] = accumulator;
            arraySize += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = arraySize - 1; i >= 0; i--) {
            sb.append(collector[i]);
        }

        return sb.toString();
    }

}
