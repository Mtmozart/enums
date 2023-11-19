package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.status.OrderStatus1;

public class Order1 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus1 status;
	private Client client;
	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	public Order1() {
	}

	public Order1(Date moment, OrderStatus1 status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus1 getStatus() {
		return status;
	}

	public void setStatus(OrderStatus1 status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void AddItem(OrderItem item) {
		items.add(item);
	}
	
	public void AddRemove(OrderItem item) {
		items.remove(item);
	}

	public double total() {
		double sum = 0.0;
		for(OrderItem it : items) {
			//sum += it.subTotal();
			sum = sum + it.subTotal();
			
		}
		return sum;
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}	


	
	
	

	
}
