package ex02.Task3;

import java.util.ArrayList;
import ex01.Task2.Item2d;

public class Main {
    protected View view;

    public Main(View view) {
        this.view = view;
    }

    public void menu() {
        view.viewInit();
        view.viewShow();
    }

    public static void main(String[] args) {
        ViewResult view1 = new ViewResult(5);
        ViewResult view2 = new ViewResult();

        System.out.println("=== TEST CALCULATION ===");

        view1.viewInit();
        view1.viewShow();

        ArrayList<Item2d> list = view1.getItems();
        if (list.size() > 0) {
            System.out.println("OK: Data generated\n");
        } else {
            System.out.println("ERROR: No data\n");
        }

        System.out.println("=== TEST SERIALIZATION ===");

        try {
            view1.viewSave();
            System.out.println("Saved successfully");
        } catch (Exception e) {
            System.out.println("Save error: " + e);
        }

        try {
            view2.viewRestore();
            System.out.println("Restored successfully");
            view2.viewShow();
        } catch (Exception e) {
            System.out.println("Restore error: " + e);
        }

        if (view1.getItems().size() == view2.getItems().size()) {
            System.out.println("OK: Sizes match");
        } else {
            System.out.println("ERROR: Sizes differ");
        }
    }
}