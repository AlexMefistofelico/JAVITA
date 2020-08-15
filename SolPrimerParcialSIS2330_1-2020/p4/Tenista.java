import java.util.Scanner;
public class Tenista extends Deportista {	//CLASE Hija O SUB CLASE
//clase publica Futbolista herada de Deportista	
	public String pais;			//campo
    
    public Tenista() {	//CONSTRUCTOR
    	super();		//llamanos al constructor de la SUPER CLASE
		pais = null;	//valores por defecto    
    }
   	
   	@Override 				//opcional denotamos sobre escritura del metodo
   	public void leer(){
   		Scanner in = new Scanner(System.in);//objeto entrada (creacion)
   		
   		super.leer();						//llamanos a funcion de clase padre
   		
   		System.out.println ("Lectura Datos Tenista: ");		
   		System.out.print ("pais: ");
   		pais = in.nextLine();			//leer
   	}
   	
   	@Override 				//opcional denotamos sobre escritura del metodo
   	public void imprimir(){	//mostrar datos
   		super.imprimir();	//llamanos a funcion de clase padre
   		System.out.println ("\t"+pais);
   	}
}