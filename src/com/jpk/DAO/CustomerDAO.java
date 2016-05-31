package com.jpk.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.jpk.entity.Customer;


public class CustomerDAO
{
    private EntityManagerFactory factory = null;
    private EntityManager em = null;
    private final String persistenceUnitName = "PersistenceUnitInfoName";


    public void putDataToDatabase( Customer customer )
    {
        connectToDatabase( persistenceUnitName );
        saveDataInDatabase( customer );
        disconectFromDatabase();
    }


    public List<Customer> takeDataFromDatabase( boolean engineering, boolean art, boolean entertainment, boolean literature, String age )
    {
        connectToDatabase( persistenceUnitName );
        String JPQLquery = "select e from Customer e where e.engineering=" + engineering + " and e.art= " + art + " and e.entertainment= " +
            entertainment + " and e.literature= " + literature + " and e.age= '" + age + "'";

        System.out.println( JPQLquery );

        List<Customer> listOfCustomers = takeListOfEmailsForCustomersFromTable( JPQLquery );
        disconectFromDatabase();
        System.out.println( "list of custommers done" );
        return listOfCustomers;
    }


    private void connectToDatabase( String persistenceUnitName )
    {
        System.out.println( "started factory" );
        factory = Persistence.createEntityManagerFactory( persistenceUnitName );
        em = factory.createEntityManager();
        em.getTransaction().begin();
    }


    private void disconectFromDatabase()
    {
        em.close();
        factory.close();
    }


    private List<Customer> takeListOfEmailsForCustomersFromTable( String JPQLqueryText )
    {
        TypedQuery<Customer> query = em.createQuery( JPQLqueryText, Customer.class );
        List<Customer> customers = query.getResultList();
        return customers;
    }


    private void saveDataInDatabase( Customer customer )
    {
        em.persist( customer );
        em.getTransaction().commit();
    }
}
