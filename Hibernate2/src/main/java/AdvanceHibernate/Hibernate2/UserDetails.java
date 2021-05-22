package AdvanceHibernate.Hibernate2;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
//	@Temporal( TemporalType.DATE)
//	private Date joinDate;
//	private String Address;
//	@Lob
//	private String description;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
//	public Date getJoinDate() {
//		return joinDate;
//	}
//	public void setJoinDate(Date joinDate) {
//		this.joinDate = joinDate;
//	}
//	public String getAddress() {
//		return Address;
//	}
//	public void setAddress(String address) {
//		Address = address;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}

	
	
}
