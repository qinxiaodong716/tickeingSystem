package entity;

import java.io.Serializable;
/**
 * 订单 
 * @author windows
 *
 */
public class Order implements Serializable{
	private static final long serialVersionUID = 2427165183041369292L;
	private int orderId;
	private double price;
	private String status;
	private String operatorPhone;
	private int flightId; 
	private String flightNumber;
	private String departureDate;
	private int ticketOrderId; 
	private String passengerName;
	private String certificationNumber;
	private String orderDate;
	private String level;
	private String passengerType;
	private String fromCity;
	private String toCity;
	private String departureTime;
	private String arrivalTime;
	private int sailLength;
	private String airplane;
	
	public Order() {
		super();
	}

	public Order(int orderId, double price, String status, String operatorPhone, int flightId, String flightNumber,
			String departureDate, int ticketOrderId, String passengerName, String certificationNumber, String orderDate,
			String level, String passengerType, String fromCity, String toCity, String departureTime,
			String arrivalTime, int sailLength, String airplane) {
		super();
		this.orderId = orderId;
		this.price = price;
		this.status = status;
		this.operatorPhone = operatorPhone;
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.departureDate = departureDate;
		this.ticketOrderId = ticketOrderId;
		this.passengerName = passengerName;
		this.certificationNumber = certificationNumber;
		this.orderDate = orderDate;
		this.level = level;
		this.passengerType = passengerType;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.sailLength = sailLength;
		this.airplane = airplane;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOperatorPhone() {
		return operatorPhone;
	}

	public void setOperatorPhone(String operatorPhone) {
		this.operatorPhone = operatorPhone;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public int getTicketOrderId() {
		return ticketOrderId;
	}

	public void setTicketOrderId(int ticketOrderId) {
		this.ticketOrderId = ticketOrderId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getCertificationNumber() {
		return certificationNumber;
	}

	public void setCertificationNumber(String certificationNumber) {
		this.certificationNumber = certificationNumber;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
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

	public int getSailLength() {
		return sailLength;
	}

	public void setSailLength(int sailLength) {
		this.sailLength = sailLength;
	}

	public String getAirplane() {
		return airplane;
	}

	public void setAirplane(String airplane) {
		this.airplane = airplane;
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
		result = prime * result + ((certificationNumber == null) ? 0 : certificationNumber.hashCode());
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + flightId;
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((fromCity == null) ? 0 : fromCity.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((operatorPhone == null) ? 0 : operatorPhone.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + orderId;
		result = prime * result + ((passengerName == null) ? 0 : passengerName.hashCode());
		result = prime * result + ((passengerType == null) ? 0 : passengerType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sailLength;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ticketOrderId;
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
		Order other = (Order) obj;
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
		if (certificationNumber == null) {
			if (other.certificationNumber != null)
				return false;
		} else if (!certificationNumber.equals(other.certificationNumber))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (flightId != other.flightId)
			return false;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (fromCity == null) {
			if (other.fromCity != null)
				return false;
		} else if (!fromCity.equals(other.fromCity))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (operatorPhone == null) {
			if (other.operatorPhone != null)
				return false;
		} else if (!operatorPhone.equals(other.operatorPhone))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId != other.orderId)
			return false;
		if (passengerName == null) {
			if (other.passengerName != null)
				return false;
		} else if (!passengerName.equals(other.passengerName))
			return false;
		if (passengerType == null) {
			if (other.passengerType != null)
				return false;
		} else if (!passengerType.equals(other.passengerType))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (sailLength != other.sailLength)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (ticketOrderId != other.ticketOrderId)
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
		return "Order [orderId=" + orderId + ", price=" + price + ", status=" + status + ", operatorPhone="
				+ operatorPhone + ", flightId=" + flightId + ", flightNumber=" + flightNumber + ", departureDate="
				+ departureDate + ", ticketOrderId=" + ticketOrderId + ", passengerName=" + passengerName
				+ ", certificationNumber=" + certificationNumber + ", orderDate=" + orderDate + ", level=" + level
				+ ", passengerType=" + passengerType + ", fromCity=" + fromCity + ", toCity=" + toCity
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", sailLength=" + sailLength
				+ ", airplane=" + airplane + "]";
	}
	
}
