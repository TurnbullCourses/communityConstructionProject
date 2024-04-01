package edu.ithaca.dturnbull.bank;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class Project {
    //
    private String name;
    private Integer id;
    private double price;
    private LocalDateTime completionDate;
    private LocalDateTime operatingHoursStart;
    private LocalDateTime operatingHoursEnd;


public Project(String name, Integer id, double price, LocalDateTime completionDate, LocalDateTime operatingHoursStart, LocalDateTime operatingHoursEnd){
    this.name = name;
    this.id = id;
    this.price= price;
    this.completionDate = completionDate;
    this.operatingHoursStart = operatingHoursStart;
    this.operatingHoursEnd = operatingHoursEnd;
}

public int getProjectId() {
    return id;
}

public String getName() {
    return name;
}

public double getPrice() {
    return price;
}

public LocalDateTime getCompletionDate() {
    return completionDate;
}

public String getOperatingHours() {
    return "From " + operatingHoursStart.toLocalTime().toString() + " to " + operatingHoursEnd.toLocalTime().toString();
}


public void setProjectId(int projectId) {
    this.id = projectId;
}

public void setName(String name) {
    this.name = name;
}

public void setPrice(double price) {
    this.price = price;
}

public void setCompletionDate(LocalDateTime completionDate) {
    this.completionDate = completionDate;
}

public void setOperatingHours(LocalDateTime start, LocalDateTime end) {
    this.operatingHoursStart = start;
    this.operatingHoursEnd = end;
}
}