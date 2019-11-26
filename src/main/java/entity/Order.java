package entity;

import java.io.Serializable;
/**
 * 订单 
 * @author windows
 *
 */
public class Order implements Serializable{
	private static final long serialVersionUID = 2427165183041369292L;
	private long orderId;        				 //订单号
	private double price;						 //金额				3
	private String status;						 //订单状态			4
	private String salesName;				 	 //操作人
	private String flightNumber;				 //航班号			
	private String departureDate;				 //出发日期
	private int ticketOrderId; 					 //机票编号                   2
	private String passengerName;				 //乘客姓名
	private String certificationNumber;			 //乘客证件
	private String orderDate;					 //订单日期			6
	private String level;						 //舱位等级
	private String passengerType;    			 //乘客类型			
	private int operatorType;    			 //操作人类型			7
	private String fromCity;					 //出发地
	private String fromAirportName;					 //出发机场
	private String toCity;						 //到达地
	private String toAirportName;						 //到达机场
	private String departureTime;				 //出发时间
	private String arrivalTime;					 //到达时间
	private int sailLength;						 //航程
	private String airplane;					 //机型
	private String branchName;					 //售票点
	private String operatorPhone;				//操作人电话			1
	private	String linkmanName;					//联系人				8
	private String linkmanPhone;				//联系人电话        		 9
	public Order() {
		super();
	}
	public Order(double price, String status, String flightNumber ,
			int operatorType, String operatorPhone, String linkmanName, String linkmanPhone) {
		super();
		this.price = price;
		this.status = status;
		this.flightNumber = flightNumber;
		this.operatorType = operatorType;
		this.operatorPhone = operatorPhone;
		this.linkmanName = linkmanName;
		this.linkmanPhone = linkmanPhone;
	}
	public Order(long orderId, double price, String status, String salesName, String flightNumber, String departureDate,
			int ticketOrderId, String passengerName, String certificationNumber, String orderDate, String level,
			String passengerType, int operatorType, String fromCity, String fromAirportName, String toCity, String toAirportName,
			String departureTime, String arrivalTime, int sailLength, String airplane, String branchName,
			String operatorPhone, String linkmanName, String linkmanPhone) {
		super();
		this.orderId = orderId;
		this.price = price;
		this.status = status;
		this.salesName = salesName;
		this.flightNumber = flightNumber;
		this.departureDate = departureDate;
		this.ticketOrderId = ticketOrderId;
		this.passengerName = passengerName;
		this.certificationNumber = certificationNumber;
		this.orderDate = orderDate;
		this.level = level;
		this.passengerType = passengerType;
		this.operatorType = operatorType;
		this.fromCity = fromCity;
		this.fromAirportName = fromAirportName;
		this.toCity = toCity;
		this.toAirportName = toAirportName;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.sailLength = sailLength;
		this.airplane = airplane;
		this.branchName = branchName;
		this.operatorPhone = operatorPhone;
		this.linkmanName = linkmanName;
		this.linkmanPhone = linkmanPhone;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
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
	public String getSalesName() {
		return salesName;
	}
	public void setSalesName(String salesName) {
		this.salesName = salesName;
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
	public int getOperatorType() {
		return operatorType;
	}
	public void setOperatorType(int operatorType) {
		this.operatorType = operatorType;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getfromAirportName() {
		return fromAirportName;
	}
	public void setfromAirportName(String fromAirportName) {
		this.fromAirportName = fromAirportName;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String gettoAirportName() {
		return toAirportName;
	}
	public void settoAirportName(String toAirportName) {
		this.toAirportName = toAirportName;
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
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getOperatorPhone() {
		return operatorPhone;
	}
	public void setOperatorPhone(String operatorPhone) {
		this.operatorPhone = operatorPhone;
	}
	public String getlinkmanName() {
		return linkmanName;
	}
	public void setlinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}
	public String getLinkmanPhone() {
		return linkmanPhone;
	}
	public void setLinkmanPhone(String linkmanPhone) {
		this.linkmanPhone = linkmanPhone;
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
		result = prime * result + ((branchName == null) ? 0 : branchName.hashCode());
		result = prime * result + ((certificationNumber == null) ? 0 : certificationNumber.hashCode());
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((fromCity == null) ? 0 : fromCity.hashCode());
		result = prime * result + ((fromAirportName == null) ? 0 : fromAirportName.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((linkmanName == null) ? 0 : linkmanName.hashCode());
		result = prime * result + ((linkmanPhone == null) ? 0 : linkmanPhone.hashCode());
		result = prime * result + ((operatorPhone == null) ? 0 : operatorPhone.hashCode());
		result = prime * result + operatorType;
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		result = prime * result + ((passengerName == null) ? 0 : passengerName.hashCode());
		result = prime * result + ((passengerType == null) ? 0 : passengerType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sailLength;
		result = prime * result + ((salesName == null) ? 0 : salesName.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ticketOrderId;
		result = prime * result + ((toCity == null) ? 0 : toCity.hashCode());
		result = prime * result + ((toAirportName == null) ? 0 : toAirportName.hashCode());
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
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
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
		if (fromAirportName == null) {
			if (other.fromAirportName != null)
				return false;
		} else if (!fromAirportName.equals(other.fromAirportName))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (linkmanName == null) {
			if (other.linkmanName != null)
				return false;
		} else if (!linkmanName.equals(other.linkmanName))
			return false;
		if (linkmanPhone == null) {
			if (other.linkmanPhone != null)
				return false;
		} else if (!linkmanPhone.equals(other.linkmanPhone))
			return false;
		if (operatorPhone == null) {
			if (other.operatorPhone != null)
				return false;
		} else if (!operatorPhone.equals(other.operatorPhone))
			return false;
		if (operatorType != other.operatorType)
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
		if (salesName == null) {
			if (other.salesName != null)
				return false;
		} else if (!salesName.equals(other.salesName))
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
		if (toAirportName == null) {
			if (other.toAirportName != null)
				return false;
		} else if (!toAirportName.equals(other.toAirportName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", price=" + price + ", status=" + status + ", salesName=" + salesName
				+ ", flightNumber=" + flightNumber + ", departureDate=" + departureDate + ", ticketOrderId="
				+ ticketOrderId + ", passengerName=" + passengerName + ", certificationNumber=" + certificationNumber
				+ ", orderDate=" + orderDate + ", level=" + level + ", passengerType=" + passengerType
				+ ", operatorType=" + operatorType + ", fromCity=" + fromCity + ", fromAirportName=" + fromAirportName + ", toCity="
				+ toCity + ", toAirportName=" + toAirportName + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", sailLength=" + sailLength + ", airplane=" + airplane + ", branchName=" + branchName
				+ ", operatorPhone=" + operatorPhone + ", linkmanName=" + linkmanName + ", linkmanPhone=" + linkmanPhone
				+ "]";
	}
	
}
