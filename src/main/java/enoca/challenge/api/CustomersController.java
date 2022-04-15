package enoca.challenge.api;

import enoca.challenge.business.abstracts.CustomerService;
import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
import enoca.challenge.core.utilities.results.concrete.ErrorDataResult;
import enoca.challenge.core.utilities.results.concrete.ErrorResult;
import enoca.challenge.entities.concrete.Customer;

import enoca.challenge.entities.dtos.CustomerContainsDto;
import enoca.challenge.entities.dtos.CustomerWithOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/delete")
    public ResponseEntity<Result> delete(@RequestParam int id){
        return ResponseEntity.ok(customerService.delete(id));
    }

    @PostMapping("/update")
    public ResponseEntity<Result> update(@Valid @RequestBody Customer customer){
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


}
