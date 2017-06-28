import java.util.Comparator;


public class BruteCollinearPoints {
   private LineSegment[] segments;
   private int n = 0; // index for segments
   private Comparator<Point> comp;
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
   }
}

















































