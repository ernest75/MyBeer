
package com.example.mybeer.networking.apimodels;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Volume implements Serializable, Parcelable
{

    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("unit")
    @Expose
    private String unit;
    public final static Parcelable.Creator<Volume> CREATOR = new Creator<Volume>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Volume createFromParcel(Parcel in) {
            return new Volume(in);
        }

        public Volume[] newArray(int size) {
            return (new Volume[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2924862031294286027L;

    protected Volume(Parcel in) {
        this.value = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.unit = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Volume() {
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
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
