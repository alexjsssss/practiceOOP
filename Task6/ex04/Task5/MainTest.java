package ex04.Task5;

import ex01.Task2.Item2d;
import ex02.Task3.ViewResult;

public class MainTest {
    public static void main(String[] args) {
        // Тест ChangeItemCommand
        ChangeItemCommand cmd = new ChangeItemCommand();
        Item2d item = new Item2d();
        item.setXY(10, 5);
        cmd.setItem(item);
        cmd.setOffset(2.0);
        cmd.execute();
        System.out.println("After change: x=" + item.getX() + ", y=" + item.getY());

        // Тест ChangeConsoleCommand
        ChangeConsoleCommand ccmd = new ChangeConsoleCommand(new ViewResult());
        ccmd.getView().viewInit();
        ccmd.execute();
        System.out.println("Key=" + ccmd.getKey() + ", toString=" + ccmd.toString());
    }
}
