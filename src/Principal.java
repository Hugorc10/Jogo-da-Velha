/*
 * Created by Hugo Teixeira Mafra <hugorc10@hotmail.com> on 09/07/2018. Last modification on 11/07/2018.
 * <p>
 * Enrollment number: 201611540
 * <p>
 * TicTacToe it is a software that simulates a Tic-tac-toe game (also know as Jogo da Velha in portuguese).
 * <p>
 * TicTacToe is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * TicTacToe is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with TicTacToe.  If not, see <http://www.gnu.org/licenses/>.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import util.GameManager;

public class Principal extends Application {

  public static void main(String[] args) {
    Application.launch(Principal.class);
  }

  /**
   * Inicia a aplicacao construindo e definindo uma cena
   * <p>
   * @param myStage Palco da aplicacao
   * @throws Exception Excecao de erro de execucao
   */
  @Override
  public void start(Stage myStage) {
    GameManager gameManager = new GameManager();
    Scene scene = gameManager.getGameScene();

    // Icone da aplicacao
    Image iconImage = new Image(Principal.class.getResourceAsStream("/img/tic-tac-toe-icon.png"));

    // Titulo da aplicacao
    myStage.setTitle("Tic-Tac-Toe (Jogo da Velha)");
    myStage.getIcons().add(iconImage);
    myStage.setScene(scene);
    myStage.setResizable(false);
    myStage.show();
  }
}

