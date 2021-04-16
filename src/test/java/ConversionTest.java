import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversionTest {
    @Test
    public void testTempConversion() throws Throwable {
        Conversion sut = new Conversion();

        double temp = 90.0d;
        String unit = "";
        double result = sut.tempConversion(temp, unit);

        assertEquals(194.0, result, 1e-4);
    }
}
