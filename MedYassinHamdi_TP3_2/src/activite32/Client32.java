package activite32;


	import java.io.*;
	import java.net.InetAddress;
	import java.net.InetSocketAddress;
	import java.net.Socket;
    import java.util.Scanner;

	public class Client32 {
		
	    public static void main(String[] args) {
	        try {
	            // definir laddresse IP de serveur
	            InetAddress serverAddress = InetAddress.getByName("localhost");
	            InetSocketAddress serverSocketAddress = new InetSocketAddress(serverAddress, 1234);

	            // Creation la socket client
	            Socket clientSocket = new Socket();

	            // Connecter la socketclient avec le serveur 
	            clientSocket.connect(serverSocketAddress);

                // pour la communication entre le client et serveir avec des objets
	            OutputStream output = clientSocket.getOutputStream();
	            ObjectOutputStream os = new ObjectOutputStream(output);
                
	            Scanner scanner = new Scanner(System.in);
	        	int a = scanner.nextInt();
				int b =scanner.nextInt();
	           
	            
	            // Creation une instance operation
	            Operation op = new Operation('*',a,b);

	            // envoyer cette instance au serveur en tant que un objet
	            os.writeObject(op);

                // pour la communication entre le client et serveir avec des objets
	            InputStream input = clientSocket.getInputStream();
	            ObjectInputStream is = new ObjectInputStream(input);

	            // Recevoir le resultat du serveur de type object
	            //transformer son type à operation
	            op = (Operation) is.readObject();

	            // Print le resultat
	            System.out.println("Result received from the server: " + op.getRes());
	        } catch (Exception e) {
	            System.out.println("Client: An error occurred - " + e.getMessage());
	            throw new RuntimeException(e);
	        }
	    }
	}