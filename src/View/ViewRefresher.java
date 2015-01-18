/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Graphics2D;
import java.util.Observer;

/**
 *
 * @author Talonos
 */
public interface ViewRefresher extends Observer 
{
    void refreshView(Graphics2D g2d);
}
