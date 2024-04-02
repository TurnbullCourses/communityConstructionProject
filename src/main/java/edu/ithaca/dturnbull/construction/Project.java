package edu.ithaca.dturnbull.construction;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class Project {
    //
    private static String name;
    private static Integer id;
    private static double price;
    private static String completionDate;
    private static LocalDateTime operatingHoursStart;
    private static LocalDateTime operatingHoursEnd;


public Project(String name, Integer id, double price, String completionDate, LocalDateTime operatingHoursStart, LocalDateTime operatingHoursEnd){
    this.name = name;
    this.id = id;
    this.price= price;
    this.completionDate = completionDate;
    this.operatingHoursStart = operatingHoursStart;
    this.operatingHoursEnd = operatingHoursEnd;
}

public static int getProjectId() {
    return id;
}

public static String getName() {
    return name;
}

public static double getPrice() {
    return price;
}

public static String getCompletionDate() {
    return completionDate;
}

public static String getOperatingHours() {
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

public void setCompletionDate(String completionDate) {
    this.completionDate = completionDate;
}

public void setOperatingHours(LocalDateTime start, LocalDateTime end) {
    this.operatingHoursStart = start;
    this.operatingHoursEnd = end;
}
}