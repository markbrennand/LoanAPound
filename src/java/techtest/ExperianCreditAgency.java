package techtest;

public class ExperianCreditAgency implements CreditAgency {

    @Override
    public String getName() {
        return "experian";
    }

    @Override
    public int getScore(Applicant applicant) {
        return 900;
    }
}
