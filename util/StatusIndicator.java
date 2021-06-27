package util;

import controller.SquareController;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import view.SquareView;

public class StatusIndicator extends HBox {

  private final ImageView playerToken = new ImageView();
  private final Label playerLabel = new Label("Current player: ");

  public StatusIndicator(Game game) {

    setPadding(new Insets(16));
    setAlignment(Pos.CENTER);

    bindIndicatorFieldsToGame(game);

    playerToken.setFitHeight(35);
    playerToken.setPreserveRatio(true);

    playerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    playerLabel.setTextFill(Color.WHITE);

    getChildren().addAll(playerLabel, playerToken);
  }

  private void bindIndicatorFieldsToGame(Game game) {
    // Define o bind para o playerToker
    playerToken.imageProperty().bind(
          Bindings.when(
                  game.currentPlayerProperty().isEqualTo(SquareController.State.CIRCLE)
          )
                  .then(SquareView.circleImage)
                  .otherwise(
                          Bindings.when(
                                  game.currentPlayerProperty().isEqualTo(SquareController.State.CROSS)
                          )
                                  .then(SquareView.crossImage)
                                  .otherwise((Image) null)
                  )
    );

    // Define o bind para o playerLabel
    playerLabel.textProperty().bind(
          Bindings.when(
                  game.gameOverProperty().not()
          )
                  .then("Current Player: ")
                  .otherwise(
                          Bindings.when(
                                  game.winnerProperty().isEqualTo(SquareController.State.EMPTY)
                          )
                                  .then("Draw")
                                  .otherwise("Winning Player: ")
                  )
    );
  }
}


