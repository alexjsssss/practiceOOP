package ex01.Task2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private Calc calc = new Calc();

    private void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Enter command...");
            System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
            try {
                s = in.readLine();
            } catch(IOException e) {
                System.out.println("Error: " + e);
                System.exit(0);
            }
            if (s.length() != 1) continue;

            switch (s.charAt(0)) {
                case 'q':
                    System.out.println("Exit.");
                    break;
                case 'v':
                    calc.show();
                    break;
                case 'g':
                    double mass = Math.random() * 100;
                    double height = Math.random() * 50;
                    calc.init(mass, height);
                    calc.show();
                    break;
                case 's':
                    try {
                        calc.save();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    break;
                case 'r':
                    try {
                        calc.restore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                    break;
                default:
                    System.out.println("Wrong command.");
            }
        } while(s.charAt(0) != 'q');
    }

    public static void main(String[] args) {
        new Main().menu();
    }
}
