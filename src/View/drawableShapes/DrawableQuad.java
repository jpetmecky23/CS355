/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.drawableShapes;

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
    public void draw(Graphics2D g2d){
        AffineTransform rotate = new AffineTransform();
        int centerX = x + width / 2;
        int centerY = y + height / 2;
        //rotate.translate(centerX, centerY);
        rotate.rotate(angle);
     //   g2d.setTransform(rotate);
        g2d.setColor(color);
        g2d.fillRect(x, y, width, height);
        
        if(this.isSelected){
            g2d.setColor(Color.WHITE);
            centerX = x + width / 2;
            g2d.fillOval(centerX - 3, y - 27, 6, 6);
            g2d.drawLine(centerX, y, centerX, (y - 25));
            g2d.drawRect(x, y, width, height);
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
