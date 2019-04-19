
package com.ahmed.testforapp.model.entity;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity
public class MediaMetadatum implements Parcelable {
    public MediaMetadatum() {
    }

    @SerializedName("url")
    @Expose
    @ColumnInfo(name = "url")
    private String url;
    @SerializedName("format")
    @Expose
    @ColumnInfo(name = "format")
    private String format;
    @SerializedName("height")
    @Expose
    @ColumnInfo(name = "height")
    private Integer height;
    @SerializedName("width")
    @Expose
    @ColumnInfo(name = "width")
    private Integer width;

    @Ignore
    protected MediaMetadatum(Parcel in) {
        url = in.readString();
        format = in.readString();
        if (in.readByte() == 0) {
            height = null;
        } else {
            height = in.readInt();
        }
        if (in.readByte() == 0) {
            width = null;
        } else {
            width = in.readInt();
        }
    }

    public static final Creator<MediaMetadatum> CREATOR = new Creator<MediaMetadatum>() {
        @Override
        public MediaMetadatum createFromParcel(Parcel in) {
            return new MediaMetadatum(in);
        }

        @Override
        public MediaMetadatum[] newArray(int size) {
            return new MediaMetadatum[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(format);
        if (height == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(height);
        }
        if (width == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(width);
        }
    }
}
