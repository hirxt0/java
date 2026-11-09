package practice4;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Objects;

public class Task4_2 {
    public static void main(String[] args) {
        Employer[] employees = {
            new Developer("Иванов Иван", 100_000, 2021, "высшее", "Java"),
            new Developer("Смирнова Ольга", 120_000, 2022, "высшее", "Python"),
            new Teacher("Петрова Анна", 60_000, 2019, "педагогическое", "математика"),
            new Teacher("Козлов Максим", 65_000, 2020, "педагогическое", "физика"),
            new Manager("Сидоров Павел", 90_000, 2023, "высшее", 8),
            new Manager("Волкова Мария", 95_000, 2021, "высшее", 12)
        };

        double totalBonus = 0;

        for (Employer employee : employees) {
            System.out.println("сотрудник: " + employee.toString());
            employee.getInfo();

            double bonus = employee.calculateBonus();
            System.out.printf("премия: %.2f руб.%n", bonus);
            System.out.println();

            totalBonus += bonus;
    }

    System.out.printf("общая сумма премий: %.2f руб.%n", totalBonus);

        Employer first = employees[0];
        Employer same = new Developer("Иванов Иван", 100_000, 2021, "высшее", "Java");
        Employer different = new Developer("Иванов Иван", 110_000, 2021, "высшее", "Java");

        System.out.println("первый сотрудник: " + first);
        System.out.println("равен сотруднику с теми же ФИО и зарплатой: " + first.equals(same));
        System.out.println("равен сотруднику с другой зарплатой: " + first.equals(different));
        System.out.println("хэш первого: " + first.hashCode());
        System.out.println("хэш равного ему сотрудника: " + same.hashCode());
    }
}

class Employer{
    private final String name;
    private final int salary;
    private final int yearEmp;
    private final String education;

    Employer(String name, int salary, int yearEmp, String education) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("ФИО должно быть заполнено");
        }
        if (salary <= 0) {
            throw new IllegalArgumentException("Зарплата должна быть больше нуля");
        }
        if (yearEmp <= 0 || yearEmp > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Некорректный год трудоустройства");
        }
        if (education == null || education.isBlank()) {
            throw new IllegalArgumentException("Образование должно быть указано");
        }

        this.name = name;
        this.salary = salary;
        this.yearEmp = yearEmp;
        this.education = education;
    }

    public void getInfo() {
        PrintWriter writer = new PrintWriter(System.out);
        writer.println(name);
        writer.println("зарплата: " + salary);
        writer.println("год трудоустройства: " + yearEmp);
        writer.println("образование: " + education);
        writer.flush();
    }

    public int calculateExperience() {
        int currentYear = LocalDate.now().getYear();
        return currentYear - yearEmp;
    }

    public double calculateBonus() {
        int experience = calculateExperience();
        return salary * (experience / 100.0);
    }

    @Override 
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Employer other)) {
            return false;
        }
        return Objects.equals(salary, other.salary) && Objects.equals(name, other.name);
    }

    @Override 
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}

class Developer extends Employer {
    private final String language;

    Developer(String name, int salary, int yearEmp, String education,
              String language) {
        super(name, salary, yearEmp, education);
        if (language == null || language.isBlank()) {
        throw new IllegalArgumentException("Укажи язык программирования");
    }
        this.language = language;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("язык программирования: " + language);
    }
}

class Teacher extends Employer {
    private final String subject;

    Teacher(String name, int salary, int yearEmp, String education,
            String subject) {
        super(name, salary, yearEmp, education);
        if (subject == null || subject.isBlank()) {
        throw new IllegalArgumentException("Укажи язык программирования");
    }
        this.subject = subject;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("предмет: " + subject);
    }
}

class Manager extends Employer {
    private final int teamSize;

    Manager(String name, int salary, int yearEmp, String education,
            int teamSize) {
        super(name, salary, yearEmp, education);
        if (teamSize <=0) {
        throw new IllegalArgumentException("Укажи язык программирования");
    }
        this.teamSize = teamSize;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("размер команды: " + teamSize);
    }
}