import static javax.swing.JOptionPane.*;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class Dialogos {
	public static void main(String[] args) {
		int n;
		
		String mensage = "Mi Mensage",s;		
		
		Integer vecEnteros[] = {1,2,3,4,5};
		
		ImageIcon icono = new ImageIcon("eclipse.png");
		
		String vecDias[] = {"Lunes","Martes","Miercoles","Jueves","Viernes"};
					
		Font fuente = new Font("Arial",Font.ITALIC,54);
		
		JLabel rotulo = new JLabel("Dialogos");
		rotulo.setFont(fuente);
		rotulo.setForeground(Color.BLUE);
		
		ImageIcon vecIconos[] = {new ImageIcon("instagram.jpg"),new ImageIcon("whatsapp.jpg"),new ImageIcon("facebook.jpg"),new ImageIcon("youtube.jpg"),new ImageIcon("android.jpg")};
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

//	FIRMA DE LAS FUNCION + SOBRECARGA		
//		static int showConfirmDialog(Component compPadre,Object msg)
//		static int showConfirmDialog(Component compPadre,Object msg,String titulo,int tipoOpcion)
//		static int showConfirmDialog(Component compPadre,Object msg,String titulo,int tipoOpcion,int tipoMsg)
//		static int showConfirmDialog(Component compPadre,Object msg,String titulo,int tipoOpcion,int tipoMsg,Icon icono)
		
		n = showConfirmDialog(null,mensage);
		System.out.println("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,rotulo);
		System.out.println("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,icono);
		System.out.println("(showConfirmDialog): "+n);

		n = showConfirmDialog(null,mensage,"Titulo",YES_NO_OPTION);
		System.out.println("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,rotulo,"Titulo",CANCEL_OPTION);
		System.out.println("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,icono,"Titulo",YES_NO_CANCEL_OPTION);
		System.out.println("(showConfirmDialog): "+n);
		
		n = showConfirmDialog(null,mensage,"Titulo",YES_NO_OPTION,ERROR_MESSAGE);
		System.out.println("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,rotulo,"Titulo",CANCEL_OPTION,WARNING_MESSAGE);
		System.out.println("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,icono,"Titulo",YES_NO_CANCEL_OPTION,INFORMATION_MESSAGE);
		System.out.println("(showConfirmDialog): "+n);

		n = showConfirmDialog(null,mensage,"Titulo",YES_NO_OPTION,ERROR_MESSAGE,icono);
		System.out.println("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,rotulo,"Titulo",CANCEL_OPTION,WARNING_MESSAGE,icono);
		System.out.println("(showConfirmDialog): "+n);
		n = showConfirmDialog(null,icono,"Titulo",YES_NO_CANCEL_OPTION,INFORMATION_MESSAGE,icono);
		System.out.println("(showConfirmDialog): "+n);

//	FIRMA DE LAS FUNCION + SOBRECARGA		
//		static String showInputDialog(Component compPadre,Object msg)
//		static String showInputDialog(Component compPadre,Object msg,Object valSelIni)
//		static String showInputDialog(Component compPadre,Object msg,String titulo,int tipoMsg)
//		static Object showInputDialog(Component compPadre,Object msg,String titulo,int tipoMsg,Icon icono,Object[] valSeleccion,Object valSelIni)
//		static String showInputDialog(Object msg)
//		static String showInputDialog(Object msg,Object valSelIni)
		
		s = showInputDialog(null,mensage);
		System.out.println("(showInputDialog): "+s);
		s = showInputDialog(null,rotulo);
		System.out.println("(showInputDialog): "+s);
		s = showInputDialog(null,icono);
		System.out.println("(showInputDialog): "+s);
		
		s = showInputDialog(null,mensage,mensage);
		System.out.println("(showInputDialog): "+s);
		s = showInputDialog(null,rotulo,"por defecto");
		System.out.println("(showInputDialog): "+s);
		s = showInputDialog(null,icono,icono);
		System.out.println("(showInputDialog): "+s);

		s = showInputDialog(null,mensage,"Mi Titulo",ERROR_MESSAGE);
		System.out.println("(showInputDialog): "+s);
		s = showInputDialog(null,rotulo,"Mi Titulo",WARNING_MESSAGE);
		System.out.println("(showInputDialog): "+s);
		s = showInputDialog(null,icono,"Mi Titulo",INFORMATION_MESSAGE);
		System.out.println("(showInputDialog): "+s);

		n = (int)showInputDialog(null,mensage,"Mi Titulo",ERROR_MESSAGE,icono,vecEnteros,vecEnteros[1]);
		System.out.println("(showInputDialog): "+n);
		s = (String)showInputDialog(null,rotulo,"Mi Titulo",WARNING_MESSAGE,icono,vecDias,vecDias[2]);
		System.out.println("(showInputDialog): "+s);
		vecIconos[0] = (ImageIcon)showInputDialog(null,icono,"Mi Titulo",INFORMATION_MESSAGE,icono,vecIconos,vecIconos[3]);
		System.out.println("(showInputDialog): "+vecIconos[0]);
		
//	FIRMA DE LAS FUNCION + SOBRECARGA				
//		static void	showMessageDialog(Component compPadre,Object msg)
//		static void	showMessageDialog(Component compPadre,Object msg,String titulo,int tipoMsg)
//		static void	showMessageDialog(Component compPadre,Object msg,String titulo,int tipoMsg,Icon icono)
//		static int	showOptionDialog(Component compPadre,Object msg,String titulo,int tipoOpcion,int tipoMsg,Icon icono,Object[] opciones,Object valIni)

		showMessageDialog(null,mensage);
		showMessageDialog(null,rotulo);
		showMessageDialog(null,icono);
		
		showMessageDialog(null,mensage,"Mi Titulo",ERROR_MESSAGE);
		showMessageDialog(null,rotulo,"Mi Titulo",WARNING_MESSAGE);
		showMessageDialog(null,icono,"Mi Titulo",INFORMATION_MESSAGE);
		
		showMessageDialog(null,mensage,"Mi Titulo",ERROR_MESSAGE,icono);//solapamos el tipoMsg
		showMessageDialog(null,rotulo,"Mi Titulo",WARNING_MESSAGE,icono);//solapamos el tipoMsg
		showMessageDialog(null,icono,"Mi Titulo",INFORMATION_MESSAGE,icono);//solapamos el tipoMsg

		n = showOptionDialog(null,mensage,"Mi Titulo",YES_NO_OPTION,WARNING_MESSAGE,icono,vecEnteros,vecEnteros[0]);
		System.out.println("(showOptionDialog): "+n);
		n = showOptionDialog(null,mensage,"Mi Titulo",YES_NO_CANCEL_OPTION,ERROR_MESSAGE,icono,vecDias,vecDias[1]);
		System.out.println("(showOptionDialog): "+n);
		n = showOptionDialog(null,mensage,"Mi Titulo",YES_NO_OPTION,WARNING_MESSAGE,icono,vecIconos,vecIconos[2]);
		System.out.println("(showOptionDialog): "+n);
		
		
	}
}


