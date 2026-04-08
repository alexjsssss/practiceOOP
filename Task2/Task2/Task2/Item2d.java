package ex01.Task2;
import java.io.Serializable;

/**
 * Зберігає параметри (маса, висота), результат (енергія) та
 * найбільшу кількість послідовних 1 у двійковому представленні.
 */
public class Item2d implements Serializable {
    private static final long serialVersionUID = 1L;

    private double mass;       // маса
    private double height;     // висота
    private double energy;     // потенційна енергія
    private int maxOnes;       // найбільша кількість послідовних 1

    // transient поле не серіалізується
    private transient String comment;

    public Item2d() {
        mass = 0.0;
        height = 0.0;
        energy = 0.0;
        maxOnes = 0;
    }

    public Item2d(double mass, double height) {
        this.mass = mass;
        this.height = height;
    }

    public double getMass() { return mass; }
    public double getHeight() { return height; }
    public double getEnergy() { return energy; }
    public int getMaxOnes() { return maxOnes; }
    public String getComment() { return comment; }

    public void setMass(double mass) { this.mass = mass; }
    public void setHeight(double height) { this.height = height; }
    public void setEnergy(double energy) { this.energy = energy; }
    public void setMaxOnes(int maxOnes) { this.maxOnes = maxOnes; }
    public void setComment(String comment) { this.comment = comment; }

    @Override
    public String toString() {
        return "mass = " + mass + ", height = " + height +
               ", energy = " + energy + ", maxOnes = " + maxOnes +
               (comment != null ? ", comment = " + comment : "");
    }
}