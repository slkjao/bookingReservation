package com.decolar.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private String reservationClient;
	private String reservationEmployee;
	
	

	public Booking() {
	}

	public Booking(Long id, LocalDate checkIn, LocalDate checkOut, String reservationClient,
			String reservationEmployee) {
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.reservationClient = reservationClient;
		this.reservationEmployee = reservationEmployee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public String getReservationClient() {
		return reservationClient;
	}

	public void setReservationClient(String reservationClient) {
		this.reservationClient = reservationClient;
	}

	public String getReservationEmployee() {
		return reservationEmployee;
	}

	public void setReservationEmployee(String reservationEmployee) {
		this.reservationEmployee = reservationEmployee;
	}

}
