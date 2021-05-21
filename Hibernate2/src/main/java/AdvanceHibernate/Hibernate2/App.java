package AdvanceHibernate.Hibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	userDetailsDB();
    	

    	
    }
    
    public static void userDetailsDB(){
    	
    	UserDetails user = new UserDetails();
    	user.setUserId(3);
    	user.setUserName("Third User");
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	session.beginTransaction();
    	
    	
    	session.save(user);
    	
    	session.getTransaction().commit();
    	session.close();
    	
    }
    
    
}
