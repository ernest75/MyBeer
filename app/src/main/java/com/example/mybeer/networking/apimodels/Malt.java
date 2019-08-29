
package com.example.mybeer.networking.apimodels;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Malt implements Serializable, Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("amount")
    @Expose
    private Amount amount;
    public final static Parcelable.Creator<Malt> CREATOR = new Creator<Malt>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Malt createFromParcel(Parcel in) {
            return new Malt(in);
        }

        public Malt[] newArray(int size) {
            return (new Malt[size]);
        }

    }
    ;
    private final static long serialVersionUID = 392780594190592471L;

    protected Malt(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.amount = ((Amount) in.readValue((Amount.class.getClassLoader())));
    }

    public Malt() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(amount);
    }

    public int describeContents() {
        return  0;
    }

}
