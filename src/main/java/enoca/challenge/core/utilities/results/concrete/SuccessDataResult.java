package enoca.challenge.core.utilities.results.concrete;

import enoca.challenge.core.utilities.results.abstracts.DataResult;

public class SuccessDataResult<T> extends DataResult {
    public SuccessDataResult(T data, String message) {
        super(true, data, message);
    }

    public SuccessDataResult(T data) {
        super(true, data);
    }
    public SuccessDataResult(String message){
        super(true,message);
    }
}
