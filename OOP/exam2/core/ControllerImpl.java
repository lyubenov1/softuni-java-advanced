package harpoonDiver.core;
import harpoonDiver.common.ConstantMessages;
import harpoonDiver.common.ExceptionMessages;
import harpoonDiver.models.diver.DeepWaterDiver;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.diver.OpenWaterDiver;
import harpoonDiver.models.diver.WreckDiver;
import harpoonDiver.models.diving.Diving;
import harpoonDiver.models.diving.DivingImpl;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;
import harpoonDiver.repositories.DiverRepository;
import harpoonDiver.repositories.DivingSiteRepository;
import harpoonDiver.repositories.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

public class ControllerImpl implements Controller{
    private Repository<Diver> diverRepository;
    private Repository<DivingSite> divingSiteRepository;
    private int siteCount;
    public ControllerImpl() {
        diverRepository = new DiverRepository();
        divingSiteRepository = new DivingSiteRepository();
    }

    @Override
    public String addDiver(String kind, String diverName) {
        Diver diver;
        switch (kind) {
            case "DeepWaterDiver":
                diver = new DeepWaterDiver(diverName);
                break;
            case "OpenWaterDiver":
                diver = new OpenWaterDiver(diverName);
                break;
            case "WreckDiver":
                diver = new WreckDiver(diverName);
                break;
            default: throw new IllegalArgumentException(ExceptionMessages.DIVER_INVALID_KIND);
        }
        diverRepository.add(diver);
        return String.format(ConstantMessages.DIVER_ADDED, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);
        divingSite.getSeaCreatures().addAll(Arrays.asList(seaCreatures));
        divingSiteRepository.add(divingSite);
        return String.format(ConstantMessages.DIVING_SITE_ADDED, siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = diverRepository.byName(diverName);
        if (diver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DIVER_DOES_NOT_EXIST, diverName));
        }
        diverRepository.remove(diver);
        return String.format(ConstantMessages.DIVER_REMOVE, diverName);
    }

    @Override
    public String startDiving(String siteName) {
        List<Diver> suitableDivers = diverRepository.getCollection()
                .stream().filter(d -> d.getOxygen() > 30).collect(Collectors.toList());
        if (suitableDivers.isEmpty()) {
            throw new IllegalArgumentException(harpoonDiver.common.ExceptionMessages.SITE_DIVERS_DOES_NOT_EXISTS);
        }
        DivingSite site = divingSiteRepository.byName(siteName);
        Diving diving = new DivingImpl();
        diving.searching(site, suitableDivers);
        siteCount++;
        long removed = suitableDivers.stream().filter(d -> d.getOxygen() == 0).count();
        return String.format(ConstantMessages.SITE_DIVING, siteName, removed);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(harpoonDiver.common.ConstantMessages.FINAL_DIVING_SITES, siteCount));
        sb.append(System.lineSeparator());
        sb.append(String.format(ConstantMessages.FINAL_DIVERS_STATISTICS));

        Collection<Diver> divers = diverRepository.getCollection();
        for (Diver diver : divers) {
            sb.append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.FINAL_DIVER_NAME, diver.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.FINAL_DIVER_OXYGEN, diver.getOxygen()));
            sb.append(System.lineSeparator());
            if (diver.getSeaCatch().getSeaCreatures().isEmpty()) {
                sb.append(String.format(ConstantMessages.FINAL_DIVER_CATCH, "None"));
            } else {
                sb.append(String.format(ConstantMessages.FINAL_DIVER_CATCH,
                        String.join(ConstantMessages.FINAL_DIVER_CATCH_DELIMITER,
                                diver.getSeaCatch().getSeaCreatures())));
            }

        }
        return sb.toString();
    }
}
