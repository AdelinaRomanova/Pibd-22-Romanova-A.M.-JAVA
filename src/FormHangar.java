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
    private JTextField textBoxNameHangar;
    private JButton btnAddHangar;
    private JList listBoxHangars;
    private JButton btnDelHangar;
    private JButton btnSetPlane;
    private JButton btnAddPlane;

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

        btnAddPlane.addActionListener(e -> createPLane());
        btnTakePlane.addActionListener(e -> takePlane());
        btnDelHangar.addActionListener(e -> delParking());
        btnAddHangar.addActionListener(e -> addParking());
        btnSetPlane.addActionListener(e -> setPlane());
        listBoxHangars.addListSelectionListener(e -> listListener());

        frameHangar.repaint();
    }

    private void createPLane() {
        FormPlaneConfig frameConfig = new FormPlaneConfig(this);
    }
    public void addPlane(Warplane plane) {
        if (plane != null && listBoxHangars.getSelectedIndex() >= 0) {
            if (((hangarCollection.get((String) listBoxHangars.getSelectedValue()).OperationAdd(plane))) !=-1) {
                frameHangar.repaint();
            } else {
                JOptionPane.showMessageDialog(frameHangar, "Самолёт не удалось приземлить");
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
