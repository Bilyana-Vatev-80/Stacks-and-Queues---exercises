import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(";");
        String[] robots = new String[input.length];
        int[] processTime = new int[input.length];
        int[] workTime = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] data = input[i].split("-");
            String name = data[0];
            int time = Integer.parseInt(data[1]);
            robots[i] = name;
            processTime[i] = time;
        }
        String startingTime = scanner.nextLine();

        ArrayDeque<String> products = new ArrayDeque<>();

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            products.offer(line);

            line = scanner.nextLine();
        }
        String[] timeData = startingTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int beginTime = hours * 3600 + minutes * 60 + seconds;

        while (!products.isEmpty()) {
            beginTime++;

            String product = products.poll();

            boolean isWorking = false;
            for (int i = 0; i < robots.length; i++) {
                if (workTime[i] == 0 && !isWorking) {
                    workTime[i] = processTime[i];
                    isWorking = true;
                    printRobotData(robots[i], product, beginTime);
                }
                if (workTime[i] > 0) {
                    workTime[i]--;
                }
            }
            if (!isWorking) {
                products.offer(product);
            }
        }
    }

    private static void printRobotData(String robot, String product, int beginTime) {
        long s = beginTime % 60;
        long m = (beginTime / 60) % 60;
        long h = (beginTime / (60 * 60)) % 24;
        System.out.println(robot + " - " + product + String.format(" [%02d:%02d:%02d]", h, m, s));
    }
}
