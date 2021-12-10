import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

/* Huffman codificacion , decodifinacion */
//Hace dos semanas, en un articulo publicado por La Razon me referia a La otra educacion, a aquella que, a pesar de su importancia, valor social y pertinencia, es ignorada. Hoy retomo el tema, me referire a la "educacion permanente". Posiblemente, a primera impresion, pensara que es la educacion que se desarrolla de manera continua. Desde la estructura del Sistema Educativo de Bolivia, es algo de eso pero es mucho mas...

public class Huffman {
    static final boolean leerDeArchivo = false;
    static final boolean elNuevoTextoSeBasoEnElViejo = false;

    static PriorityQueue<Nodo> nodos = new PriorityQueue<>((o1, o2) -> (o1.valor < o2.valor) ? -1 : 1);
    static TreeMap<Character, String> codigos = new TreeMap<>();
    static String texto = "";
    static String codificado = "";
    static String decodificado = "";
    static int ASCII[] = new int[128];

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = (leerDeArchivo) ? new Scanner(new File("input.txt")) : new Scanner(System.in);
        int decision = 1;
        while (decision != 0) {
            if (manejoDecision(scanner, decision)) continue;
            decision = menuConsola(scanner);
        }
    }

    private static int menuConsola(Scanner scanner) {
        int decision;
        System.out.println("\n---- Menu ----\n" +
                "-- [0] Salir \n" +
                "-- [1] Ingrese Nuevo Texto\n" +
                "-- [2] Codificar Texto\n" +
                "-- [3] Decodificar Texto");
        decision = Integer.parseInt(scanner.nextLine());
        if (leerDeArchivo)
            System.out.println("Decision: " + decision + "\n---- Fin del Menu ----\n");
        return decision;
    }

    private static boolean manejoDecision(Scanner scanner, int decision) {
        
        if (decision == 1){
            if (manejoNuevoTexto(scanner)) return true;
        }else if (decision == 2){
            if (manejoCodificacionNuevoTexto(scanner)) return true;
        }else if (decision == 3){
            manejoDecodificacionNuevoTexto(scanner);
        }
        return false;
    }

    private static void manejoDecodificacionNuevoTexto(Scanner scanner) {
        System.out.print("Ingrese texto a Decodificar: ");
        codificado = scanner.nextLine();
        System.out.println("Texto Decodificado: " + codificado);
        decodificarTexto();
    }

    private static boolean manejoCodificacionNuevoTexto(Scanner scanner) {
        System.out.print("Ingrese texto a Codificar: ");
        texto = scanner.nextLine();
        System.out.println("texto Codificado: " + texto);

        if (!esElMismoConjuntoDeCaracteres()) {
            System.out.println("Entrada no Valida");
            texto = "";
            return true;
        }
        codificarTexto();
        return false;
    }

    private static boolean manejoNuevoTexto(Scanner scanner) {
        int tamañoTextoAnterior = texto.length();
        System.out.print("Ingresa Texto: ");
        texto = scanner.nextLine();
        if (elNuevoTextoSeBasoEnElViejo && (tamañoTextoAnterior != 0 && !esElMismoConjuntoDeCaracteres())) {
            System.out.println("Entrada no Valida");
            texto = "";
            return true;
        }
            ASCII = new int[128];
            nodos.clear();
            codigos.clear();
            codificado = "";
            decodificado = "";
            System.out.println("Texto: " + texto);
            calcularIntervalosDeCaracteres(nodos, true);
            construirArbol(nodos);
            generarCodigos(nodos.peek(), "");

            mostrarCodigos();
            System.out.println("-- Codificando/Decodificando --");
            codificarTexto();
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
                    System.out.println("Entrada no Valida");

        }
        System.out.println("Decodificar Texto: " + decodificado);
    }

    private static void codificarTexto() {
        codificado = "";
        for (int i = 0; i < texto.length(); i++)
            codificado += codigos.get(texto.charAt(i));
        System.out.println("Texto Codificado: " + codificado);
    }

    private static void construirArbol(PriorityQueue<Nodo> vector) {
        while (vector.size() > 1)
            vector.add(new Nodo(vector.poll(), vector.poll()));
    }

    private static void mostrarCodigos() {
        System.out.println("--- Mostrando Codigos ---");
        codigos.forEach((k, v) -> System.out.println("'" + k + "' : " + v));//para ejecucion java 8.1 o superior
    }

    private static void calcularIntervalosDeCaracteres(PriorityQueue<Nodo> vector, boolean imprimeIntervalos) {
        if (imprimeIntervalos) System.out.println("-- Intervalos --");

        for (int i = 0; i < texto.length(); i++)
            ASCII[texto.charAt(i)]++;

        for (int i = 0; i < ASCII.length; i++)
            if (ASCII[i] > 0) {
                vector.add(new Nodo(ASCII[i] / (texto.length() * 1.0), ((char) i) + ""));
                if (imprimeIntervalos)
                    //System.out.printl("'" + ((char) i) + "' : " + ASCII[i] / (texto.length() * 1.0));
                    System.out.printf("'%c' : %.7f\n",((char) i) , ASCII[i] / (texto.length() * 1.0));
            }
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
