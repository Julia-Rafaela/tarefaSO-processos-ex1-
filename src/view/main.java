package view;


import controller.RedesController;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
public class main {

	public static void main (String[] args) throws IOException {
		 RedesController rController = new RedesController();
		 
		 int opc = 0 ;
			while (opc!=9){
			opc = Integer.parseInt(JOptionPane.showInputDialog("1- validar IP \n 2- PING \n 9- Finaliza"));
			switch (opc) {
			       case 1: rController.validarIp();
			                break;
			       case 2: 	 
			    	   String process ="PING -4 -n 10 www.google.com.br" ;
				         rController.ping(process);
			               break;
			       case 9:  JOptionPane.showMessageDialog(null,"Programa finalizado");
			                break;
			       default: JOptionPane.showMessageDialog(null,"Opção Inválida");
	
		 
	
		 
		 //rController.callProcess(process);
	
		 
	 //String param = "cmd.exe";
	 //rController.killprocess(param);
	}
}
	}
}
