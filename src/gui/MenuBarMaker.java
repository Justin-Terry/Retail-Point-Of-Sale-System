package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuBarMaker {
	private MenuBar menuBar;
	private Menu clockMenu = new Menu("Clock In/Out");
	private Menu fileMenu = new Menu("File");
	private Menu productsMenu = new Menu("Products");
	private Menu employeesMenu = new Menu("Employees");
	private Menu transactionsMenu = new Menu("Transactions");
	private Parent sceneParent;
	private Stage pop = new Stage();
	private Scene popScene;

	public MenuBarMaker() {
		menuBar = new MenuBar();
		try {
			// Load FXML file for clockInOutPopUp
			sceneParent = FXMLLoader.load(this.getClass().getResource("clockInOutPopUp.fxml"));
			// Create the scene for the clockInOutPopUps
			popScene = new Scene(sceneParent, 300, 150);
			// Load the CSS for clockInOutPopUps
			popScene.getStylesheets().add(getClass().getResource("gui.css").toExternalForm());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Add menus and menu items
		menuBar.getMenus().addAll(fileMenu, productsMenu, transactionsMenu, employeesMenu, clockMenu);
		clockMenu.getItems().addAll(new MenuItem("Clock In"), new MenuItem("Clock Out"));
		fileMenu.getItems().add(new MenuItem("Exit"));
		
		fileMenu.getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent act) {
				Alert exitConfirmation = new Alert(AlertType.CONFIRMATION, "Are you sure you want to exit?", ButtonType.YES, ButtonType.CANCEL);
				exitConfirmation.setHeaderText("Exit");
				exitConfirmation.showAndWait();
				
				if(exitConfirmation.getResult() == ButtonType.YES) {
					System.out.println("Here");
					System.exit(0);
				}
				
				
			}
		});			
		
		// Clock In menu item eventhandler
		clockMenu.getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent act) {
				pop = new Stage();
				Label headerLabel = (Label) popScene.lookup("#popHeader");
				headerLabel.setText("Clock In");
				pop.setTitle("Clock In");
				pop.setScene(popScene);
				pop.initModality(Modality.APPLICATION_MODAL); // Prevents other windows being used until this window is
																// closed
				pop.show();
			}
		});
		// Clock out menut item eventhandler
		clockMenu.getItems().get(1).setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent act) {
				pop = new Stage();
				Label headerLabel = (Label) popScene.lookup("#popHeader");
				headerLabel.setText("Clock Out");
				pop.setTitle("Clock Out");
				pop.setScene(popScene);
				pop.initModality(Modality.APPLICATION_MODAL); // Prevents other windows being used until this window is
																// closed
				pop.show();

			}
		});
	}
	
	public MenuBar getMenuBar() {
		return menuBar;
	}

}
