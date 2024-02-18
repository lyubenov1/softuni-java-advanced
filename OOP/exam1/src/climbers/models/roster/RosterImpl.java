package climbers.models.roster;
import java.util.*;

public class RosterImpl implements Roster {
    private Collection<String> peaks;

    public RosterImpl() {
        this.peaks = new ArrayList<>();
    }

    @Override
    public Collection<String> getPeaks() {
        return peaks;
    }
}
