package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SceneController {
	private Stage window;
	private Scene myScene;
	Stage pop = new Stage();
	MenuBar menuBar;

	public SceneController(Stage theStage) {
		window = theStage;
		MenuBarMaker mbh = new MenuBarMaker();
		menuBar = mbh.getMenuBar();
		
		
		// ---------------------------------- CREATE MENUBAR MENUS ---------------------------------------------
		
	}

	public Scene getHomeScene() {
		BorderPane bp = new BorderPane();
		bp.setTop(menuBar);
		myScene = new Scene(bp, window.getHeight(), window.getWidth());
		return myScene;
	}

}
