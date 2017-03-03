/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author SAM
 */
public class lines {
    private JPanel jp;
    public void setPanel(JPanel j){this.jp=j;};
    public void lines(){
        GridLayout g = new GridLayout(50, 1);
        this.jp.setLayout(g);
    }
    //TO ADD A NEW LINE TO MY VIEW
    public void addLine(String[] str, int t){
        //JPANEL ROWS MAX=50 (could be extended)
        JPanel line = new JPanel();
        line.setSize(this.jp.getWidth(), 40);
        GridLayout cols = new GridLayout(1, str.length*2);
        line.setLayout(cols);
        ArrayList<JComponent> component = new ArrayList<>();
        
        for(int i=0; i<str.length; i++){
            JLabel l = new JLabel(str[i]);
            component.add(l);
            JTextField gtext = new JTextField();
            gtext.setSize(t, i);
            component.add(gtext);
        }
        for(JComponent jc : component){
            line.add(jc);
        }
        this.jp.add(line);
    }
    
    //HERE I BROWSE MY "TABLE" LINE BY LINE
    public void browse(JPanel jp){  
        String res;
        for(Component com : jp.getComponents()){
            if(com.getClass()==JPanel.class){
                JPanel j = (JPanel) com;
                res="";
                for(Component c : j.getComponents()){
                    
                    if(c.getClass()==JTextField.class){
                        JTextField jt = (JTextField) c;
                        res+= " *** "+jt.getText();
                    }
                }
                JOptionPane.showMessageDialog(null, res);
            }
        }
    }
    
    //MY OBJECTIVE IS TO RETURN AN ARRAY OF STRING
    //FOR EXAMPLE 
    // students{{name, age}, {name, age}, ...}
}
