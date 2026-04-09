package ex04.Task5;

import ex02.Task3.View;
import ex03.Task4.ViewableTable;

public class Application {
    private static Application instance = new Application();
    private Application() {}

    public static Application getInstance() {
        return instance;
    }

    /** Об’єкт для відображення результатів */
    private View view = new ViewableTable().getView();

    /** Меню – макрокоманда */
    private Menu menu = new Menu();

    /** Запуск діалогового інтерфейсу */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.add(new UndoConsoleCommand(menu.getHistory())); // нова команда undo
        menu.execute();
    }
}
