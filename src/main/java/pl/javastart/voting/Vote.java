package pl.javastart.voting;

// klasa pomocnicza, możesz ją dowolnie zmieniać, albo usunąć
public class Vote {

    private String voter;
    private Boolean vote; // ZA, PRZECIW, wstrzymanie się

    public Vote(String voter, Boolean vote) {
        this.voter = voter;
        this.vote = vote;
    }

    public String getVoter() {
        return voter;
    }

    public Boolean getVote() {
        return vote;
    }

    public String getVoteAsString() {
        if (vote == null) {
            return "WSTRZYMAŁ SIĘ";
        } else if (vote) {
            return "ZA";
        } else {
            return "PRZECIW";
        }
    }
}
