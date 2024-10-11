import java.text.DecimalFormat;

public class LinearEquation {
    private int x;
    private int y;
    private int x2;
    private int y2;
    private int x3;


    public LinearEquation(int x, int y, int x2, int y2) {    // Constructor for when there is no x3

        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;

    }


    public LinearEquation(int x, int y, int x2, int y2, int x3) {    // Constructor for when there is x3

        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
    }


    public String fractionConversion( double number ){    // converts numbers to fractions

        String slope; //creating the variables
        String numberString = number+""; //converting the number to be converted in to a string
        // long is used for 2 of its properties, being able to represent a large number (useful for line 38 since 10^(decPlace) may get large, as well as being able to represent large integers without having to worry about floating point
        int decPlace = numberString.length() - numberString.indexOf(".")-2; //find the number of digits to the right of the decimal EX:
        long denominator = (long) Math.pow(10, decPlace); // denominator is 10 to the power of that many digits
        long numerator =(long) (number*denominator);//The numerator is the denominator multiplied by the number to be divided

        if (numerator % denominator == 0) { //checks if the number is an integer
            slope = number/denominator+"";
        } else { // if not, then just set slope equal to
            slope = numerator+"/"+denominator;
        }
        if (number/denominator == 0) {// if there is no slope, just return ""
            slope = "";
        }

        return slope;

    }


    public double slopeCalc() { //calculates slope
        double slope = ((double) y2 - y) / ((double) x2 - x);

        return slope;
    }


    public double interceptCalc() { //calculates the y - intercept
        double b = y - slopeCalc()*x; // b is the intercept

        return b;
    }


    public double distance() { //calculates the distance between points
        double distance = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow((y2 - y), 2)); // dividing the total amount by the amount of p
        return distance;
    }


    public double newX() // returns the y value associated with the x
    {
        return (slopeCalc() * x3) + interceptCalc();
    }


    public String toString() {// returns a string with all the wanted information

      DecimalFormat df = new DecimalFormat("#.##"); // used to round future numbers/variables

        // Initialize first strings
        String firstPair = "First pair: (" + x + ", " + y + ")";
        String secondPair = "Second pair: (" + x2 + ", " + y2 + ")";
        double slopeValue = slopeCalc();
        double interceptValue = interceptCalc();

        // Format the fractions
        String slopeData = fractionConversion(slopeValue);
        String interceptData; // Declare the variable

        if (interceptValue == 0) {
            interceptData = ""; // Assign an empty string if interceptValue is 0
        } else {
            interceptData = df.format(interceptValue); // Format if not 0
        }

        String distanceData = "Distance between points: " + df.format(distance());// creates the distance string

        if (y == y2) {// returns a different string if there is no function and only a constant
            return firstPair + "\n" + secondPair + "\n" + "Equation of the line: y = " + y + "\n" + distanceData;
        }
        if (slopeValue == 1) {//all of these are used for formatting depending on the status of slopeValue
            slopeData = "";
        }
        if (slopeValue == -1) {
            slopeData = "-";
        }
        if (slopeValue == 0) {
            slopeData = "";
        }

        String equation;// making the different formats for the equation depending on the intercept value
        if (interceptValue > 0) {
            equation = "Slope intercept form: y = " + slopeData + "x + " + interceptData;
        } else if (interceptValue < 0) {
            equation = "Slope intercept form: y = " + slopeData + "x - " + df.format(-interceptValue);
        } else { // intercept == 0
            equation = "Slope intercept form: y = " + slopeData + "x";
        }

        if (slopeValue == 1) {
            slopeData = "1"; // this makes it so that in the equation the slope does not appear, but the slope still appears in the slope of line print statement
        }

        //creating the final string so it can be used elsewhere
        String info = firstPair + "\n" + secondPair + "\n" + "Slope of line: " + slopeData + "\n" + "Y-Intercept: " + df.format(interceptValue) + "\n" + equation + "\n" + distanceData;
        return info;

    }

}
