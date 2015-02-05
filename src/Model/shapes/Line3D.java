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
        this.setCenter();
    }

    @Override
    public Point3D world2Obj(Point3D p) {
        return p; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public boolean isPointInShape(Point3D q) {
        Point3D convertedPointq = this.world2Obj(q);
        Point3D convertedStart = this.world2Obj(this.start);
        Point3D convertedEnd = this.world2Obj(this.end);
        Point3D n = unitVector(convertedStart, convertedEnd);
        double dotProd = dotProd(convertedPointq, n);
        double d = dotProd(convertedStart, n);
        double result = Math.abs(dotProd - d);
        if(result <= 4){
            if(pointWithInEndPoints(convertedPointq)){
                return true;
            }
        }
        return false;
    }  
    
   private boolean pointWithInEndPoints(Point3D convertedPointq){
        Point3D convertedStart = this.world2Obj(this.start);
        Point3D convertedEnd = this.world2Obj(this.end);
        double length = this.normalize(convertedStart, convertedEnd);
        Point3D unitVector = this.unitVector(convertedStart, convertedEnd);
        double dotProd = this.dotProd(this.subPoints(convertedPointq, convertedStart), unitVector);
        
        if(dotProd <= length){
            return true;
        }
        return false;
   }
    
   private void setCenter(){
      // double x = Math.abs(this.start.x - this.end.x) / 2;
      // double y = Math.abs(this.start.y - this.end.y) / 2;;
       //Point3D c = new Point3D(x, y, 0);
       //this.center = c;
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
