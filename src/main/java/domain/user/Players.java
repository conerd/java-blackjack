package domain.user;

import domain.BettingMoneyCalculator;
import domain.card.Card;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private static final int INDEX_FROM_PLAYER = 1;
    private static final int INDEX_DEALER = 0;
    private List<Player> players = new ArrayList<>();
    private BettingMoneyCalculator bettingMoneyCalculator;

    public Players(String playerNames) {
        createPlayers(playerNames);
    }

    private void createPlayers(String playerNames) {
        Player dealer = new Dealer();
        players.add(dealer);

        String[] names = playerNames.split(",");
        for (String name : names) {
            players.add(new Player(name, InputView.inputBettingMoney(name)));
        }
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public void distributeCardToPlayer(int player, Card poll) {
        players.get(player).addCard(poll);
    }

    public String getPlayerName(int player) {
        return players.get(player).getName();
    }

    public List<String> getPlayerNames() {
        List<String> playerNames = new ArrayList<>();

        for (int i = INDEX_FROM_PLAYER; i < players.size(); i++) {
            playerNames.add(players.get(i).getName());
        }

        return playerNames;
    }

    public String getPlayerCards(int player) {
        return players.get(player).getCardsNames();
    }

    public boolean isNeedAdditionalCard(int player) {
        return players.get(player).isNeedAdditionalCard();
    }

    public int getScore(int player) {
        return players.get(player).getScore();
    }

    public void calculateBettingMoney() {
        bettingMoneyCalculator = new BettingMoneyCalculator(players.get(INDEX_DEALER).getScore());
        for (int i = INDEX_FROM_PLAYER; i < players.size(); i++) {
            bettingMoneyCalculator.calculateBettingMoney(players.get(i).getScore(), players.get(i).getBettingMoney());
        }
        bettingMoneyCalculator.calculateDealerMoney();
    }

    public String getResult(int player) {
        return players.get(player).getName() + ": " + bettingMoneyCalculator.getBettingMoney(player);
    }
}
