/* TicTacToe.java
Created by: Jack Larkin
4/11/2022
*/

// Tools
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class TicTacToe extends JFrame{
  // Variables
  static JButton btnQuit,btnPvP, btnPvC, btnRestart;
  static JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
  static JLabel lblWelcome, lblGame, lblChoose, lblWinner, lblTurn, lblWinsX, lblWinsO, lblPic, lblX1, lblX2, lblX3, lblX4, lblX5, lblX6, lblX7, lblX8, lblX9;
  static ArrayList<Integer> board = new ArrayList<Integer>();
  static String[] gameboard;
  static String turn, winner, player, game;
  static int box, WinCounterX, WinCounterO;
  static ImageIcon X, O; 

  //Constructors
  public TicTacToe(){
    super("TicTacToe");
    setSize(1280,720);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    init();
    setVisible(true);
  }
  // Methods
  private void init(){
    game = "none";
    // Graphics
    MyPanel mypanel = new MyPanel();
    mypanel.setBounds(0,0,1280,700);
    mypanel.setBackground(new Color(204,229,255));
    //add(mypanel);

    // Layout

    // Quit Button 

    btnQuit = new JButton("Exit");
      btnQuit.setBounds(1150,600,80,50);
      btnQuit.setBackground(new Color(204,255,255));
      btnQuit.setFont(new Font("Courier", Font.BOLD, 15));
      btnQuit.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          dispose(); // exit, close the window.
        }
      });
      add(btnQuit);
      // Main Menu

      // Labels
      lblWelcome = new JLabel("TicTacToe: Designed by Jack Larkin");
      lblWelcome.setBounds(390,50,550,100);
      lblWelcome.setFont(new Font("Courier", Font.BOLD, 25));
      
      add(lblWelcome);

      lblWinsX = new JLabel("X Wins: " + WinCounterX);
      lblWinsX.setBounds(1000, 50, 500, 100);
      lblWinsX.setForeground(new Color(255,102,102));
      lblWinsX.setFont(new Font("Courier", Font.BOLD, 20));

      add(lblWinsX);

      lblWinsO = new JLabel("O Wins: " + WinCounterO);
      lblWinsO.setBounds(1000, 100, 500, 100);
      lblWinsO.setForeground(new Color(0,128,255));
      lblWinsO.setFont(new Font("Courier", Font.BOLD, 20));

      add(lblWinsO);

      lblChoose = new JLabel("Choose a Game Mode:");
      lblChoose.setBounds(520, 200, 300, 100);
      lblChoose.setFont(new Font("Courier", Font.BOLD, 20));
      add(lblChoose);

      lblTurn = new JLabel();
      lblTurn.setBounds(520, 50, 400, 100);
      lblTurn.setForeground(new Color(96,96,96));
      lblTurn.setFont(new Font("Courier", Font.BOLD, 20));
      //add(lblTurn);

      lblWinner = new JLabel();
      //lblWinner.setBounds();

      // Buttons

      btnPvP = new JButton("Player vs. Player");
      btnPvP.setBounds(530, 300, 175, 50);
      btnPvP.setBackground(new Color(204,255,204));
      btnPvP.setFont(new Font("Courier", Font.BOLD, 14));
      btnPvP.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          showBoard(); // Start Game
          add(mypanel);
          game = "pvp";
          PvP();
        }
      });
      add(btnPvP);

      btnRestart = new JButton("Play Again?");
      btnRestart.setBounds(540, 510, 175, 50);
      btnRestart.setBackground(new Color(204, 255, 204));
      btnRestart.setFont(new Font("Courier", Font.BOLD, 15));
      btnRestart.setVisible(false);
      btnRestart.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          showMenu(); // Restart
          remove(mypanel);
        }
      });    
      add(btnRestart);

      btnPvC = new JButton("Player vs. Comp");
      btnPvC.setBounds(530, 360, 175, 50);
      btnPvC.setBackground(new Color(204, 255, 204));
      btnPvC.setFont(new Font("Courier", Font.BOLD, 14));
      btnPvC.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          showBoard(); // Start Game
          game = "pvc";
          add(mypanel);
          PvC();
        }
      });
      add(btnPvC);

      btn1 = new JButton();
      btn1.setBounds(500, 200,50, 50);
      btn1.setBackground(Color.WHITE);
      btn1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          //board.set(0, 1);
          gameboard[0] = turn;
          remove(btn1);
          revalidate();
          repaint();
          if (game.equals("pvp")){
            PvP();
            System.out.println("PvP");
          }else if (game.equals("pvc")) {
            PvC();
            PvC();
          }
          
        }
      });

      btn2 = new JButton();
      btn2.setBounds(600, 200, 50, 50);
      btn2.setBackground(Color.WHITE);
      btn2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          gameboard[1] = turn;
          remove(btn2);
          revalidate();
          repaint();
          if (game.equals("pvp")){
            PvP();
          }else if (game.equals("pvc")) {
            PvC();
            PvC();
          }
        }
      });

      btn3 = new JButton();
      btn3.setBounds(700, 200, 50, 50);
      btn3.setBackground(Color.WHITE);
      btn3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          gameboard[2] = turn;
          remove(btn3);
          revalidate();
          repaint();
          if (game.equals("pvp")){
            PvP();
          }else if (game.equals("pvc")) {
            PvC();
            PvC();
          }
        }
      });

      btn4 = new JButton();
      btn4.setBounds(500, 300, 50, 50);
      btn4.setBackground(Color.WHITE);
      btn4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          gameboard[3] = turn;
          remove(btn4);
          revalidate();
          repaint();
          if (game.equals("pvp")){
            PvP();
          }else if (game.equals("pvc")) {
            PvC();
            PvC();
          }
        }
      });

      btn5 = new JButton();
      btn5.setBounds(600, 300, 50, 50);
      btn5.setBackground(Color.WHITE);
      btn5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          gameboard[4] = turn;
          remove(btn5);
          revalidate();
          repaint();
          if (game.equalsIgnoreCase("pvp")){
            PvP();
          }else if (game.equalsIgnoreCase("pvc")) {
            PvC();
            PvC();
          }
        }
      });

      btn6 = new JButton();
      btn6.setBounds(700, 300, 50, 50);
      btn6.setBackground(Color.WHITE);
      btn6.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          gameboard[5] = turn;
          remove(btn6);
          revalidate();
          repaint();
          if (game.equals("pvp")){
            PvP();
          }else if (game.equals("pvc")) {
            PvC();
            PvC();
          }
        }
      });

      btn7 = new JButton();
      btn7.setBounds(500, 400, 50, 50);
      btn7.setBackground(Color.WHITE);
      btn7.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          gameboard[6] = turn;
          remove(btn7);
          revalidate();
          repaint();
          if (game.equals("pvp")){
            PvP();
          }else if (game.equals("pvc")) {
            PvC();
            PvC();
          }
        }
      });

      btn8 = new JButton();
      btn8.setBounds(600, 400, 50, 50);
      btn8.setBackground(Color.WHITE);
      btn8.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          gameboard[7] = turn;
          remove(btn8);
          revalidate();
          repaint();
          if (game.equals("pvp")){
            PvP();
          }else if (game.equals("pvc")) {
            PvC();
            PvC();
          }
        }
      });

      btn9 = new JButton();
      btn9.setBounds(700, 400, 50, 50);
      btn9.setBackground(Color.WHITE);
      btn9.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          gameboard[8] = turn;
          remove(btn9);
          revalidate();
          repaint();
          if (game.equals("pvp")){
            PvP();
          }else if (game.equals("pvc")) {
            PvC();
            PvC();
          }
        }
      });
      X = new ImageIcon("img/redXsized.png");
      O = new ImageIcon("img/blueOsized.png");
      // X's and O's


      lblX1 = new JLabel();
      lblX1.setBounds(500, 200, 50, 50);
      add(lblX1);
      lblX2 = new JLabel();
      lblX2.setBounds(600, 200, 50, 50);
      add(lblX2);
      lblX3 = new JLabel();
      lblX3.setBounds(700, 200, 50, 50);
      add(lblX3);
      lblX4 = new JLabel();
      lblX4.setBounds(500, 300, 50, 50);
      add(lblX4);
      lblX5 = new JLabel();
      lblX5.setBounds(600, 300, 50, 50);
      add(lblX5);
      lblX6 = new JLabel();
      lblX6.setBounds(700, 300, 50, 50);
      add(lblX6);
      lblX7 = new JLabel();
      lblX7.setBounds(500, 400, 50, 50);
      add(lblX7);
      lblX8 = new JLabel();
      lblX8.setBounds(600, 400, 50, 50);
      add(lblX8);
      lblX9 = new JLabel();
      lblX9.setBounds(700, 400, 50, 50);
      add(lblX9);
          // Board 
      ImageIcon tic = new ImageIcon("img/board.png");
      lblPic = new JLabel();
      lblPic.setIcon(tic);
      lblPic.setBounds(450, 150, 350, 350);
      lblPic.setBackground(new Color(250, 250, 250));
      lblPic.setVisible(false);
      add(lblPic);
  }
  // Main method 
  public static void main(String[] args){ //throws InterruptedException 
    TicTacToe game = new TicTacToe();
    gameboard = new String[9];
    for  (int i = 0; i < 9; i++){
      gameboard[i] = String.valueOf (i + 1);
    }
  }

  // New Class
  public class MyPanel  extends JPanel{

    @Override
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      
    } 
  }
  public static void PvP() throws NullPointerException{
    winner = "none";
    player = "none";
    turn = "X";
    if (gameboard[0].equals("X")){
      lblX1.setIcon(X);
      lblX1.setVisible(true);
      turn = "O";
      gameboard[0] = "A";
    } else if (gameboard[0].equals("O")) {
      lblX1.setIcon(O);
      lblX1.setVisible(true);
      turn = "X";
      gameboard[0] = "B";
    }
    if (gameboard[1].equals("X")){
      lblX2.setVisible(true);
      lblX2.setIcon(X);
      gameboard[1] = "A";
      turn = "O";
    } else if (gameboard[1].equals("O")){
      lblX2.setVisible(true);
      lblX2.setIcon(O);
      gameboard[1] = "B";
      turn = "X";
    }
    if (gameboard[2].equals("X")){
      lblX3.setVisible(true);
      lblX3.setIcon(X);
      gameboard[2] = "A";
      turn = "O";
    } else if (gameboard[2].equals("O")){
      lblX3.setVisible(true);
      lblX3.setIcon(O);
      gameboard[2] = "B";
      turn = "X";
    }
    if (gameboard[3].equals("X")){
      gameboard[3] = turn;
      lblX4.setVisible(true);
      lblX4.setIcon(X);
      gameboard[3] = "A";
      turn = "O";
    } else if (gameboard[3].equals("O")){
      gameboard[3] = turn;
      lblX4.setVisible(true);
      lblX4.setIcon(O);
      gameboard[3] = "B";
      turn = "X";
    }
    
    if (gameboard[4].equals("X")){
      lblX5.setVisible(true);
      lblX5.setIcon(X);
      gameboard[4] = "A";
      turn = "O";
    } else if (gameboard[4].equals("O")){
      lblX5.setVisible(true);
      lblX5.setIcon(O);
      gameboard[4] = "B";
      turn = "X";
    }
    if (gameboard[5].equals("X")){
      lblX6.setVisible(true);
      lblX6.setIcon(X);
      gameboard[5] = "A";
      turn = "O";
    } else if (gameboard[5].equals("O")){
      lblX6.setVisible(true);
      lblX6.setIcon(O);
      gameboard[5] = "B";
      turn = "X";
    }
    if (gameboard[6].equals("X")){
      lblX7.setVisible(true);
      lblX7.setIcon(X);
      gameboard[6] = "A";
      turn = "O";
    } else if (gameboard[6].equals("O")){
      lblX7.setVisible(true);
      lblX7.setIcon(O);
      gameboard[6] = "B";
      turn = "X";
    }
    if (gameboard[7].equals("X")){
      lblX8.setVisible(true);
      lblX8.setIcon(X);
      gameboard[7] = "A";
      turn = "O";
    } else if (gameboard[7].equals("O")){
      lblX8.setVisible(true);
      lblX8.setIcon(O);
      gameboard[7] = "B";
      turn = "X";
    }
    if (gameboard[8].equals("X")){
      lblX9.setVisible(true);
      lblX9.setIcon(X);
      gameboard[8] = "A";
      turn = "O";
    } else if (gameboard[8].equals("O")){
      lblX9.setVisible(true);
      lblX9.setIcon(O);
      gameboard[8] = "B";
      turn = "X";
    }
    if (turn.equals("X")){
      lblTurn.setText("Player 1's turn");
    }
    else if (turn.equals("O")){
      lblTurn.setText("Player 2's turn");
    }
    winner = declareWinner();
    if (winner.equals("X")){
      player = "Player 1";
    }
    else if (winner.equals("O")){
      player = "Player 2";
    }
    if (winner.equalsIgnoreCase("draw")){
       lblTurn.setText("DRAW! No one wins. Thank you for playing!");
       lblTurn.setBounds(425, 50, 500, 100);
       btnRestart.setVisible(true);
    }
    else if (winner.equalsIgnoreCase("X")){
       lblTurn.setText(player + " wins! Congratulations!");
       lblTurn.setBounds(465, 50, 400, 100);
       WinCounterX = WinCounterX + 1;
       lblWinsX.setText("X Wins: " + WinCounterX);
       btnRestart.setVisible(true);

    }
    if (winner.equalsIgnoreCase("O")){
      lblTurn.setText(player + " wins! Congratulations!");
      lblTurn.setBounds(465, 50, 400, 100);
      WinCounterO = WinCounterO + 1;
      lblWinsO.setText("O Wins: " + WinCounterO);
      btnRestart.setVisible(true);
    }
  }
  
  public static void PvC() throws NullPointerException{
    winner = "none";
    player = "none";
    turn = "X";
    int min = 1;
    int max = 9;
    int counter = 0;
    String boxcheck = "no";
    if (gameboard[0].equals("X")){
      lblX1.setIcon(X);
      lblX1.setVisible(true);
      turn = "O";
      gameboard[0] = "A";
    } else if (gameboard[0].equals("O")) {
      lblX1.setIcon(O);
      lblX1.setVisible(true);
      btn1.setVisible(false);
      turn = "X";
      gameboard[0] = "B";
    }
    if (gameboard[1].equals("X")){
      lblX2.setVisible(true);
      lblX2.setIcon(X);
      gameboard[1] = "A";
      turn = "O";
    } else if (gameboard[1].equals("O")){
      lblX2.setVisible(true);
      lblX2.setIcon(O);
      btn2.setVisible(false);
      gameboard[1] = "B";
      turn = "X";
    }
    if (gameboard[2].equals("X")){
      lblX3.setVisible(true);
      lblX3.setIcon(X);
      gameboard[2] = "A";
      turn = "O";
    } else if (gameboard[2].equals("O")){
      lblX3.setVisible(true);
      lblX3.setIcon(O);
      btn3.setVisible(false);
      gameboard[2] = "B";
      turn = "X";
    }
    if (gameboard[3].equals("X")){
      gameboard[3] = turn;
      lblX4.setVisible(true);
      lblX4.setIcon(X);
      gameboard[3] = "A";
      turn = "O";
    } else if (gameboard[3].equals("O")){
      gameboard[3] = turn;
      lblX4.setVisible(true);
      lblX4.setIcon(O);
      btn4.setVisible(false);
      gameboard[3] = "B";
      turn = "X";
    }
    if (gameboard[4].equals("X")){
      lblX5.setVisible(true);
      lblX5.setIcon(X);
      gameboard[4] = "A";
      turn = "O";
    } else if (gameboard[4].equals("O")){
      lblX5.setVisible(true);
      lblX5.setIcon(O);
      btn5.setVisible(false);
      gameboard[4] = "B";
      turn = "X";
    }
    if (gameboard[5].equals("X")){
      lblX6.setVisible(true);
      lblX6.setIcon(X);
      gameboard[5] = "A";
      turn = "O";
    } else if (gameboard[5].equals("O")){
      lblX6.setVisible(true);
      lblX6.setIcon(O);
      btn6.setVisible(false);
      gameboard[5] = "B";
      turn = "X";
    }
    if (gameboard[6].equals("X")){
      lblX7.setVisible(true);
      lblX7.setIcon(X);
      gameboard[6] = "A";
      turn = "O";
    } else if (gameboard[6].equals("O")){
      lblX7.setVisible(true);
      lblX7.setIcon(O);
      btn7.setVisible(false);
      gameboard[6] = "B";
      turn = "X";
    }
    if (gameboard[7].equals("X")){
      lblX8.setVisible(true);
      lblX8.setIcon(X);
      gameboard[7] = "A";
      turn = "O";
    } else if (gameboard[7].equals("O")){
      lblX8.setVisible(true);
      lblX8.setIcon(O);
      btn8.setVisible(false);
      gameboard[7] = "B";
      turn = "X";
    }
    if (gameboard[8].equals("X")){
      lblX9.setVisible(true);
      lblX9.setIcon(X);
      gameboard[8] = "A";
      turn = "O";
    } else if (gameboard[8].equals("O")){
      lblX9.setVisible(true);
      lblX9.setIcon(O);
      btn9.setVisible(false);
      gameboard[8] = "B";
      turn = "X";
    }
    if (counter < 4 ){
      if (turn.equals("O")){
        //Generates random number for slot
        if (counter < 4){
          while (boxcheck.equals("no")){ 
            int i = (int) Math.floor(Math.random() * (max - min + 1) + min);
            if (counter >= 4){
              break;
            } else if (counter < 4){
              if (gameboard[i-1].equals(Integer.toString(i))) {
                gameboard[i-1] = "O";
                turn = "X";
                boxcheck = "yes";  
                counter = counter + 1;
                System.out.println(counter);
              }
            }
        // Nested if else statements if the while loop doesnt work
          /*}else{
            i = (int) Math.floor(Math.random() * (max - min + 1) + min);
            if (gameboard[i-1].equals(Integer.toString(i))) {
              gameboard[i-1] = "O";
              turn = "X";
              System.out.println(i);
            }else{
              i = (int) Math.floor(Math.random() * (max - min + 1) + min);
              if (gameboard[i-1].equals(Integer.toString(i))) {
                gameboard[i-1] = "O";
                turn = "X";
                System.out.println(i);
              }else{
                i = (int) Math.floor(Math.random() * (max - min + 1) + min);
                if (gameboard[i-1].equals(Integer.toString(i))) {
                  gameboard[i-1] = "O";
                  turn = "X";
                  System.out.println(i);
                }else{
                  i = (int) Math.floor(Math.random() * (max - min + 1) + min);
                  if (gameboard[i-1].equals(Integer.toString(i))) {
                    gameboard[i-1] = "O";
                    turn = "X";
                    System.out.println(i);
                  }else{
                    i = (int) Math.floor(Math.random() * (max - min + 1) + min);
                    if (gameboard[i-1].equals(Integer.toString(i))) {
                      gameboard[i-1] = "O";
                      turn = "X";
                      System.out.println(i);
                    }else{
                      i = (int) Math.floor(Math.random() * (max - min + 1) + min);
                      if (gameboard[i-1].equals(Integer.toString(i))) {
                        gameboard[i-1] = "O";
                        turn = "X";
                        System.out.println(i);
                      }else{
                        i = (int) Math.floor(Math.random() * (max - min + 1) + min);
                        if (gameboard[i-1].equals(Integer.toString(i))) {
                          gameboard[i-1] = "O";
                          turn = "X";
                          System.out.println(i);
                        }else{
                          i = (int) Math.floor(Math.random() * (max - min + 1) + min);
                          if (gameboard[i-1].equals(Integer.toString(i))) {
                            gameboard[i-1] = "O";
                            turn = "X";
                            System.out.println(i);  
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }*/
          }
        }
      }
    } else {
      boxcheck = "yes";
    }
    if (turn.equals("X")){
      lblTurn.setText("Player 1's turn");
    }
    else if (turn.equals("O")){
      lblTurn.setText("Player 2's turn");
    }
    winner = declareWinner();
    if (winner.equals("X")){
      player = "Player 1";
      boxcheck = "yes";  
    }
    else if (winner.equals("O")){
      player = "Player 2";
      boxcheck = "yes";  
    }
    if (winner.equalsIgnoreCase("draw")){
       lblTurn.setText("DRAW! No one wins. Thank you for playing!");
       lblTurn.setBounds(425, 50, 500, 100);
       btnRestart.setVisible(true);
       boxcheck = "yes";  
    }
    else if (winner.equalsIgnoreCase("X")){
       lblTurn.setText(player + " wins! Congratulations!");
       lblTurn.setBounds(465, 50, 400, 100);
       WinCounterX = WinCounterX + 1;
       lblWinsX.setText("X Wins: " + WinCounterX);
       btnRestart.setVisible(true);
       boxcheck = "yes";  
    }
    if (winner.equalsIgnoreCase("O")){
      lblTurn.setText(player + " wins! Congratulations!");
      lblTurn.setBounds(465, 50, 400, 100);
      WinCounterO = WinCounterO + 1;
      lblWinsO.setText("O Wins: " + WinCounterO);
      btnRestart.setVisible(true);
      boxcheck = "yes";  
    }
  }
  private void showMenu(){
    remove(btn1);
    remove(btn2);
    remove(btn3);
    remove(btn4);
    remove(btn5);
    remove(btn6);
    remove(btn7);
    remove(btn8);
    remove(btn9);
    remove(lblTurn);
    add(btnPvP);
    add(btnPvC);
    add(lblWelcome);
    add(lblChoose);
    lblTurn.setBounds(520, 50, 400, 100);
    btnRestart.setVisible(false);
    lblPic.setVisible(false);
    lblX1.setVisible(false);
    lblX2.setVisible(false);
    lblX3.setVisible(false);
    lblX4.setVisible(false);
    lblX5.setVisible(false);
    lblX6.setVisible(false);
    lblX7.setVisible(false);
    lblX8.setVisible(false);
    lblX9.setVisible(false);
    revalidate();
    repaint();
    gameboard = new String[9];
    for (int i = 0; i < 9; i++) {
      gameboard[i] = String.valueOf(i + 1);
    }
  }

  private void showBoard(){
    add(btn1);
    add(btn2);
    add(btn3);
    add(btn4);
    add(btn5);
    add(btn6);
    add(btn7);
    add(btn8);
    add(btn9);
    btn1.setVisible(true);
    btn2.setVisible(true);
    btn3.setVisible(true);
    btn4.setVisible(true);
    btn5.setVisible(true);
    btn6.setVisible(true);
    btn7.setVisible(true);
    btn8.setVisible(true);
    btn9.setVisible(true);
    add(lblTurn);
    remove(btnPvP);
    remove(btnPvC);
    remove(lblWelcome);
    remove(lblChoose);
    lblPic.setVisible(true);
    revalidate();
    repaint();
  }
    
  public static String declareWinner(){
    // There are 8 possible win scenarios for both X and O
    for (int i = 0; i < 8; i++){
      String line = null;
      switch (i){
        case 0: 
          line = gameboard[0] + gameboard[1] + gameboard[2];
          break;
        case 1: 
          line = gameboard[3] + gameboard[4] + gameboard[5];
          break;
        case 2: 
          line = gameboard[6] + gameboard[7] + gameboard[8];
          break;
        case 3: 
          line = gameboard[0] + gameboard[3] + gameboard[6];
          break;
        case 4: 
          line = gameboard[1] + gameboard[4] + gameboard[7];
          break;
        case 5: 
          line = gameboard[2] + gameboard[5] + gameboard[8];
          break;
        case 6: 
          line = gameboard[0] + gameboard[4] + gameboard[8];
          break;
        case 7: 
          line = gameboard[2] + gameboard[4] + gameboard[6];
          break;
      }
        if (line.equals("AAA")){
          return "X";
        }
        else if (line.equals("BBB")){
          return "O";
        }
    }
    for (int i = 0; i<9; i++){
      if (Arrays.asList(gameboard).contains(
        String.valueOf(i + 1))){
          break;
        }
      else if (i == 8){
        return "draw";
      }
    }
    return "";
  }
}