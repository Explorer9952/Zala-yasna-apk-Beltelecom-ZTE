package com.google.protobuf.nano;

/* loaded from: classes.dex */
public final class CodedInputByteBufferNano {
    private static final int DEFAULT_RECURSION_LIMIT = 64;
    private static final int DEFAULT_SIZE_LIMIT = 67108864;
    private final byte[] buffer;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int bufferStart;
    private int lastTag;
    private int recursionDepth;
    private int currentLimit = Integer.MAX_VALUE;
    private int recursionLimit = 64;
    private int sizeLimit = DEFAULT_SIZE_LIMIT;

    private CodedInputByteBufferNano(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.bufferStart = i;
        this.bufferSize = i2 + i;
        this.bufferPos = i;
    }

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static CodedInputByteBufferNano newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputByteBufferNano newInstance(byte[] bArr, int i, int i2) {
        return new CodedInputByteBufferNano(bArr, i, i2);
    }

    private final void recomputeBufferSizeAfterLimit() {
        int i = this.bufferSize + this.bufferSizeAfterLimit;
        this.bufferSize = i;
        int i2 = this.currentLimit;
        if (i <= i2) {
            this.bufferSizeAfterLimit = 0;
            return;
        }
        int i3 = i - i2;
        this.bufferSizeAfterLimit = i3;
        this.bufferSize = i - i3;
    }

    public final void checkLastTagWas(int i) {
        if (this.lastTag != i) {
            throw InvalidProtocolBufferNanoException.invalidEndTag();
        }
    }

    public final int getBytesUntilLimit() {
        int i = this.currentLimit;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.bufferPos;
    }

    public final byte[] getData(int i, int i2) {
        if (i2 == 0) {
            return WireFormatNano.EMPTY_BYTES;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.bufferStart + i, bArr, 0, i2);
        return bArr;
    }

    public final int getPosition() {
        return this.bufferPos - this.bufferStart;
    }

    public final boolean isAtEnd() {
        return this.bufferPos == this.bufferSize;
    }

    public final void popLimit(int i) {
        this.currentLimit = i;
        recomputeBufferSizeAfterLimit();
    }

    public final int pushLimit(int i) {
        if (i < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        }
        int i2 = i + this.bufferPos;
        int i3 = this.currentLimit;
        if (i2 > i3) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        this.currentLimit = i2;
        recomputeBufferSizeAfterLimit();
        return i3;
    }

    public final boolean readBool() {
        return readRawVarint32() != 0;
    }

    public final byte[] readBytes() {
        int readRawVarint32 = readRawVarint32();
        if (readRawVarint32 < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        }
        if (readRawVarint32 == 0) {
            return WireFormatNano.EMPTY_BYTES;
        }
        int i = this.bufferSize;
        int i2 = this.bufferPos;
        if (readRawVarint32 > i - i2) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        byte[] bArr = new byte[readRawVarint32];
        System.arraycopy(this.buffer, i2, bArr, 0, readRawVarint32);
        this.bufferPos += readRawVarint32;
        return bArr;
    }

    public final double readDouble() {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public final int readEnum() {
        return readRawVarint32();
    }

    public final int readFixed32() {
        return readRawLittleEndian32();
    }

    public final long readFixed64() {
        return readRawLittleEndian64();
    }

    public final float readFloat() {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public final void readGroup(MessageNano messageNano, int i) {
        int i2 = this.recursionDepth;
        if (i2 >= this.recursionLimit) {
            throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
        }
        this.recursionDepth = i2 + 1;
        messageNano.mergeFrom(this);
        checkLastTagWas(WireFormatNano.makeTag(i, 4));
        this.recursionDepth--;
    }

    public final int readInt32() {
        return readRawVarint32();
    }

    public final long readInt64() {
        return readRawVarint64();
    }

    public final void readMessage(MessageNano messageNano) {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
        }
        int pushLimit = pushLimit(readRawVarint32);
        this.recursionDepth++;
        messageNano.mergeFrom(this);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(pushLimit);
    }

    public final byte readRawByte() {
        int i = this.bufferPos;
        if (i == this.bufferSize) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i + 1;
        return bArr[i];
    }

    public final byte[] readRawBytes(int i) {
        if (i < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        }
        int i2 = this.bufferPos;
        int i3 = i2 + i;
        int i4 = this.currentLimit;
        if (i3 > i4) {
            skipRawBytes(i4 - i2);
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        if (i > this.bufferSize - i2) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, i);
        this.bufferPos += i;
        return bArr;
    }

    public final int readRawLittleEndian32() {
        return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
    }

    public final long readRawLittleEndian64() {
        return ((readRawByte() & 255) << 8) | (readRawByte() & 255) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48) | ((readRawByte() & 255) << 56);
    }

    public final int readRawVarint32() {
        int i;
        byte readRawByte = readRawByte();
        if (readRawByte >= 0) {
            return readRawByte;
        }
        int i2 = readRawByte & Byte.MAX_VALUE;
        byte readRawByte2 = readRawByte();
        if (readRawByte2 >= 0) {
            i = readRawByte2 << 7;
        } else {
            i2 |= (readRawByte2 & Byte.MAX_VALUE) << 7;
            byte readRawByte3 = readRawByte();
            if (readRawByte3 >= 0) {
                i = readRawByte3 << 14;
            } else {
                i2 |= (readRawByte3 & Byte.MAX_VALUE) << 14;
                byte readRawByte4 = readRawByte();
                if (readRawByte4 < 0) {
                    int i3 = i2 | ((readRawByte4 & Byte.MAX_VALUE) << 21);
                    byte readRawByte5 = readRawByte();
                    int i4 = i3 | (readRawByte5 << 28);
                    if (readRawByte5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (readRawByte() >= 0) {
                            return i4;
                        }
                    }
                    throw InvalidProtocolBufferNanoException.malformedVarint();
                }
                i = readRawByte4 << 21;
            }
        }
        return i2 | i;
    }

    public final long readRawVarint64() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((readRawByte() & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferNanoException.malformedVarint();
    }

    public final int readSFixed32() {
        return readRawLittleEndian32();
    }

    public final long readSFixed64() {
        return readRawLittleEndian64();
    }

    public final int readSInt32() {
        return decodeZigZag32(readRawVarint32());
    }

    public final long readSInt64() {
        return decodeZigZag64(readRawVarint64());
    }

    public final String readString() {
        int readRawVarint32 = readRawVarint32();
        if (readRawVarint32 < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        }
        if (readRawVarint32 > this.bufferSize - this.bufferPos) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        String str = new String(this.buffer, this.bufferPos, readRawVarint32, InternalNano.UTF_8);
        this.bufferPos += readRawVarint32;
        return str;
    }

    public final int readTag() {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        int readRawVarint32 = readRawVarint32();
        this.lastTag = readRawVarint32;
        if (readRawVarint32 != 0) {
            return readRawVarint32;
        }
        throw InvalidProtocolBufferNanoException.invalidTag();
    }

    public final int readUInt32() {
        return readRawVarint32();
    }

    public final long readUInt64() {
        return readRawVarint64();
    }

    public final void resetSizeCounter() {
    }

    public final void rewindToPosition(int i) {
        int i2 = this.bufferPos;
        int i3 = this.bufferStart;
        if (i <= i2 - i3) {
            if (i >= 0) {
                this.bufferPos = i3 + i;
                return;
            }
            StringBuilder sb = new StringBuilder(24);
            sb.append("Bad position ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        int i4 = this.bufferPos - this.bufferStart;
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append("Position ");
        sb2.append(i);
        sb2.append(" is beyond current ");
        sb2.append(i4);
        throw new IllegalArgumentException(sb2.toString());
    }

    public final int setRecursionLimit(int i) {
        if (i >= 0) {
            int i2 = this.recursionLimit;
            this.recursionLimit = i;
            return i2;
        }
        StringBuilder sb = new StringBuilder(47);
        sb.append("Recursion limit cannot be negative: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public final int setSizeLimit(int i) {
        if (i >= 0) {
            int i2 = this.sizeLimit;
            this.sizeLimit = i;
            return i2;
        }
        StringBuilder sb = new StringBuilder(42);
        sb.append("Size limit cannot be negative: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public final boolean skipField(int i) {
        int tagWireType = WireFormatNano.getTagWireType(i);
        if (tagWireType == 0) {
            readInt32();
            return true;
        }
        if (tagWireType == 1) {
            readRawLittleEndian64();
            return true;
        }
        if (tagWireType == 2) {
            skipRawBytes(readRawVarint32());
            return true;
        }
        if (tagWireType == 3) {
            skipMessage();
            checkLastTagWas(WireFormatNano.makeTag(WireFormatNano.getTagFieldNumber(i), 4));
            return true;
        }
        if (tagWireType == 4) {
            return false;
        }
        if (tagWireType != 5) {
            throw InvalidProtocolBufferNanoException.invalidWireType();
        }
        readRawLittleEndian32();
        return true;
    }

    public final void skipMessage() {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (skipField(readTag));
    }

    public final void skipRawBytes(int i) {
        if (i < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        }
        int i2 = this.bufferPos;
        int i3 = i2 + i;
        int i4 = this.currentLimit;
        if (i3 > i4) {
            skipRawBytes(i4 - i2);
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        if (i > this.bufferSize - i2) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        this.bufferPos = i2 + i;
    }
}
