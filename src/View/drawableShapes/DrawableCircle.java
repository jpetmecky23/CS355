/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.drawableShapes;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author James
 */
public class DrawableCircle extends DrawableShape{
    private int x;
    private int y;
    private int width;
    private int height;

    public DrawableCircle(Color color, double angle, boolean isSelected, int x, int y, int width, int height) {
        super(color, angle, isSelected);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g2d){
        g2d.setColor(color);
        g2d.fillOval(x, y, width, height);
        
        if(this.isSelected){
            g2d.setColor(Color.WHITE);
            g2d.drawOval(x, y, width, height);
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
