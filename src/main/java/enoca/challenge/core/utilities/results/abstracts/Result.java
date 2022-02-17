package enoca.challenge.core.utilities.results.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public abstract class Result {
    private boolean success;
    private String message;

    public Result(boolean success){
        this.success=success;
    }
}
