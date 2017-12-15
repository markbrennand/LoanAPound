package techtest;

public interface CreditCheckService {
    public CreditCheckResult getScore(Applicant applicant);
    public CreditCheckResult getScore(String agency, Applicant applicant);
}
