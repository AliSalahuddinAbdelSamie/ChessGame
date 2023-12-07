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
     private int movesSincePromotion;
    public myLabel(String name){
        this.name=name;
        movesSincePromotion=-1;
    }

    public int getMovesSincePromotion() {
        return movesSincePromotion;
    }

    public void setMovesSincePromotion(int movesSincePromotion) {
        this.movesSincePromotion = movesSincePromotion;
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
}
