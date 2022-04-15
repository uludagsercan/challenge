package enoca.challenge.dataAccess.abstracts;

import enoca.challenge.entities.concrete.Customer;

import enoca.challenge.entities.dtos.CustomerContainsDto;
import enoca.challenge.entities.dtos.CustomerWithOrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {
    Customer getById(int id);
    @Query(value = "select new enoca.challenge.entities.dtos.CustomerContainsDto(c.customerId,o.id,c.name) " +
            "from Customer c inner join " +
            "c.orders o where c.name like %:name%")
    List<CustomerContainsDto> getByNameContains(@Param("name") String name);

    @Query("select new enoca.challenge.entities.dtos.CustomerWithOrderDto(c.customerId,c.name,c.age) from Customer c " +
            "left join c.orders o where o.customer.customerId is null " )
    List<CustomerWithOrderDto> getCustomerByOrdersIsNotContain();
}
