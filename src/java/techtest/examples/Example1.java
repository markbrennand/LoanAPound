package techtest.examples;

import techtest.Applicant;
import techtest.CreditCheckResult;
import techtest.CreditCheckService;
import techtest.CreditCheckServiceFactory;

public class Example1 {
    public static void main(String[] args) throws Exception {
        // Create a dummy applicant. In the real world the applicant would have come from the database.
        // There's no need to populate the applicant's fields as they're unused in the test implementation.
        Applicant applicant = new Applicant();

        // Get the credit check service. Currently the test implementation is used. In the real world the
        // factory get instance method would be changed to use a real world implementation.
        // If Spring was used another option would be to autowire the credit check service into the code.
        CreditCheckService creditCheckService = CreditCheckServiceFactory.getInstance();

        // If an argument has been specified then this identifies the credit agency to be used. Can be either
        // equifax or experian in the test implementation.
        if (args.length == 1) {
            CreditCheckResult result = creditCheckService.getScore(args[0], applicant);

            // If the Error is set in the result then the call failed.
            if (result.getError() != null) {
                throw new Exception(result.getError().getMessage());
            }

            System.out.println("Credit Score: " +
                    result.getCreditScore().getScore() +
                    " from agency " +
                    result.getCreditScore().getAgency().getName());
        } else {
            // Use the default agency for the credit check.
            CreditCheckResult result = creditCheckService.getScore(applicant);

            // If the Error is set in the result then the call failed.
            if (result.getError() != null) {
                throw new Exception(result.getError().getMessage());
            }

            System.out.println("Credit Score: " +
                    result.getCreditScore().getScore() +
                    " from agency " +
                    result.getCreditScore().getAgency().getName());
        }
    }
}
