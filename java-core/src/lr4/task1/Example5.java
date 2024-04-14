package lr4.task1;

public class Example5 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        } catch (RuntimeException e) {  // Обработка исключения
            System.out.println("3");
        }
        System.out.println("2");
    }
}
