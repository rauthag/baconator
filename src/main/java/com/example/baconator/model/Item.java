package com.example.baconator.model;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.Instant;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Item {

  private final UUID runId;
  private String start_ms;
  private String end_ms;
  private String duration;
  private List<BaconData> items = new ArrayList<>();

  public Item() {
    this.runId = UUID.randomUUID();
  }

  public void AddBaconData(int howMuch){
    Timestamp startTS = new Timestamp(System.currentTimeMillis());
    Instant startIn = startTS.toInstant();
    this.start_ms = startIn.toEpochMilli() + " ms";


    for(int i = 0; i < howMuch; i++){
      this.items.add(new BaconData());
    }

    Timestamp endTS = new Timestamp(System.currentTimeMillis());
    Instant endIn = endTS.toInstant();
    this.end_ms = endIn.toEpochMilli() + " ms";

    long durationLong = ChronoUnit.MILLIS.between(
            startIn.atZone(ZoneId.systemDefault()),
            endIn.atZone(ZoneId.systemDefault()));
    this.duration = durationLong + " ms";
  }

  public UUID getRunId() {
    return runId;
  }

  public List<BaconData> getItems() {
    return items;
  }

  public String getEnd_ms() {
    return end_ms;
  }

  public String getStart_ms() {
    return start_ms;
  }

  public String getDuration() {return duration; }
}


