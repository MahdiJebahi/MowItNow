package entities;

public class Mower {
    private int x;
    private int y;
    private char orientation;
    private Lawn lawn;

    public Mower(int x, int y, char orientation, Lawn lawn) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.lawn = lawn;
    }

    public void move(String g) {
        for (int i = 0; i < g.length(); i++) {
            if (g.charAt(i) == 'G') {
                turnLeft();
            }
            else if (g.charAt(i) == 'D') {
                turnRight();
            }
            else if (g.charAt(i) == 'A') {
                advance();
            }
        }
    }

    public void turnLeft(){
        if (orientation == 'N')
            orientation = 'W';
        else if (orientation =='W')
            orientation = 'S';
        else if (orientation =='S')
            orientation = 'E';
        else
            orientation = 'N';

    }
    public void turnRight(){
        if (orientation == 'N')
            orientation = 'E';
        else if (orientation =='E')
            orientation = 'S';
        else if (orientation =='S')
            orientation = 'W';
        else
            orientation = 'N';
    }

    public String getPosition() {
        return x + " " + y + " " + orientation;
    }

    public void advance() {
        int newX = x;
        int newY = y;
        if (orientation == 'N')
            newY++;
        else if (orientation == 'S')
            newY--;
        else if (orientation == 'E')
            newX++;
        else if(orientation == 'W')
            newX--;
      if (lawn.isInside(newX,newY)){
          x = newX;
          y = newY;
      }
    }
}
