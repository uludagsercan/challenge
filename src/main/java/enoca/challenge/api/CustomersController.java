package enoca.challenge.api;

import enoca.challenge.business.abstracts.CustomerService;
import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
import enoca.challenge.core.utilities.results.concrete.ErrorDataResult;

import enoca.challenge.entities.concrete.Customer;

import enoca.challenge.entities.dtos.CustomerContainsDto;
import enoca.challenge.entities.dtos.CustomerWithOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    private CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Customer>> getAll(){
        return customerService.getAll();
    }
    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.add(customer));
    }

    @PostMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.delete(customer));
    }

    @PostMapping("/update")
    public ResponseEntity<Result> update(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.update(customer));
    }

    @GetMapping("/getById")
    public DataResult<Customer> getCustomerById(@RequestParam int id){
        return customerService.getById(id);
    }

    @GetMapping("/getByNameContains")
    public DataResult<List<CustomerContainsDto>> getByNameContains(@RequestParam String name){
        return customerService.getByNameContains(name);
    }

    @GetMapping("/getByCustomerWithOrder")
    public DataResult<List<CustomerWithOrderDto>> getByCustomerWithOrder(){
        return customerService.getByCustomerWithOrder();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        List<String> errors = new ArrayList<>();
        for (var item : exceptions.getBindingResult().getFieldErrors()){
            errors.add(item.getDefaultMessage());
        }
        return new ErrorDataResult<Object>(errors,"Doğrulama hatası");
    }
}
