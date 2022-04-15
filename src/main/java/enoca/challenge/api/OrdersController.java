package enoca.challenge.api;


import enoca.challenge.business.abstracts.OrderService;
<<<<<<< HEAD
import enoca.challenge.core.utilities.business.BusinessRule;
import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
import enoca.challenge.core.utilities.results.concrete.ErrorDataResult;
import enoca.challenge.core.utilities.results.concrete.ErrorResult;
=======
import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
import enoca.challenge.core.utilities.results.concrete.ErrorDataResult;
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
import enoca.challenge.entities.concrete.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


=======
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private OrderService orderService;
    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/add")
<<<<<<< HEAD
    public ResponseEntity<Result> add(@Valid @RequestBody Order order){

=======
    public ResponseEntity<Result> add(@RequestBody Order order){
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
        return ResponseEntity.ok(orderService.add(order));
    }
    @GetMapping("/getall")
    public DataResult<List<Order>> getAll(){
        return orderService.getAll();
    }
    @PostMapping("/update")
<<<<<<< HEAD
    public ResponseEntity<Result> update(@Valid @RequestBody Order order){
        return ResponseEntity.ok(orderService.update(order));
    }
    @GetMapping("/delete")
    public ResponseEntity<Result> delete(@RequestParam int id){
        return ResponseEntity.ok(orderService.delete(id));
=======
    public ResponseEntity<Result> update(@RequestBody Order order){
        return ResponseEntity.ok(orderService.update(order));
    }
    @PostMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody Order order){
        return ResponseEntity.ok(orderService.delete(order));
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
    }
    @GetMapping("/getByCreateDateAfter")
    public DataResult<List<Order>> getByCreateDateAfter(@RequestParam String createDate){
        return orderService.getByCreateDateAfter(LocalDate.parse(createDate));
    }
    @GetMapping("/getById")
    public DataResult<Order> getById(@RequestParam int id){
        return orderService.getById(id);
    }
<<<<<<< HEAD

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<>(validationErrors,"Doğrulama hataları");
        return errors;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public ErrorResult handleBadRequestException(){
        return new ErrorResult("Bad Request");
=======
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        List<String> errors = new ArrayList<>();
        for (var item : exceptions.getBindingResult().getFieldErrors()){
            errors.add(item.getDefaultMessage());
        }
        return new ErrorDataResult<Object>(errors,"Doğrulama hatası");
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
    }

}
