package ex02.Task3;

import java.io.*;
import ex01.Task2.Item2d;

public class Calc {
    private static final String FNAME = "Item2d.bin";
    private Item2d result;

    public Calc() {
        result = new Item2d();
    }

    public Item2d getResult() { return result; }

    private int calcEnergy(double mass, double height) {
        final double g = 9.81;
        return (int)(mass * g * height);
    }

    private int maxConsecutiveOnes(int value) {
        int max = 0, count = 0;
        while (value > 0) {
            if ((value & 1) == 1) {
                count++;
                if (count > max) max = count;
            } else count = 0;
            value >>= 1;
        }
        return max;
    }

    public void init(double mass, double height) {
        int energy = calcEnergy(mass, height);
        result.setM(mass);
        result.setH(height);
        result.setE(energy);
        result.setMax1(maxConsecutiveOnes(energy));
    }

    public void show() { System.out.println(result); }

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

