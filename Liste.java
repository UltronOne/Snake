import javafx.scene.canvas.GraphicsContext;

public class Liste
{
    private Knoten erster;

    public Liste()
    {
    }

    public void einfuegen(SnakeElement elem)
    {
        if(erster==null){
         erster = new Knoten(elem);   
            
        }else{
            
         erster.einfuegen(elem);   
        }
        
    }

    public void entnehmen()
    {
        erster = erster.getNaechster();

    }

    public void zeichnen(GraphicsContext gc)
    {
        if(erster !=null){
            erster.zeichnen(gc);
        }
        
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
