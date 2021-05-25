package AdvanceHibernate.Hibernate2;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Vehicle {
	
	@Id @GeneratedValue
	private int vehicleId;
	private String vehivleName;
	

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
	public String getVehivleName() {
		return vehivleName;
	}
	public void setVehivleName(String vehivleName) {
		this.vehivleName = vehivleName;
	}
	

	
	
}
