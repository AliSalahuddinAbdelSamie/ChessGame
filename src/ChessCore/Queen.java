
package ChessCore;


public class Queen extends Piece {
     
    public Queen(PieceColor color,String name,PieceType type)
    {
        super(color,name,type);
    }
    private Queen(Queen queen){
        super(queen.getColor(),queen.getName(),queen.getType());
        this.setHasMoved(queen.getHasMoved());
    }
    @Override
    public String toString() {
        return "Queen";
    }
    

    @Override
    public boolean isValidMove(Move move) {
        return new Rook(super.getColor(),"temp",PieceType.ROOK).isValidMove(move)|| new Bishop(super.getColor(),"temp",PieceType.BISHOP).isValidMove(move);
    }
    @Override
    public Piece clone(){
        return new Queen(this);
    }
}
