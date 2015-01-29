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
    
}
