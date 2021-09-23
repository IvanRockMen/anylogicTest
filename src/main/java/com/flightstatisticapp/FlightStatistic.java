package com.flightstatisticapp;

import com.flightstatisticapp.model.Ticket;
import org.apache.commons.math.stat.descriptive.rank.Percentile;

import java.util.List;

public class FlightStatistic {
    List<Ticket> tickets;
    public FlightStatistic(List<Ticket> tickets)
    {
        this.tickets = tickets;
    }

    public float getMeanFlightTime()
    {
        float mean = 0;
        for(Ticket ticket: tickets)
        {
            mean += (float) ticket.getFlightTime();
        }
        mean /= tickets.size();

        return mean;
    }

    public double getPercentile(double percent)
    {
        double[] flightTimes = new double[tickets.size()];
        int c = 0;
        for(Ticket ticket: tickets)
        {
            flightTimes[c] = (double) ticket.getFlightTime();
            c+=1;
        }
        double percentill = new Percentile().evaluate(flightTimes, percent);
        return percentill;

    }

}
