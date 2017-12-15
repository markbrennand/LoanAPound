package techtest;

public class CreditCheckServiceFactory {
    private static final CreditCheckService service = new TestCreditCheckService();

    public static CreditCheckService getInstance() {
        return service;
    }
}
