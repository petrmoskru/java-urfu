package lr6;

import java.util.concurrent.atomic.AtomicInteger;

public class Example5 {
    private static final AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);

    public static int findMax(int[] array) {
        int numThreads = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numThreads];
        int size = (int) Math.ceil(array.length / (double) numThreads);

        for (int i = 0; i < numThreads; i++) {
            final int start = i * size;
            final int end = (i == numThreads - 1) ? array.length : (i + 1) * size;
            threads[i] = new Thread(() -> {
                int localMax = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    if (array[j] > localMax) {
                        localMax = array[j];
                    }
                }
                synchronized (max) {
                    if (localMax > max.get()) {
                        max.set(localMax);
                    }
                }
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
        return max.get();
    }

    public static void main(String[] args) {
        int[] array = {5, 10, 12, 5000, 50, 321, 591, 1, 2, 3, 5, 10, 12, 58, 50, 321, 591, 1, 2, 412, 4124124, 412};
        int max = findMax(array);
        System.out.println("Максимальный элемент в массиве: " + max);
    }
}
