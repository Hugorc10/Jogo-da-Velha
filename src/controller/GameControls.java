package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.GameManager;
import util.Game;

public class GameControls extends HBox {

  /**
   * Seta os controles de renicio da partida
   * <p>
   * @param gameManager
   * @param game
   */
  public GameControls(final GameManager gameManager, final Game game) {
    // Seta um espacamento e aliamento ao painel
    setSpacing(10);
    setAlignment(Pos.CENTER);

    // Define que a propriedade tera seu valor modificado em relacao ao metodo 'gameOverProperty'
    visibleProperty().bind(game.gameOverProperty());

    Label playAgainLbl = new Label("Play Again?");
    playAgainLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
    playAgainLbl.setStyle("-fx-text-fill: whitesmoke;");

    // Cria o botao com a resposta 'Yes'
    Button playAgainBtn = new Button("Yes");
    playAgainBtn.setDefaultButton(true);
    playAgainBtn.setFont(Font.font("Comic Sans MS",  FontWeight.MEDIUM, 20));
    playAgainBtn.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
          // Renicia o jogo
          gameManager.newGame();
        }
    });

    // Cria o botao com a resposta 'No'
    Button exitBtn = new Button("No");
    exitBtn.setCancelButton(true);
    exitBtn.setFont(Font.font("Comic Sans MS", FontWeight.MEDIUM, 20));
    exitBtn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        // Sai do jogo
        gameManager.quit();
      }
    });

    // Adiciona os componentes ao painel
    getChildren().setAll(playAgainLbl, playAgainBtn, exitBtn);
  }
}
