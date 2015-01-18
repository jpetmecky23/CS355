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
public class Square extends Shape{
    private Point3D upperLeftCorner;
    private int size;
    
    public Square(Point3D ulc, int s){
        this.upperLeftCorner = ulc;
        this.size = s;
    }

    public Point3D getUpperLeftCorner() {
        return upperLeftCorner;
    }

    public void setUpperLeftCorner(Point3D upperLeftCorner) {
        this.upperLeftCorner = upperLeftCorner;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
