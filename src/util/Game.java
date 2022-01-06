package util;

import controller.SquareController;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.Parent;
import view.GameView;

public class Game {

  // Parte visual da aplicacao
  private final GameView gameView;
  // Fundo da aplicacao
  private final Board board = new Board(this);
  // Define o objeto que contem a estrategia de ganho do jogo e atribui um fundo a ele
  private final WinningStrategy winningStrategy = new WinningStrategy(board);

  private final ReadOnlyObjectWrapper<SquareController.State> currentPlayer = new ReadOnlyObjectWrapper<>(SquareController.State.CROSS);
  private final ReadOnlyObjectWrapper<SquareController.State> winner = new ReadOnlyObjectWrapper<>(SquareController.State.EMPTY);
  private final ReadOnlyBooleanWrapper drawn = new ReadOnlyBooleanWrapper(false);
  private final ReadOnlyBooleanWrapper gameOver = new ReadOnlyBooleanWrapper(false);

  /**
   * Construtor que inicializa um novo gameView e seta um gameManager
   * <p>
   * @param gameManager GameManager que ira ser atribuido ao GameView
   */
  public Game(GameManager gameManager) {
    gameOver.bind(
          winnerProperty().isNotEqualTo(SquareController.State.EMPTY)
                  .or(drawnProperty())
    );

    gameView = new GameView(gameManager, this);
  }

  public ReadOnlyObjectProperty<SquareController.State> currentPlayerProperty() {
    return currentPlayer.getReadOnlyProperty();
  }

  public SquareController.State getCurrentPlayer() {
    return currentPlayer.get();
  }

  public ReadOnlyObjectProperty<SquareController.State> winnerProperty() {
    return winner.getReadOnlyProperty();
  }

  public ReadOnlyBooleanProperty drawnProperty() {
    return drawn.getReadOnlyProperty();
  }

  /**
   * Retorna o getter do draw (empate)
   */
  public boolean isDrawn() {
    return drawn.get();
  }

  public ReadOnlyBooleanProperty gameOverProperty() {
    return gameOver.getReadOnlyProperty();
  }

  /**
   * Retorna o getter da variavel gameOver
   */
  public boolean isGameOver() {
    return gameOver.get();
  }

  /**
   * Retorna o getter da variavel board
   */
  public Board getBoard() {
    return board;
  }

  /**
   * Define a logica da proxima rodada do jogo
   */
  public void nextTurn() {
    if (isGameOver()) return;

    switch (currentPlayer.get()) {
      case EMPTY:
      case CIRCLE:
        currentPlayer.set(SquareController.State.CROSS);
        break;
      case CROSS:
        currentPlayer.set(SquareController.State.CIRCLE);
        break;
    }
  }

  /**
   * Verifica quem eh o vencedor do jogo e tambem o empate
   */
  private void checkForWinner() {
    winner.set(winningStrategy.getWinner());
    drawn.set(winningStrategy.isDrawn());

    if (isDrawn()) {
      currentPlayer.set(SquareController.State.EMPTY);
    }
  }

  /**
   * Atualiza o fundo de acordo com o vencendor
   */
  public void boardUpdated() {
    checkForWinner();
  }

  /**
   * Retorna o no pai da aplicacao que no caso eh o gameView
   */
  public Parent getGameView() {
    return gameView;
  }
}
