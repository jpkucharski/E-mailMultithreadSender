package com.jpk.email;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.jpk.entity.Customer;


public class TextMessage
    implements Runnable, MessageCintentCreator
{
    private Session session;
    private String userName;
    private String subject;
    private String content;
    private Customer customerObject;


    public TextMessage( Session session, String userName, Customer customerObject, String subject, String content )
    {
        System.out.println( "TextMessage object created" );
        this.session = session;
        this.userName = userName;
        this.subject = subject;
        this.content = content;
        this.customerObject = customerObject;
    }

    @Override
    public void run()
    {
        System.out.println( "start creating message" );
        createMessage();
    }

    @Override
    public void createMessage()
    {
        Message msg = new MimeMessage( session );
        try
        {
            
            System.out.println( "parameters for message: " );
            System.out.println( "userName" + userName );
            System.out.println( "subject" + subject );
            System.out.println( "content" + customerObject.getEmail() );
            System.out.println( "adress" + content );
            
            msg.setFrom( new InternetAddress( userName ) );
            InternetAddress[] toAddresses = { new InternetAddress( customerObject.getEmail() ) };
            msg.setRecipients( Message.RecipientType.TO, toAddresses );
            msg.setSubject(
                "Hello " + customerObject.getFirstName() + ", " + "I known that you are between: " + customerObject.getAge() +
                    " years old. And I want to offer incredible Deal. " + subject );
            msg.setSentDate( new Date() );
            msg.setText( content );
            Transport.send( msg );
            System.out.println( "Email was send to: " + customerObject.getEmail() );
            System.out.println();
        }
        catch( MessagingException e )
        {
            e.printStackTrace();
        }
    }
}
