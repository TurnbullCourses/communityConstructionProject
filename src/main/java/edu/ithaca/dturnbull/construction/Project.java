package edu.ithaca.dturnbull.construction;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Project {
    //
    private String name;
    private Integer id;
    private double price;
    private LocalDate completionDate;
    private LocalDateTime operatingHoursStart;
    private LocalDateTime operatingHoursEnd;


public Project(String name, Integer id, double price, LocalDate completionDate, LocalDateTime operatingHoursStart, LocalDateTime operatingHoursEnd){
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

public LocalDate getCompletionDate() {
    return completionDate;
}
public String getFormattedCompletionDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
        return completionDate.format(formatter);
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

public void setCompletionDate(LocalDate completionDate) {
    this.completionDate = completionDate;
}

public void setOperatingHours(LocalDateTime start, LocalDateTime end) {
    this.operatingHoursStart = start;
    this.operatingHoursEnd = end;
}
}