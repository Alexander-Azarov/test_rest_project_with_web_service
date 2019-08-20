package main.ru.sbrf.rest.test.core;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * Класс IIncrementerImpl - реализация интерфейса IIncrementer
 */
public class IIncrementerImpl implements IIncrementer {

    /*
     * Значение счетчика
     * Используется тип AtomicInteger как потокобезопасный
     */
    private final AtomicInteger number = new AtomicInteger(0);

    /*
     По-умолчанию максимум - максимальное значение int.
     */
    private int maximumValue = Integer.MAX_VALUE;

    /*
     * Метод получения значения счетчика
     * @return значение счетчика
     */
    public int getNumber() {
        return this.number.get();
    }

    /*
     * Метод увеличения значения счетчика на 1
     */
    public void incrementNumber() {
        if (this.number.intValue() == this.maximumValue) {
            this.number.set(0); // сброс на 0
        } else {
            this.number.incrementAndGet();
        }
    }

    /**
     * Метод установки максимального значения счетчика
     * Выбрасываем исключение {@link IllegalArgumentException} т.к. в интерфейсе явно не указано, какое исключение может
     * возврщать метод!
     * @param maximumValue - максимальное значение счетчика
     */
    public void setMaximumValue(int maximumValue) {
        if (maximumValue < 0) throw new IllegalArgumentException("Ошибка! Нельзя указать в качестве максимального " +
                "значения отрицательное число!");
        this.maximumValue = maximumValue;
    }
}
