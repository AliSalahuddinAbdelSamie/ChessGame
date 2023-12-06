/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessGui;

import javax.swing.JLabel;

/**
 *
 * @author Aly
 */
public class myLabel extends JLabel {
     private String name;
    public myLabel(String name){
        this.name=name;
       
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
}
