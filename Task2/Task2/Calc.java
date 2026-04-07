package ex01.Task2;
import java.io.*;

/**
 * Виконує обчислення потенційної енергії та серіалізацію результатів.
 */
public class Calc {
    private static final String FNAME = "Item2d.bin";
    private Item2d result;

    public Calc() {
        result = new Item2d();
    }

    public void setResult(Item2d result) {
        this.result = result;
    }

    public Item2d getResult() {
        return result;
    }

    private double calcEnergy(double mass, double height) {
        final double g = 9.81;
        return mass * g * height;
    }

    private int maxConsecutiveOnes(long value) {
        int max = 0, count = 0;
        while (value > 0) {
            if ((value & 1) == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
            value >>= 1;
        }
        return max;
    }

    public void init(double mass, double height) {
        result.setMass(mass);
        result.setHeight(height);
        double energy = calcEnergy(mass, height);
        result.setEnergy(energy);
        result.setMaxOnes(maxConsecutiveOnes((long) energy));
    }

    public void show() {
        System.out.println(result);
    }

    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(result);
        os.close();
    }

    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Item2d) is.readObject();
        is.close();
    }
}
