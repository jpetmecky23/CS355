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
        AffineTransform afftrand = getTransform();//Tools.world2View(Controller.inst().getZoom(), Controller.inst().getViewOffset());
        g2d.setTransform(afftrand);//Done differentlly than the other shapes since lines don't have centers
        g2d.setColor(color);
        g2d.drawLine(x1, y1, x2, y2);
       
    }
    
        @Override
    public void drawHandles(Graphics2D g2d) {
            double zoom =  Controller.inst().getZoom();
            int handleScaler = (int) (16 / zoom);
            if(this.isSelected){
            g2d.setColor(Color.WHITE);
            g2d.fillRect(x1 - handleScaler, y1 - handleScaler, handleScaler, handleScaler);
            g2d.fillRect(x2 - handleScaler, y2 - handleScaler, handleScaler, handleScaler);
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
   
        @Override
    public AffineTransform getTransform(){
        Point3D center = new Point3D(0, 0, 0);//getCenter();
        AffineTransform obj2World = Tools.obj2World(angle, center);
        AffineTransform world2View = Tools.world2View(Controller.inst().getZoom(), Controller.inst().getViewOffset());
       world2View.concatenate(obj2World);
       return world2View;
    }
}
