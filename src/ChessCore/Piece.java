
package ChessCore;

public abstract class Piece implements Prototype {
    private PieceColor color;
    private boolean hasMoved;
    private String name;
    private final PieceType type;
    public Piece(PieceColor color,String name,PieceType type){
        this.color=color;
        hasMoved=false;
        this.name=name;
        this.type=type;
    }
    
    public boolean getHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
    
    public PieceColor getColor(){
        return color;
    }
   
    public abstract boolean isValidMove(Move move);

    public String getName() {
        return name;
    }

    public PieceType getType() {
        return type;
    }
      
    @Override
    public abstract Piece clone();
}
