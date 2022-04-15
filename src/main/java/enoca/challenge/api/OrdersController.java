package enoca.challenge.api;


import enoca.challenge.business.abstracts.OrderService;
import enoca.challenge.core.utilities.business.BusinessRule;
import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
import enoca.challenge.core.utilities.results.concrete.ErrorDataResult;
import enoca.challenge.core.utilities.results.concrete.ErrorResult;
import enoca.challenge.entities.concrete.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private OrderService orderService;
    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody Order order){

        return ResponseEntity.ok(orderService.add(order));
    }
    @GetMapping("/getall")
    public DataResult<List<Order>> getAll(){
        return orderService.getAll();
    }
    @PostMapping("/update")
    public ResponseEntity<Result> update(@Valid @RequestBody Order order){
        return ResponseEntity.ok(orderService.update(order));
    }
    @GetMapping("/delete")
    public ResponseEntity<Result> delete(@RequestParam int id){
        return ResponseEntity.ok(orderService.delete(id));
    }
    @GetMapping("/getByCreateDateAfter")
    public DataResult<List<Order>> getByCreateDateAfter(@RequestParam String createDate){
        return orderService.getByCreateDateAfter(LocalDate.parse(createDate));
    }
    @GetMapping("/getById")
    public DataResult<Order> getById(@RequestParam int id){
        return orderService.getById(id);
    }

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
    }

}
