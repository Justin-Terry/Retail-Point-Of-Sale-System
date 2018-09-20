package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneController {
	Stage window;
	Scene myScene;
	MenuBar menuBar = new MenuBar();
	Menu clockMenu = new Menu("Clock In/Out");
	
	
	public SceneController(Stage s) {
		window = s;
		menuBar.getMenus().add(clockMenu);
		clockMenu.getItems().addAll(new MenuItem("Clock In"), new MenuItem("Clock Out"));
		
		clockMenu.getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent act) {
				Stage pop = new Stage();
				Scene popScene = new Scene(new VBox(), 300, 200);
				pop.setTitle("Clock In");
				pop.setScene(popScene);
				pop.show();
				
			}
		});
		
		clockMenu.getItems().get(1).setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent act) {
				Stage pop = new Stage();
				Scene popScene = new Scene(new VBox(), 300, 200);
				pop.setTitle("Clock Out");
				pop.setScene(popScene);
				pop.show();
				
			}
		});
	}
	
	public Scene getHomeScene() {
		BorderPane bp = new BorderPane();
		bp.setTop(menuBar);
		myScene = new Scene(bp, window.getHeight(), window.getWidth());
		return myScene;
	}
	
	
	
	
}
