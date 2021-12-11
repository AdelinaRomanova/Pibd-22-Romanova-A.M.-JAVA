import java.awt.*;

public class Stormtrooper extends Warplane {

    public Color DopColor;
    public Color GetDopColor()
    {
        return DopColor;
    }
    public void SetDopColor(Color dopColor)
    {
        this.DopColor = dopColor;
    }

    public boolean Turbo;
    public boolean GetTurbo()
    {
        return Turbo;
    }
    public void SetTurbo(boolean turbo)
    {
        this.Turbo = turbo;
    }

    public boolean Rockets;
    public boolean getRockets() { return Rockets; }
    public void setRockets(boolean Rockets) { Rockets = Rockets; }

    private IRockets TypeRockets;

    public Stormtrooper(int maxSpeed, int weight, Color mainColor, Color dopColor, boolean turbo, boolean rockets, int countRockets, String typeRockets)
    {
        super(maxSpeed, weight, mainColor, 230, 220);
        DopColor = dopColor;
        Turbo = turbo;
        Rockets = rockets;
        switch (typeRockets) {
            case "Овальные":
                TypeRockets = new RocketsDop(countRockets);
                break;
            case "Прямоугольные":
                TypeRockets = new RocketsRect(countRockets);
                break;
            case "Треугольные":
                TypeRockets = new RocketsTringle(countRockets);
                break;
        }
    }

    //Отрисовка штурмовика
    public void DrawTransport(Graphics g)
    {
        Color col2 = new Color(127, 127, 127);
        Color col1 = new Color(0,0,0);
        Color col5 = new Color(240, 96, 0);
        Color col4 = new Color(239, 52, 62);
        if (GetTurbo())
        {
            Polygon pol6 = new Polygon();
            pol6.addPoint(_startPosX + 220, _startPosY + 100);
            pol6.addPoint(_startPosX + 250, _startPosY +92);
            pol6.addPoint(_startPosX + 220, _startPosY + 130);
            g.setColor(GetDopColor());
            g.drawPolygon(pol6);
            g.setColor(col5);
            g.fillPolygon(pol6);

            Polygon pol7 = new Polygon();
            pol7.addPoint(_startPosX + 220, _startPosY + 130);
            pol7.addPoint(_startPosX + 250, _startPosY + 138);
            pol7.addPoint(_startPosX + 220, _startPosY + 100);
            g.setColor(GetDopColor());
            g.drawPolygon(pol7);
            g.setColor(col5);
            g.fillPolygon(pol7);

            Polygon pol8 = new Polygon();
            pol8.addPoint(_startPosX + 220, _startPosY + 100);
            pol8.addPoint(_startPosX + 270, _startPosY + 115);
            pol8.addPoint(_startPosX + 220, _startPosY + 130);
            g.setColor(GetDopColor());
            g.drawPolygon(pol8);
            g.setColor(col4);
            g.fillPolygon(pol8);
        }

        super.DrawTransport(g);
        if (Rockets){
            TypeRockets.DrawRockets(g, _startPosX, _startPosY, MainColor, DopColor);
        }
    }
}
