package domain.user;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Players {
    List<Player> players = new ArrayList<>();

    public Players(String playerNames) {
        createPlayers(playerNames);
        createDealer();
    }

    private void createPlayers(String playerNames) {
        String[] names = playerNames.split(",");

        for (int i = 0; i < names.length; i++) {
            players.add(new Player(names[i], InputView.inputBettingMoney(names[i])));
        }
    }

    private void createDealer() {
        players.add(new Dealer());
    }


}
