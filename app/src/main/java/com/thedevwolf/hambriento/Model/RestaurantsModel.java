package com.thedevwolf.hambriento.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class RestaurantsModel {


    private int results_found;
    private int results_start;
    private int results_shown;
    private List<RestaurantsData> restaurants;

    public int getResults_found() {
        return results_found;
    }

    public void setResults_found(int results_found) {
        this.results_found = results_found;
    }

    public int getResults_start() {
        return results_start;
    }

    public void setResults_start(int results_start) {
        this.results_start = results_start;
    }

    public int getResults_shown() {
        return results_shown;
    }

    public void setResults_shown(int results_shown) {
        this.results_shown = results_shown;
    }

    public List<RestaurantsData> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantsData> restaurants) {
        this.restaurants = restaurants;
    }

    public static class RestaurantsData implements Parcelable {


        private RestaurantData restaurant;

        protected RestaurantsData(Parcel in) {
        }

        public static final Creator<RestaurantsData> CREATOR = new Creator<RestaurantsData>() {
            @Override
            public RestaurantsData createFromParcel(Parcel in) {
                return new RestaurantsData(in);
            }

            @Override
            public RestaurantsData[] newArray(int size) {
                return new RestaurantsData[size];
            }
        };

        public RestaurantData getRestaurant() {
            return restaurant;
        }

        public void setRestaurant(RestaurantData restaurant) {
            this.restaurant = restaurant;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        public static class RestaurantData implements Parcelable {

            private RBean R;
            private String apikey;
            private String id;
            private String name;
            private String url;
            private LocationBean location;
            private int switch_to_order_menu;
            private String cuisines;
            private int average_cost_for_two;
            private int price_range;
            private String currency;
            private int opentable_support;
            private int is_zomato_book_res;
            private String mezzo_provider;
            private int is_book_form_web_view;
            private String book_form_web_view_url;
            private String book_again_url;
            private String thumb;
            private UserRatingBean user_rating;
            private String photos_url;
            private String menu_url;
            private String featured_image;
            private int has_online_delivery;
            private int is_delivering_now;
            private boolean include_bogo_offers;
            private String deeplink;
            private int is_table_reservation_supported;
            private int has_table_booking;
            private String events_url;
            private List<?> offers;
            private List<?> establishment_types;

            protected RestaurantData(Parcel in) {
                apikey = in.readString();
                id = in.readString();
                name = in.readString();
                url = in.readString();
                switch_to_order_menu = in.readInt();
                cuisines = in.readString();
                average_cost_for_two = in.readInt();
                price_range = in.readInt();
                currency = in.readString();
                opentable_support = in.readInt();
                is_zomato_book_res = in.readInt();
                mezzo_provider = in.readString();
                is_book_form_web_view = in.readInt();
                book_form_web_view_url = in.readString();
                book_again_url = in.readString();
                thumb = in.readString();
                photos_url = in.readString();
                menu_url = in.readString();
                featured_image = in.readString();
                has_online_delivery = in.readInt();
                is_delivering_now = in.readInt();
                include_bogo_offers = in.readByte() != 0;
                deeplink = in.readString();
                is_table_reservation_supported = in.readInt();
                has_table_booking = in.readInt();
                events_url = in.readString();
            }

            public static final Creator<RestaurantData> CREATOR = new Creator<RestaurantData>() {
                @Override
                public RestaurantData createFromParcel(Parcel in) {
                    return new RestaurantData(in);
                }

                @Override
                public RestaurantData[] newArray(int size) {
                    return new RestaurantData[size];
                }
            };

            public RBean getR() {
                return R;
            }

            public void setR(RBean R) {
                this.R = R;
            }

            public String getApikey() {
                return apikey;
            }

            public void setApikey(String apikey) {
                this.apikey = apikey;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public int getSwitch_to_order_menu() {
                return switch_to_order_menu;
            }

            public void setSwitch_to_order_menu(int switch_to_order_menu) {
                this.switch_to_order_menu = switch_to_order_menu;
            }

            public String getCuisines() {
                return cuisines;
            }

            public void setCuisines(String cuisines) {
                this.cuisines = cuisines;
            }

            public int getAverage_cost_for_two() {
                return average_cost_for_two;
            }

            public void setAverage_cost_for_two(int average_cost_for_two) {
                this.average_cost_for_two = average_cost_for_two;
            }

            public int getPrice_range() {
                return price_range;
            }

            public void setPrice_range(int price_range) {
                this.price_range = price_range;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public int getOpentable_support() {
                return opentable_support;
            }

            public void setOpentable_support(int opentable_support) {
                this.opentable_support = opentable_support;
            }

            public int getIs_zomato_book_res() {
                return is_zomato_book_res;
            }

            public void setIs_zomato_book_res(int is_zomato_book_res) {
                this.is_zomato_book_res = is_zomato_book_res;
            }

            public String getMezzo_provider() {
                return mezzo_provider;
            }

            public void setMezzo_provider(String mezzo_provider) {
                this.mezzo_provider = mezzo_provider;
            }

            public int getIs_book_form_web_view() {
                return is_book_form_web_view;
            }

            public void setIs_book_form_web_view(int is_book_form_web_view) {
                this.is_book_form_web_view = is_book_form_web_view;
            }

            public String getBook_form_web_view_url() {
                return book_form_web_view_url;
            }

            public void setBook_form_web_view_url(String book_form_web_view_url) {
                this.book_form_web_view_url = book_form_web_view_url;
            }

            public String getBook_again_url() {
                return book_again_url;
            }

            public void setBook_again_url(String book_again_url) {
                this.book_again_url = book_again_url;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public UserRatingBean getUser_rating() {
                return user_rating;
            }

            public void setUser_rating(UserRatingBean user_rating) {
                this.user_rating = user_rating;
            }

            public String getPhotos_url() {
                return photos_url;
            }

            public void setPhotos_url(String photos_url) {
                this.photos_url = photos_url;
            }

            public String getMenu_url() {
                return menu_url;
            }

            public void setMenu_url(String menu_url) {
                this.menu_url = menu_url;
            }

            public String getFeatured_image() {
                return featured_image;
            }

            public void setFeatured_image(String featured_image) {
                this.featured_image = featured_image;
            }

            public int getHas_online_delivery() {
                return has_online_delivery;
            }

            public void setHas_online_delivery(int has_online_delivery) {
                this.has_online_delivery = has_online_delivery;
            }

            public int getIs_delivering_now() {
                return is_delivering_now;
            }

            public void setIs_delivering_now(int is_delivering_now) {
                this.is_delivering_now = is_delivering_now;
            }

            public boolean isInclude_bogo_offers() {
                return include_bogo_offers;
            }

            public void setInclude_bogo_offers(boolean include_bogo_offers) {
                this.include_bogo_offers = include_bogo_offers;
            }

            public String getDeeplink() {
                return deeplink;
            }

            public void setDeeplink(String deeplink) {
                this.deeplink = deeplink;
            }

            public int getIs_table_reservation_supported() {
                return is_table_reservation_supported;
            }

            public void setIs_table_reservation_supported(int is_table_reservation_supported) {
                this.is_table_reservation_supported = is_table_reservation_supported;
            }

            public int getHas_table_booking() {
                return has_table_booking;
            }

            public void setHas_table_booking(int has_table_booking) {
                this.has_table_booking = has_table_booking;
            }

            public String getEvents_url() {
                return events_url;
            }

            public void setEvents_url(String events_url) {
                this.events_url = events_url;
            }

            public List<?> getOffers() {
                return offers;
            }

            public void setOffers(List<?> offers) {
                this.offers = offers;
            }

            public List<?> getEstablishment_types() {
                return establishment_types;
            }

            public void setEstablishment_types(List<?> establishment_types) {
                this.establishment_types = establishment_types;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(apikey);
                dest.writeString(id);
                dest.writeString(name);
                dest.writeString(url);
                dest.writeInt(switch_to_order_menu);
                dest.writeString(cuisines);
                dest.writeInt(average_cost_for_two);
                dest.writeInt(price_range);
                dest.writeString(currency);
                dest.writeInt(opentable_support);
                dest.writeInt(is_zomato_book_res);
                dest.writeString(mezzo_provider);
                dest.writeInt(is_book_form_web_view);
                dest.writeString(book_form_web_view_url);
                dest.writeString(book_again_url);
                dest.writeString(thumb);
                dest.writeString(photos_url);
                dest.writeString(menu_url);
                dest.writeString(featured_image);
                dest.writeInt(has_online_delivery);
                dest.writeInt(is_delivering_now);
                dest.writeByte((byte) (include_bogo_offers ? 1 : 0));
                dest.writeString(deeplink);
                dest.writeInt(is_table_reservation_supported);
                dest.writeInt(has_table_booking);
                dest.writeString(events_url);
            }

            public static class RBean {
                /**
                 * res_id : 18699316
                 */

                private int res_id;

                public int getRes_id() {
                    return res_id;
                }

                public void setRes_id(int res_id) {
                    this.res_id = res_id;
                }
            }

            public static class LocationBean implements Parcelable{
                /**
                 * address : Central Cinemas, Laxmindra Nagar, Udupi Main Road, Vidyaratna Nagar, Manipal
                 * locality : Vidyaratna Nagar
                 * city : Manipal
                 * city_id : 11299
                 * latitude : 13.3491335409
                 * longitude : 74.7827345878
                 * zipcode :
                 * country_id : 1
                 * locality_verbose : Vidyaratna Nagar, Manipal
                 */

                private String address;
                private String locality;
                private String city;
                private int city_id;
                private String latitude;
                private String longitude;
                private String zipcode;
                private int country_id;
                private String locality_verbose;

                protected LocationBean(Parcel in) {
                    address = in.readString();
                    locality = in.readString();
                    city = in.readString();
                    city_id = in.readInt();
                    latitude = in.readString();
                    longitude = in.readString();
                    zipcode = in.readString();
                    country_id = in.readInt();
                    locality_verbose = in.readString();
                }

                public static final Creator<LocationBean> CREATOR = new Creator<LocationBean>() {
                    @Override
                    public LocationBean createFromParcel(Parcel in) {
                        return new LocationBean(in);
                    }

                    @Override
                    public LocationBean[] newArray(int size) {
                        return new LocationBean[size];
                    }
                };

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getLocality() {
                    return locality;
                }

                public void setLocality(String locality) {
                    this.locality = locality;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public int getCity_id() {
                    return city_id;
                }

                public void setCity_id(int city_id) {
                    this.city_id = city_id;
                }

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }

                public String getZipcode() {
                    return zipcode;
                }

                public void setZipcode(String zipcode) {
                    this.zipcode = zipcode;
                }

                public int getCountry_id() {
                    return country_id;
                }

                public void setCountry_id(int country_id) {
                    this.country_id = country_id;
                }

                public String getLocality_verbose() {
                    return locality_verbose;
                }

                public void setLocality_verbose(String locality_verbose) {
                    this.locality_verbose = locality_verbose;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(address);
                    dest.writeString(locality);
                    dest.writeString(city);
                    dest.writeInt(city_id);
                    dest.writeString(latitude);
                    dest.writeString(longitude);
                    dest.writeString(zipcode);
                    dest.writeInt(country_id);
                    dest.writeString(locality_verbose);
                }
            }

            public static class UserRatingBean implements Parcelable {
                /**
                 * aggregate_rating : 3.4
                 * rating_text : Average
                 * rating_color : CDD614
                 * votes : 31
                 */

                private String aggregate_rating;
                private String rating_text;
                private String rating_color;
                private String votes;

                protected UserRatingBean(Parcel in) {
                    aggregate_rating = in.readString();
                    rating_text = in.readString();
                    rating_color = in.readString();
                    votes = in.readString();
                }

                public static final Creator<UserRatingBean> CREATOR = new Creator<UserRatingBean>() {
                    @Override
                    public UserRatingBean createFromParcel(Parcel in) {
                        return new UserRatingBean(in);
                    }

                    @Override
                    public UserRatingBean[] newArray(int size) {
                        return new UserRatingBean[size];
                    }
                };

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

                public String getRating_color() {
                    return rating_color;
                }

                public void setRating_color(String rating_color) {
                    this.rating_color = rating_color;
                }

                public String getVotes() {
                    return votes;
                }

                public void setVotes(String votes) {
                    this.votes = votes;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(aggregate_rating);
                    dest.writeString(rating_text);
                    dest.writeString(rating_color);
                    dest.writeString(votes);
                }
            }
        }
    }
}
