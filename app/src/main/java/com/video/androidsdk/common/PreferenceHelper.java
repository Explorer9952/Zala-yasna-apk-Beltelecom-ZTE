package com.video.androidsdk.common;

import android.content.Context;
import android.content.SharedPreferences;
import com.video.androidsdk.log.LogEx;
import java.security.InvalidParameterException;
import java.util.Map;

/* loaded from: classes.dex */
public final class PreferenceHelper {
    private static final String LOG_TAG = "PreferenceHelper";
    private static final String UUID_KEY = "uuidkey";
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mPreferences;

    public PreferenceHelper(Context context, String str) {
        this.mPreferences = null;
        this.mEditor = null;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            this.mPreferences = sharedPreferences;
            if (sharedPreferences != null) {
                this.mEditor = sharedPreferences.edit();
                return;
            } else {
                LogEx.w(LOG_TAG, "mEditor is null!");
                return;
            }
        }
        throw new InvalidParameterException();
    }

    public void clear() {
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.clear().commit();
        } else {
            LogEx.w(LOG_TAG, "mEditor is null!");
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    public Map<String, ?> getAll() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null) {
            LogEx.w(LOG_TAG, "mPreferences is null!");
            return null;
        }
        return sharedPreferences.getAll();
    }

    public boolean getBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null) {
            LogEx.w(LOG_TAG, "mPreferences is null,return defValue:" + z);
            return z;
        }
        return sharedPreferences.getBoolean(str, z);
    }

    public float getFloat(String str, float f) {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null) {
            LogEx.w(LOG_TAG, "mPreferences is null,return defValue:" + f);
            return f;
        }
        return sharedPreferences.getFloat(str, f);
    }

    public int getInt(String str, int i) {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null) {
            LogEx.w(LOG_TAG, "mPreferences is null,return defValue:" + i);
            return i;
        }
        return sharedPreferences.getInt(str, i);
    }

    public long getLong(String str, long j) {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null) {
            LogEx.w(LOG_TAG, "mPreferences is null,return defValue:" + j);
            return j;
        }
        return sharedPreferences.getLong(str, j);
    }

    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null) {
            LogEx.w(LOG_TAG, "mPreferences is null,return defValue:" + str2);
            return str2;
        }
        return sharedPreferences.getString(str, str2);
    }

    public void putBoolean(String str, Boolean bool) {
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.putBoolean(str, bool.booleanValue());
            this.mEditor.commit();
        } else {
            LogEx.w(LOG_TAG, "mEditor is null!");
        }
    }

    public void putFloat(String str, float f) {
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.putFloat(str, f);
            this.mEditor.commit();
        } else {
            LogEx.w(LOG_TAG, "mEditor is null!");
        }
    }

    public void putInt(String str, int i) {
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.putInt(str, i);
            this.mEditor.commit();
        } else {
            LogEx.w(LOG_TAG, "mEditor is null!");
        }
    }

    public void putLong(String str, long j) {
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.putLong(str, j);
            this.mEditor.commit();
        } else {
            LogEx.w(LOG_TAG, "mEditor is null!");
        }
    }

    public void putString(String str, String str2) {
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.putString(str, str2);
            this.mEditor.commit();
        } else {
            LogEx.w(LOG_TAG, "mEditor is null!");
        }
    }

    public void remove(String str) {
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.remove(str).commit();
        } else {
            LogEx.w(LOG_TAG, "mEditor is null!");
        }
    }
}
