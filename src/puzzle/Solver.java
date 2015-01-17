package puzzle;

import java.util.Calendar;
import java.util.Stack;

public class Solver {

	private Stack<Position> positionsTried = new Stack<Position>();	
	
	public Solver() {

		Position position = new Position(1, 0, -1);
		positionsTried.push(position);
	}
	
	protected boolean findPostions()
	{
//		System.out.println(this.positionsTried);

		Position lastGoodPosition = positionsTried.peek();
		Position nextPosition = findNextPosition();
		
		if (nextPosition != null) {
			this.positionsTried.push(nextPosition);
		}
		
		while (nextPosition == null)
		{
//			System.out.println("Popping");
			positionsTried.pop();
			Position peek = positionsTried.peek();
			peek.setTraveledTo(peek.getTraveledTo() + 1);
			nextPosition = findNextPosition();
		}
		
		if (positionsTried.size() == 64) 
		{
			displaySolution();
			return true;
		}
		
		return false;
	}

	private void displaySolution() {
		
		System.out.println("SOLUTION FOUND");
		System.out.println(this.positionsTried);
	
	}

	private Position findNextPosition() 
	{	
		Position peek = this.positionsTried.peek();
		int x = peek.getX();
		int y = peek.getY();
		int traveledTo = peek.getTraveledTo();
		
		if (traveledTo == -1)
		{
			int xtry = x + 1;
			int ytry = y - 2;
			if (validateTry(xtry, ytry))
			{
				peek.setTraveledTo(1);
				return new Position(xtry, ytry, -1);
			}
			traveledTo = 1;
		}
		if (traveledTo == 1)
		{
			int xtry = x + 2;
			int ytry = y - 1;
			if (validateTry(xtry, ytry))
			{
				peek.setTraveledTo(2);
				return new Position(xtry, ytry, -1);
			}
			traveledTo = 2;

		}
		if (traveledTo == 2)
		{
			int xtry = x + 2;
			int ytry = y + 1;
			if (validateTry(xtry, ytry))
			{
				peek.setTraveledTo(3);
				return new Position(xtry, ytry, -1);
			}
			traveledTo = 3;

		}
		if (traveledTo == 3)
		{
			int xtry = x + 1;
			int ytry = y + 2;
			if (validateTry(xtry, ytry))
			{
				peek.setTraveledTo(4);
				return new Position(xtry, ytry, -1);
			}
			traveledTo = 4;

		}
		if (traveledTo == 4)
		{
			int xtry = x - 1;
			int ytry = y + 2;
			if (validateTry(xtry, ytry))
			{
				peek.setTraveledTo(5);
				return new Position(xtry, ytry, -1);
			}
			traveledTo = 5;

		}
		if (traveledTo == 5)
		{
			int xtry = x - 2;
			int ytry = y + 1;
			if (validateTry(xtry, ytry))
			{
				peek.setTraveledTo(6);
				return new Position(xtry, ytry, -1);
			}
			traveledTo = 6;

		}
		if (traveledTo == 6)
		{
			int xtry = x - 2;
			int ytry = y - 1;
			if (validateTry(xtry, ytry))
			{
				peek.setTraveledTo(7);
				return new Position(xtry, ytry, -1);
			}
			traveledTo = 7;

		}
		if (traveledTo == 7)
		{
			int xtry = x - 1;
			int ytry = y - 2;
			if (validateTry(xtry, ytry))
			{
				peek.setTraveledTo(8);
				return new Position(xtry, ytry, -1);
			}
		}

		return null;
		
	}

	private boolean validateTry(int xtry, int ytry) {
		
		// ensure we haven't already traversed this cell
		for (Position pos : positionsTried)
		{
			if (pos.getX() == xtry && pos.getY() == ytry)
			{
				return false;
			}
		}
		
		if (xtry < 0)
		{
			return false;
		}
		if (xtry > 7)
		{
			return false;
		}
		if (ytry < 0)
		{
			return false;
		}
		if (ytry > 7)
		{
			return false;
		}
		
		return true;
	}

	public static void main(String[] args) {

		long start = Calendar.getInstance().getTimeInMillis();
		
		Solver solver = new Solver();
		
		boolean found = false;
		do {
			found = solver.findPostions();
		} while (found == false);
		
		long end = Calendar.getInstance().getTimeInMillis();
		
		System.out.println(end - start);
	}
	
	
}
