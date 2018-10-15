import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.application.Platform;

import javafx.scene.control.*;

public class Controller {
    @FXML
    private Canvas canvas;

    @FXML
    private Button btnStart;

    @FXML
    private Label lblLoose;

    @FXML
    private Label lblPunkte;

    private GraphicsContext gc;

    private Snake snake;
    private Timer timer;
    private int scale;

    private Futter futter;
    private int breite;
    private int hoehe;
    private int b;
    private int h;
    private String zustand;

    private int punkte;

    @FXML 
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        snake = new Snake();
        timer = new Timer(this);   

        //Größe des Spielfelds:
        b = (int)canvas.getWidth();
        h = (int)canvas.getHeight();

        // Anzahl der Spalten / Zeilen
        breite = (int) (canvas.getWidth()/10);
        hoehe = (int) (canvas.getHeight()/10);        

        futter = new Futter(10,10);

        lblLoose.setVisible(false);
        btnStart.setVisible(true);
        lblPunkte.setVisible(false);

    }

    @FXML
    public void start(ActionEvent event) {

        // Startbutton nicht mehr anzeigen
        btnStart.setVisible(false);
        lblLoose.setVisible(false);

        punkte = 0;
        lblPunkte.setText("Punkte: " + punkte);
        lblPunkte.setVisible(true);

        // Snake erzeugen
        snake.init();
        // Spielfeld zeichnen
        zeichnen();
        // Timer starten
        timer.start();

    }

    public void stop()
    {
        //snake.sterben();
        timer.stop();
        lblLoose.setVisible(true);
        btnStart.setVisible(true);
    }

    // Gameloop
    public void update()
    {       
        snake.bewegen();
        int x = snake.getKopfX();
        int y = snake.getKopfY();

        // Snake findet Futter
        if (x == futter.getX() && y == futter.getY())
        {
            snake.essen();
            int xf = (int) (Math.random() * breite);
            int yf = (int) (Math.random() * hoehe);
            futter = new Futter(xf,yf);
            punkte = punkte + 10;
            lblPunkte.setText("Punkte: " + punkte);
        }
        // Snake stößt an den Rand
        if (x < 0 || x >= breite || y < 0 || y >= hoehe)
        {
            stop();   
        }

        if (snake.trifftSich())
        { 
            stop();
        }

        // Zeichne das Spielfeld
        zeichnen();
    }

    public void zeichnen()
    {
        // Löscht das Spielfeld
        gc.clearRect(0,0,b,h);
        //Zeichnet den Snake und das Futter
        snake.zeichnen(gc);
        futter.zeichnen(gc);
    }

    // STeuerung mit den Tasten

    public void gedrueckt(KeyEvent ke)
    {
        if (ke.getCode() == KeyCode.LEFT)
        {
            snake.setRichtung("links");   
        }
        if (ke.getCode() == KeyCode.RIGHT)
        {
            snake.setRichtung("rechts");
        }
        if (ke.getCode() == KeyCode.DOWN)
        {
            snake.setRichtung("unten");
        }
        if (ke.getCode() == KeyCode.UP)
        {
            snake.setRichtung("oben");
        }
        if (ke.getCode() == KeyCode.A)
        {
            snake.setRichtung("links");   
        }
        if (ke.getCode() == KeyCode.D)
        {
            snake.setRichtung("rechts");
        }
        if (ke.getCode() == KeyCode.S)
        {
            snake.setRichtung("unten");
        }
        if (ke.getCode() == KeyCode.W)
        {
            snake.setRichtung("oben");
        }

        ke.consume();
    }

}