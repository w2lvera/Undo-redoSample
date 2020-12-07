/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.menu;

import com.vera.mvc.Controller.State;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import com.vera.mvc.model.Model;

/**
 *
 * @author user
 */
public class OpenFile implements Command{
    State state;

    public OpenFile(State state) {
        this.state = state;
    }
    
    public void execute() {
        Model model= state.getModel();
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    File file = fc.getSelectedFile();
                    try {
                        model.open(file);
                    //} catch (FileNotFoundException ex) {
                    //    JOptionPane.showMessageDialog(null,"file not found");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }

                }

        }
}
