
package ChessCore;

public class Bishop extends Piece {
   
    public Bishop(PieceColor color,String name,PieceType type){
        super(color,name,type);   
    }
    private Bishop(Bishop bishop){
        super(bishop.getColor(),bishop.getName(),bishop.getType());
        this.setHasMoved(bishop.getHasMoved());
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

 
    @Override
    public Piece clone() {
        return new Bishop(this);
    }
  
}
