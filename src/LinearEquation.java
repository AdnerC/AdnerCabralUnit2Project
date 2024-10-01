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
    public double SlopeCalc() {
        double slope = ((double) y2 - y) / ((double) x2 - x);

        return slope;
    }

    public double InterceptCalc() {
        double b = y - SlopeCalc();
        return b;
    }

    public double Distance() {
        double distance = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow((y2 - y), 2)); // dividing the total amount by the amount of p
        return distance;
    }

    public double NewX() {
        return (SlopeCalc() * x3) + InterceptCalc();
    }

    public String toString() {
        String info = "First pair: " +"("+x+", "+y+")" + "\n"  ;
        return null;
    }


}