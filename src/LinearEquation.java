import java.text.DecimalFormat;
public class LinearEquation {
    private int x;
    private int y;
    private int x2;
    private int y2;
    private int x3;

    public LinearEquation(int x, int y, int x2, int y2) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;

    }
    public LinearEquation(int x, int y, int x2, int y2, int x3) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
    }

    public String fractionConversion( double number ){
        String slope = null;

        String numberString = number+"";
        int decPlace = numberString.length() - numberString.indexOf(".")-1;
        long denominator = (long) Math.pow(10, decPlace);
        long numerator =(long) (number*denominator);
        if (numerator % denominator == 0) {
            slope = number/denominator+"";
        } else {
            slope = numerator+"/"+denominator;
        }
        return slope;

    }


    public double slopeCalc() {
        double slope = ((double) y2 - y) / ((double) x2 - x);

        return slope;
    }

    public double interceptCalc() {
        double b = y - slopeCalc()*x;
        return b;
    }

    public double distance() {
        double distance = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow((y2 - y), 2)); // dividing the total amount by the amount of p
        return distance;
    }

    public double newX() {
        return (slopeCalc() * x3) + interceptCalc();
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##"); // used to round future numbers/variables


        String info = "First pair: " +"("+x+", "+y+")" + "\n"+"Second pair: " +"("+x2+", "+y2+")"+"\n"+"Slope of line : "+fractionConversion(slopeCalc())+"\n"+"Y-Intercept: "+interceptCalc()+"\n"+"Slope intercept form: y = "+fractionConversion(slopeCalc())+"x + "+interceptCalc()+"\n"+"Distance between points: "+ df.format(distance());
        return info;
    }


}