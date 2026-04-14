package com.carrentle.service;

import com.carrentle.entity.Booking;
import com.carrentle.entity.Car;
import com.carrentle.repository.BookingRepository;
import com.carrentle.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarRepository carRepository;

    public Booking bookCar(Long carId, LocalDate start, LocalDate end) {

        Car car = carRepository.findById(carId).get();

        // Double booking check
        List<Booking> bookings = bookingRepository.findByCarId(carId);

        for (Booking b : bookings) {
            if (!(end.isBefore(b.getStartDate()) || start.isAfter(b.getEndDate()))) {
                throw new RuntimeException("Car already booked!");
            }
        }

        long days = ChronoUnit.DAYS.between(start, end);
        double total = days * car.getPricePerDay();

        Booking booking = new Booking();
        booking.setCar(car);
        booking.setStartDate(start);
        booking.setEndDate(end);
        booking.setTotalPrice(total);
        booking.setStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }
}
