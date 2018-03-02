package pw.davor.www.offlinefirstappmvp_rx2.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import pw.davor.www.offlinefirstappmvp_rx2.data.local.dao.DatePojoDao;
import pw.davor.www.offlinefirstappmvp_rx2.data.models.DatePojo;

/**
 * Created by bnc on 16.2.2018..
 */

@Database(entities = {DatePojo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    return Room.databaseBuilder(context, AppDatabase.class, "offline-first-app-db").build();
                }
            }
        }
        return sInstance;
    }

    public abstract DatePojoDao datePojoDao();


}
