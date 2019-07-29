package suites;


import tests.CalculationTest;
import tests.SavingCalculatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CalculationTest.class,
                    SavingCalculatorTest.class})
public class DefaultSuite {
}
