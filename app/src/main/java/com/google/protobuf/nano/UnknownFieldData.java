package com.google.protobuf.nano;

import java.util.Arrays;

/* loaded from: classes.dex */
final class UnknownFieldData {
    final byte[] bytes;
    final int tag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnknownFieldData(int i, byte[] bArr) {
        this.tag = i;
        this.bytes = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int computeSerializedSize() {
        return CodedOutputByteBufferNano.computeRawVarint32Size(this.tag) + 0 + this.bytes.length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnknownFieldData)) {
            return false;
        }
        UnknownFieldData unknownFieldData = (UnknownFieldData) obj;
        return this.tag == unknownFieldData.tag && Arrays.equals(this.bytes, unknownFieldData.bytes);
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.bytes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
        codedOutputByteBufferNano.writeRawVarint32(this.tag);
        codedOutputByteBufferNano.writeRawBytes(this.bytes);
    }
}
