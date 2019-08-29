
package com.example.mybeer.networking.apimodels;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Amount implements Serializable, Parcelable
{

    @SerializedName("value")
    @Expose
    private Double value;
    @SerializedName("unit")
    @Expose
    private String unit;
    public final static Parcelable.Creator<Amount> CREATOR = new Creator<Amount>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Amount createFromParcel(Parcel in) {
            return new Amount(in);
        }

        public Amount[] newArray(int size) {
            return (new Amount[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5607718095007721303L;

    protected Amount(Parcel in) {
        this.value = ((Double) in.readValue((Double.class.getClassLoader())));
        this.unit = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Amount() {
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
