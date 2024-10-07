import java.text.DecimalFormat;
public class LinearEquation {
    private int x;
    private int y;
    private int x2;
    private int y2;
    private int x3;

    // Constructor for when there is no x3
    public LinearEquation(int x, int y, int x2, int y2) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;


    }
    // Constructor for when there is x3

    public LinearEquation(int x, int y, int x2, int y2, int x3) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
    }

    // converts numbers to fractions
    public String fractionConversion( double number ){
        String slope; //creating the variables
        String numberString = number+""; //converting the number to be converted in to a string

        int decPlace = numberString.length() - numberString.indexOf(".")-2; //find the number of digits to the right of the decimal EX:
        long denominator = (long) Math.pow(10, decPlace); // denominator is 10 to the power of that many digits
        long numerator =(long) (number*denominator);//The numerator is the denominator multiplied by the number to be divided

        if (numerator % denominator == 0) { //checks if the number is an integer
            slope = number/denominator+"";
        } else { // if not, then just set slope equal to
            slope = numerator+"/"+denominator;
        }
        if (number/denominator == 0) {
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

    public String test() {// used for testing conversion/slope
        String test = "Slope before fraction conversion: " + slopeCalc()+"\n"+"Formatted slope: " + fractionConversion(slopeCalc());
        return test;
    }

    public String toString() {// returns a string with all the wanted information

        DecimalFormat df = new DecimalFormat("#.##"); // used to round future numbers/variables
        String firstPair = "First pair: " +"("+x+", "+y+")";
        String secondPair = "Second pair: " +"("+x2+", "+y2+")";
        String slope = "Slope of line : "+fractionConversion(slopeCalc());
        String intercept = "Y-Intercept: "+interceptCalc();
        String equation ="Slope intercept form: y = "+fractionConversion(slopeCalc())+"x + "+interceptCalc();
        String distance = "Distance between points: "+ df.format(distance());

        String slopeData = fractionConversion(slopeCalc());
        String interceptData = interceptCalc()+"";
        String distanceData = "Distance between points: "+ df.format(distance());

        if (slopeCalc()==1) {
            slopeData ="";
        }
        if (slopeCalc()==-1) {
            slopeData ="";
        }
        if (interceptCalc()==0) {
            interceptData = "";
            equation ="Slope intercept form: y = "+fractionConversion(slopeCalc())+"x";
        }
        if (slopeCalc()==0){
            slopeData = "";
        }
        if (slopeCalc()==0 && interceptCalc()==0){
            equation ="Slope intercept form: y = "+fractionConversion(slopeCalc())+"x - "+interceptCalc()*-1;
        }
        if (interceptCalc()<0) { // if the intercept is negative, make it positive and simply subtract
            equation ="Slope intercept form: y = "+fractionConversion(slopeCalc())+"x";
        }
        String finalEquation = equation;
        String info = "First pair: " +"("+x+", "+y+")" + "\n"+"Second pair: " +"("+x2+", "+y2+")"+"\n"+"Slope of line : "+fractionConversion(slopeCalc())+"\n"+"Y-Intercept: "+interceptCalc()+"\n"+"Slope intercept form: y = "+fractionConversion(slopeCalc())+"x + "+interceptCalc()+"\n"+"Distance between points: "+ df.format(distance());
        return info;
    }

}
