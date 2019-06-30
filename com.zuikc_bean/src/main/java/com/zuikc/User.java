package com.zuikc;

import java.util.Date;

public class User {
    private int id;
    private String siteTime;
    private String siteNum;
    private String siteLocation;
    private String siteName;
    private String siteDescription;
    private String siteLinker;
    private String siteDayHandle;
    private String siteCommWay;
    private double siteLong;
    private double siteLat;

    public User(int id, String siteTime, String siteNum, String siteLocation, String siteName, String siteDescription, String siteLinker, String siteDayHandle, String siteCommWay, double siteLong, double siteLat) {
        this.id = id;
        this.siteTime = siteTime;
        this.siteNum = siteNum;
        this.siteLocation = siteLocation;
        this.siteName = siteName;
        this.siteDescription = siteDescription;
        this.siteLinker = siteLinker;
        this.siteDayHandle = siteDayHandle;
        this.siteCommWay = siteCommWay;
        this.siteLong = siteLong;
        this.siteLat = siteLat;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSiteTime() {
        return siteTime;
    }

    public void setSiteTime(String siteTime) {
        this.siteTime = siteTime;
    }

    public String getSiteNum() {
        return siteNum;
    }

    public void setSiteNum(String siteNum) {
        this.siteNum = siteNum;
    }

    public String getSiteLocation() {
        return siteLocation;
    }

    public void setSiteLocation(String siteLocation) {
        this.siteLocation = siteLocation;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteDescription() {
        return siteDescription;
    }

    public void setSiteDescription(String siteDescription) {
        this.siteDescription = siteDescription;
    }

    public String getSiteLinker() {
        return siteLinker;
    }

    public void setSiteLinker(String siteLinker) {
        this.siteLinker = siteLinker;
    }

    public String getSiteDayHandle() {
        return siteDayHandle;
    }

    public void setSiteDayHandle(String siteDayHandle) {
        this.siteDayHandle = siteDayHandle;
    }

    public String getSiteCommWay() {
        return siteCommWay;
    }

    public void setSiteCommWay(String siteCommWay) {
        this.siteCommWay = siteCommWay;
    }

    public double getSiteLong() {
        return siteLong;
    }

    public void setSiteLong(double siteLong) {
        this.siteLong = siteLong;
    }

    public double getSiteLat() {
        return siteLat;
    }

    public void setSiteLat(double siteLat) {
        this.siteLat = siteLat;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", siteTime='" + siteTime + '\'' +
                ", siteNum='" + siteNum + '\'' +
                ", siteLocation='" + siteLocation + '\'' +
                ", siteName='" + siteName + '\'' +
                ", siteDescription='" + siteDescription + '\'' +
                ", siteLinker='" + siteLinker + '\'' +
                ", siteDayHandle='" + siteDayHandle + '\'' +
                ", siteCommWay='" + siteCommWay + '\'' +
                ", siteLong=" + siteLong +
                ", siteLat=" + siteLat +
                '}';
    }
}
