package AdvanceHibernate.Hibernate2;

import java.util.Date;

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
    	
    	UserDetails user1 = new UserDetails();
    	user1.setUserName("First User");
    	
    	UserDetails user2 = new UserDetails();
    	user2.setUserName("Second User");
    	
    	UserDetails user3 = new UserDetails();
    	user3.setUserName("Third User");
    	
//    	user.setAddress("FirstOneAddress");
//    	user.setJoinDate(new Date());
//    	user.setDescription("it's a well done user");
//    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	session.beginTransaction();
    	
    	
    	session.save(user1);
    	session.save(user2);
    	session.save(user3);

    	
    	session.getTransaction().commit();
    	session.close();
    	
//    	user=null;
//    	
//    	session=sf.openSession();
//    	session.beginTransaction();
//    	user= (UserDetails)session.get(UserDetails.class, 3);
//    	System.out.println("User Name is: "+user.getUserName());
    }
    
    
}
