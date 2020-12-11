package tudelft.chocolate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MyChocolateTest {
    private ChocolateBags bag;

    @BeforeEach
    public void initialize() {this.bag = new ChocolateBags();}

    @ParameterizedTest(name = "small={0}, big={1}, total={2}, expected={3}")
    @CsvSource({"1,1,5,0", "1,1,6,1", "1,1,7,-1", "1,1,8,-1" })
    public void totalIsTooBig(int small, int big, int total, int expected) {
        int res = bag.calculate(small, big, total);
        Assertions.assertEquals(expected, res);
    }

    @ParameterizedTest(name = "small={0}, big={1}, total={2}, expected={3}")
    @CsvSource({"4,0,10,-1", "4,1,10,-1", "4,2,10,0", "4,3,10,0"})
    public void onlyBigBars(int small, int big, int total, int expected) {
        int res = bag.calculate(small, big, total);
        Assertions.assertEquals(expected, res);
    }

    @ParameterizedTest(name = "small={0}, big={1}, total={2}, expected={3}")
    @CsvSource({"1,1,2,-1","2,1,2,2","5,1,3,3" })
    public void onlySmallBars(int small, int big, int total, int expected) {
        int res = bag.calculate(small, big, total);
        Assertions.assertEquals(expected, res);
    }
    @ParameterizedTest(name = "small={0}, big={1}, total={2}, expected={3}")
    @CsvSource({"1,1,7,-1","1,2,7,-1","2,2,7,2","20,2,20,10"})
    public void bigAndSmall(int small, int big, int total, int expected) {

    }
}
