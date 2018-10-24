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
        inhalt.zeichnen(gc);
        if(naechster!=null){
            naechster.zeichnen(gc);
            
            
        }
    }

    public void einfuegen(SnakeElement elem)
    {
        if(naechster==null){
            
            naechster = new Knoten(elem);
        }else{
         einfuegen(elem);   
            
    }
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
