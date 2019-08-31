
package com.example.mybeer.networking.apimodels;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BoilVolume implements Serializable, Parcelable
{

    @SerializedName("value")
    @Expose
    private Double value;
    @SerializedName("unit")
    @Expose
    private String unit;
    public final static Parcelable.Creator<BoilVolume> CREATOR = new Creator<BoilVolume>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BoilVolume createFromParcel(Parcel in) {
            return new BoilVolume(in);
        }

        public BoilVolume[] newArray(int size) {
            return (new BoilVolume[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8663043190789357548L;

    protected BoilVolume(Parcel in) {
        this.value = ((Double) in.readValue((Integer.class.getClassLoader())));
        this.unit = ((String) in.readValue((String.class.getClassLoader())));
    }

    public BoilVolume() {
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
