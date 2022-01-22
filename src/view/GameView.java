package view;

import controller.GameControls;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import util.Game;
import util.GameManager;
import util.StatusIndicator;

public class GameView extends VBox {

    /**
     * Construtor que inicializa a parte visual de todo o jogo
     *
     * @param gameManager Objeto que contem a acao de new game (novo jogo) e quit (sair)
     * @param game
     */
    public GameView(GameManager gameManager, Game game) {
        // Define um estilo espacamento de borda ao VBox
        setStyle("-fx-background-color: midnightblue;");
        setPadding(new Insets(30));
        getChildren().addAll(
                game.getBoard().getBoardView(),
                new StatusIndicator(game),
                new GameControls(gameManager, game)
        );
    }
}
