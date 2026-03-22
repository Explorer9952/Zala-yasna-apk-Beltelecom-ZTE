package com.google.vr.ndk.base.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: classes.dex */
public interface GvrApiData {

    /* loaded from: classes.dex */
    public final class RenderTextureParamsListData extends MessageNano {
        private static volatile RenderTextureParamsListData[] _emptyArray;
        public RenderTextureParamsData[] paramsData;

        /* loaded from: classes.dex */
        public final class RenderTextureParamsData extends MessageNano {
            private static volatile RenderTextureParamsData[] _emptyArray;
            private int bitField0_;
            public float[] eyeFov;
            private int eyeType_;
            public float[] eyeViewportBounds;
            private long nativePtr_;

            public RenderTextureParamsData() {
                clear();
            }

            public static RenderTextureParamsData[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new RenderTextureParamsData[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static RenderTextureParamsData parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new RenderTextureParamsData().mergeFrom(codedInputByteBufferNano);
            }

            public static RenderTextureParamsData parseFrom(byte[] bArr) {
                return (RenderTextureParamsData) MessageNano.mergeFrom(new RenderTextureParamsData(), bArr);
            }

            public final RenderTextureParamsData clear() {
                this.bitField0_ = 0;
                this.nativePtr_ = 0L;
                float[] fArr = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.eyeViewportBounds = fArr;
                this.eyeFov = fArr;
                this.eyeType_ = 0;
                this.cachedSize = -1;
                return this;
            }

            public final RenderTextureParamsData clearEyeType() {
                this.eyeType_ = 0;
                this.bitField0_ &= -3;
                return this;
            }

            public final RenderTextureParamsData clearNativePtr() {
                this.nativePtr_ = 0L;
                this.bitField0_ &= -2;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                if ((this.bitField0_ & 1) != 0) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, this.nativePtr_);
                }
                float[] fArr = this.eyeViewportBounds;
                if (fArr != null && fArr.length > 0) {
                    int length = fArr.length * 4;
                    computeSerializedSize = computeSerializedSize + length + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length);
                }
                float[] fArr2 = this.eyeFov;
                if (fArr2 != null && fArr2.length > 0) {
                    int length2 = fArr2.length * 4;
                    computeSerializedSize = computeSerializedSize + length2 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length2);
                }
                return (this.bitField0_ & 2) != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, this.eyeType_) : computeSerializedSize;
            }

            public final int getEyeType() {
                return this.eyeType_;
            }

            public final long getNativePtr() {
                return this.nativePtr_;
            }

            public final boolean hasEyeType() {
                return (this.bitField0_ & 2) != 0;
            }

            public final boolean hasNativePtr() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final RenderTextureParamsData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                int i;
                int pushLimit;
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag != 8) {
                        if (readTag == 18) {
                            int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                            pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                            int i2 = readRawVarint32 / 4;
                            float[] fArr = this.eyeViewportBounds;
                            int length = fArr == null ? 0 : fArr.length;
                            int i3 = i2 + length;
                            float[] fArr2 = new float[i3];
                            if (length != 0) {
                                System.arraycopy(this.eyeViewportBounds, 0, fArr2, 0, length);
                            }
                            while (length < i3) {
                                fArr2[length] = codedInputByteBufferNano.readFloat();
                                length++;
                            }
                            this.eyeViewportBounds = fArr2;
                        } else if (readTag == 21) {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 21);
                            float[] fArr3 = this.eyeViewportBounds;
                            int length2 = fArr3 == null ? 0 : fArr3.length;
                            int i4 = repeatedFieldArrayLength + length2;
                            float[] fArr4 = new float[i4];
                            if (length2 != 0) {
                                System.arraycopy(this.eyeViewportBounds, 0, fArr4, 0, length2);
                            }
                            while (length2 < i4 - 1) {
                                fArr4[length2] = codedInputByteBufferNano.readFloat();
                                codedInputByteBufferNano.readTag();
                                length2++;
                            }
                            fArr4[length2] = codedInputByteBufferNano.readFloat();
                            this.eyeViewportBounds = fArr4;
                        } else if (readTag == 26) {
                            int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                            pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint322);
                            int i5 = readRawVarint322 / 4;
                            float[] fArr5 = this.eyeFov;
                            int length3 = fArr5 == null ? 0 : fArr5.length;
                            int i6 = i5 + length3;
                            float[] fArr6 = new float[i6];
                            if (length3 != 0) {
                                System.arraycopy(this.eyeFov, 0, fArr6, 0, length3);
                            }
                            while (length3 < i6) {
                                fArr6[length3] = codedInputByteBufferNano.readFloat();
                                length3++;
                            }
                            this.eyeFov = fArr6;
                        } else if (readTag == 29) {
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 29);
                            float[] fArr7 = this.eyeFov;
                            int length4 = fArr7 == null ? 0 : fArr7.length;
                            int i7 = repeatedFieldArrayLength2 + length4;
                            float[] fArr8 = new float[i7];
                            if (length4 != 0) {
                                System.arraycopy(this.eyeFov, 0, fArr8, 0, length4);
                            }
                            while (length4 < i7 - 1) {
                                fArr8[length4] = codedInputByteBufferNano.readFloat();
                                codedInputByteBufferNano.readTag();
                                length4++;
                            }
                            fArr8[length4] = codedInputByteBufferNano.readFloat();
                            this.eyeFov = fArr8;
                        } else if (readTag == 32) {
                            this.eyeType_ = codedInputByteBufferNano.readInt32();
                            i = this.bitField0_ | 2;
                        } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                        codedInputByteBufferNano.popLimit(pushLimit);
                    } else {
                        this.nativePtr_ = codedInputByteBufferNano.readUInt64();
                        i = this.bitField0_ | 1;
                    }
                    this.bitField0_ = i;
                }
            }

            public final RenderTextureParamsData setEyeType(int i) {
                this.eyeType_ = i;
                this.bitField0_ |= 2;
                return this;
            }

            public final RenderTextureParamsData setNativePtr(long j) {
                this.nativePtr_ = j;
                this.bitField0_ |= 1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                if ((this.bitField0_ & 1) != 0) {
                    codedOutputByteBufferNano.writeUInt64(1, this.nativePtr_);
                }
                float[] fArr = this.eyeViewportBounds;
                int i = 0;
                if (fArr != null && fArr.length > 0) {
                    int length = fArr.length * 4;
                    codedOutputByteBufferNano.writeRawVarint32(18);
                    codedOutputByteBufferNano.writeRawVarint32(length);
                    int i2 = 0;
                    while (true) {
                        float[] fArr2 = this.eyeViewportBounds;
                        if (i2 >= fArr2.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeFloatNoTag(fArr2[i2]);
                        i2++;
                    }
                }
                float[] fArr3 = this.eyeFov;
                if (fArr3 != null && fArr3.length > 0) {
                    int length2 = fArr3.length * 4;
                    codedOutputByteBufferNano.writeRawVarint32(26);
                    codedOutputByteBufferNano.writeRawVarint32(length2);
                    while (true) {
                        float[] fArr4 = this.eyeFov;
                        if (i >= fArr4.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeFloatNoTag(fArr4[i]);
                        i++;
                    }
                }
                if ((this.bitField0_ & 2) != 0) {
                    codedOutputByteBufferNano.writeInt32(4, this.eyeType_);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public RenderTextureParamsListData() {
            clear();
        }

        public static RenderTextureParamsListData[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RenderTextureParamsListData[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static RenderTextureParamsListData parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RenderTextureParamsListData().mergeFrom(codedInputByteBufferNano);
        }

        public static RenderTextureParamsListData parseFrom(byte[] bArr) {
            return (RenderTextureParamsListData) MessageNano.mergeFrom(new RenderTextureParamsListData(), bArr);
        }

        public final RenderTextureParamsListData clear() {
            this.paramsData = RenderTextureParamsData.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            RenderTextureParamsData[] renderTextureParamsDataArr = this.paramsData;
            if (renderTextureParamsDataArr != null && renderTextureParamsDataArr.length > 0) {
                int i = 0;
                while (true) {
                    RenderTextureParamsData[] renderTextureParamsDataArr2 = this.paramsData;
                    if (i >= renderTextureParamsDataArr2.length) {
                        break;
                    }
                    RenderTextureParamsData renderTextureParamsData = renderTextureParamsDataArr2[i];
                    if (renderTextureParamsData != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, renderTextureParamsData);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RenderTextureParamsListData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    RenderTextureParamsData[] renderTextureParamsDataArr = this.paramsData;
                    int length = renderTextureParamsDataArr == null ? 0 : renderTextureParamsDataArr.length;
                    int i = repeatedFieldArrayLength + length;
                    RenderTextureParamsData[] renderTextureParamsDataArr2 = new RenderTextureParamsData[i];
                    if (length != 0) {
                        System.arraycopy(this.paramsData, 0, renderTextureParamsDataArr2, 0, length);
                    }
                    while (length < i - 1) {
                        renderTextureParamsDataArr2[length] = new RenderTextureParamsData();
                        codedInputByteBufferNano.readMessage(renderTextureParamsDataArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    renderTextureParamsDataArr2[length] = new RenderTextureParamsData();
                    codedInputByteBufferNano.readMessage(renderTextureParamsDataArr2[length]);
                    this.paramsData = renderTextureParamsDataArr2;
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            RenderTextureParamsData[] renderTextureParamsDataArr = this.paramsData;
            if (renderTextureParamsDataArr != null && renderTextureParamsDataArr.length > 0) {
                int i = 0;
                while (true) {
                    RenderTextureParamsData[] renderTextureParamsDataArr2 = this.paramsData;
                    if (i >= renderTextureParamsDataArr2.length) {
                        break;
                    }
                    RenderTextureParamsData renderTextureParamsData = renderTextureParamsDataArr2[i];
                    if (renderTextureParamsData != null) {
                        codedOutputByteBufferNano.writeMessage(1, renderTextureParamsData);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }
}
