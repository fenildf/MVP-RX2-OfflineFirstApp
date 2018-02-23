
package pw.davor.www.offlinefirstappmvp_rx2.data.dataModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class DatePojo {

    @SerializedName("date")
    private String mDate;
    @SerializedName("milliseconds_since_epoch") @PrimaryKey
    private Long mMillisecondsSinceEpoch;
    @SerializedName("time")
    private String mTime;

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public Long getMillisecondsSinceEpoch() {
        return mMillisecondsSinceEpoch;
    }

    public void setMillisecondsSinceEpoch(Long millisecondsSinceEpoch) {
        mMillisecondsSinceEpoch = millisecondsSinceEpoch;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatePojo)) return false;

        DatePojo pojo = (DatePojo) o;

        return mMillisecondsSinceEpoch.equals(pojo.mMillisecondsSinceEpoch);
    }

    @Override
    public int hashCode() {
        return mMillisecondsSinceEpoch.hashCode();
    }
}
