package com.decolar.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.decolar.model.Booking;
import com.decolar.service.BookingService;

import jakarta.websocket.server.PathParam;

@Controller
public class BookingController {

	private final BookingService bookingService;

	public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@GetMapping("/form")
	public String viewForm() {
		return "reservationForm.html";
	}

	@GetMapping("/form/{id}")
	public String viewEditForm(@PathVariable("id") Long id, Model model) {
		Booking retrievedBooking = bookingService.findById(id);
		model.addAttribute("retrievedBooking", retrievedBooking);
		return "editReservationForm.html";
	}

	@PostMapping("/form")
	public String submitForm(@RequestParam String reservationClient, @RequestParam String reservationEmployee,
			@RequestParam LocalDate checkIn, @RequestParam LocalDate checkOut, Model model) {
		if (!isValidDates(checkIn, checkOut)) {
			model.addAttribute("message", "Datas Invalidas!");
			return "reservationForm.html";
		}
		Booking booking = new Booking(null, checkIn, checkOut, reservationClient, reservationEmployee);
		bookingService.saveBooking(booking);
		return "redirect:/table";
	}

	@PostMapping("/form/{id}")
	public String submitEditForm(@RequestParam Long id, @RequestParam String reservationClient,
			@RequestParam String reservationEmployee, @RequestParam LocalDate checkIn, @RequestParam LocalDate checkOut,
			Model model) {
		if (!isValidDates(checkIn, checkOut)) {
			model.addAttribute("message", "Datas Invalidas!");
			return "redirect:/form/"+ id;
		}
		Booking booking = new Booking(id, checkIn, checkOut, reservationClient, reservationEmployee);
		bookingService.saveBooking(booking);
		return "redirect:/table";
	}

	public boolean isValidDates(LocalDate checkIn, LocalDate checkOut) {
		if (checkIn.isAfter(checkOut) || checkIn.equals(checkOut)) {
			return false;
		}
		return true;
	}

}
