
package ch.heigvd.res.mailbot.smtp;

import ch.heigvd.res.mailbot.model.mail.Mail;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

/**
 *
 * @author manalito
 */
public class SmtpClient implements SmtpClient_I {

    private static final Logger LOG = Logger.getLogger(SmtpClient.class.getName());

    private Socket socket;
    private PrintWriter pWriter;
    private BufferedReader bReader;

    private String smtpServerAddress;
    private int smtpServerPort;

    public SmtpClient(String smtpServerAddress, int smtpServerport){
        this.smtpServerAddress = smtpServerAddress;
        this.smtpServerPort = smtpServerport;
    }


    @Override
    public void sendMail(Mail mail) throws IOException {
        LOG.info("Sending a message via SMTP protocol");
        Socket socket = new Socket(smtpServerAddress, smtpServerPort);
        pWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
        bReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        String line = bReader.readLine();
        LOG.info(line);
        pWriter.printf("EHLO localhost\r\n");

        line = bReader.readLine();
        LOG.info(line);


        // throw an error if we receive other message from server than 250
        if(!line.startsWith("250")){
            throw new IOException("SMTP error :" + line);
        }

        while(line.startsWith("250-")){
            throw new IOException("SMTP error :" + line);
        }
    }
}
