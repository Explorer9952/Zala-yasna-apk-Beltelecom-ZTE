package com.video.androidsdk.player;

import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.widget.RelativeLayout;
import com.tencent.mm.sdk.contact.RContact;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.common.AssetStatus;
import com.video.androidsdk.player.common.AssetType;
import com.video.androidsdk.player.common.DecoderType;
import com.video.androidsdk.player.common.SubtitleHorizontal;
import com.video.androidsdk.player.common.SubtitleVertical;
import com.video.androidsdk.player.common.UrlRedirectUtil;
import com.video.androidsdk.player.common.UrlUtils;
import com.video.androidsdk.player.common.ZoomModeType;
import com.video.androidsdk.player.render.RenderImpl;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AbsBasePlayer.java */
/* loaded from: classes.dex */
public class a extends RenderImpl implements IBasePlayer {

    /* renamed from: c, reason: collision with root package name */
    protected IBasePlayer.OnEventListener f3307c;
    protected IBasePlayer.OnMsgReportListener e;
    protected IBasePlayer.OnVideoListener f;
    protected IBasePlayer.OnTextRenderListener g;

    /* renamed from: a, reason: collision with root package name */
    protected UrlRedirectUtil f3305a = new UrlRedirectUtil();

    /* renamed from: b, reason: collision with root package name */
    protected boolean f3306b = true;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f3308d = true;

    private String c(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf("JITPDRMType=")) <= 0) {
            return str;
        }
        if (!this.f3306b) {
            LogEx.d("AbsBasePlayer", "Protected content cannot be played");
            if (str.contains("JITPDRMType=Widevine")) {
                str = str.replace("JITPDRMType=Widevine", "JITPDRMType=NO");
            } else if (str.contains("JITPDRMType=widevine")) {
                str = str.replace("JITPDRMType=widevine", "JITPDRMType=NO");
            }
        }
        String substring = str.substring(indexOf + 12);
        int indexOf2 = substring.indexOf("&");
        if (indexOf2 > 0) {
            substring = substring.substring(0, indexOf2);
        }
        if (substring.isEmpty()) {
            return str;
        }
        if (!substring.contains("Widevine-") && !substring.contains("NO-")) {
            return str;
        }
        try {
            str = str.replace(substring, com.video.androidsdk.player.common.a.a(substring.getBytes(), com.video.androidsdk.license.a.a("exodrmtypekey")));
            LogEx.d("AbsBasePlayer", "strDrmType = " + substring + ",encrypt url = " + str);
            return str;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LogEx.d("AbsBasePlayer", "DrmEncrypt Exception :" + e.getMessage());
            return str;
        }
    }

    private int d(String str) {
        int i = 0;
        int i2 = 0;
        while (i <= str.lastIndexOf(47)) {
            i2++;
            int indexOf = str.indexOf(47, i);
            if (i2 == 3) {
                return indexOf;
            }
            i = indexOf + 1;
        }
        return -1;
    }

    private int e(String str) {
        int lastIndexOf = str.lastIndexOf(63);
        if (lastIndexOf > 0) {
            String substring = str.substring(0, lastIndexOf);
            if (str.lastIndexOf(63) <= str.lastIndexOf(47) + 1) {
                return -1;
            }
            str = substring;
        }
        return str.lastIndexOf(47);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        if (com.video.androidsdk.license.a.h) {
            LogEx.d("AbsBasePlayer", " playerModelOn is true");
            openInternal(str);
            return;
        }
        LogEx.d("AbsBasePlayer", "you should check license");
        IBasePlayer.OnEventListener onEventListener = this.f3307c;
        if (onEventListener != null) {
            onEventListener.onError("30000502", "[player_error][APP][EVENT]Received license failed event");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b(String str) {
        String substring;
        if (!TextUtils.isEmpty(str) && str.contains("needencrypt=1")) {
            int d2 = d(str);
            int e = e(str);
            if (d2 != -1 && e != -1 && d2 < e) {
                String substring2 = str.substring(d2 + 1, e);
                if (str.indexOf(63) == -1) {
                    substring = str.substring(e + 1);
                } else {
                    substring = str.substring(e + 1, str.indexOf(63));
                }
                long currentTimeMillis = (System.currentTimeMillis() + Util.MILLSECONDS_OF_DAY) / 1000;
                String str2 = substring2 + RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR + substring + RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR + Long.toString(currentTimeMillis);
                LogEx.d("AbsBasePlayer", "original message is " + str2);
                try {
                    String a2 = a(str2, "huawei");
                    if (str.lastIndexOf(63) == -1) {
                        str = str + "?sign=" + a2 + "&t=" + Long.toString(currentTimeMillis);
                    } else {
                        str = str + "&sign=" + a2 + "&t=" + Long.toString(currentTimeMillis);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return str;
    }

    public boolean closeSensor() {
        return false;
    }

    public void enableCardBoardVideo(boolean z) {
    }

    public void enableSphericalVideo(boolean z) {
    }

    public void enableSubtitle(boolean z) {
    }

    public int getAssetCount(AssetType assetType) {
        return 0;
    }

    public int getAssetIndex(AssetType assetType, AssetStatus assetStatus) {
        return 0;
    }

    public int getAudioChannel() {
        return 0;
    }

    public void getAudioInfoArray(ArrayList<String> arrayList) {
    }

    public long getAvailabilityStartTime() {
        return 0L;
    }

    public long getBitrateEstimate() {
        return 0L;
    }

    public long getBufferedPosition() {
        return 0L;
    }

    public long getCurrentPosition() {
        return 0L;
    }

    public long getCurrentTimeMs() {
        return 0L;
    }

    public String getDRMUniqueIdentifier() {
        return null;
    }

    public long getDuration() {
        return 0L;
    }

    public long getLeftTimeMs() {
        return 0L;
    }

    public float getPlaySpeed() {
        return 0.0f;
    }

    public int getPlayerState() {
        return 0;
    }

    public String getProbeKP() {
        return null;
    }

    public long getRightTimeMs() {
        return 0L;
    }

    public int getScreenBrightness() {
        return 0;
    }

    public long getSeekOff() {
        return 0L;
    }

    public float getSphericalViewSensorRoll() {
        return 0.0f;
    }

    public void getSubtitleInfoArray(ArrayList<String> arrayList) {
    }

    public SurfaceView getSurfaceView() {
        return null;
    }

    public long getUTCPosition() {
        return 0L;
    }

    public long getVideoFrameRate() {
        return 0L;
    }

    public int getVideoHeight() {
        return 0;
    }

    public void getVideoInfoArray(ArrayList<String> arrayList) {
    }

    public int getVideoWidth() {
        return 0;
    }

    public float getVolume() {
        return 0.0f;
    }

    public void init(int i, int i2, int i3, int i4) {
    }

    public void init(Surface surface) {
    }

    public void init(SurfaceView surfaceView) {
    }

    public void init(TextureView textureView) {
    }

    public void init(RelativeLayout relativeLayout) {
    }

    public void init(RelativeLayout relativeLayout, int i, boolean z) {
    }

    public boolean isPlaying() {
        return false;
    }

    public boolean isRecording() {
        return false;
    }

    public boolean isTrackAvailable(AssetType assetType, int i) {
        return false;
    }

    public void mute() {
    }

    public boolean onKeyDown(KeyEvent keyEvent, int i, int i2) {
        return false;
    }

    public void open(String str) {
        IBasePlayer.OnEventListener onEventListener;
        LogEx.d("AbsBasePlayer", "url is " + str);
        if (TextUtils.isEmpty(str) && (onEventListener = this.f3307c) != null) {
            onEventListener.onError("-100", "url is null, return");
        } else {
            open(str, true);
        }
    }

    public void open(String str, String str2, String str3) {
    }

    protected void openInternal(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void openInternal(String str, int i) {
    }

    public boolean openSensor() {
        return false;
    }

    public void pause() {
    }

    public boolean recordStart(String str) {
        return false;
    }

    public boolean recordStop() {
        return false;
    }

    public void release() {
        if (this.f3305a != null) {
            LogEx.d("AbsBasePlayer", "cancel redirect url if exists");
            this.f3305a.cancel();
        }
    }

    public void resume() {
    }

    public void resume4bg() {
    }

    public void seek(long j) {
    }

    public void seek(long j, long j2) {
    }

    public void seek(long j, long j2, long j3) {
    }

    public boolean selectAudioByIndex(int i) {
        return false;
    }

    public boolean selectSubtitleByIndex(int i) {
        return false;
    }

    public boolean selectVideoByIndex(int i) {
        return false;
    }

    public void setAudioChannel(int i) {
    }

    public void setAudioChannel(boolean z, boolean z2) {
    }

    public void setAutoSpeed(boolean z) {
    }

    public void setDRMInfo(String str, String str2) {
    }

    public void setDecoderType(DecoderType decoderType, DecoderType decoderType2) {
        if (decoderType == null) {
            return;
        }
        if (decoderType == DecoderType.Decoder_HW) {
            this.f3308d = true;
        } else {
            this.f3308d = false;
        }
    }

    public void setFadingVolumn(float f, long j) {
    }

    public void setInitialBufferingTime(int i) {
    }

    public void setIsNormalSeek(boolean z) {
    }

    public void setLooping(boolean z) {
    }

    public void setMaxAllBufferSize(long j) {
    }

    public void setMaxBufferSize(long j) {
    }

    public void setMaxBufferingTime(int i) {
    }

    public void setMaxSupportTime(long j) {
    }

    public void setOnEventListener(IBasePlayer.OnEventListener onEventListener) {
        this.f3307c = onEventListener;
    }

    @Override // com.video.androidsdk.player.IBasePlayer
    public void setOnMsgReportListener(IBasePlayer.OnMsgReportListener onMsgReportListener) {
        this.e = onMsgReportListener;
    }

    @Override // com.video.androidsdk.player.IBasePlayer
    public void setOnTextRenderListener(IBasePlayer.OnTextRenderListener onTextRenderListener) {
        this.g = onTextRenderListener;
    }

    @Override // com.video.androidsdk.player.IBasePlayer
    public void setOnVideoListener(IBasePlayer.OnVideoListener onVideoListener) {
        this.f = onVideoListener;
    }

    public void setPlaySpeed(float f) {
    }

    public void setPlaybackBufferingTime(int i) {
    }

    public void setPlayerHeader(String str) {
    }

    public void setPreferredAudioLanguage(String str) {
    }

    public void setPreferredBitrate(long j) {
    }

    public void setPreferredSubtitleLanguage(String str) {
    }

    public void setRenderTypeOpenGL() {
    }

    public void setScale(float f) {
    }

    public void setScreenBrightness(int i) {
    }

    public void setSourceType(String str) {
    }

    public void setSphericalVideoView(float f, float f2, float f3) {
    }

    public void setSubtitleGravity(SubtitleHorizontal subtitleHorizontal, SubtitleVertical subtitleVertical) {
    }

    public void setUseAdaptiveTrack() {
    }

    public void setUserLanguage(String str) {
    }

    public void setVolume(float f) {
    }

    public void setZoomMode(ZoomModeType zoomModeType, Rect rect) {
    }

    public void start() {
    }

    public void startWriteLog() {
    }

    public void stop() {
        if (this.f3305a != null) {
            LogEx.d("AbsBasePlayer", "cancel redirect url if exists");
            this.f3305a.cancel();
        }
    }

    public void stopSphericalView() {
    }

    public void stopWriteLog() {
    }

    public void suspend4bg() {
    }

    public boolean takeSnapShot(int i, String str, int i2, int i3) {
        return false;
    }

    public boolean unifySeekIsLive() {
        return true;
    }

    public void unmute() {
    }

    public void updateVideoSize(int i, int i2) {
    }

    private void a(String str, String str2, boolean z) {
        LogEx.d("AbsBasePlayer", "url is " + str);
        String c2 = c(str);
        this.f3305a.cancel();
        this.f3305a.getUrlAfterRedirection(c2, new b(this, str2, z));
    }

    @Override // com.video.androidsdk.player.IBasePlayer
    public void open(String str, boolean z) {
        open(str, z, true);
    }

    protected String a(String str) {
        HashMap<String, String> paramsMap;
        if (TextUtils.isEmpty(str) || (paramsMap = UrlUtils.getParamsMap(str)) == null || !paramsMap.containsKey("videoid") || paramsMap.containsKey("playseek")) {
            return "";
        }
        String str2 = paramsMap.get("videoid");
        return !str2.startsWith("ch") ? "" : str2;
    }

    @Override // com.video.androidsdk.player.IBasePlayer
    public void open(String str, boolean z, boolean z2) {
        HashMap<String, Pair<String, Long>> urlMap = UrlUtils.getUrlMap();
        if (z2 && UrlUtils.isNeedToRedirect(str)) {
            String a2 = a(str);
            LogEx.d("AbsBasePlayer", "channelCode is " + a2);
            if (!TextUtils.isEmpty(a2) && z) {
                if (urlMap.containsKey(a2)) {
                    Pair<String, Long> pair = urlMap.get(a2);
                    LogEx.d("AbsBasePlayer", "cache url is " + ((String) pair.first));
                    if (SystemClock.elapsedRealtime() - ((Long) pair.second).longValue() <= 21600000 && !TextUtils.isEmpty((CharSequence) pair.first)) {
                        LogEx.d("AbsBasePlayer", "play without redircet ,use cache url :" + ((String) pair.first));
                        f(b((String) pair.first));
                        return;
                    }
                    LogEx.d("AbsBasePlayer", "cache url needs update,do redirect");
                    urlMap.remove(a2);
                    a(str, a2, true);
                    return;
                }
                a(str, a2, z);
                return;
            }
            a(str, a2, z);
            return;
        }
        LogEx.d("AbsBasePlayer", "play without redircet");
        f(b(str));
    }

    private String a(String str, String str2) throws Exception {
        String a2 = com.video.androidsdk.license.a.a("HmacSHA256");
        Mac mac = Mac.getInstance(a2);
        mac.init(new SecretKeySpec(str2.getBytes(), a2));
        byte[] doFinal = mac.doFinal(str.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b2 : doFinal) {
            sb.append(String.format("%02x", Byte.valueOf(b2)));
        }
        return sb.toString();
    }

    private void a(String str, int i) {
        if (com.video.androidsdk.license.a.h) {
            LogEx.d("AbsBasePlayer", " playerModelOn is true");
            openInternal(str, i);
            return;
        }
        LogEx.d("AbsBasePlayer", "you should check license");
        IBasePlayer.OnEventListener onEventListener = this.f3307c;
        if (onEventListener != null) {
            onEventListener.onError("30000502", "[player_error][APP][EVENT]Received license failed event");
        }
    }

    @Override // com.video.androidsdk.player.IBasePlayer
    public void open(String str, int i) {
        a(str, i);
    }
}
