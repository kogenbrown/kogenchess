import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

public class Chessboard extends JFrame implements ActionListener {

    JFrame frame;
    JPanel board;
    JPanel titlePanel;
    JLabel textfield;
    ImageIcon db,dk,dn,dp,dq,dr,lb,lk,ln,lp,lq,lr;
    JButton[][] buttons;
    boolean pieceSelected = false;
    JButton selection;
    public Chessboard() {
        db = new ImageIcon("db.png");
        dk = new ImageIcon("dk.png");
        dn = new ImageIcon("dn.png");
        dp = new ImageIcon("dp.png");
        dq = new ImageIcon("dq.png");
        dr = new ImageIcon("dr.png");
        lb = new ImageIcon("lb.png");
        lk = new ImageIcon("lk.png");
        ln = new ImageIcon("ln.png");
        lp = new ImageIcon("lp.png");
        lq = new ImageIcon("lq.png");
        lr = new ImageIcon("lr.png");
        frame = new JFrame();
        titlePanel = new JPanel();
        titlePanel.setBackground(new Color(25,25,25));
        buttons = new JButton[8][8];
        board = new JPanel();
        textfield = new JLabel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,900);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(51,255,51));
        textfield.setFont(new Font("Monospaced",Font.PLAIN,75));
        textfield.setHorizontalAlignment(JLabel.LEFT);
        textfield.setText("Chess");
        textfield.setOpaque(true);
        titlePanel.setBounds(0,0,800,100);
        titlePanel.add(textfield);
        frame.add(titlePanel,BorderLayout.NORTH);
        board.setLayout(new GridLayout(8,8));
        board.setBackground(new Color(25,25,25));

        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                buttons[i][j]=new JButton();
                buttons[i][j].setFocusable(false);

                if((i+j)%2!=0) {
                    buttons[i][j].setBackground(new Color(118,150,86));
                } else {
                    buttons[i][j].setBackground(new Color(238-30,238-30,210-30));
                }
                // if(i<=1) buttons[i][j].setForeground(Color.BLACK);
                // else if(i>=6) buttons[i][j].setForeground(Color.WHITE);
                buttons[i][j].setFont(new Font("Monospaced",Font.BOLD,75));
                if(i==1) buttons[i][j].setIcon(dp);
                if(i==6) buttons[i][j].setIcon(lp);
                if(i==0) {
                    if(j==0||j==7) {
                        buttons[i][j].setIcon(dr);
                    } else if (j==1||j==6) {
                        buttons[i][j].setIcon(dn);
                    } else if (j==2||j==5) {
                        buttons[i][j].setIcon(db);
                    } else if(j==3) {
                        buttons[i][j].setIcon(dq);
                    } else buttons[i][j].setIcon(dk);
                } else if (i==7) {
                    if(j==0||j==7) {
                        buttons[i][j].setIcon(lr);
                    } else if (j==1||j==6) {
                        buttons[i][j].setIcon(ln);
                    } else if (j==2||j==5) {
                        buttons[i][j].setIcon(lb);
                    } else if(j==3) {
                        buttons[i][j].setIcon(lq);
                    } else buttons[i][j].setIcon(lk);
                }
                board.add(buttons[i][j]);
                buttons[i][j].addActionListener(this);
                
            }
        }
        frame.add(board);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                if(e.getSource()==buttons[i][j]) {
                    if(!pieceSelected) {
                        if(buttons[i][j].getIcon()!=null) {
                            buttons[i][j].setEnabled(false);
                            pieceSelected=true;
                            selection=buttons[i][j];
                        }
                    } else {
                        selection.setEnabled(true);
                        buttons[i][j].setIcon(selection.getIcon());
                        selection.setIcon(null);
                        pieceSelected=false;
                    }
                }
            }
        }
    }
}