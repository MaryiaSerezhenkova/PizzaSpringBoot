package by.academy.pizza.api.mapper;


import by.academy.pizza.api.ITicket;
import by.academy.pizza.api.core.Order;
import by.academy.pizza.api.core.Ticket;


public class TicketMapper {
    private final OrderMapper orderMapper;

    public TicketMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public ITicket inputMapping(Ticket ticket) {
        Order order = orderMapper.orderOutputMapping(ticket.getOrder());
        return new Ticket (ticket.getNumber(), ticket.getOrder().getId());
                
    }

    public Ticket outputMapping(Ticket ticket) {
        Order order = orderMapper.orderOutputMapping(ticket.getOrder());
        return new Ticket (ticket.getId(), ticket.getCreatAt(), ticket.getNumber(), ticket.getOrder());
                
    }
}