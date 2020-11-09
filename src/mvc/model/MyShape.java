/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

/**
 *
 * @author Wera
 */
public class MyShape {
    RectangularShape shape;

    public MyShape(RectangularShape shape) {
        this.shape = shape;
    }

    public MyShape() {
    }

    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }
    
    public void setFrame(Point2D[]pd){
        shape.setFrameFromDiagonal(pd[0], pd[1]);
    }

    void draw(Graphics2D g) {
        g.draw(shape);
    }
    
}
