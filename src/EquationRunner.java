import java.util.Scanner;
import java.text.DecimalFormat;

public class EquationRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("What is your first pair? ");
        String firstString = s.nextLine();

        System.out.print("What is your second pair? ");
        String secondString = s.nextLine();

        int index1 = firstString.indexOf(", ");
        int index2 = secondString.indexOf(", ");

        String x1S = firstString.substring(1, index1);
        String y1S = firstString.substring(index1+2, firstString.length()-1);

        String x2S = secondString.substring(1, index2);
        String y2S = secondString.substring(index2+2, secondString.length()-1);

        int x1 = Integer.parseInt(x1S);
        int y1 = Integer.parseInt(y1S);
        int x2 = Integer.parseInt(x2S);
        int y2 = Integer.parseInt(y2S);

        LinearEquation firstEquation = new LinearEquation(x1,y1,x2,y2);

        String printString = firstEquation.toString();
        System.out.println(printString);

        System.out.print("What is your new x value? ");
        String newXString = s.nextLine();
        int newX = Integer.parseInt(newXString);
        LinearEquation secondEquation = new LinearEquation(x1,y1,x2,y2, newX);
        double newY = secondEquation.newX();
        System.out.println("Calculated point: ("+newX+","+newY+")");

    }
}

