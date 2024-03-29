
package com.example.mybeer.networking.apimodels;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeerApi implements Serializable, Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("tagline")
    @Expose
    private String tagline;
    @SerializedName("first_brewed")
    @Expose
    private String firstBrewed;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("abv")
    @Expose
    private Double abv;
    @SerializedName("ibu")
    @Expose
    private Double ibu;
    @SerializedName("target_fg")
    @Expose
    private Double targetFg;
    @SerializedName("target_og")
    @Expose
    private Double targetOg;
    @SerializedName("ebc")
    @Expose
    private Double ebc;
    @SerializedName("srm")
    @Expose
    private Double srm;
    @SerializedName("ph")
    @Expose
    private Double ph;
    @SerializedName("attenuation_level")
    @Expose
    private Double attenuationLevel;
    @SerializedName("volume")
    @Expose
    private Volume volume;
    @SerializedName("boil_volume")
    @Expose
    private BoilVolume boilVolume;
    @SerializedName("method")
    @Expose
    private Method method;
    @SerializedName("ingredients")
    @Expose
    private Ingredients ingredients;
    @SerializedName("food_pairing")
    @Expose
    private List<String> foodPairing = null;
    @SerializedName("brewers_tips")
    @Expose
    private String brewersTips;
    @SerializedName("contributed_by")
    @Expose
    private String contributedBy;
    public final static Parcelable.Creator<BeerApi> CREATOR = new Creator<BeerApi>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BeerApi createFromParcel(Parcel in) {
            return new BeerApi(in);
        }

        public BeerApi[] newArray(int size) {
            return (new BeerApi[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4452764729921994257L;

    protected BeerApi(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.tagline = ((String) in.readValue((String.class.getClassLoader())));
        this.firstBrewed = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.imageUrl = ((String) in.readValue((Object.class.getClassLoader())));
        this.abv = ((Double) in.readValue((Double.class.getClassLoader())));
        this.ibu = ((Double) in.readValue((Double.class.getClassLoader())));
        this.targetFg = ((Double) in.readValue((Double.class.getClassLoader())));
        this.targetOg = ((Double) in.readValue((Double.class.getClassLoader())));
        this.ebc = ((Double) in.readValue((Double.class.getClassLoader())));
        this.srm = ((Double) in.readValue((Double.class.getClassLoader())));
        this.ph = ((Double) in.readValue((Double.class.getClassLoader())));
        this.attenuationLevel = ((Double) in.readValue((Double.class.getClassLoader())));
        this.volume = ((Volume) in.readValue((Volume.class.getClassLoader())));
        this.boilVolume = ((BoilVolume) in.readValue((BoilVolume.class.getClassLoader())));
        this.method = ((Method) in.readValue((Method.class.getClassLoader())));
        this.ingredients = ((Ingredients) in.readValue((Ingredients.class.getClassLoader())));
        in.readList(this.foodPairing, (java.lang.String.class.getClassLoader()));
        this.brewersTips = ((String) in.readValue((String.class.getClassLoader())));
        this.contributedBy = ((String) in.readValue((String.class.getClassLoader())));
    }

    public BeerApi() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getFirstBrewed() {
        return firstBrewed;
    }

    public void setFirstBrewed(String firstBrewed) {
        this.firstBrewed = firstBrewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public Double getIbu() {
        return ibu;
    }

    public void setIbu(Double ibu) {
        this.ibu = ibu;
    }

    public Double getTargetFg() {
        return targetFg;
    }

    public void setTargetFg(Double targetFg) {
        this.targetFg = targetFg;
    }

    public Double getTargetOg() {
        return targetOg;
    }

    public void setTargetOg(Double targetOg) {
        this.targetOg = targetOg;
    }

    public Double getEbc() {
        return ebc;
    }

    public void setEbc(Double ebc) {
        this.ebc = ebc;
    }

    public Double getSrm() {
        return srm;
    }

    public void setSrm(Double srm) {
        this.srm = srm;
    }

    public Double getPh() {
        return ph;
    }

    public void setPh(Double ph) {
        this.ph = ph;
    }

    public Double getAttenuationLevel() {
        return attenuationLevel;
    }

    public void setAttenuationLevel(Double attenuationLevel) {
        this.attenuationLevel = attenuationLevel;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public BoilVolume getBoilVolume() {
        return boilVolume;
    }

    public void setBoilVolume(BoilVolume boilVolume) {
        this.boilVolume = boilVolume;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getFoodPairing() {
        return foodPairing;
    }

    public void setFoodPairing(List<String> foodPairing) {
        this.foodPairing = foodPairing;
    }

    public String getBrewersTips() {
        return brewersTips;
    }

    public void setBrewersTips(String brewersTips) {
        this.brewersTips = brewersTips;
    }

    public String getContributedBy() {
        return contributedBy;
    }

    public void setContributedBy(String contributedBy) {
        this.contributedBy = contributedBy;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(tagline);
        dest.writeValue(firstBrewed);
        dest.writeValue(description);
        dest.writeValue(imageUrl);
        dest.writeValue(abv);
        dest.writeValue(ibu);
        dest.writeValue(targetFg);
        dest.writeValue(targetOg);
        dest.writeValue(ebc);
        dest.writeValue(srm);
        dest.writeValue(ph);
        dest.writeValue(attenuationLevel);
        dest.writeValue(volume);
        dest.writeValue(boilVolume);
        dest.writeValue(method);
        dest.writeValue(ingredients);
        dest.writeList(foodPairing);
        dest.writeValue(brewersTips);
        dest.writeValue(contributedBy);
    }

    public int describeContents() {
        return  0;
    }

}
