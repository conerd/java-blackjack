import domain.card.Card;
import domain.card.CardFactory;
import domain.user.Player;
import domain.user.Players;
import view.InputView;

import java.util.*;

public class BlackJackGame {
    private static final int FIRST_DISTRIBUTION_COUNT = 2;
    private static Queue<Card> cards = new LinkedList<>();
    private static List<Player> players = new ArrayList<>();

    public BlackJackGame() {
        initCards();
    }

    private void initCards() {
        List<Card> initialCards = CardFactory.create();
        Collections.shuffle(initialCards);

        for (Card card : initialCards) {
            cards.offer(card);
        }
    }

    public void run() {
        players = Players.createPlayers(InputView.inputPlayerNames());
        splitCards();

    }

    private void splitCards() {
        for (Player player : players) {
            splitCardsTwice(player);
        }
    }

    private void splitCardsTwice(Player player) {
        for (int i = 0; i < FIRST_DISTRIBUTION_COUNT; i++) {
            player.addCard(cards.poll());
        }
    }
}
