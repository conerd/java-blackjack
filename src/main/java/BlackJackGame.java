import domain.user.Players;
import view.InputView;

public class BlackJackGame {

    public BlackJackGame() {

    }

    public void run() {
        Players players = new Players(InputView.inputPlayerNames());
    }
}
