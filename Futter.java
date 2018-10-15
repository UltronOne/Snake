import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Futter {
    private int x;
    private int y;
    private int scale;

    public Futter(int x_, int y_)
    {
        x = x_;
        y = y_;
        scale = 10;
    }

    public void zeichnen(GraphicsContext gc)
    {
        gc.setFill(Color.RED);
        gc.fillOval(x*scale,y*scale,scale-1,scale-1);

    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

}