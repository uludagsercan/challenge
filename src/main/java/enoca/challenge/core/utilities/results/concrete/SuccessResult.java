package enoca.challenge.core.utilities.results.concrete;

import enoca.challenge.core.utilities.results.abstracts.Result;

public class SuccessResult extends Result {
    public SuccessResult(String message) {
        super(true, message);
    }
    public SuccessResult(){
        super(true);
    }
}
