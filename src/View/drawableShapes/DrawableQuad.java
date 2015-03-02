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
public class DrawableQuad extends DrawableShape{
    private int x;
    private int y;
    private int width;
    private int height;

    public DrawableQuad(Color color, double angle, boolean isSelected, int x, int y, int width, int height) {
        super(color, angle, isSelected);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void drawShape(Graphics2D g2d){
        g2d.setTransform(getTransform());
        g2d.setColor(color);
        g2d.fillRect(-width / 2, -height / 2, width, height);
    }

    @Override
    public void drawHandles(Graphics2D g2d) {
        if(this.isSelected){
           g2d.setTransform(getTransform());
            g2d.setColor(Color.WHITE);
            
            g2d.drawRect(-width / 2, -height / 2, width, height);
            g2d.fillRect((-width / 2) - 3, (-height / 2) - 3, 7, 7);//Top Left            
            g2d.fillRect((width / 2) - 3, (-height / 2) - 3, 7, 7); //Top Right         
            g2d.fillRect((width / 2) - 3, (height / 2) - 3, 7, 7);  //Bottom Right        
            g2d.fillRect((-width / 2) - 3, (height / 2) - 3, 7, 7);//Bottom Left
            g2d.fillRect(0, (-height / 2) - 20, 7, 7);//Rotation
        }
    }

    @Override
    public Point3D getCenter(){
        int centerX = x + width / 2;
        int centerY = y + height / 2;
        Point3D center = new Point3D(centerX, centerY, 0);
        return center;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
}
