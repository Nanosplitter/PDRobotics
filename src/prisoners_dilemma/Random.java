package prisoners_dilemma;

public class Random extends Algorithm{

	public char chooseMove() {	
		return cMoves[rnd.nextInt(2)];
	}
}
