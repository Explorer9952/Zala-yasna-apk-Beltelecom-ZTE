package com.google.protobuf.nano;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FieldData implements Cloneable {
    private Extension cachedExtension;
    private List unknownFieldData;
    private Object value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldData() {
        this.unknownFieldData = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldData(Extension extension, Object obj) {
        this.cachedExtension = extension;
        this.value = obj;
    }

    private byte[] toByteArray() {
        byte[] bArr = new byte[computeSerializedSize()];
        writeTo(CodedOutputByteBufferNano.newInstance(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addUnknownField(UnknownFieldData unknownFieldData) {
        this.unknownFieldData.add(unknownFieldData);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final FieldData m8clone() {
        Object clone;
        FieldData fieldData = new FieldData();
        try {
            fieldData.cachedExtension = this.cachedExtension;
            if (this.unknownFieldData == null) {
                fieldData.unknownFieldData = null;
            } else {
                fieldData.unknownFieldData.addAll(this.unknownFieldData);
            }
            if (this.value != null) {
                if (this.value instanceof MessageNano) {
                    clone = ((MessageNano) this.value).mo6clone();
                } else if (this.value instanceof byte[]) {
                    clone = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length];
                        fieldData.value = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        clone = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        clone = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        clone = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        clone = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        clone = ((double[]) this.value).clone();
                    } else if (this.value instanceof MessageNano[]) {
                        MessageNano[] messageNanoArr = (MessageNano[]) this.value;
                        MessageNano[] messageNanoArr2 = new MessageNano[messageNanoArr.length];
                        fieldData.value = messageNanoArr2;
                        while (i < messageNanoArr.length) {
                            messageNanoArr2[i] = messageNanoArr[i].mo6clone();
                            i++;
                        }
                    }
                }
                fieldData.value = clone;
            }
            return fieldData;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int computeSerializedSize() {
        Object obj = this.value;
        if (obj != null) {
            return this.cachedExtension.computeSerializedSize(obj);
        }
        Iterator it2 = this.unknownFieldData.iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += ((UnknownFieldData) it2.next()).computeSerializedSize();
        }
        return i;
    }

    public boolean equals(Object obj) {
        List list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldData)) {
            return false;
        }
        FieldData fieldData = (FieldData) obj;
        if (this.value == null || fieldData.value == null) {
            List list2 = this.unknownFieldData;
            if (list2 != null && (list = fieldData.unknownFieldData) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(toByteArray(), fieldData.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        Extension extension = this.cachedExtension;
        if (extension != fieldData.cachedExtension) {
            return false;
        }
        if (!extension.clazz.isArray()) {
            return this.value.equals(fieldData.value);
        }
        Object obj2 = this.value;
        return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) fieldData.value) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) fieldData.value) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) fieldData.value) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) fieldData.value) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) fieldData.value) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) fieldData.value) : Arrays.deepEquals((Object[]) obj2, (Object[]) fieldData.value);
    }

    UnknownFieldData getUnknownField(int i) {
        List list = this.unknownFieldData;
        if (list != null && i < list.size()) {
            return (UnknownFieldData) this.unknownFieldData.get(i);
        }
        return null;
    }

    int getUnknownFieldSize() {
        List list = this.unknownFieldData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getValue(Extension extension) {
        if (this.value == null) {
            this.cachedExtension = extension;
            this.value = extension.getValueFrom(this.unknownFieldData);
            this.unknownFieldData = null;
        } else if (!this.cachedExtension.equals(extension)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.value;
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValue(Extension extension, Object obj) {
        this.cachedExtension = extension;
        this.value = obj;
        this.unknownFieldData = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
        Object obj = this.value;
        if (obj != null) {
            this.cachedExtension.writeTo(obj, codedOutputByteBufferNano);
            return;
        }
        Iterator it2 = this.unknownFieldData.iterator();
        while (it2.hasNext()) {
            ((UnknownFieldData) it2.next()).writeTo(codedOutputByteBufferNano);
        }
    }
}
