/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.view;

import com.vera.menu.SwitchActivity;
import com.vera.menu.SwitchColor;
import com.vera.menu.SwitchFill;
import com.vera.menu.SwitchRedo;
import com.vera.menu.SwitchShape;
import com.vera.menu.SwitchState;
import com.vera.menu.SwitchUndo;
import com.vera.mvc.Controller.State;
import com.vera.mvc.model.MyShape;
import com.vera.mvc.model.UndoMachine;
import com.vera.mvc.model.activity.Draw;
import com.vera.mvc.model.activity.Move;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

/**
 *
 * @author Wera
 */
public class MyFrame extends JFrame {

    MyPanel panel;
    State state;
    UndoMachine undoMachine;

    public MyFrame(State state, UndoMachine machine) {
        this.state = state;
        this.undoMachine = machine;
       
        JMenuBar bar;
        bar = new JMenuBar();
        this.setJMenuBar(bar);
        ArrayList<Action> menuItems = new ArrayList<>();
        menuItems.add(new SwitchState("прямоугольник",new ImageIcon("rectangle.gif"),
                new SwitchShape(state, new Rectangle2D.Double())));
        menuItems.add(new SwitchState("овал", new ImageIcon("ellipse.gif"),
                new SwitchShape(state, new Ellipse2D.Double())));
        menuItems.add(new SwitchState("незалитый", new ImageIcon("nofill.gif"),
                new SwitchFill(state, MyShape.FillBehavior.NO_FILL)));
        menuItems.add(new SwitchState("залитый", new ImageIcon("fill.gif"),
                new SwitchFill(state, MyShape.FillBehavior.FILL)));
        menuItems.add(new SwitchState("рисовать", new ImageIcon("draw.gif"),
                new SwitchActivity(state, new Draw())));
        menuItems.add(new SwitchState("двигать", new ImageIcon("move.gif"),
                new SwitchActivity(state, new Move())));
        menuItems.add(new SwitchUndo("undo",new ImageIcon("undo.gif"),undoMachine));
        menuItems.add(new SwitchRedo("redo",new ImageIcon("redo.gif"),undoMachine));
        menuItems.add(new SwitchState("выбор цвета", new ImageIcon("colors.gif"),
                new SwitchColor(state)));
        undoMachine.addObserver((SwitchUndo)menuItems.get(menuItems.size()-3));
        undoMachine.addObserver((SwitchRedo)menuItems.get(menuItems.size()-2));
        undoMachine.notifyMenu();
        
        ArrayList<JMenu> menus = new ArrayList<>();
        menus.add(new JMenu("фигура"));
        menus.add(new JMenu("заливка"));
        menus.add(new JMenu("действие"));
        menus.add(new JMenu("undo/redo"));
        menus.add(new JMenu("цвет"));
        int i = 0;
        int k = menuItems.size()-2;
        for (JMenu m : menus) {
            bar.add(m);
            
            if (i < k) {
                m.add(menuItems.get(i));
                m.add(menuItems.get(i + 1));
                i += 2;
            } else {
                m.add(menuItems.get(i));
            }
        }
        JToolBar toolBar = new JToolBar();
        for (Action x : menuItems) {
            toolBar.add(x);
        }

        add(toolBar, BorderLayout.NORTH);


        

//        
        /////////////////////////////////////////////////////////////////
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);
        setVisible(true);
    }

    public void setPanel(MyPanel panel) {
        this.panel = panel;
        add(panel);
    }

}
