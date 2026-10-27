package practice1;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("x:");
        double x = scanner.nextDouble();
        double y = 4 * Math.pow(x, 3) + 23 * x - 55;

        System.out.println("y = " + y);
    }
}