package pl.javastart.voting;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Voting {

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");
        //voters.add("Jacek Placek");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Zigniew Siobro");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {

        List<Vote> resultList = new ArrayList<>();
        VotingResult votingResult = new VotingResult(resultList);
        for (String voter : voters) {
            String input = "";
            while (!(input.equals("z") || input.equals("p") || input.equals("w"))) {
                System.out.println("Jak głosuje " + voter + "? (z - za, p - przeciw, w - wstrzymanie się)");
                input = scanner.nextLine();
            }
            Vote voteCasted = new Vote(voter, generateVote(input));
            resultList.add(voteCasted);
        }
        return votingResult; // to możesz (a nawet powinieneś/powinnaś) zmienić :)
    }

    private String generateVote(String input) {
        return switch (input) {
            case "z" -> "ZA";
            case "p" -> "PRZECIW";
            case "w" -> "WSTRZYMAŁ SIĘ";
            default -> "glos nieprawidłowy";
        };
    }
}