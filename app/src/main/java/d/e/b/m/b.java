package d.e.b.m;

import android.os.Handler;
import android.os.Message;
import com.google.gson.Gson;
import com.zte.ucs.tvcall.ocx.ResultInfo;
import com.zte.ucs.tvcall.ocx.audioconf.FireConfCreateResult;
import com.zte.ucs.tvcall.ocx.audioconf.FireConfPartyNotifyInfo;
import com.zte.ucs.tvcall.ocx.audioconf.VoiceConfMemState;
import com.zte.ucs.tvcall.ocx.telephone.CallThrowScreenRspInfo;
import com.zte.ucs.tvcall.ocx.telephone.CallTransferRspInfo;
import com.zte.ucs.tvcall.ocx.videoconf.CallVideoConfParticipantSoundState;
import com.zte.ucs.tvcall.ocx.videoconf.CallVideoConfSoundControlResp;
import com.zte.ucs.tvcall.ocx.videoconf.ConferenceParticipateInfo;
import com.zte.ucs.tvcall.ocx.videoconf.ConferenceinviteResp;
import com.zte.ucs.tvcall.ocx.videoconf.ConferenceinviteuserInfoResp;
import com.zte.ucs.tvcall.ocx.videoconf.SwitchtofrontInfoResp;
import com.zte.ucs.tvcall.ocx.videoconf.VideoConferenceInfoResp;
import d.e.b.b.e;
import d.e.b.n.d;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes2.dex */
public class b extends e implements a {
    private static final String f = "b";

    private static boolean c(String str) {
        String a2 = d.e.b.n.a.a("VideoConfDomain");
        d.a(f, "java_FireReportMemberStatus check isVidwoConf weather uri[" + str + "] matching the configured domainName[" + a2 + "].");
        if (a2 == null || "".equals(a2)) {
            d.d(f, "VideoConference did not set the domainName!");
        } else if (str.endsWith(a2)) {
            return true;
        }
        return false;
    }

    @Override // d.e.b.m.a
    public void a(int i) {
        d.a(f, String.format(Locale.getDefault(), "【通话-需创建媒体流数量通知】 java_NotifyMediaStreamInfo iMediaStreamNum[%d] just for demo test. Do nothing!", Integer.valueOf(i)));
    }

    @Override // d.e.b.m.a
    public void a(int i, int i2) {
        d.a(f, String.format(Locale.getDefault(), "【SDK-视频第一帧通知（实时）】 java_SetFixedSize i_nWidth[%d],i_nHeight[%d]", Integer.valueOf(i), Integer.valueOf(i2)));
        Message obtain = Message.obtain();
        obtain.what = 28;
        obtain.arg1 = i;
        obtain.arg2 = i2;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void a(int i, String str, Object obj) {
        d.a(f, String.format(Locale.getDefault(), "【通话-IMS音/视频切换通知】 java_FireIMSCallEvent lType[%d] lpCaller[%s]", Integer.valueOf(i), str));
        if (str == null) {
            str = "";
        }
        String replaceAll = str.replaceAll(";.*$", "");
        long j = i;
        if (j == 3) {
            Message obtain = Message.obtain();
            obtain.obj = replaceAll;
            obtain.arg1 = 3;
            obtain.what = 13;
            c().sendMessage(obtain);
            return;
        }
        if (j == 5) {
            Message obtain2 = Message.obtain();
            obtain2.obj = replaceAll;
            obtain2.arg1 = 5;
            obtain2.what = 7;
            c().sendMessage(obtain2);
        }
    }

    @Override // d.e.b.m.a
    public void a(int i, VoiceConfMemState[] voiceConfMemStateArr) {
        d.a(f, String.format(Locale.getDefault(), "【多方通话-多方语音通话成员状态通知】 java_NfyVoiceConfMemState  count[%d]", Integer.valueOf(i)));
        if (voiceConfMemStateArr == null) {
            d.d(f, "java_NfyVoiceConfMemState get voiceConfMemState null!");
            return;
        }
        if (i > voiceConfMemStateArr.length) {
            i = voiceConfMemStateArr.length;
            d.d(f, "java_NfyVoiceConfMemState get count greater than voiceConfMemState Array! only get count:" + i);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            VoiceConfMemState voiceConfMemState = voiceConfMemStateArr[i2];
            d.a(f, String.format(Locale.getDefault(), "java_NfyVoiceConfMemState  Callee[%s] state[%d]", voiceConfMemState.getLpCallee(), Integer.valueOf(voiceConfMemState.getState())));
            arrayList.add(voiceConfMemState);
        }
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.arg1 = i;
        obtain.obj = arrayList;
        e().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void a(CallThrowScreenRspInfo callThrowScreenRspInfo) {
        String szSessionId = callThrowScreenRspInfo.getSzSessionId();
        String szPeerNumber = callThrowScreenRspInfo.getSzPeerNumber();
        String szThrowScreenDstNumber = callThrowScreenRspInfo.getSzThrowScreenDstNumber();
        int currentCallType = callThrowScreenRspInfo.getCurrentCallType();
        ResultInfo resultInfo = callThrowScreenRspInfo.getResultInfo();
        int errorCode = resultInfo.getErrorCode();
        d.a(f, String.format(Locale.getDefault(), "【甩屏回调】java_CBCallThrowScreen sessionId[%s] szPeerNumber[%s] szThrowScreenDstNumber[%s] currentCalType[%d] result[%d] errorCode[%d],erroeReason[%s]", szSessionId, szPeerNumber, szThrowScreenDstNumber, Integer.valueOf(currentCallType), Integer.valueOf(resultInfo.getResult()), Integer.valueOf(errorCode), resultInfo.getErrorReason()));
        Message obtain = Message.obtain();
        obtain.what = 31;
        obtain.obj = callThrowScreenRspInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void a(CallTransferRspInfo callTransferRspInfo) {
        String json = new Gson().toJson(callTransferRspInfo);
        d.a(f, String.format(Locale.getDefault(), "【呼叫转移回调】java_CBCallTranfer" + json, new Object[0]));
        Message obtain = Message.obtain();
        obtain.what = 32;
        obtain.obj = callTransferRspInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void a(CallVideoConfParticipantSoundState callVideoConfParticipantSoundState) {
        String str;
        int i;
        String str2 = "";
        if (callVideoConfParticipantSoundState != null) {
            str2 = callVideoConfParticipantSoundState.getConfUri();
            i = callVideoConfParticipantSoundState.getiSoundControlType();
            str = callVideoConfParticipantSoundState.getRequestUri();
        } else {
            callVideoConfParticipantSoundState = new CallVideoConfParticipantSoundState();
            str = "";
            i = 0;
        }
        d.a(f, String.format(Locale.getDefault(), "【多方视频-参与方禁言/发言状态通知】 java_CBCallVideoConfParticipantSoundState confUri[%s], soundControl[%d],requestUri[%s]", str2, Integer.valueOf(i), str));
        Message obtain = Message.obtain();
        obtain.what = 11;
        obtain.obj = callVideoConfParticipantSoundState;
        f().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void a(CallVideoConfSoundControlResp callVideoConfSoundControlResp) {
        String str;
        String str2;
        int i;
        String str3 = "";
        if (callVideoConfSoundControlResp != null) {
            String confUri = callVideoConfSoundControlResp.getConfUri();
            String sessionId = callVideoConfSoundControlResp.getSessionId();
            i = callVideoConfSoundControlResp.getResult();
            str2 = callVideoConfSoundControlResp.getParticipantUri();
            str = confUri;
            str3 = sessionId;
        } else {
            callVideoConfSoundControlResp = new CallVideoConfSoundControlResp();
            str = "";
            str2 = str;
            i = 0;
        }
        d.a(f, String.format(Locale.getDefault(), "【多方视频-主席控制禁言/发言执行通知】 java_CBCallVideoConfSoundControl sessionId[%s],confUri[%s],partUri[%s], result[%d]", str3, str, str2, Integer.valueOf(i)));
        Message obtain = Message.obtain();
        obtain.what = 10;
        obtain.obj = callVideoConfSoundControlResp;
        f().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void a(String str, int i) {
        Message obtain;
        Handler c2;
        d.a(f, String.format(Locale.getDefault(), "【通话-媒体就绪通知】 java_NotifyUIMediaInitFinished lpCaller[%s] lType[%d]", str, Integer.valueOf(i)));
        if (str == null) {
            str = "";
        }
        String replaceAll = str.replaceAll(";.*$", "");
        d.a(f, "java_NotifyUIMediaInitFinished received, need check domainName to choose VideoHandler callback.");
        if (c(replaceAll)) {
            obtain = Message.obtain();
            obtain.obj = replaceAll;
            obtain.arg1 = i;
            obtain.what = 8;
            c2 = f();
        } else {
            obtain = Message.obtain();
            obtain.obj = replaceAll;
            obtain.arg1 = i;
            obtain.what = 23;
            c2 = c();
        }
        c2.sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void a(String str, int i, int i2) {
        d.a(f, String.format(Locale.getDefault(), "【通话-状态通知】 java_FireReportMemberStatus lpCallee[%s] lStatus[%d], lCallType[%d]", str, Integer.valueOf(i), Integer.valueOf(i2)));
        if (str == null) {
            str = "";
        }
        String replaceAll = str.replaceAll(";.*$", "");
        long j = i;
        if (j == 2) {
            Message obtain = Message.obtain();
            obtain.obj = replaceAll;
            obtain.arg1 = i2;
            obtain.arg2 = i;
            obtain.what = 1;
            c().sendMessage(obtain);
            return;
        }
        if (j == 3) {
            Message obtain2 = Message.obtain();
            obtain2.obj = replaceAll;
            obtain2.what = 2;
            c().sendMessage(obtain2);
            return;
        }
        if (j == 5) {
            d.a(f, "java_FireReportMemberStatus receive lStatus:" + i + ", need check domainName to choose VideoHandler callback.");
            if (c(replaceAll)) {
                Message obtain3 = Message.obtain();
                obtain3.obj = replaceAll;
                obtain3.arg1 = i2;
                obtain3.what = 4;
                f().sendMessage(obtain3);
                return;
            }
            Message obtain4 = Message.obtain();
            obtain4.obj = replaceAll;
            obtain4.arg1 = i2;
            obtain4.what = 3;
            c().sendMessage(obtain4);
            return;
        }
        if (j == 4) {
            Message obtain5 = Message.obtain();
            obtain5.obj = replaceAll;
            obtain5.arg1 = i2;
            obtain5.what = 4;
            c().sendMessage(obtain5);
            return;
        }
        if (j == 6) {
            d.a(f, "java_FireReportMemberStatus receive lStatus:" + i + ", need check domainName to choose VideoHandler callback.");
            if (c(replaceAll)) {
                Message obtain6 = Message.obtain();
                obtain6.obj = replaceAll;
                obtain6.arg1 = i2;
                obtain6.what = 9;
                f().sendMessage(obtain6);
                return;
            }
            Message obtain7 = Message.obtain();
            obtain7.obj = replaceAll;
            obtain7.arg1 = i2;
            obtain7.what = 5;
            c().sendMessage(obtain7);
            return;
        }
        if (j == 500) {
            Message obtain8 = Message.obtain();
            obtain8.obj = replaceAll;
            obtain8.arg1 = i2;
            obtain8.what = 6;
            c().sendMessage(obtain8);
            return;
        }
        if (j == 501) {
            Message obtain9 = Message.obtain();
            obtain9.obj = replaceAll;
            obtain9.arg1 = i2;
            obtain9.what = 22;
            c().sendMessage(obtain9);
            return;
        }
        if (j == 11 || j == 12) {
            return;
        }
        if (j == 18) {
            Message obtain10 = Message.obtain();
            obtain10.obj = replaceAll;
            obtain10.arg1 = i2;
            obtain10.what = 11;
            c().sendMessage(obtain10);
            return;
        }
        if (j == 1 || j == 491 || j == 492) {
            return;
        }
        if (j == 17) {
            Message obtain11 = Message.obtain();
            obtain11.obj = replaceAll;
            obtain11.arg1 = i2;
            obtain11.what = 17;
            c().sendMessage(obtain11);
            return;
        }
        if (j == 16) {
            Message obtain12 = Message.obtain();
            obtain12.obj = replaceAll;
            obtain12.arg1 = i2;
            obtain12.what = 16;
            c().sendMessage(obtain12);
            return;
        }
        if (j != 19) {
            if (j == 24) {
                Message obtain13 = Message.obtain();
                obtain13.obj = replaceAll;
                obtain13.arg1 = i2;
                obtain13.what = 25;
                c().sendMessage(obtain13);
                return;
            }
            if (j == 25) {
                Message obtain14 = Message.obtain();
                obtain14.obj = replaceAll;
                obtain14.arg1 = i2;
                obtain14.what = 26;
                c().sendMessage(obtain14);
                return;
            }
            if (j == 20) {
                Message obtain15 = Message.obtain();
                obtain15.obj = replaceAll;
                obtain15.arg1 = i2;
                obtain15.what = 12;
                c().sendMessage(obtain15);
                return;
            }
            if (j == 7 || j == 8 || j == 9) {
                Message obtain16 = Message.obtain();
                obtain16.obj = replaceAll;
                obtain16.arg1 = i2;
                obtain16.what = 8;
                c().sendMessage(obtain16);
            }
        }
    }

    @Override // d.e.b.m.a
    public void a(String str, int i, int i2, String str2) {
        d.a(f, String.format(Locale.getDefault(), "【通话-第二路通话状态通知】 java_FireNewCallWhenBusy2 lpCaller[%s],lType[%d],iAVCallType[%d],pURL[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), str2));
        if (str == null) {
            str = "";
        }
        String replaceAll = str.replaceAll(";.*$", "");
        if (1 == i) {
            Message obtain = Message.obtain();
            obtain.obj = replaceAll;
            obtain.arg1 = i2;
            obtain.what = 15;
            c().sendMessage(obtain);
            return;
        }
        if (2 == i) {
            Message obtain2 = Message.obtain();
            obtain2.obj = replaceAll;
            obtain2.arg1 = i2;
            obtain2.what = 18;
            c().sendMessage(obtain2);
        }
    }

    @Override // d.e.b.m.a
    public void a(String str, int i, String str2) {
        d.a(f, String.format(Locale.getDefault(), "【多方视频-创建会议执行通知】 java_CreateVideoConference sessionId[%s], result[%d], asUrl[%s]", str, Integer.valueOf(i), str2));
        VideoConferenceInfoResp videoConferenceInfoResp = new VideoConferenceInfoResp();
        videoConferenceInfoResp.setSessionId(str);
        videoConferenceInfoResp.setAsUrl(str2);
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.arg1 = i;
        obtain.obj = videoConferenceInfoResp;
        f().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void a(String str, int i, String str2, String str3) {
        d.a(f, String.format(Locale.getDefault(), "【多方视频-邀请成员参与执行通知】 java_Conferenceinviteuser sessionId[%s], result[%d], asUrl[%s], uri[%s]", str, Integer.valueOf(i), str2, str3));
        ConferenceinviteuserInfoResp conferenceinviteuserInfoResp = new ConferenceinviteuserInfoResp();
        conferenceinviteuserInfoResp.setSessionId(str);
        conferenceinviteuserInfoResp.setAsUrl(str2);
        conferenceinviteuserInfoResp.setUri(str3);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        obtain.obj = conferenceinviteuserInfoResp;
        f().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void a(String str, String str2) {
        d.a(f, String.format("【通话-IVVR点击事件上报通知】 java_FireIVVRClickEvent pCalleeNumber[%s],content[%s]", str, str2));
        d.e.b.m.c.b bVar = new d.e.b.m.c.b();
        bVar.a(str);
        bVar.b(str2);
        Message obtain = Message.obtain();
        obtain.obj = bVar;
        obtain.what = 30;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void a(String str, String str2, int i, int i2) {
        d.a(f, String.format(Locale.getDefault(), "【多方视频-成员加入通知】 java_ConferenceParticipantStatus asUri[%s], uri[%s], picno[%d], dStatus[%d]", str, str2, Integer.valueOf(i), Integer.valueOf(i2)));
        Message obtain = Message.obtain();
        obtain.what = 5;
        ConferenceParticipateInfo conferenceParticipateInfo = new ConferenceParticipateInfo();
        conferenceParticipateInfo.setAsUrl(str);
        conferenceParticipateInfo.setUri(str2);
        conferenceParticipateInfo.setPicno(i);
        conferenceParticipateInfo.setStatus(i2);
        obtain.obj = conferenceParticipateInfo;
        f().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void a(String str, String str2, int i, int i2, int i3) {
        d.a(f, String.format(Locale.getDefault(), "【多方通话-创建结果通知】 java_FireCreateConfCallResult confid[%s], sessionid[%s],result[%d],type[%d],subType[%d]", str2, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
        FireConfCreateResult fireConfCreateResult = new FireConfCreateResult();
        fireConfCreateResult.setConfid(str2);
        fireConfCreateResult.setSessionid(str);
        fireConfCreateResult.setResult(i);
        fireConfCreateResult.setType(i2);
        fireConfCreateResult.setSubType(i3);
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = fireConfCreateResult;
        e().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void a(String str, String str2, String str3, int i, int i2) {
        d.a(f, String.format(Locale.getDefault(), "【多方通话-接到邀请通知】 java_NfyVoiceConfInvite callednum[%s],confid[%s],callingnum[%s],type[%d],subType[%d]", str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)));
        FireConfPartyNotifyInfo fireConfPartyNotifyInfo = new FireConfPartyNotifyInfo();
        ArrayList arrayList = new ArrayList();
        if (!d.e.b.n.e.a(str)) {
            for (String str4 : str.split(";", -1)) {
                arrayList.add(str4);
            }
        }
        fireConfPartyNotifyInfo.setCallednum(arrayList);
        fireConfPartyNotifyInfo.setCallingnum(str3);
        fireConfPartyNotifyInfo.setConfid(str2);
        fireConfPartyNotifyInfo.setType(i);
        fireConfPartyNotifyInfo.setSubType(i2);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = fireConfPartyNotifyInfo;
        e().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void b(String str, int i) {
        d.a(f, String.format(Locale.getDefault(), "【通话-来电通知】 java_FireSomeOneCallMe lpCaller[%s] lType[%d]", str, Integer.valueOf(i)));
        if (str == null) {
            str = "";
        }
        String replaceAll = str.replaceAll(";.*$", "");
        Message obtain = Message.obtain();
        obtain.obj = replaceAll;
        obtain.arg1 = i;
        obtain.what = 0;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void b(String str, int i, int i2) {
        d.a(f, String.format(Locale.getDefault(), "【通话-呼叫保持执行通知】 java_NfyHoldResult callnum[%s] type[%d], result[%d]", str, Integer.valueOf(i), Integer.valueOf(i2)));
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.arg1 = i;
        obtain.arg2 = i2;
        obtain.what = 27;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void b(String str, int i, String str2, String str3) {
        d.a(f, String.format(Locale.getDefault(), "【多方视频-视频前转上台执行通知】 java_Switchtofront sessionId[%s], result[%d], asUrl[%s], uri[%s]", str, Integer.valueOf(i), str2, str3));
        SwitchtofrontInfoResp switchtofrontInfoResp = new SwitchtofrontInfoResp();
        switchtofrontInfoResp.setSessionId(str);
        switchtofrontInfoResp.setAsUrl(str2);
        switchtofrontInfoResp.setUri(str3);
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.arg1 = i;
        obtain.obj = switchtofrontInfoResp;
        f().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void c(String str, int i) {
        d.a(f, String.format(Locale.getDefault(), "【多方视频-Subscribe结果通知】 java_ConferenceSubscribeResp asUri[%s], result[%d]", str, Integer.valueOf(i)));
        Message obtain = Message.obtain();
        obtain.what = 7;
        obtain.arg1 = i;
        obtain.obj = str;
        f().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void d(String str, int i) {
        d.a(f, String.format(Locale.getDefault(), "【多方通话-参与方状态消息通知】 java_NfyVoiceConfStateResp  sessionId[%s], result[%d], ", str, Integer.valueOf(i)));
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.arg1 = i;
        obtain.obj = str;
        e().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void d(String str, String str2) {
        d.a(f, String.format("【通话-服务端前转呼叫通知】 java_FireCalleeForward pCalleeNumber[%s],pForwardNumber[%s]", str, str2));
        String replaceAll = str2.replaceAll(";.*$", "");
        d.e.b.m.c.a aVar = new d.e.b.m.c.a();
        aVar.a(str);
        aVar.b(replaceAll);
        Message obtain = Message.obtain();
        obtain.obj = aVar;
        obtain.what = 14;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void e(String str, String str2) {
        d.a(f, String.format("【多方视频-收到邀请的通知】 java_Conferenceinvite asUrl[%s], uri[%s]", str, str2));
        ConferenceinviteResp conferenceinviteResp = new ConferenceinviteResp();
        conferenceinviteResp.setAsUrl(str);
        conferenceinviteResp.setUri(str2);
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = conferenceinviteResp;
        f().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void f(int i) {
        d.a(f, String.format(Locale.getDefault(), "【SDK-设备获取失败通知（实时）】 java_DeviceRequestStatus dStatus[%d]", Integer.valueOf(i)));
        Message obtain = Message.obtain();
        obtain.what = 20;
        obtain.arg1 = i;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void f(String str, int i) {
        d.a(f, String.format(Locale.getDefault(), "【多方视频-会议会场信息通知】 java_ConferenceDetailInfo asUri[%s], participants[%d]", str, Integer.valueOf(i)));
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.arg1 = i;
        obtain.obj = str;
        f().sendMessage(obtain);
    }

    @Override // d.e.b.m.a
    public void h(int i) {
        d.a(f, String.format(Locale.getDefault(), "【SDK-视频第一帧通知（实时）】 java_FirstFrame result[%d]", Integer.valueOf(i)));
        Message obtain = Message.obtain();
        obtain.what = 24;
        obtain.arg1 = i;
        c().sendMessage(obtain);
    }
}
