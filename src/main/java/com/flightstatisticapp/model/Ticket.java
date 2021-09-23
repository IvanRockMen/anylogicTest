package com.flightstatisticapp.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.time.Duration;

public class Ticket {
    private String origin;
    private String origin_name;
    private String destenation;
    private String destenation_name;
    private String departure_date;
    private String departure_time;
    private String arrival_date;
    private String arrival_time;
    private String carrier;
    private int stops;
    private int price;

    public Ticket(String origin, String origin_name, String destenation, String destenation_name,
                  String departure_date, String departure_time, String arrival_date, String arrival_time,
                  String carrier, int stops, int price)
    {
        this.origin = origin;
        this.origin_name = origin_name;
        this.destenation = destenation;
        this.destenation_name = destenation_name;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.arrival_date = arrival_date;
        this.arrival_time = arrival_time;
        this.carrier = carrier;
        this.stops = stops;
        this.price = price;
    }

    public int getFlightTime()
    {
        String[] spliteded_departure_time = this.departure_time.split(":");
        int departureHour = Integer.parseInt(spliteded_departure_time[0]);
        int departureMinute = Integer.parseInt(spliteded_departure_time[1]);
        String[] spliteded_departure_date = this.departure_date.split("\\.");
        int departureDay = Integer.parseInt(spliteded_departure_date[0]);
        int departureMonth = Integer.parseInt(spliteded_departure_date[1]);
        int departureYear = Integer.parseInt(spliteded_departure_date[2]);
        Calendar departureCalendar = new GregorianCalendar(departureYear, departureMonth, departureDay,
                departureHour, departureMinute, 0);
        String[] splited_arrival_time = this.arrival_time.split(":");
        int arrivalHour = Integer.parseInt(splited_arrival_time[0]);
        int arrivalMinute = Integer.parseInt(splited_arrival_time[1]);
        String[] splited_arrival_date = this.arrival_date.split("\\.");
        int arrivalDay = Integer.parseInt(splited_arrival_date[0]);
        int arrivalMonth = Integer.parseInt(splited_arrival_date[1]);
        int arrivalYear = Integer.parseInt(splited_arrival_date[2]);
        Calendar arrivalCalendar = new GregorianCalendar(arrivalYear, arrivalMonth, arrivalDay,
                arrivalHour, arrivalMinute, 0);
        int time = (int) Duration.between(departureCalendar.toInstant(), arrivalCalendar.toInstant()).toMinutes();
        return time;
    }

    @Override
    public String toString()
    {
        return "Ticket{" +
                "origin='" + origin + "'" +
                "origin_name='" + origin_name + "'" +
                "destination='" + destenation + "'" +
                "destination_name='" + destenation_name + "'" +
                "departure_date='" + departure_date + "'" +
                "departure_time='" + departure_time + "'" +
                "arrival_date='" + arrival_date + "'" +
                "arrival_time='" + arrival_time + "'" +
                "carrier='" + carrier + "'" +
                "stops=" + stops +
                "price=" + price +
                "}";
    }

}
