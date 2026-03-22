package com.google.protobuf.nano;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.zte.ucs.tvcall.Commons;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* loaded from: classes.dex */
public final class CodedOutputByteBufferNano {
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    public static final int LITTLE_ENDIAN_64_SIZE = 8;
    private static final int MAX_UTF8_EXPANSION = 3;
    private final ByteBuffer buffer;

    /* loaded from: classes.dex */
    public class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        OutOfSpaceException(int r3, int r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 108(0x6c, float:1.51E-43)
                r0.<init>(r1)
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space (pos "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = " limit "
                r0.append(r3)
                r0.append(r4)
                java.lang.String r3 = ")."
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.nano.CodedOutputByteBufferNano.OutOfSpaceException.<init>(int, int):void");
        }
    }

    private CodedOutputByteBufferNano(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    private CodedOutputByteBufferNano(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int computeBoolSize(int i, boolean z) {
        return computeTagSize(i) + computeBoolSizeNoTag(z);
    }

    public static int computeBoolSizeNoTag(boolean z) {
        return 1;
    }

    public static int computeBytesSize(int i, byte[] bArr) {
        return computeTagSize(i) + computeBytesSizeNoTag(bArr);
    }

    public static int computeBytesSizeNoTag(byte[] bArr) {
        return computeRawVarint32Size(bArr.length) + bArr.length;
    }

    public static int computeDoubleSize(int i, double d2) {
        return computeTagSize(i) + computeDoubleSizeNoTag(d2);
    }

    public static int computeDoubleSizeNoTag(double d2) {
        return 8;
    }

    public static int computeEnumSize(int i, int i2) {
        return computeTagSize(i) + computeEnumSizeNoTag(i2);
    }

    public static int computeEnumSizeNoTag(int i) {
        return computeRawVarint32Size(i);
    }

    public static int computeFixed32Size(int i, int i2) {
        return computeTagSize(i) + computeFixed32SizeNoTag(i2);
    }

    public static int computeFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeFixed64Size(int i, long j) {
        return computeTagSize(i) + computeFixed64SizeNoTag(j);
    }

    public static int computeFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeFloatSize(int i, float f) {
        return computeTagSize(i) + computeFloatSizeNoTag(f);
    }

    public static int computeFloatSizeNoTag(float f) {
        return 4;
    }

    public static int computeGroupSize(int i, MessageNano messageNano) {
        return (computeTagSize(i) << 1) + computeGroupSizeNoTag(messageNano);
    }

    public static int computeGroupSizeNoTag(MessageNano messageNano) {
        return messageNano.getSerializedSize();
    }

    public static int computeInt32Size(int i, int i2) {
        return computeTagSize(i) + computeInt32SizeNoTag(i2);
    }

    public static int computeInt32SizeNoTag(int i) {
        if (i >= 0) {
            return computeRawVarint32Size(i);
        }
        return 10;
    }

    public static int computeInt64Size(int i, long j) {
        return computeTagSize(i) + computeInt64SizeNoTag(j);
    }

    public static int computeInt64SizeNoTag(long j) {
        return computeRawVarint64Size(j);
    }

    public static int computeMessageSize(int i, MessageNano messageNano) {
        return computeTagSize(i) + computeMessageSizeNoTag(messageNano);
    }

    public static int computeMessageSizeNoTag(MessageNano messageNano) {
        int serializedSize = messageNano.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computeRawVarint32Size(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int computeRawVarint64Size(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int computeSFixed32Size(int i, int i2) {
        return computeTagSize(i) + computeSFixed32SizeNoTag(i2);
    }

    public static int computeSFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeSFixed64Size(int i, long j) {
        return computeTagSize(i) + computeSFixed64SizeNoTag(j);
    }

    public static int computeSFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeSInt32Size(int i, int i2) {
        return computeTagSize(i) + computeSInt32SizeNoTag(i2);
    }

    public static int computeSInt32SizeNoTag(int i) {
        return computeRawVarint32Size(encodeZigZag32(i));
    }

    public static int computeSInt64Size(int i, long j) {
        return computeTagSize(i) + computeSInt64SizeNoTag(j);
    }

    public static int computeSInt64SizeNoTag(long j) {
        return computeRawVarint64Size(encodeZigZag64(j));
    }

    public static int computeStringSize(int i, String str) {
        return computeTagSize(i) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(String str) {
        int encodedLength = encodedLength(str);
        return computeRawVarint32Size(encodedLength) + encodedLength;
    }

    public static int computeTagSize(int i) {
        return computeRawVarint32Size(WireFormatNano.makeTag(i, 0));
    }

    public static int computeUInt32Size(int i, int i2) {
        return computeTagSize(i) + computeUInt32SizeNoTag(i2);
    }

    public static int computeUInt32SizeNoTag(int i) {
        return computeRawVarint32Size(i);
    }

    public static int computeUInt64Size(int i, long j) {
        return computeTagSize(i) + computeUInt64SizeNoTag(j);
    }

    public static int computeUInt64SizeNoTag(long j) {
        return computeRawVarint64Size(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r8 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int encode(java.lang.CharSequence r6, byte[] r7, int r8, int r9) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.nano.CodedOutputByteBufferNano.encode(java.lang.CharSequence, byte[], int, int):int");
    }

    private static void encode(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (!byteBuffer.hasArray()) {
            encodeDirect(charSequence, byteBuffer);
            return;
        }
        try {
            byteBuffer.position(encode(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e);
            throw bufferOverflowException;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    private static void encodeDirect(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            char c2 = charAt;
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i = (charAt >>> 6) | 960;
                } else {
                    if (charAt >= 55296 && 57343 >= charAt) {
                        int i3 = i2 + 1;
                        if (i3 != charSequence.length()) {
                            char charAt2 = charSequence.charAt(i3);
                            if (Character.isSurrogatePair(charAt, charAt2)) {
                                int codePoint = Character.toCodePoint(charAt, charAt2);
                                byteBuffer.put((byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                                byteBuffer.put((byte) (((codePoint >>> 12) & 63) | Commons.MSG_MCSP_INIT_SUCCESS));
                                byteBuffer.put((byte) (((codePoint >>> 6) & 63) | Commons.MSG_MCSP_INIT_SUCCESS));
                                byteBuffer.put((byte) ((codePoint & 63) | Commons.MSG_MCSP_INIT_SUCCESS));
                                i2 = i3;
                                i2++;
                            } else {
                                i2 = i3;
                            }
                        }
                        StringBuilder sb = new StringBuilder(39);
                        sb.append("Unpaired surrogate at index ");
                        sb.append(i2 - 1);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    byteBuffer.put((byte) ((charAt >>> '\f') | 480));
                    i = ((charAt >>> 6) & 63) | Commons.MSG_MCSP_INIT_SUCCESS;
                }
                byteBuffer.put((byte) i);
                c2 = (charAt & '?') | Commons.MSG_MCSP_INIT_SUCCESS;
            }
            byteBuffer.put((byte) c2);
            i2++;
        }
    }

    public static int encodeZigZag32(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long encodeZigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    private static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 += encodedLengthGeneral(charSequence, i);
                    break;
                }
                i2 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        long j = i2 + 4294967296L;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        StringBuilder sb = new StringBuilder(39);
                        sb.append("Unpaired surrogate at index ");
                        sb.append(i);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    public static CodedOutputByteBufferNano newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedOutputByteBufferNano newInstance(byte[] bArr, int i, int i2) {
        return new CodedOutputByteBufferNano(bArr, i, i2);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final int position() {
        return this.buffer.position();
    }

    public final void reset() {
        this.buffer.clear();
    }

    public final int spaceLeft() {
        return this.buffer.remaining();
    }

    public final void writeBool(int i, boolean z) {
        writeTag(i, 0);
        writeBoolNoTag(z);
    }

    public final void writeBoolNoTag(boolean z) {
        writeRawByte(z ? 1 : 0);
    }

    public final void writeBytes(int i, byte[] bArr) {
        writeTag(i, 2);
        writeBytesNoTag(bArr);
    }

    public final void writeBytesNoTag(byte[] bArr) {
        writeRawVarint32(bArr.length);
        writeRawBytes(bArr);
    }

    public final void writeDouble(int i, double d2) {
        writeTag(i, 1);
        writeDoubleNoTag(d2);
    }

    public final void writeDoubleNoTag(double d2) {
        writeRawLittleEndian64(Double.doubleToLongBits(d2));
    }

    public final void writeEnum(int i, int i2) {
        writeTag(i, 0);
        writeEnumNoTag(i2);
    }

    public final void writeEnumNoTag(int i) {
        writeRawVarint32(i);
    }

    public final void writeFixed32(int i, int i2) {
        writeTag(i, 5);
        writeFixed32NoTag(i2);
    }

    public final void writeFixed32NoTag(int i) {
        writeRawLittleEndian32(i);
    }

    public final void writeFixed64(int i, long j) {
        writeTag(i, 1);
        writeFixed64NoTag(j);
    }

    public final void writeFixed64NoTag(long j) {
        writeRawLittleEndian64(j);
    }

    public final void writeFloat(int i, float f) {
        writeTag(i, 5);
        writeFloatNoTag(f);
    }

    public final void writeFloatNoTag(float f) {
        writeRawLittleEndian32(Float.floatToIntBits(f));
    }

    public final void writeGroup(int i, MessageNano messageNano) {
        writeTag(i, 3);
        writeGroupNoTag(messageNano);
        writeTag(i, 4);
    }

    public final void writeGroupNoTag(MessageNano messageNano) {
        messageNano.writeTo(this);
    }

    public final void writeInt32(int i, int i2) {
        writeTag(i, 0);
        writeInt32NoTag(i2);
    }

    public final void writeInt32NoTag(int i) {
        if (i >= 0) {
            writeRawVarint32(i);
        } else {
            writeRawVarint64(i);
        }
    }

    public final void writeInt64(int i, long j) {
        writeTag(i, 0);
        writeInt64NoTag(j);
    }

    public final void writeInt64NoTag(long j) {
        writeRawVarint64(j);
    }

    public final void writeMessage(int i, MessageNano messageNano) {
        writeTag(i, 2);
        writeMessageNoTag(messageNano);
    }

    public final void writeMessageNoTag(MessageNano messageNano) {
        writeRawVarint32(messageNano.getCachedSize());
        messageNano.writeTo(this);
    }

    public final void writeRawByte(byte b2) {
        if (!this.buffer.hasRemaining()) {
            throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
        }
        this.buffer.put(b2);
    }

    public final void writeRawByte(int i) {
        writeRawByte((byte) i);
    }

    public final void writeRawBytes(byte[] bArr) {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public final void writeRawBytes(byte[] bArr, int i, int i2) {
        if (this.buffer.remaining() < i2) {
            throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
        }
        this.buffer.put(bArr, i, i2);
    }

    public final void writeRawLittleEndian32(int i) {
        if (this.buffer.remaining() < 4) {
            throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
        }
        this.buffer.putInt(i);
    }

    public final void writeRawLittleEndian64(long j) {
        if (this.buffer.remaining() < 8) {
            throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
        }
        this.buffer.putLong(j);
    }

    public final void writeRawVarint32(int i) {
        while ((i & (-128)) != 0) {
            writeRawByte((i & 127) | Commons.MSG_MCSP_INIT_SUCCESS);
            i >>>= 7;
        }
        writeRawByte(i);
    }

    public final void writeRawVarint64(long j) {
        while (((-128) & j) != 0) {
            writeRawByte((((int) j) & 127) | Commons.MSG_MCSP_INIT_SUCCESS);
            j >>>= 7;
        }
        writeRawByte((int) j);
    }

    public final void writeSFixed32(int i, int i2) {
        writeTag(i, 5);
        writeSFixed32NoTag(i2);
    }

    public final void writeSFixed32NoTag(int i) {
        writeRawLittleEndian32(i);
    }

    public final void writeSFixed64(int i, long j) {
        writeTag(i, 1);
        writeSFixed64NoTag(j);
    }

    public final void writeSFixed64NoTag(long j) {
        writeRawLittleEndian64(j);
    }

    public final void writeSInt32(int i, int i2) {
        writeTag(i, 0);
        writeSInt32NoTag(i2);
    }

    public final void writeSInt32NoTag(int i) {
        writeRawVarint32(encodeZigZag32(i));
    }

    public final void writeSInt64(int i, long j) {
        writeTag(i, 0);
        writeSInt64NoTag(j);
    }

    public final void writeSInt64NoTag(long j) {
        writeRawVarint64(encodeZigZag64(j));
    }

    public final void writeString(int i, String str) {
        writeTag(i, 2);
        writeStringNoTag(str);
    }

    public final void writeStringNoTag(String str) {
        try {
            int computeRawVarint32Size = computeRawVarint32Size(str.length());
            if (computeRawVarint32Size != computeRawVarint32Size(str.length() * 3)) {
                writeRawVarint32(encodedLength(str));
                encode(str, this.buffer);
                return;
            }
            int position = this.buffer.position();
            if (this.buffer.remaining() < computeRawVarint32Size) {
                throw new OutOfSpaceException(position + computeRawVarint32Size, this.buffer.limit());
            }
            this.buffer.position(position + computeRawVarint32Size);
            encode(str, this.buffer);
            int position2 = this.buffer.position();
            this.buffer.position(position);
            writeRawVarint32((position2 - position) - computeRawVarint32Size);
            this.buffer.position(position2);
        } catch (BufferOverflowException e) {
            OutOfSpaceException outOfSpaceException = new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
            outOfSpaceException.initCause(e);
            throw outOfSpaceException;
        }
    }

    public final void writeTag(int i, int i2) {
        writeRawVarint32(WireFormatNano.makeTag(i, i2));
    }

    public final void writeUInt32(int i, int i2) {
        writeTag(i, 0);
        writeUInt32NoTag(i2);
    }

    public final void writeUInt32NoTag(int i) {
        writeRawVarint32(i);
    }

    public final void writeUInt64(int i, long j) {
        writeTag(i, 0);
        writeUInt64NoTag(j);
    }

    public final void writeUInt64NoTag(long j) {
        writeRawVarint64(j);
    }
}
