package com.decolar;


import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.decolar.model.Booking;
import com.decolar.repository.BookingRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public void run(String... args) throws Exception {
		Booking b1 = new Booking(null, LocalDate.of(2023, 12, 21), LocalDate.of(2023, 12, 24), "jonas", "raul");
		Booking b2 = new Booking(null, LocalDate.of(2023, 9, 11), LocalDate.of(2023, 9, 13), "pedro", "raul");
		Booking b3 = new Booking(null, LocalDate.of(2023, 10, 12), LocalDate.of(2023, 10, 19), "paulo", "fernando");
		Booking b4 = new Booking(null, LocalDate.of(2023, 11, 05), LocalDate.of(2023, 11, 27), "mathias", "fernando");
		
		bookingRepository.saveAll(Arrays.asList(b1,b2,b3,b4));
		
	}
	
	
}
