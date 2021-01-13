import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(firstLine[0]);
        int s = Integer.parseInt(firstLine[1]);
        int z = Integer.parseInt(firstLine[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] numbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(numbers[i]));
        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            if (queue.contains(z)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}
