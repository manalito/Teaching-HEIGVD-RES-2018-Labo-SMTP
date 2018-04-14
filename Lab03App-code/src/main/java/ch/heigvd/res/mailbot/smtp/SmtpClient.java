
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

    private static final String endOfLine = "\r\n";

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
        pWriter.printf("EHLO localhost" + endOfLine);

        line = bReader.readLine();
        LOG.info(line);


        // throw an error if we receive other message from server than 250
        if(!line.startsWith("250")){
            throw new IOException("SMTP error :" + line);
        }

        while(line.startsWith("250-")){
            line = bReader.readLine();
            LOG.info(line);
        }
        pWriter.write("MAIL FROM: " + mail.getFrom() + endOfLine);
        pWriter.flush();
        line = bReader.readLine();
        LOG.info(line);

        for(String to : mail.getTo()){
            pWriter.write("RCPT TO: " + to + endOfLine);
            pWriter.flush();
            line = bReader.readLine();
            LOG.info(line);
        }
/*
        for(String cc : mail.getCc()){
            pWriter.write("RCPT TO: " + cc + endOfLine);
            pWriter.flush();
            line = bReader.readLine();
            LOG.info(line);
        }

        for(String bc : mail.getBcc()) {
            pWriter.write("RCPT TO: " + bc + endOfLine);
            pWriter.flush();
            line = bReader.readLine();
            LOG.info(line);
        }
        */

        // Send Data
        pWriter.write("DATA" + endOfLine);
        pWriter.flush();

        line = bReader.readLine();
        LOG.info(line);
        pWriter.write("Content-Type: text/plain; charset=UTF-8" + endOfLine);
        pWriter.write("From: " + mail.getFrom() + endOfLine);
        pWriter.write("To: " + mail.getTo().get(0));
        for(int i = 1; i < mail.getTo().size(); ++i){
            pWriter.write(", " + mail.getTo().get(i));
        }
        pWriter.write(endOfLine);

        if(mail.getCc() != null){
            pWriter.write("Cc: " + mail.getCc().get(0));
            for(int i = 1; i < mail.getCc().size(); ++i){
                pWriter.write(", " + mail.getCc().get(i));
            }
            pWriter.write(endOfLine);
        }

        if(mail.getBcc() != null) {
            pWriter.write("Bcc: " + mail.getBcc().get(0));
            for (int i = 1; i < mail.getBcc().size(); ++i) {
                pWriter.write(", " + mail.getBcc().get(i));
            }
            pWriter.write(endOfLine);
        }


        pWriter.write("Subject: " + mail.getSubject());
        pWriter.write(endOfLine + endOfLine);
        pWriter.write(mail.getBody());
        pWriter.write(endOfLine + "." + endOfLine);
        pWriter.flush();

        line = bReader.readLine();
        LOG.info(line);

        pWriter.write("QUIT" + endOfLine);
        pWriter.flush();

        bReader.close();
        pWriter.close();
        socket.close();
    }
}
