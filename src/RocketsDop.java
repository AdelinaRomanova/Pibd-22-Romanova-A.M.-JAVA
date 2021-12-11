import java.awt.*;

public class RocketsDop {

    private static RocketsEnum rocketsEnum;
    public int count;

    public RocketsDop(int countRockets) {
        this.count = countRockets;
        SetEnumRockets(count);
    }

    public void SetEnumRockets(int countRockets) {
        this.rocketsEnum = rocketsEnum.setEnumNumber(countRockets);
    }

    public static void DrawRocket(Graphics g, int _startPosX, int _startPosY, Color mainColor, Color dopColor) {
        if (rocketsEnum == RocketsEnum.Two || rocketsEnum == RocketsEnum.Four || rocketsEnum == RocketsEnum.Six)
        {
            g.setColor(dopColor);

            g.fillOval(_startPosX + 75, _startPosY + 165, 27, 15);
            g.fillOval(_startPosX + 75, _startPosY + 50, 27, 15);
            g.setColor(mainColor);
            g.drawOval(_startPosX + 75, _startPosY + 165, 27, 15);
            g.drawOval(_startPosX + 75, _startPosY + 50, 27, 15);
        }
        if (rocketsEnum == RocketsEnum.Four || rocketsEnum == RocketsEnum.Six)
        {
            g.setColor(dopColor);
            g.fillOval(_startPosX + 70, _startPosY + 140, 40, 20);
            g.fillOval(_startPosX + 70, _startPosY + 70, 40, 20);
            g.setColor(mainColor);
            g.drawOval(_startPosX + 70, _startPosY + 140, 40, 20);
            g.drawOval(_startPosX + 70, _startPosY + 70, 40, 20);
        }
        if (rocketsEnum == RocketsEnum.Six)
        {
            g.setColor(dopColor);
            g.fillOval(_startPosX + 85, _startPosY + 190, 15, 10);
            g.fillOval(_startPosX + 80, _startPosY + 30, 15, 10);
            g.setColor(mainColor);
            g.drawOval(_startPosX + 85, _startPosY + 190, 15, 10);
            g.drawOval(_startPosX + 80, _startPosY + 30, 15, 10);
        }
    }
}