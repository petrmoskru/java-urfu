package lr6;

import java.util.concurrent.atomic.AtomicInteger;

public class Example6 {
    private static final AtomicInteger sum = new AtomicInteger(0);

    public static int sum(int[] array) {
        int numThreads = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numThreads];
        int size = array.length / numThreads;

        for (int i = 0; i < numThreads; i++) {
            final int start = i * size;
            final int end = (i == numThreads - 1) ? array.length : (i + 1) * size;
            threads[i] = new Thread(() -> {
                int localSum = 0;
                for (int j = start; j < end; j++) {
                    localSum += array[j];
                }
                sum.addAndGet(localSum);
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Поток был прерван");
            }
        }
        return sum.get();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = sum(array);
        System.out.println("Сумма элементов в массиве: " + sum);
    }
}
