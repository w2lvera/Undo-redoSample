/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.io.Serializable;

/**
 *
 * @author Wera
 */
public class MyShape implements Serializable{

    Color color;
    RectangularShape shape;
    FillBehavior fb;

    public MyShape(RectangularShape shape) {
        this.shape = shape;
        color = Color.BLUE;
        fb = FillBehavior.NO_FILL;
    }

    public MyShape() {
        color = Color.BLUE;
        shape = new Rectangle2D.Double();
        fb =  FillBehavior.NO_FILL;;
    }

    public MyShape(Color color, RectangularShape shape, FillBehavior fb) {
        this.color = color;
        this.shape = shape;
        this.fb = fb;
    }

    public void setFb(FillBehavior fb) {
        this.fb = fb;
    }

    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }

    public void setFrame(Point2D[] pd) {
        shape.setFrameFromDiagonal(pd[0], pd[1]);
    }

    void draw(Graphics2D g) {
        fb.draw(g,color,shape);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public MyShape.FillBehavior getFb() {
        return fb;
    }
    public boolean contains(Point2D p){
        return shape.contains(p);
    }
    public MyShape clone() {
        MyShape s = new MyShape();       
        RectangularShape s1 = (RectangularShape) shape.clone();      
        s.setColor(color);
        s.setShape(s1);
        s.fb = this.fb; 
        return s;
    }

    public RectangularShape getShape() {
        return shape;
    }

   

    /////////////////////inner enum/////////////////////////////////////
    
    public enum FillBehavior implements Serializable{
        FILL {
            @Override
            public void draw(Graphics2D g,  Color c, RectangularShape sh) {
                  Paint paint = g.getPaint();
                  g.setPaint(c);
                  g.fill(sh);
                  g.setPaint(paint);
            }
        } ,
        NO_FILL {
            @Override
            public void draw(Graphics2D g, Color c, RectangularShape sh) {
                 Paint paint = g.getPaint();
                 g.setPaint(c);
                 g.draw(sh);
                 g.setPaint(paint);
            }
        };
        public abstract void  draw(Graphics2D g, Color c, RectangularShape sh);        
        
    }

    
}
