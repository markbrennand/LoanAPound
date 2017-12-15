package techtest;

import java.util.List;

public class InFlightLoanRequest extends LoanRequest {
    private List<CreditScore> creditScores;

    public List<CreditScore> getCreditScores() {
        return creditScores;
    }

    public void setCreditScores(List<CreditScore> creditScores) {
        this.creditScores = creditScores;
    }
}
