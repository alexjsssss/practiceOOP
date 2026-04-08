package ex02.Task3;

import java.util.ArrayList;
public class MainTest {
    public static void main(String[] args) {

        ViewResult view1 = new ViewResult(5);
        ViewResult view2 = new ViewResult();

        System.out.println("=== TEST CALCULATION ===");

        // Генерація даних
        view1.viewInit();
        view1.viewShow();

        // Перевірка що дані існують
        ArrayList<Item2d> list = view1.getItems();
        if (list.size() > 0) {
            System.out.println("OK: Data generated\n");
        } else {
            System.out.println("ERROR: No data\n");
        }

        System.out.println("=== TEST SERIALIZATION ===");

        // Збереження
        try {
            view1.viewSave();
            System.out.println("Saved successfully");
        } catch (Exception e) {
            System.out.println("Save error: " + e);
        }

        // Відновлення
        try {
            view2.viewRestore();
            System.out.println("Restored successfully");
            view2.viewShow();
        } catch (Exception e) {
            System.out.println("Restore error: " + e);
        }

        // Перевірка кількості елементів
        if (view1.getItems().size() == view2.getItems().size()) {
            System.out.println("OK: Sizes match");
        } else {
            System.out.println("ERROR: Sizes differ");
        }
    }
}