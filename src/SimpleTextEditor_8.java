import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            switch (tokens[0]) {
                case "1":
                    stack.push(sb.toString());
                    sb.append(tokens[1]);

                    break;
                case "2":
                    stack.push(sb.toString());
                    int count = Integer.parseInt(tokens[1]);
                    int start = sb.length() - count;
                    sb.delete(start, start + count);
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(sb.charAt(index - 1));
                    break;
                case "4":
                    //undo operation
                    if (!stack.isEmpty()) {
                        sb = new StringBuilder(stack.pop());
                    }
                    break;
            }
        }
    }
}
