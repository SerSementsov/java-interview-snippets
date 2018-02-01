package algo.tasks;

import java.util.ArrayList;
import java.util.List;

public class PowersOfTwo {
    public static void main(String[] args) {
        System.out.println(findPowersOfTwoThatMake(100));
        System.out.println(findPowersOfTwoThatMake(50));
        System.out.println(findPowersOfTwoThatMake(500000000));
        System.out.println(findPowersOfTwoThatMake(500000001));
        System.out.println(findPowersOfTwoThatMake(500000005));

//        System.out.println(findPowersOfTwoThatMake(-1));
    }

    private static List<Integer> findPowersOfTwoThatMake(int sum) {
        requirePositiveArg(sum);
        List<Integer> terms = new ArrayList<>();
        while (sum > 0) {
            int maxPower = findMaxPower(sum);
            terms.add(maxPower);

            sum -= Math.pow(2, maxPower);
        }
        return terms;
    }

    private static int findMaxPower(int sum) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int temp = (int) Math.pow(2, i);

            if (temp == sum) {
                return i;
            } else if (temp > sum) {
                return i - 1;
            }
        }

        throw new IllegalArgumentException("can't find powers of 2 for " + sum);
    }

    private static void requirePositiveArg(int sum) {
        if (sum < 1) {
            throw new IllegalArgumentException("argument must be positive");
        }
    }
}
