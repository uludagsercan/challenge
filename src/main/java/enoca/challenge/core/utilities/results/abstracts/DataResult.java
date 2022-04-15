package enoca.challenge.core.utilities.results.abstracts;

<<<<<<< HEAD

=======
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30


public abstract class DataResult<T> extends Result {
    private T data;
    public DataResult(boolean success, T data, String message){
        super(success,message);
        this.data=data;
    }
    public DataResult(boolean success, T data){
        super(success);
        this.data=data;
    }
<<<<<<< HEAD
    public DataResult(boolean success,String message){
        super(success,message);
    }
    public T getData(){
        return data;
    }

=======
    public T getData(){
        return data;
    }
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
}
