import java.awt.*;

public class RocketsTringle implements IRockets {

    private RocketsEnum rocketsEnum;
    public int count;

    public RocketsTringle(int countRockets){
        this.count = countRockets;
        SetEnumRockets(count);
    }
    @Override
    public void SetEnumRockets(int countRockets){
        this.rocketsEnum = RocketsEnum.setEnumNumber(countRockets);
    }

    @Override
    public void DrawRockets(Graphics g, int _startPosX, int _startPosY, Color mainColor, Color dopColor) {

        if (rocketsEnum == RocketsEnum.Two || rocketsEnum == RocketsEnum.Four || rocketsEnum == RocketsEnum.Six)
        {
            g.setColor(dopColor);

            Polygon pol1 = new Polygon();
            pol1.addPoint(_startPosX + 70, _startPosY + 75);
            pol1.addPoint(_startPosX + 105, _startPosY + 63);
            pol1.addPoint(_startPosX + 105, _startPosY + 87);
            g.fillPolygon(pol1);

            Polygon pol2 = new Polygon();
            pol2.addPoint(_startPosX + 70, _startPosY + 155);
            pol2.addPoint(_startPosX + 105, _startPosY + 143);
            pol2.addPoint(_startPosX + 105, _startPosY + 167);
            g.fillPolygon(pol2);
        }
        if (rocketsEnum == RocketsEnum.Four || rocketsEnum == RocketsEnum.Six)
        {
            Polygon pol3 = new Polygon();
            pol3.addPoint(_startPosX + 77, _startPosY + 55);
            pol3.addPoint(_startPosX + 97, _startPosY + 47);
            pol3.addPoint(_startPosX + 97, _startPosY + 63);
            g.fillPolygon(pol3);

            Polygon pol4 = new Polygon();
            pol4.addPoint(_startPosX + 77, _startPosY + 175);
            pol4.addPoint(_startPosX + 97, _startPosY + 167);
            pol4.addPoint(_startPosX + 97, _startPosY + 183);
            g.fillPolygon(pol4);
        }
        if (rocketsEnum == RocketsEnum.Six)
        {
            Polygon pol5 = new Polygon();
            pol5.addPoint(_startPosX + 85, _startPosY + 40);
            pol5.addPoint(_startPosX + 95, _startPosY + 35);
            pol5.addPoint(_startPosX + 95, _startPosY + 45);
            g.fillPolygon(pol5);

            Polygon pol6 = new Polygon();
            pol6.addPoint(_startPosX + 85, _startPosY + 190);
            pol6.addPoint(_startPosX + 95, _startPosY + 185);
            pol6.addPoint(_startPosX + 95, _startPosY + 195);
            g.fillPolygon(pol6);
        }
    }
}

