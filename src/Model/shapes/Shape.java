/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.shapes;

import java.awt.Color;

/**
 *
 * @author James
 */
public class Shape{
    private Color color;
    protected double angle;
    protected boolean isSelected;
    protected Point3D center;
    
    public Shape(Color color) {
        this.color = color;
        this.angle = 0;
        this.isSelected = false;
    }
       
    public Point3D world2Obj(Point3D p){        
        double transX = p.x - center.x;
        double transY = p.y - center.y;
        Point3D transPoint = new Point3D(transX, transY, 0);
        return transPoint;
    }
    
    public void isPointInShape(Point3D p){
        //Call world2Obj and the check to see if the point lies within the shape. 
    }
    
    protected double dotProd(Point3D p1, Point3D p2){
        return (p1.x * p2.x) + (p1.y * p2.y);
    }
    
    protected Point3D subPoints(Point3D p1, Point3D p2){
        return new Point3D((p1.x - p2.x),(p1.y - p2.y), 0);
    }
    
    protected Point3D perpVec(Point3D p){
        return new Point3D(-p.y,p.x, 0);
    }
    
    protected double normalize(Point3D p1, Point3D p2){
    double X = p2.x - p1.x;
    X = X * X;
    double Y = p2.y - p1.y;
    Y = Y * Y;
    double normal = Math.sqrt(X + Y); 
    return normal;
    }
    
    protected Point3D unitVector(Point3D p1, Point3D p2){
    double X = p2.x - p1.x;
    double Y = p2.y - p1.y;
    double magnitude = normalize(p1, p2);
    Point3D p = new Point3D(X / magnitude, Y / magnitude, 0);
    return p;
    }
    
    public Color getColor() {
        return color;
    }   

    public void setColor(Color color) {
        this.color = color;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Point3D getCenter() {
        return center;
    }

    public void setCenter(Point3D center) {
        this.center = center;
    }

    public boolean isIsSelected() {
        return isSelected;
    }
    
    
}
