package com.flightstatisticapp;

import com.flightstatisticapp.model.Ticket;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.BufferedReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONSimpleParser {
    private String path;
    public JSONSimpleParser(String path)
    {
        this.path = path;
    }

    public List<Ticket> parse() {
        JSONParser parser = new JSONParser();


        List<Ticket> tickets = new ArrayList<Ticket>();
        try(BufferedReader bufferedReader = java.nio.file.Files.newBufferedReader(Paths.get(path));) {
            JSONObject root = (JSONObject) parser.parse(bufferedReader);
            JSONArray ticketList = (JSONArray) root.get("tickets");

            for (Object it : ticketList) {
                JSONObject obj = (JSONObject) it;
                String ticketOrigin = (String) obj.get("origin");
                String ticketOriginName = (String) obj.get("origin_name");
                String ticketDestinatoin = (String) obj.get("origin");
                String ticketDestinatoinName = (String) obj.get("origin_name");
                String ticketDepartureDate = (String) obj.get("departure_date");
                String ticketDepartureTime = (String) obj.get("departure_time");
                String ticketArrivalDate = (String) obj.get("arrival_date");
                String ticketArrivalTime = (String) obj.get("arrival_time");
                String ticketCarrier = (String) obj.get("carrier");
                int ticketStops = (int) (long) obj.get("stops");
                int ticketPrice = (int) (long) obj.get("price");

                Ticket ticket = new Ticket(ticketOrigin, ticketOriginName, ticketDestinatoin, ticketDestinatoinName,
                        ticketDepartureDate, ticketDepartureTime, ticketArrivalDate, ticketArrivalTime,
                        ticketCarrier, ticketStops, ticketPrice);
                tickets.add(ticket);
            }
        }
        catch (Exception e)
        {
            System.out.println("Parser reader error " + e.toString());
        }

        return tickets;
    }
}
