import javafx.animation.AnimationTimer;

public class Timer extends AnimationTimer
{
    Controller controller;
    private long lastUpdate = 0 ;
    public Timer(Controller controller){
        this.controller = controller;
    }

    @Override
    public void handle(long now) {

        if (now - lastUpdate >= 200_000_000) {
            controller.update();
            lastUpdate = now ;
        }
    }

    @Override
    public void start(){
        super.start();
    }

    @Override
    public void stop(){
        super.stop();
    }
}
