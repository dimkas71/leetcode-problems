package algorithmic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("""
        Adding string as an array of digits as numbers. For example
        "10001" + "543" should be "10544"
        """)
class AddStringOfDigitsAsNumbersTest {

    @DisplayName("""
            "0" + "0" should be equal "0"
            """)
    @Test
    void zeroStringPlusZeroString() {

        String s1 = "0";
        String s2 = "0";

        Assertions.assertEquals("0", Utils.add(s1, s2));

    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0, 0, 0",
            "0, 1, 1",
            "101, 1, 102",
            "342, 465, 807",
            "9999999, 9999, 10009998",
            "10001, 543, 10544",
            "10003, 543, 10546",
            "942, 9465, 10407"

    })
    void stringAddingTests(String s1, String s2, String expected) {
        Assertions.assertEquals(expected, Utils.add(s1, s2));
    }

}
