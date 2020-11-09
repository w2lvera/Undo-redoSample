/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.Controller;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import mvc.view.MyFrame;
import mvc.view.MyPanel;

/**
 *
 * @author Wera
 */
public class Controller {
    RectangularShape r;
    MyFrame frame;
    MyPanel panel;
    Point2D [] pd;

    public Controller() {
        r = new Rectangle2D.Double();
        panel = new MyPanel();
        panel.setController(this);
        frame = new MyFrame();
        frame.setPanel(panel);
        
        pd = new Point2D[2];
    }
    public void getPointOne(Point2D p){
        pd[0] = p;
    }
    public void getPointTwo(Point2D p){
        pd[1] = p;
        r.setFrameFromDiagonal(pd[0],pd[1]);
    }

    public void draw(Graphics2D g2) {
        g2.draw(r);
    }
}
