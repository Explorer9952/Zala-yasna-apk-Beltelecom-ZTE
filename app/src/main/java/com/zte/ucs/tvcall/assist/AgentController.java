package com.zte.ucs.tvcall.assist;

import android.annotation.SuppressLint;
import d.e.b.n.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public class AgentController {
    public static final int AllPno = 0;
    public static final int HTTP_PNO = 14;
    public static final int MSRPAgentPno = 15;
    public static final int MSRPAssistDispatchPno = 17;
    public static final int MSRPAssistSendPno = 16;
    public static final int MediaAgentPno = 18;
    public static final int MediaAssistAudioRtpPno = 20;
    public static final int MediaAssistWaveoutPno = 19;
    public static final int PRO_SERVICE = 2;
    public static final int SET_THREAD_ID = 1;
    public static final int SIPAgentPno = 12;
    public static final int SoftAgentPno = 11;
    public static final int UIThreadID = 10;
    public static final int XCAPAgentPno = 13;
    public static boolean blauncher = false;

    @SuppressLint({"UseSparseArrays"})
    private static final HashMap<Integer, String> mThreadtagMap = new HashMap<>();

    @SuppressLint({"UseSparseArrays"})
    private static final HashMap<Integer, AgentThread> mThreadMap = new HashMap<>();
    static String Tag = "TvCall.AgentController";

    static {
        mThreadtagMap.put(10, "UIThreadID");
        mThreadtagMap.put(11, "ocxAgent");
        mThreadtagMap.put(12, "sipAgent");
        mThreadtagMap.put(13, "xcapAgent");
        mThreadtagMap.put(14, "httpAgentPno");
        mThreadtagMap.put(15, "MSRPAgent");
        mThreadtagMap.put(16, "MSRPAssistSendPno");
        mThreadtagMap.put(17, "MSRPAssistDispatch");
        mThreadtagMap.put(18, "MediaAgent");
        mThreadtagMap.put(19, "MediaAssistWaveout");
        mThreadtagMap.put(20, "MediaAssistAudioRtp");
    }

    public static void debug(String str, String str2) {
        d.c(str, str2);
    }

    public static void error(String str, String str2) {
        d.d(str, str2);
    }

    public static void info(String str, String str2) {
        d.a(str, str2);
    }

    public static void loadZxinOSLibrary() {
        System.loadLibrary("zxinos");
        Native.setEnv(1);
        System.loadLibrary("BasicFunc");
        System.loadLibrary("zteexpat");
        System.loadLibrary("msrp");
        System.loadLibrary("xcap");
        System.loadLibrary("sip");
    }

    static void myPostMsg(int i, int i2) {
        String format;
        if (mThreadMap.containsKey(Integer.valueOf(i))) {
            String str = mThreadtagMap.get(Integer.valueOf(i));
            d.c(Tag, String.format(Locale.getDefault(), "reciever thread[%s],pno[%d],msgPtr[%d]", str, Integer.valueOf(i), Integer.valueOf(i2)));
            AgentThread agentThread = mThreadMap.get(Integer.valueOf(i));
            if (agentThread != null && agentThread.ownLooperThread != null) {
                agentThread.postServiceMsg(i2);
                return;
            }
            format = String.format(Locale.getDefault(), "the reciever thread[%s],pno[%d] not launch!", str, Integer.valueOf(i));
        } else {
            format = String.format(Locale.getDefault(), "reciever thread[Unknown] pno[%d],msgPtr[%d]", Integer.valueOf(i), Integer.valueOf(i2));
        }
        d.d(Tag, format);
    }

    static int startAllThread() {
        d.a(Tag, "Start All Thread");
        mThreadMap.clear();
        Iterator<Integer> it2 = mThreadtagMap.keySet().iterator();
        while (it2.hasNext()) {
            startThread(it2.next().intValue());
        }
        return 0;
    }

    static void startThread(int i) {
        if (!mThreadtagMap.containsKey(Integer.valueOf(i))) {
            d.d(Tag, String.format(Locale.getDefault(), "startThread[Unknown] pno[%d]", Integer.valueOf(i)));
            return;
        }
        String str = mThreadtagMap.get(Integer.valueOf(i));
        d.a(Tag, String.format(Locale.getDefault(), "startThread[%s] pno[%d]", str, Integer.valueOf(i)));
        AgentThread agentThread = new AgentThread(str, i);
        mThreadMap.put(Integer.valueOf(i), agentThread);
        agentThread.startThread();
    }

    static int stopThread(int i) {
        if (mThreadMap.containsKey(Integer.valueOf(i))) {
            d.a(Tag, String.format(Locale.getDefault(), "stopThread[%s] pno[%d]", mThreadtagMap.get(Integer.valueOf(i)), Integer.valueOf(i)));
            AgentThread agentThread = mThreadMap.get(Integer.valueOf(i));
            if (agentThread != null) {
                agentThread.stopThread();
            }
        } else {
            d.d(Tag, String.format(Locale.getDefault(), "stopThread[Unknown] pno[%d]", Integer.valueOf(i)));
        }
        return 0;
    }

    public static void warning(String str, String str2) {
        d.b(str, str2);
    }
}
