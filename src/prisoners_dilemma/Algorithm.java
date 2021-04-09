package prisoners_dilemma;

import java.util.Random;

public abstract class Algorithm {
	//Make new 100 element array of type char called lastMoves
	static protected char[] lastMoves = new char[100];
	
	//Make new int i (used for incrementing loops)
	static protected int i = 0;
	
	static int myPoints = 0;
	static int enemyPoints = 0;
	
	//A Random object for all of your random needs
	static protected Random rnd = new Random();
	
	//An array of all the possible moves, initially used alongside a random number generator to make a random choice algorithm
	protected static char [] cMoves = {'C', 'D'};
		
	//Constructor
	public Algorithm() {
		//Loops over lastMoves array and initializes all elements to char '0'
		for(i = 0; i < lastMoves.length; i++) {
			lastMoves[i] = '0';
		}
	}
	
	
	public String debugInfo() {
		//Loops over entire lastMoves array and forms a String called "debug" that will allow you to see the array live
		String debug = "";
		for (i = 0; i < lastMoves.length; i++) {
			//If lastMoves[i] is NOT the last element in the array
			if(i < lastMoves.length - 1) {
				//Put a comma after the element
				debug += lastMoves[i] + ", ";
			} else {
				//Do not put a comma after the last element
				debug += lastMoves[i];
			}
		}
		//Returns the debug string so that you can use debugInfo() as a String
		return debug;
	}
	
	protected void cycleList(char move) {
		//Loops over array and pushes each element down one, and adds the most recent move of the enemy to the end
		for(i = 0; i < lastMoves.length; i++) {
			//If lastMoves[i] is NOT the last element in the array
			if (i < lastMoves.length - 1) {
				//Make the element the same as the one after it
				lastMoves[i] = lastMoves[i + 1];
			} else {
				//If the last element, add in the new move
				lastMoves[i] = move;
			}
		}
	}
	
	//RunSimulation.java will call this to report the result of the last simulation. 
	//lastMove is the enemy's last move, 
	//myYears is your total amount of years in prison, 
	//and enemyYears is the enemy's total amount of years in prison.
	public void reportResult(char lastMove, int myPoints, int enemyPoints) {
		//Adding the last move to the end of the array
		cycleList(lastMove);
		
		//Storing the years variables.
		this.myPoints = myPoints;
		this.enemyPoints = enemyPoints;
	}
	
	//This is where you will write your algorithm. RunSimulation calls this method and expects a return of 'C' for cooperate, or 'D' to defect and give up the other prisoner
	public char chooseMove() {
		return cMoves[rnd.nextInt(2)];
	}
	
}
