import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FormPlane {
    private JPanel panelPlane;
    private JPanel panelButton;
    private JPanel panelNavig;

    private JButton btnCreateStorm;
    private JButton buttonLeft;
    private JButton buttonUp;
    private JButton buttonDown;
    private JButton buttonRight;
    private JPanel panelBtnNavig;

    private JComboBox<String> comboBoxRockets;

    private DrawPicture draw;
    private JFrame frameStormtrooper;

    public FormPlane() {
        frameStormtrooper = new JFrame("Штурмовик");
        frameStormtrooper.setSize(new Dimension(900, 500));
        frameStormtrooper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw = new DrawPicture();

        btnCreateStorm.addActionListener(e -> setPlane());

        buttonUp.addActionListener(e ->{
            draw.getTransport().MoveTransport(Direction.Up);
            frameStormtrooper.repaint();
        });
        buttonDown.addActionListener(e ->{
            draw.getTransport().MoveTransport(Direction.Down);
            frameStormtrooper.repaint();
        });
        buttonRight.addActionListener(e ->{
            draw.getTransport().MoveTransport(Direction.Right);
            frameStormtrooper.repaint();
        });
        buttonLeft.addActionListener(e ->{
            draw.getTransport().MoveTransport(Direction.Left);
            frameStormtrooper.repaint();
        });
        frameStormtrooper.add(panelPlane);
        frameStormtrooper.setVisible(true);
    }
    private void setPlane(){
            Random rnd = new Random();
            draw.setTransport(new Stormtrooper(rnd.nextInt(200)+100, rnd.nextInt(500)+1000, Color.BLACK, Color.GRAY, true, true, comboBoxRockets.getSelectedIndex()));
            draw.getTransport().SetPosition(rnd.nextInt(590) + 10, rnd.nextInt(150) + 20, panelPlane.getWidth(), panelPlane.getHeight()-panelNavig.getHeight()-panelNavig.getHeight() - panelButton.getHeight() );
            panelPlane.add(draw);
            frameStormtrooper.repaint();
            frameStormtrooper.setVisible(true);
        }
    }
