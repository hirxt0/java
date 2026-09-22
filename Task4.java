import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Эта программа считает кинетическую энергию тела: E = m * v^2 / 2");

        System.out.println("Введите массу тела в кг");
        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка");
            return;
        }
        double m = scanner.nextDouble();
        if (m <= 0) {
            System.out.println("Ошибка");
            return;
        }
        System.out.println("Введите скорость тела в м/с");
        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка");
            return;
        }
        double v = scanner.nextDouble();
        if (v < 0) {
            System.out.println("Ошибка");
            return;
        }
        double e = m * v * v / 2;
        System.out.println("Кинетическая энергия = " + e + " Дж");
    }
}