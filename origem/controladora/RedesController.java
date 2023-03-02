package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	 private String osName = os();

	  private static String os() {
	    return System.getProperty("os.name");
	  }

	  public void validarIp() throws IOException {
	    String command = "";
         System.out.println("Sistema operacional =  "+osName);
	    if (osName.startsWith("Windows")) {
	      command = "ipconfig";
	      try {
	        Process process = Runtime.getRuntime().exec(command);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	        String line;
	        while ((line = reader.readLine()) != null) {
	          if (line.contains("IPv4")) {
	            String[] parts = line.trim().split(":");
	            System.out.println(parts[0] + ": " + parts[1]);
	          } else if (line.contains("Ethernet adapter") || line.contains("enp4s0") || line.contains("wlan0")) {
	            System.out.println(line);
	          }
	        }
	      } catch (IOException e) {
	        e.printStackTrace();
	      
	    }  		 } if(os().contains("Linux")){
				try {
					Process proc = Runtime.getRuntime().exec("ifconfig");
		    		InputStream fdados = proc.getInputStream();
		    		InputStreamReader leitura = new InputStreamReader(fdados);
		    		BufferedReader buffer = new BufferedReader(leitura);
		    		String linha = buffer.readLine();
		    		while(linha != null) {
		    			if(linha.contains("flags")) {
		    		System.out.println(linha);}
		    			if(linha.contains("IPv4")) {
		    				System.out.println(linha);}
		    		linha = buffer.readLine();
		    		}
		    		buffer.close();
		    		leitura.close();
		    		fdados.close();
		    	} catch(IOException e) {
					e.printStackTrace();
	}
		 }
	}

	  public void ping( String process) {
		  if(os().contains("Windows")){
		  try{
	    		Process proc = Runtime.getRuntime().exec("PING -4 -n 10 www.google.com.br");
	    		InputStream fdados = proc.getInputStream();
	    		InputStreamReader leitura = new InputStreamReader(fdados);
	    		BufferedReader buffer = new BufferedReader(leitura);
	    		String linha = buffer.readLine();
	    		while(linha != null) {
	    		System.out.println(linha);
	    		linha = buffer.readLine();
	    		}
	    		buffer.close();
	    		leitura.close();
	    		fdados.close();
	    	} catch(IOException e) {
				e.printStackTrace();
	    	}
		  }else {
				if(os().contains("Linux")){
					try 
						Process proc = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br");
			    		InputStream fdados = proc.getInputStream();
			    		InputStreamReader leitura = new InputStreamReader(fdados);
			    		BufferedReader buffer = new BufferedReader(leitura);
			    		String linha = buffer.readLine();
			    		while(linha != null) {
			    		System.out.println(linha);
			    		linha = buffer.readLine();
			    		}
			    		buffer.close();
			    		leitura.close();
			    		fdados.close();
			    	} catch(IOException e) {
						e.printStackTrace();
	}
	    
       }
	           
   }
   }
}


