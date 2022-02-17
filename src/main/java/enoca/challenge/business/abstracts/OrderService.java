package enoca.challenge.business.abstracts;

import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
import enoca.challenge.entities.concrete.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    Result add(Order order);
    Result update(Order order);
    Result delete(Order order);
    DataResult<List<Order>> getAll();
   // DataResult<Order>getOrderById(int id);
    DataResult<Order> getById(int id);
    DataResult<List<Order>>getByCreateDateAfter(LocalDate createDate);
}
