package ex05.Task6;

import java.util.concurrent.TimeUnit;
import ex02.Task3.ViewResult;

public class MainTest {
    public static void main(String[] args) {
        final int N = 10; // кількість елементів для тесту
        ViewResult view = new ViewResult(N);
        view.viewInit();

        // створюємо команди
        MaxCommand max = new MaxCommand(view);
        AvgCommand avg = new AvgCommand(view);
        MinMaxCommand minmax = new MinMaxCommand(view);

        // тестуємо MaxCommand
        System.out.println("=== Тест MaxCommand ===");
        max.execute();
        System.out.println("Max result index: " + max.getResult());

        // тестуємо AvgCommand
        System.out.println("\n=== Тест AvgCommand ===");
        avg.execute();
        System.out.println("Average result: " + avg.getResult());

        // тестуємо MinMaxCommand
        System.out.println("\n=== Тест MinMaxCommand ===");
        minmax.execute();
        System.out.println("Min index: " + minmax.getResultMin() +
                           ", Max index: " + minmax.getResultMax());

        // тестуємо CommandQueue
        System.out.println("\n=== Тест CommandQueue ===");
        CommandQueue queue = new CommandQueue();
        queue.put(new MaxCommand(view));
        queue.put(new AvgCommand(view));
        queue.put(new MinMaxCommand(view));

        try {
            TimeUnit.SECONDS.sleep(5);
            queue.shutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        System.out.println("\n=== Тестування завершено ===");
    }
}
