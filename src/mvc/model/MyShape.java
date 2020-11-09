/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

/**
 *
 * @author Wera
 */
public class MyShape {
    Color color;
    RectangularShape shape;
    FillBehavior fb;

    public MyShape(RectangularShape shape) {
        this.shape = shape;
        color = Color.BLUE;
        fb = new NoFill();
        fb.setColor(color);
        fb.serShape(shape);
    }

    public MyShape() {
        color = Color.BLUE;
        shape = new Rectangle2D.Double();
        fb = new Fill();
        fb.setColor(color);
        fb.serShape(shape);
    }

    public MyShape(Color color, RectangularShape shape, FillBehavior fb) {
        this.color = color;
        this.shape = shape;
        this.fb = fb;
        this.fb.serShape(shape);
        this.fb.setColor(color);
    }

    public void setFb(FillBehavior fb) {
        this.fb = fb;
        fb.serShape(shape);
        fb.setColor(color);
    }

    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }
    
    public void setFrame(Point2D[]pd){
        shape.setFrameFromDiagonal(pd[0], pd[1]);
    }

    void draw(Graphics2D g) {
        fb.draw(g);
       
    }
    //////////////////////////////////////////////////////////
   

   
    
}
