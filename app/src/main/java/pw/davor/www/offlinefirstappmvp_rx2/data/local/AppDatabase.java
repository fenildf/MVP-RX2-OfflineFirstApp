package pw.davor.www.offlinefirstappmvp_rx2.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import pw.davor.www.offlinefirstappmvp_rx2.data.local.dao.DatePojoDao;
import pw.davor.www.offlinefirstappmvp_rx2.data.models.DatePojo;

/**
 * Created by bnc on 16.2.2018..
 */

@Database(entities = {DatePojo.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {


    public abstract DatePojoDao datePojoDao();


}
