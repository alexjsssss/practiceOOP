package ex04.Task5;

import ex02.Task3.View;

/** Консольна команда View */
public class ViewConsoleCommand implements ConsoleCommand {
    private View view;
    public ViewConsoleCommand(View view) { this.view = view; }

    @Override
    public char getKey() { return 'v'; }
    @Override
    public String toString() { return "'v'iew"; }

    @Override
    public void execute() {
        System.out.println("View current.");
        view.viewShow();
    }
}

