package lr2;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст для шифрования:");
        String text = scanner.nextLine();
        System.out.println("Введите ключ:");
        int key = scanner.nextInt();

        String encryptedText = encrypt(text, key);
        System.out.println("Текст после преобразования: " + encryptedText);

        while (true) {
            System.out.println("Выполнить обратное преобразование? (y/n)");
            scanner.nextLine();
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("y")) {
                String decryptedText = decrypt(encryptedText, key);
                System.out.println("Текст после обратного преобразования: " + decryptedText);
                break;
            } else if (response.equalsIgnoreCase("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
            }
        }

        scanner.close();
    }

    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char shifted = (char) (((ch - 'a' + key) % 26) + 'a');
                result.append(shifted);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char shifted = (char) (((ch - 'a' - key + 26) % 26) + 'a');
                result.append(shifted);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
