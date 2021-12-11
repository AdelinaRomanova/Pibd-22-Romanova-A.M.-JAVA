import java.awt.*;

public class Stormtrooper {
    private int _startPosX;
    private int _startPosY;
    private int _pictureWidth;
    private int _pictureHeight;
    private final int planeWidth = 250;
    private final int planeHeight = 230;

    public int MaxSpeed;
    public int GetMaxSpeed()
    {
        return MaxSpeed;
    }
    public void SetMaxSpeed(int maxSpeed)
    {
        this.MaxSpeed = maxSpeed;
    }

    public int Weight;
    public int GetWeight()
    {
        return Weight;
    }
    private void SetWeight(int weight)
    {
        this.Weight = weight;
    }

    public Color MainColor;
    public Color GetMainColor()
    {
        return MainColor;
    }
    public void SetMainColor(Color mainColor)
    {
        this.MainColor = mainColor;
    }


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

    private RocketsDop rockets;

    public Stormtrooper(int maxSpeed, int weight, Color mainColor, Color dopColor, boolean turbo, boolean rockets, int countRockets)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        DopColor = dopColor;
        Turbo = turbo;
        Rockets = rockets;
        this.rockets = new RocketsDop(countRockets);
    }

    //Установка позиции автомобиля
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    //Изменение направления пермещения
    public void MoveTransport(Direction direction)
    {
        float step = MaxSpeed* 100 / Weight;
        switch (direction)
        {
            // вправо
            case Right:
                if (_startPosX + step < _pictureWidth - planeWidth)
                {
                    _startPosX += step;
                }
                break;
            //влево
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            //вверх
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
            //вниз
            case Down:
                if (_startPosY + step < _pictureHeight - planeHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }

    //Отрисовка штурмовика
    public void DrawTransport(Graphics g)
    {
        Color col3 = new Color(109, 54, 54);
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
        g.setColor(col2);
        g.fillRect(_startPosX + 30, _startPosY + 100, 190, 30); // корпус
        g.setColor(GetMainColor());
        g.drawRect(_startPosX + 30, _startPosY + 100, 190, 30);

        g.setColor(col1);
        Polygon pol1 = new Polygon();
        pol1.addPoint(_startPosX, _startPosY + 115);
        pol1.addPoint(_startPosX + 30, _startPosY + 130);
        pol1.addPoint(_startPosX + 30, _startPosY + 100);
        g.fillPolygon(pol1);

        Polygon pol2 = new Polygon();
        pol2.addPoint(_startPosX + 90, _startPosY + 100);
        pol2.addPoint(_startPosX + 90, _startPosY);
        pol2.addPoint(_startPosX + 100, _startPosY);
        pol2.addPoint(_startPosX + 120, _startPosY + 100);
        g.setColor(col2);
        g.fillPolygon(pol2);
        g.setColor(GetMainColor());
        g.drawPolygon(pol2);

        Polygon pol3 = new Polygon();
        pol3.addPoint(_startPosX + 90, _startPosY + 130);
        pol3.addPoint(_startPosX + 90, _startPosY + 230);
        pol3.addPoint(_startPosX + 100, _startPosY + 230);
        pol3.addPoint(_startPosX + 120, _startPosY + 130);
        g.setColor(col2);
        g.fillPolygon(pol3);
        g.setColor(GetMainColor());
        g.drawPolygon(pol3);

        Polygon pol4 = new Polygon();
        pol4.addPoint(_startPosX + 180, _startPosY + 100);
        pol4.addPoint(_startPosX + 180, _startPosY + 80);
        pol4.addPoint(_startPosX + 220, _startPosY + 45);
        pol4.addPoint(_startPosX + 220, _startPosY + 100);
        g.setColor(col2);
        g.fillPolygon(pol4);
        g.setColor(GetMainColor());
        g.drawPolygon(pol4);

        Polygon pol5 = new Polygon();
        pol5.addPoint(_startPosX + 180, _startPosY + 130);
        pol5.addPoint(_startPosX + 180, _startPosY + 150);
        pol5.addPoint(_startPosX + 220, _startPosY + 185);
        pol5.addPoint(_startPosX + 220, _startPosY + 130);
        g.setColor(col2);
        g.fillPolygon(pol5);
        g.setColor(GetMainColor());
        g.drawPolygon(pol5);

        if (Rockets) {
            rockets.DrawRocket(g, _startPosX, _startPosY, MainColor, DopColor);
        }
    }
}
