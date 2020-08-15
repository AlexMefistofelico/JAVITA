//VER CLASE "Lista.java" POR SER DE INTERES
//VER CLASE "Nodo.java" POR SER DE INTERES
import java.util.Scanner;
public class Pregunta2{
//	2.	Definir una función que recibe como parámetro una lista encadenada simple y 
//		retorna en otra lista encadenada simple únicamente los valores que no son números 
//		primos.
	public boolean esPrimo(int n){		//firma funcion para verificar si un numero es Primo
		if(n<=1)return false;		//no son primos los de este rango
		for(int i=2;i<=n/2;i++)		//recoremos 2,3,4 ... n/2	
			if(n%i==0)return false;	//verificamos si "i" es divisor de "n"
		return true;			//no encontramos divisores "i" de "n" (es Primo)
	}
	
	public Lista listarPrimos(Lista l){	        //firma funcion para llevar los no primos a otra lista
		Lista r = new Lista();		        //creamos lista resultado a retorna
		Nodo tmp = l.raiz;		        //creamos Nodo para hacer el recorido
		while(tmp!=null){		        //mientras no lleguemos al final de la lista
			if(!esPrimo(tmp.info))		//si NO es primo
				r.agregar(tmp.info);	//agregamos a nuestra lista resultado
			tmp = tmp.sig;		        //recorremos al siguiente nodo para verificar.
		}		
		return r;			        //retornamos el resultado
	}
	
	public static void main (String[] args) {
    	Pregunta2 obj = new Pregunta2();        //creamos objeto para utilizar funciones y metodos de nuestra clase
    	Lista listaNumeros = new Lista();	//lista para llenar datos      	
    	Lista listaSinPrimos = new Lista(); 	//lista para filtrar (NO primos)
    	int tamLista;				//tamaño de la lista
    	Scanner in = new Scanner(System.in);	//Scanner para leer nuestros datos por consola
    	
    	System.out.print ("Ingresa tamaño lista: ");//MENSAJE
    	tamLista = in.nextInt();		//leemos tamaño de la lista 
    	
    	while(tamLista > 0){
    	    System.out.print ("Ingresa Valor a lista: ");       //MENSAJE
    		listaNumeros.agregar(in.nextInt());	        //leemos valor, y la agregamos a la lista
    		tamLista--;					//reducimos tamLista por que ya agregamor +1 elemento
    	}
    	
    	System.out.println ("\nLista Original: ");
    	listaNumeros.mostrar();
    	
    	System.out.println ("\nLista Sin Primos: ");
    	listaSinPrimos = obj.listarPrimos(listaNumeros);
    	listaSinPrimos.mostrar();
    	
    }
}
/*	ej.

Ingresa tamaño lista: 6
Ingresa Valor a lista: 7
Ingresa Valor a lista: 88
Ingresa Valor a lista: 9
Ingresa Valor a lista: 71
Ingresa Valor a lista: 45
Ingresa Valor a lista: 54

Lista Original:
Raiz -> 7 -> 88 -> 9 -> 71 -> 45 -> 54 -> null

Lista Sin Primos:
Raiz -> 88 -> 9 -> 45 -> 54 -> null

*/