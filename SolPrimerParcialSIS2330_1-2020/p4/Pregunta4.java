//VER CLASE "Deportista.java" POR SER DE INTERES (archivos NECESARIOS)
//VER CLASE "Fotbolista.java" POR SER DE INTERES(archivos NECESARIOS)
//VER CLASE "Basquetbolista.java" POR SER DE INTERES(archivos NECESARIOS)
//VER CLASE "Tenista.java" POR SER DE INTERES(archivos NECESARIOS)

public class Pregunta4{
	
//	4.	Desarrollar un programa completo para implementar 
//		la siguiente Jerarquía de Clases: (EN GRAFICO)

	public static void main (String[] args) {
    	Deportista objdep = new Deportista();
    	Deportista objfut = new Futbolista();
    	Deportista objbas = new Basquetbolista();
    	Deportista objten = new Tenista();
    
    	objdep.leer();			//llamada funcion propia de clase padre
    	System.out.println ();	//salto linea
    	objfut.leer(); 			//llamada funcion redefinida en clase hija
    	System.out.println ();	//salto linea
    	objbas.leer(); 			//llamada funcion redefinida en clase hija
    	System.out.println ();	//salto linea
    	objten.leer(); 			//llamada funcion redefinida en clase hija
    	System.out.println ();	//salto linea
    	
    	System.out.println ("Deportista: ");
    	objdep.imprimir();	//llamada funcion propia de clase padre
    	System.out.println ();
    	System.out.println ("Futbolista");
    	objfut.imprimir();	//llamada funcion redefinida en clase hija
    	System.out.println ("Basquetbolista");
    	objbas.imprimir();	//llamada funcion redefinida en clase hija
    	System.out.println ("Tenista");
    	objten.imprimir();	//llamada funcion redefinida en clase hija
    
    }
}

/*
ej.

Lectura Datos Deportista:
Codigo: 1
Nombre: maria jose
Fecha_Nac: 12/12/2000

Lectura Datos Deportista:
Codigo: 2
Nombre: mario puts
Fecha_Nac: 11/11/2001
Lectura Datos Futbolista:
Peso: 75,3
Salario: 20000

Lectura Datos Deportista:
Codigo: 3
Nombre: ximine diw
Fecha_Nac: 10/10/2006
Lectura Datos Basquetbolista:
Estatura: 1,98

Lectura Datos Deportista:
Codigo: 4
Nombre: jhoselin anc
Fecha_Nac: 16/06/1996
Lectura Datos Tenista:
pais: bolivia

Deportista:
1       maria jose      12/12/2000
Futbolista
2       mario puts      11/11/2001      75.3    20000.0
Basquetbolista
3       ximine diw      10/10/2006      1.98
Tenista
4       jhoselin anc    16/06/1996      bolivia

*/