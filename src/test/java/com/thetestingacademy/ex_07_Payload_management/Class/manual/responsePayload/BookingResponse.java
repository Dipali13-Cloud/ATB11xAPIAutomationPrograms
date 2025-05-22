package com.thetestingacademy.ex_07_Payload_management.Class.manual.responsePayload;

import com.thetestingacademy.ex_07_Payload_management.Class.manual.requestPayload.Booking;

public class BookingResponse {

    private Integer bookingid;
    private Booking booking;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
