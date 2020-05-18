package domain.user;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Players {
    public static List<Player> createPlayers(String playerNames) {
        List<Player> players = new ArrayList<>();

        players.add(new Dealer());

        String[] names = playerNames.split(",");
        for (String name : names) {
            players.add(new Player(name, InputView.inputBettingMoney(name)));
        }

        return players;
    }
}
