package enoca.challenge.dataAccess.abstracts;

import enoca.challenge.entities.concrete.Customer;
import enoca.challenge.entities.concrete.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderDao extends JpaRepository<Order,Integer> {

    Order getById(int id);
    List<Order> getByCreateDateAfter(LocalDate createDate);
}
