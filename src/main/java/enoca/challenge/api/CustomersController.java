package enoca.challenge.api;

import enoca.challenge.business.abstracts.CustomerService;
import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
import enoca.challenge.core.utilities.results.concrete.ErrorDataResult;
<<<<<<< HEAD
import enoca.challenge.core.utilities.results.concrete.ErrorResult;
=======

>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
import enoca.challenge.entities.concrete.Customer;

import enoca.challenge.entities.dtos.CustomerContainsDto;
import enoca.challenge.entities.dtos.CustomerWithOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.validation.FieldError;
=======

>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;
import java.util.Map;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30

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
<<<<<<< HEAD

=======
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.add(customer));
    }

<<<<<<< HEAD
    @GetMapping("/delete")
    public ResponseEntity<Result> delete(@RequestParam int id){
        return ResponseEntity.ok(customerService.delete(id));
    }

    @PostMapping("/update")
    public ResponseEntity<Result> update(@Valid @RequestBody Customer customer){
=======
    @PostMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.delete(customer));
    }

    @PostMapping("/update")
    public ResponseEntity<Result> update(@RequestBody Customer customer){
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
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

<<<<<<< HEAD
    @GetMapping("/getCustomerByOrdersNotContaining")
    public DataResult<List<CustomerWithOrderDto>> getCustomerByOrdersNotContaining(){
        return customerService.getCustomerByOrdersIsNotContain();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<>(validationErrors,"Doğrulama hataları");
        return errors;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleBadRequestException(Exception exception){
        return new ErrorResult("Bad Request");
    }


=======
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
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
}
