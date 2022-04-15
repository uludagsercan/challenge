package enoca.challenge.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerWithOrderDto {
    private int id;
    private String name;
    private int age;
}
