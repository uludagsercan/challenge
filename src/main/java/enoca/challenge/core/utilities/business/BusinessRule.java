package enoca.challenge.core.utilities.business;

import enoca.challenge.core.utilities.results.abstracts.Result;

public class BusinessRule {
    public static Result Run(Result logic ){
        if (!logic.isSuccess()){
            return logic;
        }
        return null;
    }
}
