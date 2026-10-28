package practice2;
import java.util.Scanner;


public class Task{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double answer1 = task2_1(n);
        long answer2 = task2_2(n);
        boolean answer3 = task2_3(n);

        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        printMean(a, b);

        scanner.close();
    }
    public static double task2_1(int n) {
        double answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += (double) 1 / i;
        }
        return answer;
    }
    public static long task2_2(int n) {
        long answer = 1;
        for (int i = 1; i <= n; i++) {
            answer *= i;
        }
        return answer;
    }
    public static boolean task2_3(int n) {
        while (n > 0) {
            int curr_digit = n % 10;
            if (curr_digit % 2 != 0) {
                return true;
            }
            n -= curr_digit;
            n = n / 10;
        }
        return false;
    }
    public static void printMean(int a, int b) {
        double result1 = (double) (a + b) / 2;
        long ab = (long) a*b;
        double result2 = Math.sqrt(ab);
        System.out.println(result1 + " " + result2);
    }
}
