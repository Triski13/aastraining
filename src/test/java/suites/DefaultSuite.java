package suites;


import tests.CalculationTest;
import tests.NewSavingRequestTest;
import tests.SavingCalculatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CalculationTest.class,
                    SavingCalculatorTest.class,
        NewSavingRequestTest.class})
public class DefaultSuite {
}
