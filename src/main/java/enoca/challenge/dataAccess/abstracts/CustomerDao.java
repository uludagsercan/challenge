package enoca.challenge.dataAccess.abstracts;

import enoca.challenge.entities.concrete.Customer;

import enoca.challenge.entities.dtos.CustomerContainsDto;
import enoca.challenge.entities.dtos.CustomerWithOrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
import org.springframework.data.repository.query.Param;
=======
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {
<<<<<<< HEAD
    Customer getById(int id);
    @Query(value = "select new enoca.challenge.entities.dtos.CustomerContainsDto(c.customerId,o.id,c.name) " +
            "from Customer c inner join " +
            "c.orders o where c.name like %:name%")
    List<CustomerContainsDto> getByNameContains(@Param("name") String name);

    @Query("select new enoca.challenge.entities.dtos.CustomerWithOrderDto(c.customerId,c.name,c.age) from Customer c " +
            "left join c.orders o where o.customer.customerId is null " )
    List<CustomerWithOrderDto> getCustomerByOrdersIsNotContain();
=======

    Customer getById(int id);
    @Query(value = "select new enoca.challenge.entities.dtos.CustomerContainsDto(c.customerId,o.id,c.name) " +
            "from Customer c inner join " +
            "c.orders o where c.name like %?1%")
    List<CustomerContainsDto> getByNameContains(String name);
    @Query("select new enoca.challenge.entities.dtos.CustomerWithOrderDto(c.customerId,c.name,c.age) from Customer c " +
            "left join c.orders o where o.customer.customerId is null " )
    List<CustomerWithOrderDto> getByCustomerWithOrder();
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
}
