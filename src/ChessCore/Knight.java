
package ChessCore;

public class Knight extends Piece {
    
    
    public Knight(PieceColor color,String name,PieceType type)
    {
        super(color,name,type);
    }
    private Knight(Knight knight){
        super(knight.getColor(),knight.getName(),knight.getType());
        this.setHasMoved(knight.getHasMoved());
    }
    @Override
    public String toString() {
        return "Knight";
    }
    
    @Override
    public boolean isValidMove(Move move) {
        int colDiff=move.getDestination().getColPos()-move.getSource().getColPos();
        int rowDiff=move.getDestination().getRowPos()-move.getSource().getRowPos();
        if((Math.abs(rowDiff)==1 && Math.abs(colDiff)==2)||(Math.abs(rowDiff)==2 && Math.abs(colDiff)==1) )
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
        return new Knight(this);
    }
}
