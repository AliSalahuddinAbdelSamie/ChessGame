
package ChessGui;

import ChessCore.Board;
import ChessCore.ChessGame;
import ChessCore.ChessGame.Memento;
import ChessCore.GameStatus;
import ChessCore.Move;
import ChessCore.MoveStatus;
import ChessCore.PieceColor;
import ChessCore.Square;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class BoardFrame extends javax.swing.JFrame {

    private ChessGame game;
    private HashMap<String,myPanel> map;
    private JPanel[] panelArray;
    private JLabel[] labelArray;
    private ArrayList<Color> originalColors;
    private JLabel lastClicked;
    private Stack<Memento> gameHistory;
    private HashMap<String,myLabel> labelMap;
    private ArrayList<myLabel> promotedPieces;
    private final Icon whitePawnIcon;
    private final Icon blackPawnIcon;
    public BoardFrame() {
        initComponents();
        whitePawnIcon=whitePawn1.getIcon();
        blackPawnIcon=blackPawn1.getIcon();
        gameHistory=new Stack<>();
        lastClicked=null;
        game=new ChessGame();
        map=new HashMap<>();
        labelMap=new HashMap<>();
        promotedPieces=new ArrayList<>();
        originalColors=new ArrayList<>();
        panelArray = new JPanel[]   {a1, a2, a3, a4, a5, a6, a7, a8, b1, b2, b3, b4, b5, b6, b7, b8,
                                    c1, c2, c3, c4, c5, c6, c7, c8, d1, d2, d3, d4, d5, d6, d7, d8,
                                    e1, e2, e3, e4, e5, e6, e7, e8, f1, f2, f3, f4, f5, f6, f7, f8,
                                    g1, g2, g3, g4, g5, g6, g7, g8, h1, h2, h3, h4, h5, h6, h7, h8};
        labelArray=new JLabel[]     {whiteRook1,whiteKnight1,whiteBishop1,whiteQueen,whiteKing,whiteBishop2,
                                     whiteKnight2,whiteRook2,whitePawn1,whitePawn2,whitePawn3,whitePawn4,whitePawn5,
                                     whitePawn6,whitePawn7,whitePawn8,blackRook1,blackKnight1,blackBishop1,blackQueen,
                                     blackKing,blackBishop2,blackKnight2,blackRook2,blackPawn1,blackPawn2,blackPawn3,
                                     blackPawn4,blackPawn5,blackPawn6,blackPawn7,blackPawn8
                                     };
        for(JLabel i:labelArray){
            myLabel temp=(myLabel) i;
             i.addMouseListener(new mouseClickedLabel());
            labelMap.put(temp.getName(), temp);
        }
        for(JPanel i: panelArray){
            originalColors.add(i.getBackground());
            myPanel temp=(myPanel) i;
            i.addMouseListener(new mouseClicked());
            map.put(temp.getName(), temp);
        }
        
    }
    private class mouseClicked extends MouseAdapter{
        public void mousePressed(java.awt.event.MouseEvent evt) {
                updateBoard(evt);
            }
    }
    private class mouseClickedLabel extends MouseAdapter{
        public void mousePressed(java.awt.event.MouseEvent evt) {
                JLabel temp=(JLabel) evt.getSource();
                myPanel parent=(myPanel)temp.getParent();
                if(!updateBoard(evt))
                highlightAllValidDestinations(parent);
                lastClicked=temp;
            }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        a8 = new myPanel("a8");
        blackRook1 = new myLabel("BR1");
        b8 = new myPanel("b8");
        blackKnight1 = new myLabel("BK1");
        b7 = new myPanel("b7");
        blackPawn2 = new myLabel("BP2");
        a7 = new myPanel("a7");
        blackPawn1 = new myLabel("BP1");
        a5 = new myPanel("a5");
        b5 = new myPanel("b5");
        b6 = new myPanel("b6");
        a6 = new myPanel("a6");
        a2 = new myPanel("a2");
        whitePawn1 = new myLabel("WP1");
        b2 = new myPanel("b2");
        whitePawn2 = new myLabel("WP2");
        b1 = new myPanel("b1");
        whiteKnight1 = new myLabel("WK1");
        a1 = new myPanel("a1");
        whiteRook1 = new myLabel("WR1");
        a3 = new myPanel("a3");
        b3 = new myPanel("b3");
        b4 = new myPanel("b4");
        a4 = new myPanel("a4");
        d8 = new myPanel("d8");
        blackQueen = new myLabel("BQ");
        c3 = new myPanel("c3");
        c8 = new myPanel("c8");
        blackBishop1 = new myLabel("BB1");
        c1 = new myPanel("c1");
        whiteBishop1 = new myLabel("WB1");
        d1 = new myPanel("d1");
        whiteQueen = new myLabel("WQ");
        d2 = new myPanel("d2");
        whitePawn4 = new myLabel("WP4");
        c2 = new myPanel("c2");
        whitePawn3 = new myLabel("WP3");
        c6 = new myPanel("c6");
        d6 = new myPanel("d6");
        d5 = new myPanel("d5");
        c5 = new myPanel("c5");
        c4 = new myPanel("c4");
        c7 = new myPanel("c7");
        blackPawn3 = new myLabel("BP3");
        d4 = new myPanel("d4");
        d7 = new myPanel("d7");
        blackPawn4 = new myLabel("BP4");
        d3 = new myPanel("d3");
        f8 = new myPanel("f8");
        blackBishop2 = new myLabel("BB2");
        g6 = new myPanel("g6");
        e8 = new myPanel("e8");
        blackKing = new myLabel("BK");
        g2 = new myPanel("g2");
        whitePawn7 = new myLabel("WP7");
        h2 = new myPanel("h2");
        whitePawn8 = new myLabel("WP8");
        h1 = new myPanel("h1");
        whiteRook2 = new myLabel("WR2");
        g1 = new myPanel("g1");
        whiteKnight2 = new myLabel("WK2");
        g8 = new myPanel("g8");
        blackKnight2 = new myLabel("BK2");
        g3 = new myPanel("g3");
        h8 = new myPanel("h8");
        blackRook2 = new myLabel("BR2");
        e4 = new myPanel("e4");
        f4 = new myPanel("f4");
        f3 = new myPanel("f3");
        e3 = new myPanel("e3");
        e1 = new myPanel("e1");
        whiteKing = new myLabel("WK");
        f1 = new myPanel("f1");
        whiteBishop2 = new myLabel("WB2");
        h3 = new myPanel("h3");
        h7 = new myPanel("h7");
        blackPawn8 = new myLabel("BP8");
        f2 = new myPanel("f2");
        whitePawn6 = new myLabel("WP6");
        e2 = new myPanel("e2");
        whitePawn5 = new myLabel("WP5");
        e6 = new myPanel("e6");
        h4 = new myPanel("h4");
        f6 = new myPanel("f6");
        g7 = new myPanel("g7");
        blackPawn7 = new myLabel("BP7");
        f5 = new myPanel("f5");
        g4 = new myPanel("g4");
        e5 = new myPanel("e5");
        g5 = new myPanel("g5");
        e7 = new myPanel("e7");
        blackPawn5 = new myLabel("BP5");
        h5 = new myPanel("h5");
        f7 = new myPanel("f7");
        blackPawn6 = new myLabel("BP6");
        h6 = new myPanel("h6");
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ChessGame");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        a8.setBackground(new java.awt.Color(255, 183, 122));

        blackRook1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackRook.png"))); // NOI18N

        javax.swing.GroupLayout a8Layout = new javax.swing.GroupLayout(a8);
        a8.setLayout(a8Layout);
        a8Layout.setHorizontalGroup(
            a8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(blackRook1)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        a8Layout.setVerticalGroup(
            a8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(blackRook1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        b8.setBackground(new java.awt.Color(60, 33, 6));

        blackKnight1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackKnight.png"))); // NOI18N

        javax.swing.GroupLayout b8Layout = new javax.swing.GroupLayout(b8);
        b8.setLayout(b8Layout);
        b8Layout.setHorizontalGroup(
            b8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(b8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(blackKnight1)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        b8Layout.setVerticalGroup(
            b8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(b8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(blackKnight1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        b7.setBackground(new java.awt.Color(255, 183, 122));

        blackPawn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackPawn.png"))); // NOI18N

        javax.swing.GroupLayout b7Layout = new javax.swing.GroupLayout(b7);
        b7.setLayout(b7Layout);
        b7Layout.setHorizontalGroup(
            b7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(b7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(blackPawn2)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        b7Layout.setVerticalGroup(
            b7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(b7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(blackPawn2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        a7.setBackground(new java.awt.Color(60, 33, 6));

        blackPawn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackPawn.png"))); // NOI18N

        javax.swing.GroupLayout a7Layout = new javax.swing.GroupLayout(a7);
        a7.setLayout(a7Layout);
        a7Layout.setHorizontalGroup(
            a7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(blackPawn1)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        a7Layout.setVerticalGroup(
            a7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(blackPawn1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        a5.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout a5Layout = new javax.swing.GroupLayout(a5);
        a5.setLayout(a5Layout);
        a5Layout.setHorizontalGroup(
            a5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        a5Layout.setVerticalGroup(
            a5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        b5.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout b5Layout = new javax.swing.GroupLayout(b5);
        b5.setLayout(b5Layout);
        b5Layout.setHorizontalGroup(
            b5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        b5Layout.setVerticalGroup(
            b5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        b6.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout b6Layout = new javax.swing.GroupLayout(b6);
        b6.setLayout(b6Layout);
        b6Layout.setHorizontalGroup(
            b6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        b6Layout.setVerticalGroup(
            b6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        a6.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout a6Layout = new javax.swing.GroupLayout(a6);
        a6.setLayout(a6Layout);
        a6Layout.setHorizontalGroup(
            a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        a6Layout.setVerticalGroup(
            a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        a2.setBackground(new java.awt.Color(255, 183, 122));

        whitePawn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhitePawn.png"))); // NOI18N

        javax.swing.GroupLayout a2Layout = new javax.swing.GroupLayout(a2);
        a2.setLayout(a2Layout);
        a2Layout.setHorizontalGroup(
            a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(whitePawn1)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        a2Layout.setVerticalGroup(
            a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(whitePawn1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        b2.setBackground(new java.awt.Color(60, 33, 6));

        whitePawn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhitePawn.png"))); // NOI18N

        javax.swing.GroupLayout b2Layout = new javax.swing.GroupLayout(b2);
        b2.setLayout(b2Layout);
        b2Layout.setHorizontalGroup(
            b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(b2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(whitePawn2)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        b2Layout.setVerticalGroup(
            b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(b2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(whitePawn2)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        b1.setBackground(new java.awt.Color(255, 183, 122));

        whiteKnight1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhiteKnight.png"))); // NOI18N

        javax.swing.GroupLayout b1Layout = new javax.swing.GroupLayout(b1);
        b1.setLayout(b1Layout);
        b1Layout.setHorizontalGroup(
            b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(b1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(whiteKnight1)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        b1Layout.setVerticalGroup(
            b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(b1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(whiteKnight1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        a1.setBackground(new java.awt.Color(60, 33, 6));

        whiteRook1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhiteRook.png"))); // NOI18N

        javax.swing.GroupLayout a1Layout = new javax.swing.GroupLayout(a1);
        a1.setLayout(a1Layout);
        a1Layout.setHorizontalGroup(
            a1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(whiteRook1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        a1Layout.setVerticalGroup(
            a1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(whiteRook1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        a3.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout a3Layout = new javax.swing.GroupLayout(a3);
        a3.setLayout(a3Layout);
        a3Layout.setHorizontalGroup(
            a3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        a3Layout.setVerticalGroup(
            a3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        b3.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout b3Layout = new javax.swing.GroupLayout(b3);
        b3.setLayout(b3Layout);
        b3Layout.setHorizontalGroup(
            b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        b3Layout.setVerticalGroup(
            b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        b4.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout b4Layout = new javax.swing.GroupLayout(b4);
        b4.setLayout(b4Layout);
        b4Layout.setHorizontalGroup(
            b4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        b4Layout.setVerticalGroup(
            b4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        a4.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout a4Layout = new javax.swing.GroupLayout(a4);
        a4.setLayout(a4Layout);
        a4Layout.setHorizontalGroup(
            a4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        a4Layout.setVerticalGroup(
            a4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        d8.setBackground(new java.awt.Color(60, 33, 6));

        blackQueen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackQueen.png"))); // NOI18N

        javax.swing.GroupLayout d8Layout = new javax.swing.GroupLayout(d8);
        d8.setLayout(d8Layout);
        d8Layout.setHorizontalGroup(
            d8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(blackQueen)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        d8Layout.setVerticalGroup(
            d8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(blackQueen)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        c3.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout c3Layout = new javax.swing.GroupLayout(c3);
        c3.setLayout(c3Layout);
        c3Layout.setHorizontalGroup(
            c3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        c3Layout.setVerticalGroup(
            c3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        c8.setBackground(new java.awt.Color(255, 183, 122));

        blackBishop1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackBishop.png"))); // NOI18N

        javax.swing.GroupLayout c8Layout = new javax.swing.GroupLayout(c8);
        c8.setLayout(c8Layout);
        c8Layout.setHorizontalGroup(
            c8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(blackBishop1)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        c8Layout.setVerticalGroup(
            c8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(blackBishop1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        c1.setBackground(new java.awt.Color(60, 33, 6));

        whiteBishop1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhiteBishop.png"))); // NOI18N

        javax.swing.GroupLayout c1Layout = new javax.swing.GroupLayout(c1);
        c1.setLayout(c1Layout);
        c1Layout.setHorizontalGroup(
            c1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(whiteBishop1)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        c1Layout.setVerticalGroup(
            c1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(whiteBishop1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        d1.setBackground(new java.awt.Color(255, 183, 122));

        whiteQueen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhiteQueen.png"))); // NOI18N

        javax.swing.GroupLayout d1Layout = new javax.swing.GroupLayout(d1);
        d1.setLayout(d1Layout);
        d1Layout.setHorizontalGroup(
            d1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(whiteQueen)
                .addGap(16, 16, 16))
        );
        d1Layout.setVerticalGroup(
            d1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(whiteQueen)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        d2.setBackground(new java.awt.Color(60, 33, 6));

        whitePawn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhitePawn.png"))); // NOI18N

        javax.swing.GroupLayout d2Layout = new javax.swing.GroupLayout(d2);
        d2.setLayout(d2Layout);
        d2Layout.setHorizontalGroup(
            d2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(whitePawn4)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        d2Layout.setVerticalGroup(
            d2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(whitePawn4)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        c2.setBackground(new java.awt.Color(255, 183, 122));

        whitePawn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhitePawn.png"))); // NOI18N

        javax.swing.GroupLayout c2Layout = new javax.swing.GroupLayout(c2);
        c2.setLayout(c2Layout);
        c2Layout.setHorizontalGroup(
            c2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(whitePawn3)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        c2Layout.setVerticalGroup(
            c2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(whitePawn3)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        c6.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout c6Layout = new javax.swing.GroupLayout(c6);
        c6.setLayout(c6Layout);
        c6Layout.setHorizontalGroup(
            c6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        c6Layout.setVerticalGroup(
            c6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        d6.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout d6Layout = new javax.swing.GroupLayout(d6);
        d6.setLayout(d6Layout);
        d6Layout.setHorizontalGroup(
            d6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        d6Layout.setVerticalGroup(
            d6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        d5.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout d5Layout = new javax.swing.GroupLayout(d5);
        d5.setLayout(d5Layout);
        d5Layout.setHorizontalGroup(
            d5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        d5Layout.setVerticalGroup(
            d5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        c5.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout c5Layout = new javax.swing.GroupLayout(c5);
        c5.setLayout(c5Layout);
        c5Layout.setHorizontalGroup(
            c5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        c5Layout.setVerticalGroup(
            c5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        c4.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout c4Layout = new javax.swing.GroupLayout(c4);
        c4.setLayout(c4Layout);
        c4Layout.setHorizontalGroup(
            c4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        c4Layout.setVerticalGroup(
            c4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        c7.setBackground(new java.awt.Color(60, 33, 6));

        blackPawn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackPawn.png"))); // NOI18N

        javax.swing.GroupLayout c7Layout = new javax.swing.GroupLayout(c7);
        c7.setLayout(c7Layout);
        c7Layout.setHorizontalGroup(
            c7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(blackPawn3)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        c7Layout.setVerticalGroup(
            c7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(blackPawn3)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        d4.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout d4Layout = new javax.swing.GroupLayout(d4);
        d4.setLayout(d4Layout);
        d4Layout.setHorizontalGroup(
            d4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        d4Layout.setVerticalGroup(
            d4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        d7.setBackground(new java.awt.Color(255, 183, 122));

        blackPawn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackPawn.png"))); // NOI18N

        javax.swing.GroupLayout d7Layout = new javax.swing.GroupLayout(d7);
        d7.setLayout(d7Layout);
        d7Layout.setHorizontalGroup(
            d7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(blackPawn4)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        d7Layout.setVerticalGroup(
            d7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(blackPawn4)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        d3.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout d3Layout = new javax.swing.GroupLayout(d3);
        d3.setLayout(d3Layout);
        d3Layout.setHorizontalGroup(
            d3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        d3Layout.setVerticalGroup(
            d3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        f8.setBackground(new java.awt.Color(60, 33, 6));

        blackBishop2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackBishop.png"))); // NOI18N

        javax.swing.GroupLayout f8Layout = new javax.swing.GroupLayout(f8);
        f8.setLayout(f8Layout);
        f8Layout.setHorizontalGroup(
            f8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(blackBishop2)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        f8Layout.setVerticalGroup(
            f8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(blackBishop2)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        g6.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout g6Layout = new javax.swing.GroupLayout(g6);
        g6.setLayout(g6Layout);
        g6Layout.setHorizontalGroup(
            g6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        g6Layout.setVerticalGroup(
            g6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        e8.setBackground(new java.awt.Color(255, 183, 122));

        blackKing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackKing.png"))); // NOI18N

        javax.swing.GroupLayout e8Layout = new javax.swing.GroupLayout(e8);
        e8.setLayout(e8Layout);
        e8Layout.setHorizontalGroup(
            e8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(e8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(blackKing)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        e8Layout.setVerticalGroup(
            e8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e8Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(blackKing)
                .addGap(16, 16, 16))
        );

        g2.setBackground(new java.awt.Color(255, 183, 122));

        whitePawn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhitePawn.png"))); // NOI18N

        javax.swing.GroupLayout g2Layout = new javax.swing.GroupLayout(g2);
        g2.setLayout(g2Layout);
        g2Layout.setHorizontalGroup(
            g2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, g2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(whitePawn7)
                .addGap(16, 16, 16))
        );
        g2Layout.setVerticalGroup(
            g2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(g2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(whitePawn7)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        h2.setBackground(new java.awt.Color(60, 33, 6));

        whitePawn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhitePawn.png"))); // NOI18N

        javax.swing.GroupLayout h2Layout = new javax.swing.GroupLayout(h2);
        h2.setLayout(h2Layout);
        h2Layout.setHorizontalGroup(
            h2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(h2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(whitePawn8)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        h2Layout.setVerticalGroup(
            h2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(h2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(whitePawn8)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        h1.setBackground(new java.awt.Color(255, 183, 122));

        whiteRook2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhiteRook.png"))); // NOI18N

        javax.swing.GroupLayout h1Layout = new javax.swing.GroupLayout(h1);
        h1.setLayout(h1Layout);
        h1Layout.setHorizontalGroup(
            h1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, h1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(whiteRook2)
                .addGap(16, 16, 16))
        );
        h1Layout.setVerticalGroup(
            h1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(h1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(whiteRook2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        g1.setBackground(new java.awt.Color(60, 33, 6));

        whiteKnight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhiteKnight.png"))); // NOI18N

        javax.swing.GroupLayout g1Layout = new javax.swing.GroupLayout(g1);
        g1.setLayout(g1Layout);
        g1Layout.setHorizontalGroup(
            g1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(g1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(whiteKnight2)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        g1Layout.setVerticalGroup(
            g1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(g1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(whiteKnight2)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        g8.setBackground(new java.awt.Color(255, 183, 122));

        blackKnight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackKnight.png"))); // NOI18N

        javax.swing.GroupLayout g8Layout = new javax.swing.GroupLayout(g8);
        g8.setLayout(g8Layout);
        g8Layout.setHorizontalGroup(
            g8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(g8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(blackKnight2)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        g8Layout.setVerticalGroup(
            g8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(g8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(blackKnight2)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        g3.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout g3Layout = new javax.swing.GroupLayout(g3);
        g3.setLayout(g3Layout);
        g3Layout.setHorizontalGroup(
            g3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        g3Layout.setVerticalGroup(
            g3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        h8.setBackground(new java.awt.Color(60, 33, 6));

        blackRook2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackRook.png"))); // NOI18N

        javax.swing.GroupLayout h8Layout = new javax.swing.GroupLayout(h8);
        h8.setLayout(h8Layout);
        h8Layout.setHorizontalGroup(
            h8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(h8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(blackRook2)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        h8Layout.setVerticalGroup(
            h8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(h8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(blackRook2)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        e4.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout e4Layout = new javax.swing.GroupLayout(e4);
        e4.setLayout(e4Layout);
        e4Layout.setHorizontalGroup(
            e4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        e4Layout.setVerticalGroup(
            e4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        f4.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout f4Layout = new javax.swing.GroupLayout(f4);
        f4.setLayout(f4Layout);
        f4Layout.setHorizontalGroup(
            f4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        f4Layout.setVerticalGroup(
            f4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        f3.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout f3Layout = new javax.swing.GroupLayout(f3);
        f3.setLayout(f3Layout);
        f3Layout.setHorizontalGroup(
            f3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        f3Layout.setVerticalGroup(
            f3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        e3.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout e3Layout = new javax.swing.GroupLayout(e3);
        e3.setLayout(e3Layout);
        e3Layout.setHorizontalGroup(
            e3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        e3Layout.setVerticalGroup(
            e3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        e1.setBackground(new java.awt.Color(60, 33, 6));

        whiteKing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhiteKing.png"))); // NOI18N

        javax.swing.GroupLayout e1Layout = new javax.swing.GroupLayout(e1);
        e1.setLayout(e1Layout);
        e1Layout.setHorizontalGroup(
            e1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, e1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(whiteKing)
                .addGap(16, 16, 16))
        );
        e1Layout.setVerticalGroup(
            e1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(e1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(whiteKing)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        f1.setBackground(new java.awt.Color(255, 183, 122));

        whiteBishop2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhiteBishop.png"))); // NOI18N

        javax.swing.GroupLayout f1Layout = new javax.swing.GroupLayout(f1);
        f1.setLayout(f1Layout);
        f1Layout.setHorizontalGroup(
            f1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(whiteBishop2)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        f1Layout.setVerticalGroup(
            f1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(whiteBishop2)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        h3.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout h3Layout = new javax.swing.GroupLayout(h3);
        h3.setLayout(h3Layout);
        h3Layout.setHorizontalGroup(
            h3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        h3Layout.setVerticalGroup(
            h3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        h7.setBackground(new java.awt.Color(255, 183, 122));

        blackPawn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackPawn.png"))); // NOI18N

        javax.swing.GroupLayout h7Layout = new javax.swing.GroupLayout(h7);
        h7.setLayout(h7Layout);
        h7Layout.setHorizontalGroup(
            h7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(h7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(blackPawn8)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        h7Layout.setVerticalGroup(
            h7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(h7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(blackPawn8)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        f2.setBackground(new java.awt.Color(60, 33, 6));

        whitePawn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhitePawn.png"))); // NOI18N

        javax.swing.GroupLayout f2Layout = new javax.swing.GroupLayout(f2);
        f2.setLayout(f2Layout);
        f2Layout.setHorizontalGroup(
            f2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(whitePawn6)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        f2Layout.setVerticalGroup(
            f2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(whitePawn6)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        e2.setBackground(new java.awt.Color(255, 183, 122));

        whitePawn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/WhitePawn.png"))); // NOI18N

        javax.swing.GroupLayout e2Layout = new javax.swing.GroupLayout(e2);
        e2.setLayout(e2Layout);
        e2Layout.setHorizontalGroup(
            e2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(e2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(whitePawn5)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        e2Layout.setVerticalGroup(
            e2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(e2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(whitePawn5)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        e6.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout e6Layout = new javax.swing.GroupLayout(e6);
        e6.setLayout(e6Layout);
        e6Layout.setHorizontalGroup(
            e6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        e6Layout.setVerticalGroup(
            e6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        h4.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout h4Layout = new javax.swing.GroupLayout(h4);
        h4.setLayout(h4Layout);
        h4Layout.setHorizontalGroup(
            h4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        h4Layout.setVerticalGroup(
            h4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        f6.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout f6Layout = new javax.swing.GroupLayout(f6);
        f6.setLayout(f6Layout);
        f6Layout.setHorizontalGroup(
            f6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        f6Layout.setVerticalGroup(
            f6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        g7.setBackground(new java.awt.Color(60, 33, 6));

        blackPawn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackPawn.png"))); // NOI18N

        javax.swing.GroupLayout g7Layout = new javax.swing.GroupLayout(g7);
        g7.setLayout(g7Layout);
        g7Layout.setHorizontalGroup(
            g7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(g7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(blackPawn7)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        g7Layout.setVerticalGroup(
            g7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(g7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(blackPawn7)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        f5.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout f5Layout = new javax.swing.GroupLayout(f5);
        f5.setLayout(f5Layout);
        f5Layout.setHorizontalGroup(
            f5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        f5Layout.setVerticalGroup(
            f5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        g4.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout g4Layout = new javax.swing.GroupLayout(g4);
        g4.setLayout(g4Layout);
        g4Layout.setHorizontalGroup(
            g4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        g4Layout.setVerticalGroup(
            g4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        e5.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout e5Layout = new javax.swing.GroupLayout(e5);
        e5.setLayout(e5Layout);
        e5Layout.setHorizontalGroup(
            e5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        e5Layout.setVerticalGroup(
            e5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        g5.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout g5Layout = new javax.swing.GroupLayout(g5);
        g5.setLayout(g5Layout);
        g5Layout.setHorizontalGroup(
            g5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        g5Layout.setVerticalGroup(
            g5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        e7.setBackground(new java.awt.Color(60, 33, 6));

        blackPawn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackPawn.png"))); // NOI18N

        javax.swing.GroupLayout e7Layout = new javax.swing.GroupLayout(e7);
        e7.setLayout(e7Layout);
        e7Layout.setHorizontalGroup(
            e7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(e7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(blackPawn5)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        e7Layout.setVerticalGroup(
            e7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(e7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(blackPawn5)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        h5.setBackground(new java.awt.Color(255, 183, 122));

        javax.swing.GroupLayout h5Layout = new javax.swing.GroupLayout(h5);
        h5.setLayout(h5Layout);
        h5Layout.setHorizontalGroup(
            h5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        h5Layout.setVerticalGroup(
            h5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        f7.setBackground(new java.awt.Color(255, 183, 122));

        blackPawn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChessGui/BlackPawn.png"))); // NOI18N

        javax.swing.GroupLayout f7Layout = new javax.swing.GroupLayout(f7);
        f7.setLayout(f7Layout);
        f7Layout.setHorizontalGroup(
            f7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(blackPawn6)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        f7Layout.setVerticalGroup(
            f7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(blackPawn6)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        h6.setBackground(new java.awt.Color(60, 33, 6));

        javax.swing.GroupLayout h6Layout = new javax.swing.GroupLayout(h6);
        h6.setLayout(h6Layout);
        h6Layout.setHorizontalGroup(
            h6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        h6Layout.setVerticalGroup(
            h6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(a2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(a1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(d7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(e8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(f7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(e6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(e4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(f3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(e2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(g8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(g7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(h7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(g6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(h5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(g3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(h4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(g2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(g1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(e8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(f7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(e6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(e4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(f3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(e2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(g8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(h7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(g7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(g6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(h5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(h3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(g3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(g2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(g1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(d8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(d7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(d6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jButton1.setText("undo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!gameHistory.empty()){
        game.restoreToSavepoint(gameHistory.pop());
        redrawBoard();
        highlightKingCheck();
        myLabel temp=null;
        for(myLabel i:promotedPieces){
            if(i.getMovesSincePromotion()==0){
                i.setMovesSincePromotion(-1);
               if(i.getName().charAt(0)=='W')
                   i.setIcon(whitePawnIcon);
               else i.setIcon(blackPawnIcon);
               temp=i;
            }
            else i.setMovesSincePromotion(i.getMovesSincePromotion()-1);
        }
        if(temp!=null)
            promotedPieces.remove(temp);
        //flipBoard();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void redrawBoard(){
        Board board=game.getBoard();
        myPanel panel;
        JLabel label;
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++){
                panel=map.get(changePosToName(i,j));
                if(board.getSquare(i, j).getPiece()==null){
                        
                    panel.removeAll();
                    panel.repaint();
                }
                else {
                    label=labelMap.get(board.getSquare(i, j).getPiece().getName());
                    panel.removeAll();
                    panel.add(label);
                    panel.repaint();
                }
                
            }
    }
    private void highlightAllValidDestinations(myPanel panel){
        ArrayList<Move> moves=game.getAllValidMovesFromSquare(panel.getName());
        removeHighlights();
        for (Move i:moves){
   
           myPanel destination=(myPanel)map.get(changePosToName(i.getDestination()));
           destination.setBackground(new Color(153,255,153));
        }
    }
    private void removeHighlights(){
        int x=0;
        for(JPanel i:panelArray){
            if(i.getBackground()==Color.red){
                x++;
                continue;
            }
            i.setBackground(originalColors.get(x));
            x++;
        }
    }
    private void removeKingHighlight(){
        int x=0;
        for(JPanel i:panelArray){
            i.setBackground(originalColors.get(x));
            x++;
        }
    }
    private void highlightKingCheck(){
         myPanel kingPanel;
        if(game.getStatus()==GameStatus.WHITEINCHECK){
          kingPanel=(myPanel)map.get(changePosToName(game.getKingPos(PieceColor.WHITE)));
          kingPanel.setBackground(Color.red);
        }
        else if(game.getStatus()==GameStatus.BLACKINCHECK){
          kingPanel=(myPanel)map.get(changePosToName(game.getKingPos(PieceColor.BLACK)));
          kingPanel.setBackground(Color.red);
        }
        else removeKingHighlight();
    }
    
    private String changePosToName(Square square) {
        char col=(char)(square.getColPos()+'a');
        String row=String.valueOf(square.getRowPos()+1);
        return col+row;
    }
    private String changePosToName(int row,int col) {
        char colAsString=(char)(col+'a');
        String rowAsString=String.valueOf(row+1);
        return colAsString+rowAsString;
    }
    private void checkGameEnd(){
        GameStatus status=game.getStatus();
        switch(status){
            case WHITE_WIN:
                JOptionPane.showMessageDialog(this, "Checkmate,White Won!!!");
                this.dispose();
                break;
            case BLACK_WIN:
                JOptionPane.showMessageDialog(this, "Checkmate,Black Won!!!");
                this.dispose();
                break;
            case STALEMATE:
                JOptionPane.showMessageDialog(this, "Game Over,Stalemate!!!");
                this.dispose();
                break;
            case INSUFFICIENTMATERIAL:
                JOptionPane.showMessageDialog(this, "Game Over,Insufficient Material!!!");
                this.dispose();
                break;
        
        }
    }
    private void flipBoard(){
        for(int i=0,m=7;i<8/2;i++,m--)
            for(int j=0,n=7;j<8;j++,n--){
                myPanel first=(myPanel)map.get(changePosToName(i,j));
                myPanel last=(myPanel)map.get(changePosToName(m,n));
                JLabel labelFirst;
                JLabel labelLast;
                if(first.getComponents().length==0)
                    labelFirst=null;
                else labelFirst=(JLabel)first.getComponent(0);
                if(last.getComponents().length==0)
                    labelLast=null;
                else labelLast=(JLabel)last.getComponent(0);
                first.removeAll();
                if(labelLast!=null)
                    first.add(labelLast);
                first.repaint();
                last.removeAll();
                if(labelFirst!=null)
                    last.add(labelFirst);
                last.repaint();
                first.setName(changePosToName(m, n));
                last.setName(changePosToName(i, j));
                map.put(changePosToName(m, n), first);
                map.put(changePosToName(i, j), last);
            
            }
}   
    private void changeLabel(JLabel label,PieceColor color,char promotion){
        if(color==PieceColor.WHITE){
            switch(promotion){
                case 'K': 
                    label.setIcon(whiteKnight1.getIcon());
                    break;    
                case 'B':
                    label.setIcon(whiteBishop1.getIcon());
                    break; 
                case 'R':
                    label.setIcon(whiteRook1.getIcon());
                    break;
                case 'Q':
                    label.setIcon(whiteQueen.getIcon());
                    break;    
            }
        }else {
            switch(promotion){
                case 'K': 
                    label.setIcon(blackKnight1.getIcon());
                    break;    
                case 'B':
                    label.setIcon(blackBishop1.getIcon());
                    break;
                case 'R':
                    label.setIcon(blackRook1.getIcon());
                    break;
                case 'Q':
                    label.setIcon(blackQueen.getIcon());
                    break;
            }
        
        }

    }
    private boolean updateBoard(MouseEvent evt){
        Board board=game.getBoard();
        if(lastClicked!=null){
            myPanel parent=(myPanel)lastClicked.getParent();
             myPanel dest;
            if(evt.getSource() instanceof JPanel)
             dest=(myPanel) evt.getSource();
            else {
                JLabel label=(JLabel)evt.getSource();
                if(label.getName().equals("WK")||label.getName().equals("BK"))
                return false;
                    dest=(myPanel)label.getParent();
            }
            if(parent==null)
                return false;
            if(game.isValidMove(parent.getName(), dest.getName())){
                gameHistory.push(game.savepoint());
            }
            
            if(game.playGame(parent.getName(), dest.getName())){
                redrawBoard();
                if(game.getCurrentMoveStatus()==MoveStatus.PROMOTION){
                    String choice;
                    while(true){
                        choice=JOptionPane.showInputDialog("PromoteTo(K-Q-R-B)");
                        if(choice.equals("K")||choice.equals("R")||choice.equals("Q")||choice.equals("B"))
                            break;
                        else JOptionPane.showMessageDialog(this,"Please enter a correct choice");
                    }
                    PieceColor color=game.promotionHandling(choice.charAt(0));
                    JLabel label=(JLabel)dest.getComponent(0);
                    changeLabel(label, color,choice.charAt(0));
                    promotedPieces.add((myLabel)label); 
                    highlightKingCheck();
                }
            for(myLabel i:promotedPieces)
                i.setMovesSincePromotion(i.getMovesSincePromotion()+1);
            parent.repaint();
            removeHighlights();
            checkGameEnd();
           // flipBoard();
            highlightKingCheck();
            return true;
            }
            
            
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BoardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BoardFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel a1;
    private javax.swing.JPanel a2;
    private javax.swing.JPanel a3;
    private javax.swing.JPanel a4;
    private javax.swing.JPanel a5;
    private javax.swing.JPanel a6;
    private javax.swing.JPanel a7;
    private javax.swing.JPanel a8;
    private javax.swing.JPanel b1;
    private javax.swing.JPanel b2;
    private javax.swing.JPanel b3;
    private javax.swing.JPanel b4;
    private javax.swing.JPanel b5;
    private javax.swing.JPanel b6;
    private javax.swing.JPanel b7;
    private javax.swing.JPanel b8;
    private javax.swing.JLabel blackBishop1;
    private javax.swing.JLabel blackBishop2;
    private javax.swing.JLabel blackKing;
    private javax.swing.JLabel blackKnight1;
    private javax.swing.JLabel blackKnight2;
    private javax.swing.JLabel blackPawn1;
    private javax.swing.JLabel blackPawn2;
    private javax.swing.JLabel blackPawn3;
    private javax.swing.JLabel blackPawn4;
    private javax.swing.JLabel blackPawn5;
    private javax.swing.JLabel blackPawn6;
    private javax.swing.JLabel blackPawn7;
    private javax.swing.JLabel blackPawn8;
    private javax.swing.JLabel blackQueen;
    private javax.swing.JLabel blackRook1;
    private javax.swing.JLabel blackRook2;
    private javax.swing.JPanel c1;
    private javax.swing.JPanel c2;
    private javax.swing.JPanel c3;
    private javax.swing.JPanel c4;
    private javax.swing.JPanel c5;
    private javax.swing.JPanel c6;
    private javax.swing.JPanel c7;
    private javax.swing.JPanel c8;
    private javax.swing.JPanel d1;
    private javax.swing.JPanel d2;
    private javax.swing.JPanel d3;
    private javax.swing.JPanel d4;
    private javax.swing.JPanel d5;
    private javax.swing.JPanel d6;
    private javax.swing.JPanel d7;
    private javax.swing.JPanel d8;
    private javax.swing.JPanel e1;
    private javax.swing.JPanel e2;
    private javax.swing.JPanel e3;
    private javax.swing.JPanel e4;
    private javax.swing.JPanel e5;
    private javax.swing.JPanel e6;
    private javax.swing.JPanel e7;
    private javax.swing.JPanel e8;
    private javax.swing.JPanel f1;
    private javax.swing.JPanel f2;
    private javax.swing.JPanel f3;
    private javax.swing.JPanel f4;
    private javax.swing.JPanel f5;
    private javax.swing.JPanel f6;
    private javax.swing.JPanel f7;
    private javax.swing.JPanel f8;
    private javax.swing.JPanel g1;
    private javax.swing.JPanel g2;
    private javax.swing.JPanel g3;
    private javax.swing.JPanel g4;
    private javax.swing.JPanel g5;
    private javax.swing.JPanel g6;
    private javax.swing.JPanel g7;
    private javax.swing.JPanel g8;
    private javax.swing.JPanel h1;
    private javax.swing.JPanel h2;
    private javax.swing.JPanel h3;
    private javax.swing.JPanel h4;
    private javax.swing.JPanel h5;
    private javax.swing.JPanel h6;
    private javax.swing.JPanel h7;
    private javax.swing.JPanel h8;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel whiteBishop1;
    private javax.swing.JLabel whiteBishop2;
    private javax.swing.JLabel whiteKing;
    private javax.swing.JLabel whiteKnight1;
    private javax.swing.JLabel whiteKnight2;
    private javax.swing.JLabel whitePawn1;
    private javax.swing.JLabel whitePawn2;
    private javax.swing.JLabel whitePawn3;
    private javax.swing.JLabel whitePawn4;
    private javax.swing.JLabel whitePawn5;
    private javax.swing.JLabel whitePawn6;
    private javax.swing.JLabel whitePawn7;
    private javax.swing.JLabel whitePawn8;
    private javax.swing.JLabel whiteQueen;
    private javax.swing.JLabel whiteRook1;
    private javax.swing.JLabel whiteRook2;
    // End of variables declaration//GEN-END:variables
}
