/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.shapes;

import Model.Model;
import Utillities.Tools;
import java.awt.Color;

/**
 *
 * @author James
 */
public class Triangle extends Shape{
    private Point3D one;//(I will implemete this when I find that it is benificail)
    private Point3D two;
    private Point3D three;
    
    public Triangle(Point3D a,Color color){
        super(color);
        this.one = a;
        this.two = null;
        this.three = null;
    }

    /*@Override
    public void translateShape(Point3D transVec) {
        if(this.isSelected){
        double x = this.one.x + transVec.x;
        double y = this.one.y + transVec.y;
        Point3D p = new Point3D(x, y, 0);
        this.setOne(p);
        x = this.two.x + transVec.x;
        y = this.two.y + transVec.y;
        p = new Point3D(x, y, 0);
        this.setTwo(p);
        x = this.three.x + transVec.x;
        y = this.three.y + transVec.y;
        p = new Point3D(x, y, 0);
        this.setThree(p);
        }
    }*/
    

    
    @Override
    public boolean isPointInShape(Point3D p) {
        Point3D convertedPoint = Tools.world2Obj(p, this);
        this.orderPoints();/*
        boolean testP1 = testPoint(convertedPoint,Tools.world2Obj(this.one, this.angle), Tools.world2Obj(this.two, this.angle));
        boolean testP2 = testPoint(convertedPoint,Tools.world2Obj(this.two, this.angle), Tools.world2Obj(this.three, this.angle));
        boolean testP3 = testPoint(convertedPoint,Tools.world2Obj(this.three, this.angle),Tools.world2Obj(this.one, this.angle));
        if(testP1 && testP2 && testP3){
            this.isSelected = true;
            Model.inst().setSelectColor(this.getColor());
            return true;
        }
        else{
            this.isSelected = false;
            return false;
            }*/
        return false;
    }

    private void orderPoints(){
        if(two.y > one.y && three.y < two.y && two.x < three.x){
            Point3D temp = two;
            two = three;
            three = temp;
        }
    }
    
    private boolean testPoint(Point3D convertedPoint, Point3D p1, Point3D p2){
        Point3D f = Tools.subPoints(convertedPoint, p1);
        Point3D g = Tools.subPoints(p2, p1);
        g = Tools.perpVec(g);
        double dotProd = Tools.dotProd(f, g);
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
