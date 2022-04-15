package enoca.challenge.entities.concrete;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
<<<<<<< HEAD
import javax.validation.Constraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
=======
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Order {
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "total_price")
    private int totalPrice;
<<<<<<< HEAD

    @Column(name = "order_date",updatable = false)

=======
    @Column(name = "order_date")
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
    private LocalDate createDate;
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    @OnDelete( action = OnDeleteAction.CASCADE )
<<<<<<< HEAD
    @NotNull
=======
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
    private Customer customer;
}
