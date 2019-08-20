package main.ru.sbrf.rest.test.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import main.ru.sbrf.rest.test.core.IIncrementerHolder;

/*
Класс Java будет размещен по пути URI "/incrementerservice"
 */
@Path("/incrementerservice")
public class IncrementerService {

    /*
    Метод получения значения счетчика будет вызван при получении запроса вида
    /incrementerservice/getNumber
    @Return строка с информацие о вызове метода getNumber
     */
    @GET
    @Produces("text/plain")
    @Path(value = "/getNumber")
    public String getNumber() {
        IIncrementerHolder holder = IIncrementerHolder.getInstance();
        return "Number value is: " + holder.getIncrementer().getNumber();
    }


    /*
    Метод увеличения значения счетчика будет вызван при получении запроса вида
    /incrementerservice/incrementNumber
    @Return строка с информацие о вызове метода incrementNumber
     */
    @GET
    @Produces("text/plain")
    @Path(value = "/incrementNumber")
    public String incrementNumber() {
        IIncrementerHolder holder = IIncrementerHolder.getInstance();
        holder.getIncrementer().incrementNumber();
        return "Incrementer called - Number value is: " + holder.getIncrementer().getNumber();
    }
}