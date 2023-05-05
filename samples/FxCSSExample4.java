import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FxCSSExample4 extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		// Create the Labels
		Label label = new Label("This is a simple Inherit Example");
		Label message = new Label();

		// Set the Style of the Label
		message.setStyle("-fx-font-family: \"arial\";-fx-font-size: 16px;-fx-font-style: italic;");

		// Create The Buttons
		Button ok = new Button("OK");
		Button cancel = new Button("Cancel");

		// Set the Style of the Button
		ok.setStyle
		(
				"-fx-border-color: red;"
				+ "-fx-border-width: inherit;"
		);

		// Add an EventHandler to the OK-Button
		ok.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				message.setText("You have pressed the OK Button");
			}
		});

		// Add an EventHandler to the OK-Button
		cancel.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				message.setText("You have pressed the Cancel Button");
			}
		});

		// Create the HBox
		HBox hbox = new HBox();
		// Set the vertical spacing between children to 20px
		hbox.setSpacing(20);
		// Add the Buttons to the HBox
		hbox.getChildren().addAll(ok,cancel);

		// Create the VBox
		VBox root = new VBox();
		// Set the vertical spacing between children to 20px
		root.setSpacing(20);
		// Set the padding of the VBox
		root.setPadding(new Insets(10, 10, 10, 10));
		// Add the Labels and the HBox to the VBox
		root.getChildren().addAll(label,hbox,message);
		// Create the Scene
		Scene scene = new Scene(root,400,200);

		// Set the Style for the Root Element
		root.setStyle
		(
				"-fx-cursor: hand;"
				+ "-fx-border-color: blue;"
				+ "-fx-border-width: 5px;"
		);

		// Add the StyleSheet to the Scene
		scene.getStylesheets().add(getClass().getResource("fxcssexample4.css").toExternalForm());
		// Add the scene to the Stage
		stage.setScene(scene);
		// Set the title of the Stage
		stage.setTitle("An Inheritance Example");
		// Display the Stage
		stage.show();
	}

}
