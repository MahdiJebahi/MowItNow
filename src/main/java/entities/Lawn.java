package entities;

public class Lawn {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Lawn(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public boolean isInside(int newX, int newY) {
        if (newX < 0 || newX > width || newY < 0 || newY > height) {
            return false;
        }
        else
            return true;
    }
}
