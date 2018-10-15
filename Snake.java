import javafx.scene.canvas.GraphicsContext;

public class Snake
{
    private SnakeElement kopf;
    private Liste schwanz;  // Eine Liste die Snakeelemente aufnehmen kann

    private int vx;
    private int vy;
   


    public void init()
    {
        kopf = new SnakeElement(1,1);
        schwanz = new Liste();
        vx = 1;
        vy = 0;
    }

    public void bewegen()
    {
        int x = kopf.getX();
        int y = kopf.getY();
        schwanz.einfuegen(kopf);
        kopf = new SnakeElement(x+vx,y+vy);
        schwanz.entnehmen();
    }

    public void essen()
    {
        int x = kopf.getX();
        int y = kopf.getY();
        schwanz.einfuegen(kopf);
        kopf = new SnakeElement(x+vx,y+vy);
    }

    public void sterben()
    {
        schwanz.leeren();
        kopf = new SnakeElement(10,10);
    }

    public void setRichtung(String richtung)
    {
        if (richtung.equals("rechts"))
        {
            vx = 1;
            vy = 0;
        }
        if (richtung.equals("links"))
        {
            vx = -1;
            vy = 0;
        }
        if (richtung.equals("oben"))
        {
            vx = 0;
            vy = -1;
        }
        if (richtung.equals("unten"))
        {
            vx = 0;
            vy = 1;
        }

    }

    public boolean trifftSich()
    {
        return schwanz.trifft(kopf.getX(),kopf.getY());
    }

    public int getKopfX()
    {
        return kopf.getX();
    }

    public int getKopfY()
    {
        return kopf.getY();
    }

    public void zeichnen(GraphicsContext gc)
    {
        kopf.zeichnen(gc);
        schwanz.zeichnen(gc);
    }

}
