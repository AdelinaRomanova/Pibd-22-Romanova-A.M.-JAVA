import java.awt.*;
public abstract class Vehicle implements ITransport
{
    protected int _startPosX;
    protected int _startPosY;
    protected int _pictureWidth;
    protected int _pictureHeight;
    public int MaxSpeed;
    public float Weight;
    public Color MainColor;

    public void setMaxSpeed(int maxSpeed)
    {
        this.MaxSpeed = maxSpeed;
    }
    public int getMaxSpeed()
    {
        return MaxSpeed;
    }

    public void setWeight(float weight)
    {
        this.Weight = weight;
    }
    public float getWeight()
    {
        return Weight;
    }

    public void setMainColor(Color mainColor)
    {
        this.MainColor = mainColor;
    }
    public Color getMainColor()
    {
        return MainColor;
    }

    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    public abstract void DrawTransport(Graphics g);
    public abstract void MoveTransport(Direction direction);
}
