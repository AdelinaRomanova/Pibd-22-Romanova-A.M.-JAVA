import javax.swing.*;
import java.awt.*;
public class DrawHangar extends JComponent {
    private Hangar<Warplane, IRockets> hangar;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (hangar != null){
            hangar.Draw(g);
        }
        super.repaint();
    }

    public void setHangar(Hangar<Warplane, IRockets> hangar){
        this.hangar = hangar;
    }

    public Hangar<Warplane, IRockets> getHangar(){
        return hangar;
    }
}
