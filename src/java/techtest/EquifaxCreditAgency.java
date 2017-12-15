package techtest;

public class EquifaxCreditAgency implements CreditAgency {
    @Override
    public String getName() {
        return "equifax";
    }

    @Override
    public int getScore(Applicant applicant) {
        return 450;
    }
}
