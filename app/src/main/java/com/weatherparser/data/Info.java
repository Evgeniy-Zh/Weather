
package com.weatherparser.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Info extends RealmObject {

    @SerializedName("f")
    @Expose
    private Boolean f;
    @SerializedName("n")
    @Expose
    private Boolean n;
    @SerializedName("nr")
    @Expose
    private Boolean nr;
    @SerializedName("ns")
    @Expose
    private Boolean ns;
    @SerializedName("nsr")
    @Expose
    private Boolean nsr;
    @SerializedName("p")
    @Expose
    private Boolean p;
    @SerializedName("lat")
    @Expose
    private Float lat;
    @SerializedName("lon")
    @Expose
    private Float lon;
    @SerializedName("tzinfo")
    @Expose
    private Tzinfo tzinfo;
    @SerializedName("def_pressure_mm")
    @Expose
    private Integer defPressureMm;
    @SerializedName("def_pressure_pa")
    @Expose
    private Integer defPressurePa;
    @SerializedName("_h")
    @Expose
    private Boolean h;
    @SerializedName("url")
    @Expose
    private String url;

    public Boolean getF() {
        return f;
    }

    public void setF(Boolean f) {
        this.f = f;
    }

    public Boolean getN() {
        return n;
    }

    public void setN(Boolean n) {
        this.n = n;
    }

    public Boolean getNr() {
        return nr;
    }

    public void setNr(Boolean nr) {
        this.nr = nr;
    }

    public Boolean getNs() {
        return ns;
    }

    public void setNs(Boolean ns) {
        this.ns = ns;
    }

    public Boolean getNsr() {
        return nsr;
    }

    public void setNsr(Boolean nsr) {
        this.nsr = nsr;
    }

    public Boolean getP() {
        return p;
    }

    public void setP(Boolean p) {
        this.p = p;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Tzinfo getTzinfo() {
        return tzinfo;
    }

    public void setTzinfo(Tzinfo tzinfo) {
        this.tzinfo = tzinfo;
    }

    public Integer getDefPressureMm() {
        return defPressureMm;
    }

    public void setDefPressureMm(Integer defPressureMm) {
        this.defPressureMm = defPressureMm;
    }

    public Integer getDefPressurePa() {
        return defPressurePa;
    }

    public void setDefPressurePa(Integer defPressurePa) {
        this.defPressurePa = defPressurePa;
    }

    public Boolean getH() {
        return h;
    }

    public void setH(Boolean h) {
        this.h = h;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
