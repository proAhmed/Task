
package com.ahmed.testforapp.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.ahmed.testforapp.util.MediaMetaConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity
public class Medium implements Parcelable {
    public Medium() {
    }

    @PrimaryKey(autoGenerate = true)
    @Expose(deserialize = false,serialize = false)
    @ColumnInfo(name = "medium_id")
    public int id;
    @SerializedName("type")
    @Expose
    @ColumnInfo(name = "type")
    private String type;
    @SerializedName("subtype")
    @Expose
    @ColumnInfo(name = "subtype")
    private String subtype;
    @SerializedName("caption")
    @Expose
    @ColumnInfo(name = "caption")
    private String caption;
    @SerializedName("copyright")
    @Expose
    @ColumnInfo(name = "copyright")
    private String copyright;
    @SerializedName("approved_for_syndication")
    @Expose
    @ColumnInfo(name = "approved_for_syndication")
    private Integer approvedForSyndication;
    @SerializedName("media-metadata")
    @Expose
    @TypeConverters(MediaMetaConverter.class)
    private List<MediaMetadatum> mediaMetadata = null;

    @Ignore
    protected Medium(Parcel in) {
        id = in.readInt();
        type = in.readString();
        subtype = in.readString();
        caption = in.readString();
        copyright = in.readString();
        if (in.readByte() == 0) {
            approvedForSyndication = null;
        } else {
            approvedForSyndication = in.readInt();
        }
        mediaMetadata = in.createTypedArrayList(MediaMetadatum.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(type);
        dest.writeString(subtype);
        dest.writeString(caption);
        dest.writeString(copyright);
        if (approvedForSyndication == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(approvedForSyndication);
        }
        dest.writeTypedList(mediaMetadata);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Medium> CREATOR = new Creator<Medium>() {
        @Override
        public Medium createFromParcel(Parcel in) {
            return new Medium(in);
        }

        @Override
        public Medium[] newArray(int size) {
            return new Medium[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getApprovedForSyndication() {
        return approvedForSyndication;
    }

    public void setApprovedForSyndication(Integer approvedForSyndication) {
        this.approvedForSyndication = approvedForSyndication;
    }

    public List<MediaMetadatum> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(List<MediaMetadatum> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

}
