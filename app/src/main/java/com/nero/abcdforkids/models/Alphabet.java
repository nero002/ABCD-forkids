package com.nero.abcdforkids.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Alphabet  implements Parcelable {
    private String title;
    private int image;

    public Alphabet(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public Alphabet() {
    }

    protected Alphabet(Parcel in) {
        title = in.readString();
        image = in.readInt();
    }

    public static final Creator<Alphabet> CREATOR = new Creator<Alphabet>() {
        @Override
        public Alphabet createFromParcel(Parcel in) {
            return new Alphabet(in);
        }

        @Override
        public Alphabet[] newArray(int size) {
            return new Alphabet[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {

        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(image);
    }
}
