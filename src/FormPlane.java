import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FormPlane {
    private JPanel panelPlane;
    private JPanel panelButton;
    private JPanel panelNavig;

    private JButton btnCreateWarplane;
    private JButton btnCreateStorm;
    private JButton buttonLeft;
    private JButton buttonUp;
    private JButton buttonDown;
    private JButton buttonRight;
    private JPanel panelBtnNavig;

    private JComboBox<String> comboBoxRockets;
    private JComboBox<String> comboBoxTypeRock;

    private DrawPicture draw;
    private JFrame framePlane;

    public FormPlane() {
        framePlane = new JFrame("Штурмовик");
        framePlane.setSize(new Dimension(900, 500));
        draw = new DrawPicture();

        btnCreateWarplane.addActionListener(e -> setWarplane());
        btnCreateStorm.addActionListener(e -> setStormtrooper());

        buttonUp.addActionListener(e ->{
            draw.getTransport().MoveTransport(Direction.Up);
            framePlane.repaint();
        });
        buttonDown.addActionListener(e ->{
            draw.getTransport().MoveTransport(Direction.Down);
            framePlane.repaint();
        });
        buttonRight.addActionListener(e ->{
            draw.getTransport().MoveTransport(Direction.Right);
            framePlane.repaint();
        });
        buttonLeft.addActionListener(e ->{
            draw.getTransport().MoveTransport(Direction.Left);
            framePlane.repaint();
        });

        framePlane.add(panelPlane);
        framePlane.setVisible(true);
    }

        private void setWarplane(){
            Random rnd = new Random();
            draw.setTransport(new Warplane(rnd.nextInt(200)+100, rnd.nextInt(500)+1000, Color.BLACK));
            draw.getTransport().SetPosition(rnd.nextInt(590) + 10, rnd.nextInt(150) + 20, panelPlane.getWidth(), panelPlane.getHeight()-panelNavig.getHeight() - panelButton.getHeight() );
            panelPlane.add(draw);
            framePlane.repaint();
            framePlane.setVisible(true);
        }

        private void setStormtrooper(){
            Random rnd = new Random();
            draw.setTransport(new Stormtrooper(rnd.nextInt(200)+100, rnd.nextInt(2000)+1000, Color.BLUE, Color.BLACK, true, true, comboBoxRockets.getSelectedIndex(), comboBoxTypeRock.getSelectedItem().toString()));
            draw.getTransport().SetPosition(rnd.nextInt(100), rnd.nextInt(100), panelPlane.getWidth(), panelPlane.getHeight()-panelNavig.getHeight()-panelButton.getHeight() );
            panelPlane.add(draw);
            framePlane.repaint();
            framePlane.setVisible(true);
        }

        public void setVehicle(ITransport transport){
            Random rnd = new Random();
            draw.setTransport(transport);
            draw.getTransport().SetPosition(rnd.nextInt(100), rnd.nextInt(100), panelPlane.getWidth(), panelPlane.getHeight()-panelNavig.getHeight()-panelButton.getHeight() );
            panelPlane.add(draw);
            framePlane.repaint();
            framePlane.setVisible(true);
    }
}
