package com.thedevwolf.hambriento.Model;

import java.util.List;

public class CuisinesModel {


    private List<CuisinesData> cuisines;

    public List<CuisinesData> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<CuisinesData> cuisines) {
        this.cuisines = cuisines;
    }

    public static class CuisinesData {
        /**
         * cuisine : {"cuisine_id":152,"cuisine_name":"African"}
         */

        private CuisineData cuisine;

        public CuisineData getCuisine() {
            return cuisine;
        }

        public void setCuisine(CuisineData cuisine) {
            this.cuisine = cuisine;
        }

        public static class CuisineData {
            /**
             * cuisine_id : 152
             * cuisine_name : African
             */

            private int cuisine_id;
            private String cuisine_name;

            public int getCuisine_id() {
                return cuisine_id;
            }

            public void setCuisine_id(int cuisine_id) {
                this.cuisine_id = cuisine_id;
            }

            public String getCuisine_name() {
                return cuisine_name;
            }

            public void setCuisine_name(String cuisine_name) {
                this.cuisine_name = cuisine_name;
            }
        }
    }
}
