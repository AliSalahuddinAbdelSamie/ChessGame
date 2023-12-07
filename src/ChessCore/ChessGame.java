/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

import java.util.ArrayList;
import java.util.Stack;

public class ChessGame  {
    private Board board;
    private Move lastMove;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private GameStatus status;
    private Move currentMove;
    
    
    public ChessGame(){
        board=new Board();
        lastMove=null;
        player1=new Player(PieceColor.WHITE);
        player2=new Player(PieceColor.BLACK);
        currentPlayer=player1;
        status=GameStatus.ACTIVE;
        
    }

    public Board getBoard() {
        return board;
    }
    public boolean isValidMove(String source,String dest){
        return isValidMove(new Move(changeNameToSquare(source),changeNameToSquare(dest)));
    }
    public boolean isValidMove(Move move){
        
        
        
        if(checkMovePutsItselfInCheck(move))
            return false;
        
        return isValidMoveWithoutCheck(move);
    }
    public boolean isValidMoveWithoutCheck(Move move){
        if((currentPlayer==player1 && move.getSource().getPiece().getColor()!=PieceColor.WHITE) || (currentPlayer==player2 &&move.getSource().getPiece().getColor()!=PieceColor.BLACK))
            return false;
        return isValidMoveWithoutTurn( move);
    }
    private boolean isValidMoveWithoutTurn(Move move){
        
        if (move.getSource().getPiece() instanceof Pawn)
            ((Pawn)move.getSource().getPiece()).setLastMove(lastMove);
        
        if(move.getSource().getPiece().isValidMove(move))
        {
            
            if(move.getStatus()==MoveStatus.CASTLING){

                Square s=board.getRookIfAvailableForCastling(move.getSource().getPiece().getColor(),getDirectionForCastling(move));
                if(s!=null){
                    return board.checkPath(move.getSource(),s);
                }
                else return false;
            }
            
            if(move.getSource().getPiece() instanceof Knight)
                return true;
            else
                return board.checkPath(move.getSource(),move.getDestination());   
        }
        else return false;
    }
   private boolean checkMovePutsItselfInCheck(Move move){
        GameStatus s=(move.getSource().getPiece().getColor()==PieceColor.WHITE)?GameStatus.WHITEINCHECK:GameStatus.BLACKINCHECK;
        GameStatus originalStatus=status; 
        Piece p=tempMove(move);
        if(status==s)
            {
                undoMove(move,p,originalStatus);
                return true;
            }
            undoMove(move,p,originalStatus);    
            return false;
    }
    //gets all valid moves from a target square
    public ArrayList<Move> getAllValidMovesFromSquare(Square source){
        ArrayList<Move> moves=new ArrayList<>();
         if (source == null ||source.isEmpty()) {
            return moves;
        }
        for (int i = 0; i < 8; i++) {
            for (int j= 0; j < 8; j++) {
                Square temp = board.getSquare(i,j);
                Move move=new Move(source,temp);
                if (isValidMoveWithoutCheck(move)) {
                    if(!checkMovePutsItselfInCheck(move))
                    moves.add(move);
                }   
            }
        }
        return moves;
    }
    public ArrayList<Move> getAllValidMovesFromSquareInternal(Square source){
        ArrayList<Move> moves=new ArrayList<>();
         if (source == null ||source.isEmpty()) {
            return moves;
        }
        for (int i = 0; i < 8; i++) {
            for (int j= 0; j < 8; j++) {
                Square temp = board.getSquare(i,j);
                Move move=new Move(source,temp);
                if (isValidMoveWithoutTurn(move)) {
                    moves.add(move);
                }   
            }
        }
        return moves;
    }
    public ArrayList<Move> getAllValidMovesFromSquare(String source){
        
        return getAllValidMovesFromSquare(changeNameToSquare(source));
    }
    public boolean playGame(String source,String destination)
    {   
         
        if(status==GameStatus.BLACK_WIN ||status==GameStatus.WHITE_WIN||status==GameStatus.STALEMATE||status==GameStatus.INSUFFICIENTMATERIAL){
            System.out.println("Game already ended");
            return false;
        }
        Square s;
        Square d;
        try{
            s=changeNameToSquare(source);
            d=changeNameToSquare(destination);
            PieceColor c=s.getPiece().getColor();
        }catch(NumberFormatException e){
            System.out.println("Invalid move");
            return false;
        }catch(NullPointerException e){
            System.out.println("Invalid move");
            return false;
        }
        if(d.getPiece() instanceof King)
            return false;
                  
        Piece capturedPiece=d.getPiece();
        currentMove=new Move(s,d);
        if(isValidMove(currentMove))
        {     
            currentMove.getSource().getPiece().setHasMoved(true);
            lastMove=currentMove; 
            d.setPiece(s.getPiece());
            s.setPiece(null);
            if(currentMove.getStatus()==MoveStatus.ENPASSENT){
                System.out.println("Enpassant");
                capturedPiece=board.getSquare(currentMove.getSource().getRowPos(), currentMove.getDestination().getColPos()).getPiece();        
                board.getSquare(currentMove.getSource().getRowPos(), currentMove.getDestination().getColPos()).setPiece(null);
            }
            if(currentMove.getStatus()==MoveStatus.CASTLING){
                Square forRook=null;
                int direction=getDirectionForCastling(currentMove);
                System.out.println("Castle");
                forRook=board.getRookIfAvailableForCastling(currentMove.getDestination().getPiece().getColor(), direction);
                forRook.getPiece().setHasMoved(true);
                board.getSquare(currentMove.getDestination().getRowPos(),currentMove.getDestination().getColPos()+(direction*-1)).setPiece(forRook.getPiece());
                forRook.setPiece(null);
            }
            if((d.getPiece() instanceof Pawn && d.getPiece().getColor()==PieceColor.WHITE && d.getRowPos()==7)||(d.getPiece() instanceof Pawn && d.getPiece().getColor()==PieceColor.BLACK && d.getRowPos()==0))
                currentMove.setStatus(MoveStatus.PROMOTION);
            if(capturedPiece!=null){
                System.out.println("Captured "+capturedPiece);
                currentPlayer.decreaseNumberOfPieces(capturedPiece);
                
                
            }
                
            updateGameStatus();
            switchPlayers();
            return true;    
        }
        else {
            System.out.println("Invalid move");
            return false;
        }
        
       
        
    }
    public Square getKingPos(PieceColor color){
        
            return board.getKingPosition(color);
    }
    public GameStatus getStatus(){
        return status;
    }
    public MoveStatus getCurrentMoveStatus(){
        return currentMove.getStatus();
    }
    //handles promotion
    public PieceColor promotionHandling(char promotion){
        Player temp=(currentPlayer==player1)?player2:player1;
        Square d=currentMove.getDestination();
        switch (promotion){
                    case 'K': 
                    d.setPiece(new Knight(d.getPiece().getColor(),d.getPiece().getName()));
                    temp.setNumbersForPromotion(d.getPiece());
                    updateGameStatus();
                    return d.getPiece().getColor();
                case 'B':
                    d.setPiece(new Bishop(d.getPiece().getColor(),d.getPiece().getName()));
                    temp.setNumbersForPromotion(d.getPiece());
                    updateGameStatus();
                    return d.getPiece().getColor();
                case 'R':
                    d.setPiece(new Rook(d.getPiece().getColor(),d.getPiece().getName()));
                    temp.setNumbersForPromotion(d.getPiece());
                    updateGameStatus();
                    return d.getPiece().getColor();
                case 'Q':
                    d.setPiece(new Queen(d.getPiece().getColor(),d.getPiece().getName()));
                    temp.setNumbersForPromotion(d.getPiece());
                    updateGameStatus();
                    return d.getPiece().getColor();
                default:
                    return d.getPiece().getColor();
    }
    }

    private GameStatus updateStatusForCheck() {
        Square s ;
        Square blackKingSquare =board.getKingPosition(PieceColor.BLACK);
        Square whiteKingSquare =board.getKingPosition(PieceColor.WHITE);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board.getSquare(i, j).isEmpty())
                    continue;
                if(board.getSquare(i, j).getPiece().getColor()!=PieceColor.WHITE)
                    continue;
                 s = board.getSquare(i, j);
                Move move = new Move(s, blackKingSquare);
               
                if (isValidMoveWithoutTurn(move)) {
                    
                    return GameStatus.BLACKINCHECK;
                   
                }

            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board.getSquare(i, j).isEmpty())
                    continue;
                if(board.getSquare(i, j).getPiece().getColor()!=PieceColor.BLACK)
                    continue;
                 s = board.getSquare(i, j); 
                Move move = new Move(s, whiteKingSquare);
                if (isValidMoveWithoutTurn(move))
                {
                    
                    return GameStatus.WHITEINCHECK;
                     
                }

            }
        }
       
        return  GameStatus.ACTIVE;
    }
    private boolean isCheckmate(){
        PieceColor checker;
        GameStatus originalStatus=status;
        
        if(status==GameStatus.BLACKINCHECK){
             checker=PieceColor.BLACK;
             
        }
        else {checker=PieceColor.WHITE;
            }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board.getSquare(i, j).isEmpty())
                    continue;
                if(board.getSquare(i, j).getPiece().getColor()!=checker)
                    continue;
                ArrayList<Move> moves=getAllValidMovesFromSquareInternal(board.getSquare(i, j));
                
                for(Move x:moves){   
                    if(!checkMovePutsItselfInCheck(x))
                        return false;
                }
             
            }
        
        }
        
        
        return true;
        
    }
    private boolean isInStaleMate(){
        PieceColor checker;
        GameStatus originalStatus=status;  
        if(status==GameStatus.WHITEINCHECK||status==GameStatus.BLACKINCHECK)
            return false;
        if(currentPlayer==player1){
             checker=PieceColor.BLACK;
             
        }
        else {
            checker=PieceColor.WHITE;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board.getSquare(i, j).isEmpty())
                    continue;
                if(board.getSquare(i, j).getPiece().getColor()!=checker)
                    continue;
                ArrayList<Move> moves=getAllValidMovesFromSquareInternal(board.getSquare(i, j));
                
                for(Move x:moves){   
                     if(!checkMovePutsInCheckForStalemate(x))
                        return false;                        
                }
             
            }
        
        }
          
        return true;
        
    }
    private boolean checkMovePutsInCheckForStalemate(Move move){
        GameStatus originalStatus=status;
        Piece p=tempMove(move);
        if(status==GameStatus.ACTIVE)
            {
                undoMove(move,p,originalStatus);
                return false;
            }
            undoMove(move,p,originalStatus);    
            return true;
    }
    
    private Square changeNameToSquare(String name) throws NumberFormatException{
        return board.getSquare(Integer.parseInt(name.substring(1))-1,(int)(name.toLowerCase().charAt(0)-'a'));
    }
    

    private int getDirectionForCastling(Move move){
        int direction;
        if(move.getDestination().getColPos()-move.getSource().getColPos()>0)
            direction=1;
        else direction=-1;
        return direction;
    }
    
    
    private boolean isInsufficientMaterial()
    {
       int totalWhitePieces = board.countPieces(PieceColor.WHITE);
       int totalBlackPieces = board.countPieces(PieceColor.BLACK);
       return totalWhitePieces == 1 && totalBlackPieces == 1 ||
              (totalWhitePieces == 2 && totalBlackPieces == 2 && player1.getKnights()==1 && player2.getKnights()==1 ) ||
               (totalWhitePieces == 2 && totalBlackPieces == 2 && player2.getBishops()==1 && player1.getBishops()==1) || 
               (totalWhitePieces == 1 && totalBlackPieces == 3 && player2.getKnights()==2) ||
               (totalWhitePieces == 3 && totalBlackPieces == 1 && player1.getKnights()==2);
   
    }

    private void updateGameStatus(){
        if( updateStatusForCheck()!=GameStatus.ACTIVE){
             status= updateStatusForCheck();
            if(isCheckmate()){
                status=(updateStatusForCheck()==GameStatus.WHITEINCHECK)?GameStatus.BLACK_WIN:GameStatus.WHITE_WIN;
                if(status==GameStatus.WHITE_WIN)
                System.out.println("White Won");
                else System.out.println("Black Won");
                return;
            }
           
            if(status==GameStatus.WHITEINCHECK)
                System.out.println("White in check");
            else System.out.println("Black in check");
        }else if(isInStaleMate()){
            status=GameStatus.STALEMATE;
            System.out.println("Stalemate");
        }else if(isInsufficientMaterial()){
            status=GameStatus.INSUFFICIENTMATERIAL;
            System.out.println("Insufficient Material");
        }
        else status=GameStatus.ACTIVE;
    }
    private void switchPlayers(){
        if(currentPlayer.getColor()==PieceColor.WHITE)
            currentPlayer=player2;
        else currentPlayer=player1;
    }

    private void undoMove(Move move,Piece piece,GameStatus status){
        move.getSource().setPiece(move.getDestination().getPiece());
        move.getDestination().setPiece(piece);
        this.status=status;
    }
    private Piece tempMove(Move move){
        Piece capturedPiece =move.getDestination().getPiece();
        move.getDestination().setPiece(move.getSource().getPiece());
        move.getSource().setPiece(null);
        status=updateStatusForCheck();
        return capturedPiece;
    }
    public Memento savepoint(){
        return new Memento(board,lastMove,currentPlayer,status,currentMove);
    }
    public void restoreToSavepoint(Memento memento){
        this.board=memento.getBoard();
        this.lastMove=memento.getLastMove();
        this.currentPlayer=memento.getCurrentPlayer();
        this.status=memento.getStatus();
        this.currentMove=memento.getCurrentMove();
        
    }
    
    public static class Memento{
        private final Board board;
        private final Move lastMove;
        private final Player currentPlayer;
        private final GameStatus status;
        private final Move currentMove;
        

        private Memento(Board board, Move lastMove, Player currentPlayer, GameStatus status, Move currentMove) {
            this.board = new Board(board);
            this.lastMove = lastMove;
            this.currentPlayer = currentPlayer;
            this.status = status;
            this.currentMove = currentMove;
            
        }

        private Board getBoard() {
            return board;
        }

        private Move getLastMove() {
            return lastMove;
        }

        private Player getCurrentPlayer() {
            return currentPlayer;
        }

        private GameStatus getStatus() {
            return status;
        }

        private Move getCurrentMove() {
            return currentMove;
        }

        
        
        
    }
}
