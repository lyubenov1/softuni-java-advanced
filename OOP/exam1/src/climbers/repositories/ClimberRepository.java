package climbers.repositories;

import climbers.models.climber.Climber;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
public class ClimberRepository implements Repository<Climber> {
    private final Map<String, Climber> climbers;

    public ClimberRepository() {
        this.climbers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Climber> getCollection() {
        return Collections.unmodifiableCollection(climbers.values());
    }

    @Override
    public void add(Climber entity) {
        climbers.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Climber entity) {
        return climbers.remove(entity.getName()) != null;
    }

    @Override
    public Climber byName(String name) {
        return climbers.get(name);
    }
}
