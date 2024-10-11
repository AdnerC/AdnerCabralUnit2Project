import java.util.Scanner;

public class EquationRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("What is your first pair? ");// user enters first pair
        String firstString = s.nextLine();

        System.out.print("What is your second pair? ");// user enters second pair
        String secondString = s.nextLine();

        int index1 = firstString.indexOf(", ");// finding the index of comma in point format (x, y)
        int index2 = secondString.indexOf(", ");

        String x1S = firstString.substring(1, index1);//separating the x and y values for the first pair
        String y1S = firstString.substring(index1+2, firstString.length()-1);

        String x2S = secondString.substring(1, index2);//separating the x and y values for the second pair
        String y2S = secondString.substring(index2+2, secondString.length()-1);

        int x1 = Integer.parseInt(x1S);// converting each variable to a string
        int y1 = Integer.parseInt(y1S);
        int x2 = Integer.parseInt(x2S);
        int y2 = Integer.parseInt(y2S);

        LinearEquation firstEquation = new LinearEquation(x1,y1,x2,y2); // creating object

        String printString = firstEquation.toString();// printing the info sheet
        System.out.println(printString);

        System.out.print("What is your new x value? ");// now asking for the new x value
        String newXString = s.nextLine();
        int newX = Integer.parseInt(newXString);
        LinearEquation secondEquation = new LinearEquation(x1,y1,x2,y2, newX);// creating a new object with the newX variable now
        double newY = secondEquation.newX();
        System.out.println("Calculated point: ("+newX+","+newY+")");

    }
}
