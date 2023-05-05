package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;


public class MyClass extends Application {

    //private final static Logger LOGGER = SMLogger.getLogger();
    private static Stage primaryStage;
    Image win = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Main/Assets/xml.png")));

    @Override
    public void start(Stage primaryStage) throws Exception {
        //LOGGER.info("Приложение запущено успешно 0");
        MyClass.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/Main/Views/mainForm.fxml"));
        primaryStage.setTitle(" СЗГУ РЦТиКК проект \"Редактор данных АС ЭКР\"    dpShell v.0.0");
        primaryStage.getIcons().add(win);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 1350, 900));
        primaryStage.show();
        // LOGGER.info("Приложение запущено успешно 1");
        // LOGGER.log(Level.WARNING, "Не найдено поле loginField" );
        // LOGGER.info(new PrintScreenSupplier());
    }

    public static Stage getStage() {
        return primaryStage;
    }


}
