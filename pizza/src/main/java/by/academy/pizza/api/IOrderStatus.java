package by.academy.pizza.api;

import java.util.List;

import by.academy.pizza.api.core.Stage;
import by.academy.pizza.api.core.Ticket;

/**
 * Статус заказа выданный по определённому квитку
 */
public interface IOrderStatus {

    /**
     * По какому квитку мы получили статус
     * @return
     */
    Ticket getTicket();

    /**
     * Получить список пройденных этапов
     * @return пройденные этапы заказа
     */
    List<Stage> getHistory();

    /**
     * Признак готовности заказа
     * @return true - готов, false - неготов
     */
    boolean isDone();
}
