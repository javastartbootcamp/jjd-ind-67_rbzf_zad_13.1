package pl.javastart.voting;

import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {
    List<Vote> votingResult;

    public VotingResult(List<Vote> votingResult) {
        this.votingResult = votingResult;
    }

    public List<Vote> getVotingResult() {
        return votingResult;
    }

    public void setVotingResult(List<Vote> votingResult) {
        this.votingResult = votingResult;
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */

    public void printResults() {
        // metoda powinna drukować wyniki głosowania
        System.out.printf("%s %.2f%s \n", "Głosów za: ", calculateInFavourVotesPercentage(votingResult), "%");
        System.out.printf("%s %.2f%s \n", "Głosów przeciw: ", calculateAgainstVotesPercentage(votingResult), "%");
        System.out.printf("%s %.2f%s \n", "Wstrzymało się: ", calculateRestrainVotesPercentage(votingResult), "%");
    }

    private double calculateRestrainVotesPercentage(List<Vote> votingResult) {
        int sum = 0;
        double result;
        for (Vote vote : votingResult) {
            if (vote.getVote().equals("WSTRZYMAŁ SIĘ")) {
                sum++;
            }
        }
        return ((double) sum / votingResult.size()) * 100;
    }

    private double calculateAgainstVotesPercentage(List<Vote> votingResult) {
        int sum = 0;
        for (Vote vote : votingResult) {
            if (vote.getVote().equals("PRZECIW")) {
                sum++;
            }
        }
        return ((double) sum / votingResult.size()) * 100;
    }

    private double calculateInFavourVotesPercentage(List<Vote> votingResult) {
        int sum = 0;
        for (Vote vote : votingResult) {
            if (vote.getVote().equals("ZA")) {
                sum++;
            }
        }
        return ((double) sum / votingResult.size()) * 100;
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        int index = getIndex(voterName);
        System.out.println(voterName + ": " + votingResult.get(index).getVote());
    }

    private int getIndex(String voterName) {
        int index = -1;
        for (int i = 0; i < votingResult.size(); i++) {
            if (votingResult.get(i).getVoter().equals(voterName)) {
                index = i;
            }
        }
        return index;
    }
}