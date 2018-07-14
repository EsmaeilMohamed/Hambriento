package com.thedevwolf.hambriento.Model;

import java.util.List;

public class GeocodeModel {

    /**
     * location : {"entity_type":"subzone","entity_id":78014,"title":"Stamford Hill","latitude":"-29.8291030000","longitude":"31.0305770000","city_id":78,"city_name":"Durban","country_id":189,"country_name":"South Africa"}
     * popularity : {"popularity":"2.92","nightlife_index":"1.84","nearby_res":["7801067","7800551","7800248","7800219","7801062","7800194","7800215","7800200","7800503"],"top_cuisines":["Cafe","Fast Food","Grill","Italian","Indian"],"popularity_res":"100","nightlife_res":"10","subzone":"Stamford Hill","subzone_id":78014,"city":"Durban"}
     * link : https://www.zomato.com/durban/stamford-hill-restaurants
     * nearby_restaurants : [{"restaurant":{"R":{"res_id":7801067},"apikey":"5da255e481f39722e4c825938d2058ba","id":"7801067","name":"Antique Cafe","url":"https://www.zomato.com/durban/antique-cafe-morningside?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","location":{"address":"Churchill House, 93 Churchill Road, Morningside, Durban","locality":"Morningside","city":"Durban","city_id":78,"latitude":"-29.8315840000","longitude":"31.0206560000","zipcode":"","country_id":189,"locality_verbose":"Morningside, Durban"},"switch_to_order_menu":0,"cuisines":"Cafe","average_cost_for_two":150,"price_range":2,"currency":"R","offers":[],"opentable_support":0,"is_zomato_book_res":0,"mezzo_provider":"OTHER","is_book_form_web_view":0,"book_form_web_view_url":"","book_again_url":"","thumb":"","user_rating":{"aggregate_rating":"4.1","rating_text":"Very Good","rating_color":"5BA829","votes":"52"},"photos_url":"https://www.zomato.com/durban/antique-cafe-morningside/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop","menu_url":"https://www.zomato.com/durban/antique-cafe-morningside/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop","featured_image":"","has_online_delivery":0,"is_delivering_now":0,"include_bogo_offers":true,"deeplink":"zomato://restaurant/7801067","is_table_reservation_supported":0,"has_table_booking":0,"events_url":"https://www.zomato.com/durban/antique-cafe-morningside/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1"}},{"restaurant":{"R":{"res_id":7800551},"apikey":"5da255e481f39722e4c825938d2058ba","id":"7800551","name":"Mali's Indian Restaurant","url":"https://www.zomato.com/durban/malis-indian-restaurant-morningside?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","location":{"address":"77 Smiso Nkwanaya Road, Morningside, Durban","locality":"Morningside","city":"Durban","city_id":78,"latitude":"-29.8202100000","longitude":"31.0236570000","zipcode":"","country_id":189,"locality_verbose":"Morningside, Durban"},"switch_to_order_menu":0,"cuisines":"Indian","average_cost_for_two":260,"price_range":3,"currency":"R","offers":[],"opentable_support":0,"is_zomato_book_res":0,"mezzo_provider":"OTHER","is_book_form_web_view":0,"book_form_web_view_url":"","book_again_url":"","thumb":"https://b.zmtcdn.com/data/res_imagery/7800551_RESTAURANT_e902c6d2f5fdf680189b2b6589530498.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A","user_rating":{"aggregate_rating":"4.3","rating_text":"Very Good","rating_color":"5BA829","votes":"102"},"photos_url":"https://www.zomato.com/durban/malis-indian-restaurant-morningside/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop","menu_url":"https://www.zomato.com/durban/malis-indian-restaurant-morningside/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop","featured_image":"https://b.zmtcdn.com/data/res_imagery/7800551_RESTAURANT_e902c6d2f5fdf680189b2b6589530498.jpg?output-format=webp","has_online_delivery":0,"is_delivering_now":0,"include_bogo_offers":true,"deeplink":"zomato://restaurant/7800551","is_table_reservation_supported":0,"has_table_booking":0,"events_url":"https://www.zomato.com/durban/malis-indian-restaurant-morningside/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1"}},{"restaurant":{"R":{"res_id":7800248},"apikey":"5da255e481f39722e4c825938d2058ba","id":"7800248","name":"Havana Grill","url":"https://www.zomato.com/durban/havana-grill-stamford-hill?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","location":{"address":"Suncoast Casino and Entertainment World, Battery Beach Road, Stamford Hill, Durban","locality":"Suncoast Casino and Entertainment World, Stamford Hill","city":"Durban","city_id":78,"latitude":"-29.8358333333","longitude":"31.0351611111","zipcode":"","country_id":189,"locality_verbose":"Suncoast Casino and Entertainment World, Stamford Hill, Durban"},"switch_to_order_menu":0,"cuisines":"Grill","average_cost_for_two":300,"price_range":4,"currency":"R","offers":[],"opentable_support":0,"is_zomato_book_res":0,"mezzo_provider":"OTHER","is_book_form_web_view":0,"book_form_web_view_url":"","book_again_url":"","thumb":"","user_rating":{"aggregate_rating":"3.8","rating_text":"Good","rating_color":"9ACD32","votes":"65"},"photos_url":"https://www.zomato.com/durban/havana-grill-stamford-hill/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop","menu_url":"https://www.zomato.com/durban/havana-grill-stamford-hill/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop","featured_image":"","has_online_delivery":0,"is_delivering_now":0,"include_bogo_offers":true,"deeplink":"zomato://restaurant/7800248","is_table_reservation_supported":0,"has_table_booking":0,"events_url":"https://www.zomato.com/durban/havana-grill-stamford-hill/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1"}},{"restaurant":{"R":{"res_id":7800219},"apikey":"5da255e481f39722e4c825938d2058ba","id":"7800219","name":"Vapor Cafe","url":"https://www.zomato.com/durban/vapor-cafe-morningside?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","location":{"address":"514 A Lilian Ngoyi Road, Morningside, Durban","locality":"Morningside","city":"Durban","city_id":78,"latitude":"-29.8204527778","longitude":"31.0226916667","zipcode":"","country_id":189,"locality_verbose":"Morningside, Durban"},"switch_to_order_menu":0,"cuisines":"Greek","average_cost_for_two":100,"price_range":2,"currency":"R","offers":[],"opentable_support":0,"is_zomato_book_res":0,"mezzo_provider":"OTHER","is_book_form_web_view":0,"book_form_web_view_url":"","book_again_url":"","thumb":"https://b.zmtcdn.com/data/res_imagery/7800219_RESTAURANT_927fced4c1a515865a740a8074c50e9c.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A","user_rating":{"aggregate_rating":"3.6","rating_text":"Good","rating_color":"9ACD32","votes":"55"},"photos_url":"https://www.zomato.com/durban/vapor-cafe-morningside/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop","menu_url":"https://www.zomato.com/durban/vapor-cafe-morningside/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop","featured_image":"https://b.zmtcdn.com/data/res_imagery/7800219_RESTAURANT_927fced4c1a515865a740a8074c50e9c.jpg","has_online_delivery":0,"is_delivering_now":0,"include_bogo_offers":true,"deeplink":"zomato://restaurant/7800219","is_table_reservation_supported":0,"has_table_booking":0,"events_url":"https://www.zomato.com/durban/vapor-cafe-morningside/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1"}},{"restaurant":{"R":{"res_id":7801062},"apikey":"5da255e481f39722e4c825938d2058ba","id":"7801062","name":"S43","url":"https://www.zomato.com/durban/s43-morningside?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","location":{"address":"43 Station Drive, Morningside, Durban","locality":"Morningside","city":"Durban","city_id":78,"latitude":"-29.8202900000","longitude":"31.0281000000","zipcode":"","country_id":189,"locality_verbose":"Morningside, Durban"},"switch_to_order_menu":0,"cuisines":"Burger, Contemporary","average_cost_for_two":200,"price_range":3,"currency":"R","offers":[],"opentable_support":0,"is_zomato_book_res":0,"mezzo_provider":"OTHER","is_book_form_web_view":0,"book_form_web_view_url":"","book_again_url":"","thumb":"https://b.zmtcdn.com/data/res_imagery/7801062_RESTAURANT_7a58a63a98e7e46d70258fb92b4cd732.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A","user_rating":{"aggregate_rating":"4.0","rating_text":"Very Good","rating_color":"5BA829","votes":"38"},"photos_url":"https://www.zomato.com/durban/s43-morningside/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop","menu_url":"https://www.zomato.com/durban/s43-morningside/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop","featured_image":"https://b.zmtcdn.com/data/res_imagery/7801062_RESTAURANT_7a58a63a98e7e46d70258fb92b4cd732.jpg?output-format=webp","has_online_delivery":0,"is_delivering_now":0,"include_bogo_offers":true,"deeplink":"zomato://restaurant/7801062","is_table_reservation_supported":0,"has_table_booking":0,"events_url":"https://www.zomato.com/durban/s43-morningside/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1"}},{"restaurant":{"R":{"res_id":7800194},"apikey":"5da255e481f39722e4c825938d2058ba","id":"7800194","name":"Butcher Boys","url":"https://www.zomato.com/durban/butcher-boys-windermere?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","location":{"address":"170 Florida Road, Windermere, Durban","locality":"Windermere","city":"Durban","city_id":78,"latitude":"-29.8331916667","longitude":"31.0166388889","zipcode":"","country_id":189,"locality_verbose":"Windermere, Durban"},"switch_to_order_menu":0,"cuisines":"Grill, Steak","average_cost_for_two":300,"price_range":4,"currency":"R","offers":[],"opentable_support":0,"is_zomato_book_res":0,"mezzo_provider":"OTHER","is_book_form_web_view":0,"book_form_web_view_url":"","book_again_url":"","thumb":"","user_rating":{"aggregate_rating":"3.9","rating_text":"Good","rating_color":"9ACD32","votes":"49"},"photos_url":"https://www.zomato.com/durban/butcher-boys-windermere/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop","menu_url":"https://www.zomato.com/durban/butcher-boys-windermere/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop","featured_image":"","has_online_delivery":0,"is_delivering_now":0,"include_bogo_offers":true,"deeplink":"zomato://restaurant/7800194","is_table_reservation_supported":0,"has_table_booking":0,"events_url":"https://www.zomato.com/durban/butcher-boys-windermere/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1"}},{"restaurant":{"R":{"res_id":7800215},"apikey":"5da255e481f39722e4c825938d2058ba","id":"7800215","name":"Casablanca","url":"https://www.zomato.com/durban/casablanca-morningside?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","location":{"address":"Liliyan Ngoyi Road, Morningside, Durban","locality":"Morningside","city":"Durban","city_id":78,"latitude":"-29.8240666667","longitude":"31.0224388889","zipcode":"","country_id":189,"locality_verbose":"Morningside, Durban"},"switch_to_order_menu":0,"cuisines":"Portuguese, Seafood","average_cost_for_two":200,"price_range":3,"currency":"R","offers":[],"opentable_support":0,"is_zomato_book_res":0,"mezzo_provider":"OTHER","is_book_form_web_view":0,"book_form_web_view_url":"","book_again_url":"","thumb":"","user_rating":{"aggregate_rating":"3.9","rating_text":"Good","rating_color":"9ACD32","votes":"53"},"photos_url":"https://www.zomato.com/durban/casablanca-morningside/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop","menu_url":"https://www.zomato.com/durban/casablanca-morningside/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop","featured_image":"","has_online_delivery":0,"is_delivering_now":0,"include_bogo_offers":true,"deeplink":"zomato://restaurant/7800215","is_table_reservation_supported":0,"has_table_booking":0,"events_url":"https://www.zomato.com/durban/casablanca-morningside/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1"}},{"restaurant":{"R":{"res_id":7800200},"apikey":"5da255e481f39722e4c825938d2058ba","id":"7800200","name":"Marco's Italian","url":"https://www.zomato.com/durban/marcos-italian-windermere?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","location":{"address":"45 Lilian Ngoyi. Windermere, Durban","locality":"Windermere","city":"Durban","city_id":78,"latitude":"-29.8372861111","longitude":"31.0189444444","zipcode":"","country_id":189,"locality_verbose":"Windermere, Durban"},"switch_to_order_menu":0,"cuisines":"Italian","average_cost_for_two":250,"price_range":3,"currency":"R","offers":[],"opentable_support":0,"is_zomato_book_res":0,"mezzo_provider":"OTHER","is_book_form_web_view":0,"book_form_web_view_url":"","book_again_url":"","thumb":"","user_rating":{"aggregate_rating":"3.6","rating_text":"Good","rating_color":"9ACD32","votes":"22"},"photos_url":"https://www.zomato.com/durban/marcos-italian-windermere/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop","menu_url":"https://www.zomato.com/durban/marcos-italian-windermere/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop","featured_image":"","has_online_delivery":0,"is_delivering_now":0,"include_bogo_offers":true,"deeplink":"zomato://restaurant/7800200","is_table_reservation_supported":0,"has_table_booking":0,"events_url":"https://www.zomato.com/durban/marcos-italian-windermere/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1"}},{"restaurant":{"R":{"res_id":7800503},"apikey":"5da255e481f39722e4c825938d2058ba","id":"7800503","name":"Cafe Jiran","url":"https://www.zomato.com/durban/cafe-jiran-north-beach?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","location":{"address":"Belaire Hotel, 151 Snell Parade, North Beach, Durban","locality":"North Beach","city":"Durban","city_id":78,"latitude":"-29.8401900000","longitude":"31.0348660000","zipcode":"","country_id":189,"locality_verbose":"North Beach, Durban"},"switch_to_order_menu":0,"cuisines":"African","average_cost_for_two":350,"price_range":4,"currency":"R","offers":[],"opentable_support":0,"is_zomato_book_res":0,"mezzo_provider":"OTHER","is_book_form_web_view":0,"book_form_web_view_url":"","book_again_url":"","thumb":"","user_rating":{"aggregate_rating":"3.5","rating_text":"Good","rating_color":"9ACD32","votes":"41"},"photos_url":"https://www.zomato.com/durban/cafe-jiran-north-beach/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop","menu_url":"https://www.zomato.com/durban/cafe-jiran-north-beach/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop","featured_image":"","has_online_delivery":0,"is_delivering_now":0,"include_bogo_offers":true,"deeplink":"zomato://restaurant/7800503","is_table_reservation_supported":0,"has_table_booking":0,"events_url":"https://www.zomato.com/durban/cafe-jiran-north-beach/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1"}}]
     */

    private LocationData location;
    private PopularityData popularity;
    private String link;
    private List<NearbyRestaurantsData> nearby_restaurants;

    public LocationData getLocation() {
        return location;
    }

    public void setLocation(LocationData location) {
        this.location = location;
    }

    public PopularityData getPopularity() {
        return popularity;
    }

    public void setPopularity(PopularityData popularity) {
        this.popularity = popularity;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<NearbyRestaurantsData> getNearby_restaurants() {
        return nearby_restaurants;
    }

    public void setNearby_restaurants(List<NearbyRestaurantsData> nearby_restaurants) {
        this.nearby_restaurants = nearby_restaurants;
    }

    public static class LocationData {
        /**
         * entity_type : subzone
         * entity_id : 78014
         * title : Stamford Hill
         * latitude : -29.8291030000
         * longitude : 31.0305770000
         * city_id : 78
         * city_name : Durban
         * country_id : 189
         * country_name : South Africa
         */

        private String entity_type;
        private int entity_id;
        private String title;
        private String latitude;
        private String longitude;
        private int city_id;
        private String city_name;
        private int country_id;
        private String country_name;

        public String getEntity_type() {
            return entity_type;
        }

        public void setEntity_type(String entity_type) {
            this.entity_type = entity_type;
        }

        public int getEntity_id() {
            return entity_id;
        }

        public void setEntity_id(int entity_id) {
            this.entity_id = entity_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public int getCountry_id() {
            return country_id;
        }

        public void setCountry_id(int country_id) {
            this.country_id = country_id;
        }

        public String getCountry_name() {
            return country_name;
        }

        public void setCountry_name(String country_name) {
            this.country_name = country_name;
        }
    }

    public static class PopularityData {
        /**
         * popularity : 2.92
         * nightlife_index : 1.84
         * nearby_res : ["7801067","7800551","7800248","7800219","7801062","7800194","7800215","7800200","7800503"]
         * top_cuisines : ["Cafe","Fast Food","Grill","Italian","Indian"]
         * popularity_res : 100
         * nightlife_res : 10
         * subzone : Stamford Hill
         * subzone_id : 78014
         * city : Durban
         */

        private String popularity;
        private String nightlife_index;
        private String popularity_res;
        private String nightlife_res;
        private String subzone;
        private int subzone_id;
        private String city;
        private List<String> nearby_res;
        private List<String> top_cuisines;

        public String getPopularity() {
            return popularity;
        }

        public void setPopularity(String popularity) {
            this.popularity = popularity;
        }

        public String getNightlife_index() {
            return nightlife_index;
        }

        public void setNightlife_index(String nightlife_index) {
            this.nightlife_index = nightlife_index;
        }

        public String getPopularity_res() {
            return popularity_res;
        }

        public void setPopularity_res(String popularity_res) {
            this.popularity_res = popularity_res;
        }

        public String getNightlife_res() {
            return nightlife_res;
        }

        public void setNightlife_res(String nightlife_res) {
            this.nightlife_res = nightlife_res;
        }

        public String getSubzone() {
            return subzone;
        }

        public void setSubzone(String subzone) {
            this.subzone = subzone;
        }

        public int getSubzone_id() {
            return subzone_id;
        }

        public void setSubzone_id(int subzone_id) {
            this.subzone_id = subzone_id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<String> getNearby_res() {
            return nearby_res;
        }

        public void setNearby_res(List<String> nearby_res) {
            this.nearby_res = nearby_res;
        }

        public List<String> getTop_cuisines() {
            return top_cuisines;
        }

        public void setTop_cuisines(List<String> top_cuisines) {
            this.top_cuisines = top_cuisines;
        }
    }

    public static class NearbyRestaurantsData {
        /**
         * restaurant : {"R":{"res_id":7801067},"apikey":"5da255e481f39722e4c825938d2058ba","id":"7801067","name":"Antique Cafe","url":"https://www.zomato.com/durban/antique-cafe-morningside?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","location":{"address":"Churchill House, 93 Churchill Road, Morningside, Durban","locality":"Morningside","city":"Durban","city_id":78,"latitude":"-29.8315840000","longitude":"31.0206560000","zipcode":"","country_id":189,"locality_verbose":"Morningside, Durban"},"switch_to_order_menu":0,"cuisines":"Cafe","average_cost_for_two":150,"price_range":2,"currency":"R","offers":[],"opentable_support":0,"is_zomato_book_res":0,"mezzo_provider":"OTHER","is_book_form_web_view":0,"book_form_web_view_url":"","book_again_url":"","thumb":"","user_rating":{"aggregate_rating":"4.1","rating_text":"Very Good","rating_color":"5BA829","votes":"52"},"photos_url":"https://www.zomato.com/durban/antique-cafe-morningside/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop","menu_url":"https://www.zomato.com/durban/antique-cafe-morningside/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop","featured_image":"","has_online_delivery":0,"is_delivering_now":0,"include_bogo_offers":true,"deeplink":"zomato://restaurant/7801067","is_table_reservation_supported":0,"has_table_booking":0,"events_url":"https://www.zomato.com/durban/antique-cafe-morningside/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1"}
         */

        private RestaurantData restaurant;

        public RestaurantData getRestaurant() {
            return restaurant;
        }

        public void setRestaurant(RestaurantData restaurant) {
            this.restaurant = restaurant;
        }

        public static class RestaurantData {
            /**
             * R : {"res_id":7801067}
             * apikey : 5da255e481f39722e4c825938d2058ba
             * id : 7801067
             * name : Antique Cafe
             * url : https://www.zomato.com/durban/antique-cafe-morningside?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1
             * location : {"address":"Churchill House, 93 Churchill Road, Morningside, Durban","locality":"Morningside","city":"Durban","city_id":78,"latitude":"-29.8315840000","longitude":"31.0206560000","zipcode":"","country_id":189,"locality_verbose":"Morningside, Durban"}
             * switch_to_order_menu : 0
             * cuisines : Cafe
             * average_cost_for_two : 150
             * price_range : 2
             * currency : R
             * offers : []
             * opentable_support : 0
             * is_zomato_book_res : 0
             * mezzo_provider : OTHER
             * is_book_form_web_view : 0
             * book_form_web_view_url :
             * book_again_url :
             * thumb :
             * user_rating : {"aggregate_rating":"4.1","rating_text":"Very Good","rating_color":"5BA829","votes":"52"}
             * photos_url : https://www.zomato.com/durban/antique-cafe-morningside/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop
             * menu_url : https://www.zomato.com/durban/antique-cafe-morningside/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop
             * featured_image :
             * has_online_delivery : 0
             * is_delivering_now : 0
             * include_bogo_offers : true
             * deeplink : zomato://restaurant/7801067
             * is_table_reservation_supported : 0
             * has_table_booking : 0
             * events_url : https://www.zomato.com/durban/antique-cafe-morningside/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1
             */

            private RRestaurantData R;
            private String apikey;
            private String id;
            private String name;
            private String url;
            private LocationRestaurantData location;
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
            private UserRatingRestaurantData user_rating;
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

            public RRestaurantData getR() {
                return R;
            }

            public void setR(RRestaurantData R) {
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

            public LocationRestaurantData getLocation() {
                return location;
            }

            public void setLocation(LocationRestaurantData location) {
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

            public UserRatingRestaurantData getUser_rating() {
                return user_rating;
            }

            public void setUser_rating(UserRatingRestaurantData user_rating) {
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

            public static class RRestaurantData {
                /**
                 * res_id : 7801067
                 */

                private int res_id;

                public int getRes_id() {
                    return res_id;
                }

                public void setRes_id(int res_id) {
                    this.res_id = res_id;
                }
            }

            public static class LocationRestaurantData {
                /**
                 * address : Churchill House, 93 Churchill Road, Morningside, Durban
                 * locality : Morningside
                 * city : Durban
                 * city_id : 78
                 * latitude : -29.8315840000
                 * longitude : 31.0206560000
                 * zipcode :
                 * country_id : 189
                 * locality_verbose : Morningside, Durban
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
            }

            public static class UserRatingRestaurantData {
                /**
                 * aggregate_rating : 4.1
                 * rating_text : Very Good
                 * rating_color : 5BA829
                 * votes : 52
                 */

                private String aggregate_rating;
                private String rating_text;
                private String rating_color;
                private String votes;

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
            }
        }
    }
}
