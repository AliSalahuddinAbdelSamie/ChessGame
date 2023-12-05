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
    public Queen(PieceColor color)
    {
        super(color);
    }

    @Override
    public String toString() {
        return "Queen";
    }
    

    @Override
    public boolean isValidMove(Move move) {
        return new Rook(super.getColor()).isValidMove(move)|| new Bishop(super.getColor()).isValidMove(move);
    }
}
