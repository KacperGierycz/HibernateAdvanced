package AdvanceHibernate.Hibernate2;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(
//		name="VEHICLE_TYPE",
//		discriminatorType=DiscriminatorType.STRING
//		)
public class Vehicle {
	
	@Id @GeneratedValue(strategy=GenerationType.TABLE)
	private int vehicleId;
	private String vehicleName;
	

//	@ManyToMany(mappedBy="vehicle")
//	private Collection<UserDetails> userList = new ArrayList();
	
//	@ManyToOne
//	@NotFound(action=NotFoundAction.IGNORE)
//	private UserDetail user;
	
	
//	@ManyToOne
//	@JoinColumn(name="USER_ID")
//	private UserDetails user;
	
	
//public Collection<UserDetails> getUserList() {
//		return userList;
//	}
//	public void setUserList(Collection<UserDetails> userList) {
//		this.userList = userList;
//	}
	//	public UserDetails getUser() {
//		return user;
//	}
//	public void setUser(UserDetails user) {
//		this.user = user;
//	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	

	
	
}
