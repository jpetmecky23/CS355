/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.drawableShapes;

import Controller.Controller;
import Model.shapes.Point3D;
import Utillities.Tools;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 *
 * @author James
 */
public class DrawableLine extends DrawableShape{
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public DrawableLine(Color color, double angle, boolean isSelected, int x1, int y1, int x2, int y2) {
        super(color, angle, isSelected);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void drawShape(Graphics2D g2d){
        AffineTransform world2View = Tools.world2View(Controller.inst().getZoom(), Controller.inst().getViewOffset());
        g2d.setTransform(world2View);//Done differentlly than the other shapes since lines don't have centers
        g2d.setColor(color);
        g2d.drawLine(x1, y1, x2, y2);
       
    }
    
        @Override
    public void drawHandles(Graphics2D g2d) {
            if(this.isSelected){
            g2d.setColor(Color.WHITE);
            g2d.fillOval(x1 - 3, y1 - 3, 6, 6);
            g2d.fillOval(x2 - 3, y2 - 3, 6, 6);
        }
    }
    
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
   
    
}
