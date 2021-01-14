package charHelper;
/*
 * Spanish Character Clipboard Helper
 * August 27, 2020
 * Steve Cina
 */

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class CharHelper extends Application {
	final static String[] sChars = {"Á","É","Í","Ó","Ú","Ñ","Ü",
			"á","é","í","ó","ú","ñ","ü","¿","¡","º","ª","«","»","€"};
	
	public static void main(String[] args) {
		launch();
	}
	
	private void copyToClipboard(String s) {
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection(s);
		clip.setContents(stringSelection, null);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button[] charButtons = new Button[sChars.length];
		for (int i = 0; i < sChars.length; i++) {
			final int k = i; //this looks like shit, but it works.
			charButtons[i] = new Button();
			charButtons[i].setText(sChars[i]);
			charButtons[i].setOnMouseClicked(e -> copyToClipboard(charButtons[k].getText()));
		}
		
		FlowPane pane = new FlowPane();
		
		pane.setPrefWidth(482);
		pane.getChildren().addAll(charButtons);
		
		//primaryStage.initStyle(StageStyle.TRANSPARENT); //Looks cool, but loses the close button.
		primaryStage.setResizable(false);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.setTitle("Spanish Character Clipboard Helper");
		primaryStage.setScene(new Scene(pane));
		primaryStage.show();
	}
}