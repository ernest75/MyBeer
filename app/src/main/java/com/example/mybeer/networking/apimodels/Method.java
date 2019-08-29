
package com.example.mybeer.networking.apimodels;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Method implements Serializable, Parcelable
{

    @SerializedName("mash_temp")
    @Expose
    private List<MashTemp> mashTemp = null;
    @SerializedName("fermentation")
    @Expose
    private Fermentation fermentation;
    @SerializedName("twist")
    @Expose
    private Object twist;
    public final static Parcelable.Creator<Method> CREATOR = new Creator<Method>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Method createFromParcel(Parcel in) {
            return new Method(in);
        }

        public Method[] newArray(int size) {
            return (new Method[size]);
        }

    }
    ;
    private final static long serialVersionUID = 3574064012398725357L;

    protected Method(Parcel in) {
        in.readList(this.mashTemp, (com.example.mybeer.networking.apimodels.MashTemp.class.getClassLoader()));
        this.fermentation = ((Fermentation) in.readValue((Fermentation.class.getClassLoader())));
        this.twist = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Method() {
    }

    public List<MashTemp> getMashTemp() {
        return mashTemp;
    }

    public void setMashTemp(List<MashTemp> mashTemp) {
        this.mashTemp = mashTemp;
    }

    public Fermentation getFermentation() {
        return fermentation;
    }

    public void setFermentation(Fermentation fermentation) {
        this.fermentation = fermentation;
    }

    public Object getTwist() {
        return twist;
    }

    public void setTwist(Object twist) {
        this.twist = twist;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(mashTemp);
        dest.writeValue(fermentation);
        dest.writeValue(twist);
    }

    public int describeContents() {
        return  0;
    }

}
