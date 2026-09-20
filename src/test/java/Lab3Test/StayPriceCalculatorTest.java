package Lab3Test;

import Lab3.ReserveMyPark;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StayPriceCalculatorTest {

    //Creates an instance of the program
    private ReserveMyPark calculator = new ReserveMyPark();

    @ParameterizedTest
    //Loads data from csv file while also skipping header row
    @CsvFileSource(resources = "/TestCasesLab3 - Sheet1.csv", numLinesToSkip = 1)
    void testStayPrice(int nights, int guestAge, boolean isArkansasResident,
                        boolean hasVeteranDiscount, String expected) throws Exception {

        //Checks if test case is supposed to throw an exception
        if (expected.equals("Exception Thrown")) {

            //Makes sure an exception is actually thrown
            assertThrows(Exception.class, () -> {
                calculator.calculateStayPrice(nights, guestAge,
                        isArkansasResident, hasVeteranDiscount);
            });

        }
        else {

            //Calculates stay price with test case inputs
            double result = calculator.calculateStayPrice(nights, guestAge,
                    isArkansasResident, hasVeteranDiscount);

            //Converts string to double
            double expectedPrice = Double.parseDouble(expected);

            //Checks if calculated price matches expected price
            assertEquals(expectedPrice, result);
        }

    }
}
