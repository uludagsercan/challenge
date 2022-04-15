package enoca.challenge.core.utilities.results.concrete;

import enoca.challenge.core.utilities.results.abstracts.Result;

public class ErrorResult extends Result {
    public ErrorResult(String message) {
        super(false, message);
    }
    public ErrorResult() {
        super(false);
    }
}
