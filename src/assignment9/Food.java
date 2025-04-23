package assignment9;

import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

public class Food {

    public static final double FOOD_SIZE = 0.02;
    private double x, y;

    /**
     * create food at specific location
     */
    public Food(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * create food at random location
     */
    public static Food createRandom() {
        double x = FOOD_SIZE + Math.random() * (1 - 2 * FOOD_SIZE);
        double y = FOOD_SIZE + Math.random() * (1 - 2 * FOOD_SIZE);
        return new Food(x, y);
    }

    /**
     * draw food as red square
     */
    public void draw() {
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledSquare(x, y, FOOD_SIZE);
    }

    /**
     * checks if the point is inside the red square
     */
    public boolean contains(double px, double py) {
        return Math.abs(px - x) <= FOOD_SIZE && Math.abs(py - y) <= FOOD_SIZE;
    }

}