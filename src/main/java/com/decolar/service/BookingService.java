package com.decolar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.decolar.model.Booking;
import com.decolar.repository.BookingRepository;

@Service
public class BookingService {
	
	private final BookingRepository bookingRepository;
	
	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	public Booking saveBooking(Booking booking) {
		bookingRepository.save(booking);
		return booking;
	}
	
	public List<Booking> findAll(){
		return bookingRepository.findAll();
	}
	
	public Booking findById(Long id) {
		return bookingRepository.findById(id).get();
	}
}
