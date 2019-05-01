import java.util.Optional;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Pair;

public class Targeta extends Pago{
	public TextField Targeta;
	public Targeta(){
		super();
		dialog.setHeaderText("Dialogo Targeta");
		
		Targeta = new TextField();
		Targeta.setPromptText("Targeta"); 
		grid.add(new Label("Targeta:"), 0, 1);
		grid.add(Targeta, 1, 1);
		
	}
	
	@Override
	public void accion(){
		
		Node botonA = dialog.getDialogPane().lookupButton(boton);
		botonA.setDisable(true);
		
		Targeta.textProperty().addListener((observable, oldValue, newValue) -> {
		    botonA.setDisable(newValue.trim().isEmpty());
		});

		dialog.getDialogPane().setContent(grid);

		Platform.runLater(() -> Targeta.requestFocus());

		dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == boton) {
		        return new Pair<>(cajaMonto.getText(),Targeta.getText());
		    }
		    return null;
		});

		Optional<Pair<String, String>> result = dialog.showAndWait();

		result.ifPresent(cajaTargeta -> {
			cadResul += "Monto "+cajaTargeta.getKey()+"\nTargeta "+cajaTargeta.getValue()+"\n";
		});
		

	}
}
