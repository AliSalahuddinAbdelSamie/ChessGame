/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessGui;

/**
 *
 * @author Aly
 */
import javax.swing.JPanel;

/**
 *
 * @author Aly
 */
public class myPanel extends JPanel {
    private String name;
    public myPanel(String name){
        this.name=name;
       
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }

    
    

    
    
}
