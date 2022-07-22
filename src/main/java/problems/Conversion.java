public class Conversion {
    public double tempConversion(double temp, String unit) {
        if (unit.equals("F")) {
            return (temp - 32) * (5.0/9.0);
        } else {
            return (temp * (9.0/5.0)) + 32;
        }
    }
}
