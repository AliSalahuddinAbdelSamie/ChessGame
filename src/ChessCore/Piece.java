/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

public abstract class Piece implements Prototype {
    private PieceColor color;
    private boolean hasMoved;
    private String name;
    public Piece(PieceColor color,String name){
        this.color=color;
        hasMoved=false;
        this.name=name;
    }
    
    public boolean getHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
    
    public PieceColor getColor(){
        return color;
    }
   
    public abstract boolean isValidMove(Move move);

    public String getName() {
        return name;
    }
      
    @Override
    public abstract Piece clone();
}
