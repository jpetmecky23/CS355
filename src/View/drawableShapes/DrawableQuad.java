/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.drawableShapes;

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
        int centerX = x + width / 2;
        int centerY = y + height / 2;
        Point3D center = new Point3D(centerX, centerY, 0);
        AffineTransform obj2World = Tools.obj2World(angle, center);
        // set the drawing transformation
        g2d.setTransform(obj2World);
        g2d.setColor(color);
        g2d.fillRect(-width / 2, -height / 2, width, height);
        
        if(this.isSelected){
            g2d.setColor(Color.WHITE);
            centerX = x + width / 2;
            g2d.fillOval(centerX - 3, y - 27, 6, 6);
            g2d.drawLine(centerX, y, centerX, (y - 25));
            g2d.drawRect(-width / 2, -height / 2, width, height);
        }
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
