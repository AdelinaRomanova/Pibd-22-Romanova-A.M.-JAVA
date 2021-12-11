import javax.swing.*;
import java.awt.*;

public class DrawPicture extends JComponent {
    private Stormtrooper storm;
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (storm != null){
            storm.DrawTransport(g);
        }
        super.repaint();
    }
    public void setTransport(Stormtrooper storm){
        this.storm = storm;
    }
    public Stormtrooper getTransport(){
        return storm;
    }
}
