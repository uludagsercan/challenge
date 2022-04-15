package enoca.challenge.business.concretes;

import enoca.challenge.business.abstracts.CustomerService;
import enoca.challenge.business.abstracts.OrderService;
import enoca.challenge.core.utilities.business.BusinessRule;
import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
import enoca.challenge.core.utilities.results.concrete.ErrorDataResult;
import enoca.challenge.core.utilities.results.concrete.ErrorResult;
import enoca.challenge.core.utilities.results.concrete.SuccessDataResult;
import enoca.challenge.core.utilities.results.concrete.SuccessResult;
import enoca.challenge.dataAccess.abstracts.OrderDao;
import enoca.challenge.entities.concrete.Customer;
import enoca.challenge.entities.concrete.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class OrderManager implements OrderService {

    private OrderDao orderDao;
    private CustomerService customerService;
    @Autowired
    public OrderManager(OrderDao orderDao, CustomerService customerService) {
        this.orderDao = orderDao;
        this.customerService = customerService;
    }

    @Override
    public Result add(Order order) {
        var orderResult = BusinessRule.Run(checkIfOrderExist(order.getId()));
        if (orderResult == null){
            return new ErrorResult("Sipariş sistemde mevcuttur.");
        }
        var result = customerService.getById(order.getCustomer().getCustomerId());
        if(result.isSuccess() == false){
            return new ErrorResult("Müşteriye ait bilgi bulunamadı");
        }
        order.setCreateDate(LocalDate.now());
        orderDao.save(order);
        return new SuccessResult("Ekleme işlemi başarılıdır.");
    }


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
        orderDao.save(order);
        return new SuccessResult("Güncelleme işlemi başarılıdır");
    }


    @Override
    public Result delete(int id) {
        Result result = BusinessRule.Run(checkIfOrderExist(id));
        if (result !=null){
            return result;
        }
        orderDao.deleteById(id);
        return new SuccessResult("Silme işlemi başarılıdır.");
    }

    @Override
    public DataResult<List<Order>> getAll() {
        return new SuccessDataResult<List<Order>>(orderDao.findAll(),"Siparişler listelendi.");
    }

    @Override
    public DataResult<Order> getById(int id) {
        Result result = BusinessRule.Run(checkIfOrderExist(id));
        return result==null ?new SuccessDataResult<Order>(orderDao.getById(id),"Sipariş listelendi")
                : new ErrorDataResult<Order>(result.getMessage());
    }

    @Override
    public DataResult<List<Order>> getByCreateDateAfter(LocalDate createDate) {
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
    }
}
