package techtest;

import java.util.Date;

public class CreditScore {
    private CreditAgency agency;
    private int score;
    private Date created;

    public CreditAgency getAgency() {
        return agency;
    }

    public void setAgency(CreditAgency agency) {
        this.agency = agency;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public static class Builder extends AbstractBuilder<CreditScore> {
        @Override
        public CreditScore create() {
            return new CreditScore();
        }

        @Override
        public CreditScore build() {
            return instance();
        }

        public Builder withAgency(CreditAgency agency) {
            instance().setAgency(agency);
            return this;
        }

        public Builder withScore(int score) {
            instance().setScore(score);
            return this;
        }
        public Builder withCreated(Date created) {
            instance().setCreated(created);
            return this;
        }
    }
}
