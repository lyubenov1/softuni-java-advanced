package harpoonDiver.models.divingSite;
import java.util.*;
import harpoonDiver.common.*;

public class DivingSiteImpl implements DivingSite {
    private String name;
    private Collection<String> seaCreatures;
    public DivingSiteImpl(String name) {
        setName(name);
        seaCreatures = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null) {
            throw new NullPointerException(ExceptionMessages.SITE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getSeaCreatures() {
        return seaCreatures;
    }

    @Override
    public String getName() {
        return name;
    }
}
