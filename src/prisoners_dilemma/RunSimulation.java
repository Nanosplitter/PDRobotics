package prisoners_dilemma;

import java.util.Random;

public class RunSimulation {

	Random rnd = new Random();
	static int cWins = 0;
	static int pWins = 0;
	static int ties = 0;
	static char[] aMoves = { 'C', 'D'};
	static Algorithm algorithmA;
	static Algorithm algorithmB;
	int aPoints = 0;
	int bPoints = 0;
	static char bMove = ' ';
	static char aMove = ' ';

	public RunSimulation(Algorithm robot, Algorithm robotRandom) {
		algorithmA = robot;
		algorithmB = robotRandom;
		for (int i = 0; i < 1000; i++) {
			playGame();
		}
	}

	public void playGame() {
		// Add a little Space
		System.out.println();
		
		// Reset console for next game
		System.out.println("************Next Game************");

		// Set computers' move
		aMove = algorithmA.chooseMove();
		bMove = algorithmB.chooseMove();

		// Display computer's move
		System.out.println("Prisoner A's move: " + aMove);

		// Display algorithm's move
		System.out.println("Prisoner B's move: " + bMove);
		System.out.println();

		// Decide winner
		if (aMove == 'C' && bMove == 'C') {
			aPoints += 4;
			bPoints += 4;
		} else if (aMove == 'C' && bMove == 'D') {
			bPoints += 5;
		} else if (aMove == 'D' && bMove == 'C') {
			aPoints += 5;
		} else if (aMove == 'D' && bMove == 'D') {
			aPoints += 1;
			bPoints += 1;
		} 

		// Report results back to algorithm
		algorithmA.reportResult(bMove, aPoints, bPoints);
		algorithmB.reportResult(aMove, bPoints, aPoints);
		

		// Print out debug info
		//System.out.println("Your lastMoves array: " + algorithmA.debugInfo());
		//System.out.println();
		
		// Print out current score
		//System.out.println("Your Points: " + aPoints + " | " + ((double)aPoints/((double)aPoints + (double)bPoints)) * 100 + "%");
		//System.out.println("Other Points: " + bPoints + " | " + ((double)bPoints/((double)aPoints + (double)bPoints)) * 100 + "%");

		
	}

}
