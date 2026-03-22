package com.zte.sdk.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
public class SipStatusException extends Exception {
    private static final long serialVersionUID = -4873475340802779322L;
    private Throwable cause;
    private String error_code;
    private String error_message;

    public SipStatusException(String str) {
        super(str);
        this.error_code = "";
        this.error_message = "";
        this.error_code = str;
    }

    public SipStatusException(String str, String str2, Throwable th) {
        super(str);
        this.error_code = "";
        this.error_message = "";
        this.error_code = str;
        this.cause = th;
        this.error_message = str2;
    }

    public SipStatusException(Throwable th) {
        this.error_code = "";
        this.error_message = "";
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public String getError_code() {
        return this.error_code;
    }

    public String getError_message() {
        return this.error_message;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        Throwable cause = getCause();
        if (cause != null) {
            message = message + "    " + this.error_message + ";    \n" + cause.getMessage();
        }
        return message + "    " + this.error_message;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        if (getCause() == null) {
            super.printStackTrace(printStream);
        } else {
            printStream.println(this);
            getCause().printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        if (getCause() == null) {
            super.printStackTrace(printWriter);
        } else {
            printWriter.println(this);
            getCause().printStackTrace(printWriter);
        }
    }

    public void setCause(Throwable th) {
        this.cause = th;
    }

    public void setError_code(String str) {
        this.error_code = str;
    }

    public void setError_message(String str) {
        this.error_message = str;
    }
}
