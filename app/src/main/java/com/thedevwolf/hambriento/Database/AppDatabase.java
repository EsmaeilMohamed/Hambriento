package com.thedevwolf.hambriento.Database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import timber.log.Timber;

@Database(entities = {RestaurantModel.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "hambriento";
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .build();
            }
        }
        Timber.d( "Getting the database instance");
        return sInstance;
    }


    public abstract RestaurantDao restaurantDao();

}
