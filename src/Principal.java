/**
 * Created by Hugo Teixeira Mafra <hugorc10@hotmail.com> on 09/07/2018. Last modification on 11/07/2018.
 * <br>
 * Enrollment number: 201611540
 * <br>
 * TicTacToe it is a software that simulates a Tic-tac-toe game (also know as Jogo da Velha in portuguese).
 * <br>
 * MIT License
 * <br>
 * Copyright (c) 2018 Hugo Mafra
 * <br>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <br>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <br>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
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

