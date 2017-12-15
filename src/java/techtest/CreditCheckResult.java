package techtest;

import java.util.Date;

public class CreditCheckResult {
    private Error error;
    private CreditScore creditScore;

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public CreditScore getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(CreditScore creditScore) {
        this.creditScore = creditScore;
    }

    public static class Builder extends AbstractBuilder<CreditCheckResult> {
        @Override
        public CreditCheckResult create() {
            return new CreditCheckResult();
        }

        @Override
        public CreditCheckResult build() {
            return instance();
        }

        public Builder withError(String message) {
            instance().setError(new Error.Builder().withMessage(message).build());
            return this;
        }

        public Builder withCreditScore(CreditAgency agency, int score, Date created) {
            instance().setCreditScore(new CreditScore.Builder().
                    withAgency(agency).
                    withScore(score).
                    withCreated(created).
                    build());
            return this;
        }
    }
}
