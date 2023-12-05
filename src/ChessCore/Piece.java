/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

public abstract class Piece {
    private PieceColor color;
    private boolean hasMoved;
    public Piece(PieceColor color){
        this.color=color;
        hasMoved=false;
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
}
