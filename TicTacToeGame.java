/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author anubhav
 */

public class TicTacToeGame implements ActionListener
{
    JFrame jf;
    JButton[] jb;
    
    int count=0;
    String str="";
    boolean win=false;
    Color color1;
    
    TicTacToeGame()
    {
        jf=new JFrame("TicTacToe Game by Anubhav");
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(3, 3));
        
        jb=new JButton[10];
        for(int i=1; i<10; i++)
        {
            jb[i]=new JButton();
            jb[i].addActionListener(this);
            jf.add(jb[i]);
        }
        
        jf.setVisible(true);
    }
    public static void main(String[] args)
    {
        new TicTacToeGame();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        count=count+1;
        if(count%2==0)
        {
            str="0";
            color1=Color.BLUE;
        }
        else
        {
            color1=Color.yellow;
            str="X";
        }
        // I know it very expensive 😢
        for(int i=1; i<10; i++)
        {
            if(e.getSource()==jb[i])
            {
                jb[i].setBackground(color1);
                jb[i].setFont(new Font("Arial", 1, 50));
                jb[i].setText(str);
                jb[i].setEnabled(false);
            }
        }
        
        winningPossibilities();
        whoWins();
    }
    void winningPossibilities()
    {
        //horizontal winning possibilities
        if(jb[1].getText()==jb[2].getText() && jb[2].getText()==jb[3].getText() && jb[3].getText() != "")
        {
            win=true;
        }
        else if(jb[4].getText()==jb[5].getText() && jb[5].getText()==jb[6].getText() && jb[6].getText() != "")
        {
            win=true;
        }
        else if(jb[7].getText()==jb[8].getText() && jb[8].getText()==jb[9].getText() && jb[9].getText() != "")
        {
            win=true;
        }
        //vertical winning possibilities
        else if(jb[1].getText()==jb[4].getText() && jb[4].getText()==jb[7].getText() && jb[7].getText() != "")
        {
            win=true;
        }
        else if(jb[2].getText()==jb[5].getText() && jb[5].getText()==jb[8].getText() && jb[8].getText() != "")
        {
            win=true;
        }
        else if(jb[3].getText()==jb[6].getText() && jb[6].getText()==jb[9].getText() && jb[9].getText() != "")
        {
            win=true;
        }
        //diagonal winning possibilities
        else if(jb[1].getText()==jb[5].getText() && jb[5].getText()==jb[9].getText() && jb[9].getText() != "")
        {
            win=true;
        }
        else if(jb[3].getText()==jb[5].getText() && jb[5].getText()==jb[7].getText() && jb[7].getText() != "")
        {
            win=true;
        }
        //game draw
        else
        {
            win=false;
        }
    }
    void whoWins()
    {
        if(win==true)
        {
            JOptionPane.showMessageDialog(jf, str+" wins");
            restartGame();
        }
        else if(win==false && count==9)
        {
            JOptionPane.showMessageDialog(jf, "Match Draw");
            restartGame();
        }
    }
    void restartGame()
    {
        int i=JOptionPane.showConfirmDialog(jf, "Do you want to restart the game ?");
        if(i==0)
        {
            for(int j=1; j<10; j++)
            {
                jb[j].setText("");
                jb[j].setBackground(null);
            }
            
            btnSetEnabling(true);
            
            str="";
            count=0;
            win=false;
        }
        else if(i==1)
        {
            System.exit(0);
        }
        else // If user go for cancel option 
        {
            btnSetEnabling(false);
        }
    }
    void btnSetEnabling(boolean b)
    {
        for(int i=1; i<10; i++)
        {
            jb[i].setEnabled(b);
        }
    }
}