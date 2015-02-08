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

    @Override
    public void translateShape(Point3D transVec) {
        if(this.isSelected){
        double x = this.start.x + transVec.x;
        double y = this.start.y + transVec.y;
        Point3D p = new Point3D(x, y, 0);
        this.setStart(p);
        x = this.end.x + transVec.x;
        y = this.end.y + transVec.y;
        p = new Point3D(x, y, 0);
        this.setEnd(p);
        }
    }
    
    
    
   private boolean pointWithInEndPoints(Point3D q){
        /*
        if(dotProd <= length){
            return true;
        }*/
        return false;
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
