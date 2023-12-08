/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

public class Player implements Prototype {
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
    
    private Player(Player player){
        this.color=player.color;
        this.pawns=player.pawns;
        this.rooks=player.rooks;
        this.knights=player.knights;
        this.bishops=player.bishops;
        this.queens=player.queens;
        this.king=player.king;
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

    @Override
    public Player clone() {
        return new Player(this);
    }
    
       
}
