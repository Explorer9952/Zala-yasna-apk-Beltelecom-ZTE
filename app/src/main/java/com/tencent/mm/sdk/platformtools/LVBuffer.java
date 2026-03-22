package com.tencent.mm.sdk.platformtools;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class LVBuffer {
    public static final int LENGTH_ALLOC_PER_NEW = 4096;
    public static final int MAX_STRING_LENGTH = 2048;
    private ByteBuffer ap;
    private boolean aq;

    private int a(int i) {
        if (this.ap.limit() - this.ap.position() > i) {
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(this.ap.limit() + 4096);
        allocate.put(this.ap.array(), 0, this.ap.position());
        this.ap = allocate;
        return 0;
    }

    public byte[] buildFinish() {
        if (!this.aq) {
            throw new Exception("Buffer For Parse");
        }
        a(1);
        this.ap.put((byte) 125);
        int position = this.ap.position();
        byte[] bArr = new byte[position];
        System.arraycopy(this.ap.array(), 0, bArr, 0, position);
        return bArr;
    }

    public boolean checkGetFinish() {
        return this.ap.limit() - this.ap.position() <= 1;
    }

    public int getInt() {
        if (this.aq) {
            throw new Exception("Buffer For Build");
        }
        return this.ap.getInt();
    }

    public long getLong() {
        if (this.aq) {
            throw new Exception("Buffer For Build");
        }
        return this.ap.getLong();
    }

    public String getString() {
        if (this.aq) {
            throw new Exception("Buffer For Build");
        }
        int i = this.ap.getShort();
        if (i > 2048) {
            this.ap = null;
            throw new Exception("Buffer String Length Error");
        }
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        this.ap.get(bArr, 0, i);
        return new String(bArr);
    }

    public int initBuild() {
        ByteBuffer allocate = ByteBuffer.allocate(4096);
        this.ap = allocate;
        allocate.put((byte) 123);
        this.aq = true;
        return 0;
    }

    public int initParse(byte[] bArr) {
        int i = (bArr == null || bArr.length == 0) ? -1 : bArr[0] != 123 ? -2 : bArr[bArr.length - 1] != 125 ? -3 : 0;
        if (i != 0) {
            this.ap = null;
            throw new Exception("Parse Buffer Check Failed :" + i);
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.ap = wrap;
        wrap.position(1);
        this.aq = false;
        return 0;
    }

    public int putInt(int i) {
        if (!this.aq) {
            throw new Exception("Buffer For Parse");
        }
        a(4);
        this.ap.putInt(i);
        return 0;
    }

    public int putLong(long j) {
        if (!this.aq) {
            throw new Exception("Buffer For Parse");
        }
        a(8);
        this.ap.putLong(j);
        return 0;
    }

    public int putString(String str) {
        if (!this.aq) {
            throw new Exception("Buffer For Parse");
        }
        byte[] bytes = str != null ? str.getBytes() : null;
        if (bytes == null) {
            bytes = new byte[0];
        }
        if (bytes.length > 2048) {
            throw new Exception("Buffer String Length Error");
        }
        a(bytes.length + 2);
        this.ap.putShort((short) bytes.length);
        if (bytes.length > 0) {
            this.ap.put(bytes);
        }
        return 0;
    }
}
