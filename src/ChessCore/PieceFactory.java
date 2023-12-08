
package ChessCore;


public class PieceFactory {
    public Piece create(PieceColor color,String name,PieceType type){
        switch(type){
            case BISHOP:return new Bishop(color,name,type);
            case KING:return new King(color,name,type);
            case KNIGHT:return new Knight(color,name,type);
            case PAWN:return new Pawn(color,name,type);
            case QUEEN:return new Queen(color,name,type);
            case ROOK:return new Rook(color,name,type);
            default:return null;
        }}
        
    
    
}
