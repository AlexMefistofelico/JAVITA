import java.util.Scanner;
import java.io.*;

public class Registro {
	public int codigo;		//4bytes
	public String nombre;	//12bytes
	public double nota;		//8bytes
	public boolean estado;	//1byte
							//25bytes (tamaño total registro)
    public Registro(int c,String n,double d) {	//constructor con TRES PARAMETROS
		codigo = c;								//asignacion
		nombre = n;								//asignacion
		nota = d;								//asignacion
		estado = true;							//asignacion
    }
    
    public Registro() {	//constructor por DEFECTO
		codigo = 0;		//asignacion
		nombre = null;	//asignacion
		nota = 0.0;		//asignacion
		estado = false;	//asignacion
    }
    
    public Registro(Registro reg) {	//constructor de COPIA
		codigo = reg.codigo;		//asignacion
		nombre = reg.nombre;		//asignacion
		nota = reg.nota;			//asignacion
		estado = reg.estado;		//asignacion
    }
    
    public int getTamReg(){return 25;}//retornamos el tamaño total de nuestro registro (metodo)
    
	public void grabar(RandomAccessFile f)throws IOException{//metodo para grabar registo(entero)
		byte b[] = new byte[12];				//vector de bytes para proceso grabado "String" tamaño fijo		
		f.writeInt(codigo);						//grabamos codigo (solo)
		
		nombre.getBytes(0,nombre.length(),b,0);	//de nombre "String" -> b "byte[]"
		//	  .getBytes(iniFuente,finFuente,Destino,iniDestino);
		
		f.write(b);								//grabamos nombre que esta en "b" (solo)
		f.writeDouble(nota);					//grabamos nota (solo)
		f.writeBoolean(estado);					//grabamos estado (solo)
	}    
    
	public void leer(RandomAccessFile f)throws IOException{//metodo para leer registo(entero)
		byte b[] = new byte[12];				//vector de bytes para proceso leido "String" tamaño fijo
		codigo = f.readInt();					//leemos codigo (solo)
		f.readFully(b);							//leemos nombre en "b" 
		nombre = new String(b).trim();			//creamos String con "b" eliminando espacios del final(trim)
		nota = f.readDouble();					//leemos nota (solo)
		estado = f.readBoolean();				//leemos estado (solo)
	}    
    
    @Override										//opcional para describir SOBRE ESCRITURA del metodo 
    public String toString(){						//sobre escribimos metodo de la clase padre(implícita) Object
    	return ":: "+codigo+"\t"+nombre+"\t"+nota;	//concatenamos contenido campos
    }
}