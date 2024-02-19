package handball.entities.gameplay;
import handball.entities.team.*;
import handball.entities.equipment.*;
import java.util.*;
import handball.common.*;
import java.util.stream.*;

public abstract class BaseGameplay implements Gameplay {
    private String name;
    private int capacity;
    Collection<Equipment> equipments;
    Collection<Team> teams;

    public BaseGameplay(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        equipments = new ArrayList<>();
        teams = new ArrayList<>();
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int allProtection() {
        return getEquipments().stream().mapToInt(Equipment::getProtection).sum();
    }

    @Override
    public void addTeam(Team team) {
        teams.add(team);
    }

    @Override
    public void removeTeam(Team team) {
        teams.remove(team);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
        teams.forEach(Team::play);
    }

    @Override
    public Collection<Team> getTeam() {
        return teams;
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return equipments;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return String.format("%s %s\nTeam: %s\nEquipment: %d, Protection: %d\n",
                this.name, this.getClass().getSimpleName(),
                this.teams.stream().map(Team::getName).collect(Collectors.joining(" ")),
                this.equipments.size(), allProtection());
    }
}
