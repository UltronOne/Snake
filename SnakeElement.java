import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SnakeElement {
    private int x;
    private int y;
    private int scale;

    public SnakeElement(int x_, int y_)
    {
        x = x_;
        y = y_;
        scale = 10;
    }

    public void zeichnen(GraphicsContext gc)
    {
        gc.setFill(Color.WHITE);
        gc.fillRect(x*scale,y*scale,scale-1,scale-1);

    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public boolean trifft(int x_, int y_)
    {
        if(x == x_ && y == y_)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
