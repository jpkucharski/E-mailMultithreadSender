package com.jpk.email;

import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import com.jpk.entity.Customer;

public class EmailAccountConnectior
{
   private String host;
   private String port;
   private String userName;
   private String password;
   private Session session;
   


    public EmailAccountConnectior( String host, String port, String userName, String password )
    {
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;
    }

    public void sendMessage1(List<Customer> listOfCustomers, String subject, String content){
        System.out.println( "send message start" );
        SMTPConnectionAndStartingSession();
        System.out.println( host );
        System.out.println( port );
        System.out.println( userName );
        System.out.println( password );
        
        
        for(Customer c: listOfCustomers){
           
            new Thread(new TextMessage( session, userName, c, subject, content )).start();
            
        }
    }
    
    private void SMTPConnectionAndStartingSession()
    {
        Properties properties = new Properties();
        properties.put( "mail.smtp.host", host );
        properties.put( "mail.smtp.socketFactory.port", port );
        properties.put( "mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory" );
        properties.put( "mail.smtp.auth", "true" );
        properties.put( "mail.smtp.port", port );
        Authenticator auth = new Authenticator()
        {
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication( userName, password );
            }
        };
        session = Session.getInstance( properties, auth );
        System.out.println( "SMTP connection done" );
    }
}
