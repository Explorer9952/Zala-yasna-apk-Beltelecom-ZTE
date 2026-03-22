package com.zte.iptvclient.android.mobile.a0.c;

import android.text.TextUtils;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.prevue.SDKPrevueMgr;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.k.x;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TsTVPrevueListManager.java */
/* loaded from: classes2.dex */
public class b {
    private static b h;

    /* renamed from: b, reason: collision with root package name */
    private String f5555b;
    private Date g;

    /* renamed from: a, reason: collision with root package name */
    private String f5554a = "TsTVPrevueListManager";

    /* renamed from: d, reason: collision with root package name */
    private SimpleDateFormat f5557d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    private SimpleDateFormat e = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);
    private SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<PrevueBean> f5556c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TsTVPrevueListManager.java */
    /* loaded from: classes2.dex */
    public class a implements SDKPrevueMgr.OnPrevueListReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueListReturnListener
        public void onPrevueListReturn(String str, String str2, String str3) {
            LogEx.d(b.this.f5554a, "onPrevueListReturn returncode= " + str + "  errmsg " + str2 + "  jsp " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        PrevueBean prevueBeanFromJSon = PrevueBean.getPrevueBeanFromJSon(jSONArray.getJSONObject(i));
                        if (prevueBeanFromJSon != null) {
                            if (!TextUtils.isEmpty(prevueBeanFromJSon.getEndtime())) {
                                prevueBeanFromJSon.setDuration(TimeUtil.format(x.d(prevueBeanFromJSon.getBegintime()), "HH:mm") + " - " + TimeUtil.format(x.d(prevueBeanFromJSon.getEndtime()), "HH:mm"));
                            }
                            arrayList.add(prevueBeanFromJSon);
                        }
                    }
                    b.this.a((ArrayList<PrevueBean>) arrayList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private b() {
    }

    public static b b() {
        if (h == null) {
            h = new b();
        }
        return h;
    }

    public void a(String str, ArrayList<PrevueBean> arrayList) {
        LogEx.d(this.f5554a, "setCurrentChannelProgramesShcedulesList strChannelcode=" + str);
        if (arrayList == null) {
            if (this.f5556c != null && TextUtils.equals(this.f5555b, str)) {
                return;
            } else {
                this.f5556c = arrayList;
            }
        } else {
            ArrayList<PrevueBean> arrayList2 = this.f5556c;
            if (arrayList2 != null) {
                arrayList2.clear();
            } else {
                this.f5556c = new ArrayList<>();
            }
            this.f5556c.addAll(arrayList);
        }
        this.f5555b = str;
    }

    public void b(String str) {
        try {
            if (s.b().after(x.a(this.e.format(s.b()) + " 00:00:00", "yyyy.MM.dd HH:mm:ss"))) {
                if (s.b().before(x.a(this.e.format(s.b()) + " 02:00:00", "yyyy.MM.dd HH:mm:ss"))) {
                    this.f5555b = str;
                    a(TimeUtil.addOffset(s.b(), 6, -1));
                }
            }
            if (s.b().after(x.a(this.e.format(s.b()) + " 22:00:00", "yyyy.MM.dd HH:mm:ss"))) {
                if (s.b().before(x.a(this.e.format(s.b()) + " 23:59:59", "yyyy.MM.dd HH:mm:ss"))) {
                    this.f5555b = str;
                    a(TimeUtil.addOffset(s.b(), 6, 1));
                }
            }
            LogEx.d(this.f5554a, "no need update extroChannelProgrames");
        } catch (Exception e) {
            LogEx.e(this.f5554a, "e=" + e.getMessage());
        }
    }

    public ArrayList<PrevueBean> a(String str) {
        if (TextUtils.equals(this.f5555b, str)) {
            return this.f5556c;
        }
        return null;
    }

    public void a(Date date) {
        String str = this.f.format(date) + " 00:00:00";
        LogEx.d(this.f5554a, "start time " + str);
        String str2 = this.f.format(date) + " 23:59:59";
        LogEx.d(this.f5554a, "startTime is " + str + "   endTime is " + str2);
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("channelcode", this.f5555b);
        hashMap.put("begintime", str);
        hashMap.put("endtime", str2);
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", "500");
        sDKPrevueMgr.getPrevueList(hashMap, new a());
    }

    public boolean b(Date date, String str) {
        b((Date) null);
        ArrayList<PrevueBean> a2 = a(str);
        boolean z = true;
        if (date != null && a2 != null && a2.size() != 0) {
            int i = 0;
            boolean z2 = false;
            boolean z3 = true;
            while (true) {
                if (i >= a2.size()) {
                    z = z3;
                    break;
                }
                if (b(date, a2.get(i))) {
                    if (TextUtils.equals("0", a2.get(i).getTstv())) {
                        b(s.b());
                        z2 = true;
                        z3 = false;
                    }
                } else if (z2 && a(date, a2.get(i))) {
                    b(x.d(a2.get(i).getBegintime()));
                    break;
                }
                i++;
            }
        }
        LogEx.d(this.f5554a, "checkedTime" + date + " enableTs" + z + " enableTsDate " + a());
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<PrevueBean> arrayList) {
        ArrayList<PrevueBean> a2 = a(this.f5555b);
        if (a2 == null) {
            a(this.f5555b, arrayList);
            return;
        }
        if (arrayList.size() <= 0 || a2.size() <= 0 || TextUtils.isEmpty(arrayList.get(0).getBegintime()) || TextUtils.isEmpty(a2.get(0).getBegintime())) {
            return;
        }
        if (a(arrayList.get(0)).before(a(a2.get(0)))) {
            arrayList.addAll(a2);
            a(this.f5555b, arrayList);
        } else {
            a2.addAll(arrayList);
            a(this.f5555b, a2);
        }
    }

    private void b(Date date) {
        this.g = date;
    }

    private boolean b(Date date, PrevueBean prevueBean) {
        if (prevueBean != null && date != null) {
            Date d2 = x.d(prevueBean.getBegintime());
            Date d3 = x.d(prevueBean.getEndtime());
            if (date.getTime() >= d2.getTime() && date.getTime() < d3.getTime()) {
                LogEx.d(this.f5554a, "matchEnableTsTimeStamp CurrentTsBeginTime=" + this.f5557d.format(date) + " prevue=" + prevueBean.getDuration());
                return true;
            }
        }
        return false;
    }

    private Date a(PrevueBean prevueBean) {
        return x.d(prevueBean.getBegintime());
    }

    public boolean a(Date date, String str) {
        ArrayList<PrevueBean> a2 = a(str);
        boolean z = false;
        if (a2 != null && date != null && a2.size() != 0) {
            for (int i = 0; i < a2.size(); i++) {
                if (b(date, a2.get(i)) && TextUtils.equals("0", a2.get(i).getTstv())) {
                    break;
                }
            }
        }
        z = true;
        LogEx.d(this.f5554a, "checkCurrentTSBeginTimeEnableTs " + z);
        return z;
    }

    public Date a() {
        return this.g;
    }

    private boolean a(Date date, PrevueBean prevueBean) {
        if (prevueBean != null && date != null) {
            Date d2 = x.d(prevueBean.getBegintime());
            Date d3 = x.d(prevueBean.getEndtime());
            if ((date.getTime() <= d2.getTime() && d3.before(s.b()) && TextUtils.equals("1", prevueBean.getTstv())) || (date.before(d2) && s.b().before(d3) && TextUtils.equals("1", prevueBean.getTstv()))) {
                return true;
            }
        }
        return false;
    }
}
