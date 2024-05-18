package lr7.task7;

import java.io.*;

public class Example1 {
    public static void main(String[] args) {
        Cars car = new Cars("Audi", 10000, true);
        String filePath = "src/lr7/task7/car.json";

        try {
            writeObjectToFile(car, filePath);
            System.out.println("Объект записан в car.json");
        } catch (IOException e) {
            System.out.println("Ошибка при записи объекта: " + e.getMessage());
        }

        Cars restoredCar = null;
        try {
            restoredCar = (Cars) readObjectFromFile(filePath);
            System.out.println("Объект успешно считан!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при чтении объекта: " + e.getMessage());
        }
        System.out.println("Объект после считывания: ");
        System.out.println(restoredCar);
    }

    private static void writeObjectToFile(Object obj, String filePath) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(obj);
        }
    }

    private static Object readObjectFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return in.readObject();
        }
    }
}
