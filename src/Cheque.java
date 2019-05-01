import java.util.Optional;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Pair;

class Cheque extends Pago{
	public TextField cajaCheque;
	public Cheque(){
		super();
		dialog.setHeaderText("Dialogo Cheque");
		
		cajaCheque = new TextField();
		cajaCheque.setPromptText("Cheque"); 
		grid.add(new Label("Cheque:"), 0, 1);
		grid.add(cajaCheque, 1, 1);
		
	}
	
	@Override
	public void accion(){
		
		Node botonA = dialog.getDialogPane().lookupButton(boton);
		botonA.setDisable(true);
		
		cajaCheque.textProperty().addListener((observable, oldValue, newValue) -> {
		    botonA.setDisable(newValue.trim().isEmpty());
		});

		dialog.getDialogPane().setContent(grid);

		Platform.runLater(() -> cajaCheque.requestFocus());

		dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == boton) {
		        return new Pair<>(cajaMonto.getText(),cajaCheque.getText());
		    }
		    return null;
		});

		Optional<Pair<String, String>> result = dialog.showAndWait();

		result.ifPresent(cajacajaCheque -> {
			cadResul += "Monto "+cajacajaCheque.getKey()+"\nCheque "+cajacajaCheque.getValue()+"\n";
		});
		

	}
}
