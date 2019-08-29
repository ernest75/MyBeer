
package com.example.mybeer.networking.apimodels;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fermentation implements Serializable, Parcelable
{

    @SerializedName("temp")
    @Expose
    private Temp_ temp;
    public final static Parcelable.Creator<Fermentation> CREATOR = new Creator<Fermentation>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Fermentation createFromParcel(Parcel in) {
            return new Fermentation(in);
        }

        public Fermentation[] newArray(int size) {
            return (new Fermentation[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8998223332372247230L;

    protected Fermentation(Parcel in) {
        this.temp = ((Temp_) in.readValue((Temp_.class.getClassLoader())));
    }

    public Fermentation() {
    }

    public Temp_ getTemp() {
        return temp;
    }

    public void setTemp(Temp_ temp) {
        this.temp = temp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(temp);
    }

    public int describeContents() {
        return  0;
    }

}
