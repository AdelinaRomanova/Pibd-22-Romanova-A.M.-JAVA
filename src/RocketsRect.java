import java.awt.*;

public class RocketsRect implements IRockets {

    private RocketsEnum rocketsEnum;
    public int count;

    public RocketsRect(int countRockets){
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

            g.fillRect(_startPosX + 75, _startPosY + 165, 27, 15);
            g.fillRect(_startPosX + 75, _startPosY + 50, 27, 15);
            g.setColor(dopColor);
            g.fillRect(_startPosX + 75, _startPosY + 165, 27, 15);
            g.fillRect(_startPosX + 75, _startPosY + 50, 27, 15);
        }
        if (rocketsEnum == RocketsEnum.Four || rocketsEnum == RocketsEnum.Six)
        {
            g.setColor(dopColor);
            g.fillRect(_startPosX + 70, _startPosY + 140, 40, 20);
            g.fillRect(_startPosX + 70, _startPosY + 70, 40, 20);
            g.setColor(dopColor);
            g.fillRect(_startPosX + 70, _startPosY + 140, 40, 20);
            g.fillRect(_startPosX + 70, _startPosY + 70, 40, 20);
        }
        if (rocketsEnum == RocketsEnum.Six)
        {
            g.setColor(dopColor);
            g.fillRect(_startPosX + 85, _startPosY + 190, 15, 10);
            g.fillRect(_startPosX + 80, _startPosY + 30, 15, 10);
            g.setColor(dopColor);
            g.fillRect(_startPosX + 85, _startPosY + 190, 15, 10);
            g.fillRect(_startPosX + 80, _startPosY + 30, 15, 10);
        }
    }
}

