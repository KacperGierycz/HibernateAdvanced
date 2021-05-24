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

    //	userDetailsDB();
    	setOfAddresses();

    	
    }
    
    public static void setOfAddresses() {
    	
    	UserDetails user1 = new UserDetails();
    	user1.setUserName("First User");
    	
    	Address addr= new Address();
    	Address addr2= new Address();
    	
    	addr.setCity("Warsaw");
    	addr.setState("Mazowsze");
    	addr.setStreet("Siemiatycka");
    	addr.setPincode("00122");
    	
    	addr2.setCity("Warsaw2");
    	addr2.setState("Mazowsze3");
    	addr2.setStreet("Siemiatycka4");
    	addr2.setPincode("001222");
    	
    	user1.getListOfAddresses().add(addr);
    	user1.getListOfAddresses().add(addr2);
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	session.beginTransaction();
    	
    	
    	session.save(user1);


    	
    	session.getTransaction().commit();
    	session.close();
    	
    	
    }
    
    public static void userDetailsDB(){
    	
    	UserDetails user1 = new UserDetails();
    	user1.setUserName("First User");
    	
    	
    	Address addr= new Address();
    	Address addr2= new Address();

    	
    	addr.setCity("Warsaw");
    	addr.setState("Mazowsze");
    	addr.setStreet("Siemiatycka");
    	addr.setPincode("00122");
  //  	user1.setHomeAddress(addr);
    	
    	addr2.setCity("Warsaw2");
    	addr2.setState("Mazowsze3");
    	addr2.setStreet("Siemiatycka4");
    	addr2.setPincode("001222");
  //  	user1.setOfficeAddress(addr2);

    	
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
