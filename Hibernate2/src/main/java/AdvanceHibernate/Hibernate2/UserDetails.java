package AdvanceHibernate.Hibernate2;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.SelectBeforeUpdate
//@Table( name = "USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String userName;
	
//	@OneToMany(cascade=CascadeType.PERSIST)
//	private Collection<Vehicle> vehicle=new ArrayList();
	
	
	
	
	
//	@ManyToMany
//	private Collection<Vehicle> vehicle=new ArrayList();
	
//	@OneToMany(mappedBy="user")
//	@JoinTable(name="USER_VEHICLE", joinColumns = @JoinColumn(name="USER_ID"),
//		inverseJoinColumns=@JoinColumn(name="VECHICLE_ID"))
//	private Collection<Vehicle> vehicle=new ArrayList();
	
//	@JoinColumn(name="VEHICLE_ID")
//	private Vehicle vehicle;
	
	
//	@ElementCollection(fetch=FetchType.EAGER)
//	@JoinTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
//	@GenericGenerator(name="hilo-gen",strategy="increment")
//	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type="long"))
//	private Collection<Address>listOfAddresses= new ArrayList();
	
	
	
	
	
	
	
	
	
//	@Embedded
//	@AttributeOverrides({
//	@AttributeOverride(name="street", column=@Column(name="HOME_STREET_NAME")),
//	@AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),
//	@AttributeOverride(name="state", column=@Column(name="HOME_STATE_NAME")),
//	@AttributeOverride(name="pincode", column=@Column(name="HOME_PINCODE_NAME"))
//	})
//	private Address homeAddress;
//	@Embedded
//	private Address officeAddress;
	
	
//	@Temporal( TemporalType.DATE)
//	private Date joinDate;
//	private String Address;
//	@Lob
//	private String description;



//public Collection<Vehicle> getVehicle() {
//		return vehicle;
//	}
//	public void setVehicle(Collection<Vehicle> vehicle) {
//		this.vehicle = vehicle;
//	}
	//	public Vehicle getVehicle() {
//		return vehicle;
//	}
//	public void setVehicle(Vehicle vehicle) {
//		this.vehicle = vehicle;
//	}
	public int getUserId() {
		return userId;
	}
//public Collection<Address> getListOfAddresses() {
//		return listOfAddresses;
//	}
//	public void setListOfAddresses(Collection<Address> listOfAddresses) {
//		this.listOfAddresses = listOfAddresses;
//	}
	//	public Address getHomeAddress() {
//		return homeAddress;
//	}
//	public void setHomeAddress(Address homeAddress) {
//		this.homeAddress = homeAddress;
//	}
//	public Address getOfficeAddress() {
//		return officeAddress;
//	}
//	public void setOfficeAddress(Address officeAddress) {
//		this.officeAddress = officeAddress;
//	}
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
