package com.android.vending.expansion.zipfile;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.android.vending.expansion.zipfile.b;
import com.zte.ucs.tvcall.Commons;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class APEZProvider extends ContentProvider {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f1889c = {"_id", "ZPFN", "ZFIL", "ZMOD", "ZCRC", "ZCOL", "ZUNL", "ZTYP"};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f1890d = {0, 1, 2, 3, 4, 5, 6, 7};

    /* renamed from: a, reason: collision with root package name */
    private b f1891a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1892b;

    private boolean b() {
        int i;
        if (!this.f1892b) {
            Context context = getContext();
            PackageManager packageManager = context.getPackageManager();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(a(), Commons.MSG_MCSP_INIT_SUCCESS);
            try {
                int i2 = packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
                String[] strArr = null;
                Bundle bundle = resolveContentProvider.metaData;
                if (bundle != null) {
                    int i3 = bundle.getInt("mainVersion", i2);
                    int i4 = resolveContentProvider.metaData.getInt("patchVersion", i2);
                    String string = resolveContentProvider.metaData.getString("mainFilename", "N");
                    if ("N" != string) {
                        String string2 = resolveContentProvider.metaData.getString("patchFilename", "N");
                        strArr = "N" != string2 ? new String[]{string, string2} : new String[]{string};
                    }
                    i = i4;
                    i2 = i3;
                } else {
                    i = i2;
                }
                try {
                    if (strArr == null) {
                        this.f1891a = a.b(context, i2, i);
                    } else {
                        this.f1891a = a.a(strArr);
                    }
                    this.f1892b = true;
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public abstract String a();

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        b();
        return super.applyBatch(arrayList);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "vnd.android.cursor.item/asset";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        b();
        String encodedPath = uri.getEncodedPath();
        if (encodedPath.startsWith("/")) {
            encodedPath = encodedPath.substring(1);
        }
        return this.f1891a.b(encodedPath);
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        b();
        AssetFileDescriptor openAssetFile = openAssetFile(uri, str);
        if (openAssetFile != null) {
            return openAssetFile.getParcelFileDescriptor();
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int[] iArr;
        b();
        b bVar = this.f1891a;
        b.a[] a2 = bVar == null ? new b.a[0] : bVar.a();
        if (strArr == null) {
            iArr = f1890d;
            strArr = f1889c;
        } else {
            int length = strArr.length;
            int[] iArr2 = new int[length];
            for (int i = 0; i < length; i++) {
                if (strArr[i].equals("_id")) {
                    iArr2[i] = 0;
                } else if (strArr[i].equals("ZPFN")) {
                    iArr2[i] = 1;
                } else if (strArr[i].equals("ZFIL")) {
                    iArr2[i] = 2;
                } else if (strArr[i].equals("ZMOD")) {
                    iArr2[i] = 3;
                } else if (strArr[i].equals("ZCRC")) {
                    iArr2[i] = 4;
                } else if (strArr[i].equals("ZCOL")) {
                    iArr2[i] = 5;
                } else if (strArr[i].equals("ZUNL")) {
                    iArr2[i] = 6;
                } else if (strArr[i].equals("ZTYP")) {
                    iArr2[i] = 7;
                } else {
                    throw new RuntimeException();
                }
            }
            iArr = iArr2;
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr, a2.length);
        int length2 = iArr.length;
        for (b.a aVar : a2) {
            MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
            for (int i2 = 0; i2 < length2; i2++) {
                switch (iArr[i2]) {
                    case 0:
                        newRow.add(Integer.valueOf(i2));
                        break;
                    case 1:
                        newRow.add(aVar.f1895b);
                        break;
                    case 2:
                        newRow.add(aVar.c());
                        break;
                    case 3:
                        newRow.add(Long.valueOf(aVar.f));
                        break;
                    case 4:
                        newRow.add(Long.valueOf(aVar.g));
                        break;
                    case 5:
                        newRow.add(Long.valueOf(aVar.h));
                        break;
                    case 6:
                        newRow.add(Long.valueOf(aVar.i));
                        break;
                    case 7:
                        newRow.add(Integer.valueOf(aVar.e));
                        break;
                }
            }
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
