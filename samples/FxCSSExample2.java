import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class FxCSSExample2 extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		// Create the Labels
		Label label = new Label("This is a simple Stylesheet Example");
		Label message = new Label();

		// Create The Button
		Button button = new Button("OK");

		// Add an EventHandler to the OK-Button
		button.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				message.setText("You have pressed the OK Button");
			}
		});

		// Create the VBox
		VBox root = new VBox();
		// Set the vertical spacing between children to 20px
		root.setSpacing(20);
		// Set the padding of the VBox
		root.setPadding(new Insets(10, 10, 10, 10));
		// Add the Labels and the Button to the VBox
		root.getChildren().addAll(label,button,message);
		// Create the Scene
		Scene scene = new Scene(root,350,200);
		// Add the StyleSheet to the Scene
		scene.getStylesheets().add(getClass().getResource("fxcssexample2.css").toExternalForm());
		// Add the scene to the Stage
		stage.setScene(scene);
		// Set the title of the Stage
		stage.setTitle("A simple StyleSheet Example");
		// Display the Stage
		stage.show();
	}

}
