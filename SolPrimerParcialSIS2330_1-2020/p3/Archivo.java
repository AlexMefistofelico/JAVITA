//VER CLASE "Registro.java" POR SER DE INTERES

import java.io.*;		//clases de manipulación flujo entrada salida
import java.util.Scanner.*;	//entrada por consola scanner

public class Archivo {				
	public String nombreArch;	//nombre arch
	public RandomAccessFile arch;	//archivo como tal
	
    public Archivo(String n) {		//constructor
		nombreArch = n;		//asignamos nombre
    }
    
    public void abrir(String modo)throws IOException{//firma funcion para apertura dada un "modo"+lanzar posible Error IOException
    	arch = new RandomAccessFile(nombreArch,modo);//usando el contructor
    }
    
    public void cerrar()throws IOException{	//opcional
    	arch.close();				//metodo para cerrar flujo de archivo
    }
    
    public void agregar(Registro reg)throws IOException{//firma funcion para agregar a "arch" lo que se manda como argumento
    	abrir("rw");					//<importante> abrir para "lectura escritura"
    	arch.seek(arch.length());			//desplazamos puntero a final de archivo
    	reg.grabar(arch);				//grabamos en final de archivo
    	cerrar();					//<importante> cerrar flujo de archivo
    }
   	
    public void reportar()throws IOException{
    	Registro reg = new Registro();			//registro auxiliar para lectura 
    	abrir("r");					//<importante> abrir para "lectura"
    	System.out.println (":: COD\tNOMBRE\t\tNOTA");
    	while(arch.getFilePointer()<arch.length()){	//mientras no lleguemos al final del archivo
    		reg.leer(arch);				//leer de archivo
    		if(reg.estado)				//si su estada es valido
    			System.out.println (reg);	//mostramos (llamada implicita toString (sobre escrita en Registro.java))
    	}
    	cerrar();					//<importante> cerrar flujo de archivo
    }
    
}