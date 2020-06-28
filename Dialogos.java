import static javax.swing.JOptionPane.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class Dialogos {
	public static void main(String[] args) {
		int n;
		String mensage = "Mi Mensage",s = "";
		Integer vecEntero[] = {1,2,3,4,5};
		ImageIcon icono = new ImageIcon("eclipse.png");
		String vecDias[] = {"Lunes","Martes","Miercoles","Jueves","Viernes"};
		ImageIcon vecIconos[] = {new ImageIcon("instagram.jpg"),
								new ImageIcon("whatsapp.jpg"),
								new ImageIcon("facebook.jpg"),
								new ImageIcon("youtube.jpg"),
								new ImageIcon("android.jpg")};
		JLabel rotulo = new JLabel("Dialogos");
		rotulo.setFont(new Font("Arial",Font.ITALIC,24));
		rotulo.setForeground(Color.BLUE);
	
	
//		tipoMsg
//		•	ERROR_MESSAGE
//		•	INFORMATION_MESSAGE
//		•	WARNING_MESSAGE
//		•	QUESTION_MESSAGE
//		•	PLAIN_MESSAGE
//
//		tipoOpcion
//		•	DEFAULT_OPTION
//		•	YES_NO_OPTION
//		•	YES_NO_CANCEL_OPTION
//		•	OK_CANCEL_OPTION

//	FIRMA DE LOS METODOS + SOBRECARGA		
//		static int showConfirmDialog(Component compPadre,Object msg)
//		static int showConfirmDialog(Component compPadre,Object msg,String titulo,int tipoOpcion)
//		static int showConfirmDialog(Component compPadre,Object msg,String titulo,int tipoOpcion,int tipoMsg)
//		static int showConfirmDialog(Component compPadre,Object msg,String titulo,int tipoOpcion,int tipoMsg,Icon icono)
 	
		n = showConfirmDialog(null,mensage);
		System.out.println ("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,rotulo);
		System.out.println ("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,icono);
		System.out.println ("(showConfirmDialog): "+n);
  
		n = showConfirmDialog(null,mensage,"Mi Titulo",YES_NO_OPTION);
		System.out.println ("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,rotulo,"Mi Titulo",YES_OPTION);
		System.out.println ("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,icono,"Mi Titulo",YES_NO_CANCEL_OPTION);
		System.out.println ("(showConfirmDialog): "+n);
		 
 		
		n = showConfirmDialog(null,mensage,"Mi Titulo",YES_NO_OPTION,WARNING_MESSAGE);
		System.out.println ("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,rotulo,"Mi Titulo",YES_OPTION,ERROR_MESSAGE);
		System.out.println ("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,icono,"Mi Titulo",YES_NO_CANCEL_OPTION,INFORMATION_MESSAGE);
		System.out.println ("(showConfirmDialog): "+n);
 
 
		n = showConfirmDialog(null,mensage,"Mi Titulo",YES_NO_OPTION,WARNING_MESSAGE,icono);
		System.out.println ("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,rotulo,"Mi Titulo",YES_OPTION,ERROR_MESSAGE,icono);
		System.out.println ("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,icono,"Mi Titulo",YES_NO_CANCEL_OPTION,INFORMATION_MESSAGE,icono);
		System.out.println ("(showConfirmDialog): "+n);
	 

//	FIRMA DE LOS METOD0S + SOBRECARGA		
//		static String showInputDialog(Component compPadre,Object msg)
//		static String showInputDialog(Component compPadre,Object msg,Object valSelIni)
//		static String showInputDialog(Component compPadre,Object msg,String titulo,int tipoMsg)
//		static Object showInputDialog(Component compPadre,Object msg,String titulo,int tipoMsg,Icon icono,Object[] valSeleccion,Object valSelIni)
//		static String showInputDialog(Object msg)
//		static String showInputDialog(Object msg,Object valSelIni)
 	
	s = showInputDialog(null,mensage);
	System.out.println ("(showInputDialog): "+s);
	s = showInputDialog(null,rotulo);
	System.out.println ("(showInputDialog): "+s);
	s = showInputDialog(null,icono);
	System.out.println ("(showInputDialog): "+s);
	 
 	s = showInputDialog(null,mensage,"valini");
	System.out.println ("(showInputDialog): "+s);
	s = showInputDialog(null,rotulo,"valini");
	System.out.println ("(showInputDialog): "+s);
	s = showInputDialog(null,icono,"valini");
	System.out.println ("(showInputDialog): "+s);
  	
	s = showInputDialog(null,mensage,"Mi Titulo",WARNING_MESSAGE);
	System.out.println ("(showInputDialog): "+s);
	s = showInputDialog(null,rotulo,"Mi Titulo",ERROR_MESSAGE);
	System.out.println ("(showInputDialog): "+s);
	s = showInputDialog(null,icono,"Mi Titulo",INFORMATION_MESSAGE);
	System.out.println ("(showInputDialog): "+s);
	 

	n = (Integer)showInputDialog(null,mensage,"Mi Titulo",WARNING_MESSAGE,icono,vecEntero,vecEntero[3]);
	System.out.println ("(showInputDialog): "+n);
	s = (String)showInputDialog(null,rotulo,"Mi Titulo",ERROR_MESSAGE,icono,vecDias,vecDias[3]);
	System.out.println ("(showInputDialog): "+s);
	vecIconos[3] = (ImageIcon)showInputDialog(null,icono,"Mi Titulo",INFORMATION_MESSAGE,icono,vecIconos,vecIconos[3]);
	System.out.println ("(showInputDialog): "+vecIconos[3]);
 
	s = showInputDialog(mensage);
	System.out.println ("(showInputDialog): "+s);
	s = showInputDialog(rotulo);
	System.out.println ("(showInputDialog): "+s);
	s = showInputDialog(icono);
	System.out.println ("(showInputDialog): "+s);
	  
	s = showInputDialog(mensage,"val defecto");
	System.out.println ("(showInputDialog): "+s);
	s = showInputDialog(rotulo,"val defecto");
	System.out.println ("(showInputDialog): "+s);
	s = showInputDialog(icono,"val defecto");
	System.out.println ("(showInputDialog): "+s);
	 
//	FIRMA DE LOS METODOS + SOBRECARGA				
//		static void	showMessageDialog(Component compPadre,Object msg)
//		static void	showMessageDialog(Component compPadre,Object msg,String titulo,int tipoMsg)
//		static void	showMessageDialog(Component compPadre,Object msg,String titulo,int tipoMsg,Icon icono)
//		static int	showOptionDialog(Component compPadre,Object msg,String titulo,int tipoOpcion,int tipoMsg,Icon icono,Object[] opciones,Object valIni)
 		
		showMessageDialog(null,mensage);
		showMessageDialog(null,rotulo);
		showMessageDialog(null,icono);
  
		showMessageDialog(null,mensage,"Mi Titulo",WARNING_MESSAGE);
		showMessageDialog(null,rotulo,"Mi Titulo",ERROR_MESSAGE);
		showMessageDialog(null,icono,"Mi Titulo",PLAIN_MESSAGE);
  
		showMessageDialog(null,mensage,"Mi Titulo",WARNING_MESSAGE,icono);
		showMessageDialog(null,rotulo,"Mi Titulo",ERROR_MESSAGE,icono);
		showMessageDialog(null,icono,"Mi Titulo",PLAIN_MESSAGE,icono);
 
		n = showOptionDialog(null,mensage,"Mi Titulo",YES_OPTION,WARNING_MESSAGE,icono,vecEntero,vecEntero[0]);
		System.out.println ("(showOptionDialog): "+n);	
		n = showOptionDialog(null,rotulo,"Mi Titulo",YES_OPTION,ERROR_MESSAGE,icono,vecDias,vecDias[1]);
		System.out.println ("(showOptionDialog): "+n);	
		n = showOptionDialog(null,icono,"Mi Titulo",YES_OPTION,INFORMATION_MESSAGE,icono,vecIconos,vecIconos[2]);
		System.out.println ("(showOptionDialog): "+n);	
		
		
	}
}


























