import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class PlayerInfos {
    private int totalSpaces = 100;
    private int currentSpaces = 100;
    private int spaces;
    private int countRound = 1;
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    ArrayList<String> PlayerName = new ArrayList<>();
    HashMap<String, Integer> PlayerNameScore = new HashMap<>();


    PlayerInfos(){
        System.out.print("How many players: ");
        int playerNum = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= playerNum; i++) {
            System.out.print("What is your name: ");
            String name = sc.nextLine();
            PlayerName.add(name);

            CardColorNumber first = new CardColorNumber();
            spaces = first.getSpace();
            currentSpaces -= spaces;
            PlayerNameScore.put(name, currentSpaces);
        }
        System.out.println(PlayerNameScore);
    }

    public boolean updateSpaces(){
        countRound++;
        for (int i = 0; i < PlayerName.size(); i++) {
            String Player = PlayerName.get(i);
            currentSpaces = PlayerNameScore.get(Player);

            if (countRound%5==0){
                int challenge = rand.nextInt(5);
                System.out.printf("Challenge for %s: ", Player);
                if (challenge==sc.nextInt()) {
                    currentSpaces -= 5;
                    PlayerNameScore.replace(Player, currentSpaces);
                    System.out.println("success");
                } else {
                    System.out.println("fail");
                }
                System.out.println(PlayerNameScore);
            }

            CardColorNumber update = new CardColorNumber();
            spaces = update.getSpace();
            currentSpaces -= spaces;
            PlayerNameScore.replace(Player, currentSpaces);
            if (currentSpaces <= 0) {
                System.out.println(PlayerNameScore);
                System.out.printf("%s wins", Player);
                return true;
            }
        }
        return false;
    }

    public HashMap getPlayerNameScore(){
        return PlayerNameScore;
    }
}
