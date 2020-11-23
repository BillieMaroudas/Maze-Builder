/** Display a grid as a string.
  */
public class Displayer {

	// the grid to be displayed
	private Grid grid;
	
	/** Initialize the Displayer with the Grid provided.
	 */
	public Displayer(Grid grid) {
		this.grid = grid; 	
	}
	
	/** Return the string for the vertical (west- and east-facing) walls in the row of
	 * a grid (with row index = y).
	 * 
	 * Cell bodies should be represented as space characters.
	 * Cell walls should be represented as pipe ("|") characters
	 * if present; otherwise a space should be put in their place.
	 * 
	 * @param y The index of the row to produce a string for
	 * @return The displayed walls as a string
	 */
	public String verticalWalls(int y) {
		String s = "";
		
		for (int x=0; x < grid.getWidth(); x++) {
				if (grid.getCell(x, y).hasWest()) {
					s += ("|");
				} else {
					s += (" ");
				}
				s += (" ");
				if (x == grid.getWidth()-1) {
					if (grid.getCell(x, y).hasEast()) {
						s += ("|");
					}
					else {
					s += (" ");
					}
				}
				
		}
		return s;		
	}
	
	/** Return the string for the southern walls in the row of
	 * a grid (with row index = y).
	 * 
	 * Cell corners should be represented as "+" signs.
	 * Cell walls should be represented as hyphen ("-") characters
	 * if present; otherwise a space should be put in their place.
	 * 
	 * @param y The index of the row to produce a string for
	 * @return The displayed walls as a string
	 */
	public String horizontalWalls(int y) {
		String s = "";
		
		s += ("+");
		for (int x=0; x < grid.getWidth(); x++) {
				if (grid.getCell(x, y).hasSouth()) {
					s += ("-");
				} else {
					s += (" ");
				}
				s += ("+");
		}
		return s;
	}

	
	/** Return a string displaying the layout of the
	 * our instance variable grid.
	 * 
	 * Cell bodies should be represented as space characters.
	 * Cell walls should be represented as pipe ("|") characters
	 * if present; otherwise a space should be put in their place.
	 * Cell corners should be represented as plus ("+") characters.
	 * 
	 * @return The grid, displayed as a string
	 */
	public String displayAsString() {
		String s = "";
		
		s += ("+");
		for (int x=0; x < grid.getWidth(); x++) {
			if (grid.getCell(x, 0).hasNorth()) {
			  s += ("-");
			} else {
			  s += (" ");
			}
			s += ("+");
		}
		s += ("\n");

		for (int y=0; y < grid.getHeight(); y++) {
			s += verticalWalls(y);
			s += ("\n");
			s += horizontalWalls(y);
			s += ("\n");
		}
				
		return s;
	}


}
