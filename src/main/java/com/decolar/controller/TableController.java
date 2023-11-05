package com.decolar.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.decolar.model.Booking;
import com.decolar.service.BookingService;

@Controller
public class TableController {

	private final BookingService bookingService;
	
	public TableController(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@GetMapping("/table")
	public String viewTable(Model model) {
		List<String> headers = Arrays.asList("ID",  "Name of the Client", "Employee Responsible", "Check In Date", "Check Out Date", "Action");
		List<Booking> bookings = bookingService.findAll();
		model.addAttribute("headers", headers);
		model.addAttribute("bookings", bookings);
		return "reservationTable.html";
	}
}
