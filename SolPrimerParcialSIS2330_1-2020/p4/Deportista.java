import java.util.Scanner;
public class Deportista {	//CLASE PADRE O SUPER CLASE
	public int codigo;	//campo
	public String nombre;	//campo
	public String fecha_nac;//campo
    
    public Deportista() {	//CONSTRUCTOR
    	codigo = 1;
    	nombre = "primerNombre";
    	fecha_nac = "01/01/2000";
    }
   	
    public void leer(){
            Scanner in = new Scanner(System.in);
            System.out.println ("Lectura Datos Deportista: ");
            System.out.print ("Codigo: ");
            codigo = in.nextInt();		//leer entero
            System.out.print ("Nombre: ");
            in.nextLine();			//limpiando buffer de entrada -> "\n"
            nombre = in.nextLine();		//leer string con espacios(posibles)
            System.out.print ("Fecha_Nac: ");
            fecha_nac = in.next();		//leer string
    }
    public void imprimir(){		        //mostrar datos
            System.out.print (codigo+"\t"+nombre+"\t"+fecha_nac);
    }
}