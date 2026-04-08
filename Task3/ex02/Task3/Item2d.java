package ex02.Task3;

import java.io.Serializable;
import java.util.Objects;

public class Item2d implements Serializable {
    private static final long serialVersionUID = 1L;

    private double mass;
    private double height;
    private double energy;
    private int maxOnes;

    public void setData(double m, double h, double e, int ones) {
        mass = m;
        height = h;
        energy = e;
        maxOnes = ones;
    }

    public double getMass() { return mass; }
    public double getHeight() { return height; }
    public double getEnergy() { return energy; }
    public int getMaxOnes() { return maxOnes; }

    @Override
    public String toString() {
        return "m=" + mass +
               ", h=" + height +
               ", E=" + String.format("%.2f", energy) +
               ", max1=" + maxOnes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item2d)) return false;
        Item2d item = (Item2d) o;
        return Double.compare(item.mass, mass) == 0 &&
               Double.compare(item.height, height) == 0 &&
               Double.compare(item.energy, energy) == 0 &&
               maxOnes == item.maxOnes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mass, height, energy, maxOnes);
    }
}