
package ChessCore;

public class Pawn extends Piece {
    private Move lastMove;
    private final PieceType type=PieceType.PAWN;
    public Pawn(PieceColor color,String name,PieceType type){
        super(color,name,type);  
        lastMove=null;   
    }
    private Pawn(Pawn pawn){
        super(pawn.getColor(),pawn.getName(),pawn.getType());
        this.setHasMoved(pawn.getHasMoved());
        this.setLastMove(pawn.lastMove);
        
    }
    public void setLastMove(Move lastMove) {
        this.lastMove = lastMove;
    }
    

    @Override
    public String toString() {
        return "Pawn";
    }
    
    
     @Override
    public boolean isValidMove(Move move) {     
        
        
        int startRow = move.getSource().getRowPos();
        int startCol = move.getSource().getColPos();
        int endRow = move.getDestination().getRowPos();
        int endCol =  move.getDestination().getColPos();
            
        int direction;
          if (super.getColor() == PieceColor.WHITE) {
            direction = 1;
            } else 
          {
            direction = -1;
          }

        
        if (endCol == startCol && endRow == startRow + direction && move.getDestination().isEmpty()) {        
            return true;
        }
 
        if (!super.getHasMoved() && endCol == startCol && endRow == startRow + 2 * direction && move.getDestination().isEmpty()) {        
            return true;
        }

        if (Math.abs(endCol - startCol) == 1 && endRow == startRow + direction) {
            Piece target = move.getDestination().getPiece();
            if (target != null && target.getColor() != getColor()) {           
                return true;
            }
        }
        if(lastMove!=null){
            if(lastMove.getDestination().getPiece() instanceof Pawn && lastMove.getDestination().getRowPos()-lastMove.getSource().getRowPos()==2*-1*direction ){
                if(lastMove.getDestination().getColPos()==startCol+1 || lastMove.getDestination().getColPos()==startCol-1){
                    if(lastMove.getDestination().getRowPos()==startRow)
                        if(Math.abs(endCol - startCol) == 1 && endRow == startRow + direction && lastMove.getDestination().getColPos()==endCol){ 
                            move.setStatus(MoveStatus.ENPASSENT);
                            return true;
                        }

                }
            }
        }    
        return false;
    }
    @Override
    
    public Piece clone(){
        return new Pawn(this);
    }

    public PieceType getType() {
        return type;
    }

    }
