import java.util.ArrayList;
import java.util.Arrays;

public class RecursionPractice
{
   public static void main(String[] args)
   {
      long nP = numPaths( 6, 5 );
      System.out.println( "Num paths from (6,5) = " + nP );
      nP = numPaths( 12, 12 );
      System.out.println( "Num paths from (12,12) = " + nP );
      nP = numPaths( 13, 13 );
      System.out.println( "Num paths from (13,13) = " + nP );

      int n = 9;
      System.out.println( "factorial(" + n + ") is " + factorial(n));
      
      n = 12;
      System.out.println( "fibonacci(" + n + ") is " + fibonacci(n));
      System.out.println( "Recursion count = " + fibCount );
      
      int st = 1;
      int end = 4;
      int sum = sum(st, end);
      System.out.println( "Sum of the numbers from " + st + " to " + end + " is " + sum ); 
      
      towersOfHanoi(3,1,3,2); // 3 discs, start is post 1, end is post 3 and aux is post 2
      
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
      if (n <= 1) return 1;
      else return factorial(n - 1) * n;
   }
   
   public static int fibCount = 0;
   public static long fibonacci(int n)
   {
      fibCount++;
      
      if (n == 0) return 0;
      if (n == 1) return 1;
      else return fibonacci(n - 1) + fibonacci(n - 2);
   }
   
   public static void towersOfHanoi(int n, int start, int end, int aux)
   {
      /* recursively move n rings from start to end using third "aux" post */
      if (n == 0) return;
      else // n > 0
      {
         // must move n-1 rings before being able to move largest ring 
         towersOfHanoi(n - 1, start, aux, end);
         System.out.println("Move from post# " + start + " to post# " + end);
         towersOfHanoi(n - 1, aux, end, start);
      }
   }
   
   /* sum all values between s and n inclusive */
   /*   you can assume s is less than or equal to n to start */
   public static int sum(int s, int n)
   {
      if (s == n) return 0;
      else return sum(s, n - 1);
   }
   
   /* this method is done, it simply calls the recursive method */
   public static boolean isSorted(int[] a)
   {
      return isSortedRec(a, 0, a.length-1);
   }
   
   /* assume low < high to begin */
   public static boolean isSortedRec( int[] a, int low, int high )
   {
      if (low >= high) return true;
      if(a[low] < a[low + 1]) return isSortedRec(a, low + 1, high);  
      else return false;
   }

   /* this next method is done, it simply calls the recursive method */
   public static boolean isPalindrome(String a)
   {
      return isPalindromeRec(a, 0, a.length()-1);
   }
   
   public static boolean isPalindromeRec( String a, int low, int high )
   {
      if (low >= high - 1) return true;
      if (a.charAt(low) != a.charAt(high)) return false;
      else 
         return isPalindromeRec(a, low + 1, high - 1);
   }
   
   public static long numPaths(int r, int c)
   {
      if (r == 0 && c == 0) return 0;
      if (r == 0 || c == 0) return 1;
      long numPaths = numPaths(r - 1, c) + numPaths(r, c - 1);
      return numPaths;
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