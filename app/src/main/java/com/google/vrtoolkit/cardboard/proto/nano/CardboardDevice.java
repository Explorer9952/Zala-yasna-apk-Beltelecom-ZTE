package com.google.vrtoolkit.cardboard.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.zte.ucs.tvcall.Commons;

/* loaded from: classes.dex */
public interface CardboardDevice {

    /* loaded from: classes.dex */
    public final class CardboardInternalParams extends MessageNano implements Cloneable {
        private static volatile CardboardInternalParams[] _emptyArray;
        private String accelerometer_;
        private int bitField0_;
        public int[] eyeOrientations;
        private String gyroscope_;
        private float screenCenterToLensDistance_;
        private float xPpiOverride_;
        private float yPpiOverride_;

        /* loaded from: classes.dex */
        public interface OrientationType {
            public static final int CCW_0_DEGREES = 0;
            public static final int CCW_0_DEGREES_MIRRORED = 4;
            public static final int CCW_180_DEGREES = 2;
            public static final int CCW_180_DEGREES_MIRRORED = 6;
            public static final int CCW_270_DEGREES = 3;
            public static final int CCW_270_DEGREES_MIRRORED = 7;
            public static final int CCW_90_DEGREES = 1;
            public static final int CCW_90_DEGREES_MIRRORED = 5;
        }

        public CardboardInternalParams() {
            clear();
        }

        public static CardboardInternalParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CardboardInternalParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static CardboardInternalParams parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CardboardInternalParams().mergeFrom(codedInputByteBufferNano);
        }

        public static CardboardInternalParams parseFrom(byte[] bArr) {
            return (CardboardInternalParams) MessageNano.mergeFrom(new CardboardInternalParams(), bArr);
        }

        public final CardboardInternalParams clear() {
            this.bitField0_ = 0;
            this.eyeOrientations = WireFormatNano.EMPTY_INT_ARRAY;
            this.screenCenterToLensDistance_ = 0.0f;
            this.xPpiOverride_ = 0.0f;
            this.yPpiOverride_ = 0.0f;
            this.accelerometer_ = "";
            this.gyroscope_ = "";
            this.cachedSize = -1;
            return this;
        }

        public final CardboardInternalParams clearAccelerometer() {
            this.accelerometer_ = "";
            this.bitField0_ &= -9;
            return this;
        }

        public final CardboardInternalParams clearGyroscope() {
            this.gyroscope_ = "";
            this.bitField0_ &= -17;
            return this;
        }

        public final CardboardInternalParams clearScreenCenterToLensDistance() {
            this.screenCenterToLensDistance_ = 0.0f;
            this.bitField0_ &= -2;
            return this;
        }

        public final CardboardInternalParams clearXPpiOverride() {
            this.xPpiOverride_ = 0.0f;
            this.bitField0_ &= -3;
            return this;
        }

        public final CardboardInternalParams clearYPpiOverride() {
            this.yPpiOverride_ = 0.0f;
            this.bitField0_ &= -5;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        /* renamed from: clone */
        public final CardboardInternalParams mo6clone() {
            try {
                CardboardInternalParams cardboardInternalParams = (CardboardInternalParams) super.mo6clone();
                int[] iArr = this.eyeOrientations;
                if (iArr != null && iArr.length > 0) {
                    cardboardInternalParams.eyeOrientations = (int[]) iArr.clone();
                }
                return cardboardInternalParams;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            int[] iArr = this.eyeOrientations;
            if (iArr != null && iArr.length > 0) {
                int i = 0;
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.eyeOrientations;
                    if (i >= iArr2.length) {
                        break;
                    }
                    i2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i]);
                    i++;
                }
                computeSerializedSize = computeSerializedSize + i2 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(i2);
            }
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.screenCenterToLensDistance_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.xPpiOverride_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.yPpiOverride_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.accelerometer_);
            }
            return (this.bitField0_ & 16) != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.gyroscope_) : computeSerializedSize;
        }

        public final String getAccelerometer() {
            return this.accelerometer_;
        }

        public final String getGyroscope() {
            return this.gyroscope_;
        }

        public final float getScreenCenterToLensDistance() {
            return this.screenCenterToLensDistance_;
        }

        public final float getXPpiOverride() {
            return this.xPpiOverride_;
        }

        public final float getYPpiOverride() {
            return this.yPpiOverride_;
        }

        public final boolean hasAccelerometer() {
            return (this.bitField0_ & 8) != 0;
        }

        public final boolean hasGyroscope() {
            return (this.bitField0_ & 16) != 0;
        }

        public final boolean hasScreenCenterToLensDistance() {
            return (this.bitField0_ & 1) != 0;
        }

        public final boolean hasXPpiOverride() {
            return (this.bitField0_ & 2) != 0;
        }

        public final boolean hasYPpiOverride() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CardboardInternalParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            int i;
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                    int[] iArr = new int[repeatedFieldArrayLength];
                    int i2 = 0;
                    for (int i3 = 0; i3 < repeatedFieldArrayLength; i3++) {
                        if (i3 != 0) {
                            codedInputByteBufferNano.readTag();
                        }
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        switch (readInt32) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                iArr[i2] = readInt32;
                                i2++;
                                break;
                        }
                    }
                    if (i2 != 0) {
                        int[] iArr2 = this.eyeOrientations;
                        int length = iArr2 == null ? 0 : iArr2.length;
                        if (length == 0 && i2 == repeatedFieldArrayLength) {
                            this.eyeOrientations = iArr;
                        } else {
                            int[] iArr3 = new int[length + i2];
                            if (length != 0) {
                                System.arraycopy(this.eyeOrientations, 0, iArr3, 0, length);
                            }
                            System.arraycopy(iArr, 0, iArr3, length, i2);
                            this.eyeOrientations = iArr3;
                        }
                    }
                } else if (readTag != 10) {
                    if (readTag == 21) {
                        this.screenCenterToLensDistance_ = codedInputByteBufferNano.readFloat();
                        i = this.bitField0_ | 1;
                    } else if (readTag == 29) {
                        this.xPpiOverride_ = codedInputByteBufferNano.readFloat();
                        i = this.bitField0_ | 2;
                    } else if (readTag == 37) {
                        this.yPpiOverride_ = codedInputByteBufferNano.readFloat();
                        i = this.bitField0_ | 4;
                    } else if (readTag == 42) {
                        this.accelerometer_ = codedInputByteBufferNano.readString();
                        i = this.bitField0_ | 8;
                    } else if (readTag == 50) {
                        this.gyroscope_ = codedInputByteBufferNano.readString();
                        i = this.bitField0_ | 16;
                    } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    this.bitField0_ = i;
                } else {
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i4 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        switch (codedInputByteBufferNano.readInt32()) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                i4++;
                                break;
                        }
                    }
                    if (i4 != 0) {
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr4 = this.eyeOrientations;
                        int length2 = iArr4 == null ? 0 : iArr4.length;
                        int[] iArr5 = new int[i4 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.eyeOrientations, 0, iArr5, 0, length2);
                        }
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            switch (readInt322) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    iArr5[length2] = readInt322;
                                    length2++;
                                    break;
                            }
                        }
                        this.eyeOrientations = iArr5;
                    }
                    codedInputByteBufferNano.popLimit(pushLimit);
                }
            }
        }

        public final CardboardInternalParams setAccelerometer(String str) {
            if (str == null) {
                throw null;
            }
            this.accelerometer_ = str;
            this.bitField0_ |= 8;
            return this;
        }

        public final CardboardInternalParams setGyroscope(String str) {
            if (str == null) {
                throw null;
            }
            this.gyroscope_ = str;
            this.bitField0_ |= 16;
            return this;
        }

        public final CardboardInternalParams setScreenCenterToLensDistance(float f) {
            this.screenCenterToLensDistance_ = f;
            this.bitField0_ |= 1;
            return this;
        }

        public final CardboardInternalParams setXPpiOverride(float f) {
            this.xPpiOverride_ = f;
            this.bitField0_ |= 2;
            return this;
        }

        public final CardboardInternalParams setYPpiOverride(float f) {
            this.yPpiOverride_ = f;
            this.bitField0_ |= 4;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            int[] iArr = this.eyeOrientations;
            if (iArr != null && iArr.length > 0) {
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int[] iArr2 = this.eyeOrientations;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    i3 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i2]);
                    i2++;
                }
                codedOutputByteBufferNano.writeRawVarint32(10);
                codedOutputByteBufferNano.writeRawVarint32(i3);
                while (true) {
                    int[] iArr3 = this.eyeOrientations;
                    if (i >= iArr3.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeRawVarint32(iArr3[i]);
                    i++;
                }
            }
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeFloat(2, this.screenCenterToLensDistance_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeFloat(3, this.xPpiOverride_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeFloat(4, this.yPpiOverride_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputByteBufferNano.writeString(5, this.accelerometer_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputByteBufferNano.writeString(6, this.gyroscope_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* loaded from: classes.dex */
    public final class DeviceParams extends MessageNano implements Cloneable {
        private static volatile DeviceParams[] _emptyArray;
        private int bitField0_;
        public float[] distortionCoefficients;
        private boolean hasMagnet_;
        private float interLensDistance_;
        public CardboardInternalParams internal;
        public float[] leftEyeFieldOfViewAngles;
        private String model_;
        private int primaryButton_;
        private float screenToLensDistance_;
        private float trayToLensDistance_;
        private String vendor_;
        private int verticalAlignment_;

        /* loaded from: classes.dex */
        public interface ButtonType {
            public static final int INDIRECT_TOUCH = 3;
            public static final int MAGNET = 1;
            public static final int NONE = 0;
            public static final int TOUCH = 2;
        }

        /* loaded from: classes.dex */
        public interface VerticalAlignmentType {
            public static final int BOTTOM = 0;
            public static final int CENTER = 1;
            public static final int TOP = 2;
        }

        public DeviceParams() {
            clear();
        }

        public static DeviceParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DeviceParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static DeviceParams parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new DeviceParams().mergeFrom(codedInputByteBufferNano);
        }

        public static DeviceParams parseFrom(byte[] bArr) {
            return (DeviceParams) MessageNano.mergeFrom(new DeviceParams(), bArr);
        }

        public final DeviceParams clear() {
            this.bitField0_ = 0;
            this.vendor_ = "";
            this.model_ = "";
            this.screenToLensDistance_ = 0.0f;
            this.interLensDistance_ = 0.0f;
            float[] fArr = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.leftEyeFieldOfViewAngles = fArr;
            this.verticalAlignment_ = 0;
            this.trayToLensDistance_ = 0.0f;
            this.distortionCoefficients = fArr;
            this.hasMagnet_ = false;
            this.primaryButton_ = 1;
            this.internal = null;
            this.cachedSize = -1;
            return this;
        }

        public final DeviceParams clearHasMagnet() {
            this.hasMagnet_ = false;
            this.bitField0_ &= -65;
            return this;
        }

        public final DeviceParams clearInterLensDistance() {
            this.interLensDistance_ = 0.0f;
            this.bitField0_ &= -9;
            return this;
        }

        public final DeviceParams clearModel() {
            this.model_ = "";
            this.bitField0_ &= -3;
            return this;
        }

        public final DeviceParams clearPrimaryButton() {
            this.primaryButton_ = 1;
            this.bitField0_ &= -129;
            return this;
        }

        public final DeviceParams clearScreenToLensDistance() {
            this.screenToLensDistance_ = 0.0f;
            this.bitField0_ &= -5;
            return this;
        }

        public final DeviceParams clearTrayToLensDistance() {
            this.trayToLensDistance_ = 0.0f;
            this.bitField0_ &= -33;
            return this;
        }

        public final DeviceParams clearVendor() {
            this.vendor_ = "";
            this.bitField0_ &= -2;
            return this;
        }

        public final DeviceParams clearVerticalAlignment() {
            this.verticalAlignment_ = 0;
            this.bitField0_ &= -17;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        /* renamed from: clone */
        public final DeviceParams mo6clone() {
            try {
                DeviceParams deviceParams = (DeviceParams) super.mo6clone();
                float[] fArr = this.leftEyeFieldOfViewAngles;
                if (fArr != null && fArr.length > 0) {
                    deviceParams.leftEyeFieldOfViewAngles = (float[]) fArr.clone();
                }
                float[] fArr2 = this.distortionCoefficients;
                if (fArr2 != null && fArr2.length > 0) {
                    deviceParams.distortionCoefficients = (float[]) fArr2.clone();
                }
                CardboardInternalParams cardboardInternalParams = this.internal;
                if (cardboardInternalParams != null) {
                    deviceParams.internal = cardboardInternalParams.mo6clone();
                }
                return deviceParams;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.vendor_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.model_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.screenToLensDistance_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.interLensDistance_);
            }
            float[] fArr = this.leftEyeFieldOfViewAngles;
            if (fArr != null && fArr.length > 0) {
                int length = fArr.length * 4;
                computeSerializedSize = computeSerializedSize + length + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length);
            }
            if ((this.bitField0_ & 32) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(6, this.trayToLensDistance_);
            }
            float[] fArr2 = this.distortionCoefficients;
            if (fArr2 != null && fArr2.length > 0) {
                int length2 = fArr2.length * 4;
                computeSerializedSize = computeSerializedSize + length2 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length2);
            }
            if ((this.bitField0_ & 64) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, this.hasMagnet_);
            }
            if ((this.bitField0_ & 16) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, this.verticalAlignment_);
            }
            if ((this.bitField0_ & Commons.MSG_MCSP_INIT_SUCCESS) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, this.primaryButton_);
            }
            CardboardInternalParams cardboardInternalParams = this.internal;
            return cardboardInternalParams != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1729, cardboardInternalParams) : computeSerializedSize;
        }

        public final boolean getHasMagnet() {
            return this.hasMagnet_;
        }

        public final float getInterLensDistance() {
            return this.interLensDistance_;
        }

        public final String getModel() {
            return this.model_;
        }

        public final int getPrimaryButton() {
            return this.primaryButton_;
        }

        public final float getScreenToLensDistance() {
            return this.screenToLensDistance_;
        }

        public final float getTrayToLensDistance() {
            return this.trayToLensDistance_;
        }

        public final String getVendor() {
            return this.vendor_;
        }

        public final int getVerticalAlignment() {
            return this.verticalAlignment_;
        }

        public final boolean hasHasMagnet() {
            return (this.bitField0_ & 64) != 0;
        }

        public final boolean hasInterLensDistance() {
            return (this.bitField0_ & 8) != 0;
        }

        public final boolean hasModel() {
            return (this.bitField0_ & 2) != 0;
        }

        public final boolean hasPrimaryButton() {
            return (this.bitField0_ & Commons.MSG_MCSP_INIT_SUCCESS) != 0;
        }

        public final boolean hasScreenToLensDistance() {
            return (this.bitField0_ & 4) != 0;
        }

        public final boolean hasTrayToLensDistance() {
            return (this.bitField0_ & 32) != 0;
        }

        public final boolean hasVendor() {
            return (this.bitField0_ & 1) != 0;
        }

        public final boolean hasVerticalAlignment() {
            return (this.bitField0_ & 16) != 0;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
        @Override // com.google.protobuf.nano.MessageNano
        public final DeviceParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            int i;
            int pushLimit;
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 10:
                        this.vendor_ = codedInputByteBufferNano.readString();
                        i = this.bitField0_ | 1;
                        this.bitField0_ = i;
                    case 18:
                        this.model_ = codedInputByteBufferNano.readString();
                        i = this.bitField0_ | 2;
                        this.bitField0_ = i;
                    case 29:
                        this.screenToLensDistance_ = codedInputByteBufferNano.readFloat();
                        i = this.bitField0_ | 4;
                        this.bitField0_ = i;
                    case 37:
                        this.interLensDistance_ = codedInputByteBufferNano.readFloat();
                        i = this.bitField0_ | 8;
                        this.bitField0_ = i;
                    case 42:
                        int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                        pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                        int i2 = readRawVarint32 / 4;
                        float[] fArr = this.leftEyeFieldOfViewAngles;
                        int length = fArr == null ? 0 : fArr.length;
                        int i3 = i2 + length;
                        float[] fArr2 = new float[i3];
                        if (length != 0) {
                            System.arraycopy(this.leftEyeFieldOfViewAngles, 0, fArr2, 0, length);
                        }
                        while (length < i3) {
                            fArr2[length] = codedInputByteBufferNano.readFloat();
                            length++;
                        }
                        this.leftEyeFieldOfViewAngles = fArr2;
                        codedInputByteBufferNano.popLimit(pushLimit);
                    case 45:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 45);
                        float[] fArr3 = this.leftEyeFieldOfViewAngles;
                        int length2 = fArr3 == null ? 0 : fArr3.length;
                        int i4 = repeatedFieldArrayLength + length2;
                        float[] fArr4 = new float[i4];
                        if (length2 != 0) {
                            System.arraycopy(this.leftEyeFieldOfViewAngles, 0, fArr4, 0, length2);
                        }
                        while (length2 < i4 - 1) {
                            fArr4[length2] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        fArr4[length2] = codedInputByteBufferNano.readFloat();
                        this.leftEyeFieldOfViewAngles = fArr4;
                    case 53:
                        this.trayToLensDistance_ = codedInputByteBufferNano.readFloat();
                        i = this.bitField0_ | 32;
                        this.bitField0_ = i;
                    case 58:
                        int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                        pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint322);
                        int i5 = readRawVarint322 / 4;
                        float[] fArr5 = this.distortionCoefficients;
                        int length3 = fArr5 == null ? 0 : fArr5.length;
                        int i6 = i5 + length3;
                        float[] fArr6 = new float[i6];
                        if (length3 != 0) {
                            System.arraycopy(this.distortionCoefficients, 0, fArr6, 0, length3);
                        }
                        while (length3 < i6) {
                            fArr6[length3] = codedInputByteBufferNano.readFloat();
                            length3++;
                        }
                        this.distortionCoefficients = fArr6;
                        codedInputByteBufferNano.popLimit(pushLimit);
                    case 61:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 61);
                        float[] fArr7 = this.distortionCoefficients;
                        int length4 = fArr7 == null ? 0 : fArr7.length;
                        int i7 = repeatedFieldArrayLength2 + length4;
                        float[] fArr8 = new float[i7];
                        if (length4 != 0) {
                            System.arraycopy(this.distortionCoefficients, 0, fArr8, 0, length4);
                        }
                        while (length4 < i7 - 1) {
                            fArr8[length4] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        fArr8[length4] = codedInputByteBufferNano.readFloat();
                        this.distortionCoefficients = fArr8;
                    case 80:
                        this.hasMagnet_ = codedInputByteBufferNano.readBool();
                        i = this.bitField0_ | 64;
                        this.bitField0_ = i;
                    case 88:
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                            this.verticalAlignment_ = readInt32;
                            i = this.bitField0_ | 16;
                            this.bitField0_ = i;
                        }
                        break;
                    case 96:
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 3) {
                            this.primaryButton_ = readInt322;
                            i = this.bitField0_ | Commons.MSG_MCSP_INIT_SUCCESS;
                            this.bitField0_ = i;
                        }
                        break;
                    case 13834:
                        if (this.internal == null) {
                            this.internal = new CardboardInternalParams();
                        }
                        codedInputByteBufferNano.readMessage(this.internal);
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                }
            }
        }

        public final DeviceParams setHasMagnet(boolean z) {
            this.hasMagnet_ = z;
            this.bitField0_ |= 64;
            return this;
        }

        public final DeviceParams setInterLensDistance(float f) {
            this.interLensDistance_ = f;
            this.bitField0_ |= 8;
            return this;
        }

        public final DeviceParams setModel(String str) {
            if (str == null) {
                throw null;
            }
            this.model_ = str;
            this.bitField0_ |= 2;
            return this;
        }

        public final DeviceParams setPrimaryButton(int i) {
            this.primaryButton_ = i;
            this.bitField0_ |= Commons.MSG_MCSP_INIT_SUCCESS;
            return this;
        }

        public final DeviceParams setScreenToLensDistance(float f) {
            this.screenToLensDistance_ = f;
            this.bitField0_ |= 4;
            return this;
        }

        public final DeviceParams setTrayToLensDistance(float f) {
            this.trayToLensDistance_ = f;
            this.bitField0_ |= 32;
            return this;
        }

        public final DeviceParams setVendor(String str) {
            if (str == null) {
                throw null;
            }
            this.vendor_ = str;
            this.bitField0_ |= 1;
            return this;
        }

        public final DeviceParams setVerticalAlignment(int i) {
            this.verticalAlignment_ = i;
            this.bitField0_ |= 16;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeString(1, this.vendor_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeString(2, this.model_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeFloat(3, this.screenToLensDistance_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputByteBufferNano.writeFloat(4, this.interLensDistance_);
            }
            float[] fArr = this.leftEyeFieldOfViewAngles;
            int i = 0;
            if (fArr != null && fArr.length > 0) {
                int length = fArr.length * 4;
                codedOutputByteBufferNano.writeRawVarint32(42);
                codedOutputByteBufferNano.writeRawVarint32(length);
                int i2 = 0;
                while (true) {
                    float[] fArr2 = this.leftEyeFieldOfViewAngles;
                    if (i2 >= fArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloatNoTag(fArr2[i2]);
                    i2++;
                }
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputByteBufferNano.writeFloat(6, this.trayToLensDistance_);
            }
            float[] fArr3 = this.distortionCoefficients;
            if (fArr3 != null && fArr3.length > 0) {
                int length2 = fArr3.length * 4;
                codedOutputByteBufferNano.writeRawVarint32(58);
                codedOutputByteBufferNano.writeRawVarint32(length2);
                while (true) {
                    float[] fArr4 = this.distortionCoefficients;
                    if (i >= fArr4.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloatNoTag(fArr4[i]);
                    i++;
                }
            }
            if ((this.bitField0_ & 64) != 0) {
                codedOutputByteBufferNano.writeBool(10, this.hasMagnet_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputByteBufferNano.writeInt32(11, this.verticalAlignment_);
            }
            if ((this.bitField0_ & Commons.MSG_MCSP_INIT_SUCCESS) != 0) {
                codedOutputByteBufferNano.writeInt32(12, this.primaryButton_);
            }
            CardboardInternalParams cardboardInternalParams = this.internal;
            if (cardboardInternalParams != null) {
                codedOutputByteBufferNano.writeMessage(1729, cardboardInternalParams);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }
}
