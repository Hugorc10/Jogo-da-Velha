package controller;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.Node;
import util.Game;
import view.SquareView;

public class SquareController {

  // Atribui as variaveis 'chave' do jogo da velha a um enum
  public enum State { EMPTY, CIRCLE, CROSS }

  // Objeto que ira guardar a parte visual do quadrado
  private final SquareView squareView;

  private ReadOnlyObjectWrapper<State> state = new ReadOnlyObjectWrapper<>(State.EMPTY);

  public ReadOnlyObjectProperty<State> stateProperty() {
    return state.getReadOnlyProperty();
  }

  // Getter do stage
  public State getState() {
    return state.get();
  }

  private final Game game;

  /**
   * Construtor
   *
   * @param game O objeto game que ira pertencer a acoes dos quadrados
   */
  public SquareController(Game game) {
    this.game = game;

    squareView = new SquareView(this);
  }

  /**
   * Define a logica ao click em um quadrado (square)
   */
  public void pressed() {
    if (!game.isGameOver() && state.get() == State.EMPTY) {
      state.set(game.getCurrentPlayer());
      game.boardUpdated();
      game.nextTurn();
    }
  }

  // Getter do squareView
  public Node getSquareView() {
    return squareView;
  }
}
