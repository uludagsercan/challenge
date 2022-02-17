package enoca.challenge.business.concretes;
import enoca.challenge.business.abstracts.CustomerService;
import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
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
        customerDao.save(customer);
        return new SuccessResult("Ekleme işlemi başarılıdır.");
    }

    @Override
    public Result update(Customer customer) {
        customerDao.save(customer);
        return new SuccessResult("Güncelleme işlemi başarılıdır.");
    }

    @Override
    public Result delete(Customer customer) {
        customerDao.delete(customer);
        return new SuccessResult("Silme işlemi başarılıdır");
    }

    @Override
    public DataResult<List<Customer>> getAll() {
        return new SuccessDataResult<List<Customer>>(customerDao.findAll());
    }

    @Override
    public DataResult<Customer> getById(int id) {
        return new SuccessDataResult<Customer>(customerDao.getById(id));
    }

    @Override
    public DataResult<List<CustomerContainsDto>> getByNameContains(String name) {
        return new SuccessDataResult<List<CustomerContainsDto>>(customerDao.getByNameContains(name));
    }

    @Override
    public DataResult<List<CustomerWithOrderDto>> getByCustomerWithOrder() {
        return new SuccessDataResult<List<CustomerWithOrderDto>>(customerDao.getByCustomerWithOrder());
    }

}
