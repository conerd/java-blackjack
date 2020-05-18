package domain.user;

import java.util.ArrayList;
import java.util.List;

public class Players {
    List<Player> players = new ArrayList<>();

    public Players(String playerNames) {
        createPlayers(playerNames);
    }

    private void createPlayers(String playerNames) {
        String[] names = playerNames.split(",");
    }

}
