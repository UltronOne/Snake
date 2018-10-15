import javafx.scene.canvas.GraphicsContext;

public class Liste
{
    private Knoten erster;

    public Liste()
    {
    }

    public void einfuegen(SnakeElement elem)
    {
        
        // Hier ist etwas zu tun
    }

    public void entnehmen()
    {
        // Hier ist etwas zu tun

    }

    public void zeichnen(GraphicsContext gc)
    {
        // Hier ist etwas zu tun
    }

    public void leeren()
    {
        erster = null;
    }

    public boolean trifft(int x, int y)
    {
        if (erster != null)
        {
            return erster.trifft(x,y);
        }
        else
        {
            return false;
        }
    }

}
