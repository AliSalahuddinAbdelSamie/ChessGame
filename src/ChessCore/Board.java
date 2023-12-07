/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

public class Board implements Prototype {
    private Square[][] squares;
    public Board(){
        this.squares=new Square[8][8];
        setupBoard();
    }
    //copy constructor
    private Board(Board board){
        this.squares=new Square[8][8]; 
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
            {
                if(board.getSquare(i, j).getPiece()==null)
                    this.squares[i][j]=new Square(i,j,null);
                else 
                this.squares[i][j]=new Square(i,j,board.getSquare(i, j).getPiece().Clone());
            }
    }
    @Override
    public Board Clone(){
        return new Board(this);
    }
    public void setupBoard(){
        
        squares[0][0]=new Square(0,0,new Rook(PieceColor.WHITE,"WR1"));
        squares[0][1]=new Square(0,1,new Knight(PieceColor.WHITE,"WK1"));
        squares[0][2]=new Square(0,2,new Bishop(PieceColor.WHITE,"WB1"));
        squares[0][3]=new Square(0,3,new Queen(PieceColor.WHITE,"WQ"));
        squares[0][4]=new Square(0,4,new King(PieceColor.WHITE,"WK"));
        squares[0][5]=new Square(0,5,new Bishop(PieceColor.WHITE,"WB2"));
        squares[0][6]=new Square(0,6,new Knight(PieceColor.WHITE,"WK2"));
        squares[0][7]=new Square(0,7,new Rook(PieceColor.WHITE,"WR2"));
        for(int k=0;k<8;k++){
            squares[1][k]=new Square(1,k,new Pawn(PieceColor.WHITE,"WP"+(k+1)));
            squares[6][k]=new Square(6,k,new Pawn(PieceColor.BLACK,"BP"+(k+1)));
        }
        
        squares[7][0]=new Square(7,0,new Rook(PieceColor.BLACK,"BR1"));
        squares[7][1]=new Square(7,1,new Knight(PieceColor.BLACK,"BK1"));
        squares[7][2]=new Square(7,2,new Bishop(PieceColor.BLACK,"BB1"));
        squares[7][3]=new Square(7,3,new Queen(PieceColor.BLACK,"BQ"));
        squares[7][4]=new Square(7,4,new King(PieceColor.BLACK,"BK"));
        squares[7][5]=new Square(7,5,new Bishop(PieceColor.BLACK,"BB2"));
        squares[7][6]=new Square(7,6,new Knight(PieceColor.BLACK,"BK2"));
        squares[7][7]=new Square(7,7,new Rook(PieceColor.BLACK,"BR2"));
        
            
        
        for(int i=2;i<6;i++)
            for(int j=0;j<8;j++)
            {
                squares[i][j]=new Square(i,j,null);
            }
        
    }
    public Square getSquare(int row,int col){
        try{
            Square s=squares[row][col];
            return s;
        }catch(ArrayIndexOutOfBoundsException e){
            return null ;
        }
           
    }

    
    public boolean checkPath(Square s,Square d){
        int rowDistance=d.getRowPos()-s.getRowPos();
        int colDistance=d.getColPos()-s.getColPos();
        int rowDirection;
        int colDirection;
        int numberOfSteps;
        if(rowDistance<0)
            rowDirection=-1;
        else rowDirection=1;
        if(colDistance<0)
            colDirection=-1;
        else colDirection=1;
        if (colDistance != 0) {
            numberOfSteps = Math.abs(colDistance) - 1;
	} else {
            numberOfSteps = Math.abs(rowDistance) - 1;
	}
        int rowPos=s.getRowPos();
        int colPos=s.getColPos();
        for (int i = 0; i < numberOfSteps; i++) {
            if(rowDistance==0){
                colPos+=colDirection;
            }else if(colDistance==0){
                rowPos+=rowDirection;
            }else{
             rowPos+=rowDirection;
             colPos+=colDirection;
            }
            if(squares[rowPos][colPos].getPiece()!=null)
                return false;    
        }	
	return true;
   
    }
    public Square getKingPosition(PieceColor color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getSquare(i, j).getPiece() instanceof King && getSquare(i, j).getPiece().getColor()==color) {
                    return getSquare(i, j);
                }
            }
        }
        return null;

    }
    public Square getRookIfAvailableForCastling(PieceColor color,int direction){
        Square s;
        if(color==PieceColor.WHITE){
            if(direction==1)
            {
              s=getSquare(0,7);   
            }
            else s=getSquare(0,0);
            
    }else {
          if(direction==1)
            {
              s=getSquare(7,7);   
            }
            else s=getSquare(7,0);  
            
        }
        if(s.isEmpty())
            return null;
        else if(s.getPiece().getHasMoved())
            return null;
        else return s;
}
    public int countPieces(PieceColor color) {
    int count = 0;
    for (int row = 0; row < 8; row++) {
        for (int col = 0; col < 8; col++) {
            if (getSquare(row, col).getPiece() != null && getSquare(row, col).getPiece().getColor() == color) {
                count++;
            }
        }
    }
    return count;
}
      
}    
