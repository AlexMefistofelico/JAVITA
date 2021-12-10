import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
import static javax.swing.JOptionPane.*;

/* Huffman codificacion , decodifinacion */
//Hace dos semanas, en un articulo publicado por La Razon me referia a La otra educacion, a aquella que, a pesar de su importancia, valor social y pertinencia, es ignorada. Hoy retomo el tema, me referire a la "educacion permanente". Posiblemente, a primera impresion, pensara que es la educacion que se desarrolla de manera continua. Desde la estructura del Sistema Educativo de Bolivia, es algo de eso pero es mucho mas...

public class Huffman {
	
    static final boolean elNuevoTextoSeBasoEnElViejo = false;

    static PriorityQueue<Nodo> nodos = new PriorityQueue<>((o1, o2) -> (o1.valor < o2.valor) ? -1 : 1);
    static TreeMap<Character, String> codigos = new TreeMap<>();
    static String texto = "";
    static String codificado = "";
    static String decodificado = "";
    static int ASCII[] = new int[128];

    public static void main(String[] args) throws FileNotFoundException {
    	
        int decision = 1;
        while (decision != 0) {
            if (manejoDecision(decision)) continue;
            decision = menuConsola();
        }
    }

    private static int menuConsola() {
        
        String vec[] = {"0] Salir","1] Ingrese Nuevo Texto","2] Codificar Texto","3] Decodificar Texto"};
        String cad = (String)(showInputDialog(null,"\n---- Menu ----\n" +
                "-- [0] Salir \n" +
                "-- [1] Ingrese Nuevo Texto\n" +
                "-- [2] Codificar Texto\n" +
                "-- [3] Decodificar Texto:\n","Selecciona Opcion",WARNING_MESSAGE,null,vec,vec[2]));
        if(cad==null)return  0;
        return (cad.charAt(0)-'0');
    }

    private static boolean manejoDecision(int decision) {
        
        if (decision == 1){
            if (manejoNuevoTexto()) return true;
        }else if (decision == 2){
            if (manejoCodificacionNuevoTexto()) return true;
        }else if (decision == 3){
            manejoDecodificacionNuevoTexto();
        }
        return false;
    }

    private static void manejoDecodificacionNuevoTexto() {
        codificado = showInputDialog(null,"Ingrese texto a Decodificar:\n ","Entrada",WARNING_MESSAGE);
        showMessageDialog(null,"Texto Decodificado:\n " + codificado,"Msg2",WARNING_MESSAGE);
        decodificarTexto();
    }

    private static boolean manejoCodificacionNuevoTexto() {
        texto = showInputDialog(null,"Ingrese texto a Codificar: ","Entrada",WARNING_MESSAGE);
        showMessageDialog(null,"texto Codificado:\n " + texto,"Msg3",WARNING_MESSAGE);
        if (!esElMismoConjuntoDeCaracteres()) {
            showMessageDialog(null,"Entrada no Valida","Error",ERROR_MESSAGE);
            texto = "";
            return true;
        }
        codificarTexto();
        return false;
    }

    private static boolean manejoNuevoTexto() {
        int tamañoTextoAnterior = texto.length();
        texto = showInputDialog(null,"Ingrese Texto: ","Entrada",WARNING_MESSAGE);
        if (/**/ texto == null || /**/elNuevoTextoSeBasoEnElViejo && (tamañoTextoAnterior != 0 && !esElMismoConjuntoDeCaracteres())) {
            showMessageDialog(null,"Entrada no Valida","Error",WARNING_MESSAGE);
            texto = "";
            return true;
        }
            ASCII = new int[128];
            nodos.clear();
            codigos.clear();
            codificado = "";
            decodificado = "";
            showMessageDialog(null,"Texto:\n " + texto,"Reporte",WARNING_MESSAGE);
            
            calcularIntervalosDeCaracteres(nodos, true);
            construirArbol(nodos);
            generarCodigos(nodos.peek(), "");

            mostrarCodigos();
			showMessageDialog(null,"-- Codificando/Decodificando --","MSg",INFORMATION_MESSAGE);
            decodificarTexto();
            return false;

    }

    private static boolean esElMismoConjuntoDeCaracteres() {
        boolean flag = true;
        for (int i = 0; i < texto.length(); i++)
            if (ASCII[texto.charAt(i)] == 0) {
                flag = false;
                break;
            }
        return flag;
    }

    private static void decodificarTexto() {
        decodificado = "";
        Nodo nodo = nodos.peek();
        for (int i = 0; i < codificado.length(); ) {
            Nodo nodoTemporal = nodo;
            while (nodoTemporal.IZQUIERDO != null && nodoTemporal.DERECHO != null && i < codificado.length()) {
                if (codificado.charAt(i) == '1')
                    nodoTemporal = nodoTemporal.DERECHO;
                else nodoTemporal = nodoTemporal.IZQUIERDO;
                i++;
            }
            if (nodoTemporal != null)
                if (nodoTemporal.character.length() == 1)
                    decodificado += nodoTemporal.character;
                else
                	showMessageDialog(null,"Entrada no Valida","Error",ERROR_MESSAGE);
                    
        }
        showMessageDialog(null,"Decodificar Texto:\n " + decodificado,"MSG",INFORMATION_MESSAGE);
    
    }

    private static void codificarTexto() {
        codificado = "";
        for (int i = 0; i < texto.length(); i++)
            codificado += codigos.get(texto.charAt(i));
        
        showMessageDialog(null,"Texto Codificado:\n " + codificado,"Codificado",WARNING_MESSAGE);

    }

    private static void construirArbol(PriorityQueue<Nodo> vector) {
        while (vector.size() > 1)
            vector.add(new Nodo(vector.poll(), vector.poll()));
    }

    private static void mostrarCodigos() {
        String cad = "";
        //codigos.forEach((k, v) -> System.out.println ("'" + k + "' : " + v));//para ejecucion java 8.1 o superior
    	
    	for (Map.Entry<Character,String> entry : codigos.entrySet())
    		cad += ("'" + entry.getKey() + "'	=>	" + entry.getValue()+"\n");
    	
        showMessageDialog(null,cad,"--- Mostrando Codigos ---",WARNING_MESSAGE);

    }

    private static void calcularIntervalosDeCaracteres(PriorityQueue<Nodo> vector, boolean imprimeIntervalos) {
       	String tit="";
        if (imprimeIntervalos) 
        	tit = "-- Intervalos --";
		String cad = "";
        for (int i = 0; i < texto.length(); i++)
            ASCII[texto.charAt(i)]++;

        for (int i = 0; i < ASCII.length; i++)
            if (ASCII[i] > 0) {
                vector.add(new Nodo(ASCII[i] / (texto.length() * 1.0), ((char) i) + ""));
                if (imprimeIntervalos)
                    //System.out.printl("'" + ((char) i) + "' : " + ASCII[i] / (texto.length() * 1.0));
                    cad += String.format("'%c'	=>	%.7f\n",((char) i) , ASCII[i] / (texto.length() * 1.0));
            		 
            }

        showMessageDialog(null,cad,tit,WARNING_MESSAGE);

    }

    private static void generarCodigos(Nodo nodo, String s) {
        if (nodo != null) {
            if (nodo.DERECHO != null)
                generarCodigos(nodo.DERECHO, s + "1");

            if (nodo.IZQUIERDO != null)
                generarCodigos(nodo.IZQUIERDO, s + "0");

            if (nodo.IZQUIERDO == null && nodo.DERECHO == null)
                codigos.put(nodo.character.charAt(0), s);
        }
    }
}

class Nodo {
    Nodo IZQUIERDO, DERECHO;
    double valor;
    String character;

    public Nodo(double valor, String character) {
        this.valor = valor;
        this.character = character;
        IZQUIERDO = null;
        DERECHO = null;
    }

    public Nodo(Nodo IZQUIERDO, Nodo DERECHO) {
        this.valor = IZQUIERDO.valor + DERECHO.valor;
        character = IZQUIERDO.character + DERECHO.character;
        if (IZQUIERDO.valor < DERECHO.valor) {
            this.DERECHO = DERECHO;
            this.IZQUIERDO = IZQUIERDO;
        } else {
            this.DERECHO = IZQUIERDO;
            this.IZQUIERDO = DERECHO;
        }
    }
}
