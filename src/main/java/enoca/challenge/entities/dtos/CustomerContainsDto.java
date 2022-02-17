package enoca.challenge.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerContainsDto {
    private int customerId;
    private int orderId;
    private String customerName;
}
