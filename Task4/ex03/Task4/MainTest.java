package ex03.Task4;

import ex01.Task2.Item2d;

/**
 * Просте тестування класів ViewTable без JUnit
 */
public class MainTest {
    public static void main(String[] args) {
        testCalc();
        testRestore();
    }

    private static void testCalc() {
        System.out.println("=== testCalc ===");
        ViewTable tbl = new ViewTable(10, 5);

        if (tbl.getWidth() == 10) {
            System.out.println("Width OK");
        } else {
            System.out.println("Width FAIL");
        }

        if (tbl.getItems().size() == 5) {
            System.out.println("Items size OK");
        } else {
            System.out.println("Items size FAIL");
        }

        tbl.init(40, 90.0);
        Item2d item = new Item2d();
        item.setM(0.0);
        item.setH(0.0);
        item.setE(0);
        item.setMax1(0);

        if (tbl.getItems().get(0).equals(item)) {
            System.out.println("First item OK");
        } else {
            System.out.println("First item FAIL");
        }
    }

    private static void testRestore() {
        System.out.println("=== testRestore ===");
        ViewTable tbl1 = new ViewTable(10, 1000);
        ViewTable tbl2 = new ViewTable();

        tbl1.init(30, Math.random() * 100.0);
        try {
            tbl1.viewSave();
            tbl2.viewRestore();
        } catch (Exception e) {
            System.out.println("Serialization FAIL: " + e.getMessage());
            return;
        }

        if (tbl1.getItems().size() == tbl2.getItems().size()) {
            System.out.println("Size restore OK");
        } else {
            System.out.println("Size restore FAIL");
        }

        if (tbl1.getItems().containsAll(tbl2.getItems())) {
            System.out.println("Content restore OK");
        } else {
            System.out.println("Content restore FAIL");
        }
    }
}