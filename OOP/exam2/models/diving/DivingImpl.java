package harpoonDiver.models.diving;
import harpoonDiver.models.divingSite.*;
import java.util.*;
import harpoonDiver.models.diver.*;

public class DivingImpl implements Diving {
    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {
        Collection<String> divingSiteSeaCreatures = divingSite.getSeaCreatures();
        for (Diver diver : divers) {
            while (diver.canDive() && divingSiteSeaCreatures.iterator().hasNext()) {
                diver.shoot();

                String currentSeaCreature = divingSiteSeaCreatures.iterator().next();
                diver.getSeaCatch().getSeaCreatures().add(currentSeaCreature);
                divingSiteSeaCreatures.remove(currentSeaCreature);
            }
        }
    }
}