package com.njz.letsgoapp.bean.home;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class ServiceItem implements Parcelable{

    int id;
    String titile;
    String img;
    String content;
    float price;
    String startTime;
    String endTime;
    int number;
    String serviceType;
    int timeDay;
    List<String> days;
    String oneTime;

    public ServiceItem() {
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public int getTimeDay() {
        return timeDay;
    }

    public void setTimeDay(int timeDay) {
        this.timeDay = timeDay;
    }

    public List<String> getDays() {
        return days;
    }

    public String getDaysStr(){
        if(days == null) return "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i<days.size();i++){
            sb.append(days.get(i));
            sb.append(",");
            if((i+1)%3 == 0) sb.append("\n");
        }
        String result = sb.toString();
        if(result.endsWith("\n")){
            result = sb.substring(0,result.length() - 1);
        }
        if(result.endsWith(",")){
            result = sb.substring(0,result.length() - 1);
        }
        return result;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public String getOneTime() {
        return oneTime;
    }

    public void setOneTime(String oneTime) {
        this.oneTime = oneTime;
    }


    protected ServiceItem(Parcel in) {
        id = in.readInt();
        titile = in.readString();
        img = in.readString();
        content = in.readString();
        price = in.readFloat();
        startTime = in.readString();
        endTime = in.readString();
        number = in.readInt();
        serviceType = in.readString();
        timeDay = in.readInt();
        days = in.createStringArrayList();
        oneTime = in.readString();
    }

    public static final Creator<ServiceItem> CREATOR = new Creator<ServiceItem>() {
        @Override
        public ServiceItem createFromParcel(Parcel in) {
            return new ServiceItem(in);
        }

        @Override
        public ServiceItem[] newArray(int size) {
            return new ServiceItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(titile);
        dest.writeString(img);
        dest.writeString(content);
        dest.writeFloat(price);
        dest.writeString(startTime);
        dest.writeString(endTime);
        dest.writeInt(number);
        dest.writeString(serviceType);
        dest.writeInt(timeDay);
        dest.writeStringList(days);
        dest.writeString(oneTime);
    }
}