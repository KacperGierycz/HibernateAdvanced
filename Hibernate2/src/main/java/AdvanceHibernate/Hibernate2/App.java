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
    //	setOfAddresses();
    //	oneToOne();
    //	Cascade();
    	InheritanceHibernate();
    	
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
    	
    	user1.getVehicle().add(vehicle);
    	user1.getVehicle().add(vehicle2);
    	
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
    	
    	user1.getVehicle().add(vehicle);
    	user1.getVehicle().add(vehicle2);
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
