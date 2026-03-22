package com.google.vrtoolkit.cardboard.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: classes.dex */
public interface Phone {

    /* loaded from: classes.dex */
    public final class PhoneParams extends MessageNano implements Cloneable {
        private static volatile PhoneParams[] _emptyArray;
        private int bitField0_;
        private float bottomBezelHeight_;
        public float[] dEPRECATEDGyroBias;
        private float xPpi_;
        private float yPpi_;

        public PhoneParams() {
            clear();
        }

        public static PhoneParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new PhoneParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static PhoneParams parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new PhoneParams().mergeFrom(codedInputByteBufferNano);
        }

        public static PhoneParams parseFrom(byte[] bArr) {
            return (PhoneParams) MessageNano.mergeFrom(new PhoneParams(), bArr);
        }

        public final PhoneParams clear() {
            this.bitField0_ = 0;
            this.xPpi_ = 0.0f;
            this.yPpi_ = 0.0f;
            this.bottomBezelHeight_ = 0.0f;
            this.dEPRECATEDGyroBias = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        public final PhoneParams clearBottomBezelHeight() {
            this.bottomBezelHeight_ = 0.0f;
            this.bitField0_ &= -5;
            return this;
        }

        public final PhoneParams clearXPpi() {
            this.xPpi_ = 0.0f;
            this.bitField0_ &= -2;
            return this;
        }

        public final PhoneParams clearYPpi() {
            this.yPpi_ = 0.0f;
            this.bitField0_ &= -3;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        /* renamed from: clone */
        public final PhoneParams mo6clone() {
            try {
                PhoneParams phoneParams = (PhoneParams) super.mo6clone();
                float[] fArr = this.dEPRECATEDGyroBias;
                if (fArr != null && fArr.length > 0) {
                    phoneParams.dEPRECATEDGyroBias = (float[]) fArr.clone();
                }
                return phoneParams;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.xPpi_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.yPpi_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.bottomBezelHeight_);
            }
            float[] fArr = this.dEPRECATEDGyroBias;
            if (fArr == null || fArr.length <= 0) {
                return computeSerializedSize;
            }
            int length = fArr.length * 4;
            return computeSerializedSize + length + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length);
        }

        public final float getBottomBezelHeight() {
            return this.bottomBezelHeight_;
        }

        public final float getXPpi() {
            return this.xPpi_;
        }

        public final float getYPpi() {
            return this.yPpi_;
        }

        public final boolean hasBottomBezelHeight() {
            return (this.bitField0_ & 4) != 0;
        }

        public final boolean hasXPpi() {
            return (this.bitField0_ & 1) != 0;
        }

        public final boolean hasYPpi() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final PhoneParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            int i;
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 13) {
                    this.xPpi_ = codedInputByteBufferNano.readFloat();
                    i = this.bitField0_ | 1;
                } else if (readTag == 21) {
                    this.yPpi_ = codedInputByteBufferNano.readFloat();
                    i = this.bitField0_ | 2;
                } else if (readTag == 29) {
                    this.bottomBezelHeight_ = codedInputByteBufferNano.readFloat();
                    i = this.bitField0_ | 4;
                } else if (readTag == 34) {
                    int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                    int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                    int i2 = readRawVarint32 / 4;
                    float[] fArr = this.dEPRECATEDGyroBias;
                    int length = fArr == null ? 0 : fArr.length;
                    int i3 = i2 + length;
                    float[] fArr2 = new float[i3];
                    if (length != 0) {
                        System.arraycopy(this.dEPRECATEDGyroBias, 0, fArr2, 0, length);
                    }
                    while (length < i3) {
                        fArr2[length] = codedInputByteBufferNano.readFloat();
                        length++;
                    }
                    this.dEPRECATEDGyroBias = fArr2;
                    codedInputByteBufferNano.popLimit(pushLimit);
                } else if (readTag == 37) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 37);
                    float[] fArr3 = this.dEPRECATEDGyroBias;
                    int length2 = fArr3 == null ? 0 : fArr3.length;
                    int i4 = repeatedFieldArrayLength + length2;
                    float[] fArr4 = new float[i4];
                    if (length2 != 0) {
                        System.arraycopy(this.dEPRECATEDGyroBias, 0, fArr4, 0, length2);
                    }
                    while (length2 < i4 - 1) {
                        fArr4[length2] = codedInputByteBufferNano.readFloat();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    fArr4[length2] = codedInputByteBufferNano.readFloat();
                    this.dEPRECATEDGyroBias = fArr4;
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
                this.bitField0_ = i;
            }
        }

        public final PhoneParams setBottomBezelHeight(float f) {
            this.bottomBezelHeight_ = f;
            this.bitField0_ |= 4;
            return this;
        }

        public final PhoneParams setXPpi(float f) {
            this.xPpi_ = f;
            this.bitField0_ |= 1;
            return this;
        }

        public final PhoneParams setYPpi(float f) {
            this.yPpi_ = f;
            this.bitField0_ |= 2;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeFloat(1, this.xPpi_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeFloat(2, this.yPpi_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeFloat(3, this.bottomBezelHeight_);
            }
            float[] fArr = this.dEPRECATEDGyroBias;
            if (fArr != null && fArr.length > 0) {
                int length = fArr.length * 4;
                codedOutputByteBufferNano.writeRawVarint32(34);
                codedOutputByteBufferNano.writeRawVarint32(length);
                int i = 0;
                while (true) {
                    float[] fArr2 = this.dEPRECATEDGyroBias;
                    if (i >= fArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloatNoTag(fArr2[i]);
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }
}
