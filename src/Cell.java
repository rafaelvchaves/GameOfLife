import java.awt.*;
/**
 * Created by Rafael Chaves on 11/29/17.
 */
public class Cell {
    private boolean isAlive;
    private int row, col, size, age;


    public Cell(int r, int c, int size) {
        isAlive = false;
        row = r;
        col = c;
        this.size = size;
    }

    public void kill(){
        isAlive = false;
    }
    public void spawn(){
        isAlive = true;
    }

    public int numNeighbors(Cell[][] grid){
        if (isAlive)
            age++;
        int count = 0;
        if (row - 1 >= 0 && col - 1 > 0 && grid[row - 1][col - 1].getIsAlive()){
            count++;
        }
        if (row - 1 >= 0 && col >= 0 && grid[row - 1][col].getIsAlive()){
            count++;
        }
        if (row - 1 >= 0 && col + 1 < grid[0].length && grid[row - 1][col + 1].getIsAlive()){
            count++;
        }
        if (row >= 0 && col + 1 < grid[0].length && grid[row][col + 1].getIsAlive()){
            count++;
        }
        if (row + 1 < grid.length && col + 1 < grid[0].length && grid[row + 1][col + 1].getIsAlive()){
            count++;
        }
        if (row + 1 < grid.length && col >= 0 && grid[row + 1][col].getIsAlive()){
            count++;
        }
        if (row + 1 < grid.length && col - 1 >= 0 && grid[row + 1][col - 1].getIsAlive()){
            count++;
        }
        if (row >= 0 && col - 1 >= 0 && grid[row][col - 1].getIsAlive()){
            count++;
        }

        return count;
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.drawRect(col*size, row*size, size, size);
        if(isAlive)
            if (age == 0) {
                g2.setColor(new Color(0, 255, 0));
                g2.drawRect(col*size, row*size, size, size);
                g2.fillRect(col * size, row * size, size, size);
            }

            else if (age == 1) {
                g2.setColor(new Color(104, 186, 37));
                g2.drawRect(col*size, row*size, size, size);
                g2.fillRect(col * size, row * size, size, size);
            }

            else if (age == 2) {
                g2.setColor(new Color(34, 139, 34));
                g2.drawRect(col*size, row*size, size, size);
                g2.fillRect(col * size, row * size, size, size);
            }

            else if (age >= 3) {
                g2.setColor(new Color(25, 103, 32));
                g2.drawRect(col*size, row*size, size, size);
                g2.fillRect(col * size, row * size, size, size);
            }

    }
    public boolean getIsAlive(){
        return isAlive;
    }
    public void resetAge(){
        age = 0;
    }

}