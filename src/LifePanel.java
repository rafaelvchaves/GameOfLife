import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Rafael Chaves on 11/29/17.
 */
public class LifePanel extends JPanel{
    private Cell[][] grid;
    private Timer timer;
    private boolean[][] nextGen;
    private int delay = 1000;

    public LifePanel(int w, int h){
        setSize(w, h);
        setLayout(null);
        grid = new Cell[20][20];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = new Cell(r, c, 40);
            }
        }

        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextGen = new boolean[20][20];
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[0].length; c++) {
                        if (grid[r][c].getIsAlive()){
                            if (grid[r][c].numNeighbors(grid) <= 1 || grid[r][c].numNeighbors(grid) >= 4)
                                nextGen[r][c] = false;
                            else
                                nextGen[r][c] = true;
                        }
                        else {
                            if (grid[r][c].numNeighbors(grid) == 3)
                                nextGen[r][c] = true;
                            else
                                nextGen[r][c] = false;
                        }
                    }
                }
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[0].length; c++) {
                        if (grid[r][c].getIsAlive() && !nextGen[r][c])
                            grid[r][c].kill();
                        else if (!grid[r][c].getIsAlive() && nextGen[r][c])
                            grid[r][c].spawn();
                    }
                }
                repaint();
            }
        });
        JButton glider = new JButton("Glider");
        glider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[0].length; c++) {
                        if (grid[r][c].getIsAlive())
                            grid[r][c].kill();
                    }
                }
                grid[1][2].spawn();
                grid[2][3].spawn();
                grid[3][3].spawn();
                grid[3][2].spawn();
                grid[3][1].spawn();
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[0].length; c++) {
                        grid[r][c].resetAge();
                    }
                }
                grabFocus();
                repaint();
                timer.stop();
            }
        });
        glider.setBounds(805, 120, 155, 20);
        JButton smallExploder = new JButton("Small Exploder");
        smallExploder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[0].length; c++) {
                        if (grid[r][c].getIsAlive())
                            grid[r][c].kill();
                    }
                }
                grid[8][9].spawn();
                grid[9][9].spawn();
                grid[9][8].spawn();
                grid[9][10].spawn();
                grid[10][8].spawn();
                grid[10][10].spawn();
                grid[11][9].spawn();
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[0].length; c++) {
                        grid[r][c].resetAge();
                    }
                }
                grabFocus();
                repaint();
                timer.stop();
            }
        });
        smallExploder.setBounds(805, 140, 155, 20);
        JButton exploder = new JButton("Exploder");
        exploder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[0].length; c++) {
                        if (grid[r][c].getIsAlive())
                            grid[r][c].kill();
                    }
                }
                for (int r = 7; r < 12; r++) {
                    for (int c = 0; c <= 10; c++) {
                        if (c % 2 == 0)
                            grid[r][7].spawn();
                        else
                            grid[r][11].spawn();

                    }
                }
                grid[7][9].spawn();
                grid[11][9].spawn();
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[0].length; c++) {
                        grid[r][c].resetAge();
                    }
                }
                grabFocus();
                repaint();
                timer.stop();
            }
        });
        exploder.setBounds(805, 160, 155, 20);
        JButton tenCellRow = new JButton("10 Cell Row");
        tenCellRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[0].length; c++) {
                        if (grid[r][c].getIsAlive())
                            grid[r][c].kill();
                    }
                }
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 5; c < 15; c++) {
                        grid[9][c].spawn();
                    }
                }
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[0].length; c++) {
                        grid[r][c].resetAge();
                    }
                }
                grabFocus();
                repaint();
                timer.stop();
            }
        });
        tenCellRow.setBounds(805, 180, 155, 20);
        JButton tumbler = new JButton("Tumbler");
        tumbler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[0].length; c++) {
                        if (grid[r][c].getIsAlive())
                            grid[r][c].kill();
                    }
                }
                for (int r = 7; r <= 12; r++) {
                    for (int c = 7; c <= 13; c++) {
                        if (c == 7 || c == 13){
                            grid[10][c].spawn();
                            grid[11][c].spawn();
                            grid[12][c].spawn();
                        }
                        if (c == 8 || c == 12){
                            grid[7][c].spawn();
                            grid[8][c].spawn();
                            grid[12][c].spawn();
                        }
                        if (c == 9 || c == 11){
                            for (int r1 = 7; r1 <= 11; r1++) {
                                grid[r1][c].spawn();
                            }
                        }

                    }

                }
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[0].length; c++) {
                        grid[r][c].resetAge();
                    }
                }

                grabFocus();
                repaint();
                timer.stop();
            }
        });
        tumbler.setBounds(805, 200, 155, 20);

        add(glider);
        add(smallExploder);
        add(exploder);
        add(tenCellRow);
        add(tumbler);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    delay -= 100;
                    if (delay <= 0)
                        delay  = 50;
                    timer.setDelay(delay);

                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    delay += 100;
                    timer.setDelay(delay);

                }
                if (e.getKeyCode() == KeyEvent.VK_C){
                    for (int r = 0; r < grid.length; r++) {
                        for (int c = 0; c < grid[0].length; c++) {
                            if (grid[r][c].getIsAlive())
                                grid[r][c].kill();
                        }
                    }
                    repaint();

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY() - 10;

                int w = (getWidth() - 200) / 20;
                int h = getHeight() / 20;
                int r = y / h;
                int c = x / w;
                if (x < 800) {
                    if (!grid[r][c].getIsAlive())
                        grid[r][c].spawn();
                    else
                        grid[r][c].kill();
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                timer.stop();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                timer.start();
            }
        });

        JLabel up = new JLabel("Up = Increase Speed");
            up.setBounds(805, 0, 130, 20);
            JLabel down = new JLabel("Down = Decrease Speed");
            down.setBounds(805, 20, 155, 20);
            JLabel clear = new JLabel("C = Clear Board");
            clear.setBounds(805, 40, 155, 20);
            JLabel presets = new JLabel("Preset Shapes:");
            presets.setBounds(805, 100, 155, 20);
            JLabel mouse1 = new JLabel("Mouse inside window = pause");
            mouse1.setBounds(805, 60, 200, 20);
            JLabel mouse2 = new JLabel("Mouse outside window = start");
            mouse2.setBounds(805, 80, 200, 20);
            JLabel click = new JLabel("Click cells to kill/spawn them");
            click.setBounds(805, 220, 250, 20);
            add(up);
            add(down);
            add(clear);
            add(presets);
            add(mouse1);
            add(mouse2);
            add(click);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c].draw(g2);
                grid[r][c].resetAge();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 1000;
        int height = 800;
        frame.setPreferredSize(new Dimension(width, height + 24));

        JPanel panel = new LifePanel(width, height);
        panel.setFocusable(true);
        panel.grabFocus();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
