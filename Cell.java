/** A cell in a grid, which may have up to four walls, on the north,
 * east, south and west, each represented by a boolean.
 */
public class Cell {
	
	private boolean north;
	private boolean east;
	private boolean south;
	private boolean west;
	
	/** Construct a Cell, using the parameters given to initialize
	 * the wall instance variables.
	 * 
	 * @param north
	 * @param south
	 * @param east
	 * @param west
	 */
	public Cell(boolean north, boolean east, boolean south, boolean west) {
		this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
	}

	/** Construct a Cell, with all booleans set to "true".
	 * 
	 */
	public Cell() {
		this.north = true;
        this.east  = true;
        this.south = true;
        this.west  = true;
	}


	/**
	 * @return Whether there is a wall on the north side
	 */
	public boolean hasNorth() {
	    	return this.north;	    
	}
		

	/** Set whether there is a wall on the north side to a specified value
	 * @param north the value to set
	 */
	public void setNorth(boolean north) {
        this.north = north;
	}

	/**
	 * @return Whether there is a wall on the south side
	 */
	public boolean hasSouth() {
    	return this.south;	    
    }

	/** Set whether there is a wall on the south side to a specified value
	 * @param south the value to set
	 */
	public void setSouth(boolean south) {
        this.south = south;
	}

	/**
	 * @return Whether there is a wall on the east side
	 */
	public boolean hasEast() {
    	return this.east;	    
	}

	/** Set whether there is a wall on the east side to a specified value
	 * @param east the value to set
	 */
	public void setEast(boolean east) {
        this.east = east;
	}

	/**
	 * @return Whether there is a wall on the west side
	 */
	public boolean hasWest() {
    	return this.west;	    
	}

	/**  Set whether there is a wall on the west side to a specified value
	 * @param west the value to set
	 */
	public void setWest(boolean west) {
        this.west = west;
	}


}
