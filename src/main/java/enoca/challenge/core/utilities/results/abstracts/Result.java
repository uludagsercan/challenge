package enoca.challenge.core.utilities.results.abstracts;

<<<<<<< HEAD

import lombok.Data;


@Data
=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
public abstract class Result {
    private boolean success;
    private String message;

<<<<<<< HEAD
    public Result(boolean success, String message){
       this.success=success;
       this.message=message;
    }
    public Result(boolean success){
        this.success=success;

    }


=======
    public Result(boolean success){
        this.success=success;
    }
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
}
