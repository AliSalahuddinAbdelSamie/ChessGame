/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

public class Rook extends Piece {
    public Rook(PieceColor color,String name){
        super(color,name);
    }

    @Override
    public String toString() {
        return "Rook";
    }
    
    @Override
    public boolean isValidMove(Move move) {
        
       int colDiff=move.getDestination().getColPos()-move.getSource().getColPos();
       int rowDiff=move.getDestination().getRowPos()-move.getSource().getRowPos();
       if(rowDiff==0  || colDiff==0)
        {
            if(move.getDestination().isEmpty())
                return true;
            else if(super.getColor()!=move.getDestination().getPiece().getColor())
                return true;
            
        }
        return false;
    }
    @Override
    public Piece clone(){
        Rook copy=new Rook(this.getColor(),this.getName());
        copy.setHasMoved(this.getHasMoved());
        return copy;
    }
    
}
