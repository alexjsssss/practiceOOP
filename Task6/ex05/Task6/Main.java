package ex05.Task6;

import ex02.Task3.View;
import ex02.Task3.ViewableResult;
import ex04.Task5.ChangeConsoleCommand;
import ex04.Task5.GenerateConsoleCommand;
import ex04.Task5.Menu;
import ex04.Task5.ViewConsoleCommand;

/** Запуск програми; демонстрація паралельної обробки та Worker Thread */
public class Main {
    private View view = new ViewableResult().getView();

    /** Меню – макрокоманда */
    private Menu menu = new Menu();

    /** Формування меню та запуск діалогового інтерфейсу */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view));
        menu.execute();
    }

    /** Точка входу */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}