
package com.weatherparser.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Hour extends RealmObject {

    @SerializedName("hour")
    @Expose
    private String hour;
    @SerializedName("hour_ts")
    @Expose
    private Integer hourTs;
    @SerializedName("temp")
    @Expose
    private Integer temp;
    @SerializedName("feels_like")
    @Expose
    private Integer feelsLike;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("wind_speed")
    @Expose
    private Double windSpeed;
    @SerializedName("wind_gust")
    @Expose
    private Double windGust;
    @SerializedName("wind_dir")
    @Expose
    private String windDir;
    @SerializedName("pressure_mm")
    @Expose
    private Double pressureMm;
    @SerializedName("pressure_pa")
    @Expose
    private Double pressurePa;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("uv_index")
    @Expose
    private Integer uvIndex;
    @SerializedName("soil_temp")
    @Expose
    private Integer soilTemp;
    @SerializedName("soil_moisture")
    @Expose
    private Double soilMoisture;
    @SerializedName("prec_mm")
    @Expose
    private Double precMm;
    @SerializedName("prec_period")
    @Expose
    private Integer precPeriod;
    @SerializedName("prec_prob")
    @Expose
    private Integer precProb;
    @SerializedName("_nowcast")
    @Expose
    private Boolean nowcast;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Integer getHourTs() {
        return hourTs;
    }

    public void setHourTs(Integer hourTs) {
        this.hourTs = hourTs;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Integer feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getWindGust() {
        return windGust;
    }

    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public Double getPressureMm() {
        return pressureMm;
    }

    public void setPressureMm(Double pressureMm) {
        this.pressureMm = pressureMm;
    }

    public Double getPressurePa() {
        return pressurePa;
    }

    public void setPressurePa(Double pressurePa) {
        this.pressurePa = pressurePa;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(Integer uvIndex) {
        this.uvIndex = uvIndex;
    }

    public Integer getSoilTemp() {
        return soilTemp;
    }

    public void setSoilTemp(Integer soilTemp) {
        this.soilTemp = soilTemp;
    }

    public Double getSoilMoisture() {
        return soilMoisture;
    }

    public void setSoilMoisture(Double soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public Double getPrecMm() {
        return precMm;
    }

    public void setPrecMm(Double precMm) {
        this.precMm = precMm;
    }

    public Integer getPrecPeriod() {
        return precPeriod;
    }

    public void setPrecPeriod(Integer precPeriod) {
        this.precPeriod = precPeriod;
    }

    public Integer getPrecProb() {
        return precProb;
    }

    public void setPrecProb(Integer precProb) {
        this.precProb = precProb;
    }

    public Boolean getNowcast() {
        return nowcast;
    }

    public void setNowcast(Boolean nowcast) {
        this.nowcast = nowcast;
    }

    @Override
    public String toString() {
        return "Hour{" +
                "hour='" + hour + '\'' +
                ", hourTs=" + hourTs +
                ", temp=" + temp +
                ", feelsLike=" + feelsLike +
                ", icon='" + icon + '\'' +
                ", condition='" + condition + '\'' +
                ", windSpeed=" + windSpeed +
                ", windGust=" + windGust +
                ", windDir='" + windDir + '\'' +
                ", pressureMm=" + pressureMm +
                ", pressurePa=" + pressurePa +
                ", humidity=" + humidity +
                ", uvIndex=" + uvIndex +
                ", soilTemp=" + soilTemp +
                ", soilMoisture=" + soilMoisture +
                ", precMm=" + precMm +
                ", precPeriod=" + precPeriod +
                ", precProb=" + precProb +
                ", nowcast=" + nowcast +
                '}';
    }
}
