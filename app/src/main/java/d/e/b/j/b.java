package d.e.b.j;

import android.os.Message;
import com.google.gson.Gson;
import com.zte.ucs.tvcall.ocx.ResultInfo;
import com.zte.ucs.tvcall.ocx.presence.PresCheckDocCallbackInfo;
import com.zte.ucs.tvcall.ocx.presence.PresContactFreeTextSynNotify;
import com.zte.ucs.tvcall.ocx.presence.PresContactNode;
import com.zte.ucs.tvcall.ocx.presence.PresDocumentInfoNode;
import com.zte.ucs.tvcall.ocx.presence.PresPersonalFreeTextNotify;
import com.zte.ucs.tvcall.ocx.presence.PresRespContactInfo;
import com.zte.ucs.tvcall.ocx.presence.PresRespInfo;
import com.zte.ucs.tvcall.ocx.presence.PresUniversalNotify;
import com.zte.ucs.tvcall.ocx.presence.PresUniversalNotifyInfo;
import com.zte.ucs.tvcall.ocx.presence.PresUniversalResp;
import com.zte.ucs.tvcall.ocx.presence.PresUploadFreeTextResp;
import d.e.b.n.d;
import java.util.Locale;

/* loaded from: classes2.dex */
public class b extends d.e.b.b.b implements a {

    /* renamed from: d, reason: collision with root package name */
    private final String f8064d = b.class.getName();

    @Override // d.e.b.j.a
    public void a(PresContactFreeTextSynNotify presContactFreeTextSynNotify) {
        String json = new Gson().toJson(presContactFreeTextSynNotify);
        d.a(this.f8064d, "【呈现-好友个性签名更新通知】 java_PresContactFreeTextSynNotify " + json);
        Message obtain = Message.obtain();
        obtain.what = 36;
        obtain.obj = presContactFreeTextSynNotify;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void a(PresPersonalFreeTextNotify presPersonalFreeTextNotify) {
        String json = new Gson().toJson(presPersonalFreeTextNotify);
        d.a(this.f8064d, "【呈现-个人个性签名通知(文档检查使用)】 java_PresFreeTextReturn " + json);
        Message obtain = Message.obtain();
        obtain.what = 35;
        obtain.obj = presPersonalFreeTextNotify;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void a(PresUniversalNotify presUniversalNotify) {
        String json = new Gson().toJson(presUniversalNotify);
        String format = String.format(Locale.getDefault(), "【呈现-好友头像更新通知】 java_PresContactIconChangedNotify PresUniversalNotify[%s] ", presUniversalNotify.toString());
        d.a(this.f8064d, format + "," + json);
        PresUniversalNotifyInfo presUniversalNotifyInfo = new PresUniversalNotifyInfo();
        presUniversalNotifyInfo.setAccountid(presUniversalNotify.getAccountid());
        presUniversalNotifyInfo.setContactid(presUniversalNotify.getContactid());
        presUniversalNotifyInfo.setReason(presUniversalNotify.getReason());
        presUniversalNotifyInfo.setState(presUniversalNotify.getState());
        presUniversalNotifyInfo.seteTag(presUniversalNotify.geteTag());
        Message obtain = Message.obtain();
        obtain.what = 9;
        obtain.obj = presUniversalNotifyInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void a(PresUploadFreeTextResp presUploadFreeTextResp) {
        String json = new Gson().toJson(presUploadFreeTextResp);
        d.a(this.f8064d, "【呈现-更新自己的个人签名回调】 java_PresUploadFreeText " + json);
        Message obtain = Message.obtain();
        obtain.what = 34;
        obtain.obj = presUploadFreeTextResp;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void a(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        String json = new Gson().toJson(presUniversalResp);
        String format = String.format(Locale.getDefault(), "【呈现-将用户添加到Block列表通知】 java_PresAddUserIntoBlockList sessionID[%s], lResult[%d]  ", str, Integer.valueOf(resultInfo.getResult()));
        d.a(this.f8064d, format + "," + json);
        PresRespInfo presRespInfo = new PresRespInfo();
        presRespInfo.setPresUniversalResp(presUniversalResp);
        presRespInfo.setSessionID(str);
        presRespInfo.setResultInfo(resultInfo);
        Message obtain = Message.obtain();
        obtain.what = 13;
        obtain.obj = presRespInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void a(String str, ResultInfo resultInfo, PresDocumentInfoNode[] presDocumentInfoNodeArr) {
        String json = new Gson().toJson(presDocumentInfoNodeArr);
        String format = String.format(Locale.getDefault(), "【呈现-文件检查请求通知】 java_PresCheckDocuments sessionID[%s], lResult[%d]  ", str, Integer.valueOf(resultInfo.getResult()));
        d.a(this.f8064d, format + "," + json);
        PresCheckDocCallbackInfo presCheckDocCallbackInfo = new PresCheckDocCallbackInfo();
        presCheckDocCallbackInfo.setSessionID(str);
        presCheckDocCallbackInfo.setResultInfo(resultInfo);
        presCheckDocCallbackInfo.setRespobjarray(presDocumentInfoNodeArr);
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = presCheckDocCallbackInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void a(String str, PresUniversalResp presUniversalResp) {
        String json = new Gson().toJson(presUniversalResp);
        String format = String.format(Locale.getDefault(), "【呈现-Content XDMS通知】 java_PresContentReturn sessionID[%s]  ", str);
        d.a(this.f8064d, format + "," + json);
        PresRespInfo presRespInfo = new PresRespInfo();
        presRespInfo.setPresUniversalResp(presUniversalResp);
        presRespInfo.setSessionID(str);
        Message obtain = Message.obtain();
        obtain.what = 10;
        obtain.obj = presRespInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void a(String str, String str2, PresContactNode[] presContactNodeArr) {
        String json = new Gson().toJson(presContactNodeArr);
        String format = String.format(Locale.getDefault(), "【呈现-联系人列表通知】 java_PresContactListReturn sessionID[%s], accountid[%s]  ", str, str2);
        d.a(this.f8064d, format + "," + json);
        PresRespContactInfo presRespContactInfo = new PresRespContactInfo();
        presRespContactInfo.setAccountid(str2);
        presRespContactInfo.setSessionID(str);
        presRespContactInfo.setPresContactNodes(presContactNodeArr);
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = presRespContactInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void b(PresUniversalNotify presUniversalNotify) {
        String json = new Gson().toJson(presUniversalNotify);
        String format = String.format(Locale.getDefault(), "【呈现-联系人状态同步通知】 java_PresBuddyStatusNotify PresUniversalNotify[%s] ", presUniversalNotify.toString());
        d.a(this.f8064d, format + "," + json);
        PresUniversalNotifyInfo presUniversalNotifyInfo = new PresUniversalNotifyInfo();
        presUniversalNotifyInfo.setAccountid(presUniversalNotify.getAccountid());
        presUniversalNotifyInfo.setContactid(presUniversalNotify.getContactid());
        presUniversalNotifyInfo.setReason(presUniversalNotify.getReason());
        presUniversalNotifyInfo.setState(presUniversalNotify.getState());
        Message obtain = Message.obtain();
        obtain.what = 8;
        obtain.obj = presUniversalNotifyInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void b(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        String json = new Gson().toJson(presUniversalResp);
        String format = String.format(Locale.getDefault(), "【呈现-联系人头像获取通知】 java_PresLoadContactIcon sessionID[%s], lResult[%d]  ", str, Integer.valueOf(resultInfo.getResult()));
        d.a(this.f8064d, format + "," + json);
        PresRespInfo presRespInfo = new PresRespInfo();
        presRespInfo.setPresUniversalResp(presUniversalResp);
        presRespInfo.setSessionID(str);
        presRespInfo.setResultInfo(resultInfo);
        Message obtain = Message.obtain();
        obtain.what = 31;
        obtain.obj = presRespInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void c(PresUniversalNotify presUniversalNotify) {
        String json = new Gson().toJson(presUniversalNotify);
        String format = String.format(Locale.getDefault(), "【呈现-邀请添加好友通知】 java_PresAddBuddyNotify PresUniversalNotify[%s] ", presUniversalNotify.toString());
        d.a(this.f8064d, format + "," + json);
        PresUniversalNotifyInfo presUniversalNotifyInfo = new PresUniversalNotifyInfo();
        presUniversalNotifyInfo.setAccountid(presUniversalNotify.getAccountid());
        presUniversalNotifyInfo.setContactid(presUniversalNotify.getContactid());
        presUniversalNotifyInfo.setReason(presUniversalNotify.getReason());
        presUniversalNotifyInfo.setState(presUniversalNotify.getState());
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = presUniversalNotifyInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void c(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        String json = new Gson().toJson(presUniversalResp);
        String format = String.format(Locale.getDefault(), "【呈现-将用户从RCS列表删除通知】 java_PresDeleteUserFromRCSList sessionID[%s], lResult[%d]  ", str, Integer.valueOf(resultInfo.getResult()));
        d.a(this.f8064d, format + "," + json);
        PresRespInfo presRespInfo = new PresRespInfo();
        presRespInfo.setPresUniversalResp(presUniversalResp);
        presRespInfo.setSessionID(str);
        presRespInfo.setResultInfo(resultInfo);
        Message obtain = Message.obtain();
        obtain.what = 14;
        obtain.obj = presRespInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void d(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        String json = new Gson().toJson(presUniversalResp);
        String format = String.format(Locale.getDefault(), "【呈现-上传默认文档通知】 java_PresUploadDefaultDocument sessionID[%s], lResult[%d]  ", str, Integer.valueOf(resultInfo.getResult()));
        d.a(this.f8064d, format + "," + json);
        PresRespInfo presRespInfo = new PresRespInfo();
        presRespInfo.setPresUniversalResp(presUniversalResp);
        presRespInfo.setSessionID(str);
        presRespInfo.setResultInfo(resultInfo);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = presRespInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void e(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        String json = new Gson().toJson(presUniversalResp);
        String format = String.format(Locale.getDefault(), "【呈现-告知个人头像更新通知】 java_PresUploadPresenceXDMS sessionID[%s], lResult[%d]  ", str, Integer.valueOf(resultInfo.getResult()));
        d.a(this.f8064d, format + "," + json);
        PresRespInfo presRespInfo = new PresRespInfo();
        presRespInfo.setPresUniversalResp(presUniversalResp);
        presRespInfo.setSessionID(str);
        presRespInfo.setResultInfo(resultInfo);
        Message obtain = Message.obtain();
        obtain.what = 33;
        obtain.obj = presRespInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void f(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        String json = new Gson().toJson(presUniversalResp);
        String format = String.format(Locale.getDefault(), "【呈现-订阅RLS信息通知】 java_PresSubscribeRLSInfo sessionID[%s] lResult[%d]", str, Integer.valueOf(resultInfo.getResult()));
        d.a(this.f8064d, format + "," + json);
        PresRespInfo presRespInfo = new PresRespInfo();
        presRespInfo.setResultInfo(resultInfo);
        presRespInfo.setSessionID(str);
        presRespInfo.setPresUniversalResp(presUniversalResp);
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.obj = presRespInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void g(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        String json = new Gson().toJson(presUniversalResp);
        String format = String.format(Locale.getDefault(), "【呈现-获取实时文档通知】 java_PresLoadCurrentDocument sessionID[%s], lResult[%d]  ", str, Integer.valueOf(resultInfo.getResult()));
        d.a(this.f8064d, format + "," + json);
        PresRespInfo presRespInfo = new PresRespInfo();
        presRespInfo.setPresUniversalResp(presUniversalResp);
        presRespInfo.setSessionID(str);
        presRespInfo.setResultInfo(resultInfo);
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = presRespInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void h(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        String json = new Gson().toJson(presUniversalResp);
        String format = String.format(Locale.getDefault(), "【呈现-上传个人头像通知】 java_PresUploadPersonalIcon sessionID[%s], lResult[%d]  ", str, Integer.valueOf(resultInfo.getResult()));
        d.a(this.f8064d, format + "," + json);
        PresRespInfo presRespInfo = new PresRespInfo();
        presRespInfo.setPresUniversalResp(presUniversalResp);
        presRespInfo.setSessionID(str);
        presRespInfo.setResultInfo(resultInfo);
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = presRespInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void i(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        String json = new Gson().toJson(presUniversalResp);
        String format = String.format(Locale.getDefault(), "【呈现-将用户从Block列表中删除通知】 java_PresDeleteUserFromBlockList sessionID[%s], lResult[%d]  ", str, Integer.valueOf(resultInfo.getResult()));
        d.a(this.f8064d, format + "," + json);
        PresRespInfo presRespInfo = new PresRespInfo();
        presRespInfo.setPresUniversalResp(presUniversalResp);
        presRespInfo.setSessionID(str);
        presRespInfo.setResultInfo(resultInfo);
        Message obtain = Message.obtain();
        obtain.what = 16;
        obtain.obj = presRespInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void j(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        String json = new Gson().toJson(presUniversalResp);
        String format = String.format(Locale.getDefault(), "【呈现-订阅全部信息通知】 java_PresSubscribeAllInfo sessionID[%s] lResult[%d]", str, Integer.valueOf(resultInfo.getResult()));
        d.a(this.f8064d, format + "," + json);
        PresRespInfo presRespInfo = new PresRespInfo();
        presRespInfo.setResultInfo(resultInfo);
        presRespInfo.setSessionID(str);
        presRespInfo.setPresUniversalResp(presUniversalResp);
        Message obtain = Message.obtain();
        obtain.what = 7;
        obtain.obj = presRespInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void k(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        String json = new Gson().toJson(presUniversalResp);
        String format = String.format(Locale.getDefault(), "【呈现-将用户添加到Revoke列表通知】 java_PresAddUserIntoRevokeList sessionID[%s], lResult[%d]  ", str, Integer.valueOf(resultInfo.getResult()));
        d.a(this.f8064d, format + "," + json);
        PresRespInfo presRespInfo = new PresRespInfo();
        presRespInfo.setPresUniversalResp(presUniversalResp);
        presRespInfo.setSessionID(str);
        presRespInfo.setResultInfo(resultInfo);
        Message obtain = Message.obtain();
        obtain.what = 12;
        obtain.obj = presRespInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void l(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        String json = new Gson().toJson(presUniversalResp);
        String format = String.format(Locale.getDefault(), "【呈现-订阅Watcher信息通知】 java_PresSubscribeWatcherInfo sessionID[%s] lResult[%d]", str, Integer.valueOf(resultInfo.getResult()));
        d.a(this.f8064d, format + "," + json);
        PresRespInfo presRespInfo = new PresRespInfo();
        presRespInfo.setResultInfo(resultInfo);
        presRespInfo.setSessionID(str);
        presRespInfo.setPresUniversalResp(presUniversalResp);
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.obj = presRespInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.j.a
    public void m(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        int i;
        String json = new Gson().toJson(presUniversalResp);
        String format = String.format(Locale.getDefault(), "【呈现-添加用户到RCS联系人通知】 java_PresAddUserIntoRCSList sessionID[%s], lResult[%d]  ", str, Integer.valueOf(resultInfo.getResult()));
        d.a(this.f8064d, format + "," + json);
        PresRespInfo presRespInfo = new PresRespInfo();
        presRespInfo.setPresUniversalResp(presUniversalResp);
        presRespInfo.setSessionID(str);
        presRespInfo.setResultInfo(resultInfo);
        Message obtain = Message.obtain();
        if (presUniversalResp.getActionMode() == 1) {
            i = 11;
        } else {
            if (presUniversalResp.getActionMode() != 2) {
                d.a(this.f8064d, "respobj.getActionMode() is illegal!");
                d.a(this.f8064d, "java_PresAddUserIntoRCSList end");
            }
            i = 18;
        }
        obtain.what = i;
        obtain.obj = presRespInfo;
        c().sendMessage(obtain);
        d.a(this.f8064d, "java_PresAddUserIntoRCSList end");
    }

    @Override // d.e.b.j.a
    public void n(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        String json = new Gson().toJson(presUniversalResp);
        String format = String.format(Locale.getDefault(), "【呈现-将用户从Revoke列表中删除通知】 java_PresDeleteUserFromRevokeList sessionID[%s], lResult[%d]  ", str, Integer.valueOf(resultInfo.getResult()));
        d.a(this.f8064d, format + "," + json);
        PresRespInfo presRespInfo = new PresRespInfo();
        presRespInfo.setPresUniversalResp(presUniversalResp);
        presRespInfo.setSessionID(str);
        presRespInfo.setResultInfo(resultInfo);
        Message obtain = Message.obtain();
        obtain.what = 15;
        obtain.obj = presRespInfo;
        c().sendMessage(obtain);
    }
}
