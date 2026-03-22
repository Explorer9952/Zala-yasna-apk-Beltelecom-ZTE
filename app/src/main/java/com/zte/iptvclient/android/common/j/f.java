package com.zte.iptvclient.android.common.j;

import android.content.Context;
import android.text.TextUtils;
import com.video.androidsdk.common.PreferenceHelper;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;

/* compiled from: MulitAudioTrackAndSubtitleSettedManage.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    private static f f4679c;

    /* renamed from: a, reason: collision with root package name */
    private String f4680a = "MulitAudio";

    /* renamed from: b, reason: collision with root package name */
    private String f4681b = "MulitSubtitle";

    private f() {
    }

    public static final f a() {
        if (f4679c == null) {
            f4679c = new f();
        }
        return f4679c;
    }

    public void b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            PreferenceHelper a2 = a(str);
            if (a2 != null) {
                String string = a2.getString(str2, "");
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.split("&");
                    if (split.length == 2) {
                        if (!TextUtils.equals(split[1], str3)) {
                            split[1] = str3;
                            string = split[0] + "&" + split[1];
                            LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current channel =" + str2 + " need update for AudioTrack " + str3);
                        }
                    } else {
                        LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current channel MulitAudioTrackSetted get exception!");
                    }
                } else {
                    string = "#&" + str3;
                }
                a2.putString(str2, string);
                LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current channel =" + str2 + " update for seted " + string);
                return;
            }
            LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "getShareSharedPreferencesByAccount =" + str + " is null !!!");
            return;
        }
        LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "setTvMulitAudioTrackSetted getException for strAccount、strChannel 、currentSetSubtitle or is null");
    }

    public void c(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            PreferenceHelper a2 = a(str);
            if (a2 != null) {
                String string = a2.getString(this.f4680a, "");
                if (!TextUtils.isEmpty(string)) {
                    if (TextUtils.equals(string, str2)) {
                        str2 = string;
                    } else {
                        LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current VOD = need update for AudioTrack " + str2);
                    }
                } else {
                    LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current VOD MulitAudioTrackSetted have not recorded ");
                }
                a2.putString(this.f4680a, str2);
                LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current vod = update for seted " + str2);
                return;
            }
            LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "getShareSharedPreferencesByAccount =" + str + " is null !!!");
            return;
        }
        LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "setVODMulitAudioTrackSetted getException for strAccount、strChannel 、currentSetTrack or is null");
    }

    public void d(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            PreferenceHelper a2 = a(str);
            if (a2 != null) {
                String string = a2.getString(this.f4681b, "");
                if (!TextUtils.isEmpty(string)) {
                    if (TextUtils.equals(string, str2)) {
                        str2 = string;
                    } else {
                        LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current VOD = need update for AudioTrack " + str2);
                    }
                } else {
                    LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current VOD MulitMulitSubtitle have not recorded ");
                }
                a2.putString(this.f4681b, str2);
                LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current vod = update for seted " + str2);
                return;
            }
            LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "getShareSharedPreferencesByAccount =" + str + " is null !!!");
            return;
        }
        LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "setVODMulitSubtitleSetted getException for strAccount、strChannel 、currentSetTrack or is null");
    }

    public PreferenceHelper a(String str) {
        Context applicationContext = BaseApp.e().getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        LogEx.d("MulitAudioTrackAndSubtitleSettedManage", "getShareSharedPreferencesByAccount =" + str);
        return new PreferenceHelper(applicationContext, str);
    }

    public void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            PreferenceHelper a2 = a(str);
            if (a2 != null) {
                String string = a2.getString(str2, "");
                LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current strCurrentChannelSeted  " + string);
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.split("&");
                    if (split.length == 2) {
                        if (!TextUtils.equals(split[0], str3)) {
                            split[0] = str3;
                            string = split[0] + "&" + split[1];
                            LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current channel =" + str2 + " need update for AudioTrack " + str3);
                        }
                    } else {
                        LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current channel MulitAudioTrackSetted get exception!");
                    }
                } else {
                    string = str3 + "&#";
                }
                a2.putString(str2, string);
                LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current channel =" + str2 + " update for seted " + string);
                return;
            }
            LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "getShareSharedPreferencesByAccount =" + str + " is null !!!");
            return;
        }
        LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "setTvMulitAudioTrackSetted getException for strAccount、strChannel 、currentSetTrack or is null");
    }

    public String c(String str) {
        if (TextUtils.isEmpty(str)) {
            LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "getVODMulitSubtitleSetted getException for strAccount is  null");
        }
        PreferenceHelper a2 = a(str);
        if (a2 != null) {
            String string = a2.getString(this.f4681b, "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current app vod = MulitSubtitle seted  is no recored!");
            return "";
        }
        LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "getShareSharedPreferencesByAccount =" + str + " is null !!!");
        return "";
    }

    public String b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "getTvMulitSubtitleSetted getException for strAccount、or strChannel 、 is  null");
        }
        PreferenceHelper a2 = a(str);
        if (a2 != null) {
            String string = a2.getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split("&");
                if (split.length == 2) {
                    String str3 = split[1];
                    LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current channel =" + str2 + " get  for Subtitle " + str3);
                    return str3;
                }
                LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current channel MulitSubtitleSetted get exception!");
                return "";
            }
            LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current channel =" + str2 + " MulitSubtitle seted  is no recored!");
            return "";
        }
        LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "getShareSharedPreferencesByAccount =" + str + " is null !!!");
        return "";
    }

    public String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "getTvMulitAudioTrackSetted getException for strAccount、or strChannel 、 is  null");
        }
        PreferenceHelper a2 = a(str);
        if (a2 != null) {
            String string = a2.getString(str2, "");
            LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current strCurrentChannelSeted " + string);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split("&");
                if (split.length == 2) {
                    String str3 = split[0];
                    LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current channel =" + str2 + " get  for AudioTrack " + str3);
                    return str3;
                }
                LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current channel MulitAudioTrackSetted get exception!");
                return "";
            }
            LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current channel =" + str2 + " AudioTrack seted  is no recored!");
            return "";
        }
        LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "getShareSharedPreferencesByAccount =" + str + " is null !!!");
        return "";
    }

    public String b(String str) {
        if (TextUtils.isEmpty(str)) {
            LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "getVODMulitAudioTrackSetted getException for strAccount is  null");
        }
        PreferenceHelper a2 = a(str);
        if (a2 != null) {
            String string = a2.getString(this.f4680a, "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            LogEx.d("MulitAudioTrackAndSubtitleSettedManage", " current app vod = MulitAudioTrack seted  is no recored!");
            return "";
        }
        LogEx.e("MulitAudioTrackAndSubtitleSettedManage", "getShareSharedPreferencesByAccount =" + str + " is null !!!");
        return "";
    }
}
