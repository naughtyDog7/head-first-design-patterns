package org.example.ch11_proxy.protection.person;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import static lombok.AccessLevel.NONE;

@Data
public class PersonBeanImpl implements PersonBean {

    private String name;
    @Setter(NONE)
    private boolean isMale;
    private String interests;

    @Setter(NONE) @Getter(NONE)
    private int hotOrNotRating;
    private int ratingCount;

    public PersonBeanImpl(String name, boolean isMale, String interests) {
        this.name = name;
        this.isMale = isMale;
        this.interests = interests;
    }

    @Override
    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    @Override
    public int getHotOrNotRating() {
        return ratingCount == 0 ? 0 : hotOrNotRating / ratingCount;
    }

    @Override
    public void setHotOrNotRating(int rating) {
        ratingCount++;
        hotOrNotRating += rating;
    }
}
