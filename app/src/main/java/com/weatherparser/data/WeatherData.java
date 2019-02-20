
package com.weatherparser.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class WeatherData extends RealmObject {

    @PrimaryKey
    private String location;//lon:lat

    private Long timeStamp;

    @SerializedName("now")
    @Expose
    private Integer now;
    @SerializedName("now_dt")
    @Expose
    private String nowDt;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("fact")
    @Expose
    private Fact fact;
    @SerializedName("forecasts")
    @Expose
    private RealmList<Forecast> forecasts = null;

    public Integer getNow() {
        return now;
    }

    public void setNow(Integer now) {
        this.now = now;
    }

    public String getNowDt() {
        return nowDt;
    }

    public void setNowDt(String nowDt) {
        this.nowDt = nowDt;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Fact getFact() {
        return fact;
    }

    public void setFact(Fact fact) {
        this.fact = fact;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(RealmList<Forecast> forecasts) {
        this.forecasts = forecasts;
    }


    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
