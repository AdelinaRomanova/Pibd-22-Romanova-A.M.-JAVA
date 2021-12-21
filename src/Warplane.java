import java.awt.*;

public class Warplane extends Vehicle {
    protected int planeWidth = 230;
    protected int planeHeight = 220;

    public Warplane(int maxSpeed, float weight, Color mainColor)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
    }

    protected Warplane(int maxSpeed, float weight, Color mainColor, int planeWidth, int planeHeight)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        this.planeWidth = planeWidth;
        this.planeHeight = planeHeight;
    }

    @Override
    public void MoveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
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
                if (_startPosX + step > 0)
                {
                    _startPosX -= step;
                }
                break;
            //вверх
            case Up:
                if (_startPosY + step > 0)
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

    @Override
    public void DrawTransport(Graphics g) {
        Color col2 = new Color(127, 127, 127);
        Color col1 = new Color(0, 0, 0);
        g.setColor(col2);
        g.fillRect(_startPosX + 30, _startPosY + 100, 190, 30); // корпус
        g.setColor(MainColor);
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
        g.setColor(MainColor);
        g.drawPolygon(pol2);

        Polygon pol3 = new Polygon();
        pol3.addPoint(_startPosX + 90, _startPosY + 130);
        pol3.addPoint(_startPosX + 90, _startPosY + 230);
        pol3.addPoint(_startPosX + 100, _startPosY + 230);
        pol3.addPoint(_startPosX + 120, _startPosY + 130);
        g.setColor(col2);
        g.fillPolygon(pol3);
        g.setColor(MainColor);
        g.drawPolygon(pol3);

        Polygon pol4 = new Polygon();
        pol4.addPoint(_startPosX + 180, _startPosY + 100);
        pol4.addPoint(_startPosX + 180, _startPosY + 80);
        pol4.addPoint(_startPosX + 220, _startPosY + 45);
        pol4.addPoint(_startPosX + 220, _startPosY + 100);
        g.setColor(col2);
        g.fillPolygon(pol4);
        g.setColor(MainColor);
        g.drawPolygon(pol4);

        Polygon pol5 = new Polygon();
        pol5.addPoint(_startPosX + 180, _startPosY + 130);
        pol5.addPoint(_startPosX + 180, _startPosY + 150);
        pol5.addPoint(_startPosX + 220, _startPosY + 185);
        pol5.addPoint(_startPosX + 220, _startPosY + 130);
        g.setColor(col2);
        g.fillPolygon(pol5);
        g.setColor(MainColor);
        g.drawPolygon(pol5);
    }
    @Override
    public void setNewMainColor(Color MainColor){
        this.MainColor = MainColor;
    }
}
