package com.jpk.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jpk.DAO.CustomerDAO;
import com.jpk.email.EmailAccountConnectior;
import com.jpk.entity.AgeOfCustomer;
import com.jpk.entity.Customer;


@WebServlet( "/AdministrationServlet" )
public class AdministrationServlet
    extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    private String host;
    private String port;
    private String user;
    private String pass;
    private String resultMessage;
    private List<Customer> listOfCustomersObjectsFromDatabase;
    private String textMessageInfoForWebpage;


    public AdministrationServlet()
    {
        super();
    }


    public void init()
    {
        gettingSMTPServerSettingFromWebXmlFile();
    }


    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        String subject = request.getParameter( "subject" );
        String content = request.getParameter( "emailText" );

        boolean engineering = request.getParameter( "checkbox1" ) != null;
        boolean art = request.getParameter( "checkbox2" ) != null;
        boolean entertainment = request.getParameter( "checkbox3" ) != null;
        boolean literature = request.getParameter( "checkbox4" ) != null;
        String age1 = "0";

        textMessageInfoForWebpage = "There are no customers with this parameters!";
        request.setAttribute( "informationToJSP_Page", textMessageInfoForWebpage );
       
        
         try
         {
         age1 = AgeOfCustomer.valueOf( request.getParameter( "age" ) ).getAge();
        
         }
         catch( Exception e )
         {
         System.out.println( "i sie zjebalo" );
         }
        
         System.out.println( "starting servlet" );
         listOfCustomersObjectsFromDatabase = new CustomerDAO().takeDataFromDatabase( engineering, art, entertainment, literature, age1 );
         System.out.println( "size of list: " + listOfCustomersObjectsFromDatabase.size() );
         if( listOfCustomersObjectsFromDatabase.size() != 0 )
         {
         try
         {
         EmailAccountConnectior eac = new EmailAccountConnectior( host, port, user, pass );
         eac.sendMessage1( listOfCustomersObjectsFromDatabase, subject, content );
        
         resultMessage = "The e-mail was sent successfully";
         }
         catch( Exception ex )
         {
         ex.printStackTrace();
         resultMessage = "There were an error: " + ex.getMessage();
         textMessageInfoForWebpage= "Database connection or e-mail account error!!!";
         }
         finally
         {
         textMessageInfoForWebpage= "The e-mail's was send.";
         request.getRequestDispatcher( "/administration.jsp" ).forward( request, response );
         }
         }
         else
         {
         textMessageInfoForWebpage = "There are no customers with this parameters!";
         request.getRequestDispatcher( "/administration.jsp" ).forward( request, response );
         }
    }


    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }


    private void gettingSMTPServerSettingFromWebXmlFile()
    {
        ServletContext context = getServletContext();
        host = context.getInitParameter( "host" );
        port = context.getInitParameter( "port" );
        user = context.getInitParameter( "user" );
        pass = context.getInitParameter( "pass" );
    }
}
