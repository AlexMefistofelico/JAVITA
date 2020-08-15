import java.util.Scanner;
public class Basquetbolista extends Deportista {	//CLASE Hija O SUB CLASE
//clase publica Futbolista herada de Deportista	
	public double estatura;	//campo
    
    public Basquetbolista() {	//CONSTRUCTOR
    	super();		//llamanos al constructor de la SUPER CLASE
		estatura = 0;	//valores por defecto    
    }
   	
    @Override 		                        //opcional denotamos sobre escritura del metodo
    public void leer(){
            Scanner in = new Scanner(System.in);//objeto entrada (creacion)
            
            super.leer();			//llamanos a funcion de clase padre
            
            System.out.println ("Lectura Datos Basquetbolista: ");		
            System.out.print ("Estatura: ");
            estatura = in.nextDouble();	        //leer
    }
    
    @Override 		        //opcional denotamos sobre escritura del metodo
    public void imprimir(){	//mostrar datos
            super.imprimir();	//llamanos a funcion de clase padre
            System.out.println ("\t"+estatura);
    }
}