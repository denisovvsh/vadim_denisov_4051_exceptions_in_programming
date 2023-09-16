package exceptions_in_programming.Lesson3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные в произвольном порядке, разделенные пробелом:");
        String input = scanner.nextLine().trim();
        scanner.close();

        String[] data = input.split("\\s+");
        if (data.length != 6) {
            System.out.println("Ошибка: Неверное количество данных.");
            return;
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDate = data[3];
        String phoneNumber = data[4];
        String gender = data[5];

        try {
            validateData(lastName, firstName, middleName, birthDate, phoneNumber, gender);
            saveUserDataToFile(lastName, firstName, middleName, birthDate, phoneNumber, gender);
            System.out.println("Данные успешно записаны в файл.");
        } catch (UserDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void validateData(String lastName, String firstName, String middleName,
                                     String birthDate, String phoneNumber, String gender)
            throws UserDataException {
        // Проверка формата даты рождения
        Pattern datePattern = Pattern.compile("\\d{2}.\\d{2}.\\d{4}");
        Matcher dateMatcher = datePattern.matcher(birthDate);
        if (!dateMatcher.matches()) {
            throw new UserDataException("Неверный формат даты рождения.");
        }

        // Проверка формата номера телефона
        try {
            Long.parseLong(phoneNumber);
        } catch (NumberFormatException e) {
            throw new UserDataException("Номер телефона должен быть целым числом.");
        }

        // Проверка пола
        if (!gender.equals("m") && !gender.equals("f")) {
            throw new UserDataException("Неверный формат пола.");
        }
    }

    private static void saveUserDataToFile(String lastName, String firstName, String middleName,
                                           String birthDate, String phoneNumber, String gender)
            throws IOException {
        String fileName = lastName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(lastName + firstName + middleName + " " + birthDate + " " + phoneNumber + gender);
            writer.newLine();
        }
    }
}

class UserDataException extends Exception {
    public UserDataException(String message) {
        super(message);
    }
}
