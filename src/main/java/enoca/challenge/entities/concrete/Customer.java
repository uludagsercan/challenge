package enoca.challenge.entities.concrete;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
<<<<<<< HEAD
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.constraints.*;
=======
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
import java.util.List;

@Entity
@Data
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","orders"})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "customer_name")
<<<<<<< HEAD
    @NotBlank
    @NotNull
    private String name;
    @Column(name = "customer_age")

    @Min(1)
    private int age;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Order> orders;
=======
    @NotNull(message = "name alanı boş geçilemez")

    private String name;
    @Column(name = "customer_age")
    @Min(value = 15,message = "yaş 15'ten büyük olmalıdır.")
    @Max(value=60,message = "yaş maximum 60 olmalıdır.")
    private int age;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Order> orders;


>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
}
