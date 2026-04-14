package com.carrentle.controller;

import com.carrentle.dto.BookingRequest;
import com.carrentle.entity.Booking;
import com.carrentle.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking bookCar(@RequestBody BookingRequest request) {
        return bookingService.bookCar(
                request.getCarId(),
                request.getStartDate(),
                request.getEndDate()
        );
    }
}