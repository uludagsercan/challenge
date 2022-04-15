package enoca.challenge.dataAccess.abstracts;

<<<<<<< HEAD
import enoca.challenge.entities.concrete.Customer;
=======
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
import enoca.challenge.entities.concrete.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderDao extends JpaRepository<Order,Integer> {
<<<<<<< HEAD

    Order getById(int id);
    List<Order> getByCreateDateAfter(LocalDate createDate);
=======
    Order getById(int id);

    List<Order> getByCreateDateAfter(LocalDate createDate);


>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
}
