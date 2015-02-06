/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.drawableShapes;

import Model.shapes.Point3D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 *
 * @author James
 */
public class DrawableTri extends DrawableShape{
    private Point3D p1;
    private Point3D p2;
    private Point3D p3;
    
    public DrawableTri(Color color, double angle, boolean isSelected, Point3D p1, Point3D p2, Point3D p3) {
        super(color, angle, isSelected);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    
    @Override
    public void draw(Graphics2D g2d){
        if(this.p2 == null){//Don't draw anything if there is only one point
            
        }
        
        else if(this.p3 == null){//Only draw a line if there is only two points
        g2d.setColor(color);
        int x1 = (int) p1.x;
        int y1 = (int) p1.y;
        int x2 = (int) p2.x;
        int y2 = (int) p2.y;
        g2d.drawLine(x1, y1, x2, y2);
        }
        else{
        g2d.setColor(color);
        Polygon p = getPolygon();
        g2d.fillPolygon(p);
        
        if(this.isSelected){
            g2d.setColor(Color.WHITE);
            g2d.drawPolygon(p);
        }
        }
    }
    
    public Polygon getPolygon() {
        int[] xpoints;
        int[] ypoints;
        int npoints = 3; //triangle
        
        xpoints = new int[3];
        xpoints[0] = (int) p1.x;
        xpoints[1] = (int) p2.x;
        xpoints[2] = (int) p3.x;
        
        ypoints = new int[3];
        ypoints[0] = (int) p1.y;
        ypoints[1] = (int) p2.y;
        ypoints[2] = (int) p3.y;
        
        npoints = 3;//three coners on a triangle
        return new Polygon(xpoints, ypoints, npoints);
    }

    public Point3D getP1() {
        return p1;
    }

    public void setP1(Point3D p1) {
        this.p1 = p1;
    }

    public Point3D getP2() {
        return p2;
    }

    public void setP2(Point3D p2) {
        this.p2 = p2;
    }

    public Point3D getP3() {
        return p3;
    }

    public void setP3(Point3D p3) {
        this.p3 = p3;
    }
}
