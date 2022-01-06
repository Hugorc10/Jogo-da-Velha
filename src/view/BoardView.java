package view;

import javafx.scene.layout.GridPane;
import util.Board;

public class BoardView extends GridPane {

    /**
     * Adiciona um fundo em forma de matriz 3x3 ao leiaute GridPane
     * @param board
     */
    public BoardView(Board board) {
        // Define um estilo e espacamento horizontal e vertical ao GridPane
        setStyle("-fx-background-color: slategrey");
        setHgap(5);
        setVgap(5);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                add(board.getSquare(i, j).getSquareView(), i, j);
            }
        }
    }
}
