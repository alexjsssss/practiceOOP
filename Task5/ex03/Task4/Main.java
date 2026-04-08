package ex03.Task4;

import ex02.Task3.View;

public class Main extends ex02.Task3.Main {
    public Main(View view) {
        super(view);
    }

    public static void main(String[] args) {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}
