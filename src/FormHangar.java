import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FormHangar {
    private JPanel panelHangar;
    private JPanel panelButton;
    private JPanel panelCreateHangar;
    private JPanel panelTakePlane;
    private JButton btnTakePlane;
    private JTextArea textAreaPlace;
    private JButton btnCreateWarplane;
    private JButton btnCreateStorm;
    private JComboBox comboBoxTypeRock;
    private JComboBox comboBoxCountRock;

    private JFrame frameHangar;
    private Stormtrooper storm;
    private Hangar<Warplane, IRockets> hangar;
    private DrawHangar draw;

    public FormHangar(){
        frameHangar = new JFrame("Parking");
        frameHangar.setSize(new Dimension(1000, 700));
        frameHangar.setDefaultCloseOperation(frameHangar.EXIT_ON_CLOSE);
        btnCreateWarplane.addActionListener(e -> createWarplane());
        btnCreateStorm.addActionListener(e -> createStorm());
        btnTakePlane.addActionListener(e -> takePlane());
        frameHangar.add(panelHangar);
        frameHangar.setVisible(true);
        draw = new DrawHangar();
        hangar = new Hangar<Warplane, IRockets>(panelHangar.getWidth(), panelHangar.getHeight());
        draw.setHangar(hangar);
        panelHangar.add(draw);
        draw.repaint();
    }

    private void createWarplane(){
        Random rnd = new Random();
        Color selectedColor = new JColorChooser().showDialog(frameHangar, "Choose a color", Color.YELLOW);
        if (selectedColor != null){
            Warplane plane = new Warplane(rnd.nextInt(200)+100, rnd.nextInt(2000)+1000, selectedColor);
            if(draw.getHangar().OperationAdd(plane) != -1){
                draw.repaint();
            }
            else {JOptionPane.showMessageDialog(frameHangar, "The parking lot is full");}
        }
    }

    private void createStorm(){
        Random rnd = new Random();
        Color selectedColor = new JColorChooser().showDialog(frameHangar, "Choose a color", Color.YELLOW);
        if (selectedColor != null){
            Color selectedColorDop = new JColorChooser().showDialog(frameHangar, "Choose a color", Color.GRAY);
            if (selectedColorDop != null) {
                storm = new Stormtrooper(rnd.nextInt(200)+100, rnd.nextInt(2000)+1000, selectedColor, selectedColorDop, true, true, comboBoxCountRock.getSelectedIndex(), comboBoxTypeRock.getSelectedItem().toString());
                if (draw.getHangar().OperationAdd(storm) != -1) {
                    draw.repaint();
                } else {
                    JOptionPane.showMessageDialog(frameHangar, "The parking lot is full");
                }
            }
        }
    }

    private void takePlane(){
        if (textAreaPlace.getText() != ""){
            ITransport transport = draw.getHangar().OperationDel(Integer.parseInt((textAreaPlace.getText())));
            if (transport != null){
                FormPlane form = new FormPlane();
                form.setVehicle(transport);
            }
        }
        draw.repaint();
    }



}
