import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(firstLine[0]);
        int s = Integer.parseInt(firstLine[1]);
        int x = Integer.parseInt(firstLine[2]);

        ArrayDeque<Integer> stackNumber = new ArrayDeque<>();

        String[] numbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < n; i++) {
            stackNumber.push(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < s; i++) {
            stackNumber.pop();
        }
        if (stackNumber.isEmpty()) {
            System.out.println("0");
        } else {
            if (stackNumber.contains(x)) {
                System.out.println("true");
            } else {
                //min element
                //System.out.println(stackNumber.stream().mapToInt(e -> e).min().getAsInt());
                //System.out.println(Collections.min(stackNumber));
                System.out.println(getMinElement(stackNumber));
            }
        }

    }

    private static int getMinElement(ArrayDeque<Integer> stackNumber) {
        int min = Integer.MAX_VALUE;
        for (Integer integer : stackNumber) {
            if (integer < min) {
                min = integer;
            }
        }
        return min;
    }
}
