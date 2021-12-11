import java.awt.*;
import java.lang.reflect.Array;

public class Hangar<T extends ITransport, R extends IRockets> {
    private T[] _places;
    private int pictureWidth;
    private int pictureHeight;
    private int _placeSizeWidth = 280;
    private int _placeSizeHeight = 240;

    public Hangar(int picWidth, int picHeight)
    {
        int width = picWidth / _placeSizeWidth;
        int height = picHeight / _placeSizeHeight;
        _places = (T[]) Array.newInstance(ITransport.class, width*height);
        pictureWidth = picWidth;
        pictureHeight = picHeight;
    } // конструктор

    public int OperationAdd(T plane)
    {
        for (int i = 0; i < _places.length; i++)
        {
            if (_places[i] == null)
            {
                _places[i] = plane;
                return i;
            }
        }
        return -1;
    } // Перегрузка оператора сложения

    public  T OperationDel(int index)
    {
        if (index >= 0 && index < _places.length)
        {
            if (_places[index] != null)
            {
                T plane = _places[index];
                _places[index] = null;
                return plane;
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    } // Перегрузка оператора вычитания

    public boolean OperationDop1(Hangar<T, R> hangar1, Hangar<T, R> hangar2) {
        int k1 = 0;
        int k2 = 0;
        for (int i = 0; i < hangar1._places.length; i++) {
            if (hangar1._places[i] != null) {
                k1++;
            }
        }
        for (int i = 0; i < hangar2._places.length; i++) {
            if (hangar2._places[i] != null) {
                k2++;
            }
        }
        if (k1 >= k2) {
            return true;
        }
        return false;
    }

    public boolean OperationDop2(Hangar<T, R> hangar1, Hangar<T, R> hangar2) {
        int k1 = 0;
        int k2 = 0;
        for (int i = 0; i < hangar1._places.length; i++) {
            if (hangar1._places[i] != null) {
                k1++;
            }
        }
        for (int i = 0; i < hangar2._places.length; i++) {
            if (hangar2._places[i] != null) {
                k2++;
            }
        }
        if (k1 <= k2) {
            return true;
        }
        return false; }

    public void Draw(Graphics g)
    {
        DrawMarking(g);

        for (int i = 0; i < _places.length; ++i)
        {
            if (_places[i] != null) {
                _places[i].SetPosition(8 + i % 4 * _placeSizeWidth, i / 4 * _placeSizeHeight + 5, pictureWidth, pictureHeight);
                _places[i].DrawTransport(g);
            }
        }
    } // Метод отрисовки парковки

    private void DrawMarking(Graphics g)
    {
        g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        for (int i = 0; i < pictureWidth / _placeSizeWidth; i++)
        {
            for (int j = 0; j < pictureHeight / _placeSizeHeight + 1; ++j)
            {
                g2.drawLine(i * _placeSizeWidth, j * _placeSizeHeight, i * _placeSizeWidth + _placeSizeWidth / 3, j * _placeSizeHeight);
            }//линия разметки места
            g2.drawLine(i * _placeSizeWidth, 0, i * _placeSizeWidth, (pictureHeight / _placeSizeHeight) * _placeSizeHeight);
        }
    } // Метод отрисовки разметки парковочных мест
}
