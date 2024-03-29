
package com.example.mybeer.networking.apimodels;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hop implements Serializable, Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("amount")
    @Expose
    private Amount_ amount;
    @SerializedName("add")
    @Expose
    private String add;
    @SerializedName("attribute")
    @Expose
    private String attribute;
    public final static Parcelable.Creator<Hop> CREATOR = new Creator<Hop>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Hop createFromParcel(Parcel in) {
            return new Hop(in);
        }

        public Hop[] newArray(int size) {
            return (new Hop[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8026126745581637360L;

    protected Hop(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.amount = ((Amount_) in.readValue((Amount_.class.getClassLoader())));
        this.add = ((String) in.readValue((String.class.getClassLoader())));
        this.attribute = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Hop() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amount_ getAmount() {
        return amount;
    }

    public void setAmount(Amount_ amount) {
        this.amount = amount;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(amount);
        dest.writeValue(add);
        dest.writeValue(attribute);
    }

    public int describeContents() {
        return  0;
    }

}
