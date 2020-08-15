//VER CLASE "Nodo.java" POR SER DE INTERES
public class Lista {
	public Nodo raiz;			//Nodo que resa la raiz de nuestra lista
	
    public Lista(){				//CONSTRUCTOR
    	raiz = null;			//raiz => NULO (Lista Vacia)
    }
    
    public void agregar(int n){	//firma funcion para agregar al final de la lista 
    	Nodo nuevo = new Nodo(n);//Creamos un nodo llamando al constructor con "n" com parametro
    	
    	if(raiz==null)			//si me lista es vacia
    		raiz = nuevo;		//mi raiz "apuntara" a "nuevo" (Primer elemento agregado)
    	
    	else{					//si mi lista no se vacia
    		Nodo aux = raiz;	//creamos auxiliar para recorrer lista
    		
    		while(aux.sig!=null)//mietras no lleguemos al ulitmo elemento de la lista
    			aux = aux.sig;	//desplazamos
    			
    		aux.sig = nuevo;	//nuestro "-> null" ahora sera "-> nuevo" agregamos el final.
    	}
    }
    
    public void mostrar(){						//firma funcion para mostrat nuestra lista
    	Nodo aux = raiz;						//aux objeto nodo para recorres nuestra lista apartir de nuetra raiz
    	System.out.print ("Raiz -> ");			//MENSAJE
    	while(aux!=null){						//mientras no lleguemos al final de nuestra lista
    		System.out.print (aux.info+" -> ");	//MENSAJE .ej "55 -> "
    		aux = aux.sig;						//desplazamos puntero al sig. nodo
    	}
    	System.out.println ("null");			//MENSAJE.
    }
}