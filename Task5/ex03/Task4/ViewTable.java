package ex03.Task4;

import ex01.Task2.Item2d;
import ex02.Task3.ViewResult;

/**
 * ConcreteProduct (Factory Method)
 * Відображення результатів у вигляді таблиці
 */
public class ViewTable extends ViewResult {
    private static final int DEFAULT_WIDTH = 12;
    private int width;

    public ViewTable() {
        width = DEFAULT_WIDTH;
    }

    public ViewTable(int width) {
        this.width = width;
    }

    public ViewTable(int width, int n) {
        super(n);
        this.width = width;
    }

    // Overloading
    public final void init(int width) {
        this.width = width;
        viewInit();
    }

    public final void init(int width, double stepX) {
        this.width = width;
        init(stepX);
    }

    // Overriding
    @Override
    public void init(double stepX) {
        System.out.print("Initialization... ");
        super.init(stepX);
        System.out.println("done.");
    }

    public int setWidth(int width) { return this.width = width; }
    public int getWidth() { return width; }

    @Override
    public void viewHeader() {
        System.out.printf("%-" + width + "s | %-" + width + "s | %-" + width + "s | %-" + width + "s\n",
                "m", "h", "E", "max1");
        outLine();
    }

    @Override
    public void viewBody() {
        for (Item2d item : getItems()) {
            System.out.printf("%-" + width + ".2f | %-" + width + ".2f | %-" + width + "d | %-" + width + "d\n",
                    item.getM(), item.getH(), item.getE(), item.getMax1());
        }
    }

    @Override
    public void viewFooter() {
        outLine();
    }

    private void outLine() {
        for (int i = 0; i < width * 4 + 6; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}