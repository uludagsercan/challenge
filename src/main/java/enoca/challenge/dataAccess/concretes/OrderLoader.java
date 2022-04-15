package enoca.challenge.dataAccess.concretes;

import enoca.challenge.dataAccess.abstracts.OrderDao;
import enoca.challenge.entities.concrete.Customer;
import enoca.challenge.entities.concrete.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class OrderLoader implements CommandLineRunner {
    private OrderDao orderDao;
    @Autowired
    public OrderLoader(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public void run(String... args) throws Exception {
        LoadOrderData();
    }
    private void LoadOrderData(){
        if (orderDao.count()==0){
            Order o = new Order();
            Order o1 = new Order();
            Order o2 = new Order();
            Customer c = new Customer();
            Customer c1 = new Customer();
            c.setCustomerId(3);
            c.setName("Ali");
            c.setAge(32);
            c1.setCustomerId(4);
            c1.setAge(19);
            c1.setName("Ayşe");
            o.setCreateDate(LocalDate.now());
            o.setTotalPrice(23);
            o.setCustomer(c);
            o1.setCustomer(c1);
            o1.setCreateDate(LocalDate.now().plusMonths(3));
            o1.setTotalPrice(65);
            o2.setCreateDate(LocalDate.now().minusDays(3));
            o2.setCustomer(c);
            o2.setTotalPrice(65);

            orderDao.save(o);
            orderDao.save(o1);
            orderDao.save(o2);
        }

    }
}
