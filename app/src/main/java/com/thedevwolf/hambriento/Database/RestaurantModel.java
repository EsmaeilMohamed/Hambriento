package com.thedevwolf.hambriento.Database;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

@Entity(tableName = "restaurants")
public class RestaurantModel implements Parcelable {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    public String id;
    public String address;
    public String city;
    public String votes;
    public String aggregate_rating;
    public String rating_text;
    public String name;
    public String menu_url;
    public String image;
    public int online_delivery;


    public RestaurantModel() {
    }

    @Ignore
    public RestaurantModel(@NonNull String id, String address, String city, String votes, String aggregate_rating, String rating_text, String name, String menu_url, String image, int online_delivery) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.votes = votes;
        this.aggregate_rating = aggregate_rating;
        this.rating_text = rating_text;
        this.name = name;
        this.menu_url = menu_url;
        this.image = image;
        this.online_delivery = online_delivery;
    }

    protected RestaurantModel(Parcel in) {
        id = in.readString();
        address = in.readString();
        city = in.readString();
        votes = in.readString();
        aggregate_rating = in.readString();
        rating_text = in.readString();
        name = in.readString();
        menu_url = in.readString();
        image = in.readString();
        online_delivery = in.readInt();
    }

    public static final Creator<RestaurantModel> CREATOR = new Creator<RestaurantModel>() {
        @Override
        public RestaurantModel createFromParcel(Parcel in) {
            return new RestaurantModel(in);
        }

        @Override
        public RestaurantModel[] newArray(int size) {
            return new RestaurantModel[size];
        }
    };

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public String getAggregate_rating() {
        return aggregate_rating;
    }

    public void setAggregate_rating(String aggregate_rating) {
        this.aggregate_rating = aggregate_rating;
    }

    public String getRating_text() {
        return rating_text;
    }

    public void setRating_text(String rating_text) {
        this.rating_text = rating_text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public int getOnline_delivery() {
        return online_delivery;
    }

    public void setOnline_delivery(int online_delivery) {
        this.online_delivery = online_delivery;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(address);
        dest.writeString(city);
        dest.writeString(votes);
        dest.writeString(aggregate_rating);
        dest.writeString(rating_text);
        dest.writeString(name);
        dest.writeString(menu_url);
        dest.writeString(image);
        dest.writeInt(online_delivery);
    }
}
