package main.ru.sbrf.rest.test.web;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


/*
Определяем базовый URI для всех ресурсов URI
 */

/*
 * Пропишем через аннотации, а можно через WEB.xml, как для сервлетов
 */
@ApplicationPath("/")
/*
Класс Java объявляет классы корневого ресурса и провайдера
 */
public class IncrementerServiceApplication extends Application {
    /*
    Метод возвращает непустую коллекцию с классами, которые должны быть включены в опубликованное приложение JAX-RS
     */
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(IncrementerService.class);
        return h;
    }
}