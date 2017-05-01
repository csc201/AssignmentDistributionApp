



import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;





public class Emailer {


    private static String host = "smtp.gmail.com";
    private static String user = "**********";
    private static String pass = "***********";

    public Emailer(String username, String password){
        this.user = username;
        this.pass = password;
    }


    public static void sendEmail(String fromAddr, String toAddr, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props);

        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(fromAddr));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddr));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message, user, pass);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}