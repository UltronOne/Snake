import javafx.scene.canvas.GraphicsContext;
public class Knoten
{
    private SnakeElement inhalt;
    private Knoten naechster;

    public Knoten(SnakeElement inhalt_)
    {
        inhalt = inhalt_;
        naechster = null;
    }

    public void setNaechster(Knoten naechster_)
    {
        naechster = naechster_;
    }

    public void zeichnen(GraphicsContext gc)
    {
        // Hier ist etwas zu tun!
    }

    public void einfuegen(SnakeElement elem)
    {
        // Hier ist etwas zu tun!
    }

    public boolean trifft(int x, int y)
    {
        if (inhalt.trifft(x,y))
        {
            return true;
        }
        if(naechster != null)
        {
            return naechster.trifft(x,y);
        }
        return false;
    }

    public Knoten getNaechster()
    {
        return naechster;
    }

}
