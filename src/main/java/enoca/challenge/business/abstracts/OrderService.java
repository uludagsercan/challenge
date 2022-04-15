package enoca.challenge.business.abstracts;

import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
import enoca.challenge.entities.concrete.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    Result add(Order order);
    Result update(Order order);
<<<<<<< HEAD
    Result delete(int id);
    DataResult<List<Order>> getAll();
=======
    Result delete(Order order);
    DataResult<List<Order>> getAll();
   // DataResult<Order>getOrderById(int id);
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
    DataResult<Order> getById(int id);
    DataResult<List<Order>>getByCreateDateAfter(LocalDate createDate);
}
