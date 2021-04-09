package prisoners_dilemma;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;

public class RunBattleground {
	
	static ArrayList<Algorithm> competitors = new ArrayList<Algorithm>();
	public int[] scores;
	static ArrayList<Result> results = new ArrayList<Result>();
	

	public void makeList() {
		competitors.add(new NeverForgive());
		competitors.add(new TitForTat());
		competitors.add(new TitForTwoTats());
		competitors.add(new TitForTatEvil());
		//competitors.add(new Random());
		competitors.add(new Defect());
	}
	
	public void runBattles() {
		scores = new int[competitors.size()];
		
		for (Algorithm a : competitors) {
			for (Algorithm b : competitors) {
				if (!a.equals(b)) {
					RunSimulation rs = new RunSimulation(a, b);
					scores[competitors.indexOf(a)] += rs.aPoints;
					scores[competitors.indexOf(b)] += rs.bPoints;
				}
			}
		}
		
		rankAlgorithms();
	}
	
	public void rankAlgorithms() {
		double totalPoints = 0;
		
		for (int j = 0; j < scores.length; j++) {
			totalPoints += scores[j];
		}
		
		for (int i = 0; i < scores.length; i++) {
			Result res = new Result();
			res.name = competitors.get(i).getClass().getName().substring(18);
			res.points = scores[i];
			res.winPercent = round(((double)scores[i] / totalPoints) * 100, 2) + "%";
			
			results.add(res);
		}
		Collections.sort(results);
		
		makeScoreReport();
	}
	
	public void makeScoreReport() {
		
		
		
		String returnString = "";
		for (int i = 0; i < results.size(); i++) {
			System.out.format("%-3s %-16s |", i + 1 + ".", results.get(i).name);
			System.out.format("%7d |", results.get(i).points);
			System.out.format("%-8s", results.get(i).winPercent);
			System.out.println();
		}
		System.out.println(returnString);
	}
	
	private static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	
	public static void main(String[] args) {
		RunBattleground rbg = new RunBattleground();
		rbg.makeList();
		rbg.runBattles();
	}

}
