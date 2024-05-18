package lr6;

public class Example2 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Поток был прерван, не удалось завершить операцию");
                    return;
                }
            }
        };

        Thread t = new Thread(task);
        t.start();
        t.join();
    }
}
