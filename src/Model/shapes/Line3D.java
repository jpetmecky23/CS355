package Model.shapes;

import Model.Model;
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
    public void isPointInShape(Point3D q) {
        Point3D p1 = this.start;
        Point3D p2 = this.end;
        double e = Math.abs(((p2.y - p1.y) * q.x) - ((p2.x - p1.x) * q.y) + ((p2.x * p1.y) - (p2.y * p1.x)));
        double f = this.normalize(p1, p2);
        double result = e / f;
        if(result <= 4){
            //if(pointWithInEndPoints(q)){
                this.isSelected = true;
                Model.inst().setSelectColor(this.getColor());
                
            //}
        }
        else{
            this.isSelected = false;
            }
        
    }  
    
   private boolean pointWithInEndPoints(Point3D q){
        /*Point3D convertedStart = this.world2Obj(this.start);
        Point3D convertedEnd = this.world2Obj(this.end);
        double length = this.normalize(convertedStart, convertedEnd);
        Point3D unitVector = this.unitVector(convertedStart, convertedEnd);
        double dotProd = this.dotProd(this.subPoints(convertedPointq, convertedStart), unitVector);
        
        if(dotProd <= length){
            return true;
        }*/
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
