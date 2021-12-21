import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;

public class FormPlaneConfig {
    Vehicle plane;
    FormHangar formParking;

    private  JFrame frame;
    private  DrawPicture drawPicture;

    private JSpinner spinnerWeight;
    private JSpinner spinnerMaxSpeed;
    private JCheckBox checkBoxTurbo;
    private JCheckBox checkBoxRockets;
    private JSpinner spinnerRocketsCount;

    private JLabel labelPictureBox;

    public FormPlaneConfig(FormHangar formHangar) {

        this.formParking = formHangar;

        frame = new JFrame("Конфигурация самолёта");
        frame.setSize(900, 450);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);

        JButton buttonAddPlane = new JButton("Добавить");
        buttonAddPlane.setBounds(15, 350, 90, 50);
        buttonAddPlane.addActionListener(e -> addVehicle());
        frame.getContentPane().add(buttonAddPlane);

        JButton buttonCancel = new JButton("Отменить");
        buttonCancel.setBounds(110, 350, 95, 50);
        buttonAddPlane.addActionListener(e -> cancel());
        frame.getContentPane().add(buttonCancel);

        JPanel groupRockets = new JPanel();
        groupRockets.setBorder(BorderFactory.createTitledBorder("Виды ракет"));
        groupRockets.setBounds(650, 180, 210, 230);
        groupRockets.setLayout(null);
        frame.getContentPane().add(groupRockets);

        JLabel labelRocketsDop = new JLabel("Овальные ракеты");
        labelRocketsDop.setHorizontalAlignment(SwingConstants.CENTER);
        labelRocketsDop.setBorder(BorderFactory.createLineBorder(Color.black));
        labelRocketsDop.setBounds(10, 20, 190, 40);
        groupRockets.add(labelRocketsDop);

        JLabel labelRocketsRect = new JLabel("Прямоугольные ракеты");
        labelRocketsRect.setHorizontalAlignment(SwingConstants.CENTER);
        labelRocketsRect.setBorder(BorderFactory.createLineBorder(Color.black));
        labelRocketsRect.setBounds(10, 70, 190, 40);
        groupRockets.add(labelRocketsRect);

        JLabel labelRocketsTringle = new JLabel("Треугольные ракеты");
        labelRocketsTringle.setHorizontalAlignment(SwingConstants.CENTER);
        labelRocketsTringle.setBorder(BorderFactory.createLineBorder(Color.black));
        labelRocketsTringle.setBounds(10, 120, 190, 40);
        groupRockets.add(labelRocketsTringle);


        JLabel labelRocketsCount = new JLabel("Количество ракет:");
        labelRocketsCount.setBounds(10, 170, 190, 20);
        groupRockets.add(labelRocketsCount);
        spinnerRocketsCount = new JSpinner(new SpinnerNumberModel(4, 2, 6, 2));
        spinnerRocketsCount.setBounds(10, 190, 190, 20);
        groupRockets.add(spinnerRocketsCount);

        var listenerForRockets= new DragMouseAdapter();

        labelRocketsDop.addMouseListener(listenerForRockets);
        labelRocketsRect.addMouseListener(listenerForRockets);
        labelRocketsTringle.addMouseListener(listenerForRockets);

        labelRocketsDop.setTransferHandler(new TransferHandler("text"));
        labelRocketsRect.setTransferHandler(new TransferHandler("text"));
        labelRocketsTringle.setTransferHandler(new TransferHandler("text"));

        JPanel groupColor = new JPanel();
        groupColor.setBorder(BorderFactory.createTitledBorder("Цвет машины"));
        groupColor.setBounds(650, 10, 210, 160);
        groupColor.setLayout(null);
        frame.getContentPane().add(groupColor);

        JLabel labelMainColor = new JLabel("Основной цвет");
        PropertyChangeListener propertyChangeListenerMainColor = propertyChangeEvent -> {
            if (plane != null) {
                plane.setNewMainColor(labelMainColor.getBackground());
                frame.repaint();
            }
        };
        labelMainColor.setBorder(BorderFactory.createLineBorder(Color.black));
        labelMainColor.setHorizontalAlignment(SwingConstants.CENTER);
        labelMainColor.addPropertyChangeListener("background", propertyChangeListenerMainColor);
        labelMainColor.setBounds(10, 20, 90, 30);
        groupColor.add(labelMainColor);

        JLabel labelDopColor = new JLabel("Доп. цвет");
        PropertyChangeListener propertyChangeListenerDopColor = propertyChangeEvent -> {
            if (plane instanceof Stormtrooper) {
                Stormtrooper storm = (Stormtrooper) plane;
                storm.setNewDopColor(labelDopColor.getBackground());
                plane = storm;
                frame.repaint();
            }
        };
        labelDopColor.setBorder(BorderFactory.createLineBorder(Color.black));
        labelDopColor.setHorizontalAlignment(SwingConstants.CENTER);
        labelDopColor.addPropertyChangeListener("background", propertyChangeListenerDopColor);
        labelDopColor.setBounds(110, 20, 90, 30);
        groupColor.add(labelDopColor);

        JLabel labelPink = new JLabel();
        labelPink.setBackground(Color.PINK);
        labelPink.setOpaque(true);
        labelPink.setBorder(BorderFactory.createLineBorder(Color.black));
        labelPink.setBounds(10, 60, 40, 40);
        groupColor.add(labelPink);

        JLabel labelOrange = new JLabel();
        labelOrange.setBackground(Color.ORANGE);
        labelOrange.setOpaque(true);
        labelOrange.setBorder(BorderFactory.createLineBorder(Color.black));
        labelOrange.setBounds(60, 60, 40, 40);
        groupColor.add(labelOrange);

        JLabel labelRed = new JLabel();
        labelRed.setBackground(Color.RED);
        labelRed.setOpaque(true);
        labelRed.setBorder(BorderFactory.createLineBorder(Color.black));
        labelRed.setBounds(110, 60, 40, 40);
        groupColor.add(labelRed);

        JLabel labelBlack = new JLabel();
        labelBlack.setBackground(Color.BLACK);
        labelBlack.setOpaque(true);
        labelBlack.setBorder(BorderFactory.createLineBorder(Color.black));
        labelBlack.setBounds(160, 60, 40, 40);
        groupColor.add(labelBlack);

        JLabel labelWhite = new JLabel();
        labelWhite.setBackground(Color.WHITE);
        labelWhite.setOpaque(true);
        labelWhite.setBorder(BorderFactory.createLineBorder(Color.black));
        labelWhite.setBounds(10, 110, 40, 40);
        groupColor.add(labelWhite);

        JLabel labelCyan = new JLabel();
        labelCyan.setBackground(Color.CYAN);
        labelCyan.setOpaque(true);
        labelCyan.setBorder(BorderFactory.createLineBorder(Color.black));
        labelCyan.setBounds(60, 110, 40, 40);
        groupColor.add(labelCyan);

        JLabel labelMagenta = new JLabel();
        labelMagenta.setBackground(Color.MAGENTA);
        labelMagenta.setOpaque(true);
        labelMagenta.setBorder(BorderFactory.createLineBorder(Color.black));
        labelMagenta.setBounds(110, 110, 40, 40);
        groupColor.add(labelMagenta);

        JLabel labelYellow = new JLabel();
        labelYellow.setBackground(Color.YELLOW);
        labelYellow.setOpaque(true);
        labelYellow.setBorder(BorderFactory.createLineBorder(Color.black));
        labelYellow.setBounds(160, 110, 40, 40);
        groupColor.add(labelYellow);

        var listenerForColor = new DragMouseAdapter();

        labelPink.addMouseListener(listenerForColor);
        labelOrange.addMouseListener(listenerForColor);
        labelRed.addMouseListener(listenerForColor);
        labelBlack.addMouseListener(listenerForColor);
        labelWhite.addMouseListener(listenerForColor);
        labelCyan.addMouseListener(listenerForColor);
        labelMagenta.addMouseListener(listenerForColor);
        labelYellow.addMouseListener(listenerForColor);
        labelDopColor.addMouseListener(listenerForColor);
        labelMainColor.addMouseListener(listenerForColor);

        labelPink.setTransferHandler(new TransferHandler("background"));
        labelOrange.setTransferHandler(new TransferHandler("background"));
        labelRed.setTransferHandler(new TransferHandler("background"));
        labelBlack.setTransferHandler(new TransferHandler("background"));
        labelWhite.setTransferHandler(new TransferHandler("background"));
        labelCyan.setTransferHandler(new TransferHandler("background"));
        labelMagenta.setTransferHandler(new TransferHandler("background"));
        labelYellow.setTransferHandler(new TransferHandler("background"));
        labelDopColor.setTransferHandler(new TransferHandler("background"));
        labelMainColor.setTransferHandler(new TransferHandler("background"));

        JPanel groupSettingsPanel = new JPanel();
        groupSettingsPanel.setBorder(BorderFactory.createTitledBorder("Параметры машины"));
        groupSettingsPanel.setBounds(10, 10, 200, 400);
        groupSettingsPanel.setLayout(null);
        frame.getContentPane().add(groupSettingsPanel);

        JLabel labelWarplane = new JLabel("Военный самолёт");
        labelWarplane.setBorder(BorderFactory.createLineBorder(Color.black));
        labelWarplane.setHorizontalAlignment(SwingConstants.CENTER);
        labelWarplane.setBounds(10, 30, 180, 60);
        groupSettingsPanel.add(labelWarplane);

        JLabel labelStormtrooper = new JLabel("Штурмовик");
        labelStormtrooper.setBorder(BorderFactory.createLineBorder(Color.black));
        labelStormtrooper.setHorizontalAlignment(SwingConstants.CENTER);
        labelStormtrooper.setBounds(10, 110, 180, 60);
        groupSettingsPanel.add(labelStormtrooper);

        JLabel labelWeight = new JLabel("Вес:");
        labelWeight.setBounds(10, 180, 180, 20);
        groupSettingsPanel.add(labelWeight);
        spinnerWeight = new JSpinner(new SpinnerNumberModel(100, 100, 1000, 10));
        spinnerWeight.setBounds(10, 200, 180, 20);
        groupSettingsPanel.add(spinnerWeight);

        JLabel labelMaxSpeed = new JLabel("Максимальная скорость:");
        labelMaxSpeed.setBounds(10, 230, 180, 20);
        groupSettingsPanel.add(labelMaxSpeed);
        spinnerMaxSpeed = new JSpinner(new SpinnerNumberModel(10, 10, 100, 10));
        spinnerMaxSpeed.setBounds(10, 250, 180, 20);
        groupSettingsPanel.add(spinnerMaxSpeed);

        checkBoxTurbo = new JCheckBox("Турбо");
        checkBoxTurbo.setBounds(10, 280, 180, 20);
        groupSettingsPanel.add(checkBoxTurbo);

        checkBoxRockets = new JCheckBox("Ракеты");
        checkBoxRockets.setBounds(10, 300, 180, 20);
        groupSettingsPanel.add(checkBoxRockets);

        drawPicture = new DrawPicture();
        drawPicture.setBorder(BorderFactory.createLineBorder(Color.black));
        drawPicture.setBounds(230, 20, 400, 300);
        frame.getContentPane().add(drawPicture);

        labelPictureBox = new JLabel("");
        PropertyChangeListener propertyChangeListenerTransport = propertyChangeEvent -> {
            if (labelPictureBox.getText().equals("Военный самолёт")) {
                setWarplane();
            }
            if (labelPictureBox.getText().equals("Штурмовик")) {
                setStormtrooper();
            }
            if (labelPictureBox.getText().equals("Овальные ракеты")) {
                if (plane instanceof Stormtrooper) {
                    Stormtrooper storm = (Stormtrooper) plane;
                    storm.setRockets(new RocketsDop((int) spinnerRocketsCount.getValue()));
                    plane = storm;
                    frame.repaint();
                }
            }
            if (labelPictureBox.getText().equals("Прямоугольные ракеты")) {
                if (plane instanceof Stormtrooper) {
                    Stormtrooper storm = (Stormtrooper) plane;
                    storm.setRockets(new RocketsRect((int) spinnerRocketsCount.getValue()));
                    plane = storm;
                    frame.repaint();
                }
            }
            if (labelPictureBox.getText().equals("Треугольные ракеты")) {
                if (plane instanceof Stormtrooper) {
                    Stormtrooper storm = (Stormtrooper) plane;
                    storm.setRockets(new RocketsTringle((int) spinnerRocketsCount.getValue()));
                    plane = storm;
                    frame.repaint();
                }
            }
            labelPictureBox.setText("");
        };
        labelPictureBox.addPropertyChangeListener("text", propertyChangeListenerTransport);
        labelPictureBox.setBounds(230, 20, 400, 300);
        frame.getContentPane().add(labelPictureBox);

        var listenerForConfig = new DragMouseAdapter();

        labelWarplane.addMouseListener(listenerForConfig);
        labelStormtrooper.addMouseListener(listenerForConfig);
        labelPictureBox.addMouseListener(listenerForConfig);

        labelWarplane.setTransferHandler(new TransferHandler("text"));
        labelStormtrooper.setTransferHandler(new TransferHandler("text"));
        labelPictureBox.setTransferHandler(new TransferHandler("text"));

        frame.repaint();
    }

    private void setWarplane() {
        plane = new Warplane((int) spinnerMaxSpeed.getValue(), (int) spinnerWeight.getValue(), Color.BLACK);
        drawPicture.setTransport(plane);
        drawPicture.getTransport().SetPosition(40, 30, 200, 200);
        frame.repaint();
    }

    private void setStormtrooper() {
        plane =new Stormtrooper((int) spinnerMaxSpeed.getValue(), (int) spinnerWeight.getValue(), Color.BLACK, Color.BLACK, checkBoxTurbo.isSelected(),  checkBoxRockets.isSelected(), (int) spinnerRocketsCount.getValue(), "Овальные");
        drawPicture.setTransport(plane);
        drawPicture.getTransport().SetPosition(40, 30, 200, 200);
        frame.repaint();
    }

    private void cancel() {
        frame.dispose();
    }

    private void addVehicle() {
        if (plane == null) {
            formParking.addPlane(null);
        } else if (plane instanceof Stormtrooper) {
            Stormtrooper storm = (Stormtrooper) plane;
            formParking.addPlane(storm);
        } else {
            Warplane plane = (Warplane) this.plane;
            formParking.addPlane(plane);
        }
        frame.dispose();
    }
}
