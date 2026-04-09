package ex05.Task6;

import ex04.Task5.Command;

/** Інтерфейс черги завдань; шаблон Worker Thread */
public interface Queue {
    /** Додати нову задачу в чергу */
    void put(Command cmd);

    /** Взяти задачу з черги */
    Command take();
}
