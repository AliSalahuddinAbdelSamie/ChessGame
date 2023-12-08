
package ChessGui;


import javax.swing.JPanel;

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
