
import java.util.HashSet;
import java.util.Random;




public class MazeBuilder {
	
	public final static int NORTH = 0;
	public final static int EAST  = 1;
	public final static int SOUTH = 2;
	public final static int WEST  = 3;
	
	public final static int[] directions() {
		return new int[] {NORTH, EAST, SOUTH, WEST };
	}

	// the Grid we build a maze in
	private Grid grid;

	// store the cells we have visited during construction of the
	// maze
	private HashSet<Cell> visitedCells;
	
	// our current "x" position in the grid
	private int x; 
	// our current "y" position in the grid
	private int y; 
	
	
	/** Given an array of ints, return a new array containing
	 * the same ints, shuffled into random order.
	 * 
	 * @param arr The array to be shuffled
	 * @return A new array of shuffled ints
	 */
	public static int[] shuffle(int[] arr) {
		Random r = new Random();
        int shuffledArray[] = new int[arr.length];
		int i = 0;
		do{
			int index = i + r.nextInt(arr.length-i);
		    int temp = arr[i];
		    arr[i] = arr[index];
		    arr[index] = temp;
		    i++;
		    for (int j = 0; j < arr.length; j++) {
	           shuffledArray[j] = arr[j];
		    }
		} while(i < arr.length);
		
		return shuffledArray;
 
		
	}
	
	/** Returns a boolean indicating whether our current x and y
	 * coordinates are within the bounds of the Grid instance
	 * variable.
	 * 
	 * If our coordinates are within the bounds of the grid, return true,
	 * otherwise, return false.
	 * 
	 * @return Whether our position is within the grid bounds
	 */
	public boolean withinGridBounds() {
		if (x >= 0 && x < grid.getWidth()  && y >= 0 && y < grid.getHeight()) {
			return true;
		}
        else { 
        	return false;
        }
	}
	
	// move one cell north, by adjusting
	// our coordinates
	private void moveNorth() {
		y = y - 1;
	}

	// move one cell east, by adjusting
	// our coordinates
	private void moveEast() {
		x = x + 1;	
	}
	
	// move one cell south, by adjusting
	// our coordinates
	private void moveSouth() {
		y = y+1;	
	}
	
	// move one cell west, by adjusting
	// our coordinates
	private void moveWest() {
		x = x - 1;	
	}
	
	/** Return a boolean indicating whether we have already visited
	 * the cell with out current x and y coordinates --
	 * that is, return true of the visitedCells set does contain
	 * the cell at our current coordinates, and false if it does not.
	 * 
	 * @return Whether we have already visited the cell at our
	 *   current x and y coordinates
	 */
	public boolean alreadyVisited() {
		 if (visitedCells.contains(grid.getCell(x, y)))
		    {
		        return true;
		    }   
		 else {
			 return false;
		 }
	}

	
	/** Build a path from our current position, recursively
	 * calling buildPath until the whole grid has been visited.
	 * 
	 */
	public void buildPath() {
		
		visitedCells.add( grid.getCell(x, y));
		int[] shuffledDirections = shuffle(directions());
		
		for (int dir : shuffledDirections) {
			int lastX = x;
			int lastY = y;
			
			switch (dir) {
			case NORTH:
				moveNorth();
				break;
			case EAST:
				moveEast();
				break;
			case SOUTH:
				moveSouth();
				break;
			case WEST:
				moveWest();
				break;
			default:
				throw new IllegalStateException("invalid direction " + dir);
			}
			
			if (withinGridBounds() && ! alreadyVisited()) {
				grid.carveCorridor(lastX, lastY, x, y);
				buildPath();
				x = lastX;
				y = lastY;
			} else {
				x = lastX;
				y = lastY;
			}
		}
	}

	/** Initialize the instance variables of this MazeBuilder object.
	 * A new Grid object with the specified width and height should be
	 * constructed; visitedCells should be initialized with an
	 * empty HashSet; and x and y should be set to 0.
	 * 
	 * @param width The desired width of the maze
	 * @param height The desired height of the maze
	 */
	public MazeBuilder(int width, int height) {
		grid = new Grid(width, height);
		visitedCells = new HashSet<Cell>();
		x = 0;
		y = 0;
	}

	/**
	 * @return the grid
	 */
	public Grid getGrid() {
		return grid;
	}
	
	/** Build a maze with the specified height and width,
	 * and print out a string-based depiction of its structure.
	 * 
	 * @param width The desired width of the maze
	 * @param height The desired height of the maze
	 */
	public static void sampleRun(int width, int height) {
		MazeBuilder mb = new MazeBuilder(width, height);
		mb.buildPath();
		Grid g = mb.getGrid();
		Displayer d = new Displayer(g);
		String s =  d.displayAsString();
		System.out.println(s);
	}

}
