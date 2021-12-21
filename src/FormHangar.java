import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Queue;

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
    private JTextField textBoxNameHangar;
    private JButton btnAddHangar;
    private JList listBoxHangars;
    private JButton btnDelHangar;
    private JButton btnSetPlane;

    private JFrame frameHangar;
    private Stormtrooper storm;
    private DefaultListModel<String> hangarList;
    private HangarCollection hangarCollection;
    private Queue<Vehicle> planeQueueVehicles;

    private DrawHangar draw;

    public FormHangar(){
        frameHangar = new JFrame("Parking");
        frameHangar.setSize(new Dimension(1000, 700));
        frameHangar.setDefaultCloseOperation(frameHangar.EXIT_ON_CLOSE);
        frameHangar.add(panelHangar);
        frameHangar.setVisible(true);
        hangarCollection = new HangarCollection(panelHangar.getWidth()-panelButton.getWidth(),  panelHangar.getHeight());
        draw = new DrawHangar(hangarCollection);
        panelHangar.add(draw);
        hangarList = new DefaultListModel<>();
        listBoxHangars.setModel(hangarList);
        planeQueueVehicles = new LinkedList<>();

        btnCreateWarplane.addActionListener(e -> createWarplane());
        btnCreateStorm.addActionListener(e -> createStorm());
        btnTakePlane.addActionListener(e -> takePlane());
        btnDelHangar.addActionListener(e -> delParking());
        btnAddHangar.addActionListener(e -> addParking());
        btnSetPlane.addActionListener(e -> setPlane());
        listBoxHangars.addListSelectionListener(e -> listListener());

        frameHangar.repaint();
    }

    private void createWarplane(){
        Random rnd = new Random();
        Color selectedColor = new JColorChooser().showDialog(frameHangar, "Выберите цвет", Color.YELLOW);
        if (selectedColor != null){
            Warplane plane = new Warplane(rnd.nextInt(200)+100, rnd.nextInt(2000)+1000, selectedColor);
            if(hangarCollection.get((String) listBoxHangars.getSelectedValue()).OperationAdd(plane) != -1){
                frameHangar.repaint();
            }
            else {JOptionPane.showMessageDialog(frameHangar, "Ангар полный");}
        }
    }

    private void createStorm(){
        Random rnd = new Random();
        Color selectedColor = new JColorChooser().showDialog(frameHangar, "Выберите цвет", Color.YELLOW);
        if (selectedColor != null){
            Color selectedColorDop = new JColorChooser().showDialog(frameHangar, "Выберите цвет", Color.GRAY);
            if (selectedColorDop != null) {
                storm = new Stormtrooper(rnd.nextInt(200)+100, rnd.nextInt(2000)+1000, selectedColor, selectedColorDop, true, true, comboBoxCountRock.getSelectedIndex(), comboBoxTypeRock.getSelectedItem().toString());
                if (hangarCollection.get((String) listBoxHangars.getSelectedValue()).OperationAdd(storm) != -1) {
                    frameHangar.repaint();
                } else {
                    JOptionPane.showMessageDialog(frameHangar, "Ангар полный");
                }
            }
        }
    }

    private void takePlane(){
        if (listBoxHangars.getSelectedIndex() >= 0) {
            if (!textBoxNameHangar.getText().equals("")) {
                try {
                    Vehicle plane = (hangarCollection.get((String)(listBoxHangars.getSelectedValue()))).OperationDel(Integer.parseInt(textAreaPlace.getText()));
                    System.out.println(plane);
                    if (plane != null) {
                        planeQueueVehicles.add(plane);
                        System.out.println(planeQueueVehicles.size());
                        frameHangar.repaint();
                    } else {
                        JOptionPane.showMessageDialog(frameHangar, "Самолёта с таким индексом нет!");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frameHangar, "Самолёта с таким индексом нет!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(frameHangar, "Ангар не выбран");
        }
    }

    private void setPlane() {
        if (!planeQueueVehicles.isEmpty()) {
            FormPlane formPlane = new FormPlane();
            formPlane.setVehicle(planeQueueVehicles.element());
            planeQueueVehicles.remove();
            frameHangar.repaint();
        }
    }

    private void reloadLevels() {
        int index = listBoxHangars.getSelectedIndex();
        hangarList.removeAllElements();
        int i = 0;
        for (String name : hangarCollection.keySet()) {
            hangarList.add(i, name);
            i++;
        }
        int itemsCount = hangarList.size();
        if (itemsCount > 0 && (index < 0 || index >= itemsCount)) {
            listBoxHangars.setSelectedIndex(0);
        } else if (index >= 0 && index < itemsCount) {
            listBoxHangars.setSelectedIndex(index);
        }
    }

    private void addParking() {
        if (!textBoxNameHangar.getText().equals("")) {
            hangarCollection.AddParking(textBoxNameHangar.getText());
            reloadLevels();
            frameHangar.repaint();
        } else {
            JOptionPane.showMessageDialog(draw, "Введите название ангара");
        }
    }

    private void delParking() {
        if (listBoxHangars.getSelectedIndex() >= 0) {
            int result = JOptionPane.showConfirmDialog(draw, "Удалить ангар " + listBoxHangars.getSelectedValue() + "?");
            if (result == JOptionPane.YES_OPTION) {
                hangarCollection.DelParking((String) listBoxHangars.getSelectedValue());
                reloadLevels();
                frameHangar.repaint();
            }
        } else {
            JOptionPane.showMessageDialog(draw, "Ангар не выбран");
        }
    }

    private void listListener() {
        draw.setSelectedItem((String) listBoxHangars.getSelectedValue());
        frameHangar.repaint();
    }
}
