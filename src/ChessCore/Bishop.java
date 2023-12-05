/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

public class Bishop extends Piece {
    public Bishop(PieceColor color){
        super(color);
    }

    @Override
    public String toString() {
        return "Bishop";
    }
    
    @Override
    public boolean isValidMove(Move move) {
        int colDiff=move.getDestination().getColPos()-move.getSource().getColPos();
        int rowDiff=move.getDestination().getRowPos()-move.getSource().getRowPos();
        if(Math.abs(rowDiff)== Math.abs(colDiff))
        {
            if(move.getDestination().isEmpty())
                return true;
            else if(super.getColor()!=move.getDestination().getPiece().getColor())
                return true;
            
        }
        return false;
    }
}
