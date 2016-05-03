import javax.xml.crypto.Data;
import java.net.*;
import java.io.*;


public class Server {
    static ServerSocket serverSocket;
    protected final static int port = 13370;
    static Socket connection1;
    static Socket connection2;

    public static void main(String[] args) throws IOException {
        //TODO: Create Variables
        char choice;
        int[] cardDeck = {2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11};
        boolean win = false;
        DataInputStream inputFromClient1 = null;
        DataInputStream inputFromClient2 = null;

        try {
            System.out.println("Server Started.  Finding Clients...");
            serverSocket = new ServerSocket(port);
            connection1 = serverSocket.accept();
            connection2 = serverSocket.accept();

            inputFromClient1 = new DataInputStream(connection1.getInputStream());
            DataOutputStream replyToClient1 = new DataOutputStream(connection1.getOutputStream());
            System.out.println("Found Client 1.");

            connection2 = serverSocket.accept();
            inputFromClient2 = new DataInputStream(connection2.getInputStream());
            DataOutputStream replyToClient2 = new DataOutputStream(connection2.getOutputStream());
            System.out.println("Found Client 2.");

            while (true) {
                replyToClient1.writeChar('1');
                while (win == false) {
                    // TODO: Put game code here
                    if(inputFromClient1.readChar() == 'h') {

                        do {
                            //replyToClient1.writeChar('1');
                            choice = inputFromClient1.readChar();
                            System.out.println("inputFromClient1 " + choice);
                            replyToClient1.writeChar(choice);
                        } while (choice == 'h');
                    }
                    else{
                        replyToClient2.writeChar('2');
                        choice = inputFromClient2.readChar();
                        System.out.println("inputFromClient2 " + choice);

                        System.out.println("Please enter 'h' for hit or 's' for stay");
                    }

                }
            }
        }

         catch (IOException ioe) {

        }






            try {
                connection1.close();
                connection2.close();
            } catch (IOException ex) {
            }
        }
    }
