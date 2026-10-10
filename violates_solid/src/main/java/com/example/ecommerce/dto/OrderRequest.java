package com.example.ecommerce.dto;

public class OrderRequest {
	private String customerEmail;
	private double amount;
	private String notificationChannel; // "EMAIL", "SMS", "WHATSAPP"

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getNotificationChannel() {
		return notificationChannel;
	}

	public void setNotificationChannel(String notificationChannel) {
		this.notificationChannel = notificationChannel;
	}
}