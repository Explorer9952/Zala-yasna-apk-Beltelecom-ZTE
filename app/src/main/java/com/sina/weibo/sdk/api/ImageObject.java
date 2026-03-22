package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class ImageObject extends BaseMediaObject {
    public static final Parcelable.Creator<ImageObject> CREATOR = new Parcelable.Creator<ImageObject>() { // from class: com.sina.weibo.sdk.api.ImageObject.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageObject createFromParcel(Parcel parcel) {
            return new ImageObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageObject[] newArray(int i) {
            return new ImageObject[i];
        }
    };
    private static final int DATA_SIZE = 2097152;
    public byte[] imageData;
    public String imagePath;

    public ImageObject() {
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public boolean checkArgs() {
        if (this.imageData == null && this.imagePath == null) {
            LogUtil.e("Weibo.ImageObject", "imageData and imagePath are null");
            return false;
        }
        byte[] bArr = this.imageData;
        if (bArr != null && bArr.length > DATA_SIZE) {
            LogUtil.e("Weibo.ImageObject", "imageData is too large");
            return false;
        }
        String str = this.imagePath;
        if (str != null && str.length() > 512) {
            LogUtil.e("Weibo.ImageObject", "imagePath is too length");
            return false;
        }
        if (this.imagePath == null) {
            return true;
        }
        File file = new File(this.imagePath);
        try {
            if (file.exists() && file.length() != 0 && file.length() <= 10485760) {
                return true;
            }
            LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
            return false;
        } catch (SecurityException unused) {
            LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
            return false;
        }
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public int getObjType() {
        return 2;
    }

    public final void setImageObject(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                this.imageData = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                e = e2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                e.printStackTrace();
                LogUtil.e("Weibo.ImageObject", "put thumb failed");
                byteArrayOutputStream2.close();
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public BaseMediaObject toExtraMediaObject(String str) {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public String toExtraMediaString() {
        return "";
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.imageData);
        parcel.writeString(this.imagePath);
    }

    public ImageObject(Parcel parcel) {
        this.imageData = parcel.createByteArray();
        this.imagePath = parcel.readString();
    }
}
