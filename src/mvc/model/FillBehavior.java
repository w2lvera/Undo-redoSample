/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RectangularShape;

/**
 *
 * @author Wera
 */
public interface FillBehavior {
        void draw(Graphics2D g);
        void setColor(Color c);
        void serShape(RectangularShape s);
    }