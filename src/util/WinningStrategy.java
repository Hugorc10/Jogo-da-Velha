package util;

import controller.SquareController;

import java.util.HashMap;
import java.util.Map;

public class WinningStrategy {
  
  // Variaveis com valores de referencia
  private static final int CIRCLE_WON = 3;
  private static final int CROSS_WON = 30;
  private static final Map<SquareController.State, Integer> values = new HashMap<>();

  static {
    values.put(SquareController.State.EMPTY, 0);
    values.put(SquareController.State.CIRCLE, 1);
    values.put(SquareController.State.CROSS, 10);
  }

  private final Board board;

  public WinningStrategy(Board board) {
    this.board = board;
  }

  public SquareController.State getWinner() {

    for (int i = 0; i < 3; i++) {
        // Pontos internos do jogo
        int score = 0;
        for (int j = 0; j < 3; j++) {
          score += valueOf(i, j);
        }
        if (isWinning(score)) {
          return winner(score);
        }
    }

    for (int i = 0; i < 3; i++) {
      int score = 0;
      for (int j = 0; j < 3; j++) {
        score += valueOf(j, i);
      }
      if (isWinning(score)) {
        return winner(score);
      }
    }

    int score = 0;
    score += valueOf(0, 0);
    score += valueOf(1, 1);
    score += valueOf(2, 2);
    if (isWinning(score)) {
        return winner(score);
    }

    score = 0;
    score += valueOf(2, 0);
    score += valueOf(1, 1);
    score += valueOf(0, 2);
    if (isWinning(score)) {
        return winner(score);
    }

    return SquareController.State.EMPTY;
  }

  /**
   * Define a regra de empate do jogo
   */
  public boolean isDrawn() {

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board.getSquare(i, j).getState() == SquareController.State.EMPTY) {
          return false;
        }
      }
    }

    return getWinner() == SquareController.State.EMPTY;
  }

  private Integer valueOf(int i, int j) {
    return values.get(board.getSquare(i, j).getState());
  }

  /**
   * Verifica se esta ganhando de acordo com o score 
   */
  private boolean isWinning(int score) {
    return score == CIRCLE_WON || score == CROSS_WON;
  }

  /**
   * Verifica quem sera o ganhador de acordo com o score
   */
  private SquareController.State winner(int score) {
    if (score == CIRCLE_WON) return SquareController.State.CIRCLE;
    if (score == CROSS_WON) return SquareController.State.CROSS;

    return SquareController.State.EMPTY;
  }
}
