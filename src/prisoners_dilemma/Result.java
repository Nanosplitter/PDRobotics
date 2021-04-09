package prisoners_dilemma;

public class Result implements Comparable<Result>{
	public String name;
	public int points;
	public String winPercent;
	
	@Override
	public int compareTo(Result o) {
		if (points > o.points) {
			return -1;
		} else if (points == o.points) {
			return 0;
		} else {
			return 1;
		}
		
	}
}
