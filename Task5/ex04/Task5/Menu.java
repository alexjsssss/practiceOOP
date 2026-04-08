package ex04.Task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** Макрокоманда – колекція ConsoleCommand */
public class Menu implements Command {
    private List<ConsoleCommand> menu = new ArrayList<>();
    private Stack<Command> history = new Stack<>();

    public ConsoleCommand add(ConsoleCommand command) {
        menu.add(command);
        return command;
    }

    public Stack<Command> getHistory() { return history; }

    @Override
    public String toString() {
        String s = "Enter command...\n";
        for (ConsoleCommand c : menu) { s += c + ", "; }
        s += "'q'uit: ";
        return s;
    }

    @Override
    public void execute() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        menu: while (true) {
            do {
                System.out.print(this);
                try { s = in.readLine(); }
                catch (IOException e) { System.err.println("Error: " + e); System.exit(0); }
            } while (s.length() != 1);

            char key = s.charAt(0);
            if (key == 'q') { System.out.println("Exit."); break menu; }

            for (ConsoleCommand c : menu) {
                if (key == c.getKey()) {
                    c.execute();
                    history.push(c);
                    continue menu;
                }
            }
            System.out.println("Wrong command.");
        }
    }
}
