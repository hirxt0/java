package practice1;


import java.util.Scanner;
import java.util.function.DoublePredicate;

public class Task4 {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.next(); 

            switch (choice) {
                case "1" -> running = calculate(scanner);

                case "0", "выход" -> running = false;
                default -> System.out.println(
                        "Нет такого пункта. Попробуйте снова."
                );
            }
        } 
    }

    public static double readDouble(Scanner scanner, String prompt, DoublePredicate check) {
        while (true) {
            System.out.println(prompt);
            if (!scanner.hasNextDouble()) {
                System.out.println("некорректное значние, попробуйте снова");
                scanner.next();
                continue;
            }
            double m = scanner.nextDouble();
            if (check.test(m)) {
                return m;
            } else {
                System.out.println("значение не подходит");
            }
        }
    }

    static void printMenu() {
        System.out.println("1. Выполнить расчёт");
        System.out.println("0. Выход");
        System.out.print("Выберите пункт: ");
    }

    static boolean calculate(Scanner scanner) {
        Double m = readDouble(
                scanner,
                "Введите массу тела в кг (> 0)",
                x -> x > 0
        );

        Double v = readDouble(
                scanner,
                "Введите скорость тела в м/с (>= 0)",
                x -> x >= 0
        );

        double energy = kineticEnergy(m, v);
        System.out.println("Кинетическая энергия = " + energy + " Дж");
        return true;
    }

    static double kineticEnergy(double m, double v) {
        return m * v * v / 2;
    }

}