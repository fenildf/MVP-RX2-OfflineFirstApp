package pw.davor.www.offlinefirstappmvp_rx2.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import pw.davor.www.offlinefirstappmvp_rx2.data.models.DatePojo;

/**
 * Created by bnc on 16.2.2018..
 */
@Dao
public interface DatePojoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DatePojo datePojo);

    @Query("SELECT * FROM datepojo")
    Flowable<List<DatePojo>> getAllPojos();

    @Query("SELECT * FROM datepojo ORDER BY mTime DESC LIMIT 1")
    Flowable<DatePojo> getLatestPojo();
}
