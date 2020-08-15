//IMPLEMENTADO DE UNA MANERA (detallada)LARGA PARA MEJOR COMPRENSIóN DE ANALISIS Y FUTURA REUTILIZACION DE CODIGO.
//VER CLASE "Archivo.java" POR SER DE INTERES (archivos NECESARIOS)
//VER CLASE "Registro.java" POR SER DE INTERES(archivos NECESARIOS)

import java.io.*;		//clases de manipulación flujo entrada salida
import java.util.Scanner.*;	//entrada por consola scanner

public class Pregunta3{	
//	3.	A partir de un archivo de datos ‘datos.dat’, con los campos código,
//	nombre, nota, estado, generar dos archivos auxiliares ‘prom.dat’ y ‘curso.dat’
//	que contienen registros cuya nota es mayor al promedio de nota y la información ordenada alfabéticamente por el nombre en forma ascendente respectivamente.
	
    public Registro[] llevarAVector(Archivo tmp)throws IOException{
    	Registro reg = new Registro();		                //registro auxiliar para lectura 
    	tmp.abrir("r");						//<importante> abrir para "lectura"
    	
    	Registro vec[] = new Registro[(int)(tmp.arch.length()/reg.getTamReg())];//creando vector(justo) de registros 
    	int i=0;								//indice para vector									
    	while(tmp.arch.getFilePointer()<tmp.arch.length()){	                //mientras no lleguemos al final del archivo
    		reg.leer(tmp.arch);						//leer de archivo
   			vec[i++] = new Registro(reg);				//copiar valor(reg) en vec[i] 
    	}
    	tmp.cerrar();								//<importante> cerrar flujo de archivo
    	return vec;								//retornamos el vector con las datos del archivo
    }

    public double promedio(Archivo tmp)throws IOException{
    	Registro reg = new Registro();				//registro auxiliar para lectura 
    	tmp.abrir("r");						//<importante> abrir para "lectura"
    	
    	int i=0,nreg = (int)tmp.arch.length()/reg.getTamReg();	//indice para vector, numero de registros									
    	double total = 0;					//acumulador
    	
    	while(tmp.arch.getFilePointer()<tmp.arch.length()){	//mientras no lleguemos al final del archivo
    		reg.leer(tmp.arch);	                        //leer de archivo
   			total+=reg.nota;	                //sumando notas 
    	}
    	tmp.cerrar();
                                                                //<importante> cerrar flujo de archivo
    	return total/nreg;		                        //retornamos promedio
//    	retorna (nota total)/(# de registros)
    }
    
    public Archivo llevarAArchivo(Registro[] vec,Archivo tmp)throws IOException{
    	Registro reg = new Registro();		//registro auxiliar para lectura 
    	tmp.abrir("rw");			//<importante> abrir para "lectura escritura"			
    	for(int i=0;i<vec.length;i++)		//recorremos todo el vector
    		vec[i].grabar(tmp.arch);	//grabar en archivo vec[i] que es un Registro
    	return tmp;				//retornamos el vector con las datos del archivo
    }
	
	public Archivo llevarAArchivo(Registro[] vec,Archivo tmp,double prom)throws IOException{//firma para llevar los mayores a promedio
    	Registro reg = new Registro();	        //registro auxiliar para lectura 
    	tmp.abrir("rw");			//<importante> abrir para "lectura escritura"			
    	for(int i=0;i<vec.length;i++){	        //recorremos todo el vector
    		if(vec[i].nota<=prom)		//si no cumple condicion 
    			vec[i].estado = false;	//cambiamos estado para no reportar (estado->false)
    		vec[i].grabar(tmp.arch);	//grabar en archivo vec[i] que es un Registro
    	}
    	return tmp;				//retornamos el vector con las datos del archivo
    }
	
	public void ordenar(Registro vec[]){	        		                //ordenar vector de registros
		Registro tmp;								//temporal
		for (int i = 0; i<vec.length-1; i++)	        	                //recorremos 0..n-1
			for (int j = i+1; j<vec.length; j++)	                        //recorremos 1..n
				if(vec[i].nombre.compareToIgnoreCase(vec[j].nombre)>0){ //comparamos strings(detallado en Cadenas.java)
					tmp = vec[i];					//asignacion
					vec[i] = vec[j];				//asignacion
					vec[j] = tmp;					//asignacion
				}
	}
	
	public static void main (String[] args)throws IOException{
		
		Archivo archDatos = new Archivo("datos.dat");	//creamos 1er Archivo	
		Archivo archPromedio = new Archivo("prom.dat");	//creamos 2do Archivo
		Archivo archCurso = new Archivo("curso.dat");	//creamos 3er Archivo
		
		Pregunta3 obj = new Pregunta3();		//objeto para utizar metodos y campos de nuestra clase
		double promedio = obj.promedio(archDatos);	//hallamos promedio de las notas en general 

/*
 		LLENAR DATOS POR TECLADO(COMO PRACTICA PERSONAL) YO LO HAGO ASI POR FACTOR TIEMPO
    	archDatos.agregar(new Registro(1,"Juan Jose",55));
    	archDatos.agregar(new Registro(2,"Zuleyka Riv.",15));
    	archDatos.agregar(new Registro(3,"Fredy Iver",33));
    	archDatos.agregar(new Registro(4,"Maria Jose",55));
    	archDatos.agregar(new Registro(5,"Maria Jesus",45));
    	archDatos.agregar(new Registro(6,"Faviola Iris",55));
    	archDatos.agregar(new Registro(7,"Alexander A.",59));
    	archDatos.agregar(new Registro(8,"Juliancito",51));
*/
    	System.out.println ("REPORTANDO DESDE \"datos.dat\"");
    	archDatos.reportar();				//reportando 1er archivo
    	Registro vec[] = obj.llevarAVector(archDatos);	//de 1er archivo -> vecto para ordenar mas facil

    	obj.ordenar(vec);				//ordenamos vector por nombre
    	obj.llevarAArchivo(vec,archPromedio,promedio);	//de vec -> 2do archivo(ordenado y > promedio)
    	obj.llevarAArchivo(vec,archCurso);		//de vec -> 3er Archivo(ordenado)
    	
    	System.out.println ("\nREPORTANDO DESDE \"prom.dat\" ordenando por nombre y notas > "+promedio);
    	archPromedio.reportar();			//reportando 2do archivo
    	
    	System.out.println ("\nREPORTANDO DESDE \"curso.dat\" ordenando por nombre");
    	archCurso.reportar();				//reportando 3er archivo
    	
    	
    }
	
}

/*
ej.

:: COD  NOMBRE          NOTA
:: 1    Juan Jose       55.0
:: 2    Zuleyka Riv.    15.0
:: 3    Fredy Iver      33.0
:: 4    Maria Jose      55.0
:: 5    Maria Jesus     45.0
:: 6    Faviola Iris    55.0
:: 7    Alexander A.    59.0
:: 8    Juliancito      51.0

REPORTANDO DESDE "curso.dat" ordenando por nombre
:: COD  NOMBRE          NOTA
:: 7    Alexander A.    59.0
:: 6    Faviola Iris    55.0
:: 3    Fredy Iver      33.0
:: 1    Juan Jose       55.0
:: 8    Juliancito      51.0
:: 5    Maria Jesus     45.0
:: 4    Maria Jose      55.0
:: 2    Zuleyka Riv.    15.0

REPORTANDO DESDE "prom.dat" ordenando por nombre y notas > 46.0
:: COD  NOMBRE          NOTA
:: 7    Alexander A.    59.0
:: 6    Faviola Iris    55.0
:: 1    Juan Jose       55.0
:: 8    Juliancito      51.0
:: 4    Maria Jose      55.0

*/

