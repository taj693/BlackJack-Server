import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 13370;


        char selection = 'h';
        boolean win = false;
        char turn;
        Scanner input = new Scanner(System.in);
        System.out.println("Client Initialized");

        try {
            System.out.println("Fetching Server Connection...");
            InetAddress address = InetAddress.getByName(host);
            Socket connection1 = new Socket(address, port);
            Socket connection2 = new Socket(address, port);
            System.out.println("Connection Established.");

            OutputStream sendToServer1 = connection1.getOutputStream();
            DataOutputStream send1 = new DataOutputStream(sendToServer1);

            OutputStream sendToServer2 = connection2.getOutputStream();
            DataOutputStream send2 = new DataOutputStream(sendToServer2);

            InputStream inFromServer1 = connection1.getInputStream();
            DataInputStream serverReply1 = new DataInputStream(inFromServer1);

            InputStream inFromServer2 = connection2.getInputStream();
            DataInputStream serverReply2 = new DataInputStream(inFromServer2);

        while (win == false) {
            if (serverReply1.readChar() == '1')

                while (selection == 'h') {
                    System.out.println("It's your turn Player 1.  Enter 'H' for a Hit or 'S' to Stand.\n");
                    selection = input.nextLine().charAt(0);
                    System.out.println(selection);            //Test
                    send1.writeChar(selection);
                    System.out.println(serverReply1.readChar());
                }


            else if (serverReply2.readChar() == '2') {
                selection = 'h';
                while (selection == 'h') {
                    System.out.println("It's your turn PLayer 2.  Enter 'H' for a Hit or 'S' to Stand.\n");
                    selection = input.nextLine().charAt(0);
                    //System.out.println(selection);            //Test
                    send2.writeChar(selection);
                }
            }

            else {
                System.out.println("invalid");
            }

        }

        } catch (IOException ex) {
            System.out.println("IOException: " + ex);
        }

    }


}