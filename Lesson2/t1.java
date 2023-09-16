import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        float number = readFloatFromUser();
        System.out.println("Вы ввели число: " + number);
    }

    public static float readFloatFromUser() {
        Scanner scanner = new Scanner(System.in);
        float result = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите дробное число (типа float): ");
            if (scanner.hasNextFloat()) {
                result = scanner.nextFloat();
                validInput = true;
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите дробное число.");
                scanner.next();
            }
        }

        return result;
    }
}
