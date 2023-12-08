
package ChessGui;

import javax.swing.JLabel;


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
