package ex03.Task4;

import ex02.Task3.View;
import ex02.Task3.ViewableResult;

/**
 * ConcreteCreator (Factory Method)
 * Створює об’єкт ViewTable
 */
public class ViewableTable extends ViewableResult {
    @Override
    public View getView() {
        return new ViewTable();
    }
}

