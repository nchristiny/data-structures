import java.util.ArrayList;
import java.util.Arrays;

public class RecursionPractice
{
   public static void main(String[] args)
   {
      long nP = numPaths( 12, 12 );
      System.out.println( "Num paths = " + nP );
      
      int n = 9;
      System.out.println( "factorial(" + n + ") is " + factorial(n));
      
      n = 12;
      System.out.println( "fibonacci(" + n + ") is " + fibonacci(n));
      System.out.println( "Recursion count = " + fibCount );
      
      int st = 1;
      int end = 4;
      int sum = sum(st, end);
      System.out.println( "Sum of the numbers from " + st + " to " + end + " is " + sum ); 
      
      towersOfHanoi(3, 1,3,2 );
      
      String[] pal = {"racecart", "racecar", "poiuyuiop", 
         "a", "b", "poiuiuop"};
      for( int i=0; i<pal.length; i++ ) 
      {
         if( isPalindrome(pal[i]) ) 
         {
            System.out.println( pal[i] + " is a palindrome!" );
         }
         else
         {
            System.out.println( pal[i] + " is NOT a palindrome!" );
         }
      }

      int[][] a = {{1,2,3,5,4,6,7,8}, {3,4,5,7,9,10,12}};
      for( int i=0; i<a.length; i++ )
      {
         if( isSorted(a[i]) )
         {
            System.out.println( Arrays.toString(a[i]) + " is sorted!" );
         }
         else
         {
            System.out.println( Arrays.toString(a[i]) + " is NOT sorted!" );
         }
      }
      int[][] s =  new int[3][25];
      for( int i=0; i<s[0].length; i++ ) 
      {
         s[0][i] = (int)(Math.random() * s[0].length * 2);
         s[1][i] = s[0][i];
         s[2][i] = s[0][i];
      }
      s[1] = mergeSort(s[1]);
      System.out.println( "--- Original ---" );
      System.out.println( Arrays.toString(s[0]) );
      System.out.println( "--- merge sort ---" );
      System.out.println( Arrays.toString(s[1]) );
   }
   
   public static long factorial(int n)
   {
      return 0;
   }
   
   public static int fibCount = 0;
   public static long fibonacci(int n)
   {
      fibCount++;
      
      
      return 0;
   }
   
   public static void towersOfHanoi(int n, int start, int end, int aux)
   {
   }
   
   /* sum all values between s and n inclusive */
   /*   you can assume s is less than or equal to n to start */
   public static int sum(int s, int n)
   {
      return 0;
   }
   /* this method is done, it simply calls the recursive method */
   public static boolean isSorted(int[] a)
   {
      return isSortedRec(a, 0, a.length-1);
   }
   /* assume low < high to begin */
   public static boolean isSortedRec( int[] a, int low, int high )
   {
      return false;
   }

   /* this next method is done, it simply calls the recursive method */
   public static boolean isPalindrome(String a)
   {
      return isPalindromeRec(a, 0, a.length()-1);
   }
   public static boolean isPalindromeRec( String a, int low, int high )
   {
      return false;
   }
   public static long numPaths(int r, int c)
   {
      return 0;
   }
   // create new sorted array containing all the values of a
   public static int[] mergeSort(int[] a)
   {
      return null;
   }
   public static int[] merge(int[] x, int[] y)
   {
      return null;
   }
}