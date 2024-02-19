package handball.core;
import handball.repositories.*;
import java.util.*;
import handball.entities.gameplay.*;
import handball.common.*;
import handball.entities.equipment.*;
import handball.entities.team.*;

import static handball.common.ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY;

public class ControllerImpl implements Controller {
    Repository repository;
    Map<String, Gameplay> gameplays;

    public ControllerImpl() {
        repository = new EquipmentRepository();
        gameplays = new LinkedHashMap<>();
    }
    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        switch (gameplayType) {
            case "Outdoor":
                Gameplay currentGameplay = new Outdoor(gameplayName);
                gameplays.put(gameplayName, currentGameplay);
                break;
            case "Indoor":
                currentGameplay = new Indoor(gameplayName);
                gameplays.put(gameplayName, currentGameplay);
                break;
            default: throw new NullPointerException(ExceptionMessages.INVALID_GAMEPLAY_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment equipment;
        switch (equipmentType) {
            case "Kneepad":
                equipment = new Kneepad();
                break;
                case "ElbowPad":
                    equipment = new ElbowPad();
                    break;
            default: throw new IllegalArgumentException(ExceptionMessages.INVALID_EQUIPMENT_TYPE);
        }
        repository.add(equipment);
        return String.format(handball.common.ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Gameplay gameplay = gameplays.get(gameplayName);
        if (gameplayName == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_EQUIPMENT_FOUND, equipmentType));
        }
        Equipment byType = repository.findByType(equipmentType);
        gameplay.addEquipment(byType);
        repository.remove(byType);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Gameplay gameplay;
        Team currentTeam;
        switch (teamType) {
            case "Bulgaria":
                currentTeam = new Bulgaria(teamName, country, advantage);
                gameplay = gameplays.get(gameplayName);
                break;
            case "Germany":
                currentTeam = new Germany(teamName, country, advantage);
                gameplay = gameplays.get(gameplayName);
                break;
            default: throw new IllegalArgumentException(ExceptionMessages.INVALID_TEAM_TYPE);
        }
        if (!canPlay(teamType, gameplay)) {
            return String.format(ConstantMessages.GAMEPLAY_NOT_SUITABLE);
        } else {
            gameplays.get(gameplayName).addTeam(currentTeam);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
        }
    }

    private boolean canPlay(String teamType, Gameplay gameplay) {
        if (teamType.equals("Bulgaria") && gameplay.getClass().getSimpleName().equals("Outdoor")) {
            return true;
        }

        if (teamType.equals("Germany") && gameplay.getClass().getSimpleName().equals("Indoor")) {
            return true;
        }

        return false;
    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = gameplays.get(gameplayName);
        gameplay.teamsInGameplay();
        return String.format(ConstantMessages.TEAMS_PLAYED, gameplay.getTeam().size());
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        Gameplay gameplay = gameplays.get(gameplayName);
        int advantage = gameplay.getTeam().stream().mapToInt(Team::getAdvantage).sum();
        return String.format(ConstantMessages.ADVANTAGE_GAMEPLAY, gameplay.getName(), advantage);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        this.gameplays.values().forEach(output::append);
        return output.toString().trim();
    }
}
