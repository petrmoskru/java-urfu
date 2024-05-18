package lr6;

public class Example3 {
    private static final Object lock = new Object();
    private static int number = 0;

    public static void main(String[] args) {
        Runnable evenTask = () -> {
            synchronized (lock) {
                while (number < 10) {
                    while (number % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.err.println("Поток был прерван");
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;
                    lock.notifyAll();
                }
            }
        };

        Runnable oddTask = () -> {
            synchronized (lock) {
                while (number < 10) {
                    while (number % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.err.println("Поток был прерван");
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;
                    lock.notifyAll();
                }
            }
        };

        Thread evenThread = new Thread(evenTask, "ЧетныйПоток");
        Thread oddThread = new Thread(oddTask, "НечетныйПоток");

        evenThread.start();
        oddThread.start();
    }
}
