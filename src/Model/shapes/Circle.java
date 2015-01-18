/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.shapes;

/**
 *
 * @author James
 */
public class Circle extends Shape{
    private Point3D center;
    private int radis; 
    
    public Circle(Point3D c, int r){
        this.center = c;
        this.radis = r;
    }

    public Point3D getCenter() {
        return center;
    }

    public void setCenter(Point3D center) {
        this.center = center;
    }

    public int getRadis() {
        return radis;
    }

    public void setRadis(int radis) {
        this.radis = radis;
    }
    
    
}
