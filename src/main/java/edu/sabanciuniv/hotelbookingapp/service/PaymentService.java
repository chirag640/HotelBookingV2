package edu.sabanciuniv.hotelbookingapp.service;

import com.paypal.base.rest.PayPalRESTException;

import edu.sabanciuniv.hotelbookingapp.model.Booking;
import edu.sabanciuniv.hotelbookingapp.model.Payment;
import edu.sabanciuniv.hotelbookingapp.model.dto.BookingInitiationDTO;

public interface PaymentService {

    Payment savePayment(BookingInitiationDTO bookingInitiationDTO, Booking booking);

    com.paypal.api.payments.Payment createPayment(Double total,
			String currency,
			String Method,
			String intent,
			String description,
			String cancelUrl,
			String successUrl) throws PayPalRESTException;
     
    com.paypal.api.payments.Payment excecutePayment(String paymentId, String payerId) throws PayPalRESTException;
	
    
}
