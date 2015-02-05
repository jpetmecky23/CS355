package Model.shapes;

import java.awt.Color;

/**
 *
 * @author Brennan Smith
 */
public class Line3D extends Shape 
{
    public Point3D start;
    public Point3D end;
    public Line3D(Point3D s, Point3D e, Color color)
    {
        super(color);
        start = s;
        end = e;
    }

    @Override
    public boolean isPointInShape(Point3D p) {
        Point3D convertedPoint = this.world2Obj(p);
        Point3D convertedStart = this.world2Obj(this.start);
        Point3D convertedEnd = this.world2Obj(this.end);
        Point3D n = normalize(convertedStart, convertedEnd);
        Double dotProd = dotProd(convertedPoint, n);
            if(){
                return true;
            }
        
        return false;
    }  
    
    private Point3D normalize(Point3D p1, Point3D p2){
        double X = p2.x - p1.x;
        double magnitudeX = X * X;
        double Y = p2.y - p1.y;
        double magnitudeY = Y * Y;
        double magnitude = Math.sqrt(magnitudeX + magnitudeY);
        Point3D p = new Point3D(X / magnitude, Y / magnitudeY, 0);
        return p;
    }
    
    public Point3D getStart() {
        return start;
    }

    public void setStart(Point3D start) {
        this.start = start;
    }

    public Point3D getEnd() {
        return end;
    }

    public void setEnd(Point3D end) {
        this.end = end;
    }

}
