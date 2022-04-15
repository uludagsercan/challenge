package enoca.challenge.business.concretes;

<<<<<<< HEAD
import enoca.challenge.business.abstracts.CustomerService;
import enoca.challenge.business.abstracts.OrderService;
import enoca.challenge.core.utilities.business.BusinessRule;
import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
import enoca.challenge.core.utilities.results.concrete.ErrorDataResult;
=======
import enoca.challenge.business.abstracts.OrderService;
import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
import enoca.challenge.core.utilities.results.concrete.ErrorResult;
import enoca.challenge.core.utilities.results.concrete.SuccessDataResult;
import enoca.challenge.core.utilities.results.concrete.SuccessResult;
import enoca.challenge.dataAccess.abstracts.OrderDao;
<<<<<<< HEAD
import enoca.challenge.entities.concrete.Customer;
=======
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
import enoca.challenge.entities.concrete.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class OrderManager implements OrderService {

    private OrderDao orderDao;
<<<<<<< HEAD
    private CustomerService customerService;
    @Autowired
    public OrderManager(OrderDao orderDao, CustomerService customerService) {
        this.orderDao = orderDao;
        this.customerService = customerService;
=======

    @Autowired
    public OrderManager(OrderDao orderDao) {
        this.orderDao = orderDao;
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
    }

    @Override
    public Result add(Order order) {
<<<<<<< HEAD
        var orderResult = BusinessRule.Run(checkIfOrderExist(order.getId()));
        if (orderResult == null){
            return new ErrorResult("Sipariş sistemde mevcuttur.");
        }
        var result = customerService.getById(order.getCustomer().getCustomerId());
        if(result.isSuccess() == false){
            return new ErrorResult("Müşteriye ait bilgi bulunamadı");
        }
=======
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
        order.setCreateDate(LocalDate.now());
        orderDao.save(order);
        return new SuccessResult("Ekleme işlemi başarılıdır.");
    }

<<<<<<< HEAD

    @Override
    public Result update(Order order) {

        var orderResult = BusinessRule.Run(checkIfOrderExist(order.getId()));
        if (orderResult!= null){
            return orderResult;
        }
        var dateResult = BusinessRule.Run(checkIfDateIsNotEqual(order.getId(), order.getCreateDate()));
        if (dateResult != null){
            return dateResult;
        }
        var customerResult = customerService.getById(order.getCustomer().getCustomerId());
        if(!customerResult.isSuccess()){
            return customerResult;
        }
=======
    @Override
    public Result update(Order order) {
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
        orderDao.save(order);
        return new SuccessResult("Güncelleme işlemi başarılıdır");
    }

<<<<<<< HEAD

    @Override
    public Result delete(int id) {
        Result result = BusinessRule.Run(checkIfOrderExist(id));
        if (result !=null){
            return result;
        }
        orderDao.deleteById(id);
=======
    @Override
    public Result delete(Order order) {
        orderDao.delete(order);
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
        return new SuccessResult("Silme işlemi başarılıdır.");
    }

    @Override
    public DataResult<List<Order>> getAll() {
<<<<<<< HEAD
        return new SuccessDataResult<List<Order>>(orderDao.findAll(),"Siparişler listelendi.");
=======
        return new SuccessDataResult<List<Order>>(orderDao.findAll());
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
    }

    @Override
    public DataResult<Order> getById(int id) {
<<<<<<< HEAD
        Result result = BusinessRule.Run(checkIfOrderExist(id));
        return result==null ?new SuccessDataResult<Order>(orderDao.getById(id),"Sipariş listelendi")
                : new ErrorDataResult<Order>(result.getMessage());
=======
        return new SuccessDataResult<Order>(orderDao.getById(id));
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
    }

    @Override
    public DataResult<List<Order>> getByCreateDateAfter(LocalDate createDate) {
<<<<<<< HEAD
        var result = orderDao.getByCreateDateAfter(createDate);
        if (result.stream().count()<=0){
            return new ErrorDataResult<List<Order>>("Belirtilen tarihten sonraki siparişler bulunamadı");
        }
        return new SuccessDataResult<List<Order>>(orderDao.getByCreateDateAfter(createDate),
                "Belirtilen tarihten sonraki siparişler listelendi");
    }

    //Business Rules
    private Result checkIfOrderExist(int id){
        boolean result = orderDao.existsById(id);
        if (!result){
            return new ErrorResult("Sipariş bilgisi mevcut değil");
        }
        return new SuccessResult();
    }

    private Result checkIfDateIsNotEqual(int id, LocalDate localDate){


        var result = orderDao.getById(id);
        if (!result.getCreateDate().equals(localDate)){
            return new ErrorResult("Sipariş tarih bilgisi düzenlenemez");
        }
        return new SuccessResult();
=======

        return new SuccessDataResult<List<Order>>(orderDao.getByCreateDateAfter(createDate));
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
    }
}
