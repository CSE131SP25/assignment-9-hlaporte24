package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;

	public Snake() {
		segments = new LinkedList<>();
		deltaX = MOVEMENT_SIZE;
		deltaY = 0;
		segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));
	}

	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}

	public void move() {
		// get current head
		BodySegment head = segments.getFirst(); //find current head position
		double newX = head.getX() + deltaX; //calculate new head position
		double newY = head.getY() + deltaY;

		//add new head
		segments.addFirst(new BodySegment(newX, newY, SEGMENT_SIZE));

		// remove tail
		segments.removeLast();
	}

	public void draw() {
		for (BodySegment seg : segments) {
			seg.draw();
		}
	}

	public boolean eatFood(Food f) {
		BodySegment head = segments.getFirst();
		if (f.contains(head.getX(), head.getY())) {//does head + food overlap
			//add head without removing tail
			double newX = head.getX() + deltaX; // new segment is added / deltax+deltay are used to determine which direction
			double newY = head.getY() + deltaY; // tail not removed!! -- skips .removedLast()
			segments.addFirst(new BodySegment(newX, newY, SEGMENT_SIZE));
			return true;
		}
		return false;
	}

	public boolean isInbounds() {
		BodySegment head = segments.getFirst();
		double x = head.getX();
		double y = head.getY();
		return x >= 0 && x <= 1 && y >= 0 && y <= 1;
	}
}

