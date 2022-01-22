package util;

import javafx.scene.Scene;

public class GameManager {

  // Defines variables do the Scene e Game
  private Scene gameScene;
  private Game game;

  /**
   * Construtor inicializando o metodo newGame
   */
  public GameManager() {
    newGame();
  }

  /**
   * Cria um novo jogo e seta a cena atravez do 'getGameView'
   */
  public void newGame() {

    game = new Game(this);

    // Se for nulo cria uma nova cena, se não apenas seta o root dela
    if (gameScene == null) {
      gameScene = new Scene(game.getGameView());
    } else {
      gameScene.setRoot(game.getGameView());
    }
  }

  /**
   * Cria a logica para a "saida" do jogo
   */
  public void quit() {
    gameScene.getWindow().hide();
  }

  /**
   * Define um getter a variavel game
   */
  public Game getGame() {
    return game;
  }

  /**
   * Define um getter a variavel gameScene
   */
  public Scene getGameScene() {
    return gameScene;
  }
}
