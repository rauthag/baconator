package com.example.baconator.model;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class BaconData {
    private final UUID id;
    private String start_ms;
    private String end_ms;
    private String duration;


    public BaconData() {
        this.id = UUID.randomUUID();
        String data = getData();
    }

    public UUID getId() {
        return id;
    }


    public String getData(){
        Timestamp startTS = new Timestamp(System.currentTimeMillis());
        Instant startIn = startTS.toInstant();
        this.start_ms = startIn.toEpochMilli() + " ms";
        long durationLong;

        var client = HttpClient.newHttpClient();
        String data = null;

        var httpRequest =
                HttpRequest.newBuilder()
                        .uri(java.net.URI.create(String.format("https://baconipsum.com/api/?type=all-meat&paras=1")))
                        .GET()
                        .build();

        try {
            var response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            data = response.body();

            if(data.toLowerCase().contains("bacon".toLowerCase())){
                data = response.body();

                Timestamp endTS = new Timestamp(System.currentTimeMillis());
                Instant endIn = endTS.toInstant();
                this.end_ms = endIn.toEpochMilli() + " ms";

                durationLong = ChronoUnit.MILLIS.between(
                        startIn.atZone(ZoneId.systemDefault()),
                        endIn.atZone(ZoneId.systemDefault()));

                this.duration = durationLong + " ms";

                System.out.println(data);
            } else{
                data=getData();

                Timestamp endTS = new Timestamp(System.currentTimeMillis());
                Instant endIn = endTS.toInstant();

                durationLong = ChronoUnit.MILLIS.between(
                        startIn.atZone(ZoneId.systemDefault()),
                        endIn.atZone(ZoneId.systemDefault()));

                this.duration = durationLong + " ms";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return data;
    }

    public String getEnd_ms() {
        return end_ms;
    }

    public String getDuration() {
        return duration;
    }

    public String getStart_ms() {
        return start_ms;
    }
}



