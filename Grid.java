
public class Grid {
	
	// The array of cells used by this grid
	private Cell[][] cells;

	/** Initialize the grid with an array of cells, with the
	 * specified width and height. All cells in the array should
	 * have all four walls (i.e. all instance variables) set to "true".
	 * 
	 * If either of the width or height are less than or equal to zero, 
	 * throw an IllegalArgumentException.
	 * 
	 * @param width The desired width of the grid
	 * @param height The desired height of the grid
	 */
	public Grid(int width, int height) {
		 if (width <= 0 || height <= 0) {
		        throw new IllegalArgumentException();
		    }
		 
		 cells = new Cell[height][width];
		 for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                cells[i][j] = new Cell();
            }
		}
	}
	
	/** Initialize the grid with a given array of cells.
	 * 
	 * If the array is of size zero in any dimension, throw an
	 * IllegalArgumentException.
	 * 
	 * The constructor should check whether the borders of the cells
	 * are valid, and throw an IllegalArgumentException if not.
	 * 
	 * @param cells The array of cells to use for the grid
	 */
	public Grid(Cell[][] cells) {
		this.cells = cells; 
		
		if (getHeight() == 0 || getWidth() == 0) {
	        throw new IllegalArgumentException();
	    }
		
		if (bordersAreValid()) {
	        throw new IllegalArgumentException();
	    }
		
		
	}
	
	public int getHeight() {
		return cells.length;
	}
	
	public int getWidth() {
		return cells[0].length;
	}
	
	public Cell getCell(int x, int y) {
		return cells[y][x];
	}
	
	/** Check that the borders of each cell are consistent with
	 * its neighbours. For instance, if a cell has no east wall,
	 * then its neighbour to the east should have no *west* wall.
	 * 
	 * Specifically: for every cell in the grid, and for every direction,
	 * the cell may have a wall in that direction if the wall 
	 *is on the edge of the grid, and must have a wall in that direction if its neighbour
	 * in that direction has a corresponding wall.
	 * 
	 * @return Whether the cells in the grid have valid border values.
	 */
	public boolean bordersAreValid() {
		boolean validBorders = false;
		for (int i=0; i<getWidth(); i++) {
            for (int j=0; j<getHeight(); j++) {
            	if (j == 0 & i!= getWidth()-1 & i!=0){
            		if(cells[0][i].hasEast() == cells[0][i+1].hasWest()
            		&& cells[0][i].hasWest() == cells[0][i-1].hasEast()
            		&& cells[0][i].hasSouth() == cells[1][i].hasNorth()) {
            		validBorders = true;

            	   }
              	}

            	
            	if (i == 0 & j!= getHeight()-1 & j!=0){
            		if(cells[j][0].hasEast() == cells[j][1].hasWest()
            		&& cells[j][0].hasSouth() == cells[j+1][0].hasNorth()
            		&& cells[j][0].hasNorth() == cells[j-1][0].hasSouth()){
            		validBorders = true;

            	    }
        
            	}
            
            	
            	
            	if (i > 0 & j > 0 & i < getWidth()-1 & j < getHeight()-1){
            		if (cells[j][i].hasEast() == cells[j][i+1].hasWest()
            		&& cells[j][i].hasWest() == cells[j][i-1].hasEast() 	
            		&& cells[j][i].hasSouth() == cells[j+1][i].hasNorth() 
            		&& cells[j][i].hasNorth() == cells[j-1][i].hasSouth()) {
            		validBorders = true;

            		}	
            	}	
            	
            	
            	if (j == getHeight()-1 & i!= getWidth()-1 & i!=0){
            		if(cells[getHeight()-1][i].hasEast() == cells[getHeight()-1][i+1].hasWest()
            		&& cells[getHeight()-1][i].hasWest() == cells[getHeight()-1][i-1].hasEast()
            		&& cells[getHeight()-1][i].hasNorth() == cells[getHeight()-2][i].hasSouth()){
            			validBorders = true;

            	   }
            		
            	}
            	
            	if (i == getWidth()-1 & j!= getHeight()-1 & j!=0){
            		if(cells[j][getWidth()-1].hasWest() == cells[j][getWidth()-2].hasEast()
            		&& cells[j][getWidth()-1].hasSouth() == cells[j+1][getWidth()-1].hasNorth()
            		&& cells[j][getWidth()-1].hasNorth() == cells[j-1][getWidth()-1].hasSouth()){
            			validBorders = true;

            	        	    }
            		
            	}
		}
     }
		return validBorders;
	}

	/** "Carve" a corridor from one cell (with coordinates x1 and y1)
	 * to another (with coordinates x2 and y2).
	 * The two cells must be adjacent.
	 * (i.e., They must be either horizontally or vertically next to each
	 * other.)
	 * 
	 * Both cells should have their touching walls removed.
	 * 
	 * (e.g. If the first cell is to the west of the second, then
	 * it should have its east wall removed; and the second cell
	 * should have its west wall removed.)
	 * 
	 * If the cells are not adjacent, throw an IllegalArgumentException.
	 * 
	 * @param x1 X coordinate of the first cell
	 * @param y1 Y coordinate of the first cell
	 * @param x2 X coordinate of the second cell
	 * @param y2 Y coordinate of the second cell
	 */
	public void carveCorridor(int x1, int y1, int x2, int y2) {
		Cell cell1 = getCell(x1, y1);
		Cell cell2 = getCell(x2, y2);
		if (y2 == y1+1) {
			cell1.setSouth(false);
			cell2.setNorth(false);
		}
		else if (y1 == y2+1) {
			cell1.setNorth(false);
			cell2.setSouth(false);	
		}
		else if (x2 == x1+1) {
			cell1.setEast(false);
			cell2.setWest(false);
		}
		else if (x1 == x2+1) {
			cell1.setWest(false);
			cell2.setEast(false);
		}
		else {
	        throw new IllegalArgumentException();
		}
	}
	

}
