package lr6;

public class Example4 {
    private static int count = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Runnable task = () -> {
            synchronized (lock) {
                System.out.println("Поток: " + count);
                count++;
            }
        };

        for (int i = 1; i <= 10; i++) {
            new Thread(task).start();
        }
    }
}
