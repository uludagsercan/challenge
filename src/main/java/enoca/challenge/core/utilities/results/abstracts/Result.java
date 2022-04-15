package enoca.challenge.core.utilities.results.abstracts;


import lombok.Data;


@Data
public abstract class Result {
    private boolean success;
    private String message;

    public Result(boolean success, String message){
       this.success=success;
       this.message=message;
    }
    public Result(boolean success){
        this.success=success;

    }


}
