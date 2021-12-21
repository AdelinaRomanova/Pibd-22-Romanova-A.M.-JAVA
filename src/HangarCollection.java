import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HangarCollection {
    private  Map<String, Hangar<Vehicle, IRockets>> hangarStages;
    private  int pictureWidth;
    private  int pictureHeight;

    public HangarCollection(int pictureWidth, int pictureHeight)
    {
        hangarStages = new HashMap<>();
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
    } //Конструктор

    public Set<String> keySet() {
        return hangarStages.keySet();
    }

    public void AddParking(String name)
    {
        if (!hangarStages.containsKey(name)){
            hangarStages.put(name, new Hangar<>(pictureWidth, pictureHeight));
        }
    } // Добавление парковки

    public void DelParking(String name)
    {
        if (hangarStages.containsKey(name))
        {
            hangarStages.remove(name);
        }
    } // Удаление парковки

    public Hangar<Vehicle, IRockets> get(String ind)
    {
        if (hangarStages.containsKey(ind))
        {
            return hangarStages.get(ind);
        }
        return null;
    } // Доступ к парковке

    public Vehicle getVehicle(String name, int planeIndex) {
        if (hangarStages.containsKey(name)) {
            return hangarStages.get(name).getVehicle(planeIndex);
        }
        return null;
    }


}
