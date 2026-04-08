package ex02.Task3;

import java.io.*;
import java.util.ArrayList;
import ex01.Task2.Item2d;

public class ViewResult implements View {
    private static final String FNAME = "items.bin";
    private static final int DEFAULT_NUM = 5;

    private ArrayList<Item2d> items = new ArrayList<>();

    public ViewResult() {
        this(DEFAULT_NUM);
    }

    public ViewResult(int n) {
        for (int i = 0; i < n; i++) {
            items.add(new Item2d());
        }
    }

    public ArrayList<Item2d> getItems() { return items; }

    private int calcEnergy(double m, double h) {
        return (int)(m * 9.81 * h);
    }

    private int maxOnes(int val) {
        int max = 0, cur = 0;
        while (val > 0) {
            if ((val & 1) == 1) {
                cur++;
                if (cur > max) max = cur;
            } else cur = 0;
            val >>= 1;
        }
        return max;
    }

    public void init() {
        for (Item2d item : items) {
            double m = Math.random() * 100;
            double h = Math.random() * 50;
            int e = calcEnergy(m, h);
            item.setM(m);
            item.setH(h);
            item.setE(e);
            item.setMax1(maxOnes(e));
        }
    }

    // Доданий метод init(double stepX)
    public void init(double stepX) {
        viewInit();
    }

    @Override
    public void viewInit() { init(); }

    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items);
        os.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<Item2d>) is.readObject();
        is.close();
    }

    @Override
    public void viewHeader() { System.out.println("\nResults:"); }

    @Override
    public void viewBody() {
        for (Item2d item : items) {
            System.out.println(item);
        }
    }

    @Override
    public void viewFooter() { System.out.println("End.\n"); }

    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}
