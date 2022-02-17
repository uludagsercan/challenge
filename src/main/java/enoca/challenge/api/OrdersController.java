package enoca.challenge.api;


import enoca.challenge.business.abstracts.OrderService;
import enoca.challenge.core.utilities.results.abstracts.DataResult;
import enoca.challenge.core.utilities.results.abstracts.Result;
import enoca.challenge.core.utilities.results.concrete.ErrorDataResult;
import enoca.challenge.entities.concrete.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private OrderService orderService;
    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody Order order){
        return ResponseEntity.ok(orderService.add(order));
    }
    @GetMapping("/getall")
    public DataResult<List<Order>> getAll(){
        return orderService.getAll();
    }
    @PostMapping("/update")
    public ResponseEntity<Result> update(@RequestBody Order order){
        return ResponseEntity.ok(orderService.update(order));
    }
    @PostMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody Order order){
        return ResponseEntity.ok(orderService.delete(order));
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
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        List<String> errors = new ArrayList<>();
        for (var item : exceptions.getBindingResult().getFieldErrors()){
            errors.add(item.getDefaultMessage());
        }
        return new ErrorDataResult<Object>(errors,"Doğrulama hatası");
    }

}
