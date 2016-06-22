package imageprocessing;

/**
 *
 * @author Valentino Muiruri 
 * Program that flips and rotates any 2-D arrays.
 * able to do 4 transformations. vertical, horizontal, rotate right, and rotate
 * left.
 */
public class ArrayTransformations {

    public static void horizontalFlip(int[][] pixels) {
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length/2; j++) {
                int temp = pixels[i][j];
                int oppositeColumn = pixels[i].length-j-1;
                pixels[i][j] = pixels[i][oppositeColumn];
                pixels[i][oppositeColumn] = temp;
            }
        }
    }
    public static void diagonalFlip(int[][] pixels) {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = pixels[i];
            for (int j = 0; j < pixels[0].length; j++) {
                pixels[i][j] = pixels[pixels.length - j][i];
            }
        }

    }
    public static void verticalFlip(int[][] pixels) {
        for (int i = 0; i < pixels.length/2; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                int temp = pixels[i][j];
                int oppositeRow = pixels.length-i-1;
                pixels[i][j] = pixels[oppositeRow][j];
                pixels[oppositeRow][j] = temp;
            }
        }
    }
    
    public static int[][] rotateRight(int[][] pixels) {
        int[][] temp = new int[pixels[0].length][pixels.length];
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                temp[j][pixels.length-1-i] = pixels[i][j];
            }
        }
        return temp;
    }

    public static int[][] rotateLeft(int[][] pixels) {
        int[][] temp = new int[pixels[0].length][pixels.length];
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                temp[j][pixels.length-1-i] = pixels[pixels.length - 1 - i][j];
            }
        }
        return temp;
    }
    /*
 * A simple class that tests the methods in ArrayTransformations without using graphics.
 * Provided for Assignment 1, CISC 124, Winter 2015
 * Queen's University, M. Lamb
 */
    
    // Prints a two-dimensional array of integers.  Columns will line up as long
    // as the rows aren't too long and the values don't take more than 4 characters each.
    public static void printArray(int array[][]) {
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                // printf is a formatted printing method.  You aren't required to know about it.
                // The line below prints array[row][column], padding with blanks to 5 characters.
                System.out.printf("%5d", array[row][column]);
            } // end for
            System.out.println();
        } // end for
    } // end printArray
    
    
    public static void main(String args[]) {
        
        // A small 2D array of integers for testing
        int testArray[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        
        System.out.println("THE TESTING ARRAY:");
        printArray(testArray);
        
        ArrayTransformations.horizontalFlip(testArray);
        System.out.println("THE TESTING ARRAY:");
        printArray(testArray);
        
        ArrayTransformations.diagonalFlip(testArray);
        System.out.println("AFTER diagonalFlip:");
        printArray(testArray);   
        // flip again to restore to original state
        ArrayTransformations.horizontalFlip(testArray);
   
        ArrayTransformations.verticalFlip(testArray);
        System.out.println("AFTER VERTICAL FLIP:");
        printArray(testArray);   
        // flip again to restore to original state
        ArrayTransformations.verticalFlip(testArray);
        
        int clockwise[][] = ArrayTransformations.rotateRight(testArray);
        System.out.println("ROTATED RIGHT:");
        printArray(clockwise);
        
        int counterClockwise[][] = ArrayTransformations.rotateLeft(testArray);
        System.out.println("ROTATED LEFT:");
        printArray(counterClockwise);
        
        System.out.println("ORIGINAL ARRAY -- SHOULD NOT BE CHANGED BY ROTATIONS");
        printArray(testArray);
        

    
        
      
    } // end main
} // end class


