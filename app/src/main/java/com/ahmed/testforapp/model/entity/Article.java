package com.ahmed.testforapp.model.entity;


import android.os.Parcel;
import android.os.Parcelable;

import com.ahmed.testforapp.util.convertor.DesFact;
import com.ahmed.testforapp.util.convertor.DesFactConverter;
import com.ahmed.testforapp.util.convertor.OrgFact;
import com.ahmed.testforapp.util.convertor.OrgFactConverter;
import com.ahmed.testforapp.util.convertor.PreFact;
import com.ahmed.testforapp.util.convertor.PreFactConverter;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.RoomWarnings;
import androidx.room.TypeConverters;

@Entity(tableName = "article")
@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
public class Article implements Parcelable {
    public Article() {
    }

    @ColumnInfo(name = "adx_keywords")
    private String adxKeywords;

     @ColumnInfo(name = "section")
    private String section;

    @ColumnInfo(name = "byline")
    private String byline;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "abstracts")
    private String _abstract;

    @ColumnInfo(name = "publishedDate")
    private String publishedDate;

    @ColumnInfo(name = "source")
    private String source;

    @PrimaryKey
    @ColumnInfo(name = "id")
    private double id;

    @ColumnInfo(name = "views")
    private int views;

    @TypeConverters(DesFactConverter.class)
    private DesFact desFact;
    @TypeConverters(OrgFactConverter.class)
    private OrgFact orgFact;

    @Ignore
   @TypeConverters(PreFactConverter.class)
    private PreFact preFact;

    @ColumnInfo(name = "geoFacet")
    private String geoFacet;
    @Embedded
    private Medium media = null;


    @Ignore
    protected Article(Parcel in) {
        adxKeywords = in.readString();
        section = in.readString();
        byline = in.readString();
        title = in.readString();
        _abstract = in.readString();
        publishedDate = in.readString();
        source = in.readString();
        if (in.readByte() == 0) {
            id = 0;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            views = 0;
        } else {
            views = in.readInt();
        }
        geoFacet = in.readString();
        media = in.readParcelable(Medium.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(adxKeywords);
        dest.writeString(section);
        dest.writeString(byline);
        dest.writeString(title);
        dest.writeString(_abstract);
        dest.writeString(publishedDate);
        dest.writeString(source);
        if (id == 0) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(id);
        }
        if (views == 0) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(views);
        }
        dest.writeString(geoFacet);
        dest.writeParcelable(media, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }


    public DesFact getDesFact() {
        return desFact;
    }

    public void setDesFact(DesFact desFact) {
        this.desFact = desFact;
    }

    public OrgFact getOrgFact() {
        return orgFact;
    }

    public void setOrgFact(OrgFact orgFact) {
        this.orgFact = orgFact;
    }

    public PreFact getPreFact() {
        return preFact;
    }

    public void setPreFact(PreFact preFact) {
        this.preFact = preFact;
    }

    public String getGeoFacet() {
        return geoFacet;
    }

    public void setGeoFacet(String geoFacet) {
        this.geoFacet = geoFacet;
    }

    public Medium getMedia() {
        return media;
    }

    public void setMedia(Medium media) {
        this.media = media;
    }


}
