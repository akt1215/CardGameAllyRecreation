public class Main {
    public static void main(String[] args) {
        PlayerInfos playerInfos = new PlayerInfos();
        while (!playerInfos.updateSpaces()) {
            System.out.println(playerInfos.getPlayerNameScore());
        }
    }

}