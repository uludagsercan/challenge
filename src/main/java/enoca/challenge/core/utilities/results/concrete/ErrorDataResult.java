package enoca.challenge.core.utilities.results.concrete;

import enoca.challenge.core.utilities.results.abstracts.DataResult;

public class ErrorDataResult<T> extends DataResult {

    public ErrorDataResult(T data, String message) {
        super(false, data, message);
    }

    public ErrorDataResult(T data) {
        super(false, data);
    }
<<<<<<< HEAD
    public ErrorDataResult(String message){
        super(false,message);
    }
=======
>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
}
