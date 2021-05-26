package AdvanceHibernate.Hibernate2;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
    //	setOfAddresses();
    //	oneToOne();
    //	Cascade();
    //	InheritanceHibernate();
    //	CrudOperation();
    //	TransientPersistentDetached();
    //	PersistAfterDetached();
    	HQLqueries();
    }
    
    public static void HQLqueries(){
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	session.beginTransaction();
    	
    	String minUserId="5";
    	String userNamex= "User 9";
    	
    	Criteria criteria = session.createCriteria(UserDetails.class)
    			.setProjection(Projections.count("userId"));
    		
//    			.addOrder(Order.desc("userId"));
    	
    	
    	
    	
//    	criteria.add(Restrictions.eq("userName", userNamex))
//    			.add(Restrictions.gt("userId", Integer.parseInt(minUserId)));
    	
    	
    	
    	
 //   	new map(userId, userName)
//    	max(userID)

    	
//    	Query query= session.createQuery("from UserDetails where userId > ? and userName =?"); 
//    	Query query= session.createQuery("from UserDetails where userId > :userID and userName =:userName"); 
//    	Query query =session.getNamedQuery("UserDetails.byId");
//    	Query query =session.getNamedQuery("UserDetails.byName");
    	
//    	query.setString(0, userNamex);
//    	query.setInteger(0, Integer.parseInt(minUserId));
//    	query.setString(1, userNamex);
//    	query.setInteger("userID", );
//    	query.setString("userName", userNamex);
    	
//    	query.setFirstResult(5);
//    	query.setMaxResults(4);
//    	List<UserDetails> users= (List<UserDetails>) query.list();
    	List<UserDetails> users= (List<UserDetails>) criteria.list();
//    	List<String> users= (List<String>) query.list();

    	session.getTransaction().commit();
    	session.close();
    	System.out.println("Size of list result = "+users.size());
    	
//    	for (String user:users) {
//		System.out.println(user);
//		
//	}
    	
    	for (UserDetails user:users) {
    		System.out.println(user.getUserName());
    		
    	}
    }
    
    
    public static void PersistAfterDetached() {
    	Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	session.beginTransaction();
    	
    	UserDetails user = new UserDetails();
    	

    	
    	user.setUserName("Test user");
    	System.out.println(user.getUserName());
   // 	session.save(user);
    	

     	UserDetails user2=(UserDetails) session.get(UserDetails.class, 2);

    	System.out.println(user2.getUserName());

    	session.getTransaction().commit();
    	session.close();
    	
//    	user2.setUserName("Updated User xxx");
    	
    	session=sf.openSession();
    	session.beginTransaction();
    	session.update(user2);
    	session.getTransaction().commit();
    	session.close();
    	
    	
    }
    
    public static void TransientPersistentDetached() {
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	session.beginTransaction();
    	
    	UserDetails user = new UserDetails();
    	

    	
    	user.setUserName("Test user");
    	
    	session.save(user);
    	
    	user.setUserName("Updated User");
    	user.setUserName("Updated User Again");

    	
    	session.getTransaction().commit();
    	session.close();
    	
    }
    
    
    public static void CrudOperation() {   	
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	session.beginTransaction();
    	
    	
//    	for(int i=0;i<10;i++) {
//    	UserDetails user1 = new UserDetails();
//    	user1.setUserName("User "+i);
//    	session.save(user1);
//    	}
    	
    	UserDetails user=(UserDetails) session.get(UserDetails.class, 5);
 
    	user.setUserName("Updated User Name");
  //  	session.update(user);
    	
  //  	session.delete(user);
    	
    	
     	session.getTransaction().commit();
    	session.close();
       	System.out.println("User name pulled up is: "+ user.getUserName());
    	
    }

    
    
    public static void InheritanceHibernate() {
    	
    	Vehicle vehicle=new Vehicle();
    	vehicle.setVehicleName("Car");
    	
    	TwoWheeler bike = new TwoWheeler();
    	bike.setVehicleName("Bike");
    	bike.setSteeringHandle("Bike Steering Handle");
    	
    	FourWheeler car = new FourWheeler();
    	car.setVehicleName("Porshe");
    	car.setSteeringWheel("Porsh Steering Wheel");
    	
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Vehicle.class).addAnnotatedClass(FourWheeler.class).addAnnotatedClass(TwoWheeler.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	session.beginTransaction();
    	
    	session.save(vehicle);
    	session.save(bike);
    	session.save(car);
    	
     	session.getTransaction().commit();
    	session.close();
    	
    }
    
    public static void Cascade(){
    	
    	UserDetails user1 = new UserDetails();
    	user1.setUserName("First User");
    	
    	Vehicle vehicle=new Vehicle();
    	Vehicle vehicle2=new Vehicle();

    	vehicle.setVehicleName("Car");
    	vehicle2.setVehicleName("Jeep");
    	
//    	user1.getVehicle().add(vehicle);
//    	user1.getVehicle().add(vehicle2);
//    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails.class).addAnnotatedClass(Vehicle.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	session.beginTransaction();
    	
    	session.persist(user1);




    	
    	session.getTransaction().commit();
    	session.close();
    	
    }
    
    public static void oneToOne() {
    	
    	UserDetails user1 = new UserDetails();
    	user1.setUserName("First User");
    	
    	Vehicle vehicle=new Vehicle();
    	Vehicle vehicle2=new Vehicle();

    	vehicle.setVehicleName("Car");
    	vehicle2.setVehicleName("Jeep");
    	
//    	user1.getVehicle().add(vehicle);
//    	user1.getVehicle().add(vehicle2);
 //   	vehicle.getUserList().add(user1);
   // 	vehicle2.getUserList().add(user1);
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails.class).addAnnotatedClass(Vehicle.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	session.beginTransaction();
    	
    	session.save(user1);
    	session.save(vehicle);
    	session.save(vehicle2);


    	
    	session.getTransaction().commit();
    	session.close();
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
    	
//    	user1.getListOfAddresses().add(addr);
//    	user1.getListOfAddresses().add(addr2);
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	session.beginTransaction();
    	
    	
    	session.save(user1);


    	
    	session.getTransaction().commit();
    	session.close();
    	
    	user1 =null;
    	
    	session=sf.openSession();
    	user1=(UserDetails) session.get(UserDetails.class, 1);
    	session.close();
//    	System.out.println(user1.getListOfAddresses().size());
    	
    //	session.close();
    	
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
