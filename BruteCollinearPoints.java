import java.util.Comparator;


public class BruteCollinearPoints {
   private LineSegment[] segments; 
   private int n = 0; // index for segments
   private Comparator<Point> comp; // comparator for Point objects
   public BruteCollinearPoints(Point[] points)
   {
      segments = new LineSegment[points.length];
      for (int a = 0; a < points.length; a++) {
         for (int b = a + 1; b < points.length; b++) {
            for (int c = b + 1; c < points.length; c++) {
               for (int d = c + 1; d < points.length; d++) {
       
                  comp = points[a].slopeOrder();
                  // Check if all points fall on the same line
                  if (comp.compare(points[b], points[c]) ==
                      comp.compare(points[c], points[d]))

                     // check if the point, a, is the lowest on the line segment
                     if (points[a].compareTo(points[b]) == -1 &&
                         points[a].compareTo(points[c]) == -1 &&
                         points[a].compareTo(points[d]) == -1) 

                         // Check if d is the highest point on the line
                         // Points on the same location
                         if (points[d].compareTo(points[c]) == 1 &&
                             points[d].compareTo(points[b]) == 1)
                             segments[n++] = new LineSegment(points[a], points[d]);
                         
                    
               }
            }
         }
      }

   }
   public static void main(String[] args)
   {
       // bcd tests
       // Diagonal ------
       Point[] p = new Point[8];
       p[0] = new Point(1,1);
       p[1] = new Point(2,2);
       p[2] = new Point(3,3);
       p[3] = new Point(4,4);
       p[4] = new Point(2,4);
       p[5] = new Point(3,1);
       BruteCollinearPoints bcp = new BruteCollinearPoints(p);

       // Horizontal ------
       p[0] = new Point(1,1);
       p[1] = new Point(1,3);
       p[2] = new Point(2,3);
       p[3] = new Point(2,5);
       p[4] = new Point(3,3);
       p[5] = new Point(4,3);
       p[5] = new Point(4,2);
       bcp = new BruteCollinearPoints(p);
       
       // Vertical ------
       p[0] = new Point(1,1);
       p[1] = new Point(1,4);
       p[2] = new Point(3,2);
       p[3] = new Point(4,2);
       p[4] = new Point(4,3);
       p[5] = new Point(4,4);
       p[5] = new Point(4,5);
       bcp = new BruteCollinearPoints(p);
       
       // Degenerate ------
       p[0] = new Point(1,1);
       p[1] = new Point(1,1);
       p[2] = new Point(1,1);
       p[3] = new Point(1,1);
       p[4] = new Point(4,3);
       p[5] = new Point(4,4);
       p[5] = new Point(4,5);
       bcp = new BruteCollinearPoints(p);

       // Degenerate ------
       p[0] = new Point(0,0);
       p[1] = new Point(0,0);
       p[2] = new Point(0,0);
       p[3] = new Point(0,0);
       p[4] = new Point(0,0);
       p[5] = new Point(0,0);
       p[5] = new Point(0,0);
       bcp = new BruteCollinearPoints(p);

       // Split Diagonal ------
       p[0] = new Point(0,0);
       p[1] = new Point(2,2);
       p[2] = new Point(3,3);
       p[3] = new Point(5,5);
       p[4] = new Point(4,1);
       p[5] = new Point(3,5);
       bcp = new BruteCollinearPoints(p);
       
       // Split Horizontal ------
       p[0] = new Point(0,2);
       p[1] = new Point(2,2);
       p[2] = new Point(3,2);
       p[3] = new Point(5,2);
       p[4] = new Point(0,5);
       p[5] = new Point(3,0);
       bcp = new BruteCollinearPoints(p);

       // Split Vertical ------
       p[0] = new Point(3,0);
       p[1] = new Point(3,2);
       p[2] = new Point(3,4);
       p[3] = new Point(3,5);
       p[4] = new Point(1,3);
       p[5] = new Point(5,2);
       bcp = new BruteCollinearPoints(p);
 

   }
}
