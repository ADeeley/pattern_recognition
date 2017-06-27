import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

class LineSegment {
    private final Point p; // one endpoint of this line segment
    private final Point q; // the other endpoint of this line segment

    /**
     * Initialises a new line segment.
     *
     * @param p one endpoint
     * @param q the other endpoint
     * @throws NullPointerException if either p or q is null
     */
    public LineSegment(Point p, Point q)
    {
        if (p == null || q == null)
            throw new NullPointerException("Argument is null");
        this.p = p;
        this.q = q;
    }
    /**
     * Returns a string representation of this line segment
     * This method is provided for debugging only.
     * 
     * @return a string representation of this line segment
     */
    public String toString()
    {
        return p + "->" + q;
    }    
    /**
     * throws an exception is called - not uses;
     */
    public int hashCode()
    {
        throw new UnsupportedOperationException();
    }
}

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    /**
     * Initialises a new point
     *
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     */
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    /**
     * Draws this point to standard draw.
     */
    public void draw()
    {
        StdDraw.point(x, y);
    }
    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that)
    {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }
    /**
     * Returns the slope between this point and the specified point.
     * @param that otther point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(Point that)
    {
        // equal points
        if ((this.y == that.y) && (this.x == that.x))
            return Double.NEGATIVE_INFINITY;
        // horizontal line
        else if (this.y == that.y)
            return +0.0;
        // vertical line
        else if (this.x == that.x)
            return Double.POSITIVE_INFINITY;
        else        
            return (that.y - this.y) / (that.x - this.x);
    }
    /**
     * Compares the points by y-coordinate, breaking ties by x-coordinate.
     * @param  that the other point
     * @return the value - if this point is equal to the argument
     *        point (x0 = x1 and y0 = y1):
     *        A negative integer if this point is less than the argument
     *        point; and a positive integer if this point is greater than
     *        the argument point
     */
    public int compareTo(Point that)
    {
        if (this.x == that.x && this.y == that.y)
            return 0;
        else if (this.y < that.y || this.y == that.y && this.x < that.x)
            return -1;
        else
            return 1;
    }
    /*
     * Compares two points by the slope they make with this point
     * The slope is defined as in the SlopeTo() method
     *
     * @return the Comparator that defines this ordering on points

    public Comparator<Point> slopeOrder()
    {
        
    }
     */
    /**
     * Returns a string representation of this point for debugging.
     * Your program should not rely on the format of the string
     * representation
     *
     * @return a string representation of this point.
     * **do not modify**
     */
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
    /**
     * Unittests the point data type
     */
    public static void main(String[] args)
    {
    // SlopeTo unit tests--------------------- 
    Point p = new Point(5, 5);
    Point q = new Point(6, 6);
    assert p.slopeTo(q) == 1;
    assert q.slopeTo(p) == 1;

    p = new Point(7, 7);
    q = new Point(0, 0);
    assert p.slopeTo(q) == 1;
    assert q.slopeTo(p) == 1;

    p = new Point(0, 0);
    q = new Point(0, 0);
    assert p.slopeTo(q) == Double.NEGATIVE_INFINITY;
    assert q.slopeTo(p) == Double.NEGATIVE_INFINITY;

    // Positive zero for horizontal lines
    p = new Point(5, 5);
    q = new Point(10, 5);
    assert p.slopeTo(q) == +0.0;
    assert q.slopeTo(p) == +0.0;
    
    // Positive infinity for vertical lines
    p = new Point(2, 3);
    q = new Point(2, 17);
    assert p.slopeTo(q) == Double.POSITIVE_INFINITY;
    assert q.slopeTo(p) == Double.POSITIVE_INFINITY;

    // Negative infinity for equal coordinates
    p = new Point(18, 18);
    q = new Point(18, 18);
    assert p.slopeTo(q) == Double.NEGATIVE_INFINITY;
    assert q.slopeTo(p) == Double.NEGATIVE_INFINITY;

    
    // CompareTo unit tests--------------------- 
    p = new Point(0, 0);
    q = new Point(0, 0);
    assert p.compareTo(q) == 0;
    assert q.compareTo(p) == 0;

    p = new Point(10, 11);
    q = new Point(2, 3);
    assert p.compareTo(q) > 0;
    assert q.compareTo(p) < 0;

    p = new Point(5, 2);
    q = new Point(0, 0);
    assert p.compareTo(q) > 0;
    assert q.compareTo(p) < 0;

    p = new Point(5, 3);
    q = new Point(2, 3);
    assert p.compareTo(q) > 0;
    assert q.compareTo(p) < 0;

    p = new Point(8, 3);
    q = new Point(0, 3);
    assert p.compareTo(q) > 0;
    assert q.compareTo(p) < 0;
    }

}


