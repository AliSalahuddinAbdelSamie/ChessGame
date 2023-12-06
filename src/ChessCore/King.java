/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

public class King extends Piece {
    public King(PieceColor color,String name){
        super(color,name);
    }

    @Override
    public String toString() {
        return "King";
    }
    
    @Override
    public boolean isValidMove(Move move) {
        
        int colDiff=move.getDestination().getColPos()-move.getSource().getColPos();
        int rowDiff=move.getDestination().getRowPos()-move.getSource().getRowPos();
        if(Math.abs(rowDiff)<=1 && Math.abs(colDiff)<=1)
        {
            if(move.getDestination().isEmpty())
                return true;
            else if(super.getColor()!=move.getDestination().getPiece().getColor())
                return true;
            
        }
        
        if(!super.getHasMoved() && Math.abs(move.getSource().getColPos()-move.getDestination().getColPos())==2 &&move.getSource().getRowPos()==move.getDestination().getRowPos() )
        {
            
                move.setStatus(MoveStatus.CASTLING);
                return true;
            
        }
        return false;
        
    }
    @Override
    public Piece copy(){
        King copy=new King(this.getColor(),this.getName());
        copy.setHasMoved(this.getHasMoved());
        return copy;
    }
}
