package enoca.challenge.business.abstracts;

import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
import enoca.challenge.entities.concrete.Customer;
import enoca.challenge.entities.concrete.Order;
import enoca.challenge.entities.dtos.CustomerContainsDto;
import enoca.challenge.entities.dtos.CustomerWithOrderDto;

import java.util.List;

public interface CustomerService {
    Result add(Customer customer);
    Result update(Customer customer);
<<<<<<< HEAD
    Result delete(int id);
    DataResult<List<Customer>> getAll();
    DataResult<Customer> getById(int id);
    DataResult<List<CustomerContainsDto>> getByNameContains(String name);
    DataResult<List<CustomerWithOrderDto>> getCustomerByOrdersIsNotContain();
=======
    Result delete(Customer customer);
    DataResult<List<Customer>> getAll();
    DataResult<Customer> getById(int id);
    DataResult<List<CustomerContainsDto>> getByNameContains(String name);
    DataResult<List<CustomerWithOrderDto>> getByCustomerWithOrder();
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
}
