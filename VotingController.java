import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VotingController {
    private List<Voting> votings;
    
    public VotingController() {
        this.votings = new ArrayList<>();
    }
    
    public Voting createVoting(String title, LocalDate endDate, CEC cec) {
        Voting voting = new Voting(title, endDate);
        votings.add(voting);
        return voting;
    }
    
    public List<Voting> getActiveVotings() {
        LocalDate today = LocalDate.now();
        return votings.stream()
            .filter(v -> v.getEndDate().isAfter(today))
            .toList();
    }
}
