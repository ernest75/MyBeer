
package com.example.mybeer.networking.apimodels;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ingredients implements Serializable, Parcelable
{

    @SerializedName("malt")
    @Expose
    private List<Malt> malt = null;
    @SerializedName("hops")
    @Expose
    private List<Hop> hops = null;
    @SerializedName("yeast")
    @Expose
    private String yeast;
    public final static Parcelable.Creator<Ingredients> CREATOR = new Creator<Ingredients>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Ingredients createFromParcel(Parcel in) {
            return new Ingredients(in);
        }

        public Ingredients[] newArray(int size) {
            return (new Ingredients[size]);
        }

    }
    ;
    private final static long serialVersionUID = -6133722649403412774L;

    protected Ingredients(Parcel in) {
        in.readList(this.malt, (com.example.mybeer.networking.apimodels.Malt.class.getClassLoader()));
        in.readList(this.hops, (com.example.mybeer.networking.apimodels.Hop.class.getClassLoader()));
        this.yeast = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Ingredients() {
    }

    public List<Malt> getMalt() {
        return malt;
    }

    public void setMalt(List<Malt> malt) {
        this.malt = malt;
    }

    public List<Hop> getHops() {
        return hops;
    }

    public void setHops(List<Hop> hops) {
        this.hops = hops;
    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(malt);
        dest.writeList(hops);
        dest.writeValue(yeast);
    }

    public int describeContents() {
        return  0;
    }

}
