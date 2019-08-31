
package com.example.mybeer.networking.apimodels;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temp implements Serializable, Parcelable
{

    @SerializedName("value")
    @Expose
    private Double value;
    @SerializedName("unit")
    @Expose
    private String unit;
    public final static Parcelable.Creator<Temp> CREATOR = new Creator<Temp>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Temp createFromParcel(Parcel in) {
            return new Temp(in);
        }

        public Temp[] newArray(int size) {
            return (new Temp[size]);
        }

    }
    ;
    private final static long serialVersionUID = 3256492091513727842L;

    protected Temp(Parcel in) {
        this.value = ((Double) in.readValue((Integer.class.getClassLoader())));
        this.unit = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Temp() {
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(value);
        dest.writeValue(unit);
    }

    public int describeContents() {
        return  0;
    }

}
