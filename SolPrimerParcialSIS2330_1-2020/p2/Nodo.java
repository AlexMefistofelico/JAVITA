public class Nodo {
	//SOLO DEFINIMOS METODOS Y CAMPOS PARA NUESTRO INTERES (EXAMEN)
	public int info;//INFOrmacion que guardaremos en nuestro NODO
	public Nodo sig;//puntero impl�cito al siguiente nodo
	
    public Nodo(int n) {//constructor
    	info = n;	//info sera asignado con el "n" que nos dan como parametro
    	sig = null;	//puntero inpl�cito al ser creado sera NULO
    }
}