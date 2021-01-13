import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "1":
                    stackNumbers.push(Integer.parseInt(command[1]));
                    break;
                case "2":
                    stackNumbers.pop();
                    break;
                case "3":
                    //System.out.println(getMaxNumber(stackNumbers));
                    System.out.println(stackNumbers.stream().mapToInt(e -> e).max().getAsInt());
                    // System.out.println(Collections.max(stackNumbers));
                    break;
            }
        }
    }

    private static int getMaxNumber(ArrayDeque<Integer> stackNumbers) {
        int max = Integer.MIN_VALUE;
        for (Integer number : stackNumbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}
