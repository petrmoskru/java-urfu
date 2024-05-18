package lr6;

import java.time.LocalTime;

public class Example1 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Поток был прерван, не удалось завершить операцию");
                }
            }
        };

        Thread t1 = new Thread(task, "Поток-1");
        Thread t2 = new Thread(task, "Поток-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
