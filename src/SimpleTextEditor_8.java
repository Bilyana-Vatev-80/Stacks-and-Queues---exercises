import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        stack.push(sb.toString());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            switch (command[0]) {
                case "1":
                    sb.append(command[1]);
                    stack.push(sb.toString());
                    break;
                case "2":
                    int count = Integer.parseInt(command[1]);
                    sb.delete(sb.length() - count, count);
                    stack.push(sb.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(command[1]);
                    System.out.println();
                    break;
                case "4":
                    stack.pop();
                    sb = new StringBuilder();
                    sb.append(stack.pop());
                    break;
            }

        }
    }
}
