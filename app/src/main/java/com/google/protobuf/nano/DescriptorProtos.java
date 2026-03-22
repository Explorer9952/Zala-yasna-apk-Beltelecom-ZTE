package com.google.protobuf.nano;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.video.androidsdk.player.render.IRender;
import com.zte.ucs.tvcall.Commons;
import ijk.media.player.IMediaPlayer;

/* loaded from: classes.dex */
public interface DescriptorProtos {

    /* loaded from: classes.dex */
    public final class DescriptorProto extends ExtendableMessageNano {
        private static volatile DescriptorProto[] _emptyArray;
        public MessageOptions options;
        public String name = null;
        public FieldDescriptorProto[] field = FieldDescriptorProto.emptyArray();
        public FieldDescriptorProto[] extension = FieldDescriptorProto.emptyArray();
        public DescriptorProto[] nestedType = emptyArray();
        public EnumDescriptorProto[] enumType = EnumDescriptorProto.emptyArray();
        public ExtensionRange[] extensionRange = ExtensionRange.emptyArray();
        public OneofDescriptorProto[] oneofDecl = OneofDescriptorProto.emptyArray();
        public ReservedRange[] reservedRange = ReservedRange.emptyArray();
        public String[] reservedName = WireFormatNano.EMPTY_STRING_ARRAY;

        /* loaded from: classes.dex */
        public final class ExtensionRange extends ExtendableMessageNano {
            private static volatile ExtensionRange[] _emptyArray;
            public Integer start = null;
            public Integer end = null;

            public ExtensionRange() {
                this.cachedSize = -1;
            }

            public static ExtensionRange[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new ExtensionRange[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static ExtensionRange parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new ExtensionRange().mergeFrom(codedInputByteBufferNano);
            }

            public static ExtensionRange parseFrom(byte[] bArr) {
                return (ExtensionRange) MessageNano.mergeFrom(new ExtensionRange(), bArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.start;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.end;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue()) : computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final ExtensionRange mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.start = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 16) {
                        this.end = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                Integer num = this.start;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.end;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        /* loaded from: classes.dex */
        public final class ReservedRange extends ExtendableMessageNano {
            private static volatile ReservedRange[] _emptyArray;
            public Integer start = null;
            public Integer end = null;

            public ReservedRange() {
                this.cachedSize = -1;
            }

            public static ReservedRange[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new ReservedRange[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static ReservedRange parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new ReservedRange().mergeFrom(codedInputByteBufferNano);
            }

            public static ReservedRange parseFrom(byte[] bArr) {
                return (ReservedRange) MessageNano.mergeFrom(new ReservedRange(), bArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.start;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.end;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue()) : computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final ReservedRange mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.start = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 16) {
                        this.end = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                Integer num = this.start;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.end;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public DescriptorProto() {
            this.cachedSize = -1;
        }

        public static DescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static DescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new DescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static DescriptorProto parseFrom(byte[] bArr) {
            return (DescriptorProto) MessageNano.mergeFrom(new DescriptorProto(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            FieldDescriptorProto[] fieldDescriptorProtoArr = this.field;
            int i = 0;
            if (fieldDescriptorProtoArr != null && fieldDescriptorProtoArr.length > 0) {
                int i2 = 0;
                while (true) {
                    FieldDescriptorProto[] fieldDescriptorProtoArr2 = this.field;
                    if (i2 >= fieldDescriptorProtoArr2.length) {
                        break;
                    }
                    FieldDescriptorProto fieldDescriptorProto = fieldDescriptorProtoArr2[i2];
                    if (fieldDescriptorProto != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, fieldDescriptorProto);
                    }
                    i2++;
                }
            }
            DescriptorProto[] descriptorProtoArr = this.nestedType;
            if (descriptorProtoArr != null && descriptorProtoArr.length > 0) {
                int i3 = 0;
                while (true) {
                    DescriptorProto[] descriptorProtoArr2 = this.nestedType;
                    if (i3 >= descriptorProtoArr2.length) {
                        break;
                    }
                    DescriptorProto descriptorProto = descriptorProtoArr2[i3];
                    if (descriptorProto != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, descriptorProto);
                    }
                    i3++;
                }
            }
            EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
            if (enumDescriptorProtoArr != null && enumDescriptorProtoArr.length > 0) {
                int i4 = 0;
                while (true) {
                    EnumDescriptorProto[] enumDescriptorProtoArr2 = this.enumType;
                    if (i4 >= enumDescriptorProtoArr2.length) {
                        break;
                    }
                    EnumDescriptorProto enumDescriptorProto = enumDescriptorProtoArr2[i4];
                    if (enumDescriptorProto != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, enumDescriptorProto);
                    }
                    i4++;
                }
            }
            ExtensionRange[] extensionRangeArr = this.extensionRange;
            if (extensionRangeArr != null && extensionRangeArr.length > 0) {
                int i5 = 0;
                while (true) {
                    ExtensionRange[] extensionRangeArr2 = this.extensionRange;
                    if (i5 >= extensionRangeArr2.length) {
                        break;
                    }
                    ExtensionRange extensionRange = extensionRangeArr2[i5];
                    if (extensionRange != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, extensionRange);
                    }
                    i5++;
                }
            }
            FieldDescriptorProto[] fieldDescriptorProtoArr3 = this.extension;
            if (fieldDescriptorProtoArr3 != null && fieldDescriptorProtoArr3.length > 0) {
                int i6 = 0;
                while (true) {
                    FieldDescriptorProto[] fieldDescriptorProtoArr4 = this.extension;
                    if (i6 >= fieldDescriptorProtoArr4.length) {
                        break;
                    }
                    FieldDescriptorProto fieldDescriptorProto2 = fieldDescriptorProtoArr4[i6];
                    if (fieldDescriptorProto2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, fieldDescriptorProto2);
                    }
                    i6++;
                }
            }
            MessageOptions messageOptions = this.options;
            if (messageOptions != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, messageOptions);
            }
            OneofDescriptorProto[] oneofDescriptorProtoArr = this.oneofDecl;
            if (oneofDescriptorProtoArr != null && oneofDescriptorProtoArr.length > 0) {
                int i7 = 0;
                while (true) {
                    OneofDescriptorProto[] oneofDescriptorProtoArr2 = this.oneofDecl;
                    if (i7 >= oneofDescriptorProtoArr2.length) {
                        break;
                    }
                    OneofDescriptorProto oneofDescriptorProto = oneofDescriptorProtoArr2[i7];
                    if (oneofDescriptorProto != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, oneofDescriptorProto);
                    }
                    i7++;
                }
            }
            ReservedRange[] reservedRangeArr = this.reservedRange;
            if (reservedRangeArr != null && reservedRangeArr.length > 0) {
                int i8 = 0;
                while (true) {
                    ReservedRange[] reservedRangeArr2 = this.reservedRange;
                    if (i8 >= reservedRangeArr2.length) {
                        break;
                    }
                    ReservedRange reservedRange = reservedRangeArr2[i8];
                    if (reservedRange != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, reservedRange);
                    }
                    i8++;
                }
            }
            String[] strArr = this.reservedName;
            if (strArr == null || strArr.length <= 0) {
                return computeSerializedSize;
            }
            int i9 = 0;
            int i10 = 0;
            while (true) {
                String[] strArr2 = this.reservedName;
                if (i >= strArr2.length) {
                    return computeSerializedSize + i9 + (i10 * 1);
                }
                String str2 = strArr2[i];
                if (str2 != null) {
                    i10++;
                    i9 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i++;
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final DescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        FieldDescriptorProto[] fieldDescriptorProtoArr = this.field;
                        int length = fieldDescriptorProtoArr == null ? 0 : fieldDescriptorProtoArr.length;
                        int i = repeatedFieldArrayLength + length;
                        FieldDescriptorProto[] fieldDescriptorProtoArr2 = new FieldDescriptorProto[i];
                        if (length != 0) {
                            System.arraycopy(this.field, 0, fieldDescriptorProtoArr2, 0, length);
                        }
                        while (length < i - 1) {
                            fieldDescriptorProtoArr2[length] = new FieldDescriptorProto();
                            codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        fieldDescriptorProtoArr2[length] = new FieldDescriptorProto();
                        codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr2[length]);
                        this.field = fieldDescriptorProtoArr2;
                        break;
                    case 26:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        DescriptorProto[] descriptorProtoArr = this.nestedType;
                        int length2 = descriptorProtoArr == null ? 0 : descriptorProtoArr.length;
                        int i2 = repeatedFieldArrayLength2 + length2;
                        DescriptorProto[] descriptorProtoArr2 = new DescriptorProto[i2];
                        if (length2 != 0) {
                            System.arraycopy(this.nestedType, 0, descriptorProtoArr2, 0, length2);
                        }
                        while (length2 < i2 - 1) {
                            descriptorProtoArr2[length2] = new DescriptorProto();
                            codedInputByteBufferNano.readMessage(descriptorProtoArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        descriptorProtoArr2[length2] = new DescriptorProto();
                        codedInputByteBufferNano.readMessage(descriptorProtoArr2[length2]);
                        this.nestedType = descriptorProtoArr2;
                        break;
                    case 34:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
                        int length3 = enumDescriptorProtoArr == null ? 0 : enumDescriptorProtoArr.length;
                        int i3 = repeatedFieldArrayLength3 + length3;
                        EnumDescriptorProto[] enumDescriptorProtoArr2 = new EnumDescriptorProto[i3];
                        if (length3 != 0) {
                            System.arraycopy(this.enumType, 0, enumDescriptorProtoArr2, 0, length3);
                        }
                        while (length3 < i3 - 1) {
                            enumDescriptorProtoArr2[length3] = new EnumDescriptorProto();
                            codedInputByteBufferNano.readMessage(enumDescriptorProtoArr2[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        enumDescriptorProtoArr2[length3] = new EnumDescriptorProto();
                        codedInputByteBufferNano.readMessage(enumDescriptorProtoArr2[length3]);
                        this.enumType = enumDescriptorProtoArr2;
                        break;
                    case 42:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        ExtensionRange[] extensionRangeArr = this.extensionRange;
                        int length4 = extensionRangeArr == null ? 0 : extensionRangeArr.length;
                        int i4 = repeatedFieldArrayLength4 + length4;
                        ExtensionRange[] extensionRangeArr2 = new ExtensionRange[i4];
                        if (length4 != 0) {
                            System.arraycopy(this.extensionRange, 0, extensionRangeArr2, 0, length4);
                        }
                        while (length4 < i4 - 1) {
                            extensionRangeArr2[length4] = new ExtensionRange();
                            codedInputByteBufferNano.readMessage(extensionRangeArr2[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        extensionRangeArr2[length4] = new ExtensionRange();
                        codedInputByteBufferNano.readMessage(extensionRangeArr2[length4]);
                        this.extensionRange = extensionRangeArr2;
                        break;
                    case 50:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        FieldDescriptorProto[] fieldDescriptorProtoArr3 = this.extension;
                        int length5 = fieldDescriptorProtoArr3 == null ? 0 : fieldDescriptorProtoArr3.length;
                        int i5 = repeatedFieldArrayLength5 + length5;
                        FieldDescriptorProto[] fieldDescriptorProtoArr4 = new FieldDescriptorProto[i5];
                        if (length5 != 0) {
                            System.arraycopy(this.extension, 0, fieldDescriptorProtoArr4, 0, length5);
                        }
                        while (length5 < i5 - 1) {
                            fieldDescriptorProtoArr4[length5] = new FieldDescriptorProto();
                            codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr4[length5]);
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        fieldDescriptorProtoArr4[length5] = new FieldDescriptorProto();
                        codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr4[length5]);
                        this.extension = fieldDescriptorProtoArr4;
                        break;
                    case 58:
                        if (this.options == null) {
                            this.options = new MessageOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
                        break;
                    case 66:
                        int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                        OneofDescriptorProto[] oneofDescriptorProtoArr = this.oneofDecl;
                        int length6 = oneofDescriptorProtoArr == null ? 0 : oneofDescriptorProtoArr.length;
                        int i6 = repeatedFieldArrayLength6 + length6;
                        OneofDescriptorProto[] oneofDescriptorProtoArr2 = new OneofDescriptorProto[i6];
                        if (length6 != 0) {
                            System.arraycopy(this.oneofDecl, 0, oneofDescriptorProtoArr2, 0, length6);
                        }
                        while (length6 < i6 - 1) {
                            oneofDescriptorProtoArr2[length6] = new OneofDescriptorProto();
                            codedInputByteBufferNano.readMessage(oneofDescriptorProtoArr2[length6]);
                            codedInputByteBufferNano.readTag();
                            length6++;
                        }
                        oneofDescriptorProtoArr2[length6] = new OneofDescriptorProto();
                        codedInputByteBufferNano.readMessage(oneofDescriptorProtoArr2[length6]);
                        this.oneofDecl = oneofDescriptorProtoArr2;
                        break;
                    case 74:
                        int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                        ReservedRange[] reservedRangeArr = this.reservedRange;
                        int length7 = reservedRangeArr == null ? 0 : reservedRangeArr.length;
                        int i7 = repeatedFieldArrayLength7 + length7;
                        ReservedRange[] reservedRangeArr2 = new ReservedRange[i7];
                        if (length7 != 0) {
                            System.arraycopy(this.reservedRange, 0, reservedRangeArr2, 0, length7);
                        }
                        while (length7 < i7 - 1) {
                            reservedRangeArr2[length7] = new ReservedRange();
                            codedInputByteBufferNano.readMessage(reservedRangeArr2[length7]);
                            codedInputByteBufferNano.readTag();
                            length7++;
                        }
                        reservedRangeArr2[length7] = new ReservedRange();
                        codedInputByteBufferNano.readMessage(reservedRangeArr2[length7]);
                        this.reservedRange = reservedRangeArr2;
                        break;
                    case 82:
                        int repeatedFieldArrayLength8 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                        String[] strArr = this.reservedName;
                        int length8 = strArr == null ? 0 : strArr.length;
                        int i8 = repeatedFieldArrayLength8 + length8;
                        String[] strArr2 = new String[i8];
                        if (length8 != 0) {
                            System.arraycopy(this.reservedName, 0, strArr2, 0, length8);
                        }
                        while (length8 < i8 - 1) {
                            strArr2[length8] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length8++;
                        }
                        strArr2[length8] = codedInputByteBufferNano.readString();
                        this.reservedName = strArr2;
                        break;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            String str = this.name;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            FieldDescriptorProto[] fieldDescriptorProtoArr = this.field;
            int i = 0;
            if (fieldDescriptorProtoArr != null && fieldDescriptorProtoArr.length > 0) {
                int i2 = 0;
                while (true) {
                    FieldDescriptorProto[] fieldDescriptorProtoArr2 = this.field;
                    if (i2 >= fieldDescriptorProtoArr2.length) {
                        break;
                    }
                    FieldDescriptorProto fieldDescriptorProto = fieldDescriptorProtoArr2[i2];
                    if (fieldDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(2, fieldDescriptorProto);
                    }
                    i2++;
                }
            }
            DescriptorProto[] descriptorProtoArr = this.nestedType;
            if (descriptorProtoArr != null && descriptorProtoArr.length > 0) {
                int i3 = 0;
                while (true) {
                    DescriptorProto[] descriptorProtoArr2 = this.nestedType;
                    if (i3 >= descriptorProtoArr2.length) {
                        break;
                    }
                    DescriptorProto descriptorProto = descriptorProtoArr2[i3];
                    if (descriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(3, descriptorProto);
                    }
                    i3++;
                }
            }
            EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
            if (enumDescriptorProtoArr != null && enumDescriptorProtoArr.length > 0) {
                int i4 = 0;
                while (true) {
                    EnumDescriptorProto[] enumDescriptorProtoArr2 = this.enumType;
                    if (i4 >= enumDescriptorProtoArr2.length) {
                        break;
                    }
                    EnumDescriptorProto enumDescriptorProto = enumDescriptorProtoArr2[i4];
                    if (enumDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(4, enumDescriptorProto);
                    }
                    i4++;
                }
            }
            ExtensionRange[] extensionRangeArr = this.extensionRange;
            if (extensionRangeArr != null && extensionRangeArr.length > 0) {
                int i5 = 0;
                while (true) {
                    ExtensionRange[] extensionRangeArr2 = this.extensionRange;
                    if (i5 >= extensionRangeArr2.length) {
                        break;
                    }
                    ExtensionRange extensionRange = extensionRangeArr2[i5];
                    if (extensionRange != null) {
                        codedOutputByteBufferNano.writeMessage(5, extensionRange);
                    }
                    i5++;
                }
            }
            FieldDescriptorProto[] fieldDescriptorProtoArr3 = this.extension;
            if (fieldDescriptorProtoArr3 != null && fieldDescriptorProtoArr3.length > 0) {
                int i6 = 0;
                while (true) {
                    FieldDescriptorProto[] fieldDescriptorProtoArr4 = this.extension;
                    if (i6 >= fieldDescriptorProtoArr4.length) {
                        break;
                    }
                    FieldDescriptorProto fieldDescriptorProto2 = fieldDescriptorProtoArr4[i6];
                    if (fieldDescriptorProto2 != null) {
                        codedOutputByteBufferNano.writeMessage(6, fieldDescriptorProto2);
                    }
                    i6++;
                }
            }
            MessageOptions messageOptions = this.options;
            if (messageOptions != null) {
                codedOutputByteBufferNano.writeMessage(7, messageOptions);
            }
            OneofDescriptorProto[] oneofDescriptorProtoArr = this.oneofDecl;
            if (oneofDescriptorProtoArr != null && oneofDescriptorProtoArr.length > 0) {
                int i7 = 0;
                while (true) {
                    OneofDescriptorProto[] oneofDescriptorProtoArr2 = this.oneofDecl;
                    if (i7 >= oneofDescriptorProtoArr2.length) {
                        break;
                    }
                    OneofDescriptorProto oneofDescriptorProto = oneofDescriptorProtoArr2[i7];
                    if (oneofDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(8, oneofDescriptorProto);
                    }
                    i7++;
                }
            }
            ReservedRange[] reservedRangeArr = this.reservedRange;
            if (reservedRangeArr != null && reservedRangeArr.length > 0) {
                int i8 = 0;
                while (true) {
                    ReservedRange[] reservedRangeArr2 = this.reservedRange;
                    if (i8 >= reservedRangeArr2.length) {
                        break;
                    }
                    ReservedRange reservedRange = reservedRangeArr2[i8];
                    if (reservedRange != null) {
                        codedOutputByteBufferNano.writeMessage(9, reservedRange);
                    }
                    i8++;
                }
            }
            String[] strArr = this.reservedName;
            if (strArr != null && strArr.length > 0) {
                while (true) {
                    String[] strArr2 = this.reservedName;
                    if (i >= strArr2.length) {
                        break;
                    }
                    String str2 = strArr2[i];
                    if (str2 != null) {
                        codedOutputByteBufferNano.writeString(10, str2);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class EnumDescriptorProto extends ExtendableMessageNano {
        private static volatile EnumDescriptorProto[] _emptyArray;
        public EnumOptions options;
        public String name = null;
        public EnumValueDescriptorProto[] value = EnumValueDescriptorProto.emptyArray();

        public EnumDescriptorProto() {
            this.cachedSize = -1;
        }

        public static EnumDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new EnumDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static EnumDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new EnumDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static EnumDescriptorProto parseFrom(byte[] bArr) {
            return (EnumDescriptorProto) MessageNano.mergeFrom(new EnumDescriptorProto(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            EnumValueDescriptorProto[] enumValueDescriptorProtoArr = this.value;
            if (enumValueDescriptorProtoArr != null && enumValueDescriptorProtoArr.length > 0) {
                int i = 0;
                while (true) {
                    EnumValueDescriptorProto[] enumValueDescriptorProtoArr2 = this.value;
                    if (i >= enumValueDescriptorProtoArr2.length) {
                        break;
                    }
                    EnumValueDescriptorProto enumValueDescriptorProto = enumValueDescriptorProtoArr2[i];
                    if (enumValueDescriptorProto != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, enumValueDescriptorProto);
                    }
                    i++;
                }
            }
            EnumOptions enumOptions = this.options;
            return enumOptions != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, enumOptions) : computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final EnumDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (readTag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    EnumValueDescriptorProto[] enumValueDescriptorProtoArr = this.value;
                    int length = enumValueDescriptorProtoArr == null ? 0 : enumValueDescriptorProtoArr.length;
                    int i = repeatedFieldArrayLength + length;
                    EnumValueDescriptorProto[] enumValueDescriptorProtoArr2 = new EnumValueDescriptorProto[i];
                    if (length != 0) {
                        System.arraycopy(this.value, 0, enumValueDescriptorProtoArr2, 0, length);
                    }
                    while (length < i - 1) {
                        enumValueDescriptorProtoArr2[length] = new EnumValueDescriptorProto();
                        codedInputByteBufferNano.readMessage(enumValueDescriptorProtoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    enumValueDescriptorProtoArr2[length] = new EnumValueDescriptorProto();
                    codedInputByteBufferNano.readMessage(enumValueDescriptorProtoArr2[length]);
                    this.value = enumValueDescriptorProtoArr2;
                } else if (readTag == 26) {
                    if (this.options == null) {
                        this.options = new EnumOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            String str = this.name;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            EnumValueDescriptorProto[] enumValueDescriptorProtoArr = this.value;
            if (enumValueDescriptorProtoArr != null && enumValueDescriptorProtoArr.length > 0) {
                int i = 0;
                while (true) {
                    EnumValueDescriptorProto[] enumValueDescriptorProtoArr2 = this.value;
                    if (i >= enumValueDescriptorProtoArr2.length) {
                        break;
                    }
                    EnumValueDescriptorProto enumValueDescriptorProto = enumValueDescriptorProtoArr2[i];
                    if (enumValueDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(2, enumValueDescriptorProto);
                    }
                    i++;
                }
            }
            EnumOptions enumOptions = this.options;
            if (enumOptions != null) {
                codedOutputByteBufferNano.writeMessage(3, enumOptions);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class EnumOptions extends ExtendableMessageNano {
        private static volatile EnumOptions[] _emptyArray;
        public String proto1Name = null;
        public Boolean ccAllowUnsafeEnumToString = null;
        public Boolean allowAlias = null;
        public Boolean deprecated = null;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        public EnumOptions() {
            this.cachedSize = -1;
        }

        public static EnumOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new EnumOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static EnumOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new EnumOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static EnumOptions parseFrom(byte[] bArr) {
            return (EnumOptions) MessageNano.mergeFrom(new EnumOptions(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            String str = this.proto1Name;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            Boolean bool = this.allowAlias;
            if (bool != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue());
            }
            Boolean bool2 = this.deprecated;
            if (bool2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, bool2.booleanValue());
            }
            Boolean bool3 = this.ccAllowUnsafeEnumToString;
            if (bool3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, bool3.booleanValue());
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i];
                    if (uninterpretedOption != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final EnumOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.proto1Name = codedInputByteBufferNano.readString();
                } else if (readTag == 16) {
                    this.allowAlias = Boolean.valueOf(codedInputByteBufferNano.readBool());
                } else if (readTag == 24) {
                    this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                } else if (readTag == 32) {
                    this.ccAllowUnsafeEnumToString = Boolean.valueOf(codedInputByteBufferNano.readBool());
                } else if (readTag == 7994) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    int i = repeatedFieldArrayLength + length;
                    UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[i];
                    if (length != 0) {
                        System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                    }
                    while (length < i - 1) {
                        uninterpretedOptionArr2[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    uninterpretedOptionArr2[length] = new UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            String str = this.proto1Name;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            Boolean bool = this.allowAlias;
            if (bool != null) {
                codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
            }
            Boolean bool2 = this.deprecated;
            if (bool2 != null) {
                codedOutputByteBufferNano.writeBool(3, bool2.booleanValue());
            }
            Boolean bool3 = this.ccAllowUnsafeEnumToString;
            if (bool3 != null) {
                codedOutputByteBufferNano.writeBool(4, bool3.booleanValue());
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class EnumValueDescriptorProto extends ExtendableMessageNano {
        private static volatile EnumValueDescriptorProto[] _emptyArray;
        public String name = null;
        public Integer number = null;
        public EnumValueOptions options;

        public EnumValueDescriptorProto() {
            this.cachedSize = -1;
        }

        public static EnumValueDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new EnumValueDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new EnumValueDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static EnumValueDescriptorProto parseFrom(byte[] bArr) {
            return (EnumValueDescriptorProto) MessageNano.mergeFrom(new EnumValueDescriptorProto(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            Integer num = this.number;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num.intValue());
            }
            EnumValueOptions enumValueOptions = this.options;
            return enumValueOptions != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, enumValueOptions) : computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final EnumValueDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (readTag == 16) {
                    this.number = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (readTag == 26) {
                    if (this.options == null) {
                        this.options = new EnumValueOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            String str = this.name;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            Integer num = this.number;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(2, num.intValue());
            }
            EnumValueOptions enumValueOptions = this.options;
            if (enumValueOptions != null) {
                codedOutputByteBufferNano.writeMessage(3, enumValueOptions);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class EnumValueOptions extends ExtendableMessageNano {
        private static volatile EnumValueOptions[] _emptyArray;
        public Boolean deprecated = null;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        public EnumValueOptions() {
            this.cachedSize = -1;
        }

        public static EnumValueOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new EnumValueOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static EnumValueOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new EnumValueOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static EnumValueOptions parseFrom(byte[] bArr) {
            return (EnumValueOptions) MessageNano.mergeFrom(new EnumValueOptions(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Boolean bool = this.deprecated;
            if (bool != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, bool.booleanValue());
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i];
                    if (uninterpretedOption != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final EnumValueOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                } else if (readTag == 7994) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    int i = repeatedFieldArrayLength + length;
                    UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[i];
                    if (length != 0) {
                        System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                    }
                    while (length < i - 1) {
                        uninterpretedOptionArr2[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    uninterpretedOptionArr2[length] = new UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            Boolean bool = this.deprecated;
            if (bool != null) {
                codedOutputByteBufferNano.writeBool(1, bool.booleanValue());
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class FieldDescriptorProto extends ExtendableMessageNano {
        private static volatile FieldDescriptorProto[] _emptyArray;
        public FieldOptions options;
        public String name = null;
        public Integer number = null;
        public int label = Integer.MIN_VALUE;
        public int type = Integer.MIN_VALUE;
        public String typeName = null;
        public String extendee = null;
        public String defaultValue = null;
        public Integer oneofIndex = null;
        public String jsonName = null;

        /* loaded from: classes.dex */
        public interface Label {
            public static final int LABEL_OPTIONAL = 1;
            public static final int LABEL_REPEATED = 3;
            public static final int LABEL_REQUIRED = 2;
        }

        /* loaded from: classes.dex */
        public interface Type {
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
        }

        public FieldDescriptorProto() {
            this.cachedSize = -1;
        }

        public static FieldDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FieldDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static FieldDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new FieldDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static FieldDescriptorProto parseFrom(byte[] bArr) {
            return (FieldDescriptorProto) MessageNano.mergeFrom(new FieldDescriptorProto(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            String str2 = this.extendee;
            if (str2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, str2);
            }
            Integer num = this.number;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num.intValue());
            }
            int i = this.label;
            if (i != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
            }
            int i2 = this.type;
            if (i2 != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i2);
            }
            String str3 = this.typeName;
            if (str3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, str3);
            }
            String str4 = this.defaultValue;
            if (str4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, str4);
            }
            FieldOptions fieldOptions = this.options;
            if (fieldOptions != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, fieldOptions);
            }
            Integer num2 = this.oneofIndex;
            if (num2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, num2.intValue());
            }
            String str5 = this.jsonName;
            return str5 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, str5) : computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final FieldDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.extendee = codedInputByteBufferNano.readString();
                        break;
                    case 24:
                        this.number = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        break;
                    case 32:
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                            break;
                        } else {
                            this.label = readInt32;
                            break;
                        }
                    case 40:
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        switch (readInt322) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                                this.type = readInt322;
                                break;
                        }
                    case 50:
                        this.typeName = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        this.defaultValue = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        if (this.options == null) {
                            this.options = new FieldOptions();
                        }
                        codedInputByteBufferNano.readMessage(this.options);
                        break;
                    case 72:
                        this.oneofIndex = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        break;
                    case 82:
                        this.jsonName = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            String str = this.name;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            String str2 = this.extendee;
            if (str2 != null) {
                codedOutputByteBufferNano.writeString(2, str2);
            }
            Integer num = this.number;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(3, num.intValue());
            }
            int i = this.label;
            if (i != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(4, i);
            }
            int i2 = this.type;
            if (i2 != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(5, i2);
            }
            String str3 = this.typeName;
            if (str3 != null) {
                codedOutputByteBufferNano.writeString(6, str3);
            }
            String str4 = this.defaultValue;
            if (str4 != null) {
                codedOutputByteBufferNano.writeString(7, str4);
            }
            FieldOptions fieldOptions = this.options;
            if (fieldOptions != null) {
                codedOutputByteBufferNano.writeMessage(8, fieldOptions);
            }
            Integer num2 = this.oneofIndex;
            if (num2 != null) {
                codedOutputByteBufferNano.writeInt32(9, num2.intValue());
            }
            String str5 = this.jsonName;
            if (str5 != null) {
                codedOutputByteBufferNano.writeString(10, str5);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class FieldOptions extends ExtendableMessageNano {
        private static volatile FieldOptions[] _emptyArray;
        public int ctype = Integer.MIN_VALUE;
        public Boolean packed = null;
        public int jtype = Integer.MIN_VALUE;
        public int jstype = Integer.MIN_VALUE;
        public Boolean lazy = null;
        public Boolean deprecated = null;
        public Boolean weak = null;
        public UpgradedOption[] upgradedOption = UpgradedOption.emptyArray();
        public Boolean deprecatedRawMessage = null;
        public Boolean enforceUtf8 = null;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        /* loaded from: classes.dex */
        public interface CType {
            public static final int CORD = 1;
            public static final int STRING = 0;
            public static final int STRING_PIECE = 2;
        }

        /* loaded from: classes.dex */
        public interface JSType {
            public static final int JS_NORMAL = 0;
            public static final int JS_NUMBER = 2;
            public static final int JS_STRING = 1;
        }

        /* loaded from: classes.dex */
        public interface JType {
            public static final int BYTES = 1;
            public static final int EXPERIMENTAL_BYTE_BUFFER = 2;
            public static final int NORMAL = 0;
        }

        /* loaded from: classes.dex */
        public final class UpgradedOption extends ExtendableMessageNano {
            private static volatile UpgradedOption[] _emptyArray;
            public String name = null;
            public String value = null;

            public UpgradedOption() {
                this.cachedSize = -1;
            }

            public static UpgradedOption[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new UpgradedOption[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static UpgradedOption parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new UpgradedOption().mergeFrom(codedInputByteBufferNano);
            }

            public static UpgradedOption parseFrom(byte[] bArr) {
                return (UpgradedOption) MessageNano.mergeFrom(new UpgradedOption(), bArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                String str = this.name;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
                }
                String str2 = this.value;
                return str2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, str2) : computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final UpgradedOption mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.name = codedInputByteBufferNano.readString();
                    } else if (readTag == 18) {
                        this.value = codedInputByteBufferNano.readString();
                    } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                String str = this.name;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                String str2 = this.value;
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(2, str2);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public FieldOptions() {
            this.cachedSize = -1;
        }

        public static FieldOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FieldOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static FieldOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new FieldOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static FieldOptions parseFrom(byte[] bArr) {
            return (FieldOptions) MessageNano.mergeFrom(new FieldOptions(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            int i = this.ctype;
            if (i != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            Boolean bool = this.packed;
            if (bool != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue());
            }
            Boolean bool2 = this.deprecated;
            if (bool2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, bool2.booleanValue());
            }
            int i2 = this.jtype;
            if (i2 != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i2);
            }
            Boolean bool3 = this.lazy;
            if (bool3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, bool3.booleanValue());
            }
            int i3 = this.jstype;
            if (i3 != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i3);
            }
            Boolean bool4 = this.weak;
            if (bool4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, bool4.booleanValue());
            }
            UpgradedOption[] upgradedOptionArr = this.upgradedOption;
            int i4 = 0;
            if (upgradedOptionArr != null && upgradedOptionArr.length > 0) {
                int i5 = 0;
                while (true) {
                    UpgradedOption[] upgradedOptionArr2 = this.upgradedOption;
                    if (i5 >= upgradedOptionArr2.length) {
                        break;
                    }
                    UpgradedOption upgradedOption = upgradedOptionArr2[i5];
                    if (upgradedOption != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, upgradedOption);
                    }
                    i5++;
                }
            }
            Boolean bool5 = this.deprecatedRawMessage;
            if (bool5 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, bool5.booleanValue());
            }
            Boolean bool6 = this.enforceUtf8;
            if (bool6 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, bool6.booleanValue());
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i4 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i4];
                    if (uninterpretedOption != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i4++;
                }
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final FieldOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 8:
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                            break;
                        } else {
                            this.ctype = readInt32;
                            break;
                        }
                    case 16:
                        this.packed = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 24:
                        this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 32:
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                            break;
                        } else {
                            this.jtype = readInt322;
                            break;
                        }
                    case 40:
                        this.lazy = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 48:
                        int readInt323 = codedInputByteBufferNano.readInt32();
                        if (readInt323 != 0 && readInt323 != 1 && readInt323 != 2) {
                            break;
                        } else {
                            this.jstype = readInt323;
                            break;
                        }
                        break;
                    case 80:
                        this.weak = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 90:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                        UpgradedOption[] upgradedOptionArr = this.upgradedOption;
                        int length = upgradedOptionArr == null ? 0 : upgradedOptionArr.length;
                        int i = repeatedFieldArrayLength + length;
                        UpgradedOption[] upgradedOptionArr2 = new UpgradedOption[i];
                        if (length != 0) {
                            System.arraycopy(this.upgradedOption, 0, upgradedOptionArr2, 0, length);
                        }
                        while (length < i - 1) {
                            upgradedOptionArr2[length] = new UpgradedOption();
                            codedInputByteBufferNano.readMessage(upgradedOptionArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        upgradedOptionArr2[length] = new UpgradedOption();
                        codedInputByteBufferNano.readMessage(upgradedOptionArr2[length]);
                        this.upgradedOption = upgradedOptionArr2;
                        break;
                    case 96:
                        this.deprecatedRawMessage = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 104:
                        this.enforceUtf8 = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 7994:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                        int length2 = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                        int i2 = repeatedFieldArrayLength2 + length2;
                        UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[i2];
                        if (length2 != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length2);
                        }
                        while (length2 < i2 - 1) {
                            uninterpretedOptionArr2[length2] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        uninterpretedOptionArr2[length2] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length2]);
                        this.uninterpretedOption = uninterpretedOptionArr2;
                        break;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            int i = this.ctype;
            if (i != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            Boolean bool = this.packed;
            if (bool != null) {
                codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
            }
            Boolean bool2 = this.deprecated;
            if (bool2 != null) {
                codedOutputByteBufferNano.writeBool(3, bool2.booleanValue());
            }
            int i2 = this.jtype;
            if (i2 != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(4, i2);
            }
            Boolean bool3 = this.lazy;
            if (bool3 != null) {
                codedOutputByteBufferNano.writeBool(5, bool3.booleanValue());
            }
            int i3 = this.jstype;
            if (i3 != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(6, i3);
            }
            Boolean bool4 = this.weak;
            if (bool4 != null) {
                codedOutputByteBufferNano.writeBool(10, bool4.booleanValue());
            }
            UpgradedOption[] upgradedOptionArr = this.upgradedOption;
            int i4 = 0;
            if (upgradedOptionArr != null && upgradedOptionArr.length > 0) {
                int i5 = 0;
                while (true) {
                    UpgradedOption[] upgradedOptionArr2 = this.upgradedOption;
                    if (i5 >= upgradedOptionArr2.length) {
                        break;
                    }
                    UpgradedOption upgradedOption = upgradedOptionArr2[i5];
                    if (upgradedOption != null) {
                        codedOutputByteBufferNano.writeMessage(11, upgradedOption);
                    }
                    i5++;
                }
            }
            Boolean bool5 = this.deprecatedRawMessage;
            if (bool5 != null) {
                codedOutputByteBufferNano.writeBool(12, bool5.booleanValue());
            }
            Boolean bool6 = this.enforceUtf8;
            if (bool6 != null) {
                codedOutputByteBufferNano.writeBool(13, bool6.booleanValue());
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i4 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i4];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i4++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class FileDescriptorProto extends ExtendableMessageNano {
        private static volatile FileDescriptorProto[] _emptyArray;
        public EnumDescriptorProto[] enumType;
        public FieldDescriptorProto[] extension;
        public DescriptorProto[] messageType;
        public FileOptions options;
        public int[] publicDependency;
        public ServiceDescriptorProto[] service;
        public SourceCodeInfo sourceCodeInfo;
        public String syntax;
        public int[] weakDependency;
        public String name = null;
        public String package_ = null;
        public String[] dependency = WireFormatNano.EMPTY_STRING_ARRAY;

        public FileDescriptorProto() {
            int[] iArr = WireFormatNano.EMPTY_INT_ARRAY;
            this.publicDependency = iArr;
            this.weakDependency = iArr;
            this.messageType = DescriptorProto.emptyArray();
            this.enumType = EnumDescriptorProto.emptyArray();
            this.service = ServiceDescriptorProto.emptyArray();
            this.extension = FieldDescriptorProto.emptyArray();
            this.syntax = null;
            this.cachedSize = -1;
        }

        public static FileDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FileDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static FileDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new FileDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static FileDescriptorProto parseFrom(byte[] bArr) {
            return (FileDescriptorProto) MessageNano.mergeFrom(new FileDescriptorProto(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int[] iArr;
            int[] iArr2;
            int computeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            String str2 = this.package_;
            if (str2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, str2);
            }
            String[] strArr = this.dependency;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    String[] strArr2 = this.dependency;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str3 = strArr2[i2];
                    if (str3 != null) {
                        i4++;
                        i3 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                    }
                    i2++;
                }
                computeSerializedSize = computeSerializedSize + i3 + (i4 * 1);
            }
            DescriptorProto[] descriptorProtoArr = this.messageType;
            if (descriptorProtoArr != null && descriptorProtoArr.length > 0) {
                int i5 = 0;
                while (true) {
                    DescriptorProto[] descriptorProtoArr2 = this.messageType;
                    if (i5 >= descriptorProtoArr2.length) {
                        break;
                    }
                    DescriptorProto descriptorProto = descriptorProtoArr2[i5];
                    if (descriptorProto != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, descriptorProto);
                    }
                    i5++;
                }
            }
            EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
            if (enumDescriptorProtoArr != null && enumDescriptorProtoArr.length > 0) {
                int i6 = 0;
                while (true) {
                    EnumDescriptorProto[] enumDescriptorProtoArr2 = this.enumType;
                    if (i6 >= enumDescriptorProtoArr2.length) {
                        break;
                    }
                    EnumDescriptorProto enumDescriptorProto = enumDescriptorProtoArr2[i6];
                    if (enumDescriptorProto != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, enumDescriptorProto);
                    }
                    i6++;
                }
            }
            ServiceDescriptorProto[] serviceDescriptorProtoArr = this.service;
            if (serviceDescriptorProtoArr != null && serviceDescriptorProtoArr.length > 0) {
                int i7 = 0;
                while (true) {
                    ServiceDescriptorProto[] serviceDescriptorProtoArr2 = this.service;
                    if (i7 >= serviceDescriptorProtoArr2.length) {
                        break;
                    }
                    ServiceDescriptorProto serviceDescriptorProto = serviceDescriptorProtoArr2[i7];
                    if (serviceDescriptorProto != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, serviceDescriptorProto);
                    }
                    i7++;
                }
            }
            FieldDescriptorProto[] fieldDescriptorProtoArr = this.extension;
            if (fieldDescriptorProtoArr != null && fieldDescriptorProtoArr.length > 0) {
                int i8 = 0;
                while (true) {
                    FieldDescriptorProto[] fieldDescriptorProtoArr2 = this.extension;
                    if (i8 >= fieldDescriptorProtoArr2.length) {
                        break;
                    }
                    FieldDescriptorProto fieldDescriptorProto = fieldDescriptorProtoArr2[i8];
                    if (fieldDescriptorProto != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, fieldDescriptorProto);
                    }
                    i8++;
                }
            }
            FileOptions fileOptions = this.options;
            if (fileOptions != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, fileOptions);
            }
            SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo;
            if (sourceCodeInfo != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, sourceCodeInfo);
            }
            int[] iArr3 = this.publicDependency;
            if (iArr3 != null && iArr3.length > 0) {
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    iArr2 = this.publicDependency;
                    if (i9 >= iArr2.length) {
                        break;
                    }
                    i10 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i9]);
                    i9++;
                }
                computeSerializedSize = computeSerializedSize + i10 + (iArr2.length * 1);
            }
            int[] iArr4 = this.weakDependency;
            if (iArr4 != null && iArr4.length > 0) {
                int i11 = 0;
                while (true) {
                    iArr = this.weakDependency;
                    if (i >= iArr.length) {
                        break;
                    }
                    i11 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i]);
                    i++;
                }
                computeSerializedSize = computeSerializedSize + i11 + (iArr.length * 1);
            }
            String str4 = this.syntax;
            return str4 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, str4) : computeSerializedSize;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0005. Please report as an issue. */
        @Override // com.google.protobuf.nano.MessageNano
        public final FileDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            MessageNano messageNano;
            int pushLimit;
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 10:
                        this.name = codedInputByteBufferNano.readString();
                    case 18:
                        this.package_ = codedInputByteBufferNano.readString();
                    case 26:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        String[] strArr = this.dependency;
                        int length = strArr == null ? 0 : strArr.length;
                        int i = repeatedFieldArrayLength + length;
                        String[] strArr2 = new String[i];
                        if (length != 0) {
                            System.arraycopy(this.dependency, 0, strArr2, 0, length);
                        }
                        while (length < i - 1) {
                            strArr2[length] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        strArr2[length] = codedInputByteBufferNano.readString();
                        this.dependency = strArr2;
                    case 34:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        DescriptorProto[] descriptorProtoArr = this.messageType;
                        int length2 = descriptorProtoArr == null ? 0 : descriptorProtoArr.length;
                        int i2 = repeatedFieldArrayLength2 + length2;
                        DescriptorProto[] descriptorProtoArr2 = new DescriptorProto[i2];
                        if (length2 != 0) {
                            System.arraycopy(this.messageType, 0, descriptorProtoArr2, 0, length2);
                        }
                        while (length2 < i2 - 1) {
                            descriptorProtoArr2[length2] = new DescriptorProto();
                            codedInputByteBufferNano.readMessage(descriptorProtoArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        descriptorProtoArr2[length2] = new DescriptorProto();
                        codedInputByteBufferNano.readMessage(descriptorProtoArr2[length2]);
                        this.messageType = descriptorProtoArr2;
                    case 42:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
                        int length3 = enumDescriptorProtoArr == null ? 0 : enumDescriptorProtoArr.length;
                        int i3 = repeatedFieldArrayLength3 + length3;
                        EnumDescriptorProto[] enumDescriptorProtoArr2 = new EnumDescriptorProto[i3];
                        if (length3 != 0) {
                            System.arraycopy(this.enumType, 0, enumDescriptorProtoArr2, 0, length3);
                        }
                        while (length3 < i3 - 1) {
                            enumDescriptorProtoArr2[length3] = new EnumDescriptorProto();
                            codedInputByteBufferNano.readMessage(enumDescriptorProtoArr2[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        enumDescriptorProtoArr2[length3] = new EnumDescriptorProto();
                        codedInputByteBufferNano.readMessage(enumDescriptorProtoArr2[length3]);
                        this.enumType = enumDescriptorProtoArr2;
                    case 50:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        ServiceDescriptorProto[] serviceDescriptorProtoArr = this.service;
                        int length4 = serviceDescriptorProtoArr == null ? 0 : serviceDescriptorProtoArr.length;
                        int i4 = repeatedFieldArrayLength4 + length4;
                        ServiceDescriptorProto[] serviceDescriptorProtoArr2 = new ServiceDescriptorProto[i4];
                        if (length4 != 0) {
                            System.arraycopy(this.service, 0, serviceDescriptorProtoArr2, 0, length4);
                        }
                        while (length4 < i4 - 1) {
                            serviceDescriptorProtoArr2[length4] = new ServiceDescriptorProto();
                            codedInputByteBufferNano.readMessage(serviceDescriptorProtoArr2[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        serviceDescriptorProtoArr2[length4] = new ServiceDescriptorProto();
                        codedInputByteBufferNano.readMessage(serviceDescriptorProtoArr2[length4]);
                        this.service = serviceDescriptorProtoArr2;
                    case 58:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                        FieldDescriptorProto[] fieldDescriptorProtoArr = this.extension;
                        int length5 = fieldDescriptorProtoArr == null ? 0 : fieldDescriptorProtoArr.length;
                        int i5 = repeatedFieldArrayLength5 + length5;
                        FieldDescriptorProto[] fieldDescriptorProtoArr2 = new FieldDescriptorProto[i5];
                        if (length5 != 0) {
                            System.arraycopy(this.extension, 0, fieldDescriptorProtoArr2, 0, length5);
                        }
                        while (length5 < i5 - 1) {
                            fieldDescriptorProtoArr2[length5] = new FieldDescriptorProto();
                            codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr2[length5]);
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        fieldDescriptorProtoArr2[length5] = new FieldDescriptorProto();
                        codedInputByteBufferNano.readMessage(fieldDescriptorProtoArr2[length5]);
                        this.extension = fieldDescriptorProtoArr2;
                    case 66:
                        if (this.options == null) {
                            this.options = new FileOptions();
                        }
                        messageNano = this.options;
                        codedInputByteBufferNano.readMessage(messageNano);
                    case 74:
                        if (this.sourceCodeInfo == null) {
                            this.sourceCodeInfo = new SourceCodeInfo();
                        }
                        messageNano = this.sourceCodeInfo;
                        codedInputByteBufferNano.readMessage(messageNano);
                    case 80:
                        int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 80);
                        int[] iArr = this.publicDependency;
                        int length6 = iArr == null ? 0 : iArr.length;
                        int i6 = repeatedFieldArrayLength6 + length6;
                        int[] iArr2 = new int[i6];
                        if (length6 != 0) {
                            System.arraycopy(this.publicDependency, 0, iArr2, 0, length6);
                        }
                        while (length6 < i6 - 1) {
                            iArr2[length6] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            length6++;
                        }
                        iArr2[length6] = codedInputByteBufferNano.readInt32();
                        this.publicDependency = iArr2;
                    case 82:
                        pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position = codedInputByteBufferNano.getPosition();
                        int i7 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            i7++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr3 = this.publicDependency;
                        int length7 = iArr3 == null ? 0 : iArr3.length;
                        int i8 = i7 + length7;
                        int[] iArr4 = new int[i8];
                        if (length7 != 0) {
                            System.arraycopy(this.publicDependency, 0, iArr4, 0, length7);
                        }
                        while (length7 < i8) {
                            iArr4[length7] = codedInputByteBufferNano.readInt32();
                            length7++;
                        }
                        this.publicDependency = iArr4;
                        codedInputByteBufferNano.popLimit(pushLimit);
                    case 88:
                        int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 88);
                        int[] iArr5 = this.weakDependency;
                        int length8 = iArr5 == null ? 0 : iArr5.length;
                        int i9 = repeatedFieldArrayLength7 + length8;
                        int[] iArr6 = new int[i9];
                        if (length8 != 0) {
                            System.arraycopy(this.weakDependency, 0, iArr6, 0, length8);
                        }
                        while (length8 < i9 - 1) {
                            iArr6[length8] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            length8++;
                        }
                        iArr6[length8] = codedInputByteBufferNano.readInt32();
                        this.weakDependency = iArr6;
                    case 90:
                        pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position2 = codedInputByteBufferNano.getPosition();
                        int i10 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            i10++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position2);
                        int[] iArr7 = this.weakDependency;
                        int length9 = iArr7 == null ? 0 : iArr7.length;
                        int i11 = i10 + length9;
                        int[] iArr8 = new int[i11];
                        if (length9 != 0) {
                            System.arraycopy(this.weakDependency, 0, iArr8, 0, length9);
                        }
                        while (length9 < i11) {
                            iArr8[length9] = codedInputByteBufferNano.readInt32();
                            length9++;
                        }
                        this.weakDependency = iArr8;
                        codedInputByteBufferNano.popLimit(pushLimit);
                    case 98:
                        this.syntax = codedInputByteBufferNano.readString();
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            String str = this.name;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            String str2 = this.package_;
            if (str2 != null) {
                codedOutputByteBufferNano.writeString(2, str2);
            }
            String[] strArr = this.dependency;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.dependency;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str3 = strArr2[i2];
                    if (str3 != null) {
                        codedOutputByteBufferNano.writeString(3, str3);
                    }
                    i2++;
                }
            }
            DescriptorProto[] descriptorProtoArr = this.messageType;
            if (descriptorProtoArr != null && descriptorProtoArr.length > 0) {
                int i3 = 0;
                while (true) {
                    DescriptorProto[] descriptorProtoArr2 = this.messageType;
                    if (i3 >= descriptorProtoArr2.length) {
                        break;
                    }
                    DescriptorProto descriptorProto = descriptorProtoArr2[i3];
                    if (descriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(4, descriptorProto);
                    }
                    i3++;
                }
            }
            EnumDescriptorProto[] enumDescriptorProtoArr = this.enumType;
            if (enumDescriptorProtoArr != null && enumDescriptorProtoArr.length > 0) {
                int i4 = 0;
                while (true) {
                    EnumDescriptorProto[] enumDescriptorProtoArr2 = this.enumType;
                    if (i4 >= enumDescriptorProtoArr2.length) {
                        break;
                    }
                    EnumDescriptorProto enumDescriptorProto = enumDescriptorProtoArr2[i4];
                    if (enumDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(5, enumDescriptorProto);
                    }
                    i4++;
                }
            }
            ServiceDescriptorProto[] serviceDescriptorProtoArr = this.service;
            if (serviceDescriptorProtoArr != null && serviceDescriptorProtoArr.length > 0) {
                int i5 = 0;
                while (true) {
                    ServiceDescriptorProto[] serviceDescriptorProtoArr2 = this.service;
                    if (i5 >= serviceDescriptorProtoArr2.length) {
                        break;
                    }
                    ServiceDescriptorProto serviceDescriptorProto = serviceDescriptorProtoArr2[i5];
                    if (serviceDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(6, serviceDescriptorProto);
                    }
                    i5++;
                }
            }
            FieldDescriptorProto[] fieldDescriptorProtoArr = this.extension;
            if (fieldDescriptorProtoArr != null && fieldDescriptorProtoArr.length > 0) {
                int i6 = 0;
                while (true) {
                    FieldDescriptorProto[] fieldDescriptorProtoArr2 = this.extension;
                    if (i6 >= fieldDescriptorProtoArr2.length) {
                        break;
                    }
                    FieldDescriptorProto fieldDescriptorProto = fieldDescriptorProtoArr2[i6];
                    if (fieldDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(7, fieldDescriptorProto);
                    }
                    i6++;
                }
            }
            FileOptions fileOptions = this.options;
            if (fileOptions != null) {
                codedOutputByteBufferNano.writeMessage(8, fileOptions);
            }
            SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo;
            if (sourceCodeInfo != null) {
                codedOutputByteBufferNano.writeMessage(9, sourceCodeInfo);
            }
            int[] iArr = this.publicDependency;
            if (iArr != null && iArr.length > 0) {
                int i7 = 0;
                while (true) {
                    int[] iArr2 = this.publicDependency;
                    if (i7 >= iArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeInt32(10, iArr2[i7]);
                    i7++;
                }
            }
            int[] iArr3 = this.weakDependency;
            if (iArr3 != null && iArr3.length > 0) {
                while (true) {
                    int[] iArr4 = this.weakDependency;
                    if (i >= iArr4.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeInt32(11, iArr4[i]);
                    i++;
                }
            }
            String str4 = this.syntax;
            if (str4 != null) {
                codedOutputByteBufferNano.writeString(12, str4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class FileDescriptorSet extends ExtendableMessageNano {
        private static volatile FileDescriptorSet[] _emptyArray;
        public FileDescriptorProto[] file = FileDescriptorProto.emptyArray();

        public FileDescriptorSet() {
            this.cachedSize = -1;
        }

        public static FileDescriptorSet[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FileDescriptorSet[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static FileDescriptorSet parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new FileDescriptorSet().mergeFrom(codedInputByteBufferNano);
        }

        public static FileDescriptorSet parseFrom(byte[] bArr) {
            return (FileDescriptorSet) MessageNano.mergeFrom(new FileDescriptorSet(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            FileDescriptorProto[] fileDescriptorProtoArr = this.file;
            if (fileDescriptorProtoArr != null && fileDescriptorProtoArr.length > 0) {
                int i = 0;
                while (true) {
                    FileDescriptorProto[] fileDescriptorProtoArr2 = this.file;
                    if (i >= fileDescriptorProtoArr2.length) {
                        break;
                    }
                    FileDescriptorProto fileDescriptorProto = fileDescriptorProtoArr2[i];
                    if (fileDescriptorProto != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fileDescriptorProto);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final FileDescriptorSet mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    FileDescriptorProto[] fileDescriptorProtoArr = this.file;
                    int length = fileDescriptorProtoArr == null ? 0 : fileDescriptorProtoArr.length;
                    int i = repeatedFieldArrayLength + length;
                    FileDescriptorProto[] fileDescriptorProtoArr2 = new FileDescriptorProto[i];
                    if (length != 0) {
                        System.arraycopy(this.file, 0, fileDescriptorProtoArr2, 0, length);
                    }
                    while (length < i - 1) {
                        fileDescriptorProtoArr2[length] = new FileDescriptorProto();
                        codedInputByteBufferNano.readMessage(fileDescriptorProtoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    fileDescriptorProtoArr2[length] = new FileDescriptorProto();
                    codedInputByteBufferNano.readMessage(fileDescriptorProtoArr2[length]);
                    this.file = fileDescriptorProtoArr2;
                } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            FileDescriptorProto[] fileDescriptorProtoArr = this.file;
            if (fileDescriptorProtoArr != null && fileDescriptorProtoArr.length > 0) {
                int i = 0;
                while (true) {
                    FileDescriptorProto[] fileDescriptorProtoArr2 = this.file;
                    if (i >= fileDescriptorProtoArr2.length) {
                        break;
                    }
                    FileDescriptorProto fileDescriptorProto = fileDescriptorProtoArr2[i];
                    if (fileDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(1, fileDescriptorProto);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class FileOptions extends ExtendableMessageNano {
        private static volatile FileOptions[] _emptyArray;
        public Integer ccApiVersion = null;
        public int ccApiCompatibility = Integer.MIN_VALUE;
        public Boolean ccProtoArrayCompatible = null;
        public Boolean ccUtf8Verification = null;
        public Boolean ccProto1TextFormat = null;
        public String javaPackage = null;
        public Integer pyApiVersion = null;
        public Integer javaApiVersion = null;
        public Boolean javaUseJavaproto2 = null;
        public Boolean javaJava5Enums = null;
        public Boolean javaGenerateRpcBaseimpl = null;
        public Boolean javaUseJavastrings = null;
        public String javaAltApiPackage = null;
        public Boolean javaEnableDualGenerateMutableApi = null;
        public String javaOuterClassname = null;
        public Boolean javaMultipleFiles = null;
        public Boolean javaGenerateEqualsAndHash = null;
        public Boolean javaStringCheckUtf8 = null;
        public Boolean javaMutableApi = null;
        public String javaMultipleFilesMutablePackage = null;
        public int optimizeFor = Integer.MIN_VALUE;
        public String goPackage = null;
        public String javascriptPackage = null;
        public Integer szlApiVersion = null;
        public Boolean ccGenericServices = null;
        public Boolean javaGenericServices = null;
        public Boolean pyGenericServices = null;
        public Boolean deprecated = null;
        public Boolean ccEnableArenas = null;
        public Boolean javaEnableMapsForProto2 = null;
        public Boolean ccDeprecatedMapsImplementation = null;
        public String objcClassPrefix = null;
        public String csharpNamespace = null;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        /* loaded from: classes.dex */
        public interface CompatibilityLevel {
            public static final int DEPRECATED_PROTO1_COMPATIBLE = 50;
            public static final int NO_COMPATIBILITY = 0;
            public static final int PROTO1_COMPATIBLE = 100;
        }

        /* loaded from: classes.dex */
        public interface OptimizeMode {
            public static final int CODE_SIZE = 2;
            public static final int LITE_RUNTIME = 3;
            public static final int SPEED = 1;
        }

        public FileOptions() {
            this.cachedSize = -1;
        }

        public static FileOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FileOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static FileOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new FileOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static FileOptions parseFrom(byte[] bArr) {
            return (FileOptions) MessageNano.mergeFrom(new FileOptions(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            String str = this.javaPackage;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            Integer num = this.ccApiVersion;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num.intValue());
            }
            Integer num2 = this.pyApiVersion;
            if (num2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num2.intValue());
            }
            Integer num3 = this.javaApiVersion;
            if (num3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, num3.intValue());
            }
            Boolean bool = this.javaUseJavaproto2;
            if (bool != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, bool.booleanValue());
            }
            Boolean bool2 = this.javaJava5Enums;
            if (bool2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, bool2.booleanValue());
            }
            String str2 = this.javaOuterClassname;
            if (str2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, str2);
            }
            int i = this.optimizeFor;
            if (i != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i);
            }
            Boolean bool3 = this.javaMultipleFiles;
            if (bool3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, bool3.booleanValue());
            }
            String str3 = this.goPackage;
            if (str3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, str3);
            }
            String str4 = this.javascriptPackage;
            if (str4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, str4);
            }
            Boolean bool4 = this.javaGenerateRpcBaseimpl;
            if (bool4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, bool4.booleanValue());
            }
            Integer num4 = this.szlApiVersion;
            if (num4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, num4.intValue());
            }
            int i2 = this.ccApiCompatibility;
            if (i2 != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, i2);
            }
            Boolean bool5 = this.ccGenericServices;
            if (bool5 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(16, bool5.booleanValue());
            }
            Boolean bool6 = this.javaGenericServices;
            if (bool6 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(17, bool6.booleanValue());
            }
            Boolean bool7 = this.pyGenericServices;
            if (bool7 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(18, bool7.booleanValue());
            }
            String str5 = this.javaAltApiPackage;
            if (str5 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, str5);
            }
            Boolean bool8 = this.javaGenerateEqualsAndHash;
            if (bool8 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(20, bool8.booleanValue());
            }
            Boolean bool9 = this.javaUseJavastrings;
            if (bool9 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(21, bool9.booleanValue());
            }
            Boolean bool10 = this.ccProtoArrayCompatible;
            if (bool10 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(22, bool10.booleanValue());
            }
            Boolean bool11 = this.deprecated;
            if (bool11 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(23, bool11.booleanValue());
            }
            Boolean bool12 = this.ccUtf8Verification;
            if (bool12 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(24, bool12.booleanValue());
            }
            Boolean bool13 = this.ccProto1TextFormat;
            if (bool13 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(25, bool13.booleanValue());
            }
            Boolean bool14 = this.javaEnableDualGenerateMutableApi;
            if (bool14 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(26, bool14.booleanValue());
            }
            Boolean bool15 = this.javaStringCheckUtf8;
            if (bool15 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(27, bool15.booleanValue());
            }
            Boolean bool16 = this.javaMutableApi;
            if (bool16 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(28, bool16.booleanValue());
            }
            String str6 = this.javaMultipleFilesMutablePackage;
            if (str6 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(29, str6);
            }
            Boolean bool17 = this.ccEnableArenas;
            if (bool17 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(31, bool17.booleanValue());
            }
            Boolean bool18 = this.javaEnableMapsForProto2;
            if (bool18 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(34, bool18.booleanValue());
            }
            Boolean bool19 = this.ccDeprecatedMapsImplementation;
            if (bool19 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(35, bool19.booleanValue());
            }
            String str7 = this.objcClassPrefix;
            if (str7 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(36, str7);
            }
            String str8 = this.csharpNamespace;
            if (str8 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(37, str8);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i3 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i3 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i3];
                    if (uninterpretedOption != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i3++;
                }
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final FileOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 10:
                        this.javaPackage = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        this.ccApiVersion = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        break;
                    case 32:
                        this.pyApiVersion = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        break;
                    case 40:
                        this.javaApiVersion = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        break;
                    case 48:
                        this.javaUseJavaproto2 = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 56:
                        this.javaJava5Enums = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 66:
                        this.javaOuterClassname = codedInputByteBufferNano.readString();
                        break;
                    case 72:
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                            break;
                        } else {
                            this.optimizeFor = readInt32;
                            break;
                        }
                    case 80:
                        this.javaMultipleFiles = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 90:
                        this.goPackage = codedInputByteBufferNano.readString();
                        break;
                    case 98:
                        this.javascriptPackage = codedInputByteBufferNano.readString();
                        break;
                    case 104:
                        this.javaGenerateRpcBaseimpl = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 112:
                        this.szlApiVersion = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        break;
                    case 120:
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 != 0 && readInt322 != 50 && readInt322 != 100) {
                            break;
                        } else {
                            this.ccApiCompatibility = readInt322;
                            break;
                        }
                    case Commons.MSG_MCSP_INIT_SUCCESS /* 128 */:
                        this.ccGenericServices = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 136:
                        this.javaGenericServices = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case Commons.CONTACT_REFRESH_AFTER_EDIT /* 144 */:
                        this.pyGenericServices = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 154:
                        this.javaAltApiPackage = codedInputByteBufferNano.readString();
                        break;
                    case 160:
                        this.javaGenerateEqualsAndHash = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 168:
                        this.javaUseJavastrings = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 176:
                        this.ccProtoArrayCompatible = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 184:
                        this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case PsExtractor.AUDIO_STREAM /* 192 */:
                        this.ccUtf8Verification = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case IMediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK /* 200 */:
                        this.ccProto1TextFormat = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 208:
                        this.javaEnableDualGenerateMutableApi = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case IRender.PROJECTION_MODE_BULLET_TIME_8 /* 216 */:
                        this.javaStringCheckUtf8 = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 224:
                        this.javaMutableApi = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 234:
                        this.javaMultipleFilesMutablePackage = codedInputByteBufferNano.readString();
                        break;
                    case 248:
                        this.ccEnableArenas = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 272:
                        this.javaEnableMapsForProto2 = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 280:
                        this.ccDeprecatedMapsImplementation = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 290:
                        this.objcClassPrefix = codedInputByteBufferNano.readString();
                        break;
                    case 298:
                        this.csharpNamespace = codedInputByteBufferNano.readString();
                        break;
                    case 7994:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                        int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                        int i = repeatedFieldArrayLength + length;
                        UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[i];
                        if (length != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                        }
                        while (length < i - 1) {
                            uninterpretedOptionArr2[length] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr2[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        this.uninterpretedOption = uninterpretedOptionArr2;
                        break;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            String str = this.javaPackage;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            Integer num = this.ccApiVersion;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(2, num.intValue());
            }
            Integer num2 = this.pyApiVersion;
            if (num2 != null) {
                codedOutputByteBufferNano.writeInt32(4, num2.intValue());
            }
            Integer num3 = this.javaApiVersion;
            if (num3 != null) {
                codedOutputByteBufferNano.writeInt32(5, num3.intValue());
            }
            Boolean bool = this.javaUseJavaproto2;
            if (bool != null) {
                codedOutputByteBufferNano.writeBool(6, bool.booleanValue());
            }
            Boolean bool2 = this.javaJava5Enums;
            if (bool2 != null) {
                codedOutputByteBufferNano.writeBool(7, bool2.booleanValue());
            }
            String str2 = this.javaOuterClassname;
            if (str2 != null) {
                codedOutputByteBufferNano.writeString(8, str2);
            }
            int i = this.optimizeFor;
            if (i != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(9, i);
            }
            Boolean bool3 = this.javaMultipleFiles;
            if (bool3 != null) {
                codedOutputByteBufferNano.writeBool(10, bool3.booleanValue());
            }
            String str3 = this.goPackage;
            if (str3 != null) {
                codedOutputByteBufferNano.writeString(11, str3);
            }
            String str4 = this.javascriptPackage;
            if (str4 != null) {
                codedOutputByteBufferNano.writeString(12, str4);
            }
            Boolean bool4 = this.javaGenerateRpcBaseimpl;
            if (bool4 != null) {
                codedOutputByteBufferNano.writeBool(13, bool4.booleanValue());
            }
            Integer num4 = this.szlApiVersion;
            if (num4 != null) {
                codedOutputByteBufferNano.writeInt32(14, num4.intValue());
            }
            int i2 = this.ccApiCompatibility;
            if (i2 != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(15, i2);
            }
            Boolean bool5 = this.ccGenericServices;
            if (bool5 != null) {
                codedOutputByteBufferNano.writeBool(16, bool5.booleanValue());
            }
            Boolean bool6 = this.javaGenericServices;
            if (bool6 != null) {
                codedOutputByteBufferNano.writeBool(17, bool6.booleanValue());
            }
            Boolean bool7 = this.pyGenericServices;
            if (bool7 != null) {
                codedOutputByteBufferNano.writeBool(18, bool7.booleanValue());
            }
            String str5 = this.javaAltApiPackage;
            if (str5 != null) {
                codedOutputByteBufferNano.writeString(19, str5);
            }
            Boolean bool8 = this.javaGenerateEqualsAndHash;
            if (bool8 != null) {
                codedOutputByteBufferNano.writeBool(20, bool8.booleanValue());
            }
            Boolean bool9 = this.javaUseJavastrings;
            if (bool9 != null) {
                codedOutputByteBufferNano.writeBool(21, bool9.booleanValue());
            }
            Boolean bool10 = this.ccProtoArrayCompatible;
            if (bool10 != null) {
                codedOutputByteBufferNano.writeBool(22, bool10.booleanValue());
            }
            Boolean bool11 = this.deprecated;
            if (bool11 != null) {
                codedOutputByteBufferNano.writeBool(23, bool11.booleanValue());
            }
            Boolean bool12 = this.ccUtf8Verification;
            if (bool12 != null) {
                codedOutputByteBufferNano.writeBool(24, bool12.booleanValue());
            }
            Boolean bool13 = this.ccProto1TextFormat;
            if (bool13 != null) {
                codedOutputByteBufferNano.writeBool(25, bool13.booleanValue());
            }
            Boolean bool14 = this.javaEnableDualGenerateMutableApi;
            if (bool14 != null) {
                codedOutputByteBufferNano.writeBool(26, bool14.booleanValue());
            }
            Boolean bool15 = this.javaStringCheckUtf8;
            if (bool15 != null) {
                codedOutputByteBufferNano.writeBool(27, bool15.booleanValue());
            }
            Boolean bool16 = this.javaMutableApi;
            if (bool16 != null) {
                codedOutputByteBufferNano.writeBool(28, bool16.booleanValue());
            }
            String str6 = this.javaMultipleFilesMutablePackage;
            if (str6 != null) {
                codedOutputByteBufferNano.writeString(29, str6);
            }
            Boolean bool17 = this.ccEnableArenas;
            if (bool17 != null) {
                codedOutputByteBufferNano.writeBool(31, bool17.booleanValue());
            }
            Boolean bool18 = this.javaEnableMapsForProto2;
            if (bool18 != null) {
                codedOutputByteBufferNano.writeBool(34, bool18.booleanValue());
            }
            Boolean bool19 = this.ccDeprecatedMapsImplementation;
            if (bool19 != null) {
                codedOutputByteBufferNano.writeBool(35, bool19.booleanValue());
            }
            String str7 = this.objcClassPrefix;
            if (str7 != null) {
                codedOutputByteBufferNano.writeString(36, str7);
            }
            String str8 = this.csharpNamespace;
            if (str8 != null) {
                codedOutputByteBufferNano.writeString(37, str8);
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i3 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i3 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i3];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i3++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class GeneratedCodeInfo extends ExtendableMessageNano {
        private static volatile GeneratedCodeInfo[] _emptyArray;
        public Annotation[] annotation = Annotation.emptyArray();

        /* loaded from: classes.dex */
        public final class Annotation extends ExtendableMessageNano {
            private static volatile Annotation[] _emptyArray;
            public int[] path = WireFormatNano.EMPTY_INT_ARRAY;
            public String sourceFile = null;
            public Integer begin = null;
            public Integer end = null;

            public Annotation() {
                this.cachedSize = -1;
            }

            public static Annotation[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Annotation[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static Annotation parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new Annotation().mergeFrom(codedInputByteBufferNano);
            }

            public static Annotation parseFrom(byte[] bArr) {
                return (Annotation) MessageNano.mergeFrom(new Annotation(), bArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                int[] iArr = this.path;
                if (iArr != null && iArr.length > 0) {
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        int[] iArr2 = this.path;
                        if (i >= iArr2.length) {
                            break;
                        }
                        i2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i]);
                        i++;
                    }
                    computeSerializedSize = computeSerializedSize + i2 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(i2);
                }
                String str = this.sourceFile;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, str);
                }
                Integer num = this.begin;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num.intValue());
                }
                Integer num2 = this.end;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, num2.intValue()) : computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final Annotation mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                        int[] iArr = this.path;
                        int length = iArr == null ? 0 : iArr.length;
                        int i = repeatedFieldArrayLength + length;
                        int[] iArr2 = new int[i];
                        if (length != 0) {
                            System.arraycopy(this.path, 0, iArr2, 0, length);
                        }
                        while (length < i - 1) {
                            iArr2[length] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        iArr2[length] = codedInputByteBufferNano.readInt32();
                        this.path = iArr2;
                    } else if (readTag == 10) {
                        int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position = codedInputByteBufferNano.getPosition();
                        int i2 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            i2++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr3 = this.path;
                        int length2 = iArr3 == null ? 0 : iArr3.length;
                        int i3 = i2 + length2;
                        int[] iArr4 = new int[i3];
                        if (length2 != 0) {
                            System.arraycopy(this.path, 0, iArr4, 0, length2);
                        }
                        while (length2 < i3) {
                            iArr4[length2] = codedInputByteBufferNano.readInt32();
                            length2++;
                        }
                        this.path = iArr4;
                        codedInputByteBufferNano.popLimit(pushLimit);
                    } else if (readTag == 18) {
                        this.sourceFile = codedInputByteBufferNano.readString();
                    } else if (readTag == 24) {
                        this.begin = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 32) {
                        this.end = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                int[] iArr = this.path;
                if (iArr != null && iArr.length > 0) {
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        int[] iArr2 = this.path;
                        if (i2 >= iArr2.length) {
                            break;
                        }
                        i3 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i2]);
                        i2++;
                    }
                    codedOutputByteBufferNano.writeRawVarint32(10);
                    codedOutputByteBufferNano.writeRawVarint32(i3);
                    while (true) {
                        int[] iArr3 = this.path;
                        if (i >= iArr3.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeInt32NoTag(iArr3[i]);
                        i++;
                    }
                }
                String str = this.sourceFile;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(2, str);
                }
                Integer num = this.begin;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(3, num.intValue());
                }
                Integer num2 = this.end;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(4, num2.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public GeneratedCodeInfo() {
            this.cachedSize = -1;
        }

        public static GeneratedCodeInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new GeneratedCodeInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static GeneratedCodeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new GeneratedCodeInfo().mergeFrom(codedInputByteBufferNano);
        }

        public static GeneratedCodeInfo parseFrom(byte[] bArr) {
            return (GeneratedCodeInfo) MessageNano.mergeFrom(new GeneratedCodeInfo(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Annotation[] annotationArr = this.annotation;
            if (annotationArr != null && annotationArr.length > 0) {
                int i = 0;
                while (true) {
                    Annotation[] annotationArr2 = this.annotation;
                    if (i >= annotationArr2.length) {
                        break;
                    }
                    Annotation annotation = annotationArr2[i];
                    if (annotation != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, annotation);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final GeneratedCodeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    Annotation[] annotationArr = this.annotation;
                    int length = annotationArr == null ? 0 : annotationArr.length;
                    int i = repeatedFieldArrayLength + length;
                    Annotation[] annotationArr2 = new Annotation[i];
                    if (length != 0) {
                        System.arraycopy(this.annotation, 0, annotationArr2, 0, length);
                    }
                    while (length < i - 1) {
                        annotationArr2[length] = new Annotation();
                        codedInputByteBufferNano.readMessage(annotationArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    annotationArr2[length] = new Annotation();
                    codedInputByteBufferNano.readMessage(annotationArr2[length]);
                    this.annotation = annotationArr2;
                } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            Annotation[] annotationArr = this.annotation;
            if (annotationArr != null && annotationArr.length > 0) {
                int i = 0;
                while (true) {
                    Annotation[] annotationArr2 = this.annotation;
                    if (i >= annotationArr2.length) {
                        break;
                    }
                    Annotation annotation = annotationArr2[i];
                    if (annotation != null) {
                        codedOutputByteBufferNano.writeMessage(1, annotation);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class MessageOptions extends ExtendableMessageNano {
        private static volatile MessageOptions[] _emptyArray;
        public Boolean deprecated;
        public String[] experimentalJavaBuilderInterface;
        public String[] experimentalJavaInterfaceExtends;
        public String[] experimentalJavaMessageInterface;
        public Boolean javaliteSerializable;
        public Boolean mapEntry;
        public Boolean messageSetWireFormat;
        public Boolean noStandardDescriptorAccessor;
        public UninterpretedOption[] uninterpretedOption;

        public MessageOptions() {
            String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
            this.experimentalJavaMessageInterface = strArr;
            this.experimentalJavaBuilderInterface = strArr;
            this.experimentalJavaInterfaceExtends = strArr;
            this.javaliteSerializable = null;
            this.messageSetWireFormat = null;
            this.noStandardDescriptorAccessor = null;
            this.deprecated = null;
            this.mapEntry = null;
            this.uninterpretedOption = UninterpretedOption.emptyArray();
            this.cachedSize = -1;
        }

        public static MessageOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MessageOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static MessageOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MessageOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static MessageOptions parseFrom(byte[] bArr) {
            return (MessageOptions) MessageNano.mergeFrom(new MessageOptions(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Boolean bool = this.messageSetWireFormat;
            if (bool != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, bool.booleanValue());
            }
            Boolean bool2 = this.noStandardDescriptorAccessor;
            if (bool2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, bool2.booleanValue());
            }
            Boolean bool3 = this.deprecated;
            if (bool3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, bool3.booleanValue());
            }
            String[] strArr = this.experimentalJavaMessageInterface;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    String[] strArr2 = this.experimentalJavaMessageInterface;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        i4++;
                        i3 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i2++;
                }
                computeSerializedSize = computeSerializedSize + i3 + (i4 * 1);
            }
            String[] strArr3 = this.experimentalJavaBuilderInterface;
            if (strArr3 != null && strArr3.length > 0) {
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    String[] strArr4 = this.experimentalJavaBuilderInterface;
                    if (i5 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i5];
                    if (str2 != null) {
                        i7++;
                        i6 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                    }
                    i5++;
                }
                computeSerializedSize = computeSerializedSize + i6 + (i7 * 1);
            }
            String[] strArr5 = this.experimentalJavaInterfaceExtends;
            if (strArr5 != null && strArr5.length > 0) {
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    String[] strArr6 = this.experimentalJavaInterfaceExtends;
                    if (i8 >= strArr6.length) {
                        break;
                    }
                    String str3 = strArr6[i8];
                    if (str3 != null) {
                        i10++;
                        i9 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                    }
                    i8++;
                }
                computeSerializedSize = computeSerializedSize + i9 + (i10 * 1);
            }
            Boolean bool4 = this.mapEntry;
            if (bool4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, bool4.booleanValue());
            }
            Boolean bool5 = this.javaliteSerializable;
            if (bool5 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, bool5.booleanValue());
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i];
                    if (uninterpretedOption != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MessageOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.messageSetWireFormat = Boolean.valueOf(codedInputByteBufferNano.readBool());
                } else if (readTag == 16) {
                    this.noStandardDescriptorAccessor = Boolean.valueOf(codedInputByteBufferNano.readBool());
                } else if (readTag == 24) {
                    this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                } else if (readTag == 34) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    String[] strArr = this.experimentalJavaMessageInterface;
                    int length = strArr == null ? 0 : strArr.length;
                    int i = repeatedFieldArrayLength + length;
                    String[] strArr2 = new String[i];
                    if (length != 0) {
                        System.arraycopy(this.experimentalJavaMessageInterface, 0, strArr2, 0, length);
                    }
                    while (length < i - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.experimentalJavaMessageInterface = strArr2;
                } else if (readTag == 42) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    String[] strArr3 = this.experimentalJavaBuilderInterface;
                    int length2 = strArr3 == null ? 0 : strArr3.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    String[] strArr4 = new String[i2];
                    if (length2 != 0) {
                        System.arraycopy(this.experimentalJavaBuilderInterface, 0, strArr4, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        strArr4[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr4[length2] = codedInputByteBufferNano.readString();
                    this.experimentalJavaBuilderInterface = strArr4;
                } else if (readTag == 50) {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    String[] strArr5 = this.experimentalJavaInterfaceExtends;
                    int length3 = strArr5 == null ? 0 : strArr5.length;
                    int i3 = repeatedFieldArrayLength3 + length3;
                    String[] strArr6 = new String[i3];
                    if (length3 != 0) {
                        System.arraycopy(this.experimentalJavaInterfaceExtends, 0, strArr6, 0, length3);
                    }
                    while (length3 < i3 - 1) {
                        strArr6[length3] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    strArr6[length3] = codedInputByteBufferNano.readString();
                    this.experimentalJavaInterfaceExtends = strArr6;
                } else if (readTag == 56) {
                    this.mapEntry = Boolean.valueOf(codedInputByteBufferNano.readBool());
                } else if (readTag == 64) {
                    this.javaliteSerializable = Boolean.valueOf(codedInputByteBufferNano.readBool());
                } else if (readTag == 7994) {
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length4 = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    int i4 = repeatedFieldArrayLength4 + length4;
                    UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[i4];
                    if (length4 != 0) {
                        System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length4);
                    }
                    while (length4 < i4 - 1) {
                        uninterpretedOptionArr2[length4] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    uninterpretedOptionArr2[length4] = new UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length4]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            Boolean bool = this.messageSetWireFormat;
            if (bool != null) {
                codedOutputByteBufferNano.writeBool(1, bool.booleanValue());
            }
            Boolean bool2 = this.noStandardDescriptorAccessor;
            if (bool2 != null) {
                codedOutputByteBufferNano.writeBool(2, bool2.booleanValue());
            }
            Boolean bool3 = this.deprecated;
            if (bool3 != null) {
                codedOutputByteBufferNano.writeBool(3, bool3.booleanValue());
            }
            String[] strArr = this.experimentalJavaMessageInterface;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.experimentalJavaMessageInterface;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(4, str);
                    }
                    i2++;
                }
            }
            String[] strArr3 = this.experimentalJavaBuilderInterface;
            if (strArr3 != null && strArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    String[] strArr4 = this.experimentalJavaBuilderInterface;
                    if (i3 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i3];
                    if (str2 != null) {
                        codedOutputByteBufferNano.writeString(5, str2);
                    }
                    i3++;
                }
            }
            String[] strArr5 = this.experimentalJavaInterfaceExtends;
            if (strArr5 != null && strArr5.length > 0) {
                int i4 = 0;
                while (true) {
                    String[] strArr6 = this.experimentalJavaInterfaceExtends;
                    if (i4 >= strArr6.length) {
                        break;
                    }
                    String str3 = strArr6[i4];
                    if (str3 != null) {
                        codedOutputByteBufferNano.writeString(6, str3);
                    }
                    i4++;
                }
            }
            Boolean bool4 = this.mapEntry;
            if (bool4 != null) {
                codedOutputByteBufferNano.writeBool(7, bool4.booleanValue());
            }
            Boolean bool5 = this.javaliteSerializable;
            if (bool5 != null) {
                codedOutputByteBufferNano.writeBool(8, bool5.booleanValue());
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class MethodDescriptorProto extends ExtendableMessageNano {
        private static volatile MethodDescriptorProto[] _emptyArray;
        public MethodOptions options;
        public String name = null;
        public String inputType = null;
        public String outputType = null;
        public Boolean clientStreaming = null;
        public Boolean serverStreaming = null;

        public MethodDescriptorProto() {
            this.cachedSize = -1;
        }

        public static MethodDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MethodDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static MethodDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MethodDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static MethodDescriptorProto parseFrom(byte[] bArr) {
            return (MethodDescriptorProto) MessageNano.mergeFrom(new MethodDescriptorProto(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            String str2 = this.inputType;
            if (str2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, str2);
            }
            String str3 = this.outputType;
            if (str3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, str3);
            }
            MethodOptions methodOptions = this.options;
            if (methodOptions != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, methodOptions);
            }
            Boolean bool = this.clientStreaming;
            if (bool != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, bool.booleanValue());
            }
            Boolean bool2 = this.serverStreaming;
            return bool2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(6, bool2.booleanValue()) : computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MethodDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (readTag == 18) {
                    this.inputType = codedInputByteBufferNano.readString();
                } else if (readTag == 26) {
                    this.outputType = codedInputByteBufferNano.readString();
                } else if (readTag == 34) {
                    if (this.options == null) {
                        this.options = new MethodOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                } else if (readTag == 40) {
                    this.clientStreaming = Boolean.valueOf(codedInputByteBufferNano.readBool());
                } else if (readTag == 48) {
                    this.serverStreaming = Boolean.valueOf(codedInputByteBufferNano.readBool());
                } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            String str = this.name;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            String str2 = this.inputType;
            if (str2 != null) {
                codedOutputByteBufferNano.writeString(2, str2);
            }
            String str3 = this.outputType;
            if (str3 != null) {
                codedOutputByteBufferNano.writeString(3, str3);
            }
            MethodOptions methodOptions = this.options;
            if (methodOptions != null) {
                codedOutputByteBufferNano.writeMessage(4, methodOptions);
            }
            Boolean bool = this.clientStreaming;
            if (bool != null) {
                codedOutputByteBufferNano.writeBool(5, bool.booleanValue());
            }
            Boolean bool2 = this.serverStreaming;
            if (bool2 != null) {
                codedOutputByteBufferNano.writeBool(6, bool2.booleanValue());
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class MethodOptions extends ExtendableMessageNano {
        private static volatile MethodOptions[] _emptyArray;
        public int protocol = Integer.MIN_VALUE;
        public Double deadline = null;
        public Boolean duplicateSuppression = null;
        public Boolean failFast = null;
        public Boolean endUserCredsRequested = null;
        public Integer clientLogging = null;
        public Integer serverLogging = null;
        public int securityLevel = Integer.MIN_VALUE;
        public int responseFormat = Integer.MIN_VALUE;
        public int requestFormat = Integer.MIN_VALUE;
        public String streamType = null;
        public String securityLabel = null;
        public Boolean clientStreaming = null;
        public Boolean serverStreaming = null;
        public String legacyStreamType = null;
        public String legacyResultType = null;
        public Long legacyClientInitialTokens = null;
        public Long legacyServerInitialTokens = null;
        public int legacyTokenUnit = Integer.MIN_VALUE;
        public int logLevel = Integer.MIN_VALUE;
        public Boolean deprecated = null;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        /* loaded from: classes.dex */
        public interface Format {
            public static final int UNCOMPRESSED = 0;
            public static final int ZIPPY_COMPRESSED = 1;
        }

        /* loaded from: classes.dex */
        public interface LogLevel {
            public static final int LOG_HEADER_AND_FILTERED_PAYLOAD = 3;
            public static final int LOG_HEADER_AND_NON_PRIVATE_PAYLOAD_INTERNAL = 2;
            public static final int LOG_HEADER_AND_PAYLOAD = 4;
            public static final int LOG_HEADER_ONLY = 1;
            public static final int LOG_NONE = 0;
        }

        /* loaded from: classes.dex */
        public interface Protocol {
            public static final int TCP = 0;
            public static final int UDP = 1;
        }

        /* loaded from: classes.dex */
        public interface SecurityLevel {
            public static final int INTEGRITY = 1;
            public static final int NONE = 0;
            public static final int PRIVACY_AND_INTEGRITY = 2;
            public static final int STRONG_PRIVACY_AND_INTEGRITY = 3;
        }

        /* loaded from: classes.dex */
        public interface TokenUnit {
            public static final int BYTE = 1;
            public static final int MESSAGE = 0;
        }

        public MethodOptions() {
            this.cachedSize = -1;
        }

        public static MethodOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MethodOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static MethodOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MethodOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static MethodOptions parseFrom(byte[] bArr) {
            return (MethodOptions) MessageNano.mergeFrom(new MethodOptions(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            int i = this.protocol;
            if (i != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i);
            }
            Double d2 = this.deadline;
            if (d2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(8, d2.doubleValue());
            }
            Boolean bool = this.duplicateSuppression;
            if (bool != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, bool.booleanValue());
            }
            Boolean bool2 = this.failFast;
            if (bool2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, bool2.booleanValue());
            }
            Integer num = this.clientLogging;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeSInt32Size(11, num.intValue());
            }
            Integer num2 = this.serverLogging;
            if (num2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeSInt32Size(12, num2.intValue());
            }
            int i2 = this.securityLevel;
            if (i2 != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, i2);
            }
            int i3 = this.responseFormat;
            if (i3 != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, i3);
            }
            int i4 = this.requestFormat;
            if (i4 != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(17, i4);
            }
            String str = this.streamType;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, str);
            }
            String str2 = this.securityLabel;
            if (str2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, str2);
            }
            Boolean bool3 = this.clientStreaming;
            if (bool3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(20, bool3.booleanValue());
            }
            Boolean bool4 = this.serverStreaming;
            if (bool4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(21, bool4.booleanValue());
            }
            String str3 = this.legacyStreamType;
            if (str3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(22, str3);
            }
            String str4 = this.legacyResultType;
            if (str4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(23, str4);
            }
            Long l = this.legacyClientInitialTokens;
            if (l != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(24, l.longValue());
            }
            Long l2 = this.legacyServerInitialTokens;
            if (l2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(25, l2.longValue());
            }
            Boolean bool5 = this.endUserCredsRequested;
            if (bool5 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(26, bool5.booleanValue());
            }
            int i5 = this.logLevel;
            if (i5 != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(27, i5);
            }
            int i6 = this.legacyTokenUnit;
            if (i6 != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(28, i6);
            }
            Boolean bool6 = this.deprecated;
            if (bool6 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(33, bool6.booleanValue());
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i7 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i7 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i7];
                    if (uninterpretedOption != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i7++;
                }
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MethodOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 56:
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1) {
                            break;
                        } else {
                            this.protocol = readInt32;
                            break;
                        }
                    case 65:
                        this.deadline = Double.valueOf(codedInputByteBufferNano.readDouble());
                        break;
                    case 72:
                        this.duplicateSuppression = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 80:
                        this.failFast = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 88:
                        this.clientLogging = Integer.valueOf(codedInputByteBufferNano.readSInt32());
                        break;
                    case 96:
                        this.serverLogging = Integer.valueOf(codedInputByteBufferNano.readSInt32());
                        break;
                    case 104:
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3) {
                            break;
                        } else {
                            this.securityLevel = readInt322;
                            break;
                        }
                    case 120:
                        int readInt323 = codedInputByteBufferNano.readInt32();
                        if (readInt323 != 0 && readInt323 != 1) {
                            break;
                        } else {
                            this.responseFormat = readInt323;
                            break;
                        }
                    case 136:
                        int readInt324 = codedInputByteBufferNano.readInt32();
                        if (readInt324 != 0 && readInt324 != 1) {
                            break;
                        } else {
                            this.requestFormat = readInt324;
                            break;
                        }
                    case 146:
                        this.streamType = codedInputByteBufferNano.readString();
                        break;
                    case 154:
                        this.securityLabel = codedInputByteBufferNano.readString();
                        break;
                    case 160:
                        this.clientStreaming = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 168:
                        this.serverStreaming = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 178:
                        this.legacyStreamType = codedInputByteBufferNano.readString();
                        break;
                    case 186:
                        this.legacyResultType = codedInputByteBufferNano.readString();
                        break;
                    case PsExtractor.AUDIO_STREAM /* 192 */:
                        this.legacyClientInitialTokens = Long.valueOf(codedInputByteBufferNano.readInt64());
                        break;
                    case IMediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK /* 200 */:
                        this.legacyServerInitialTokens = Long.valueOf(codedInputByteBufferNano.readInt64());
                        break;
                    case 208:
                        this.endUserCredsRequested = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case IRender.PROJECTION_MODE_BULLET_TIME_8 /* 216 */:
                        int readInt325 = codedInputByteBufferNano.readInt32();
                        if (readInt325 != 0 && readInt325 != 1 && readInt325 != 2 && readInt325 != 3 && readInt325 != 4) {
                            break;
                        } else {
                            this.logLevel = readInt325;
                            break;
                        }
                    case 224:
                        int readInt326 = codedInputByteBufferNano.readInt32();
                        if (readInt326 != 0 && readInt326 != 1) {
                            break;
                        } else {
                            this.legacyTokenUnit = readInt326;
                            break;
                        }
                    case 264:
                        this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 7994:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                        int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                        int i = repeatedFieldArrayLength + length;
                        UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[i];
                        if (length != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                        }
                        while (length < i - 1) {
                            uninterpretedOptionArr2[length] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr2[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        this.uninterpretedOption = uninterpretedOptionArr2;
                        break;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            int i = this.protocol;
            if (i != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(7, i);
            }
            Double d2 = this.deadline;
            if (d2 != null) {
                codedOutputByteBufferNano.writeDouble(8, d2.doubleValue());
            }
            Boolean bool = this.duplicateSuppression;
            if (bool != null) {
                codedOutputByteBufferNano.writeBool(9, bool.booleanValue());
            }
            Boolean bool2 = this.failFast;
            if (bool2 != null) {
                codedOutputByteBufferNano.writeBool(10, bool2.booleanValue());
            }
            Integer num = this.clientLogging;
            if (num != null) {
                codedOutputByteBufferNano.writeSInt32(11, num.intValue());
            }
            Integer num2 = this.serverLogging;
            if (num2 != null) {
                codedOutputByteBufferNano.writeSInt32(12, num2.intValue());
            }
            int i2 = this.securityLevel;
            if (i2 != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(13, i2);
            }
            int i3 = this.responseFormat;
            if (i3 != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(15, i3);
            }
            int i4 = this.requestFormat;
            if (i4 != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(17, i4);
            }
            String str = this.streamType;
            if (str != null) {
                codedOutputByteBufferNano.writeString(18, str);
            }
            String str2 = this.securityLabel;
            if (str2 != null) {
                codedOutputByteBufferNano.writeString(19, str2);
            }
            Boolean bool3 = this.clientStreaming;
            if (bool3 != null) {
                codedOutputByteBufferNano.writeBool(20, bool3.booleanValue());
            }
            Boolean bool4 = this.serverStreaming;
            if (bool4 != null) {
                codedOutputByteBufferNano.writeBool(21, bool4.booleanValue());
            }
            String str3 = this.legacyStreamType;
            if (str3 != null) {
                codedOutputByteBufferNano.writeString(22, str3);
            }
            String str4 = this.legacyResultType;
            if (str4 != null) {
                codedOutputByteBufferNano.writeString(23, str4);
            }
            Long l = this.legacyClientInitialTokens;
            if (l != null) {
                codedOutputByteBufferNano.writeInt64(24, l.longValue());
            }
            Long l2 = this.legacyServerInitialTokens;
            if (l2 != null) {
                codedOutputByteBufferNano.writeInt64(25, l2.longValue());
            }
            Boolean bool5 = this.endUserCredsRequested;
            if (bool5 != null) {
                codedOutputByteBufferNano.writeBool(26, bool5.booleanValue());
            }
            int i5 = this.logLevel;
            if (i5 != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(27, i5);
            }
            int i6 = this.legacyTokenUnit;
            if (i6 != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(28, i6);
            }
            Boolean bool6 = this.deprecated;
            if (bool6 != null) {
                codedOutputByteBufferNano.writeBool(33, bool6.booleanValue());
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i7 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i7 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i7];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i7++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class OneofDescriptorProto extends ExtendableMessageNano {
        private static volatile OneofDescriptorProto[] _emptyArray;
        public String name = null;
        public OneofOptions options;

        public OneofDescriptorProto() {
            this.cachedSize = -1;
        }

        public static OneofDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new OneofDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static OneofDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new OneofDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static OneofDescriptorProto parseFrom(byte[] bArr) {
            return (OneofDescriptorProto) MessageNano.mergeFrom(new OneofDescriptorProto(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            OneofOptions oneofOptions = this.options;
            return oneofOptions != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, oneofOptions) : computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final OneofDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (readTag == 18) {
                    if (this.options == null) {
                        this.options = new OneofOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            String str = this.name;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            OneofOptions oneofOptions = this.options;
            if (oneofOptions != null) {
                codedOutputByteBufferNano.writeMessage(2, oneofOptions);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class OneofOptions extends ExtendableMessageNano {
        private static volatile OneofOptions[] _emptyArray;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        public OneofOptions() {
            this.cachedSize = -1;
        }

        public static OneofOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new OneofOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static OneofOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new OneofOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static OneofOptions parseFrom(byte[] bArr) {
            return (OneofOptions) MessageNano.mergeFrom(new OneofOptions(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i];
                    if (uninterpretedOption != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final OneofOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 7994) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    int i = repeatedFieldArrayLength + length;
                    UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[i];
                    if (length != 0) {
                        System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                    }
                    while (length < i - 1) {
                        uninterpretedOptionArr2[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    uninterpretedOptionArr2[length] = new UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class ServiceDescriptorProto extends ExtendableMessageNano {
        private static volatile ServiceDescriptorProto[] _emptyArray;
        public ServiceOptions options;
        public String name = null;
        public MethodDescriptorProto[] method = MethodDescriptorProto.emptyArray();
        public StreamDescriptorProto[] stream = StreamDescriptorProto.emptyArray();

        public ServiceDescriptorProto() {
            this.cachedSize = -1;
        }

        public static ServiceDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ServiceDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static ServiceDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ServiceDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static ServiceDescriptorProto parseFrom(byte[] bArr) {
            return (ServiceDescriptorProto) MessageNano.mergeFrom(new ServiceDescriptorProto(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            MethodDescriptorProto[] methodDescriptorProtoArr = this.method;
            int i = 0;
            if (methodDescriptorProtoArr != null && methodDescriptorProtoArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MethodDescriptorProto[] methodDescriptorProtoArr2 = this.method;
                    if (i2 >= methodDescriptorProtoArr2.length) {
                        break;
                    }
                    MethodDescriptorProto methodDescriptorProto = methodDescriptorProtoArr2[i2];
                    if (methodDescriptorProto != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, methodDescriptorProto);
                    }
                    i2++;
                }
            }
            ServiceOptions serviceOptions = this.options;
            if (serviceOptions != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, serviceOptions);
            }
            StreamDescriptorProto[] streamDescriptorProtoArr = this.stream;
            if (streamDescriptorProtoArr != null && streamDescriptorProtoArr.length > 0) {
                while (true) {
                    StreamDescriptorProto[] streamDescriptorProtoArr2 = this.stream;
                    if (i >= streamDescriptorProtoArr2.length) {
                        break;
                    }
                    StreamDescriptorProto streamDescriptorProto = streamDescriptorProtoArr2[i];
                    if (streamDescriptorProto != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, streamDescriptorProto);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ServiceDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (readTag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    MethodDescriptorProto[] methodDescriptorProtoArr = this.method;
                    int length = methodDescriptorProtoArr == null ? 0 : methodDescriptorProtoArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MethodDescriptorProto[] methodDescriptorProtoArr2 = new MethodDescriptorProto[i];
                    if (length != 0) {
                        System.arraycopy(this.method, 0, methodDescriptorProtoArr2, 0, length);
                    }
                    while (length < i - 1) {
                        methodDescriptorProtoArr2[length] = new MethodDescriptorProto();
                        codedInputByteBufferNano.readMessage(methodDescriptorProtoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    methodDescriptorProtoArr2[length] = new MethodDescriptorProto();
                    codedInputByteBufferNano.readMessage(methodDescriptorProtoArr2[length]);
                    this.method = methodDescriptorProtoArr2;
                } else if (readTag == 26) {
                    if (this.options == null) {
                        this.options = new ServiceOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                } else if (readTag == 34) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    StreamDescriptorProto[] streamDescriptorProtoArr = this.stream;
                    int length2 = streamDescriptorProtoArr == null ? 0 : streamDescriptorProtoArr.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    StreamDescriptorProto[] streamDescriptorProtoArr2 = new StreamDescriptorProto[i2];
                    if (length2 != 0) {
                        System.arraycopy(this.stream, 0, streamDescriptorProtoArr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        streamDescriptorProtoArr2[length2] = new StreamDescriptorProto();
                        codedInputByteBufferNano.readMessage(streamDescriptorProtoArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    streamDescriptorProtoArr2[length2] = new StreamDescriptorProto();
                    codedInputByteBufferNano.readMessage(streamDescriptorProtoArr2[length2]);
                    this.stream = streamDescriptorProtoArr2;
                } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            String str = this.name;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            MethodDescriptorProto[] methodDescriptorProtoArr = this.method;
            int i = 0;
            if (methodDescriptorProtoArr != null && methodDescriptorProtoArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MethodDescriptorProto[] methodDescriptorProtoArr2 = this.method;
                    if (i2 >= methodDescriptorProtoArr2.length) {
                        break;
                    }
                    MethodDescriptorProto methodDescriptorProto = methodDescriptorProtoArr2[i2];
                    if (methodDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(2, methodDescriptorProto);
                    }
                    i2++;
                }
            }
            ServiceOptions serviceOptions = this.options;
            if (serviceOptions != null) {
                codedOutputByteBufferNano.writeMessage(3, serviceOptions);
            }
            StreamDescriptorProto[] streamDescriptorProtoArr = this.stream;
            if (streamDescriptorProtoArr != null && streamDescriptorProtoArr.length > 0) {
                while (true) {
                    StreamDescriptorProto[] streamDescriptorProtoArr2 = this.stream;
                    if (i >= streamDescriptorProtoArr2.length) {
                        break;
                    }
                    StreamDescriptorProto streamDescriptorProto = streamDescriptorProtoArr2[i];
                    if (streamDescriptorProto != null) {
                        codedOutputByteBufferNano.writeMessage(4, streamDescriptorProto);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class ServiceOptions extends ExtendableMessageNano {
        private static volatile ServiceOptions[] _emptyArray;
        public Boolean multicastStub = null;
        public Double failureDetectionDelay = null;
        public Boolean deprecated = null;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        public ServiceOptions() {
            this.cachedSize = -1;
        }

        public static ServiceOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ServiceOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static ServiceOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ServiceOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static ServiceOptions parseFrom(byte[] bArr) {
            return (ServiceOptions) MessageNano.mergeFrom(new ServiceOptions(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Double d2 = this.failureDetectionDelay;
            if (d2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(16, d2.doubleValue());
            }
            Boolean bool = this.multicastStub;
            if (bool != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(20, bool.booleanValue());
            }
            Boolean bool2 = this.deprecated;
            if (bool2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(33, bool2.booleanValue());
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i];
                    if (uninterpretedOption != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ServiceOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 129) {
                    this.failureDetectionDelay = Double.valueOf(codedInputByteBufferNano.readDouble());
                } else if (readTag == 160) {
                    this.multicastStub = Boolean.valueOf(codedInputByteBufferNano.readBool());
                } else if (readTag == 264) {
                    this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                } else if (readTag == 7994) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                    UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                    int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                    int i = repeatedFieldArrayLength + length;
                    UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[i];
                    if (length != 0) {
                        System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                    }
                    while (length < i - 1) {
                        uninterpretedOptionArr2[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    uninterpretedOptionArr2[length] = new UninterpretedOption();
                    codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                    this.uninterpretedOption = uninterpretedOptionArr2;
                } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            Double d2 = this.failureDetectionDelay;
            if (d2 != null) {
                codedOutputByteBufferNano.writeDouble(16, d2.doubleValue());
            }
            Boolean bool = this.multicastStub;
            if (bool != null) {
                codedOutputByteBufferNano.writeBool(20, bool.booleanValue());
            }
            Boolean bool2 = this.deprecated;
            if (bool2 != null) {
                codedOutputByteBufferNano.writeBool(33, bool2.booleanValue());
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class SourceCodeInfo extends ExtendableMessageNano {
        private static volatile SourceCodeInfo[] _emptyArray;
        public Location[] location = Location.emptyArray();

        /* loaded from: classes.dex */
        public final class Location extends ExtendableMessageNano {
            private static volatile Location[] _emptyArray;
            public String leadingComments;
            public String[] leadingDetachedComments;
            public int[] path;
            public int[] span;
            public String trailingComments;

            public Location() {
                int[] iArr = WireFormatNano.EMPTY_INT_ARRAY;
                this.path = iArr;
                this.span = iArr;
                this.leadingComments = null;
                this.trailingComments = null;
                this.leadingDetachedComments = WireFormatNano.EMPTY_STRING_ARRAY;
                this.cachedSize = -1;
            }

            public static Location[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Location[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static Location parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new Location().mergeFrom(codedInputByteBufferNano);
            }

            public static Location parseFrom(byte[] bArr) {
                return (Location) MessageNano.mergeFrom(new Location(), bArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                int[] iArr = this.path;
                int i = 0;
                if (iArr != null && iArr.length > 0) {
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        int[] iArr2 = this.path;
                        if (i2 >= iArr2.length) {
                            break;
                        }
                        i3 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i2]);
                        i2++;
                    }
                    computeSerializedSize = computeSerializedSize + i3 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(i3);
                }
                int[] iArr3 = this.span;
                if (iArr3 != null && iArr3.length > 0) {
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        int[] iArr4 = this.span;
                        if (i4 >= iArr4.length) {
                            break;
                        }
                        i5 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr4[i4]);
                        i4++;
                    }
                    computeSerializedSize = computeSerializedSize + i5 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(i5);
                }
                String str = this.leadingComments;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, str);
                }
                String str2 = this.trailingComments;
                if (str2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, str2);
                }
                String[] strArr = this.leadingDetachedComments;
                if (strArr == null || strArr.length <= 0) {
                    return computeSerializedSize;
                }
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    String[] strArr2 = this.leadingDetachedComments;
                    if (i >= strArr2.length) {
                        return computeSerializedSize + i6 + (i7 * 1);
                    }
                    String str3 = strArr2[i];
                    if (str3 != null) {
                        i7++;
                        i6 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                    }
                    i++;
                }
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final Location mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                int pushLimit;
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag != 8) {
                        if (readTag == 10) {
                            pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                            int position = codedInputByteBufferNano.getPosition();
                            int i = 0;
                            while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                codedInputByteBufferNano.readInt32();
                                i++;
                            }
                            codedInputByteBufferNano.rewindToPosition(position);
                            int[] iArr = this.path;
                            int length = iArr == null ? 0 : iArr.length;
                            int i2 = i + length;
                            int[] iArr2 = new int[i2];
                            if (length != 0) {
                                System.arraycopy(this.path, 0, iArr2, 0, length);
                            }
                            while (length < i2) {
                                iArr2[length] = codedInputByteBufferNano.readInt32();
                                length++;
                            }
                            this.path = iArr2;
                        } else if (readTag == 16) {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                            int[] iArr3 = this.span;
                            int length2 = iArr3 == null ? 0 : iArr3.length;
                            int i3 = repeatedFieldArrayLength + length2;
                            int[] iArr4 = new int[i3];
                            if (length2 != 0) {
                                System.arraycopy(this.span, 0, iArr4, 0, length2);
                            }
                            while (length2 < i3 - 1) {
                                iArr4[length2] = codedInputByteBufferNano.readInt32();
                                codedInputByteBufferNano.readTag();
                                length2++;
                            }
                            iArr4[length2] = codedInputByteBufferNano.readInt32();
                            this.span = iArr4;
                        } else if (readTag == 18) {
                            pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                            int position2 = codedInputByteBufferNano.getPosition();
                            int i4 = 0;
                            while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                codedInputByteBufferNano.readInt32();
                                i4++;
                            }
                            codedInputByteBufferNano.rewindToPosition(position2);
                            int[] iArr5 = this.span;
                            int length3 = iArr5 == null ? 0 : iArr5.length;
                            int i5 = i4 + length3;
                            int[] iArr6 = new int[i5];
                            if (length3 != 0) {
                                System.arraycopy(this.span, 0, iArr6, 0, length3);
                            }
                            while (length3 < i5) {
                                iArr6[length3] = codedInputByteBufferNano.readInt32();
                                length3++;
                            }
                            this.span = iArr6;
                        } else if (readTag == 26) {
                            this.leadingComments = codedInputByteBufferNano.readString();
                        } else if (readTag == 34) {
                            this.trailingComments = codedInputByteBufferNano.readString();
                        } else if (readTag == 50) {
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                            String[] strArr = this.leadingDetachedComments;
                            int length4 = strArr == null ? 0 : strArr.length;
                            int i6 = repeatedFieldArrayLength2 + length4;
                            String[] strArr2 = new String[i6];
                            if (length4 != 0) {
                                System.arraycopy(this.leadingDetachedComments, 0, strArr2, 0, length4);
                            }
                            while (length4 < i6 - 1) {
                                strArr2[length4] = codedInputByteBufferNano.readString();
                                codedInputByteBufferNano.readTag();
                                length4++;
                            }
                            strArr2[length4] = codedInputByteBufferNano.readString();
                            this.leadingDetachedComments = strArr2;
                        } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                        codedInputByteBufferNano.popLimit(pushLimit);
                    } else {
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                        int[] iArr7 = this.path;
                        int length5 = iArr7 == null ? 0 : iArr7.length;
                        int i7 = repeatedFieldArrayLength3 + length5;
                        int[] iArr8 = new int[i7];
                        if (length5 != 0) {
                            System.arraycopy(this.path, 0, iArr8, 0, length5);
                        }
                        while (length5 < i7 - 1) {
                            iArr8[length5] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        iArr8[length5] = codedInputByteBufferNano.readInt32();
                        this.path = iArr8;
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                int[] iArr = this.path;
                int i = 0;
                if (iArr != null && iArr.length > 0) {
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        int[] iArr2 = this.path;
                        if (i2 >= iArr2.length) {
                            break;
                        }
                        i3 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i2]);
                        i2++;
                    }
                    codedOutputByteBufferNano.writeRawVarint32(10);
                    codedOutputByteBufferNano.writeRawVarint32(i3);
                    int i4 = 0;
                    while (true) {
                        int[] iArr3 = this.path;
                        if (i4 >= iArr3.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeInt32NoTag(iArr3[i4]);
                        i4++;
                    }
                }
                int[] iArr4 = this.span;
                if (iArr4 != null && iArr4.length > 0) {
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        int[] iArr5 = this.span;
                        if (i5 >= iArr5.length) {
                            break;
                        }
                        i6 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr5[i5]);
                        i5++;
                    }
                    codedOutputByteBufferNano.writeRawVarint32(18);
                    codedOutputByteBufferNano.writeRawVarint32(i6);
                    int i7 = 0;
                    while (true) {
                        int[] iArr6 = this.span;
                        if (i7 >= iArr6.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeInt32NoTag(iArr6[i7]);
                        i7++;
                    }
                }
                String str = this.leadingComments;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                String str2 = this.trailingComments;
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(4, str2);
                }
                String[] strArr = this.leadingDetachedComments;
                if (strArr != null && strArr.length > 0) {
                    while (true) {
                        String[] strArr2 = this.leadingDetachedComments;
                        if (i >= strArr2.length) {
                            break;
                        }
                        String str3 = strArr2[i];
                        if (str3 != null) {
                            codedOutputByteBufferNano.writeString(6, str3);
                        }
                        i++;
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public SourceCodeInfo() {
            this.cachedSize = -1;
        }

        public static SourceCodeInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SourceCodeInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static SourceCodeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SourceCodeInfo().mergeFrom(codedInputByteBufferNano);
        }

        public static SourceCodeInfo parseFrom(byte[] bArr) {
            return (SourceCodeInfo) MessageNano.mergeFrom(new SourceCodeInfo(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Location[] locationArr = this.location;
            if (locationArr != null && locationArr.length > 0) {
                int i = 0;
                while (true) {
                    Location[] locationArr2 = this.location;
                    if (i >= locationArr2.length) {
                        break;
                    }
                    Location location = locationArr2[i];
                    if (location != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, location);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SourceCodeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    Location[] locationArr = this.location;
                    int length = locationArr == null ? 0 : locationArr.length;
                    int i = repeatedFieldArrayLength + length;
                    Location[] locationArr2 = new Location[i];
                    if (length != 0) {
                        System.arraycopy(this.location, 0, locationArr2, 0, length);
                    }
                    while (length < i - 1) {
                        locationArr2[length] = new Location();
                        codedInputByteBufferNano.readMessage(locationArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    locationArr2[length] = new Location();
                    codedInputByteBufferNano.readMessage(locationArr2[length]);
                    this.location = locationArr2;
                } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            Location[] locationArr = this.location;
            if (locationArr != null && locationArr.length > 0) {
                int i = 0;
                while (true) {
                    Location[] locationArr2 = this.location;
                    if (i >= locationArr2.length) {
                        break;
                    }
                    Location location = locationArr2[i];
                    if (location != null) {
                        codedOutputByteBufferNano.writeMessage(1, location);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class StreamDescriptorProto extends ExtendableMessageNano {
        private static volatile StreamDescriptorProto[] _emptyArray;
        public StreamOptions options;
        public String name = null;
        public String clientMessageType = null;
        public String serverMessageType = null;

        public StreamDescriptorProto() {
            this.cachedSize = -1;
        }

        public static StreamDescriptorProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new StreamDescriptorProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static StreamDescriptorProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new StreamDescriptorProto().mergeFrom(codedInputByteBufferNano);
        }

        public static StreamDescriptorProto parseFrom(byte[] bArr) {
            return (StreamDescriptorProto) MessageNano.mergeFrom(new StreamDescriptorProto(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            String str = this.name;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            String str2 = this.clientMessageType;
            if (str2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, str2);
            }
            String str3 = this.serverMessageType;
            if (str3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, str3);
            }
            StreamOptions streamOptions = this.options;
            return streamOptions != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, streamOptions) : computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final StreamDescriptorProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (readTag == 18) {
                    this.clientMessageType = codedInputByteBufferNano.readString();
                } else if (readTag == 26) {
                    this.serverMessageType = codedInputByteBufferNano.readString();
                } else if (readTag == 34) {
                    if (this.options == null) {
                        this.options = new StreamOptions();
                    }
                    codedInputByteBufferNano.readMessage(this.options);
                } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            String str = this.name;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            String str2 = this.clientMessageType;
            if (str2 != null) {
                codedOutputByteBufferNano.writeString(2, str2);
            }
            String str3 = this.serverMessageType;
            if (str3 != null) {
                codedOutputByteBufferNano.writeString(3, str3);
            }
            StreamOptions streamOptions = this.options;
            if (streamOptions != null) {
                codedOutputByteBufferNano.writeMessage(4, streamOptions);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class StreamOptions extends ExtendableMessageNano {
        private static volatile StreamOptions[] _emptyArray;
        public Long clientInitialTokens = null;
        public Long serverInitialTokens = null;
        public int tokenUnit = Integer.MIN_VALUE;
        public int securityLevel = Integer.MIN_VALUE;
        public String securityLabel = null;
        public Integer clientLogging = null;
        public Integer serverLogging = null;
        public Double deadline = null;
        public Boolean failFast = null;
        public Boolean endUserCredsRequested = null;
        public int logLevel = Integer.MIN_VALUE;
        public Boolean deprecated = null;
        public UninterpretedOption[] uninterpretedOption = UninterpretedOption.emptyArray();

        /* loaded from: classes.dex */
        public interface TokenUnit {
            public static final int BYTE = 1;
            public static final int MESSAGE = 0;
        }

        public StreamOptions() {
            this.cachedSize = -1;
        }

        public static StreamOptions[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new StreamOptions[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static StreamOptions parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new StreamOptions().mergeFrom(codedInputByteBufferNano);
        }

        public static StreamOptions parseFrom(byte[] bArr) {
            return (StreamOptions) MessageNano.mergeFrom(new StreamOptions(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Long l = this.clientInitialTokens;
            if (l != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, l.longValue());
            }
            Long l2 = this.serverInitialTokens;
            if (l2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, l2.longValue());
            }
            int i = this.tokenUnit;
            if (i != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
            }
            int i2 = this.securityLevel;
            if (i2 != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i2);
            }
            String str = this.securityLabel;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, str);
            }
            Integer num = this.clientLogging;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, num.intValue());
            }
            Integer num2 = this.serverLogging;
            if (num2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, num2.intValue());
            }
            Double d2 = this.deadline;
            if (d2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(8, d2.doubleValue());
            }
            Boolean bool = this.failFast;
            if (bool != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, bool.booleanValue());
            }
            Boolean bool2 = this.endUserCredsRequested;
            if (bool2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, bool2.booleanValue());
            }
            int i3 = this.logLevel;
            if (i3 != Integer.MIN_VALUE) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i3);
            }
            Boolean bool3 = this.deprecated;
            if (bool3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(33, bool3.booleanValue());
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i4 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i4 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i4];
                    if (uninterpretedOption != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(999, uninterpretedOption);
                    }
                    i4++;
                }
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final StreamOptions mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 8:
                        this.clientInitialTokens = Long.valueOf(codedInputByteBufferNano.readInt64());
                        break;
                    case 16:
                        this.serverInitialTokens = Long.valueOf(codedInputByteBufferNano.readInt64());
                        break;
                    case 24:
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1) {
                            break;
                        } else {
                            this.tokenUnit = readInt32;
                            break;
                        }
                    case 32:
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3) {
                            break;
                        } else {
                            this.securityLevel = readInt322;
                            break;
                        }
                    case 42:
                        this.securityLabel = codedInputByteBufferNano.readString();
                        break;
                    case 48:
                        this.clientLogging = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        break;
                    case 56:
                        this.serverLogging = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        break;
                    case 65:
                        this.deadline = Double.valueOf(codedInputByteBufferNano.readDouble());
                        break;
                    case 72:
                        this.failFast = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 80:
                        this.endUserCredsRequested = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 88:
                        int readInt323 = codedInputByteBufferNano.readInt32();
                        if (readInt323 != 0 && readInt323 != 1 && readInt323 != 2 && readInt323 != 3 && readInt323 != 4) {
                            break;
                        } else {
                            this.logLevel = readInt323;
                            break;
                        }
                    case 264:
                        this.deprecated = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 7994:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 7994);
                        UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
                        int length = uninterpretedOptionArr == null ? 0 : uninterpretedOptionArr.length;
                        int i = repeatedFieldArrayLength + length;
                        UninterpretedOption[] uninterpretedOptionArr2 = new UninterpretedOption[i];
                        if (length != 0) {
                            System.arraycopy(this.uninterpretedOption, 0, uninterpretedOptionArr2, 0, length);
                        }
                        while (length < i - 1) {
                            uninterpretedOptionArr2[length] = new UninterpretedOption();
                            codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        uninterpretedOptionArr2[length] = new UninterpretedOption();
                        codedInputByteBufferNano.readMessage(uninterpretedOptionArr2[length]);
                        this.uninterpretedOption = uninterpretedOptionArr2;
                        break;
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            Long l = this.clientInitialTokens;
            if (l != null) {
                codedOutputByteBufferNano.writeInt64(1, l.longValue());
            }
            Long l2 = this.serverInitialTokens;
            if (l2 != null) {
                codedOutputByteBufferNano.writeInt64(2, l2.longValue());
            }
            int i = this.tokenUnit;
            if (i != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(3, i);
            }
            int i2 = this.securityLevel;
            if (i2 != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(4, i2);
            }
            String str = this.securityLabel;
            if (str != null) {
                codedOutputByteBufferNano.writeString(5, str);
            }
            Integer num = this.clientLogging;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(6, num.intValue());
            }
            Integer num2 = this.serverLogging;
            if (num2 != null) {
                codedOutputByteBufferNano.writeInt32(7, num2.intValue());
            }
            Double d2 = this.deadline;
            if (d2 != null) {
                codedOutputByteBufferNano.writeDouble(8, d2.doubleValue());
            }
            Boolean bool = this.failFast;
            if (bool != null) {
                codedOutputByteBufferNano.writeBool(9, bool.booleanValue());
            }
            Boolean bool2 = this.endUserCredsRequested;
            if (bool2 != null) {
                codedOutputByteBufferNano.writeBool(10, bool2.booleanValue());
            }
            int i3 = this.logLevel;
            if (i3 != Integer.MIN_VALUE) {
                codedOutputByteBufferNano.writeInt32(11, i3);
            }
            Boolean bool3 = this.deprecated;
            if (bool3 != null) {
                codedOutputByteBufferNano.writeBool(33, bool3.booleanValue());
            }
            UninterpretedOption[] uninterpretedOptionArr = this.uninterpretedOption;
            if (uninterpretedOptionArr != null && uninterpretedOptionArr.length > 0) {
                int i4 = 0;
                while (true) {
                    UninterpretedOption[] uninterpretedOptionArr2 = this.uninterpretedOption;
                    if (i4 >= uninterpretedOptionArr2.length) {
                        break;
                    }
                    UninterpretedOption uninterpretedOption = uninterpretedOptionArr2[i4];
                    if (uninterpretedOption != null) {
                        codedOutputByteBufferNano.writeMessage(999, uninterpretedOption);
                    }
                    i4++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class UninterpretedOption extends ExtendableMessageNano {
        private static volatile UninterpretedOption[] _emptyArray;
        public NamePart[] name = NamePart.emptyArray();
        public String identifierValue = null;
        public Long positiveIntValue = null;
        public Long negativeIntValue = null;
        public Double doubleValue = null;
        public byte[] stringValue = null;
        public String aggregateValue = null;

        /* loaded from: classes.dex */
        public final class NamePart extends ExtendableMessageNano {
            private static volatile NamePart[] _emptyArray;
            public String namePart = null;
            public Boolean isExtension = null;

            public NamePart() {
                this.cachedSize = -1;
            }

            public static NamePart[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new NamePart[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static NamePart parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new NamePart().mergeFrom(codedInputByteBufferNano);
            }

            public static NamePart parseFrom(byte[] bArr) {
                return (NamePart) MessageNano.mergeFrom(new NamePart(), bArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                return super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.namePart) + CodedOutputByteBufferNano.computeBoolSize(2, this.isExtension.booleanValue());
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final NamePart mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.namePart = codedInputByteBufferNano.readString();
                    } else if (readTag == 16) {
                        this.isExtension = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                codedOutputByteBufferNano.writeString(1, this.namePart);
                codedOutputByteBufferNano.writeBool(2, this.isExtension.booleanValue());
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public UninterpretedOption() {
            this.cachedSize = -1;
        }

        public static UninterpretedOption[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new UninterpretedOption[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static UninterpretedOption parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new UninterpretedOption().mergeFrom(codedInputByteBufferNano);
        }

        public static UninterpretedOption parseFrom(byte[] bArr) {
            return (UninterpretedOption) MessageNano.mergeFrom(new UninterpretedOption(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            NamePart[] namePartArr = this.name;
            if (namePartArr != null && namePartArr.length > 0) {
                int i = 0;
                while (true) {
                    NamePart[] namePartArr2 = this.name;
                    if (i >= namePartArr2.length) {
                        break;
                    }
                    NamePart namePart = namePartArr2[i];
                    if (namePart != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, namePart);
                    }
                    i++;
                }
            }
            String str = this.identifierValue;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, str);
            }
            Long l = this.positiveIntValue;
            if (l != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, l.longValue());
            }
            Long l2 = this.negativeIntValue;
            if (l2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, l2.longValue());
            }
            Double d2 = this.doubleValue;
            if (d2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(6, d2.doubleValue());
            }
            byte[] bArr = this.stringValue;
            if (bArr != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(7, bArr);
            }
            String str2 = this.aggregateValue;
            return str2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, str2) : computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final UninterpretedOption mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    NamePart[] namePartArr = this.name;
                    int length = namePartArr == null ? 0 : namePartArr.length;
                    int i = repeatedFieldArrayLength + length;
                    NamePart[] namePartArr2 = new NamePart[i];
                    if (length != 0) {
                        System.arraycopy(this.name, 0, namePartArr2, 0, length);
                    }
                    while (length < i - 1) {
                        namePartArr2[length] = new NamePart();
                        codedInputByteBufferNano.readMessage(namePartArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    namePartArr2[length] = new NamePart();
                    codedInputByteBufferNano.readMessage(namePartArr2[length]);
                    this.name = namePartArr2;
                } else if (readTag == 26) {
                    this.identifierValue = codedInputByteBufferNano.readString();
                } else if (readTag == 32) {
                    this.positiveIntValue = Long.valueOf(codedInputByteBufferNano.readUInt64());
                } else if (readTag == 40) {
                    this.negativeIntValue = Long.valueOf(codedInputByteBufferNano.readInt64());
                } else if (readTag == 49) {
                    this.doubleValue = Double.valueOf(codedInputByteBufferNano.readDouble());
                } else if (readTag == 58) {
                    this.stringValue = codedInputByteBufferNano.readBytes();
                } else if (readTag == 66) {
                    this.aggregateValue = codedInputByteBufferNano.readString();
                } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            NamePart[] namePartArr = this.name;
            if (namePartArr != null && namePartArr.length > 0) {
                int i = 0;
                while (true) {
                    NamePart[] namePartArr2 = this.name;
                    if (i >= namePartArr2.length) {
                        break;
                    }
                    NamePart namePart = namePartArr2[i];
                    if (namePart != null) {
                        codedOutputByteBufferNano.writeMessage(2, namePart);
                    }
                    i++;
                }
            }
            String str = this.identifierValue;
            if (str != null) {
                codedOutputByteBufferNano.writeString(3, str);
            }
            Long l = this.positiveIntValue;
            if (l != null) {
                codedOutputByteBufferNano.writeUInt64(4, l.longValue());
            }
            Long l2 = this.negativeIntValue;
            if (l2 != null) {
                codedOutputByteBufferNano.writeInt64(5, l2.longValue());
            }
            Double d2 = this.doubleValue;
            if (d2 != null) {
                codedOutputByteBufferNano.writeDouble(6, d2.doubleValue());
            }
            byte[] bArr = this.stringValue;
            if (bArr != null) {
                codedOutputByteBufferNano.writeBytes(7, bArr);
            }
            String str2 = this.aggregateValue;
            if (str2 != null) {
                codedOutputByteBufferNano.writeString(8, str2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }
}
