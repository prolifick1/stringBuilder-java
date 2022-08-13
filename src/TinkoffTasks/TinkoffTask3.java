package TinkoffTasks;

import java.util.Arrays;
import java.util.Scanner;

public class TinkoffTask3 {
    static Scanner scanner = new Scanner(System.in);
    static int numOfDays = scanner.nextInt();
    static int[] perDayIncome = new int[numOfDays];

    static {
        for (int i = 0; i < numOfDays; i++) {
            int sign = i % 2 == 0 ? 1 : -1;
            perDayIncome[i] = sign * scanner.nextInt();
        }
    }

//    public static void main(String[] args) {
//        System.out.println(maximizeIncome(perDayIncome));
//    }

    public static int maximizeIncome(int[] perDayIncome) {
        int notChanged = Arrays.stream(perDayIncome).sum();
        int totalMin = Arrays.stream(perDayIncome).min().orElse(0);

        if (totalMin >= 0) {
            return notChanged;
        }

        int minNonNegative = perDayIncome[0];
        for (int i = 0; i < perDayIncome.length; i += 2) {
            minNonNegative = Math.min(minNonNegative, perDayIncome[i]);
        }

        int changed = notChanged - totalMin - minNonNegative;
        return changed + Math.abs(totalMin) - minNonNegative;
    }
}
