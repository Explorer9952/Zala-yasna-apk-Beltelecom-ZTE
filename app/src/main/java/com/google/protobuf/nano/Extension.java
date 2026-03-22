package com.google.protobuf.nano;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Extension {
    public static final int TYPE_BOOL = 8;
    public static final int TYPE_BYTES = 12;
    public static final int TYPE_DOUBLE = 1;
    public static final int TYPE_ENUM = 14;
    public static final int TYPE_FIXED32 = 7;
    public static final int TYPE_FIXED64 = 6;
    public static final int TYPE_FLOAT = 2;
    public static final int TYPE_GROUP = 10;
    public static final int TYPE_INT32 = 5;
    public static final int TYPE_INT64 = 3;
    public static final int TYPE_MESSAGE = 11;
    public static final int TYPE_SFIXED32 = 15;
    public static final int TYPE_SFIXED64 = 16;
    public static final int TYPE_SINT32 = 17;
    public static final int TYPE_SINT64 = 18;
    public static final int TYPE_STRING = 9;
    public static final int TYPE_UINT32 = 13;
    public static final int TYPE_UINT64 = 4;
    protected final Class clazz;
    protected final boolean repeated;
    public final int tag;
    protected final int type;

    /* loaded from: classes.dex */
    class PrimitiveExtension extends Extension {
        private final int nonPackedTag;
        private final int packedTag;

        public PrimitiveExtension(int i, Class cls, int i2, boolean z, int i3, int i4) {
            super(i, cls, i2, z);
            this.nonPackedTag = i3;
            this.packedTag = i4;
        }

        private int computePackedDataSize(Object obj) {
            int i;
            int length = Array.getLength(obj);
            int i2 = 0;
            switch (this.type) {
                case 1:
                case 6:
                case 16:
                    return length << 3;
                case 2:
                case 7:
                case 15:
                    return length << 2;
                case 3:
                    i = 0;
                    while (i2 < length) {
                        i += CodedOutputByteBufferNano.computeInt64SizeNoTag(Array.getLong(obj, i2));
                        i2++;
                    }
                    break;
                case 4:
                    i = 0;
                    while (i2 < length) {
                        i += CodedOutputByteBufferNano.computeUInt64SizeNoTag(Array.getLong(obj, i2));
                        i2++;
                    }
                    break;
                case 5:
                    i = 0;
                    while (i2 < length) {
                        i += CodedOutputByteBufferNano.computeInt32SizeNoTag(Array.getInt(obj, i2));
                        i2++;
                    }
                    break;
                case 8:
                    return length;
                case 9:
                case 10:
                case 11:
                case 12:
                default:
                    int i3 = this.type;
                    StringBuilder sb = new StringBuilder(40);
                    sb.append("Unexpected non-packable type ");
                    sb.append(i3);
                    throw new IllegalArgumentException(sb.toString());
                case 13:
                    i = 0;
                    while (i2 < length) {
                        i += CodedOutputByteBufferNano.computeUInt32SizeNoTag(Array.getInt(obj, i2));
                        i2++;
                    }
                    break;
                case 14:
                    i = 0;
                    while (i2 < length) {
                        i += CodedOutputByteBufferNano.computeEnumSizeNoTag(Array.getInt(obj, i2));
                        i2++;
                    }
                    break;
                case 17:
                    i = 0;
                    while (i2 < length) {
                        i += CodedOutputByteBufferNano.computeSInt32SizeNoTag(Array.getInt(obj, i2));
                        i2++;
                    }
                    break;
                case 18:
                    i = 0;
                    while (i2 < length) {
                        i += CodedOutputByteBufferNano.computeSInt64SizeNoTag(Array.getLong(obj, i2));
                        i2++;
                    }
                    break;
            }
            return i;
        }

        @Override // com.google.protobuf.nano.Extension
        protected int computeRepeatedSerializedSize(Object obj) {
            int i = this.tag;
            if (i == this.nonPackedTag) {
                return super.computeRepeatedSerializedSize(obj);
            }
            if (i == this.packedTag) {
                int computePackedDataSize = computePackedDataSize(obj);
                return computePackedDataSize + CodedOutputByteBufferNano.computeRawVarint32Size(computePackedDataSize) + CodedOutputByteBufferNano.computeRawVarint32Size(this.tag);
            }
            int i2 = this.tag;
            int i3 = this.nonPackedTag;
            int i4 = this.packedTag;
            StringBuilder sb = new StringBuilder(124);
            sb.append("Unexpected repeated extension tag ");
            sb.append(i2);
            sb.append(", unequal to both non-packed variant ");
            sb.append(i3);
            sb.append(" and packed variant ");
            sb.append(i4);
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.protobuf.nano.Extension
        protected final int computeSingularSerializedSize(Object obj) {
            int tagFieldNumber = WireFormatNano.getTagFieldNumber(this.tag);
            switch (this.type) {
                case 1:
                    return CodedOutputByteBufferNano.computeDoubleSize(tagFieldNumber, ((Double) obj).doubleValue());
                case 2:
                    return CodedOutputByteBufferNano.computeFloatSize(tagFieldNumber, ((Float) obj).floatValue());
                case 3:
                    return CodedOutputByteBufferNano.computeInt64Size(tagFieldNumber, ((Long) obj).longValue());
                case 4:
                    return CodedOutputByteBufferNano.computeUInt64Size(tagFieldNumber, ((Long) obj).longValue());
                case 5:
                    return CodedOutputByteBufferNano.computeInt32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 6:
                    return CodedOutputByteBufferNano.computeFixed64Size(tagFieldNumber, ((Long) obj).longValue());
                case 7:
                    return CodedOutputByteBufferNano.computeFixed32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 8:
                    return CodedOutputByteBufferNano.computeBoolSize(tagFieldNumber, ((Boolean) obj).booleanValue());
                case 9:
                    return CodedOutputByteBufferNano.computeStringSize(tagFieldNumber, (String) obj);
                case 10:
                case 11:
                default:
                    int i = this.type;
                    StringBuilder sb = new StringBuilder(24);
                    sb.append("Unknown type ");
                    sb.append(i);
                    throw new IllegalArgumentException(sb.toString());
                case 12:
                    return CodedOutputByteBufferNano.computeBytesSize(tagFieldNumber, (byte[]) obj);
                case 13:
                    return CodedOutputByteBufferNano.computeUInt32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 14:
                    return CodedOutputByteBufferNano.computeEnumSize(tagFieldNumber, ((Integer) obj).intValue());
                case 15:
                    return CodedOutputByteBufferNano.computeSFixed32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 16:
                    return CodedOutputByteBufferNano.computeSFixed64Size(tagFieldNumber, ((Long) obj).longValue());
                case 17:
                    return CodedOutputByteBufferNano.computeSInt32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 18:
                    return CodedOutputByteBufferNano.computeSInt64Size(tagFieldNumber, ((Long) obj).longValue());
            }
        }

        @Override // com.google.protobuf.nano.Extension
        protected Object readData(CodedInputByteBufferNano codedInputByteBufferNano) {
            try {
                switch (this.type) {
                    case 1:
                        return Double.valueOf(codedInputByteBufferNano.readDouble());
                    case 2:
                        return Float.valueOf(codedInputByteBufferNano.readFloat());
                    case 3:
                        return Long.valueOf(codedInputByteBufferNano.readInt64());
                    case 4:
                        return Long.valueOf(codedInputByteBufferNano.readUInt64());
                    case 5:
                        return Integer.valueOf(codedInputByteBufferNano.readInt32());
                    case 6:
                        return Long.valueOf(codedInputByteBufferNano.readFixed64());
                    case 7:
                        return Integer.valueOf(codedInputByteBufferNano.readFixed32());
                    case 8:
                        return Boolean.valueOf(codedInputByteBufferNano.readBool());
                    case 9:
                        return codedInputByteBufferNano.readString();
                    case 10:
                    case 11:
                    default:
                        int i = this.type;
                        StringBuilder sb = new StringBuilder(24);
                        sb.append("Unknown type ");
                        sb.append(i);
                        throw new IllegalArgumentException(sb.toString());
                    case 12:
                        return codedInputByteBufferNano.readBytes();
                    case 13:
                        return Integer.valueOf(codedInputByteBufferNano.readUInt32());
                    case 14:
                        return Integer.valueOf(codedInputByteBufferNano.readEnum());
                    case 15:
                        return Integer.valueOf(codedInputByteBufferNano.readSFixed32());
                    case 16:
                        return Long.valueOf(codedInputByteBufferNano.readSFixed64());
                    case 17:
                        return Integer.valueOf(codedInputByteBufferNano.readSInt32());
                    case 18:
                        return Long.valueOf(codedInputByteBufferNano.readSInt64());
                }
            } catch (IOException e) {
                throw new IllegalArgumentException("Error reading extension field", e);
            }
        }

        @Override // com.google.protobuf.nano.Extension
        protected void readDataInto(UnknownFieldData unknownFieldData, List list) {
            int i = unknownFieldData.tag;
            int i2 = this.nonPackedTag;
            byte[] bArr = unknownFieldData.bytes;
            if (i == i2) {
                list.add(readData(CodedInputByteBufferNano.newInstance(bArr)));
                return;
            }
            CodedInputByteBufferNano newInstance = CodedInputByteBufferNano.newInstance(bArr);
            try {
                newInstance.pushLimit(newInstance.readRawVarint32());
                while (!newInstance.isAtEnd()) {
                    list.add(readData(newInstance));
                }
            } catch (IOException e) {
                throw new IllegalArgumentException("Error reading extension field", e);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0021. Please report as an issue. */
        @Override // com.google.protobuf.nano.Extension
        protected void writeRepeatedData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
            int i = this.tag;
            if (i == this.nonPackedTag) {
                super.writeRepeatedData(obj, codedOutputByteBufferNano);
                return;
            }
            if (i != this.packedTag) {
                int i2 = this.tag;
                int i3 = this.nonPackedTag;
                int i4 = this.packedTag;
                StringBuilder sb = new StringBuilder(124);
                sb.append("Unexpected repeated extension tag ");
                sb.append(i2);
                sb.append(", unequal to both non-packed variant ");
                sb.append(i3);
                sb.append(" and packed variant ");
                sb.append(i4);
                throw new IllegalArgumentException(sb.toString());
            }
            int length = Array.getLength(obj);
            int computePackedDataSize = computePackedDataSize(obj);
            try {
                codedOutputByteBufferNano.writeRawVarint32(this.tag);
                codedOutputByteBufferNano.writeRawVarint32(computePackedDataSize);
                int i5 = 0;
                switch (this.type) {
                    case 1:
                        while (i5 < length) {
                            codedOutputByteBufferNano.writeDoubleNoTag(Array.getDouble(obj, i5));
                            i5++;
                        }
                        return;
                    case 2:
                        while (i5 < length) {
                            codedOutputByteBufferNano.writeFloatNoTag(Array.getFloat(obj, i5));
                            i5++;
                        }
                        return;
                    case 3:
                        while (i5 < length) {
                            codedOutputByteBufferNano.writeInt64NoTag(Array.getLong(obj, i5));
                            i5++;
                        }
                        return;
                    case 4:
                        while (i5 < length) {
                            codedOutputByteBufferNano.writeUInt64NoTag(Array.getLong(obj, i5));
                            i5++;
                        }
                        return;
                    case 5:
                        while (i5 < length) {
                            codedOutputByteBufferNano.writeInt32NoTag(Array.getInt(obj, i5));
                            i5++;
                        }
                        return;
                    case 6:
                        while (i5 < length) {
                            codedOutputByteBufferNano.writeFixed64NoTag(Array.getLong(obj, i5));
                            i5++;
                        }
                        return;
                    case 7:
                        while (i5 < length) {
                            codedOutputByteBufferNano.writeFixed32NoTag(Array.getInt(obj, i5));
                            i5++;
                        }
                        return;
                    case 8:
                        while (i5 < length) {
                            codedOutputByteBufferNano.writeBoolNoTag(Array.getBoolean(obj, i5));
                            i5++;
                        }
                        return;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    default:
                        int i6 = this.type;
                        StringBuilder sb2 = new StringBuilder(27);
                        sb2.append("Unpackable type ");
                        sb2.append(i6);
                        throw new IllegalArgumentException(sb2.toString());
                    case 13:
                        while (i5 < length) {
                            codedOutputByteBufferNano.writeUInt32NoTag(Array.getInt(obj, i5));
                            i5++;
                        }
                        return;
                    case 14:
                        while (i5 < length) {
                            codedOutputByteBufferNano.writeEnumNoTag(Array.getInt(obj, i5));
                            i5++;
                        }
                        return;
                    case 15:
                        while (i5 < length) {
                            codedOutputByteBufferNano.writeSFixed32NoTag(Array.getInt(obj, i5));
                            i5++;
                        }
                        return;
                    case 16:
                        while (i5 < length) {
                            codedOutputByteBufferNano.writeSFixed64NoTag(Array.getLong(obj, i5));
                            i5++;
                        }
                        return;
                    case 17:
                        while (i5 < length) {
                            codedOutputByteBufferNano.writeSInt32NoTag(Array.getInt(obj, i5));
                            i5++;
                        }
                        return;
                    case 18:
                        while (i5 < length) {
                            codedOutputByteBufferNano.writeSInt64NoTag(Array.getLong(obj, i5));
                            i5++;
                        }
                        return;
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.protobuf.nano.Extension
        protected final void writeSingularData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
            try {
                codedOutputByteBufferNano.writeRawVarint32(this.tag);
                switch (this.type) {
                    case 1:
                        codedOutputByteBufferNano.writeDoubleNoTag(((Double) obj).doubleValue());
                        return;
                    case 2:
                        codedOutputByteBufferNano.writeFloatNoTag(((Float) obj).floatValue());
                        return;
                    case 3:
                        codedOutputByteBufferNano.writeInt64NoTag(((Long) obj).longValue());
                        return;
                    case 4:
                        codedOutputByteBufferNano.writeUInt64NoTag(((Long) obj).longValue());
                        return;
                    case 5:
                        codedOutputByteBufferNano.writeInt32NoTag(((Integer) obj).intValue());
                        return;
                    case 6:
                        codedOutputByteBufferNano.writeFixed64NoTag(((Long) obj).longValue());
                        return;
                    case 7:
                        codedOutputByteBufferNano.writeFixed32NoTag(((Integer) obj).intValue());
                        return;
                    case 8:
                        codedOutputByteBufferNano.writeBoolNoTag(((Boolean) obj).booleanValue());
                        return;
                    case 9:
                        codedOutputByteBufferNano.writeStringNoTag((String) obj);
                        return;
                    case 10:
                    case 11:
                    default:
                        int i = this.type;
                        StringBuilder sb = new StringBuilder(24);
                        sb.append("Unknown type ");
                        sb.append(i);
                        throw new IllegalArgumentException(sb.toString());
                    case 12:
                        codedOutputByteBufferNano.writeBytesNoTag((byte[]) obj);
                        return;
                    case 13:
                        codedOutputByteBufferNano.writeUInt32NoTag(((Integer) obj).intValue());
                        return;
                    case 14:
                        codedOutputByteBufferNano.writeEnumNoTag(((Integer) obj).intValue());
                        return;
                    case 15:
                        codedOutputByteBufferNano.writeSFixed32NoTag(((Integer) obj).intValue());
                        return;
                    case 16:
                        codedOutputByteBufferNano.writeSFixed64NoTag(((Long) obj).longValue());
                        return;
                    case 17:
                        codedOutputByteBufferNano.writeSInt32NoTag(((Integer) obj).intValue());
                        return;
                    case 18:
                        codedOutputByteBufferNano.writeSInt64NoTag(((Long) obj).longValue());
                        return;
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private Extension(int i, Class cls, int i2, boolean z) {
        this.type = i;
        this.clazz = cls;
        this.tag = i2;
        this.repeated = z;
    }

    @Deprecated
    public static Extension createMessageTyped(int i, Class cls, int i2) {
        return new Extension(i, cls, i2, false);
    }

    public static Extension createMessageTyped(int i, Class cls, long j) {
        return new Extension(i, cls, (int) j, false);
    }

    public static Extension createPrimitiveTyped(int i, Class cls, long j) {
        return new PrimitiveExtension(i, cls, (int) j, false, 0, 0);
    }

    public static Extension createRepeatedMessageTyped(int i, Class cls, long j) {
        return new Extension(i, cls, (int) j, true);
    }

    public static Extension createRepeatedPrimitiveTyped(int i, Class cls, long j, long j2, long j3) {
        return new PrimitiveExtension(i, cls, (int) j, true, (int) j2, (int) j3);
    }

    private Object getRepeatedValueFrom(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            UnknownFieldData unknownFieldData = (UnknownFieldData) list.get(i);
            if (unknownFieldData.bytes.length != 0) {
                readDataInto(unknownFieldData, arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        Class cls = this.clazz;
        Object cast = cls.cast(Array.newInstance(cls.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(cast, i2, arrayList.get(i2));
        }
        return cast;
    }

    private Object getSingularValueFrom(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.clazz.cast(readData(CodedInputByteBufferNano.newInstance(((UnknownFieldData) list.get(list.size() - 1)).bytes)));
    }

    protected int computeRepeatedSerializedSize(Object obj) {
        int length = Array.getLength(obj);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += computeSingularSerializedSize(Array.get(obj, i2));
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int computeSerializedSize(Object obj) {
        return this.repeated ? computeRepeatedSerializedSize(obj) : computeSingularSerializedSize(obj);
    }

    protected int computeSingularSerializedSize(Object obj) {
        int tagFieldNumber = WireFormatNano.getTagFieldNumber(this.tag);
        int i = this.type;
        if (i == 10) {
            return CodedOutputByteBufferNano.computeGroupSize(tagFieldNumber, (MessageNano) obj);
        }
        if (i == 11) {
            return CodedOutputByteBufferNano.computeMessageSize(tagFieldNumber, (MessageNano) obj);
        }
        int i2 = this.type;
        StringBuilder sb = new StringBuilder(24);
        sb.append("Unknown type ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Extension)) {
            return false;
        }
        Extension extension = (Extension) obj;
        return this.type == extension.type && this.clazz == extension.clazz && this.tag == extension.tag && this.repeated == extension.repeated;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object getValueFrom(List list) {
        if (list == null) {
            return null;
        }
        return this.repeated ? getRepeatedValueFrom(list) : getSingularValueFrom(list);
    }

    public int hashCode() {
        return ((((((this.type + 1147) * 31) + this.clazz.hashCode()) * 31) + this.tag) * 31) + (this.repeated ? 1 : 0);
    }

    protected Object readData(CodedInputByteBufferNano codedInputByteBufferNano) {
        Class<?> componentType = this.repeated ? this.clazz.getComponentType() : this.clazz;
        try {
            int i = this.type;
            if (i == 10) {
                MessageNano messageNano = (MessageNano) componentType.newInstance();
                codedInputByteBufferNano.readGroup(messageNano, WireFormatNano.getTagFieldNumber(this.tag));
                return messageNano;
            }
            if (i == 11) {
                MessageNano messageNano2 = (MessageNano) componentType.newInstance();
                codedInputByteBufferNano.readMessage(messageNano2);
                return messageNano2;
            }
            int i2 = this.type;
            StringBuilder sb = new StringBuilder(24);
            sb.append("Unknown type ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading extension field", e);
        } catch (IllegalAccessException e2) {
            String valueOf = String.valueOf(componentType);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 33);
            sb2.append("Error creating instance of class ");
            sb2.append(valueOf);
            throw new IllegalArgumentException(sb2.toString(), e2);
        } catch (InstantiationException e3) {
            String valueOf2 = String.valueOf(componentType);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
            sb3.append("Error creating instance of class ");
            sb3.append(valueOf2);
            throw new IllegalArgumentException(sb3.toString(), e3);
        }
    }

    protected void readDataInto(UnknownFieldData unknownFieldData, List list) {
        list.add(readData(CodedInputByteBufferNano.newInstance(unknownFieldData.bytes)));
    }

    protected void writeRepeatedData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                writeSingularData(obj2, codedOutputByteBufferNano);
            }
        }
    }

    protected void writeSingularData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
        try {
            codedOutputByteBufferNano.writeRawVarint32(this.tag);
            int i = this.type;
            if (i == 10) {
                int tagFieldNumber = WireFormatNano.getTagFieldNumber(this.tag);
                codedOutputByteBufferNano.writeGroupNoTag((MessageNano) obj);
                codedOutputByteBufferNano.writeTag(tagFieldNumber, 4);
            } else {
                if (i == 11) {
                    codedOutputByteBufferNano.writeMessageNoTag((MessageNano) obj);
                    return;
                }
                int i2 = this.type;
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeTo(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
        if (this.repeated) {
            writeRepeatedData(obj, codedOutputByteBufferNano);
        } else {
            writeSingularData(obj, codedOutputByteBufferNano);
        }
    }
}
