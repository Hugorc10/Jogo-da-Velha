package util;

import controller.SquareController;
import javafx.scene.Node;
import view.BoardView;

public class Board {

  // Parte de visual do fundo
  private final BoardView boardView;
  // Matriz 3x3 dos quadrados
  private final SquareController[][] squares = new SquareController[3][3];

  /**
   * Cria um fundo (board) 3x3 com quadrados
   *
   * @param game
   */
  public Board(Game game) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        squares[i][j] = new SquareController(game);
      }
    }

    boardView = new BoardView(this);
  }

  /**
   * Define um getter para uma posicao especifica na matriz
   * <p>
   * @param i Linhas da matriz
   * @param j Colunas da matriz
   */
  public SquareController getSquare(int i, int j) {
    return squares[i][j];
  }

  /**
   * Define um getter a variavel boardView
   */
  public Node getBoardView() {
    return boardView;
  }
}
