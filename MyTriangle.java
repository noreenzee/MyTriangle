//Noreen Akhtar
package mytriangle;

import java.util.Scanner;


public class MyTriangle
{
    //check if triangle is valid
    public static boolean isValid(double sidea, double sideb, double sidec)
    {
        double max = Math.max(sidea, Math.max(sideb, sidec));
        double sumOfOtherSides = sidea + sideb + sidec - max;
        return sumOfOtherSides > max;
    }
    
    //method call to calculate the area of the triangle 
    public static double area(double sidea, double sideb, double sidec)
    {
        double side = (sidea + sideb + sidec) / 2;
        return Math.sqrt(side * (side - sidea) * (side - sideb) * (side -sidec));
        
    }
    //method call to determine the type of triangle
    public static String triangletType(double a, double b, double c)
    {
        if (!isValid(a, b, c))
        {
            return "Invalid Triangle";
        }
        else if (a == b && b == c)
        {
            return "Equilateral";
        }
        else if (a == b || b == c || a ==c)
        {
            return "Isosceles";
        }
        else
        {
            return "Scalene";
        }
    }

   
    public static void main(String[] args)
    {
        Scanner tri = new Scanner(System.in);
        
        // Get User Input
        System.out.println("Enter the first side of the triangle:");
        double side1 = tri.nextDouble();
        System.out.println("Enter the second side of the triangle:");
        double side2 = tri.nextDouble(); 
        System.out.println("Enter the third side of the triangle:");
        double side3 = tri.nextDouble();
        
        //Sort sides
        double[] sides = {side1, side2, side3};
        java.util.Arrays.sort(sides);
        
        //Determine triangle type
        String type = triangletType(sides[0], sides[1], sides[2]);
        System.out.println("Triangle type:" + type);
        
        //Calculate the area of triangle
        if (type.equals("Invalid Triangle"))
        {
            double triangleArea = area(sides[0], sides[1], sides[2]);
            System.out.println("Area of Triangle: " + triangleArea );
        }
        tri.close();
    }
    
}
