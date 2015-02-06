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
public class Triangle extends Shape{
    private Point3D one;//(I will implemete this when I find that it is benificail)Numbering always starts wil the top and goes clockwise
    private Point3D two;
    private Point3D three;
    
    public Triangle(Point3D a,Color color){
        super(color);
        this.one = a;
        this.two = null;
        this.three = null;
    }
    
    @Override
    public boolean isPointInShape(Point3D p) {
        Point3D convertedPoint = this.world2Obj(p);
        boolean testP1 = testPoint(convertedPoint,this.world2Obj(this.one), this.world2Obj(this.two));
        boolean testP2 = testPoint(convertedPoint,this.world2Obj(this.two), this.world2Obj(this.three));
        boolean testP3 = testPoint(convertedPoint,this.world2Obj(this.three),this.world2Obj(this.one));
       
        return (testP1 && testP2 && testP3);
    }

    private boolean testPoint(Point3D convertedPoint, Point3D p1, Point3D p2){
        Point3D f = subPoints(convertedPoint, p1);
        Point3D g = subPoints(p2, p1);
        double dotProd = dotProd(f, g);
        return dotProd > 0;
    }
        
    public Point3D getOne() {
        return one;
    }

    public void setOne(Point3D one) {
        this.one = one;
    }

    public Point3D getTwo() {
        return two;
    }

    public void setTwo(Point3D two) {
        this.two = two;
    }

    public Point3D getThree() {
        return three;
    }

    public void setThree(Point3D three) {
        this.three = three;
        this.findCenter();
    }
    
    public boolean isTwoNull(){
        if(two == null){
            return true;
        }
        return false;
    }
    
    public boolean isThreeNull(){
    if(three == null){
        return true;
    }
    return false;
    }
    
    public void findCenter(){
        double centerX = (this.one.x + this.two.x + this.three.x) / 3; //Find the average
        double centerY = (this.one.y + this.two.y + this.three.y) / 3; //Find the average
        Point3D center = new Point3D(centerX, centerY, 0);
        this.setCenter(center);
    }
}
