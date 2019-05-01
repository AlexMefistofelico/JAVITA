import java.util.Optional;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.StageStyle;
import javafx.util.Pair;

public class Pago{
	public Dialog<Pair<String, String>> dialog;
	public GridPane grid ;
	public ButtonType boton; 
	public TextField cajaMonto ;
	public String cadResul = "";
	public Pago(){
		
		dialog = new Dialog<>();
		dialog.setTitle("Dialogo Pago");
		dialog.setHeaderText("Pago");
		dialog.initStyle(StageStyle.TRANSPARENT);
		
		boton = new ButtonType("Aceptar", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(boton, ButtonType.CANCEL);

		grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		cajaMonto = new TextField();
		cajaMonto.setPromptText("Monto"); 
		grid.add(new Label("Monto:"),0,0);
		grid.add(cajaMonto, 1, 0);
		
		
	}
	
	public void accion(){
		Node botonA = dialog.getDialogPane().lookupButton(boton);
		botonA.setDisable(true);

		cajaMonto.textProperty().addListener((observable, oldValue, newValue) -> {
		    botonA.setDisable(newValue.trim().isEmpty());
		});

		dialog.getDialogPane().setContent(grid);

		Platform.runLater(() -> cajaMonto.requestFocus());

		dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == boton) {
		        return new Pair<>(cajaMonto.getText(),"");
		    }
		    return null;
		});

		Optional<Pair<String, String>> result = dialog.showAndWait();

		result.ifPresent(cajaMontoPassword -> {
			cadResul += "Monto "+cajaMontoPassword.getKey()+"\n";
		});
		

	}
	public void reporte(String cad){
		Alert alerta1 = new Alert(AlertType.INFORMATION);
		alerta1.setTitle("Dialogo JavaFx");
		alerta1.setHeaderText("Reporte");
		alerta1.setContentText(cad);
		alerta1.initStyle(StageStyle.TRANSPARENT);
		java.awt.Toolkit.getDefaultToolkit().beep();
		alerta1.showAndWait();
	}
}
