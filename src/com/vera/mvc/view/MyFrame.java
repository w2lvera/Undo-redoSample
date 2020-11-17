/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.view;

import com.vera.mvc.Controller.State;
import com.vera.mvc.model.Activity;
import com.vera.mvc.model.MyShape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Wera
 */
public class MyFrame extends JFrame {

    MyPanel panel;
    State state;

    public MyFrame(State state) {
        this.state = state;
        JMenuBar bar;
        bar = new JMenuBar();
        this.setJMenuBar(bar);
        JMenu menu;
        menu = new JMenu("test");
        bar.add(menu);
        JMenuItem jMenuItem;
        jMenuItem = new JMenuItem("fill");
        JMenuItem jMenuItem1;
        jMenuItem1 = new JMenuItem("NoFill");
        menu.add(jMenuItem);
        menu.add(jMenuItem1);
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setFb(MyShape.FillBehavior.FILL);
            }
        });
        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setFb(MyShape.FillBehavior.NO_FILL);
            }
        });
        JMenu menu1 = new JMenu("activity");
        bar.add(menu1);
        JMenuItem jMenuItem2;
        jMenuItem2 = new JMenuItem("Draw");
        JMenuItem jMenuItem3;
        jMenuItem3 = new JMenuItem("Move");
        menu1.add(jMenuItem2);
        menu1.add(jMenuItem3);
        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setActivity(Activity.ActivityBehavior.DRAW);
            }
        });
        jMenuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setActivity(Activity.ActivityBehavior.MOVE);
            }
        });
        
        /////////////////////////////////////////////////////////////////
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public void setPanel(MyPanel panel) {
        this.panel = panel;
        add(panel);
    }

}
