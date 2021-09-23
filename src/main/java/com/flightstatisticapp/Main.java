package com.flightstatisticapp;

import com.flightstatisticapp.model.Ticket;

import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        JSONSimpleParser parser = null;
        try
        {
             parser = new JSONSimpleParser(args[0]);
        }
        catch (Exception e)
        {
            System.out.println("Введите путь до файла " + e.toString());
        }
        List<Ticket> tickets = parser.parse();
        FlightStatistic statistic = new FlightStatistic(tickets);
        System.out.println("Mean time: " + statistic.getMeanFlightTime() + " minutes");
        System.out.println("Procentil 90%: " + statistic.getPercentile(90));
    }

}
