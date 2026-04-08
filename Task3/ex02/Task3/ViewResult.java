package ex02.Task3;

import java.io.*;
import java.util.ArrayList;

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

    private double calcEnergy(double m, double h) {
        return m * 9.81 * h;
    }

    private int maxOnes(long val) {
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
            double e = calcEnergy(m, h);
            long eInt = Math.round(e);
            item.setData(m, h, e, maxOnes(eInt));
        }
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
