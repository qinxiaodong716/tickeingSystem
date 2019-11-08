package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 航班计划
 * @author windows
 *
 */
public class FlightScheduler implements Serializable{
	
	private static final long serialVersionUID = 2427165183041369292L;
	private String fightNumber;
	private Date startDate;
	private Date endDate;
	private String fromCity;
	private String toCity;
	private Date departureTime;
	private Date arrivalTime;
	private String airplane;
	private String scheduler;
	private double sailLength;
	private double basicPrice;
	
	
	public FlightScheduler() {}


	public FlightScheduler(String fightNumber, Date startDate, Date endDate, String fromCity, String toCity,
			Date departureTime, Date arrivalTime, String airplane, String scheduler, double sailLength, double basicPrice) {
		super();
		this.fightNumber = fightNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.airplane = airplane;
		this.scheduler = scheduler;
		this.sailLength = sailLength;
		this.setBasicPrice(basicPrice);
	}


	public String getFightNumber() {
		return fightNumber;
	}


	public void setFightNumber(String fightNumber) {
		this.fightNumber = fightNumber;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getFromCity() {
		return fromCity;
	}


	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}


	public String getToCity() {
		return toCity;
	}


	public void setToCity(String toCity) {
		this.toCity = toCity;
	}


	public Date getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}


	public Date getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public String getAirplane() {
		return airplane;
	}


	public void setAirplane(String airplane) {
		this.airplane = airplane;
	}


	public String getScheduler() {
		return scheduler;
	}


	public void setScheduler(String scheduler) {
		this.scheduler = scheduler;
	}


	public double getSailLength() {
		return sailLength;
	}


	public void setSailLength(double sailLength) {
		this.sailLength = sailLength;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airplane == null) ? 0 : airplane.hashCode());
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		long temp;
		temp = Double.doubleToLongBits(basicPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((fightNumber == null) ? 0 : fightNumber.hashCode());
		result = prime * result + ((fromCity == null) ? 0 : fromCity.hashCode());
		temp = Double.doubleToLongBits(sailLength);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((scheduler == null) ? 0 : scheduler.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((toCity == null) ? 0 : toCity.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightScheduler other = (FlightScheduler) obj;
		if (airplane == null) {
			if (other.airplane != null)
				return false;
		} else if (!airplane.equals(other.airplane))
			return false;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		if (Double.doubleToLongBits(basicPrice) != Double.doubleToLongBits(other.basicPrice))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (fightNumber == null) {
			if (other.fightNumber != null)
				return false;
		} else if (!fightNumber.equals(other.fightNumber))
			return false;
		if (fromCity == null) {
			if (other.fromCity != null)
				return false;
		} else if (!fromCity.equals(other.fromCity))
			return false;
		if (Double.doubleToLongBits(sailLength) != Double.doubleToLongBits(other.sailLength))
			return false;
		if (scheduler == null) {
			if (other.scheduler != null)
				return false;
		} else if (!scheduler.equals(other.scheduler))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (toCity == null) {
			if (other.toCity != null)
				return false;
		} else if (!toCity.equals(other.toCity))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "FlightScheduler [fightNumber=" + fightNumber + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", fromCity=" + fromCity + ", toCity=" + toCity + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", airplane=" + airplane + ", scheduler=" + scheduler
				+ ", sailLength=" + sailLength + ", basicPrice=" + basicPrice + "]";
	}


	public double getBasicPrice() {
		return basicPrice;
	}


	public void setBasicPrice(double basicPrice) {
		this.basicPrice = basicPrice;
	}


}