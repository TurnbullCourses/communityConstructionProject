package edu.ithaca.dturnbull.construction;
public interface User {
    void deleteAccount();
    void updateAccount();
    void changePassword(String password);
    boolean checkPassword(String password);
    String getEmail();
    void changeEmail(String email);
    String getName();
    void changeName(String name);
    Project viewCurrentProject();
    String viewOperatingHours();
}
