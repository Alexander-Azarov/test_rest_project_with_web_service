package test.ru.sbrf.rest.test;

import main.ru.sbrf.rest.test.core.IIncrementer;
import main.ru.sbrf.rest.test.core.IIncrementerHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Тесты класса IIncrementerImpl
 */
class IIncrementerImplTest {

    private IIncrementer incrementer;

    /*
    Инициализация счетчика перед запуском каждого теста
     */
    @BeforeEach
    void initIncrementer() {
        IIncrementerHolder holder = IIncrementerHolder.getInstance();
        incrementer = holder.getIncrementer();
    }

    /**
     *
     * ---------- Тесты на проверку одиночных вызовов методов класса IIncrementerImpl --------------
     *
     */
    @Test
    /*
     Тест на проверку метода getNumber()
     */
    void getNumberTest() {
        assertEquals(0, incrementer.getNumber(), () ->
                "Ожидалось значение " + 0 + ", а метод getNumber вернул " + incrementer.getNumber() + "!");
    }

    @Test
    /*
      Тест на проверку метода incrementNumber()
      Т.к. метод НИЧЕГО не возвращает, то просто проверим, что нет выбрасываемых исключений!
     */
    void incrementNumberTest() {
        assertDoesNotThrow(() -> incrementer.incrementNumber());
    }

    @Test
    /*
      Тест на проверку метода setMaximumValue()
     */
    void setMaximumValueTest() {
        incrementer.setMaximumValue(10);
    }

    @Test
    /*
      Хотим получить IllegalArgumentException, задав отрицательное число
     */
    void setMaximumValueExceptionTest() {
        int negativeNumber = -1;
        assertThrows(IllegalArgumentException.class, () -> incrementer.setMaximumValue(negativeNumber));
    }

    /**
     *
     * ---------- Тесты на проверку поведения класса при последователных вызовах методов класса IIncrementerImpl -------
     *
     */

    @Test
    /*
      Проверка методов incrementNumber и getNumber - первоначальное значение счетчика 0, после вызова incrementNumber
      метод getNumber должен вернуть 1
     */
    void getNumberAndIncrementTest() {
        assertDoesNotThrow(() -> incrementer.incrementNumber());

        assertEquals(1, incrementer.getNumber(), () ->
                "Ожидалось значение " + 1 + ", а метод getNumber вернул " + incrementer.getNumber() + "!");
    }

    @Test
    /*
      Проверка поведения методов setMaximumValue, setMaximumValue и getNumber при последовательных вызовах
      Сначала происходит инициализация счетчика максимальным значением 10, в цикле происходит увеличение значений
      счетчика с проверками.
     */
    void setMaximumValueAndIncrementTest() {

        int maximumCounterValue = 10;
        /*
            Инициализация максимального значения счетчика
        */
        assertDoesNotThrow(() -> incrementer.setMaximumValue(maximumCounterValue));
        /*
          Последовательные вызовы
         */
        for (int i = 0; i < maximumCounterValue; i++) {
            assertDoesNotThrow(() -> incrementer.incrementNumber());
        }
        /*
         Метод getNumber должен возвращать maximumCounterValue = 10
         */
        assertEquals(incrementer.getNumber(), maximumCounterValue, () ->
                "Ожидалось значение " + maximumCounterValue + ", а метод getNumber вернул " + incrementer.getNumber() + "!");

        /*
          Вызываем счетчик еще один раз...
         */
        assertDoesNotThrow(() -> incrementer.incrementNumber());

        /*
        После достижения максимума счетчик должен быть сброшен на 0
         */
        assertEquals(0, incrementer.getNumber(), () ->
                "Ожидалось значение " + 0 + ", а метод getNumber вернул " + incrementer.getNumber() + "!");
    }

}