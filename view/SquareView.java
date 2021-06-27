package view;

import controller.SquareController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class SquareView extends StackPane {
    // Cria o objeto para guardar o caminho da imagem em formato de "X"
    public static Image crossImage = new Image(
            SquareView.class.getResourceAsStream("/img/blue-cross-icon.png")
    );

    // Cria o objeto para guardar o caminho da imagem em formato de "O"
    public static Image circleImage = new Image(
            SquareView.class.getResourceAsStream("/img/green-cd-icon.png")
    );

    // Cria um ImageView para guardar os objetos Image
    private final ImageView imageView = new ImageView();

    /**
     * Define os parametros de visualizacao e acao dos quadrados
     *
     * @param square
     */
    public SquareView(final SquareController square) {
        // Seta o estilo e o espacamento de borda do StackPane
        setStyle("-fx-background-color: azure");
        setPadding(new Insets(10));

        imageView.setMouseTransparent(true);

        // Adiciona a imagem ao StackPane
        getChildren().setAll(imageView);
        setPrefSize(crossImage.getHeight() + 20, crossImage.getHeight() + 20);

        // Seta a acao do mouse ao clicar
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                square.pressed();
            }
        });

        // Adiciona um Listener aos quadrados
        square.stateProperty().addListener(new ChangeListener<SquareController.State>() {
            @Override
            public void changed(ObservableValue<? extends SquareController.State> observableValue, SquareController.State oldState, SquareController.State state) {
                switch (state) {
                    case EMPTY:
                        // Caso seja vazio seta a imagem como nulo
                        imageView.setImage(null);
                        break;
                    case CIRCLE:
                        // Caso seja circulo, seja o circleImage
                        imageView.setImage(circleImage);
                        break;
                    case CROSS:
                        // Caso seja X, seja o crossImage
                        imageView.setImage(crossImage);
                        break;
                }
            }
        });
    }
}
