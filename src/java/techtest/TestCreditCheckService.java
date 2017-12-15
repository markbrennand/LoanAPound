package techtest;

import java.util.Date;
import java.util.Map;
import techtest.CreditCheckResult.Builder;

import static techtest.util.Maps.newMap;
import static techtest.util.Strings.isEmptyString;

public class TestCreditCheckService implements CreditCheckService {
    private static final Map<String, CreditAgency> agencies = newMap();
    private static final CreditAgency equifaxAgency = new EquifaxCreditAgency();

    static {
        ExperianCreditAgency experianCreditAgency = new ExperianCreditAgency();
        agencies.put(equifaxAgency.getName(), equifaxAgency);
        agencies.put(experianCreditAgency.getName(), experianCreditAgency);
    }

    @Override
    public CreditCheckResult getScore(Applicant applicant) {
        try {
            return new Builder().withCreditScore(
                    equifaxAgency,
                    equifaxAgency.getScore(applicant),
                    new Date()).
                    build();
        } catch(Exception e) {
            return new Builder().withError(e.getMessage()).build();
        }
    }

    @Override
    public CreditCheckResult getScore(String agency, Applicant applicant) {
        if (isEmptyString(agency)) {
            return new Builder().withError("Credit agency must be defined").build();
        }

        try {
            CreditAgency creditAgency = agencies.get(agency);
            if (creditAgency == null) {
                return new Builder().withError("Credit agency named '" + agency + "' not registered").build();
            }
            return new Builder().withCreditScore(
                    creditAgency,
                    creditAgency.getScore(applicant),
                    new Date()).
                    build();
        } catch(Exception e) {
            return new Builder().withError(e.getMessage()).build();
        }
    }
}
