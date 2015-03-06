package Model.shapes;

import Controller.Controller;
import Controller.ModAction;
import Model.Model;
import Utillities.Tools;
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
    public boolean isPointInShape(Point3D q) {
        Point3D p1 = this.start;
        Point3D p2 = this.end;
        double e = Math.abs(((p2.y - p1.y) * q.x) - ((p2.x - p1.x) * q.y) + ((p2.x * p1.y) - (p2.y * p1.x)));
        double f = Tools.normalize(p1, p2);
        double result = e / f;
        double Scaler =  (1 / Controller.inst().getZoom());
        //System.out.println(4 * Scaler);
        if(result <= (4 * Scaler)){
                this.isSelected = true;
                Model.inst().setSelectColor(this.getColor());
                return true;
        }
        else{
            this.isSelected = false;
            return false;
            }
    }  
    
    public boolean checkStart(Point3D mouseDown){
        int handleScaler =  (int)(16 / Controller.inst().getZoom());
        Point3D upperLC = new Point3D(this.getStart().x - handleScaler, this.getStart().y - handleScaler, 0);
        Point3D lowerRC = new Point3D(this.getStart().x + handleScaler, this.getStart().y + handleScaler, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseDown)){
            return true;
        }
        return false;
    }

    public boolean checkEnd(Point3D mouseDown){
        int handleScaler =  (int)(16 / Controller.inst().getZoom());
        Point3D upperLC = new Point3D(this.getEnd().x - handleScaler, this.getEnd().y - handleScaler, 0);
        Point3D lowerRC = new Point3D(this.getEnd().x + handleScaler, this.getEnd().y + handleScaler, 0);
        Handle handle = new Handle(upperLC, lowerRC, Color.WHITE);
        if(handle.isPointInShape(mouseDown)){
            return true;
        }
        return false;
    }

     @Override
    public ModAction getModAction(Point3D mouseDown){
         if(this.isIsSelected()){
        if(checkStart(mouseDown)){
            return ModAction.MoveLineStart;
        }
        else if(checkEnd(mouseDown)){
            return ModAction.MoveLineEnd;
        }
        else if(this.isPointInShape(mouseDown)){
            return ModAction.Moving;
        }
        else{
            return ModAction.NoAction;
        }
         }
         return ModAction.NoAction;
    }
    @Override
    public boolean modifyShape(Point3D mousePrevLocation, Point3D mouseCurrentLocation, ModAction modAction) {
        Point3D delta = Tools.findDelta(mousePrevLocation, mouseCurrentLocation);
        
        if(modAction == ModAction.MoveLineStart){
            double x = this.start.x + delta.x;
            double y = this.start.y + delta.y;
            Point3D p = new Point3D(x, y, 0);
            this.setStart(p);
          return true;  
        }
        
        else if(modAction == ModAction.MoveLineEnd){
            double x = this.end.x + delta.x;
            double y = this.end.y + delta.y;
            Point3D p = new Point3D(x, y, 0);
            this.setEnd(p);
            return true;
        }
        else if(modAction == ModAction.Moving){
            double x = this.start.x + delta.x;
            double y = this.start.y + delta.y;
            Point3D p = new Point3D(x, y, 0);
            this.setStart(p);
            x = this.end.x + delta.x;
            y = this.end.y + delta.y;
            p = new Point3D(x, y, 0);
            this.setEnd(p);
            return true;
        }
        
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
