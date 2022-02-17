package enoca.challenge.business.concretes;

import enoca.challenge.business.abstracts.OrderService;
import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
import enoca.challenge.core.utilities.results.concrete.ErrorResult;
import enoca.challenge.core.utilities.results.concrete.SuccessDataResult;
import enoca.challenge.core.utilities.results.concrete.SuccessResult;
import enoca.challenge.dataAccess.abstracts.OrderDao;
import enoca.challenge.entities.concrete.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class OrderManager implements OrderService {

    private OrderDao orderDao;

    @Autowired
    public OrderManager(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Result add(Order order) {
        order.setCreateDate(LocalDate.now());
        orderDao.save(order);
        return new SuccessResult("Ekleme işlemi başarılıdır.");
    }

    @Override
    public Result update(Order order) {
        orderDao.save(order);
        return new SuccessResult("Güncelleme işlemi başarılıdır");
    }

    @Override
    public Result delete(Order order) {
        orderDao.delete(order);
        return new SuccessResult("Silme işlemi başarılıdır.");
    }

    @Override
    public DataResult<List<Order>> getAll() {
        return new SuccessDataResult<List<Order>>(orderDao.findAll());
    }

    @Override
    public DataResult<Order> getById(int id) {
        return new SuccessDataResult<Order>(orderDao.getById(id));
    }

    @Override
    public DataResult<List<Order>> getByCreateDateAfter(LocalDate createDate) {

        return new SuccessDataResult<List<Order>>(orderDao.getByCreateDateAfter(createDate));
    }
}
