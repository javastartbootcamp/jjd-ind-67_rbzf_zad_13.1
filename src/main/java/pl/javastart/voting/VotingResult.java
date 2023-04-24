package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {
    List<Vote> votingResult = new ArrayList<>();

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */

    public void printResults() {
        // metoda powinna drukować wyniki głosowania
        System.out.printf("%s%.2f%s \n", "Głosów za: ", calculateVotesByTypePercentage(votingResult, true), "%");
        System.out.printf("%s%.2f%s \n", "Głosów przeciw: ", calculateVotesByTypePercentage(votingResult, false), "%");
        System.out.printf("%s%.2f%s \n", "Wstrzymało się: ", calculateVotesByTypePercentage(votingResult, null), "%");
    }

    private double calculateVotesByTypePercentage(List<Vote> votingResult, Boolean voteType) {
        int sum = 0;
        for (Vote vote : votingResult) {

            if (vote.getVote() == voteType) {
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
        Vote vote = votingResult.get(index);
        System.out.println(voterName + ": " + vote.getVoteAsString());
    }

    private int getIndex(String voterName) {
        for (int i = 0; i < votingResult.size(); i++) {
            if (votingResult.get(i).getVoter().equals(voterName)) {
                return i;
            }
        }
        return -1;
    }
}