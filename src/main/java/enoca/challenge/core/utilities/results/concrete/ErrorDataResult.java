package enoca.challenge.core.utilities.results.concrete;

import enoca.challenge.core.utilities.results.abstracts.DataResult;

public class ErrorDataResult<T> extends DataResult {

    public ErrorDataResult(T data, String message) {
        super(false, data, message);
    }

    public ErrorDataResult(T data) {
        super(false, data);
    }
}
