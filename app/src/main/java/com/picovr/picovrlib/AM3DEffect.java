package com.picovr.picovrlib;

import android.media.audiofx.AudioEffect;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.UUID;

/* loaded from: classes.dex */
public class AM3DEffect {
    private static int AM3D_TRANSDUCER_EQ_ID = 5;
    private AudioEffect mAudioEffect;
    private Method mGetParameter;
    private Method mSetParameter;
    private Method mSetParameter2;
    private static UUID EFFECT_TYPE_NULL = UUID.fromString("ec7178ec-e5e1-4432-a3f4-4657e6795210");
    private static UUID EFFECT_TYPE_DOWNMIX_EFFECT = UUID.fromString("93f04452-e4fe-41cc-91f9-e475b6d1d69f");

    public AM3DEffect(int i) {
        Constructor<?> constructor = null;
        this.mAudioEffect = null;
        this.mSetParameter = null;
        this.mSetParameter2 = null;
        this.mGetParameter = null;
        Log.d("AM3D", "Audio session id: " + i);
        Constructor<?>[] declaredConstructors = AudioEffect.class.getDeclaredConstructors();
        for (int i2 = 0; i2 < declaredConstructors.length; i2++) {
            constructor = declaredConstructors[i2];
            if (constructor.getGenericParameterTypes().length != 4) {
            }
        }
        try {
            AudioEffect audioEffect = (AudioEffect) constructor.newInstance(EFFECT_TYPE_NULL, EFFECT_TYPE_DOWNMIX_EFFECT, 0, Integer.valueOf(i));
            this.mAudioEffect = audioEffect;
            Log.d("AM3D", audioEffect.toString());
            this.mAudioEffect.setEnabled(true);
            Class[] clsArr = {int[].class, int[].class};
            try {
                this.mGetParameter = AudioEffect.class.getMethod("getParameter", clsArr);
            } catch (Exception unused) {
                Log.d("AM3D", "get hidden getparameter method failed");
            }
            try {
                this.mSetParameter = AudioEffect.class.getMethod("setParameter", clsArr);
            } catch (Exception unused2) {
                Log.d("AM3D", "get hidden setparameter method failed");
            }
            try {
                clsArr[1] = byte[].class;
                this.mSetParameter2 = AudioEffect.class.getMethod("setParameter", clsArr);
            } catch (Exception unused3) {
                Log.d("AM3D", "get hidden setparameter method failed");
            }
        } catch (Exception unused4) {
            Log.d("AM3D", "AudioEffect constructor call failed");
        }
    }

    public int getAM3DParameter(int i, int i2, int[] iArr) {
        int[] iArr2 = {i, i2};
        try {
            if (this.mGetParameter != null) {
                return ((Integer) this.mGetParameter.invoke(this.mAudioEffect, iArr2, iArr)).intValue();
            }
        } catch (Exception unused) {
            Log.d("AM3D", "AudioEffect getAM3DParameter call failed");
        }
        return -1;
    }

    public int setAM3DParameter(int i, int i2, int i3) {
        int[] iArr = {i, i2};
        int[] iArr2 = {i3};
        try {
            if (this.mSetParameter != null) {
                return ((Integer) this.mSetParameter.invoke(this.mAudioEffect, iArr, iArr2)).intValue();
            }
        } catch (Exception unused) {
            Log.d("AM3D", "AudioEffect setAM3DParameter call failed");
        }
        return -1;
    }

    public int setAM3DTransducerEqFilterSection(byte[] bArr) {
        int[] iArr = {AM3D_TRANSDUCER_EQ_ID, -1};
        try {
            if (this.mSetParameter != null) {
                return ((Integer) this.mSetParameter2.invoke(this.mAudioEffect, iArr, bArr)).intValue();
            }
            return -1;
        } catch (Exception unused) {
            Log.d("AM3D", "AudioEffect setAM3DParameter call failed");
            return -1;
        }
    }
}
