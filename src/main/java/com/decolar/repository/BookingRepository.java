package com.decolar.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.decolar.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long >{

	

}
