package by.academy.pizza.dao.api;
import by.academy.pizza.api.ITicket;

public interface ITicketDao extends IDao<ITicket> {
	void delete(long id);

}
