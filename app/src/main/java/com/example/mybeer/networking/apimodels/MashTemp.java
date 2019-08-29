
package com.example.mybeer.networking.apimodels;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MashTemp implements Serializable, Parcelable
{

    @SerializedName("temp")
    @Expose
    private Temp temp;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    public final static Parcelable.Creator<MashTemp> CREATOR = new Creator<MashTemp>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MashTemp createFromParcel(Parcel in) {
            return new MashTemp(in);
        }

        public MashTemp[] newArray(int size) {
            return (new MashTemp[size]);
        }

    }
    ;
    private final static long serialVersionUID = -8610555544424092783L;

    protected MashTemp(Parcel in) {
        this.temp = ((Temp) in.readValue((Temp.class.getClassLoader())));
        this.duration = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public MashTemp() {
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(temp);
        dest.writeValue(duration);
    }

    public int describeContents() {
        return  0;
    }

}
