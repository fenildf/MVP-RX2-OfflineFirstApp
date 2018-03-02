package pw.davor.www.offlinefirstappmvp_rx2.data.models.dataModels;

import pw.davor.www.offlinefirstappmvp_rx2.data.models.DatePojo;

/**
 * Created by studio on 02/03/2018.
 */

public class DatePojoDataModel {
    boolean isFresh;
    DatePojo datePojo;

    public DatePojoDataModel(boolean isFresh, DatePojo datePojo) {
        this.isFresh = isFresh;
        this.datePojo = datePojo;
    }

    public boolean isFresh() {
        return isFresh;
    }

    public void setIsFresh(boolean fresh) {
        isFresh = fresh;
    }

    public DatePojo getDatePojo() {
        return datePojo;
    }

    public void setDatePojo(DatePojo datePojo) {
        this.datePojo = datePojo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatePojoDataModel)) return false;

        DatePojoDataModel that = (DatePojoDataModel) o;

        return datePojo.equals(that.datePojo);
    }

    @Override
    public int hashCode() {
        return datePojo.hashCode();
    }
}
