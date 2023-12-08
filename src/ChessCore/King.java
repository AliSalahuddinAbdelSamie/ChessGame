
package ChessCore;

public class King extends Piece {
    private final PieceType type=PieceType.KING;
    
    
    public King(PieceColor color,String name,PieceType type){
        super(color,name,type);
    }
    private King(King king){
        super(king.getColor(),king.getName(),king.getType());
        this.setHasMoved(king.getHasMoved());
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

    public PieceType getType() {
        return type;
    }
    
    @Override
    public Piece clone(){
        return new King(this);
    }
}
