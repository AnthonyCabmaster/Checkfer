package com.checkfer.test.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * I am not using Strings.xml for this since in the real world this would be returned in JSON
 * I'm also not setting any data to be perfect since we would get that in JSON - So Date will be Now() for example
 */
public class LawyerModel implements Serializable {

    /*
     * Using a default currency for the UK, You can override this with #setCurrencyCountryCode
     */
    private static final String DEFAULT_CURRENCY = "GBP";

    private String name = "Anthony Martin";
    private String speciality = "Speciality";

    /*
     * For future use - Would be used to download photo using the Glide library
     */
    private String photoURL = null;
    private String currencyCountryCode = DEFAULT_CURRENCY;

    /*
     * Would assume that a server would give a String back pre-made with X/XX. If not would use an int and return a String based on getRanking + "/" + countOfTotalLawyers
     */
    private String ranking = "1/18";
    private String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam enim elit, auctor a.";
    private String moreInfo = "Lorem ipsum dolor sit amet, Lorem ipsum dolor sit ametLorem ipsum dolor sit ametLorem ipsum dolor sit ametLorem ipsum dolor sit ametLorem ipsum dolor sit amet Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet consectetur adipiscing elit. Nulla volutpat ante at finibus tempus. Quisque placerat porttitor metus, sed euismod orci. Maecenas fringilla sem vel urna placerat, ac sagittis enim luctus. Suspendisse nisl ante, tempor non mattis vitae, condimentum et nisi. Donec nisi eros, mattis nec laoreet ac, ornare in neque. Quisque faucibus massa quis volutpat sollicitudin. Nulla at erat a ex varius blandit. Sed faucibus lacus non egestas elementum. Phasellus orci quam, sollicitudin nec mollis ultricies, congue vel lacus. Ut in aliquam elit. Sed auctor purus neque, at suscipit mauris hendrerit eget.";
    private int responseTimeInDays = 1;
    private int reviews = 12;
    private double rating = 4.8;
    private Date memberSince = new Date();
    private BigDecimal price = new BigDecimal(60.90);

    /*
        new Random().nextBoolean() is purely there for testing
     */
    private boolean isFeatured = new Random().nextBoolean();
    /*
        new Random().nextBoolean() is purely there for testing
     */
    private Boolean isFavourite = new Random().nextBoolean();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    /**
     * This is a private function as I have my own getPrice function which is {@link #getFormattedPrice()}
     *
     * @return the country code for the lawyer
     */
    private String getCurrencyCountryCode() {
        return currencyCountryCode;
    }

    public void setCurrencyCountryCode(String currencyCountryCode) {
        this.currencyCountryCode = currencyCountryCode;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getResponseTimeInDays() {
        return "Avg. Response Time: 1 day";
    }

    public void setResponseTimeInDays(int responseTimeInDays) {
        this.responseTimeInDays = responseTimeInDays;
    }

    public String getReviews() {
        return String.valueOf(reviews);
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public String getRating() {
        return String.valueOf(rating);
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getMemberSince() {
        return "Member Since: Oct 2015";
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    private String getFormattedPrice() {
        return getCurrencyCountryCode() + getPrice();
    }


    public String getPrice() {
        return "£60.90";
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public Boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
    }
}
