/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aly
 */
public class test {
    public static void main(String[] args) {
        try {
            ChessGame game=new ChessGame();
            File f=new File("ChessGame.txt");
            Scanner s=new Scanner(f);
            while(s.hasNextLine())
            {
                String n=s.nextLine();
                String y[]=n.split(",");
                game.playGame(y[0], y[1]);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}
