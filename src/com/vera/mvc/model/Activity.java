/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.model;

import java.awt.geom.Point2D;

/**
 *
 * @author Wera
 */
public class Activity {
    Model model;
    Point2D[] p;
    ActivityBehavior ab;

    public Activity(Model model) {
        this.model = model;
        p = new Point2D[2];
        ab = ActivityBehavior.DRAW;
    }

    public void setAb(Activity.ActivityBehavior activity) {
        ab = activity;
    }
    public void getPointOne(Point2D p1){
        ab.getPointOne(p1, p, model);
    }
    public void getPointTwo(Point2D p1){
        ab.getPointTwo(p1, p, model);
    }
    //////////////////////////////////////////////////
    public enum ActivityBehavior {
        DRAW {
            @Override
            public void getPointOne(Point2D p1, Point2D[] p, Model model) {
                p[0] = p1;
                model.inintCurrentShape();
            }

            @Override
            public void getPointTwo(Point2D p1, Point2D[] p, Model model) {
                p[1] = p1;
                model.changeShape(p);
            }

        },
        MOVE {
            @Override
            public void getPointOne(Point2D p1, Point2D[] p, Model model) {
                p[0] = p1;
                model.findShape(p1);
            }

            @Override
            public void getPointTwo(Point2D p1, Point2D[] p, Model model) {
                p[1] = p1;
                model.moveShape(p);
            }
        };

        public abstract void getPointOne(Point2D p1, Point2D[] p, Model model);

        public abstract void getPointTwo(Point2D p1, Point2D[] p, Model model);
    }
}
