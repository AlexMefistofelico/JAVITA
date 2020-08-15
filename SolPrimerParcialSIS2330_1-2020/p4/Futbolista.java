import java.util.Scanner;
public class Futbolista extends Deportista {	//CLASE Hija O SUB CLASE
//clase publica Futbolista herada de Deportista	
	public double peso;		//campo
	public double salario;	//campo
    
    public Futbolista() {	//CONSTRUCTOR
    	super();		//llamanos al constructo de la SUPER CLASE
		peso = 0;	//valores por defecto    
		salario = 0;	//valores por defecto    
    }
   	
    @Override 		                        //opcional denotamos sobre escritura del metodo
    public void leer(){
            Scanner in = new Scanner(System.in);//objeto entrada (creacion)
            
            super.leer();			//llamanos a funcion de clase padre
            
            System.out.println ("Lectura Datos Futbolista: ");		
            System.out.print ("Peso: ");
            peso = in.nextDouble();	//leer
            System.out.print ("Salario: ");
            salario = in.nextDouble();	//leer
    }
    
    @Override 			//opcional denotamos sobre escritura del metodo
    public void imprimir(){	//mostrar datos
            super.imprimir();   //llamanos a funcion de clase padre
            System.out.println ("\t"+peso+"\t"+salario);
    }
}