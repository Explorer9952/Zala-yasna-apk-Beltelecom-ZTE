package com.zte.iptvclient.android.mobile.t;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.models.AnswerBean;
import com.zte.iptvclient.android.common.javabean.models.OptionBean;
import com.zte.iptvclient.android.common.javabean.models.QuizListBean;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AnswerFragment.java */
/* loaded from: classes2.dex */
public class a extends com.zte.fragmentlib.b {
    private TextView A;
    private Button B;
    private RelativeLayout J;
    private ImageView K;
    private TextView L;
    private TextView M;
    private Button N;
    private com.zte.iptvclient.android.mobile.t.c.a O;
    private ArrayList<OptionBean> T;
    private String U;
    private AnswerBean V;
    private List<OptionBean> W;
    private RelativeLayout p;
    private Button q;
    private Button r;
    private Button s;
    private Button t;
    private QuizListBean u;
    private ListView v;
    private RelativeLayout w;
    private RelativeLayout x;
    private TextView y;
    private TextView z;
    private String C = "";
    private String D = "";
    private String E = "";
    private String F = "";
    private String G = "";
    private int P = 0;
    private int Q = 0;
    private ArrayList<AnswerBean> R = new ArrayList<>();
    private ArrayList<OptionBean> S = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnswerFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.t.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0349a implements View.OnClickListener {
        ViewOnClickListenerC0349a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.x.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnswerFragment.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.getActivity() instanceof MainActivity) {
                a.this.F();
            } else if (a.this.getActivity() instanceof HostActivity) {
                a.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnswerFragment.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.e(a.this);
            if (a.this.R.size() > a.this.P) {
                a aVar = a.this;
                aVar.V = (AnswerBean) aVar.R.get(a.this.P);
                a aVar2 = a.this;
                aVar2.W = ((AnswerBean) aVar2.R.get(a.this.P)).getOptionList();
            }
            a.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnswerFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.d(a.this);
            if (a.this.R.size() > a.this.P) {
                a aVar = a.this;
                aVar.V = (AnswerBean) aVar.R.get(a.this.P);
                a aVar2 = a.this;
                aVar2.W = ((AnswerBean) aVar2.R.get(a.this.P)).getOptionList();
            }
            a.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnswerFragment.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnswerFragment.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.getActivity() instanceof MainActivity) {
                a.this.F();
            } else if (a.this.getActivity() instanceof HostActivity) {
                a.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnswerFragment.java */
    /* loaded from: classes2.dex */
    public class g implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        g() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("AnswerFragment", "sdk_getquizinfo onDataReturn =" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("returncode");
                if (!TextUtils.isEmpty(jSONObject.optString("totalcount"))) {
                    a.this.Q = Integer.valueOf(jSONObject.optString("totalcount")).intValue();
                }
                if (!"0".equals(optString)) {
                    a.this.w.setVisibility(0);
                    return;
                }
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                for (int i = 0; i < jSONArray.length(); i++) {
                    a.this.T = new ArrayList();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    a.this.R.add(AnswerBean.getAnswerBeanFromJSon(jSONObject2));
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("optionlist");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        a.this.T.add(OptionBean.getOptionBeanFromJSon(jSONArray2.getJSONObject(i2)));
                    }
                    if (a.this.T.size() == 0) {
                        ((AnswerBean) a.this.R.get(i)).setOptionList(a.this.S);
                    } else {
                        ((AnswerBean) a.this.R.get(i)).setOptionList(a.this.T);
                    }
                }
                if (a.this.R == null || a.this.R.size() <= 0) {
                    a.this.w.setVisibility(0);
                    return;
                }
                if (a.this.R.size() > a.this.P) {
                    a.this.V = (AnswerBean) a.this.R.get(a.this.P);
                    a.this.W = ((AnswerBean) a.this.R.get(a.this.P)).getOptionList();
                }
                a.this.K();
            } catch (JSONException e) {
                e.printStackTrace();
                a.this.w.setVisibility(0);
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("AnswerFragment", "sdk_getquizinfo onFailReturn returncode=" + i + " errormsg " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnswerFragment.java */
    /* loaded from: classes2.dex */
    public class h implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        h() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("AnswerFragment", "sdk_submitanswer onDataReturn =" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("returncode");
                if ("0".equals(optString)) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("data"));
                    String optString2 = jSONObject2.optString("usersubjectscore");
                    String optString3 = jSONObject2.optString("passstate");
                    a.this.J.setVisibility(0);
                    if (a.this.G.equals("0")) {
                        a.this.L.setVisibility(0);
                        a.this.L.setText(optString2);
                    } else {
                        a.this.L.setVisibility(4);
                    }
                    a.this.M.setText(((com.zte.fragmentlib.b) a.this).h.getResources().getString(R.string.congratulations_txt));
                    if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(optString3)) {
                        a.this.K.setImageDrawable(((com.zte.fragmentlib.b) a.this).h.getResources().getDrawable(R.drawable.img_smile));
                    } else {
                        a.this.K.setImageDrawable(((com.zte.fragmentlib.b) a.this).h.getResources().getDrawable(R.drawable.img_cry));
                    }
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.d());
                }
                if ("500".equals(optString)) {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(((com.zte.fragmentlib.b) a.this).h.getResources().getString(R.string.operation_failed));
                }
                a.this.O.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("AnswerFragment", "sdk_submitanswer onFailReturn returncode=" + i + " errormsg " + str);
            a.this.O.notifyDataSetChanged();
        }
    }

    private void J() {
        this.B.setOnClickListener(new ViewOnClickListenerC0349a());
        this.q.setOnClickListener(new b());
        this.s.setOnClickListener(new c());
        this.t.setOnClickListener(new d());
        this.r.setOnClickListener(new e());
        this.N.setOnClickListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        com.zte.iptvclient.android.mobile.t.c.a aVar = new com.zte.iptvclient.android.mobile.t.c.a(this.h, this.V, this.W, String.valueOf(this.P + 1));
        this.O = aVar;
        this.v.setAdapter((ListAdapter) aVar);
        if (this.P == 0) {
            this.s.setBackgroundResource(R.drawable.login_out_bg_coner);
            this.s.setTextColor(c.a.a.a.d.b.d().b(R.color.account_text_textcolor));
            this.s.setEnabled(false);
        } else {
            this.s.setBackgroundResource(R.drawable.login_out_bg);
            this.s.setTextColor(c.a.a.a.d.b.d().b(R.color.login_status_bg));
            this.s.setEnabled(true);
        }
        if (this.Q == this.P + 1) {
            this.t.setBackgroundResource(R.drawable.login_out_bg_coner);
            this.t.setTextColor(c.a.a.a.d.b.d().b(R.color.account_text_textcolor));
            this.t.setEnabled(false);
            this.r.setVisibility(0);
            return;
        }
        this.t.setBackgroundResource(R.drawable.login_out_bg);
        this.t.setTextColor(c.a.a.a.d.b.d().b(R.color.login_status_bg));
        this.t.setEnabled(true);
        this.r.setVisibility(4);
    }

    private String L() {
        JsonArray jsonArray = new JsonArray();
        if (this.R == null) {
            return "";
        }
        for (int i = 0; i < this.R.size(); i++) {
            JsonObject jsonObject = new JsonObject();
            this.U = "";
            for (int i2 = 0; i2 < this.R.get(i).getOptionList().size(); i2++) {
                if (this.R.get(i).getOptionList().get(i2).isSelected()) {
                    this.U += this.R.get(i).getOptionList().get(i2).getOptionid() + ",";
                }
            }
            if (!TextUtils.isEmpty(this.U)) {
                this.U = this.U.substring(0, r5.length() - 1);
            }
            jsonObject.addProperty("userquestionoption", this.U);
            jsonObject.addProperty("questionid", this.R.get(i).getQuestionid());
            jsonArray.add(jsonObject);
        }
        LogEx.d("AnswerFragment", "array= " + jsonArray.toString());
        return Uri.encode(jsonArray.toString(), "UTF-8");
    }

    private void M() {
        ArrayList<AnswerBean> arrayList = this.R;
        if (arrayList != null) {
            arrayList.clear();
        }
        String str = "http://{ipadd:port}/iptvepg/{frame}/sdk_getquizinfo.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", i.f()) + "?subjectcode=" + this.u.getSubjectcode();
        LogEx.d("AnswerFragment", "sdk_getquizinfo url = " + str);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        String str = "http://{ipadd:port}/iptvepg/{frame}/sdk_submitanswer.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", i.f()) + "?questionlist=" + L() + "&subjectcode=" + this.u.getSubjectcode();
        LogEx.d("AnswerFragment", "sdk_submitanswer url = " + str);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new h());
    }

    static /* synthetic */ int d(a aVar) {
        int i = aVar.P;
        aVar.P = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.P;
        aVar.P = i - 1;
        return i;
    }

    public void I() {
        String str = this.F;
        if (str != null) {
            this.y.setText(str);
        }
        if (!TextUtils.isEmpty(this.E) && this.G.equals("0")) {
            this.A.setText(this.h.getResources().getString(R.string.last_answer).replace("xxx", this.E));
            this.A.setVisibility(0);
        } else {
            this.A.setVisibility(8);
        }
        if ("1".equals(this.C)) {
            this.z.setText(this.h.getResources().getString(R.string.complete_answer));
            this.A.setVisibility(0);
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
            this.A.setVisibility(8);
        }
        if (this.z.getVisibility() == 0) {
            this.B.setText(this.h.getResources().getString(R.string.again));
        } else {
            this.B.setText(this.h.getResources().getString(R.string.enter));
        }
        if ("0".equals(this.D)) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(4);
        }
        M();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        I();
        J();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            QuizListBean quizListBean = (QuizListBean) arguments.getSerializable("myDataBean");
            this.u = quizListBean;
            this.C = quizListBean.getSubjectstate();
            this.D = this.u.getAnswerstate();
            this.E = this.u.getUserSubjectScore();
            this.F = this.u.getSubjectdescription();
            this.G = this.u.getSubjecttype();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.answer_layout, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    private void d(View view) {
        com.zte.iptvclient.android.common.k.g.a(this.h, view, R.id.title_bottom_line);
        ImageView imageView = (ImageView) view.findViewById(R.id.title_bottom_line);
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.p = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.q = (Button) view.findViewById(R.id.btn_back);
        Button button = (Button) view.findViewById(R.id.btn_confirm);
        this.r = button;
        button.setText(this.h.getResources().getString(R.string.confirm_answer));
        this.s = (Button) view.findViewById(R.id.btn_last);
        this.t = (Button) view.findViewById(R.id.btn_next);
        this.v = (ListView) view.findViewById(R.id.answer_lv);
        this.J = (RelativeLayout) view.findViewById(R.id.rl_score);
        this.K = (ImageView) view.findViewById(R.id.img_score);
        this.L = (TextView) view.findViewById(R.id.txt_score);
        this.M = (TextView) view.findViewById(R.id.txt_returnmsg);
        this.N = (Button) view.findViewById(R.id.btn_ok);
        this.x = (RelativeLayout) view.findViewById(R.id.rl_quiztips);
        this.y = (TextView) view.findViewById(R.id.txt_quiz_tip);
        this.z = (TextView) view.findViewById(R.id.txt_answer);
        this.A = (TextView) view.findViewById(R.id.txt_last_answer);
        this.B = (Button) view.findViewById(R.id.btn_start);
        this.x.setVisibility(0);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.w = relativeLayout;
        relativeLayout.setVisibility(8);
        com.zte.iptvclient.common.uiframe.f.a(this.w.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.w.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.w.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.w.findViewById(R.id.refresh_image));
        ((TextView) this.w.findViewById(R.id.txt_pullrefresh)).setText(this.h.getResources().getString(R.string.there_is_no_collection));
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.J);
        com.zte.iptvclient.common.uiframe.f.a(this.K);
        com.zte.iptvclient.common.uiframe.f.a(this.L);
        com.zte.iptvclient.common.uiframe.f.a(this.M);
        com.zte.iptvclient.common.uiframe.f.a(this.N);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        OptionBean optionBean = new OptionBean();
        optionBean.setOptionid("");
        this.S.add(optionBean);
    }
}
