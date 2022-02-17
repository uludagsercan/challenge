package enoca.challenge.dataAccess.concretes;

import enoca.challenge.dataAccess.abstracts.CustomerDao;
import enoca.challenge.entities.concrete.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerLoader implements CommandLineRunner {
    private CustomerDao customerDao;
    @Autowired
    public CustomerLoader(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCustomerData();
    }
    private void loadCustomerData(){
        if(customerDao.count()==0){
            Customer c1 = new Customer();
            Customer c2 = new Customer();
            Customer c3 = new Customer();
            Customer c4 = new Customer();
            Customer c5 = new Customer();
            Customer c6 = new Customer();
            Customer c7 = new Customer();
            c1.setName("Sercan");
            c1.setAge(26);
            c2.setName("Mehmet");
            c2.setAge(23);
            c3.setName("Ali");
            c3.setAge(32);
            c4.setName("Ayşe");
            c4.setAge(19);
            c5.setName("Hüseyin");
            c5.setAge(22);
            c6.setAge(29);
            c6.setName("Melike");
            c7.setName("Ahmet");
            c7.setAge(32);
            customerDao.save(c1);
            customerDao.save(c2);
            customerDao.save(c3);
            customerDao.save(c4);
            customerDao.save(c5);
            customerDao.save(c6);
            customerDao.save(c7);

        }
    }

}
