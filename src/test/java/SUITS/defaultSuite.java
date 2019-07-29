package SUITS;


import TESTS.calculationTests;
import TESTS.savingCalculatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({calculationTests.class,
                    savingCalculatorTest.class})
public class defaultSuite {
}
