package org.example.ch11_proxy.protection.person;

public interface PersonBean {
    String getName();
    boolean isMale();
    String getInterests();
    int getHotOrNotRating();


    void setName(String name);
    void setGender(boolean isMale);
    void setInterests(String interests);
    void setHotOrNotRating(int rating);
}
