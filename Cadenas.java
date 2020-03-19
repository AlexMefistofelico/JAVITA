public class Cadenas {//<<FUNCIONES DE CADENAS POPULARES JAVA>> <-A.A.CH.CL-> 
	public String inv(String cad){//funcion para invertir una cadena => anedac
		String res = "";
		for(int i=cad.length()-1;i>=0;i--)//.length() => retorna el tamaño de la cadena "cad" 
			res+=cad.charAt(i);//concatenando caracter; .charAt(i) => retorna caracter en posicion "i" 
		return res;
	}
	public static void main(String[] args) {//PARA ESTE CASO STRING Y CADENA SON SINONIMOS...
    	String cadena = "Programacion";
    	String str1 = "alex",str2 = "maria",str3 = "zabrina";
    	String vec1[] = {"faviola","maria","eddy","suzana","abam"};
    	String vec2[] = {"Faviola","Maria","eddy","Suzana","abam"};
    	Cadenas obj = new Cadenas();//llamando al constructor por defecto "por que no tenemos constructor definido"
		byte[] a = {'a','b','c','d','e'};
		char[] b = {'a','b','c','d','e'};
    	String c = "abcde";
//    	contructores de la clase "String" los mas usados los que "nos interesa"
		String cada = new String(a);//apartir de un vector de byte's 	<linea 11>
		String cadb = new String(b);//apartir de un vector de char's 	<linea 12>
		String cadc = new String(c);//apartir de otro obj. String 		<linea 13> 
		System.out.println (cada+"-"+cadb+"-"+cadc);

		
//<<*>> 	FIRMA DE FUNCION O METODO ; QUE RETORNA ,NOMBRE Y LOS PARAMETROS QUE RECIBE
//{TEXTO}	DESCRIPCION DE LO QUE HACE LA FUNCION O METODO
//[Ej.]		EJEMPLO DE LA FUNCIONALIDAD DE LA FUNCION O METODO



//<<*>>	char charAt(int index)
//		{RETORNA EL VALOR DEL CARACTER ESPECIFICADO EN "index"}

//		[Ej.]	
//		mostrando $cadena caracter por caracter
		System.out.println ("\n<Ej. char charAt(int index)>\n");
		System.out.print (cadena.charAt(0));//cadena definido en <linea 9> primer caracter 'P'		
		System.out.print (cadena.charAt(1));		
		System.out.print (cadena.charAt(2));		
		System.out.print (cadena.charAt(3));		
		System.out.print (cadena.charAt(4));		
		System.out.print (cadena.charAt(5));	
	
		System.out.println (""+	cadena.charAt(6)+	//tener en cuenta ""+
								cadena.charAt(7)+
								cadena.charAt(8)+
								cadena.charAt(9)+
								cadena.charAt(10)+
								cadena.charAt(11));


		
//<<*>>	int compareTo(String anotherString)
//		{LAS COMPARACIONES DOS CORDONES LEXICOGRáFICAMENTE(ALFABETICAMENTE)
//			0 	si son iguales las Cadenas
//			>0 	si str > anotherString //mayor lexicograficamente
//			<0  si str < anotherString //menor lexicograficamente
//			"NO ignora mayusculas y minusculas"
//			TENER EN CUENTA:
//				alex != AleX
//		}			
//		[Ej.]
		System.out.println ("\n<Ej. int compareTo(String anotherString)>\n");
//		str1 ,str2 ,str3 declarados en <liena 10>
		System.out.println (str2.compareTo(str1));//maria > alex 		=> int>0
		System.out.println (str1.compareTo(str2));//alex < maria 		=> int<0		
		System.out.println (str3.compareTo(str3));//zabrina = zabrina 	=> int=0
		obj.mostrar(vec1);//mostrar definido al final
//		ordenamos Ascendentemente nuestro vec1 definido en <linea 11> algoritmo "burbuja"
//		con esto NO podriamos ordenar el vec2 definido en <linea 12>
		for(int i=0;i<vec1.length-1;i++)
			for(int j=i+1;j<vec1.length;j++)
				if(vec1[i].compareTo(vec1[j])>0){//tomar en cuenta "<" Descendentemente 
					String tmp = vec1[i];
					vec1[i] = vec1[j];
					vec1[j] = tmp;
				}
		obj.mostrar(vec1);//mostrar definido al final(mostramos despues de ordenar)


		
//<<*>>	int compareToIgnoreCase(String str)
//		{COMPARA DOS CADENAS LEXICOGRáFICAMENTE, IGNORANDO LAS DIFERENCIAS DEL CASO.
//			"ignora mayusculas y minusculas"
//			TENER EN CUENTA:
//				alex == AleX
//}
//		[Ej.]
		System.out.println ("\n<Ej. int compareToIgnoreCase(String str)>\n");
		obj.mostrar(vec2);//mostrar definido al final
//		con esto SI podriamos ordenar el vec2 definido en <linea 12>
		for(int i=0;i<vec2.length-1;i++)
			for(int j=i+1;j<vec2.length;j++)
				if(vec2[i].compareToIgnoreCase(vec2[j])>0){//tomar en cuenta "<" Descendentemente 
					String tmp = vec2[i];
					vec2[i] = vec2[j];
					vec2[j] = tmp;
				}
		obj.mostrar(vec2);//mostrar definido al final(mostramos despues de ordenar)
			

			
//<<*>>	String cancat(String str)
//		{CONCATENA EL STR ESPECIFICADO AL FIN DE ESTE CADENA.Encadena el cordón especificado al fin de este cordón.Encadena el cordón especificado al fin de este cordón.Encadena el cordón especificado al fin de este cordón.}
//		[Ej.]
		System.out.println ("\n<Ej. String cancat(String str)>\n");
		String aux = cadena.concat(" Funcional");
//		String aux = cadena+" Funcional";//la misma funcionalidad que arriba
		System.out.println (aux);
		

		
//<<*>>	boolean  contains(CharSequence s)
//		{RETORNA TRUE Y SóLO SI ESTA CADENA CONTIENE LA SUCESIóN ESPECIFICADA POR LA SECUENCIA DE CARACTERES "S".}
//		[Ej.]
		System.out.println ("\n<Ej. boolean  contains(CharSequence s)>\n");
		System.out.println (cadena.contains("oo"));
		//false por que cadena = "Programacion" NO contiene "oo"		
		System.out.println (cadena.contains("on"));	
		//true por que cadena = "Programacion" SI contiene "on"		
			

			
//<<*>>	boolean  endsWith(String suffix)
//		{PRUEBAS SI ESTA CADENA ACABA CON EL SUFIJO(SUFFIX) ESPECIFICADO.}
//		[Ej.]
		aux = "alex.mefistofelico@gmail.com";					
		System.out.println ("\n<Ej. boolean  endsWith(String suffix)>\n");
		//MI CORREO PERTENECE A GOOGLE?
		System.out.println ("Su correo "+(aux.endsWith("@gmail.com")?"SI ":"NO ")+"Pertenece Google Domain.");



//<<*>>	boolean equals(String anObject)
//		{COMPARA ESTA CADENA AL OBJETO(anObject) ESPECIFICADO.
//			TOMAR EN CUENTA QUE CON ESTA FUNCION
//				alex != AleX
//		}		
//		[Ej.]
		System.out.println ("\n<Ej. boolean equals(String anObject)>\n");
		if(cadena.equals(aux))//son iguales los contenidos de cadena y aux??
			System.out.println ("Las Cadenas Son IGUALES.");
		else
			System.out.println ("Las Cadenas NO! Son IGUALES.");
		aux = cadena;//ahora si son iguales
		if(cadena.equals(aux))
			System.out.println ("Las Cadenas Son IGUALES.");
		else
			System.out.println ("Las Cadenas NO! Son IGUALES.");


					
//<<*>>	boolean equalsIgnoreCase(String anotherObject)
//		{COMPARA ESTA CADENA A OTRA CADENA, IGNORANDO LAS CONSIDERACIONES DEL CASO
//			(NO TOMA EN CUENTA LAS MAYUSCULAS Y MINUSCULAS).
//			TOMAR EN CUENTA QUE CON ESTA FUNCION
//				alex == AleX
//		}		
//		[Ej.]
		System.out.println ("\n<Ej. boolean equalsIgnoreCase(String anotherObject)>\n");
		if(cadena.equalsIgnoreCase("PROGRAMACION"))//son iguales los contenidos de cadena y PROGRAMACION SIN TOMAR EN CUENTA EL CASE??
			System.out.println ("Las Cadenas Son IGUALES. considerando minusculas=mayusculas");
		else
			System.out.println ("Las Cadenas NO! Son IGUALES.");
	

			
//<<*>>   static String format(String format,Object... args)
//		{RETORNA UN STRING FORMATEADO QUE USA LA CADENA DEL FORMATO(FORMAT) ESPECIFICADO Y ARGUMENTOS.}
//		[Ej.]
		System.out.println ("\n<Ej. static String format(String format,Object... args)>\n");
		double valDouble = 12.0294387534523452345;
		int valInt = 255;		
		System.out.println (String.format("%.3f",valDouble));
//		mostramos valos con solo 3 cifras despues del punto
		System.out.println (String.format("%x",valInt));
//		mostramos valor en hexadecimal minuscula ff
		System.out.println (String.format("%X",valInt));
//		mostramos valor en hexadecimal mayuscula FF
		System.out.println (String.format("%10d",valInt));
//		mostramos valor en un espacio de 10 caracteres alineado hacia la izq.
//		"OTROS FORMATOS EXCEDEN EL CONTENIDO EL CURSO, PERO ESTARA CONTENIDO EN OTRO ARCHIVO"	



//<<*>>   byte[] getBytes()
//		{codifica este string en una sucesión de bytes que usan el charset de valor
//		predeterminado de la plataforma,guardando el resultado en un nuevo byte[] vector de byte's}
//		[Ej.]
		System.out.println ("\n<Ej. byte[] getBytes()>\n");
		a = cadena.getBytes();//"a" def. en <liena 14> "cadena" def. en <linea 9>
		System.out.print 	((char)a[0]);
		System.out.print 	((char)a[1]);
		System.out.print 	((char)a[2]);
		System.out.print 	((char)a[3]);
		System.out.print 	((char)a[4]);
		System.out.print 	((char)a[5]);
		System.out.print	((char)a[6]);
		System.out.print 	((char)a[7]);
		System.out.print 	((char)a[8]);
		System.out.print   	((char)a[9]);
		System.out.print   ((char)a[10]);
		System.out.println ((char)a[11]);
		

		
//<<*>>   int indexOf(int ch)
//		{RETORNA EL íNDICE DENTRO DE ESTA CADENA DE LA PRIMERA OCURRENCIA DEL CARáCTER(ch) ESPECIFICADO.
//		Y -1 SI NO SE ENCONTRO}
//		[Ej.]		
		aux = "faviola";
		System.out.println ("\n<Ej. int indexOf(int ch)>\n");
		System.out.println ("'v' encontrado en indice: "+aux.indexOf('e'));

					
			
//<<*>>   int indexOf(String str)
//		{RETORNA EL íNDICE DENTRO DE ESTA CADENA DE LA PRIMERA OCURRENCIA DEL SUBSTRING(STR) ESPECIFICADO.
//		Y -1 SI NO SE ENCONTRO}
//		[Ej.]
		aux = "alefantito";
		System.out.println ("\n<Ej. indexOf(String str)>\n");
		System.out.println ("'fanti' encontrado en indice: "+aux.indexOf("fanti"));
		

				
//<<*>>   int indexOf(String str,int fromIndex)
//		{RETORAN EL íNDICE DENTRO DE ESTA CADENA DE LA PRIMERA OCURRENCIA DEL SUBSTRING(STR) ESPECIFICADO, 
//		EMPEZANDO AL íNDICE(FROMINDEX) ESPECIFICADO.
//		Y -1 SI NO SE ENCONTRO}
//		[Ej.]
		System.out.println ("\n<Ej. int indexOf(String str,int fromIndex)>\n");
		aux = "abcdefghijklmnñopqrstuvwxyz";
		valInt = aux.indexOf("abc",2);//buscamos "abc" desde el indice 2 
		if(valInt==-1)
			System.out.println ("No se encontro...");
		else
			System.out.println ("esta en "+valInt);
		
			
		
//<<*>>   boolean isEmpty()
//		{RETORNA true, Y SóLO SI, length() ES 0.}
//		[Ej.]
		System.out.println ("\n<Ej. isEmpty()>\n");
		System.out.println (aux.isEmpty()?"la cadena es vacia":aux);
		
				
				
//<<*>>   int lastIndexOf(int ch)
//		{RETORNA EL íNDICE DENTRO DE ESTA CADENA DE LA úLTIMA OCURRENCIA DEL CARáCTER(ch) ESPECIFICADO.
//		Y -1 SI NO SE ENCONTRO}
//		[Ej.]
		System.out.println ("\n<Ej. int lastIndexOf(int ch)>\n");
		aux = "faviola";
		System.out.println ("'a' encontrada en indice: "+aux.lastIndexOf('a'));	



//<<*>>   int lastIndexOf(String str)
//		{RETORNA EL íNDICE DENTRO DE ESTA CADENA DE LA úLTIMA OCURRENCIA DEL SUBSTRING(str) ESPECIFICADO.
//		Y -1 SI NO SE ENCONTRO}
//		[Ej.]
		aux = "abcabcab";		
		System.out.println ("\n<Ej. int lastIndexOf(String str)>\n");
		System.out.println ("ultimo 'abc' encontrada en indice: "+aux.lastIndexOf("abc"));	


		
//<<*>>   int length()
//		{RETORNA EL TAMAñO DEL STRING}
//		[Ej.]
		System.out.println ("\n<Ej. int length()>\n");
		System.out.println ("tamaño de: \""+cadena+"\" es: "+cadena.length());



//<<*>>   boolean matches(String regex)
//		[Ej.]
		System.out.println ("\n<Ej. boolean matches(String regex)>\n");
		aux = "123ff";
		if(aux.matches("[0-9a-fA-F]+"))//exprecion regular
			System.out.println ("aux es un num. hexadecimal: "+aux);
		else
			System.err.println ("error aux no es exadecimal...");
//		"OTRAS EXPRESIONES REGULARES EXCEDEN EL CONTENIDO EL CURSO"	

			
			
//<<*>>   String replace(char oldChar, char newChar)
//		{RETORNA UN STRING QUE ES EL RESULTADO DE REEMPLAZAR TODAS LAS OCURRENCIAS DE oldCHAR EN ESTA CADENA CON EL newCHAR.}
//		[Ej.]
		aux = "fernanda";		
		System.out.println ("\n<Ej. String replace(char oldChar, char newChar)>\n");
		System.out.println (aux+" :reemplazando a => #");
		aux = aux.replace('a','#');
		System.out.println (aux);
		

				
//<<*>>   String replace(CharSequence target,CharSequence replacement)
//		{REEMPLAZA CADA SUBSTRING DE ESTA CADENA QUE COINSIDEN CON TARGET SUCESIóN DEL REEMPLAZO 
//			LITERAL ESPECIFICADA.}
//		[Ej.]
		System.out.println ("\n<Ej. String replace(CharSequence target,CharSequence replacement)>\n");
		aux = "asdfñlkjasdfñlkjasdfñlkjasdñflkj";
		aux = aux.replace("ñlkj","asdf");//reemplazando todos los "ñlkj" por "asdf"		
		System.out.println (aux);
		

		
//<<*>>   String replaceAll(String regex,String replacement)
//		{Reemplaza cada substring de esta cadena que coincide con la expresión regular(regex) ,con 
//		el reemplazo(replacement) dado.}
//		[Ej.]
		System.out.println ("\n<Ej. String replaceAll(String regex,String replacement)>\n");
		aux = "cancion funcion oracion hola favi traccion";
		System.out.println (aux);//reemplazando todo lo que termina con "cion"
		aux = aux.replaceAll("[a-zA-Z]+cion","full");
		System.out.println (aux);
//		"OTRAS EXPRESIONES REGULARES EXCEDEN EL CONTENIDO EL CURSO"	



//<<*>>   boolean startsWith(String prefix)
//		{VERIFICA IS ESTE STRING TIENE COMO PREFIJO(prefix)}
//		[Ej.]
		System.out.println ("\n<Ej. boolean startsWith(String prefix)>\n");
		aux = "www.oracle.com";
		System.out.println (aux+(aux.startsWith("www.")?" SI ":" NO ")+" es un dominio de internet");

				
				
//<<*>>   String substring(int beginIndex)
//		{RETORNA UNA CADENA QUE SE SUBSTRING DE ESTE STRING}
//		[Ej.]
		System.out.println ("\n<Ej. String substring(int beginIndex)>\n");
		aux = "Maria Magdalena";
		System.out.println (aux.substring(6));//substring desde el indice 6 "magdalena"	
		

		
//<<*>>   String substring(int beginIndex,int endIndex)
//		{RETORNA UNA CADENA QUE SE SUBSTRING DE ESTE STRING}
//		[Ej.]
		System.out.println ("\n<Ej. String substring(int beginIndex,int endIndex)>\n");
		aux = "Metodologia de La Programacion III";
		System.out.println (aux.substring(15,30));
		

		
//<<*>>   String toLowerCase()
//		{CONVIERTE TODOS LOS CARáCTERES EN ESTA CADENA A MINúSCULA.}
//		[Ej.]
		System.out.println ("\n<Ej. String toLowerCase()>\n");
		System.out.println (cadena.toLowerCase());
		

				
//<<*>>   String toUpperCase()
//		{CONVIERTE TODOS LOS CARáCTERES EN ESTA CADENA A MAYúSCULA.}
//		[Ej.]
		System.out.println ("\n<Ej. String toUpperCase()>\n");
		System.out.println (cadena.toUpperCase());



//<<*>>   String toString()
//		{ESTE OBJETO (QUé YA ES UN CORDóN!) SE RETORNA}
//		[Ej.]
		System.out.println ("\n<Ej. String toString()>\n");
		Integer valInteger = 1324;
		System.out.println (valInteger+" Cantidas de digitos: "+valInteger.toString().length());
		

		
//<<*>>   String trim()
//		{RETORNA EL STRING QUITANDO ESPACIOS DEL PRINCIPIO Y DEL FINAL}
//		[Ej.]
		System.out.println ("\n<Ej. String trim()>\n");
		aux = "      hola      ";//cadena con espacios
		System.out.println (aux.trim());



//<<*>>   static String valueOf(Object obj)//Object tambie podria ser cualquier tipo de dato primitivo
//		{RETORNA REPRESENTACION STRING DEL ARGUMENTO obj}
//		[Ej.]
    	System.out.println ("\n<Ej. static String valueOf(Object obj)>\n");
		valInt = 666;
		aux = String.valueOf(valInt)+String.valueOf(valDouble);//concatenando 
		System.out.println (aux);
	}

		
	public void mostrar(String v[]){//FUNCION PARA MOSTRAR UN VECTOR DE STRING'S
		for(String i:v)//foreach para cada 
			System.out.print (i+" ");
		System.out.println ();
	}
}
