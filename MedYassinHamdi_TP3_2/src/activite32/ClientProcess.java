package activite32;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientProcess extends Thread {
	        Socket s; // The client socket.
	        int ord; // Order in which the client connected.

	        public ClientProcess(Socket s, int ord) {
	            this.s = s;
	            this.ord = ord;
	        }

	        public void run() {
	            System.out.println("Client connected " + s.getRemoteSocketAddress() + " order: " + this.ord);

	            
	           
	            try {
	            	// communication serveur client
	            	InputStream input = s.getInputStream();
	                ObjectInputStream is = new ObjectInputStream(input);

	                // Recevoir lobjet operation
	                // transformer son type à operation
	                Operation op = (Operation) is.readObject();

	                // importer les données de la classe operation
	                int nb1 = op.getOp1();
	                int nb2 = op.getOp2();
	                char ops = op.getOp();

	                int res = 0;

	                // traitement du serveur
	                switch (ops) {
	                    case '+':
	                        res = nb1 + nb2;
	                        break;
	                    case '-':
	                        res = nb1 - nb2;
	                        break;
	                    case '*':
	                        res = nb1 * nb2;
	                        break;
	                    case '/':
	                        res = nb1 / nb2;
	                        break;
	                }

	                // mise à jour du resultat de lopération                op.setRes(res);

	                // communication serveur et client avec des objets
	                OutputStream output = s.getOutputStream();
	                ObjectOutputStream oo = new ObjectOutputStream(output);

	                // envoyer le resultat au client 
	                oo.writeObject(op);

	                s.close();
	            } catch (IOException | ClassNotFoundException e) {
	                throw new RuntimeException(e);
	            }}}