package ex01.Task2;

import java.io.Serializable;
import java.util.Objects;

/** Модель даних: маса, висота, енергія, max1 */
public class Item2d implements Serializable {
    private static final long serialVersionUID = 1L;

    private double m;   // маса (x)
    private double h;   // висота (y)
    private int E;      // енергія
    private int max1;   // макс. кількість 1

    // --- сетери ---
    public void setM(double m) { this.m = m; }
    public void setH(double h) { this.h = h; }
    public void setE(int E) { this.E = E; }
    public void setMax1(int max1) { this.max1 = max1; }

    // --- гетери ---
    public double getM() { return m; }
    public double getH() { return h; }
    public int getE() { return E; }
    public int getMax1() { return max1; }

    // --- додаткові методи для сумісності з ex04 ---
    public void setXY(double m, double h) {
        this.m = m;
        this.h = h;
    }

    public double getX() { return m; }
    public double getY() { return h; }

    public void setX(double m) { this.m = m; }
    public void setY(double h) { this.h = h; }

    @Override
    public String toString() {
        return "m=" + m +
               ", h=" + h +
               ", E=" + E +
               ", max1=" + max1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item2d)) return false;
        Item2d item = (Item2d) o;
        return Double.compare(item.m, m) == 0 &&
               Double.compare(item.h, h) == 0 &&
               E == item.E &&
               max1 == item.max1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m, h, E, max1);
    }
}