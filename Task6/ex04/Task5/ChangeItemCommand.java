package ex04.Task5;

import ex01.Task2.Item2d;

/** Команда зміни Item */
public class ChangeItemCommand implements Command {
    private Item2d item;
    private double offset;

    public Item2d setItem(Item2d item) { return this.item = item; }
    public Item2d getItem() { return item; }

    public double setOffset(double offset) { return this.offset = offset; }
    public double getOffset() { return offset; }

    @Override
    public void execute() {
        item.setY(item.getY() * offset);
    }
}
