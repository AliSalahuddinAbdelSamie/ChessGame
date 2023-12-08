/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author Aly
 */
public class Queen extends Piece {
    public Queen(PieceColor color,String name)
    {
        super(color,name);
    }

    @Override
    public String toString() {
        return "Queen";
    }
    

    @Override
    public boolean isValidMove(Move move) {
        return new Rook(super.getColor(),"temp").isValidMove(move)|| new Bishop(super.getColor(),"temp").isValidMove(move);
    }
    @Override
    public Piece clone(){
        Queen copy=new Queen(this.getColor(),this.getName());
        copy.setHasMoved(this.getHasMoved());
        return copy;
    }
}
