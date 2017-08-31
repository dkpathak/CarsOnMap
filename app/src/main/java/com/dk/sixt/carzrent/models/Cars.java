package com.dk.sixt.carzrent.models;

/**
 * Created by dk on 30/8/17.
 *
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/** Samples
 "id": "WMWSW31030T222518",
 "modelIdentifier": "mini",
 "modelName": "MINI",
 "name": "Vanessa",
 "make": "BMW",
 "group": "MINI",
 "color": "midnight_black",
 "series": "MINI",
 "fuelType": "D",
 "fuelLevel": 0.7,
 "transmission": "M",
 "licensePlate": "M-VO0259",
 "latitude": 48.134557,
 "longitude": 11.576921,
 "innerCleanliness": "REGULAR",
 "carImageUrl": "https://prod.drive-now-content.com/fileadmin/user_upload_global/assets/cars/{modelIdentifier}/{color}/2x/car.png"
 */

public class Cars implements Parcelable{

//    private String carBaseUrl = "https://prod.drive-now-content.com/fileadmin/user_upload_global/assets/cars/";

     @SerializedName("id")
     @Expose
     private String id;
     @SerializedName("modelIdentifier")
     @Expose
     private String modelIdentifier;
     @SerializedName("modelName")
     @Expose
     private String modelName;
     @SerializedName("name")
     @Expose
     private String name;
     @SerializedName("make")
     @Expose
     private String make;
     @SerializedName("group")
     @Expose
     private String group;
     @SerializedName("color")
     @Expose
     private String color;
     @SerializedName("series")
     @Expose
     private String series;
     @SerializedName("fuelType")
     @Expose
     private String fuelType;
     @SerializedName("fuelLevel")
     @Expose
     private Double fuelLevel;
     @SerializedName("transmission")
     @Expose
     private String transmission;
     @SerializedName("licensePlate")
     @Expose
     private String licensePlate;
     @SerializedName("latitude")
     @Expose
     private Double latitude;
     @SerializedName("longitude")
     @Expose
     private Double longitude;
     @SerializedName("innerCleanliness")
     @Expose
     private String innerCleanliness;

     private String carImageUrl;

    protected Cars(Parcel in) {
        id = in.readString();
        modelIdentifier = in.readString();
        modelName = in.readString();
        name = in.readString();
        make = in.readString();
        group = in.readString();
        color = in.readString();
        series = in.readString();
        fuelType = in.readString();
        transmission = in.readString();
        licensePlate = in.readString();
        innerCleanliness = in.readString();
        carImageUrl = in.readString();
    }

    public static final Creator<Cars> CREATOR = new Creator<Cars>() {
        @Override
        public Cars createFromParcel(Parcel in) {
            return new Cars(in);
        }

        @Override
        public Cars[] newArray(int size) {
            return new Cars[size];
        }
    };

    public String getId() {
         return id;
     }

     public void setId(String id) {
         this.id = id;
     }

     public String getModelIdentifier() {
         return modelIdentifier;
     }

     public void setModelIdentifier(String modelIdentifier) {
         this.modelIdentifier = modelIdentifier;
     }

     public String getModelName() {
         return modelName;
     }

     public void setModelName(String modelName) {
         this.modelName = modelName;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getMake() {
         return make;
     }

     public void setMake(String make) {
         this.make = make;
     }

     public String getGroup() {
         return group;
     }

     public void setGroup(String group) {
         this.group = group;
     }

     public String getColor() {
         return color;
     }

     public void setColor(String color) {
         this.color = color;
     }

     public String getSeries() {
         return series;
     }

     public void setSeries(String series) {
         this.series = series;
     }

     public String getFuelType() {
         return fuelType;
     }

     public void setFuelType(String fuelType) {
         this.fuelType = fuelType;
     }

     public Double getFuelLevel() {
         return fuelLevel;
     }

     public void setFuelLevel(Double fuelLevel) {
         this.fuelLevel = fuelLevel;
     }

     public String getTransmission() {
         return transmission;
     }

     public void setTransmission(String transmission) {
         this.transmission = transmission;
     }

     public String getLicensePlate() {
         return licensePlate;
     }

     public void setLicensePlate(String licensePlate) {
         this.licensePlate = licensePlate;
     }

     public Double getLatitude() {
         return latitude;
     }

     public void setLatitude(Double latitude) {
         this.latitude = latitude;
     }

     public Double getLongitude() {
         return longitude;
     }

     public void setLongitude(Double longitude) {
         this.longitude = longitude;
     }

     public String getInnerCleanliness() {
         return innerCleanliness;
     }

     public void setInnerCleanliness(String innerCleanliness) {
         this.innerCleanliness = innerCleanliness;
     }

     public String getCarImageUrl() {
         this.carImageUrl = createCarImageUrl(getModelIdentifier(),getColor());
         return carImageUrl;
     }

     public void setCarImageUrl(String carImageUrl) {
         this.carImageUrl = carImageUrl;
     }

     private String createCarImageUrl(String mi,String clr){
         String carBaseUrl = "https://prod.drive-now-content.com/fileadmin/user_upload_global/assets/cars/";
         StringBuilder stringBuilder = new StringBuilder(carBaseUrl);
         stringBuilder.append(mi);
         stringBuilder.append("/");
         stringBuilder.append(clr);
         stringBuilder.append("/2x/car.png");
         return stringBuilder.toString();
     }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(modelIdentifier);
        parcel.writeString(modelName);
        parcel.writeString(name);
        parcel.writeString(make);
        parcel.writeString(group);
        parcel.writeString(color);
        parcel.writeString(series);
        parcel.writeString(fuelType);
        parcel.writeString(transmission);
        parcel.writeString(licensePlate);
        parcel.writeString(innerCleanliness);
        carImageUrl = createCarImageUrl(getModelIdentifier(),getColor());
        parcel.writeString(carImageUrl);
    }
}
