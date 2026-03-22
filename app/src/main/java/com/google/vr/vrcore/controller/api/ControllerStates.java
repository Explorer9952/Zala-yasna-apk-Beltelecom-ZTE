package com.google.vr.vrcore.controller.api;

/* loaded from: classes.dex */
public class ControllerStates {
    public static final int CONNECTED = 3;
    public static final int CONNECTING = 2;
    public static final int DISCONNECTED = 0;
    public static final int SCANNING = 1;

    public static final String toString(int i) {
        if (i == 0) {
            return "DISCONNECTED";
        }
        if (i == 1) {
            return "SCANNING";
        }
        if (i == 2) {
            return "CONNECTING";
        }
        if (i == 3) {
            return "CONNECTED";
        }
        StringBuilder sb = new StringBuilder(39);
        sb.append("[UNKNOWN CONTROLLER STATE: ");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }
}
