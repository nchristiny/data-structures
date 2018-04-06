package projects.breadth;

import java.io.*;         
import java.util.Scanner;
import collections.list.generics.Queue;

public class BMaze
{
	
	protected int numRows;        
	protected int numCols;        

	protected int startRow;
	protected int startCol;
	protected int endRow;
	protected int endCol;

	protected BufferedReader input;

	protected Cell [][] grid;  
   BDisplay bdisplay;


//************************************************************************************
  // Constructor -- opens files, initializes arrays
	public BMaze(String inputFileName)  throws IOException
	{
      FileReader f = new FileReader(inputFileName);
      input = new BufferedReader(f);
		
		getMaze();
	}
	public void setBDisplay(BDisplay d)
   {
      bdisplay = d;
   }

//************************************************************************************
	public void getMaze() throws IOException
	{
		String line;
		int i, j;
		
		line = input.readLine();
		numRows = Integer.parseInt(line);
		line = input.readLine();
		numCols = Integer.parseInt(line);
		line = input.readLine();
		startRow = Integer.parseInt(line);
		line = input.readLine();
		startCol = Integer.parseInt(line);
		line = input.readLine();
		endRow = Integer.parseInt(line);
		line = input.readLine();
		endCol = Integer.parseInt(line);

		grid = new Cell[numRows][numCols];

  		for (i = 0; i < numRows; i++)
		{
			line = input.readLine();
			for (j = 0; j < numCols; j++)
			{
            grid[i][j] = new Cell(i, j);
            grid[i][j].distance = -1;
				grid[i][j].type = line.charAt(j);
            if( grid[i][j].type == Cell.START )
            {
               startRow = i;
               startCol = j;
            }
            if( grid[i][j].type == Cell.END )
            {
               endRow = i;
               endCol = j;
            }
			}
		}
	} // public Maze()
	
//************************************************************************************
  // This method returns the String representation of the original, unsolved maze.
	public String toString()
	{
		String mazeString = "\n";

//WRITE THIS METHOD--IT RETURNS THE STRING OF THE ORIGINAL, UNSOLVED MAZE.
		return mazeString;
	} // 	public String toString()
			
   public void sleep(int t)
   {
         try
         {
            Thread.sleep(t);
         }
         catch(InterruptedException ie)
         {
            System.out.println(ie);
         }
   }
   
//************************************************************************************
// This method will use a queue to solve the maze.  You will enqueue the start cell
// and then as long as the queue is not empty, dequeue a cell, check if it is the end cell (if 
// it is, you will call generate solution and return the length of the solution).  If it
// is not, you will visit the bordering cells, enqueueing them if they have not been visited.
// and updating the distance array.
	public int solveMaze()
	{
		int i, j;

		Queue<Cell> q = new Queue<Cell>();
      grid[startRow][startCol].distance = 0;
      q.enqueue(grid[startRow][startCol]);
      while( !q.isEmpty() )
      {
         Cell c2 = q.dequeue();
         sleep(100);  //yield to draw thread
         i = c2.i;
         j = c2.j;
         int d = c2.distance + 1;
         if( grid[i+1][j].type != Cell.WALL && 
               grid[i+1][j].distance == -1 )
         {
            grid[i+1][j].distance = d;
            q.enqueue(grid[i+1][j]);
         }
         if( grid[i-1][j].type != Cell.WALL && 
            grid[i-1][j].distance == -1 )
         {
            grid[i-1][j].distance = d;
            q.enqueue(grid[i-1][j]);
         }         
         if( grid[i][j+1].type != Cell.WALL && 
               grid[i][j+1].distance == -1 )
         {
            grid[i][j+1].distance = d;
            q.enqueue(grid[i][j+1]);
         }
         if( grid[i][j-1].type != Cell.WALL && 
               grid[i][j-1].distance == -1 )
         {
            grid[i][j-1].distance = d;
            q.enqueue(grid[i][j-1]);
         }         
      }

      return grid[endRow][endCol].distance;

	}	// 	public int solveMaze()

//************************************************************************************
// This method finds a shortest path from the start cell to the end cell, given the
// filled out distance array.  

	public void generateSolution()
	{
      int i, j;
		int count = grid[endRow][endCol].distance;
      i = endRow;
      j = endCol;
      while( count > 0 )
      {
         grid[i][j].color = 1;
         if( i-1 >= 0 && 
            grid[i-1][j].distance < grid[i][j].distance &&
               grid[i-1][j].type != Cell.WALL)
         {
            i = i - 1;
         }
         else if( i+1 < grid.length && 
               grid[i+1][j].distance < grid[i][j].distance &&
               grid[i+1][j].type != Cell.WALL)
         {
            i = i + 1;
         }
         else if( j+1 < grid[i].length && 
               grid[i][j+1].distance < grid[i][j].distance &&
               grid[i][j+1].type != Cell.WALL)
         {
            j = j + 1;
         } 
         else if( j-1 >= 0 && 
               grid[i][j-1].distance < grid[i][j].distance &&
               grid[i][j-1].type != Cell.WALL)
         {
            j = j - 1;
         }
   		count = grid[i][j].distance;
      }
      grid[i][j].color = 1;
      return;
	} // end public void generateSolution(int i, int j)
//************************************************************************************
} //public class Maze
