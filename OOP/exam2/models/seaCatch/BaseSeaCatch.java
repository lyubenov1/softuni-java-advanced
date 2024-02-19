package harpoonDiver.models.seaCatch;
import java.util.*;

public class BaseSeaCatch implements SeaCatch {
    private Collection<String> seaCreatures;
    public BaseSeaCatch() {
        seaCreatures = new ArrayList<>();
    }

    @Override
    public Collection<String> getSeaCreatures() {
        return seaCreatures;
    }
}
