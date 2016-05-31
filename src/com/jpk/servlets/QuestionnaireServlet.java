package com.jpk.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jpk.DAO.CustomerDAO;
import com.jpk.entity.Customer;


@WebServlet( "/QuestionnaireServlet" )
public class QuestionnaireServlet
    extends HttpServlet
{
    private static final long serialVersionUID = 1L;


    public QuestionnaireServlet()
    {
        super();
    }


    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        String firstName = request.getParameter( "firstName" );
        String lastName = request.getParameter( "lastName" );
        String eMainAdress = request.getParameter( "eMail" );
        String age = request.getParameter( "age" );

        boolean engineering = request.getParameter( "checkbox1" ) != null;
        boolean art = request.getParameter( "checkbox2" ) != null;
        boolean entertainment = request.getParameter( "checkbox3" ) != null;
        boolean literature = request.getParameter( "checkbox4" ) != null;

        System.out.println( firstName );
        System.out.println( lastName );
        System.out.println( eMainAdress );
        System.out.println( age );
        System.out.println( engineering );
        System.out.println( art );
        System.out.println( entertainment );
        System.out.println( literature );

        Customer customer1 = new Customer();
        customer1.setFirstName( firstName );
        customer1.setLastName( lastName );
        customer1.setEmail( eMainAdress );
        customer1.setAge( age );
        customer1.setEngineering( engineering );
        customer1.setArt( art );
        customer1.setEntertainment( entertainment );
        customer1.setLiterature( literature );
        System.out.println( "created customer" );

        new CustomerDAO().putDataToDatabase( customer1 );

        request.getRequestDispatcher( "/questionnaire.jsp" ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {

        doGet( request, response );
    }
}