package AdvanceHibernate.Hibernate2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehicle {
	
	@Id @GeneratedValue
	private int vehicleId;
	private String vehivleName;
	
	
	
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
