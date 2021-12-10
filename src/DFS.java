import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DFS extends Puzzle {
	
	private Map<String, Boolean> visited_list;
	private Stack<String> S;
	ArrayList<String> neighbours;
	Map<String, Boolean> moves;
	String current_state;

	public void DFS(String start_state) {
		/* The purpose of this function is to take a
		 * start state and, using depth-first-search, 
		 * return every possible legal state */
		
		//stores the visited value of each puzzle state
		visited_list = new HashMap<String, Boolean>();
		//the frontier of the DFS algorithm
		S = new Stack();
		//push the start node to the stack
		S.push(start_state);
		//set the first start state to not visited
		visited_list.put(start_state, false);
		
		//while the stack is not empty...
		while(!S.isEmpty()) {
			//set the current state to the state at the top of the stack
			current_state = S.pop().toString();
			System.out.println("Finding the neighbours for " + current_state);
			//if the current state has not been visited
			if (!visited_list.get(current_state)) {
				//set the current state to visited
				visited_list.put(current_state,true);
				//for each adjacent neighbour of the current_state...
				for(String neighbour: getNeighbours(current_state)) {
					//System.out.println("Neighbour = " + neighbour);
					if(neighbour != null) {
						//... add it to the stack
						S.push(neighbour.toString());
						//make sure the state is set to unvisited
						if(!visited_list.containsKey(neighbour.toString())) {
							visited_list.put(neighbour.toString(), false);
						}
					}
				}
			}
		}
		System.out.println("Search complete, writing result of R(S1) and R(S2) to file...");
		System.out.println("The result for part c is :\n");
		System.out.println(" ");
		System.out.println("The result for part d is :\n");
		System.out.println(" ");
		System.out.println("The result for part e is :\n");
		System.out.println(" ");
		System.out.println("The result for part f is :\n");
		System.out.println(" ");
	}
	
	public void test(String state) {
		// this is to test the legal states functionality
		getNeighbours(state);
	}
	
	private String[] getNeighbours(String state) {
		/* The purpose of this function is to return 
		 * the adjacent neighbours of the current state
		 * based on the legal rules defined in the 8-puzzle 
		 * game we are applying the DFS algorithm to */
		
		//define the array list of neighbours
		neighbours = new ArrayList<String>();
		
		//define all possible legal moves for a given state
		moves = new HashMap<String, Boolean>();
		moves.put("up", false);
		moves.put("down", false);
		moves.put("left", false);
		moves.put("right", false);
		
		//define the location of the blank tile
		int row_index;
		int col_index;
		
		//check the location of the black tile
		try {
			/* REMOVE THIS */
			String[] rows = state.split(";"); //if correctly formatted, will produce an array of rows of the 3x3 grid
			row_index = 0;
			col_index = 0;
			for(String row : rows) {
				row_index = row_index + 1;
				if(row.contains("_")) { //if the row contains the blank tile
					col_index = row.indexOf("_"); //get the index of the blank tile, add 1 to make it interpretable
					break;
				}
			}
			
			//remove the redundancy
			row_index = row_index - 1;
			
			//debug
			//System.out.println("Location of the blank " + row_index + " , " + col_index);
			/* NO REAL USE FOR THIS */
			
			
			
			
			
			//here row 1,2,3 in the 8 puzzle is denoted as 0,1,2 since indexing with arrays starts at 0
			
			
			//now define each possible legal rule for the current state
			if(row_index != 0) {
				moves.put("up", true); //legal rule #1, if the blank is not in the top row, then the blank can move up
			}
			if(row_index != 2) {
				moves.put("down", true); //legal rule #2, if the blank is not in the bottom row, then the blank can move down
			}
			if(col_index != 0) {
				moves.put("left", true); //legal rule #3, if the blank is not in the first column, then the blank can move left
			}
			if(col_index != 2) {
				moves.put("right", true); //legal rule #4, if the blank is not in the last column, then the blank can move right
			}
			
			//make the legal moves, producing the neighbours at each turn
			for(String move : moves.keySet()) {
				if(moves.get(move)) {
					switch(move) {
					case "left":
						String moved_left = moveLeft(state, row_index, col_index);
						//System.out.println("Left move has produced " + moved_left + " ....adding to neighbours...");
						neighbours.add(moved_left); //moves the blank left, creating a new neighbour
						break;
					case "up":
						String moved_up = moveUp(state, row_index, col_index);
						//System.out.println("Up move has produced " + moved_up + " ....adding to neighbours...");
						neighbours.add(moved_up); //moves the blank up
						break;
					case "right":
						String moved_right = moveRight(state, row_index, col_index);
						//System.out.println("Right move has produced " + moved_right + " ....adding to neighbours...");
						neighbours.add(moved_right); //moves the blank right
						break;
					case "down":
						String moved_down = moveDown(state, row_index, col_index);
						//System.out.println("Down move has produced " + moved_down + " ....adding to neighbours...");
						neighbours.add(moved_down); //moves the blank down, adding an independent state to the neighbours arraylist
						break;
					default:
						break;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.println("Returning added neighbours for DFS");
		//neighbours have been found, return them...
		return neighbours.toArray(new String[0]);
	}
	
}
