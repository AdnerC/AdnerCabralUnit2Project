import java.util.Scanner;
import java.text.DecimalFormat;

public class EquationRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("What is your first pair? ");
        String xString = s.nextLine();

        System.out.print("What is your second pair? ");
        String yString = s.nextLine();

        System.out.print("What is your second x value? ");
        String x2String = s.nextLine();

        System.out.print("What is your second y value? ");
        String y2String = s.nextLine();

//        int indexOf;(xString, ",");

        int x = Integer.parseInt(xString);
        int x2 = Integer.parseInt(x2String);
        int y = Integer.parseInt(yString);
        int y2 = Integer.parseInt(y2String);

        LinearEquation firstEquation = new LinearEquation(x,y,x2,y2);



    }
    }
