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

    // Обчислення потенційної енергії
    private double calcEnergy(double mass, double height) {
        final double g = 9.81;
        return mass * g * height;
    }

    // Пошук максимальної кількості послідовних 1 у двійковому представленні
    private int maxConsecutiveOnes(long value) {
        int max = 0, count = 0;

        while (value > 0) {
            if ((value & 1) == 1) {
                count++;
                if (count > max) max = count;
            } else {
                count = 0;
            }
            value >>= 1;
        }

        return max;
    }

    // Основний метод ініціалізації
    public void init(double mass, double height) {
        result.setMass(mass);
        result.setHeight(height);

        double energy = calcEnergy(mass, height);
        result.setEnergy(energy);
        long energyInt = Math.round(energy);
        result.setMaxOnes(maxConsecutiveOnes(energyInt));
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
