
package ChessCore;

public class Rook extends Piece {
    public Rook(PieceColor color,String name,PieceType type){
        super(color,name,type);
    }
    private Rook(Rook rook){
        super(rook.getColor(),rook.getName(),rook.getType());
        this.setHasMoved(rook.getHasMoved());
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
        return new Rook(this);
    }
    
}
