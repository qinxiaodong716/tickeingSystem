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
	private int ticketOrderId;
	private double price;
	private String status;
	private String flightNumber;
	
	public Order() {}
	
	
	public Order(int ticketOrderId, double price, String status, String flightNumber) {
		super();
		this.ticketOrderId = ticketOrderId;
		this.price = price;
		this.status = status;
		this.flightNumber = flightNumber;
	}


	public Order(int orderId, int ticketOrderId, double price, String status, String flightNumber) {
		super();
		this.orderId = orderId;
		this.ticketOrderId = ticketOrderId;
		this.price = price;
		this.status = status;
		this.flightNumber = flightNumber;
	}

	

	

	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getTicketOrderId() {
		return ticketOrderId;
	}


	public void setTicketOrderId(int ticketOrderId) {
		this.ticketOrderId = ticketOrderId;
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


	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + orderId;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ticketOrderId;
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
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (orderId != other.orderId)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (ticketOrderId != other.ticketOrderId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", ticketOrderId=" + ticketOrderId + ", price=" + price + ", status="
				+ status + ", flightNumber=" + flightNumber + "]";
	}
	
	
}
