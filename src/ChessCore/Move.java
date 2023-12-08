/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

public class Move implements Prototype {
    
    private final Square source;
    private final Square destination;
    private MoveStatus status;
    public Move(Square source,Square destination){
        this.source=source;
        this.destination=destination;
        status=MoveStatus.NORMAL;
    }
    private Move(Move move){
        this.source=move.getSource().clone();
        this.destination=move.getDestination().clone();
        this.status=move.getStatus();
    }

    public MoveStatus getStatus() {
        return status;
    }

    public void setStatus(MoveStatus status) {
        this.status = status;
    }

    
    
    public Square getSource() {
        return source;
    }

    public Square getDestination() {
        return destination;
    }
    public String getPos(){
        return String.valueOf(source.getRowPos())+String.valueOf(source.getColPos())+" "+String.valueOf(destination.getRowPos())+String.valueOf(destination.getColPos());
    }

    @Override
    public Move clone() {
        return new Move(this);
    }

    
    
}
