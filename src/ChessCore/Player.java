/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

public class Player  {
    private int pawns;
    private int rooks;
    private int knights;
    private int bishops;
    private int queens;
    private final int king;
    private final PieceColor color; 

    public Player(PieceColor color) {
        this.color=color;
        pawns=8;
        rooks=2;
        knights=2;
        bishops=2;
        queens=1;
        king=1;
    }
    
    
    public PieceColor getColor() {
        return color;
    }

    
    
    public int getPawns() {
        return pawns;
    }

    public int getRooks() {
        return rooks;
    }


    public int getKnights() {
        return knights;
    }

    public int getBishops() {
        return bishops;
    }

    public int getQueens() {
        return queens;
    }
 
    public void decreaseNumberOfPieces(Piece piece){
        if(piece instanceof Pawn)
            pawns--;
        if(piece instanceof Knight)
            knights--;
        if(piece instanceof Bishop)
            bishops--;
        if(piece instanceof Queen)
            queens--;
        if(piece instanceof Rook)
            rooks--;
    }
    public void setNumbersForPromotion(Piece piece){
            pawns--;
        if(piece instanceof Knight)
            knights++;
        if(piece instanceof Bishop)
            bishops++;
        if(piece instanceof Queen)
            queens++;
        if(piece instanceof Rook)
            rooks++;
    }

    
    
       
}
