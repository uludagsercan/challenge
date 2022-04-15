package enoca.challenge.core.utilities.results.concrete;

import enoca.challenge.core.utilities.results.abstracts.DataResult;

public class SuccessDataResult<T> extends DataResult {
    public SuccessDataResult(T data, String message) {
        super(true, data, message);
    }

    public SuccessDataResult(T data) {
        super(true, data);
    }
<<<<<<< HEAD
    public SuccessDataResult(String message){
        super(true,message);
    }
=======
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
}
