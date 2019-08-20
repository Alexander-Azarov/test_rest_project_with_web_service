package main.ru.sbrf.rest.test.core;

/*
 * Класс для получения экземпляра счетчика
 */
public abstract class IIncrementerHolder {

    private static IIncrementerHolder instance = null;
    private static IIncrementer incrementer;

    private IIncrementerHolder() {
    }

    /*
     * Для возможного последующего расширения и получения других счетчиков
     * @return
     */
    public abstract IIncrementer getIncrementer();

    public static IIncrementerHolder getInstance() {
        if (instance != null) return instance;
        instance = new LocalIIncrementerHolder();
        return instance;
    }

    /*
     * Внутренняя реализация счетчика
     */
    private static class LocalIIncrementerHolder extends IIncrementerHolder {
        private LocalIIncrementerHolder() {
            incrementer = new IIncrementerImpl();
        }

        @Override
        public IIncrementer getIncrementer() {
            return incrementer;
        }
    }

}
