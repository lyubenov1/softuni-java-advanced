package harpoonDiver.repositories;
import java.util.*;
import harpoonDiver.models.diver.*;

public class DiverRepository implements Repository<Diver> {
    private final Map<String, Diver> divers;
    public DiverRepository() {
        divers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Diver> getCollection() {
        return Collections.unmodifiableCollection(divers.values());
    }

    @Override
    public void add(Diver entity) {
        divers.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Diver entity) {
        return divers.remove(entity.getName()) != null;
    }

    @Override
    public Diver byName(String name) {
        return divers.get(name);
    }
}
