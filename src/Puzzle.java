
public class Puzzle {
	
	//private DFS dfs;
	
	public Puzzle() {
		//dfs = new DFS();
	}

	public static void main(String[] args) {
		// define given states S1 and S2
		String S1 = "abc;def;gh_";
		String S2 = "_eb;ahc;dgf";

		DFS dfs = new DFS();
		
		//dfs.test("abc;def;gh_");
		
		//execute algorithm
		dfs.DFS(S1);
		//dfs.DFS(S2);
		
		// !! answers to part a,b,c,d,e,f go here !!
		
	}
	
	public String moveUp(String state, int row_index, int col_index) {
		/* The purpose of this function is to move the blank tile
		 * upwards. Given the location of the tile, such that
		 * (n,m) is the location of the blank tile in the grid,
		 * we swap the value in (n,m) with (n-1,m) 
		 * row_index and col_index are the index of the blank tile
		 * in the grid. State is a String formatted as is valid 
		 * (e.g. abc;d_e;fgh) 
		 * Returns null otherwise */
		
		//System.out.println("Moving " + state + " Up.");
		
		//check that this is a legal move
		if(row_index != 0) {
			
			String new_state = null;
			
			//remove all semi-colons from the string to make it easier to manipulate (giving e.g. abcd_efgh)
			state = state.replaceAll(";", ""); 
			

			//find the index of the blank corresponding to the unformatted puzzle
			int index_of_blank = 0;
			
			if(row_index == 0) {
				index_of_blank = row_index + col_index;
			} else if(row_index > 0) {
				index_of_blank = (row_index * 3) + col_index;
			}

			
			//turn the string into a character array so that we can manipulate it
			char[] state_chars = state.toCharArray();
			state_chars[index_of_blank] = state_chars[index_of_blank - 3];
			state_chars[index_of_blank - 3] = '_';
			
			//re-format the output to include a semi-colon to seperate the columns (every 3 chars, add a semicolon)
			try {
			String rejoined = String.valueOf(state_chars);
			String row1 = rejoined.substring(0,3);
			String row2 = rejoined.substring(3,6);
			String row3 = rejoined.substring(6,9);
			new_state = row1 + ";" + row2 + ";" + row3;
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
			
			//turn the char array back into a string and return it
			return new_state;
		}
		return null;
	}
	
	public String moveDown(String state, int row_index, int col_index) {
		/* The purpose of this function is to move the blank tile
		 * downwards. Given the location of the tile, such that
		 * (n,m) is the location of the blank tile in the grid,
		 * we swap the value in (n,m) with (n+1,m) row_index and col_index are the index of the blank tile
		 * in the grid. 
		 * Returns null otherwise. */
		
		//System.out.println("Moving " + state + " Down.");
		
		//check that this is a legal move
		if(row_index != 2) {
		
			String new_state = null;
			
			//remove all semi-colons from the string to make it easier to manipulate (giving e.g. abcd_efgh)
			state = state.replaceAll(";", ""); 
			

			//find the index of the blank corresponding to the unformatted puzzle
			int index_of_blank = 0;
			
			if(row_index == 0) {
				index_of_blank = row_index + col_index;
			} else if(row_index > 0) {
				index_of_blank = (row_index * 3) + col_index;
			}
			
			//turn the string into a character array so that we can manipulate it
			char[] state_chars = state.toCharArray();
			state_chars[index_of_blank] = state_chars[index_of_blank + 3];
			state_chars[index_of_blank + 3] = '_';
			
			//re-format the output to include a semi-colon to seperate the columns (every 3 chars, add a semicolon)
			try {
				String rejoined = String.valueOf(state_chars);
				String row1 = rejoined.substring(0,3);
				String row2 = rejoined.substring(3,6);
				String row3 = rejoined.substring(6,9);
				new_state = row1 + ";" + row2 + ";" + row3;
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
			
			//turn the char array back into a string and return it
			return new_state;
		}
		return null;
	}
	
	public String moveLeft(String state, int row_index, int col_index) {
		/* The purpose of this function is to move the blank tile
		 * left. Given the location of the tile, such that
		 * (n,m) is the location of the blank tile in the grid,
		 * we swap the value in (n,m) with (n,m-1) row_index and col_index are the index of the blank tile
		 * in the grid. 
		 * Returns null otherwise. */
		
		//System.out.println("Moving " + state + " Left.");
		
		//check if this is a legal move or not
		if(col_index != 0) {
			
			String new_state = null;
			
			//remove all semi-colons from the string to make it easier to manipulate (giving e.g. abcd_efgh)
			state = state.replaceAll(";", ""); 
			

			//find the index of the blank corresponding to the unformatted puzzle
			int index_of_blank = 0;
			
			if(row_index == 0) {
				index_of_blank = row_index + col_index;
			} else if(row_index > 0) {
				index_of_blank = (row_index * 3) + col_index;
			}
			
			//turn the string into a character array so that we can manipulate it
			char[] state_chars = state.toCharArray();
			state_chars[index_of_blank] = state_chars[index_of_blank - 1];
			state_chars[index_of_blank - 1] = '_';
			
			//re-format the output to include a semi-colon to seperate the columns (every 3 chars, add a semicolon)
			try {
				String rejoined = String.valueOf(state_chars);
				String row1 = rejoined.substring(0,3);
				String row2 = rejoined.substring(3,6);
				String row3 = rejoined.substring(6,9);
				new_state = row1 + ";" + row2 + ";" + row3;
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
			
			//turn the char array back into a string and return it
			return new_state;
		}
		return null;
	}
	
	public String moveRight(String state, int row_index, int col_index) {
		/* The purpose of this function is to move the blank tile
		 * right. Given the location of the tile, such that
		 * (n,m) is the location of the blank tile in the grid,
		 * we swap the value in (n,m) with (n,m+1) row_index and col_index are the index of the blank tile
		 * in the grid. 
		 * Returns null otherwise. */
		
		//System.out.println("Moving " + state + " Right.");
		
		//check if this is a legal move or not
		if(col_index != 2) {
			
			String new_state = null;
			
			//remove all semi-colons from the string to make it easier to manipulate (giving e.g. abcd_efgh)
			state = state.replaceAll(";", ""); 
			
			//find the index of the blank corresponding to the unformatted puzzle
			int index_of_blank = 0;
			
			if(row_index == 0) {
				index_of_blank = row_index + col_index;
			} else if(row_index > 0) {
				index_of_blank = (row_index * 3) + col_index;
			}
			
			//turn the string into a character array so that we can manipulate it
			char[] state_chars = state.toCharArray();
			state_chars[index_of_blank] = state_chars[index_of_blank + 1];
			state_chars[index_of_blank + 1] = '_';
			
			//re-format the output to include a semi-colon to seperate the columns (every 3 chars, add a semicolon)
			try {
				String rejoined = String.valueOf(state_chars);
				String row1 = rejoined.substring(0,3);
				String row2 = rejoined.substring(3,6);
				String row3 = rejoined.substring(6,9);
				new_state = row1 + ";" + row2 + ";" + row3;
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
			
			//turn the char array back into a string and return it
			return new_state;
		}
		return null;
	}
}
