//int board[][] =
//    {{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},
//     {WALL,WALL,WALL,WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},        
//     {WALL,PATH,WALL,PATH,PATH,WALL,WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},        
//     {WALL,PATH,WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},        
//     {WALL,PATH,PATH,PATH,WALL,WALL,WALL,PATH,WALL,WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL,WALL,PATH,WALL},        
//     {WALL,PATH,WALL,WALL,WALL,WALL,PATH,PATH,WALL,WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL,PATH,PATH,WALL},        
//     {WALL,PATH,WALL,WALL,PATH,WALL,WALL,PATH,WALL,WALL,PATH,WALL,WALL,PATH,WALL,WALL,PATH,PATH,WALL,WALL},        
//     {WALL,PATH,PATH,WALL,PATH,WALL,WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL,WALL,PATH,WALL,WALL,WALL},        
//     {WALL,WALL,PATH,PATH,PATH,WALL,WALL,PATH,PATH,WALL,WALL,WALL,WALL,PATH,WALL,WALL,PATH,WALL,WALL,WALL},        
//     {WALL,WALL,WALL,PATH,PATH,PATH,PATH,PATH,WALL,WALL,WALL,WALL,WALL,PATH,WALL,PATH,PATH,WALL,WALL,WALL},        
//     {WALL,WALL,WALL,PATH,WALL,PATH,WALL,PATH,PATH,WALL,PATH,PATH,PATH,PATH,WALL,PATH,WALL,WALL,WALL,WALL},        
//     {WALL,WALL,PATH,PATH,WALL,PATH,WALL,WALL,PATH,WALL,PATH,WALL,PATH,PATH,PATH,PATH,PATH,PATH,WALL,WALL},        
//     {WALL,WALL,PATH,WALL,WALL,PATH,WALL,WALL,PATH,WALL,PATH,WALL,WALL,PATH,WALL,WALL,WALL,PATH,PATH,WALL},        
//     {WALL,WALL,PATH,WALL,WALL,PATH,WALL,WALL,PATH,WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL,PATH,WALL,WALL},        
//     {WALL,WALL,PATH,WALL,PATH,PATH,PATH,WALL,PATH,WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL,WALL},        
//     {WALL,WALL,PATH,WALL,WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL,PATH,PATH,WALL},        
//     {WALL,WALL,PATH,PATH,PATH,PATH,WALL,WALL,PATH,WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL},        
//     {WALL,WALL,WALL,WALL,WALL,PATH,PATH,PATH,PATH,WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL},
//     {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,PATH,PATH,PATH,PATH,PATH,PATH,WALL,WALL,WALL,WALL,WALL,WALL},
//     {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}
//    };
package maze;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Maze extends JFrame implements Runnable {

    static final int numRows = 20;
    static final int numColumns = 20;
    static final int XBORDER = 40;
    static final int YBORDER = 60;
    static final int YTITLE = 30;
    static final int WINDOW_BORDER = 8;
    static final int WINDOW_WIDTH = 2 * (WINDOW_BORDER + XBORDER) + numColumns * 30;
    static final int WINDOW_HEIGHT = YTITLE + WINDOW_BORDER + 2 * YBORDER + numRows * 30;

    boolean animateFirstTime = true;
    int xsize = -1;
    int ysize = -1;
    Image image;
    Graphics2D g;

    final int PATH = 0;
    final int WALL = 1;
    final int SECR = 2;
    final int PORT = 3;
   
   
        int board[][]
            = {{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, WALL, WALL, WALL, PATH, PATH, PATH, PATH, PATH, PATH, PATH, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, PORT, WALL, PATH, PATH, SECR, WALL, WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, PATH, WALL, PATH, WALL, SECR, WALL, WALL, WALL, WALL, PATH, PATH, PATH, PATH, PATH, PATH, PATH, PATH, PATH, WALL},
            {PATH, PATH, PATH, PATH, WALL, SECR, WALL, PATH, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL, WALL, PATH, PATH},
            {WALL, PATH, WALL, WALL, SECR, SECR, PATH, PATH, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL, PATH, PATH, WALL},
            {WALL, PATH, WALL, WALL, PATH, WALL, WALL, PATH, WALL, WALL, PATH, WALL, WALL, PATH, WALL, WALL, PATH, PATH, WALL, WALL},
            {WALL, PATH, PATH, WALL, PATH, WALL, WALL, PATH, PATH, PATH, PATH, PATH, PATH, PATH, WALL, WALL, PATH, WALL, WALL, WALL},
            {WALL, WALL, PATH, PATH, PATH, WALL, WALL, PATH, PATH, WALL, WALL, WALL, WALL, PATH, WALL, WALL, PATH, WALL, WALL, WALL},
            {WALL, WALL, WALL, PATH, PATH, PATH, PATH, PATH, WALL, WALL, WALL, WALL, WALL, PATH, WALL, PATH, PATH, WALL, WALL, WALL},
            {WALL, WALL, WALL, PATH, WALL, PATH, WALL, PATH, PATH, WALL, PATH, PATH, PATH, PATH, WALL, PATH, WALL, WALL, WALL, WALL},
            {WALL, WALL, PATH, PATH, WALL, PATH, WALL, WALL, PATH, WALL, PATH, WALL, PATH, PATH, PATH, PATH, PATH, PATH, WALL, WALL},
            {WALL, WALL, PATH, WALL, WALL, PATH, WALL, WALL, PATH, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL, PATH, PATH, WALL},
            {WALL, WALL, PATH, WALL, WALL, PATH, WALL, WALL, PATH, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL, PATH, WALL, WALL},
            {WALL, WALL, PATH, WALL, PATH, PATH, PATH, WALL, PATH, WALL, PATH, PATH, PATH, PATH, PATH, PATH, PATH, PATH, WALL, WALL},
            {WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL, PATH, WALL, WALL, WALL, PATH, PATH, WALL},
            {WALL, WALL, PATH, PATH, PATH, PATH, WALL, WALL, PATH, WALL, WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, WALL, WALL, WALL, WALL, PATH, PATH, PATH, PATH, WALL, WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, PATH, PATH, PATH, PATH, PATH, PATH, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}
            };
       
        int boardOrig[][]
            = {{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, WALL, WALL, WALL, PATH, PATH, PATH, PATH, PATH, PATH, PATH, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, PORT, WALL, PATH, PATH, SECR, WALL, WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, PATH, WALL, PATH, WALL, SECR, WALL, WALL, WALL, WALL, PATH, PATH, PATH, PATH, PATH, PATH, PATH, PATH, PATH, WALL},
            {PATH, PATH, PATH, PATH, WALL, SECR, WALL, PATH, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL, WALL, PATH, PATH},
            {WALL, PATH, WALL, WALL, SECR, SECR, PATH, PATH, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL, PATH, PATH, WALL},
            {WALL, PATH, WALL, WALL, PATH, WALL, WALL, PATH, WALL, WALL, PATH, WALL, WALL, PATH, WALL, WALL, PATH, PATH, WALL, WALL},
            {WALL, PATH, PATH, WALL, PATH, WALL, WALL, PATH, PATH, PATH, PATH, PATH, PATH, PATH, WALL, WALL, PATH, WALL, WALL, WALL},
            {WALL, WALL, PATH, PATH, PATH, WALL, WALL, PATH, PATH, WALL, WALL, WALL, WALL, PATH, WALL, WALL, PATH, WALL, WALL, WALL},
            {WALL, WALL, WALL, PATH, PATH, PATH, PATH, PATH, WALL, WALL, WALL, WALL, WALL, PATH, WALL, PATH, PATH, WALL, WALL, WALL},
            {WALL, WALL, WALL, PATH, WALL, PATH, WALL, PATH, PATH, WALL, PATH, PATH, PATH, PATH, WALL, PATH, WALL, WALL, WALL, WALL},
            {WALL, WALL, PATH, PATH, WALL, PATH, WALL, WALL, PATH, WALL, PATH, WALL, PATH, PATH, PATH, PATH, PATH, PATH, WALL, WALL},
            {WALL, WALL, PATH, WALL, WALL, PATH, WALL, WALL, PATH, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL, PATH, PATH, WALL},
            {WALL, WALL, PATH, WALL, WALL, PATH, WALL, WALL, PATH, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL, PATH, WALL, WALL},
            {WALL, WALL, PATH, WALL, PATH, PATH, PATH, WALL, PATH, WALL, PATH, PATH, PATH, PATH, PATH, PATH, PATH, PATH, WALL, WALL},
            {WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL, PATH, WALL, WALL, WALL, PATH, PATH, WALL},
            {WALL, WALL, PATH, PATH, PATH, PATH, WALL, WALL, PATH, WALL, WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, WALL, WALL, WALL, WALL, PATH, PATH, PATH, PATH, WALL, WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, PATH, PATH, PATH, PATH, PATH, PATH, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}
            };
       
        int board2[][] =
    {{WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},
     {WALL,PATH,PATH,PATH,PATH,PATH,PATH,WALL,WALL,WALL,WALL,WALL,WALL,WALL,PATH,PATH,PATH,PATH,PATH,WALL},        
     {WALL,PATH,WALL,WALL,PATH,PATH,PATH,SECR,SECR,SECR,SECR,SECR,PATH,PATH,PATH,WALL,WALL,WALL,PATH,WALL},        
     {WALL,PATH,WALL,WALL,PATH,PATH,PATH,WALL,WALL,WALL,WALL,PATH,PATH,WALL,WALL,WALL,WALL,WALL,PATH,WALL},        
     {PATH,PATH,PATH,WALL,PATH,PATH,PATH,WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL,PATH,PATH},        
     {WALL,WALL,PATH,WALL,PATH,WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},        
     {WALL,WALL,PATH,WALL,PATH,WALL,WALL,WALL,SECR,WALL,WALL,PATH,WALL,WALL,WALL,WALL,PATH,PATH,PATH,WALL},        
     {WALL,PATH,PATH,PATH,PATH,WALL,WALL,WALL,SECR,WALL,WALL,PATH,WALL,WALL,WALL,WALL,PATH,PATH,PATH,WALL},        
     {WALL,PATH,WALL,WALL,PATH,WALL,SECR,SECR,SECR,WALL,WALL,PATH,WALL,WALL,WALL,WALL,PATH,PATH,PATH,WALL},        
     {WALL,PATH,WALL,WALL,PATH,WALL,SECR,WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL,WALL,PATH,PATH,PATH,WALL},        
     {WALL,PATH,WALL,WALL,PATH,SECR,SECR,WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL,WALL,PATH,PATH,PATH,WALL},        
     {WALL,PATH,WALL,WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL},        
     {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL},        
     {WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL,PATH,PATH,PATH,PATH,SECR,SECR,SECR,SECR,PATH,WALL,WALL,WALL},        
     {WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL,PATH,PATH,PATH,PATH,WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL},        
     {WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL,PATH,PATH,PATH,PATH,WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL},        
     {WALL,WALL,WALL,WALL,PATH,WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL,WALL,PATH,WALL,WALL,WALL},        
     {WALL,WALL,WALL,WALL,PATH,WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL,PATH,WALL,WALL,PATH,WALL,WALL,WALL},        
     {WALL,WALL,WALL,WALL,PATH,PATH,PATH,WALL,WALL,WALL,WALL,WALL,WALL,PATH,PATH,PATH,PATH,WALL,WALL,WALL},        
     {WALL,WALL,WALL,WALL,PATH,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}
    };

       
           
//Variables for player.
    // directoin of the player
    int columnDir;
    int rowDir;
    //int value;
    boolean gameOver;
    int timeCount;
    boolean showPassage;

    Coin coin[];
    Character npcs[];
    Character player;
    static Maze frame;

    public static void main(String[] args) {
        frame = new Maze();
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Maze() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.BUTTON1 == e.getButton()) {
                    //left button

// location of the cursor.
                    int xpos = e.getX();
                    int ypos = e.getY();

                }
                if (e.BUTTON3 == e.getButton()) {
                    //right button
                    reset();
                }
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {

                repaint();
            }
        });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                if (e.VK_UP == e.getKeyCode()) {
                    rowDir = -1;
                    columnDir = 0;

                } else if (e.VK_DOWN == e.getKeyCode()) {
                    rowDir = 1;
                    columnDir = 0;

                } else if (e.VK_LEFT == e.getKeyCode()) {
                    rowDir = 0;
                    columnDir = -1;

                } else if (e.VK_RIGHT == e.getKeyCode()) {
                    rowDir = 0;
                    columnDir = 1;
                }

                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////

    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////

    public void destroy() {
    }

////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || xsize != getSize().width || ysize != getSize().height) {
            xsize = getSize().width;
            ysize = getSize().height;
            image = createImage(xsize, ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        g.setColor(Color.black);
        g.fillRect(0, 0, xsize, ysize);

        int x[] = {getX(0), getX(getWidth2()), getX(getWidth2()), getX(0), getX(0)};
        int y[] = {getY(0), getY(0), getY(getHeight2()), getY(getHeight2()), getY(0)};
//fill border
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.pink);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }

        g.setColor(Color.pink);
//horizontal lines
        for (int zi = 1; zi < numRows; zi++) {
            g.drawLine(getX(0), getY(0) + zi * getHeight2() / numRows,
                    getX(getWidth2()), getY(0) + zi * getHeight2() / numRows);
        }
//vertical lines
        for (int zi = 1; zi < numColumns; zi++) {
            g.drawLine(getX(0) + zi * getWidth2() / numColumns, getY(0),
                    getX(0) + zi * getWidth2() / numColumns, getY(getHeight2()));
        }

//Display the objects of the board
       
        // draw walls
        for (int zrow = 0; zrow < numRows; zrow++) {
            for (int zcolumn = 0; zcolumn < numColumns; zcolumn++) {
                if (board[zrow][zcolumn] == WALL) {
                    g.setColor(Color.darkGray);

                    g.fillRect(getX(0) + zcolumn * getWidth2() / numColumns,
                            getY(0) + zrow * getHeight2() / numRows,
                            getWidth2() / numColumns,
                            getHeight2() / numRows);

                }
               
               
                // draw secret passage is showPasage is true
                if (showPassage) {
                    if (board[zrow][zcolumn] == SECR)
                    {
                        g.setColor(Color.orange);

                        g.fillRect(getX(0) + zcolumn * getWidth2() / numColumns,
                                getY(0) + zrow * getHeight2() / numRows,
                                getWidth2() / numColumns,
                                getHeight2() / numRows);

                    }

                }
                // draw secret passage gray if showPassage is false
                if (board[zrow][zcolumn] == SECR && showPassage == false)
                {
                    g.setColor(Color.darkGray);

                    g.fillRect(getX(0) + zcolumn * getWidth2() / numColumns,
                            getY(0) + zrow * getHeight2() / numRows,
                            getWidth2() / numColumns,
                            getHeight2() / numRows);

                }
                if (board[zrow][zcolumn] == PORT)
                {
                    g.setColor(Color.magenta);

                    g.fillRect(getX(0) + zcolumn * getWidth2() / numColumns,
                            getY(0) + zrow * getHeight2() / numRows,
                            getWidth2() / numColumns,
                            getHeight2() / numRows);
                   
                }
               
                       

            }
        }
        player.draw(g, frame);

        for (int i = 0; i < coin.length; i++) {
            coin[i].draw(g, frame);
        }

        for (int i = 0; i < npcs.length; i++) {
            npcs[i].draw(g, frame);
        }

        if (gameOver) {
            g.setColor(Color.black);
            StringCentered(getWidth2() / 2, getHeight2() / 2, "GAME OVER", "Arial", 50);
        }
        g.setColor(Color.white);
        StringCentered(50, 620, "Lives " + Character.lives, "Arial", 20);

        gOld.drawImage(image, 0, 0, null);
    }

    public void StringCentered(int xpos, int ypos, String text, String font, int size) {
        g.setFont(new Font(font, Font.PLAIN, size));
        int width = g.getFontMetrics().stringWidth(text);
        int height = g.getFontMetrics().getHeight();
        xpos = xpos - width / 2;
        ypos = ypos - height / 4;
        xpos = getX(xpos);
        ypos = getYNormal(ypos);
        g.drawString(text, xpos, ypos);
    }
////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable

    public void run() {
        while (true) {
            animate();
            repaint();

            double seconds = .05;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////

    public void reset() {
        gameOver = false;
       
       
       
       
        for (int zrow = 0;zrow < numRows;zrow++)
        {
            for (int zcolumn = 0;zcolumn < numColumns;zcolumn++)
                board[zrow][zcolumn] = boardOrig[zrow][zcolumn];
        }
       
       
        // creates new player instance and
        player = new Character(frame);
        player.setPlayer(true);

        // creates arrays for coin instances
        coin = new Coin[Coin.numCoins];
        // create coin instance
        for (int i = 0; i < coin.length; i++) {
            coin[i] = new Coin(frame);
        }
        // create array for npcs
        npcs = new Character[Character.numNpcs];
        // create npc instance
        for (int i = 0; i < npcs.length; i++) {
            npcs[i] = new Character(frame);
        }
        // sets the instance variables for the npcs
        npcs[0].setColor(Color.red);
        npcs[0].setName("David");
        npcs[0].setSpeed(10);
       
       
        npcs[1].setColor(Color.blue);
        npcs[1].setName("Kevin");
        npcs[1].setSpeed(5);
       
        npcs[2].setName("Noa");
        npcs[2].setColor(Color.pink);
        npcs[2].setSpeed(3);
       
        //sets instance variables for player

        player.setColor(Color.green);
        Character.lives = 3;
       
       
        showPassage = false;
        timeCount = 0;

    }
/////////////////////////////////////////////////////////////////////////

    public void animate() {
        if (animateFirstTime) {
            animateFirstTime = false;
            if (xsize != getSize().width || ysize != getSize().height) {
                xsize = getSize().width;
                ysize = getSize().height;
            }
            reset();
        }
        if (gameOver) {
            return;
        }

        player.animate(frame, player.getRow(), player.getColumn(), coin, rowDir, columnDir);
        rowDir = 0;
        columnDir = 0;
        // move the npcs and player
        // see if npc and player hit each other if so move player to random location
        // if player runs out of lives game over is true
        for (Character npc : npcs) {

            if (npc.animate(frame, player.getRow(), player.getColumn(), coin, 0, 0)) {
                player.Move(frame);
                if (Character.lives <= 0) {

                    gameOver = true;
                }

            }

        }
        if(board[player.getRow()][player.getColumn()] == PORT){
           
            for (int zrow = 0;zrow < numRows;zrow++)
            {
                for (int zcolumn = 0;zcolumn < numColumns;zcolumn++)
                    board[zrow][zcolumn] = board2[zrow][zcolumn];
            }
            player.Move(frame);
           
            for (int i = 0; i < npcs.length; i++) {
                npcs[i].Move(frame);
            }
            for (int i = 0; i < coin.length; i++) {
                coin[i].Move(frame);
            }
           
        }
       
        timeCount++;

    }
////////////////////////////////////////////////////////////////////////////

    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////

    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }

/////////////////////////////////////////////////////////////////////////
    public int getX(int x) {
        return (x + XBORDER + WINDOW_BORDER);
    }

    public int getY(int y) {
        return (y + YBORDER + YTITLE);
    }

    public int getYNormal(int y) {
        return (-y + YBORDER + YTITLE + getHeight2());
    }

    public int getWidth2() {
        return (xsize - 2 * (XBORDER + WINDOW_BORDER));
    }

    public int getHeight2() {
        return (ysize - 2 * YBORDER - WINDOW_BORDER - YTITLE);
    }

    private static class initalboard {

        public initalboard() {
        }
    }
}
//////////////////////////////////////////////////////////////////////

class Coin {
// variables for coin class
    public static int numCoins = 5;
    private int row;
    private int column;
    private boolean visible;
    private int value;
// coin class constructor
    Coin(Maze frame) {
        value = (int) (Math.random() * 6) + 3;
        boolean keepLooping = true;
        while (keepLooping) {
            row = (int) (Math.random() * frame.numRows);
            column = (int) (Math.random() * frame.numColumns);
            if (frame.board[row][column] == frame.PATH) {
                keepLooping = false;
            }
        }
        visible = true;
    }
// draw coin
    public void draw(Graphics2D g, Maze frame) {
        if (!visible)
        {
            return;
        }
        g.setColor(Color.yellow);
        g.fillOval(frame.getX(0) + column * frame.getWidth2() / frame.numColumns,
                frame.getY(0) + row * frame.getHeight2() / frame.numRows,
                frame.getWidth2() / frame.numColumns,
                frame.getHeight2() / frame.numRows);
        g.setColor(Color.black);
        g.drawOval(frame.getX(0) + column * frame.getWidth2() / frame.numColumns,
                frame.getY(0) + row * frame.getHeight2() / frame.numRows,
                frame.getWidth2() / frame.numColumns,
                frame.getHeight2() / frame.numRows);
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("" + value, frame.getX(0) + column * frame.getWidth2() / frame.numColumns + 10,
        frame.getY(0) + row * frame.getHeight2() / frame.numRows + 20);
    }
// sees if coin has been picked up yet
    public int animate(int playerRow, int playerColumn) {
        if (!visible)
        {
            return (0);
        }
        if (playerRow == row && playerColumn == column) {
            visible = false;
            return (value);
        }
        return (0);
    }
    public void Move(Maze frame) {
        boolean keepLooping = true;
        while (keepLooping)
        {
            row = (int) (Math.random() * frame.numRows);
            column = (int) (Math.random() * frame.numColumns);
            if (frame.board[row][column] == frame.PATH)
            {  
                keepLooping = false;
            }
        }
    }
}
///////////////////////////////////////////////////
class Character {
// variables for Character class
    public static int numNpcs = 3;
    public static int lives;
    private int row;
    private int column;
    private int randomNum;
    private int value;
    private boolean isPlayer;
    private Color color;
    private String name;
    private int speed;
    public boolean filler;

// accessor
    public int getRow() {
        return (row);
    }
    public int getColumn() {
        return (column);
    }
// mutaters
    public void setName(String _name) {
        name = _name;
    }
    public void setColor(Color _color) {
        color = _color;
    }
    public void setSpeed(int _speed) {
        speed = _speed;
    }
    public void setPlayer(boolean _isPlayer) {
        isPlayer = _isPlayer;
    }
   
    //Character class constructors
    Character(Maze frame) {
        boolean keepLooping = true;
        while (keepLooping)
        {
            row = (int) (Math.random() * frame.numRows);
            column = (int) (Math.random() * frame.numColumns);
            if (frame.board[row][column] == frame.PATH)
            {
                keepLooping = false;
            }
            randomNum = (int) (Math.random() * 4);
        }
        value = 0;
        isPlayer = false;
    }
    // draw npcs and players
    public void draw(Graphics2D g, Maze frame) {
        g.setColor(color);
        g.fillRect(frame.getX(0) + column * frame.getWidth2() / frame.numColumns,
                frame.getY(0) + row * frame.getHeight2() / frame.numRows,
                frame.getWidth2() / frame.numColumns,
                frame.getHeight2() / frame.numRows);
        if (isPlayer)
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("" + value, frame.getX(0) + column * frame.getWidth2() / frame.numColumns + 10,
            frame.getY(0) + row * frame.getHeight2() / frame.numRows + 20);
        }
        if (!isPlayer)
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString(name + " " + value, frame.getX(0) + column * frame.getWidth2() / frame.numColumns + 10,
            frame.getY(0) + row * frame.getHeight2() / frame.numRows + 20);
        }
    }
    public boolean animate(Maze frame, int currentRow, int currentColumn, Coin coin[], int rowDir, int columnDir) {
// make npcs move in a somewhat inteligent manor
        if (!isPlayer)
        {
            if (frame.timeCount % speed == speed - 1)
            {

                if (randomNum == 0)
                {
                    rowDir = -1;
                    columnDir = 0;
                }
                if (randomNum == 1)
                {
                    rowDir = 1;
                    columnDir = 0;
                }
                if (randomNum == 2)
                {
                    rowDir = 0;
                    columnDir = -1;
                }
                if (randomNum == 3)
                {
                    rowDir = 0;
                    columnDir = 1;
                }
                if (row + rowDir < 0)
                {
                    row = frame.numRows;
                }
                if (column + columnDir < 0)
                {
                    column = frame.numColumns;
                }
                if (column + columnDir >= frame.numColumns)
                {
                    column = -1;
                }
                if (row + rowDir >= frame.numRows)
                {
                    row = -1;
                }
                if (frame.board[row + rowDir][column + columnDir] == frame.WALL)
                {
                    randomNum = (int) (Math.random() * 4);
                }
            }
        }
       // if player gets to the edge move player to the other side
        if (isPlayer) {
            if (row + rowDir < 0) {
                row = frame.numRows;
            }
            if (column + columnDir < 0) {
                column = frame.numColumns;
            }
            if (column + columnDir >= frame.numColumns) {
                column = -1;
            }
            if (row + rowDir >= frame.numRows) {
                row = -1;
            }
            // dont allow player to move if there is wall next to the edge
            if (value > 0 && frame.board[row + rowDir][column + columnDir] == frame.WALL
                    && column + columnDir > 0
                    && column + columnDir < frame.numColumns - 1
                    && row + rowDir > 0
                    && row + rowDir < frame.numRows - 1) {
                frame.board[row + rowDir][column + columnDir] = frame.PATH;
                value--;
            }
            // show the passage if player has coins
            if (value > 0)
            {
                frame.showPassage = true;
            } else
            {
                frame.showPassage = false;
            }
        }        
        // allow movement on secret path if showPassage is true
        if (frame.showPassage)
        {
            if (frame.board[row + rowDir][column + columnDir] == frame.PATH || frame.board[row + rowDir][column + columnDir] == frame.SECR || frame.board[row + rowDir][column + columnDir] == frame.PORT)
            {
                row += rowDir;
                column += columnDir;
            }
        }
// allow movement on path only if showPassage is false
        if (!frame.showPassage)
        {
            if (frame.board[row + rowDir][column + columnDir] == frame.PATH)
            {
                row += rowDir;
                column += columnDir;
            }
        }
        // player colides with npcs
        if (!isPlayer && currentRow == row && currentColumn == column) {
            lives--;
            return (true);
        }
        // if Character colides with coin add value to Character
        for (Coin coin1 : coin)
        {
            value += coin1.animate(row, column);
        }
        return (false);
    }
    public void Move(Maze frame) {
        boolean keepLooping = true;
        while (keepLooping)
        {
            row = (int) (Math.random() * frame.numRows);
            column = (int) (Math.random() * frame.numColumns);
            if (frame.board[row][column] == frame.PATH)
            {  
                keepLooping = false;
            }
        }
    }
}