import java.util.Scanner;

public class t4 {
    public static void main(String[] args) {
        try {
            String input = getInput();
            if (input.isEmpty()) {
                throw new Exception("Пустые строки вводить нельзя");
            }
            System.out.println("Вы ввели: " + input);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        return scanner.nextLine();
    }
}
