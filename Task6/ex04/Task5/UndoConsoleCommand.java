package ex04.Task5;

import java.util.Stack;

/** Консольна команда Undo */
public class UndoConsoleCommand implements ConsoleCommand {
    private Stack<Command> history;

    public UndoConsoleCommand(Stack<Command> history) {
        this.history = history;
    }

    @Override
    public char getKey() { return 'u'; }
    @Override
    public String toString() { return "'u'ndo"; }

    @Override
    public void execute() {
        if (!history.isEmpty()) {
            Command last = history.pop();
            System.out.println("Undo last command: " + last);
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}
