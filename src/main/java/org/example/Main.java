package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.Math.abs;

public class Main {

    static int[] sumNums = {2, 4, 7, 22, 8, 5, 33, 12, 98,  4, 33,  7, 99, 24, 63, 86, 52, 39};
    static int[] simNums = {2, 1, 6, 22, 8, 5, 12, 98,  4, 33,  7, 99, 18, 24, 86, 63, 52};
    static int[] sortNums = {3, -2, 7, 1, 4, -4, 6, 9, -8, 5, 0};
    static boolean asc = true;
    static boolean desc = false;
    static int[][] matrix = {{5, 33, 14}, {55, 29, 6},{7, 18, 11}};

    public static void main(String[] args) {

        System.out.println("Sum of integers in array: " + ex1(sumNums));

        ex2(6);

        System.out.println("Max Diff between adjacent elements = " + ex3(sumNums));

        ex4(sumNums, simNums);

        ex5(sortNums, asc);
        ex5(sortNums, desc);

        ex7(7);

        System.out.println(ex8(11));

        System.out.println("Is " + -1 + " Prime? : " + ex9(-1));
        System.out.println("Is " + 7 + " Prime? : " + ex9(7));
        System.out.println("Is " + 88 + " Prime? : " + ex9(88));
        System.out.println("Is " + 41 + " Prime? : " + ex9(41));
        System.out.println("Is " + 2 + " Prime? : " + ex9(2));
        System.out.println("Is " + 71 + " Prime? : " + ex9(71));
        System.out.println("Is " + 3 + " Prime? : " + ex9(3));

        ex10(matrix) ;  // print max and min values within matrix

        // TODO more to add tomorrow

        ex14(656565);
        ex14(10205);
        ex14(321125);

    }

    public static void ex14(int num) {
        // Reverse any given number with arithmetic operations ?
        // example: given INTEGER "123", return INTEGER "321"  (don't use string operations)

        int exp = 0; int n = num; double sum=0;
        ArrayList<Integer> digits = new ArrayList<>();

        while ( n >= 1 ) {
            exp++;
            digits.addLast(n - (n/10 * 10));
            n=n/10;
        }
        for (Integer digit : digits) {
            sum = sum + digit * Math.pow(10, --exp);
        }
        System.out.println((int) sum);
    }

    public void ex13() {
        // Logic to count # of occurrences of chars in a string ?
        // TODO: tomorrow - I've done this one already
    }

    public void ex12() {
        // Eliminate duplicates and print unique numbers in array
        // TODO: tomorrow - I've done this one already
    }

    public void ex11() {
        // Reverse string/palindrome w/o using predefined reverse methods
        // TODO: tomorrow - I've done this one already

    }

    public static void ex10(int [][] matrix) {
        // Print min and max values found in given multidimensional 2D array ( 3 x 3 )

        int max=matrix[0][0]; int min=matrix[0][0];
        for (int j=0; j < matrix.length; j++) { // standard for "outer" loop
            for (int[] ints : matrix) {         // enhanced for "inner" loop
                if (ints[j] > max) {
                    max = ints[j];
                }
                if (ints[j] < min) {
                    min = ints[j];
                }
            }
        }
        System.out.println("Max value in matrix: " + max);
        System.out.println("Min value in matrix: " + min);
    }

    public static boolean ex9(int n) {
        // Check if given number is prime

        if (n < 2) { return false; }            // numbers < 2 are not prime
        if ((n != 2) &&  (n % 2 == 0)) { return false; }              // n != 2 and if even, not prime

        for (int i=n-2; i > 1; i=i-2) {
            if (n % i == 0) { return false; }       // if divisible by any odd number < n, not prime
        }
        return true;        // passed the checks
    }

    public static int ex8(int n) {
        // Print fibonacci F(n) series
        // As defined: F(0)=0, F(1)=1 and F(n)=F(n-1) + F(n-2), for n > 1

        if (n < 0) { return -1; }   // error
        if (n == 0) { return 0; }   // part of the definition
        if (n == 1) { return 1; }   // part of the definition

        // ** use recursion **
        return ex8(n-1) + ex8(n-2);     // fibonacci function is recursive
    }

    public static void ex7(int base) {
        // Given base number, print out pyramid pattern in Java

        for (int j = 0; j < base; j++) {
            for (int k=base-1; k > j; k--){
                System.out.print(" ");
            }
            System.out.print("X");

            for (int i=0; i < j; i++) {
                System.out.print(" X");
            }
            System.out.println();
        }
    }

    public void ex6() {
        // Demonstrate how to swap variables with and without using temp variable
        // TODO: tomorrow
    }

    public static void ex5(int[] a, boolean asc) {
        // Sort a given array in ascending and descending order - don't use built in methods or buffer result array

        for (int j = 0; j < a.length-1; j++) {
            for (int i = 0; i < a.length-1; i++) {

                if ((a[i] > a[i + 1]) && asc) {  // ascending means swap to put lesser value on the left
                    // swap values of adjacent indices in-place
                    a[i] = a[i] + a[i + 1];
                    a[i + 1] = a[i] - a[i + 1];
                    a[i] = a[i] - a[i + 1];
                } else if ((a[i] < a[i + 1]) && !asc) {   // descending means swap to put greater value on left
                    // swap values of adjacent indices in-place
                    a[i] = a[i] + a[i + 1];
                    a[i + 1] = a[i] - a[i + 1];
                    a[i] = a[i] - a[i + 1];
                }
            }
        }

        System.out.println(Arrays.toString(a));
    }

    public static void ex4(int[] arrA, int[] arrB) {
        // Compare values at same indexes in two different arrays and create a third array
        // where values match

        ArrayList<Integer> arrMatch = new ArrayList<>();
        int index=0;
        while ((index < arrA.length) && (index < arrB.length)) {
            if (arrA[index] == arrB[index]) {
                arrMatch.addLast(arrA[index]);
            }
            index++;
        }
        System.out.println("Matching values at same indices: " + arrMatch);
    }

    public static int ex3(int[] a) {
        // Print max difference of adjacent integer elements in a given array

        int maxDiff=0; int currDiff=0;

        for (int i = 0; i < a.length - 1; i++) {    // length - 1 to not go beyond array length in check
            currDiff = (a[i] - a[i+1]);             // check adjacent elements in array
            if (abs(currDiff) > maxDiff){       // check if absolut value of current elements diff > max diff
                maxDiff = abs(currDiff);
            }
        }
        return maxDiff;
    }

    public static void ex2(int num) {
        // Print 5- multiplication tables without using multiply operator
        //  example: 2x1=2, 2x2=4, 2x3=6, 2x4=8, 2x5=10, ... 2x11=22, 2x12=24

        int prod;
        for (int h=0; h < 5; h++){              // do it 5 times starting at the given num
            for (int i = 1; i < 13; i++) {      // table up to including 12
                prod = 0;
                for (int j = 0; j < i; j++) {    // generate product with addition loop
                    prod = prod + num;
                }
                System.out.print("| " + num + "x" + i + "=" + prod + " " );
            }
            System.out.println();
            num++;      // next num
        }
    }

    public static int ex1( int[] a) {
        // Create method which accepts an array and returns the sum of
        // all the elements in the array.
        int sum=0;
        for (int x : a) {       // for each value x in given array a
            sum = sum + x;      // accumulate values of elements
        }
        return sum;
    }
}