/* 
This Program is designed to calculate the area of a square
AreaSquare.java

Designed by Jack Larkin

Method:
Variable(s):
a = side - int
area_square = side * side - int

*/

public class AreaSquare{

     public static void main(String []args){
        System.out.println("This program will display the area of a square.");
        
        int a,area_square;
        
        a = 10;
        area_square = a*a;
        
        System.out.println("The area of the square is "+area_square);
     }
}

/*
$javac AreaSquare.java
$java -Xmx128M -Xms16M AreaSquare
This program will display the area of a square.
The area of the square is 100
*/