import java.util.Scanner;

//1.	Definir una función Recursiva para determinar la cantidad 
//	de números pares que hay en un vector de n elementos.

public class Pregunta1{
	
	public int cantidadPares(int vec[],int i){
		if(vec.length==i)return 0;						//si si sale de indices de vector retornamos 0(caso base)
		if(vec[i]%2==0)return 1+cantidadPares(vec,i+1);	//si es par vec[i] entoces + 1 (contar par)
		else return cantidadPares(vec,i+1);				//si no es par recorremos indice al siguiente valor
	}
	
	public static void main (String[] args) {
    	int n,vec[];						//varibles para nuestro proposito
    	Pregunta1 obj = new Pregunta1();	//creamos objeto para utilizar nuestras definiciones
    
    	Scanner in = new Scanner(System.in);//creamos objeto Scanner para entrada 
    	System.out.print ("Ingresa N: ");	//MENSAJE
    	n = in.nextInt();					//leemos nuetra tamaño de vector
    	vec = new int[n]; 					//creamos un vector de tamaño = n
    
    	for (int i = 0; i<n; i++) {				//recorremos todo el vector
	    	System.out.print ("vec["+i+"]: ");	//MENSAJE
	    	vec[i] = in.nextInt();				//leemos dato en indice "i" del vector
		}    	
    
    	System.out.println ("Cantidad Pares Del Vector: "+obj.cantidadPares(vec,0)); //reportamos resultado.
    }
}

/*

Ingresa N: 6
vec[0]: 4
vec[1]: 345
vec[2]: 3
vec[3]: 71
vec[4]: 4
vec[5]: 12
Cantidad Pares Del Vector: 3

*/