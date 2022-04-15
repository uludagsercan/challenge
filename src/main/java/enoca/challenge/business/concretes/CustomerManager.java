package enoca.challenge.business.concretes;
import enoca.challenge.business.abstracts.CustomerService;
import enoca.challenge.core.utilities.business.BusinessRule;
import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
import enoca.challenge.core.utilities.results.concrete.ErrorDataResult;
import enoca.challenge.core.utilities.results.concrete.ErrorResult;
import enoca.challenge.core.utilities.results.concrete.SuccessDataResult;
import enoca.challenge.core.utilities.results.concrete.SuccessResult;
import enoca.challenge.dataAccess.abstracts.CustomerDao;
import enoca.challenge.entities.concrete.Customer;
import enoca.challenge.entities.concrete.Order;
import enoca.challenge.entities.dtos.CustomerContainsDto;
import enoca.challenge.entities.dtos.CustomerWithOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerManager implements CustomerService {


    private CustomerDao customerDao;
    @Autowired
    public CustomerManager(CustomerDao customerDao){
        this.customerDao=customerDao;
    }

    @Override
    public Result add(Customer customer) {
        var result = BusinessRule.Run(checkIfCustomerExist(customer.getCustomerId()));
        if (result==null){
            return new ErrorResult("Müşteri sistemde mevcuttur.");
        }
        customerDao.save(customer);
        return new SuccessResult("Ekleme işlemi başarılıdır.");
    }

    @Override
    public Result update(Customer customer) {

        //Business Rule
        Result result = BusinessRule.Run(checkIfCustomerExist(customer.getCustomerId()));
        if(result!=null){
            return new ErrorResult("Güncellenecek müşteri bulunamadı");
        }
        customerDao.save(customer);
        return new SuccessResult("Güncelleme işlemi başarılıdır.");
    }

    @Override
    public Result delete(int id) {
        //Business Rule
        Result result = BusinessRule.Run(checkIfCustomerExist(id));
        if(result!=null){
            return new ErrorResult("Silinecek müşteri bulunamadı");
        }
        customerDao.deleteById(id);
        return new SuccessResult("Silme işlemi başarılıdır");
    }

    @Override
    public DataResult<List<Customer>> getAll() {
        return new SuccessDataResult<List<Customer>>(customerDao.findAll(),"Listeleme işlemi başarılıdır.");
    }

    @Override
    public DataResult<Customer> getById(int id) {
        //Business Rule
        Result result = BusinessRule.Run(checkIfCustomerExist(id));
        if (result!=null){
            return new ErrorDataResult<Customer>("Parametre olarak girilen değer bulunamadı");
        }
        return new SuccessDataResult<Customer>(customerDao.getById(id),"Müşteriye ait bilgiler listelenmiştir.");
    }

    @Override
    public DataResult<List<CustomerContainsDto>> getByNameContains(String name) {

        var result = customerDao.getByNameContains(name);
        if (result.isEmpty()){
            return new ErrorDataResult<CustomerContainsDto>("Müşteriye ait sipariş bilgisi bulunamadı");
        }
        return new SuccessDataResult<List<CustomerContainsDto>>(result,"Müşteriye ait sipariş bilgileri listelendi");
    }

    @Override
    public DataResult<List<CustomerWithOrderDto>> getCustomerByOrdersIsNotContain() {
        var result = customerDao.getCustomerByOrdersIsNotContain();
        if (result.stream().count()<=0){
            return new ErrorDataResult<List<CustomerWithOrderDto>>("Tüm müşterilerin sipariş bilgisi mevcuttur");
        }
        return new SuccessDataResult<List<CustomerWithOrderDto>>(result,
                "Sipariş bilgisi olmayan müşteriler listelendi.");
    }

    private Result checkIfCustomerExist(int id){
        boolean result = customerDao.existsById(id);
        if(!result){
            return new ErrorResult();
        }
        return new SuccessResult();
    }
}
