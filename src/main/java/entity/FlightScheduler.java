package entity;

import java.io.Serializable;

/**
 * 航班计划
 * @author windows
 *
 */
public class FlightScheduler implements Serializable{
	
	private static final long serialVersionUID = 2427165183041369292L;
	private String flightNumber;    //航班号
	private String startDate;			//开始日期
	private String endDate;			//结束日期
	private String fromCity;		//出发地机场
	private String toCity;			//到达地机场
	private String departureTime;		//离港时间
	private String arrivalTime;		//到港时间
	private String airplane;		//执行机型
	private String scheduler;		//班期
	private int sailLength;		//航程
	private double basicPrice;		//基本票价
	private String fromAirportName;
	private String toAirportName;
	
	public FlightScheduler() {}
	
	public FlightScheduler(String flightNumber,String startDate, String endDate, String fromCity, String toCity, String departureTime,
			String arrivalTime, String airplane, String scheduler, int sailLength, double basicPrice) {
		super();
		this.flightNumber = flightNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.airplane = airplane;
		this.scheduler = scheduler;
		this.sailLength = sailLength;
		this.basicPrice = basicPrice;
	}

	public FlightScheduler(String flightNumber, String startDate, String endDate, String fromCity, String toCity,
			String departureTime, String arrivalTime, String airplane, String scheduler, int sailLength,
			double basicPrice, String fromAirportName, String toAirportName) {
		super();
		this.flightNumber = flightNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.airplane = airplane;
		this.scheduler = scheduler;
		this.sailLength = sailLength;
		this.basicPrice = basicPrice;
		this.fromAirportName = fromAirportName;
		this.toAirportName = toAirportName;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getstartDate() {
		return startDate;
	}

	public void setstartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getendDate() {
		return endDate;
	}

	public void setendDate(String endDate) {
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

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
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

	public int getSailLength() {
		return sailLength;
	}

	public void setSailLength(int sailLength) {
		this.sailLength = sailLength;
	}

	public double getBasicPrice() {
		return basicPrice;
	}

	public void setBasicPrice(double basicPrice) {
		this.basicPrice = basicPrice;
	}

	public String getFromAirportName() {
		return fromAirportName;
	}

	public void setFromAirportName(String fromAirportName) {
		this.fromAirportName = fromAirportName;
	}

	public String getToAirportName() {
		return toAirportName;
	}

	public void setToAirportName(String toAirportName) {
		this.toAirportName = toAirportName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((fromAirportName == null) ? 0 : fromAirportName.hashCode());
		result = prime * result + ((fromCity == null) ? 0 : fromCity.hashCode());
		temp = Double.doubleToLongBits(sailLength);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((scheduler == null) ? 0 : scheduler.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((toAirportName == null) ? 0 : toAirportName.hashCode());
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
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (fromAirportName == null) {
			if (other.fromAirportName != null)
				return false;
		} else if (!fromAirportName.equals(other.fromAirportName))
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
		if (toAirportName == null) {
			if (other.toAirportName != null)
				return false;
		} else if (!toAirportName.equals(other.toAirportName))
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
		return "FlightScheduler [flightNumber=" + flightNumber + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", fromCity=" + fromCity + ", toCity=" + toCity + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", airplane=" + airplane + ", scheduler=" + scheduler
				+ ", sailLength=" + sailLength + ", basicPrice=" + basicPrice + ", fromAirportName=" + fromAirportName
				+ ", toAirportName=" + toAirportName + "]";
	}
	
}