package algo.string;

import java.util.HashMap;
import java.util.Map;

//todo: fix for larger numbers
public class IntegerToWordsDemo {

    private static final Map<Integer, String> NUMBERS_TO_WORDS = new HashMap<Integer, String>() {{
        put(0, "Zero");
        put(1, "One");
        put(2, "Two");
        put(3, "Three");
        put(4, "Four");
        put(5, "Five");
        put(6, "Six");
        put(7, "Seven");
        put(8, "Eight");
        put(9, "Nine");
        put(10, "Ten");
        put(11, "Eleven");
        put(12, "Twelve");
        put(13, "Thirteen");
        put(14, "Fourteen");
        put(15, "Fifteen");
        put(16, "Sixteen");
        put(17, "Seventeen");
        put(18, "Eighteen");
        put(19, "Nineteen");
        put(20, "Twenty");
        put(30, "Thirty");
        put(40, "Forty");
        put(50, "Fifty");
        put(60, "Sixty");
        put(70, "Seventy");
        put(80, "Eighty");
        put(90, "Ninety");
    }};
    private static final int TEN = 10;
    private static final int HUNDRED = 100;
    private static final int THOUSAND = 1000;


    public static void main(String[] args) {
        System.out.println(getWordsFor(123));
        System.out.println(getWordsFor(2));
        System.out.println(getWordsFor(666));
    }

    private static String getWordsFor(int number) {
        StringBuilder sb = new StringBuilder();

        if (number == 0) {
            return NUMBERS_TO_WORDS.get(0);
        }

        if (number > THOUSAND) {
            int extra = number / THOUSAND;
            sb.append(getWord(extra))
                    .append(" Thousand");
        }

        if (number > 0) {
            sb.append(getWord(number));
        }

        return sb.toString();
    }

    private static String getWord(int number) {
        StringBuilder sb = new StringBuilder();

        if (number >= HUNDRED) {
            int numHundreds = number / HUNDRED;
            sb.append(" ").append(NUMBERS_TO_WORDS.get(numHundreds))
                    .append(" Hundred");
            number = number % HUNDRED;
        }

        if (number > 0) {
            if (number > 20) {
                int numTens = number / TEN;
                sb.append(" ")
                        .append(NUMBERS_TO_WORDS.get(numTens * TEN));

                int numOnes = number % TEN;
                if (numOnes > 0) {
                    sb.append(" ")
                            .append(NUMBERS_TO_WORDS.get(numOnes));
                }
            } else {
                sb.append(" ")
                        .append(NUMBERS_TO_WORDS.get(number));
            }
        }

        return sb.toString();
    }
}
