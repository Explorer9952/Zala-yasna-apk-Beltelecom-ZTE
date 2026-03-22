package com.scwang.smartrefresh.layout.constant;

/* loaded from: classes.dex */
public enum DimensionStatus {
    DefaultUnNotify(false),
    Default(true),
    XmlWrap(true),
    XmlLayoutUnNotify(false),
    XmlLayout(true),
    XmlExact(true),
    CodeExactUnNotify(false),
    CodeExact(true),
    DeadLockUnNotify(false),
    DeadLock(true);

    public final boolean notifyed;

    DimensionStatus(boolean z) {
        this.notifyed = z;
    }

    public boolean canReplaceWith(DimensionStatus dimensionStatus) {
        return ordinal() < dimensionStatus.ordinal() || (!this.notifyed && ordinal() == dimensionStatus.ordinal());
    }

    public boolean gteReplaceWith(DimensionStatus dimensionStatus) {
        return ordinal() >= dimensionStatus.ordinal();
    }

    public DimensionStatus notifyed() {
        return !this.notifyed ? values()[ordinal() + 1] : this;
    }

    public DimensionStatus unNotify() {
        if (!this.notifyed) {
            return this;
        }
        DimensionStatus dimensionStatus = values()[ordinal() - 1];
        return !dimensionStatus.notifyed ? dimensionStatus : DefaultUnNotify;
    }
}
