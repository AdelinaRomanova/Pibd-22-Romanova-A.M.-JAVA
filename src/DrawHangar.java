import javax.swing.*;
import java.awt.*;
public class DrawHangar extends JPanel {
    private  HangarCollection hangarCollection;
    private String selectedItem = null;

    @Override
    public void paint(Graphics g) {
        if (selectedItem != null) {
            if (hangarCollection != null) {
                hangarCollection.get(selectedItem).Draw(g);
            }
        }
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public DrawHangar(HangarCollection hangarCollection) {
        this.hangarCollection = hangarCollection;
    }
}
