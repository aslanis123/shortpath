import java.awt.*;
import java.util.Scanner;

class Point2D {

    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString(){
        return this.x + "," + this.y;
    }
}



public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the M size of the chessboard: ");
        int xDimension = scanner.nextInt();
        System.out.println("Please Enter the N height size of the chessboard: ");
        int yDimension = scanner.nextInt();
        try {
            System.out.println("Please Enter the Starting point: (X,Y)");
            String[] startingPointArray = scanner.next().split(",");
            System.out.println(startingPointArray.length);
            Point2D startingPoint = new Point2D(Integer.valueOf(startingPointArray[0]), Integer.valueOf(startingPointArray[1]));
            System.out.println("Please Enter the end point: (X,Y)");
            String[] endPointArray = scanner.next().split(",");
            Point2D endPoint = new Point2D(Integer.valueOf(endPointArray[0]), Integer.valueOf(endPointArray[1]));
        } catch (ArrayIndexOutOfBoundsException ex | )

        System.out.println(solve(xDimension, yDimension, startingPoint, endPoint));
    }

    private static String solve(int xDimantion, int yDimantion, Point2D startingPoint, Point2D endPoint) {

        int totalSteps = calculateSteps(startingPoint.getX(), endPoint.getX()) + calculateSteps(startingPoint.getY(), endPoint.getY());

        return "It requires " + totalSteps + " to reach the end point";
    }

    private static int calculateSteps(int starting, int ending) {
        int steps = 0;

        if (starting - ending > 0) {
            while (starting != ending) {
                starting--;
                steps++;
            }
            return steps;
        }
        else if (starting - ending < 0) {
            while (starting != ending) {
                starting++;
                steps++;
            }
            return steps;
        }
        else {
            return steps;
        }
    }
}
