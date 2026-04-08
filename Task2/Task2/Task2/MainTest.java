package ex01.Task2;

public class MainTest {
    public static void main(String[] args) {
        Calc calc = new Calc();

        // Тест обчислень
        calc.init(10, 5); // m=10, h=5
        Item2d data = calc.getResult();
        System.out.println("Energy = " + data.getEnergy());
        System.out.println("Max consecutive ones = " + data.getMaxOnes());

        // Тест серіалізації
        try {
            calc.save();
            calc.init(1, 1); // інші дані
            calc.restore();
            System.out.println("Restored: " + calc.getResult());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
