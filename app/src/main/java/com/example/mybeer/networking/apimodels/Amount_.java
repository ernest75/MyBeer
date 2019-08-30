
package com.example.mybeer.networking.apimodels;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Amount_ implements Serializable, Parcelable
{

    @SerializedName("value")
    @Expose
    private Double value;
    @SerializedName("unit")
    @Expose
    private String unit;
    public final static Parcelable.Creator<Amount_> CREATOR = new Creator<Amount_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Amount_ createFromParcel(Parcel in) {
            return new Amount_(in);
        }

        public Amount_[] newArray(int size) {
            return (new Amount_[size]);
        }

    }
    ;
    private final static long serialVersionUID = 3548673832759640165L;

    protected Amount_(Parcel in) {
        this.value = ((Double) in.readValue((Integer.class.getClassLoader())));
        this.unit = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Amount_() {
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
