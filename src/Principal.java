import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**ALEX ARIEL CHOQUE CLEMENTE*/
/** Jhoselin te amo mi amor*/
public class Principal extends Application{
	
	public void start(Stage arg){
	
		try{
			Pago obj = null;
		
		
			List<String> opciones = new ArrayList<String>();
			opciones.add("Efectivo");
			opciones.add("Targeta");
			opciones.add("Cheque");
	
			ChoiceDialog<String> dialog = new ChoiceDialog("Opcion", opciones);
			dialog.initStyle(StageStyle.TRANSPARENT);
			dialog.setHeaderText("Pago");
			dialog.setContentText("Elija su Modo pago:");
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()){
				switch (result.get()) {
					//pricipio de sustitucion ES UN
	    			case "Efectivo":obj = new Efectivo();/*Efectivo es un tipo de Pago*/ break;
	    			case "Targeta":obj = new Targeta();/*Targeta es un tipo de Pago*/ break;
	    			case "Cheque":obj = new Cheque();/*Cheque es un tipo de Pago*/ break;
	    			default : obj = new Pago();
				}
			}
			obj.accion();
			obj.reporte(obj.cadResul);
			
		}catch(Exception e){
			System.exit(1);
		}
	
	}
}
