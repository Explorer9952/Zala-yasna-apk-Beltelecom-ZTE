package com.squareup.leakcanary;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class LeakTrace implements Serializable {
    public final List<LeakTraceElement> elements;

    LeakTrace(List<LeakTraceElement> list) {
        this.elements = Collections.unmodifiableList(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.elements.size(); i++) {
            LeakTraceElement leakTraceElement = this.elements.get(i);
            sb.append("* ");
            if (i == 0) {
                sb.append("GC ROOT ");
            } else if (i == this.elements.size() - 1) {
                sb.append("leaks ");
            } else {
                sb.append("references ");
            }
            sb.append(leakTraceElement);
            sb.append("\n");
        }
        return sb.toString();
    }
}
