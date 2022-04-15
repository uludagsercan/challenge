package enoca.challenge.core.utilities.results.concrete;

import enoca.challenge.core.utilities.results.abstracts.Result;

public class ErrorResult extends Result {
    public ErrorResult(String message) {
        super(false, message);
    }
<<<<<<< HEAD
=======

>>>>>>> 9eec08269d92308f92c9ec7e0783e5cd385d1e30
    public ErrorResult() {
        super(false);
    }
}
