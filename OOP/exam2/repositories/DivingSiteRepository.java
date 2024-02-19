package harpoonDiver.repositories;
import harpoonDiver.models.divingSite.*;
import java.util.*;
public class DivingSiteRepository implements Repository<DivingSite> {
    private final Map<String, DivingSite> sites;

    public DivingSiteRepository() {
        sites = new LinkedHashMap<>();
    }

    @Override
    public Collection<DivingSite> getCollection() {
        return Collections.unmodifiableCollection(sites.values());
    }

    @Override
    public void add(DivingSite entity) {
        sites.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(DivingSite entity) {
        return sites.remove(entity.getName()) != null;
    }

    @Override
    public DivingSite byName(String name) {
        return sites.get(name);
    }
}
