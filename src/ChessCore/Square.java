/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

public class Square implements Prototype {
    private final int rowPos;
    private final int colPos;
    private Piece piece;

    public Square(int rowPos,int colPos){
        this.rowPos=rowPos;
        this.colPos=colPos;
    }
    public Square(int rowPos,int colPos,Piece piece){
        this.rowPos=rowPos;
        this.colPos=colPos;
        this.piece=piece;
    }
    private Square(Square square){
        this.rowPos=square.rowPos;
        this.colPos=square.colPos;
        if(square.getPiece()!=null)
        this.piece=square.piece.clone();
        else this.piece=null;
    }
    
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    public int getRowPos() {
        return rowPos;
    }

    public int getColPos() {
        return colPos;
    }
    public boolean isEmpty(){
        return piece==null;
    }

    @Override
    public Square clone() {
      return new Square(this);   
    }
    

    
}
