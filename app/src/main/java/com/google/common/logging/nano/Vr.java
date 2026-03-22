package com.google.common.logging.nano;

import android.os.Parcelable;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.google.protobuf.nano.android.ParcelableExtendableMessageNano;
import com.google.protobuf.nano.android.ParcelableMessageNanoCreator;

/* loaded from: classes.dex */
public interface Vr {

    /* loaded from: classes.dex */
    public final class VREvent extends ParcelableExtendableMessageNano {
        public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(VREvent.class);
        private static volatile VREvent[] _emptyArray;
        public Application application;
        public AudioStats audioStats;
        public String cohort;
        public Cyclops cyclops;
        public Long durationMs;
        public EmbedVrWidget embedVrWidget;
        public HeadMount headMount;
        public Application[] installedVrApplications;
        public Integer lifetimeCountBucket;
        public PerformanceStats performanceStats;
        public QrCodeScan qrCodeScan;
        public SensorStats sensorStats;
        public VrCore vrCore;

        /* loaded from: classes.dex */
        public final class Application extends ParcelableExtendableMessageNano {
            public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(Application.class);
            private static volatile Application[] _emptyArray;
            public String name;
            public String packageName;
            public String version;

            public Application() {
                clear();
            }

            public static Application[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Application[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static Application parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new Application().mergeFrom(codedInputByteBufferNano);
            }

            public static Application parseFrom(byte[] bArr) {
                return (Application) MessageNano.mergeFrom(new Application(), bArr);
            }

            public final Application clear() {
                this.packageName = null;
                this.name = null;
                this.version = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                String str = this.packageName;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
                }
                String str2 = this.name;
                if (str2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, str2);
                }
                String str3 = this.version;
                return str3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, str3) : computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final Application mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.packageName = codedInputByteBufferNano.readString();
                    } else if (readTag == 18) {
                        this.name = codedInputByteBufferNano.readString();
                    } else if (readTag == 26) {
                        this.version = codedInputByteBufferNano.readString();
                    } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                String str = this.packageName;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                String str2 = this.name;
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(2, str2);
                }
                String str3 = this.version;
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(3, str3);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        /* loaded from: classes.dex */
        public final class AudioStats extends ParcelableExtendableMessageNano {
            public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(AudioStats.class);
            private static volatile AudioStats[] _emptyArray;
            public HistogramBucket[] cpuMeasurementsPercent;
            public Integer framesPerBuffer;
            public HistogramBucket[] numberOfSimultaneousSoundFields;
            public HistogramBucket[] numberOfSimultaneousSoundObjects;
            public Integer renderingMode;
            public HistogramBucket[] renderingTimePerBufferMilliseconds;
            public Integer sampleRate;

            /* loaded from: classes.dex */
            public interface RenderingMode {
                public static final int BINAURAL_HIGH_QUALITY = 3;
                public static final int BINAURAL_LOW_QUALITY = 2;
                public static final int STEREO_PANNING = 1;
                public static final int UNKNOWN = 0;
            }

            public AudioStats() {
                clear();
            }

            public static AudioStats[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new AudioStats[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static AudioStats parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new AudioStats().mergeFrom(codedInputByteBufferNano);
            }

            public static AudioStats parseFrom(byte[] bArr) {
                return (AudioStats) MessageNano.mergeFrom(new AudioStats(), bArr);
            }

            public final AudioStats clear() {
                this.sampleRate = null;
                this.framesPerBuffer = null;
                this.renderingTimePerBufferMilliseconds = HistogramBucket.emptyArray();
                this.numberOfSimultaneousSoundObjects = HistogramBucket.emptyArray();
                this.numberOfSimultaneousSoundFields = HistogramBucket.emptyArray();
                this.cpuMeasurementsPercent = HistogramBucket.emptyArray();
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.renderingMode;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.sampleRate;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                Integer num3 = this.framesPerBuffer;
                if (num3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue());
                }
                HistogramBucket[] histogramBucketArr = this.renderingTimePerBufferMilliseconds;
                int i = 0;
                if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                    int i2 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr2 = this.renderingTimePerBufferMilliseconds;
                        if (i2 >= histogramBucketArr2.length) {
                            break;
                        }
                        HistogramBucket histogramBucket = histogramBucketArr2[i2];
                        if (histogramBucket != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, histogramBucket);
                        }
                        i2++;
                    }
                }
                HistogramBucket[] histogramBucketArr3 = this.numberOfSimultaneousSoundObjects;
                if (histogramBucketArr3 != null && histogramBucketArr3.length > 0) {
                    int i3 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr4 = this.numberOfSimultaneousSoundObjects;
                        if (i3 >= histogramBucketArr4.length) {
                            break;
                        }
                        HistogramBucket histogramBucket2 = histogramBucketArr4[i3];
                        if (histogramBucket2 != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, histogramBucket2);
                        }
                        i3++;
                    }
                }
                HistogramBucket[] histogramBucketArr5 = this.numberOfSimultaneousSoundFields;
                if (histogramBucketArr5 != null && histogramBucketArr5.length > 0) {
                    int i4 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr6 = this.numberOfSimultaneousSoundFields;
                        if (i4 >= histogramBucketArr6.length) {
                            break;
                        }
                        HistogramBucket histogramBucket3 = histogramBucketArr6[i4];
                        if (histogramBucket3 != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, histogramBucket3);
                        }
                        i4++;
                    }
                }
                HistogramBucket[] histogramBucketArr7 = this.cpuMeasurementsPercent;
                if (histogramBucketArr7 != null && histogramBucketArr7.length > 0) {
                    while (true) {
                        HistogramBucket[] histogramBucketArr8 = this.cpuMeasurementsPercent;
                        if (i >= histogramBucketArr8.length) {
                            break;
                        }
                        HistogramBucket histogramBucket4 = histogramBucketArr8[i];
                        if (histogramBucket4 != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, histogramBucket4);
                        }
                        i++;
                    }
                }
                return computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final AudioStats mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                            this.renderingMode = Integer.valueOf(readInt32);
                        }
                    } else if (readTag == 16) {
                        this.sampleRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 24) {
                        this.framesPerBuffer = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 34) {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        HistogramBucket[] histogramBucketArr = this.renderingTimePerBufferMilliseconds;
                        int length = histogramBucketArr == null ? 0 : histogramBucketArr.length;
                        int i = repeatedFieldArrayLength + length;
                        HistogramBucket[] histogramBucketArr2 = new HistogramBucket[i];
                        if (length != 0) {
                            System.arraycopy(this.renderingTimePerBufferMilliseconds, 0, histogramBucketArr2, 0, length);
                        }
                        while (length < i - 1) {
                            histogramBucketArr2[length] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        histogramBucketArr2[length] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(histogramBucketArr2[length]);
                        this.renderingTimePerBufferMilliseconds = histogramBucketArr2;
                    } else if (readTag == 42) {
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        HistogramBucket[] histogramBucketArr3 = this.numberOfSimultaneousSoundObjects;
                        int length2 = histogramBucketArr3 == null ? 0 : histogramBucketArr3.length;
                        int i2 = repeatedFieldArrayLength2 + length2;
                        HistogramBucket[] histogramBucketArr4 = new HistogramBucket[i2];
                        if (length2 != 0) {
                            System.arraycopy(this.numberOfSimultaneousSoundObjects, 0, histogramBucketArr4, 0, length2);
                        }
                        while (length2 < i2 - 1) {
                            histogramBucketArr4[length2] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr4[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        histogramBucketArr4[length2] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(histogramBucketArr4[length2]);
                        this.numberOfSimultaneousSoundObjects = histogramBucketArr4;
                    } else if (readTag == 50) {
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        HistogramBucket[] histogramBucketArr5 = this.numberOfSimultaneousSoundFields;
                        int length3 = histogramBucketArr5 == null ? 0 : histogramBucketArr5.length;
                        int i3 = repeatedFieldArrayLength3 + length3;
                        HistogramBucket[] histogramBucketArr6 = new HistogramBucket[i3];
                        if (length3 != 0) {
                            System.arraycopy(this.numberOfSimultaneousSoundFields, 0, histogramBucketArr6, 0, length3);
                        }
                        while (length3 < i3 - 1) {
                            histogramBucketArr6[length3] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr6[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        histogramBucketArr6[length3] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(histogramBucketArr6[length3]);
                        this.numberOfSimultaneousSoundFields = histogramBucketArr6;
                    } else if (readTag == 58) {
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                        HistogramBucket[] histogramBucketArr7 = this.cpuMeasurementsPercent;
                        int length4 = histogramBucketArr7 == null ? 0 : histogramBucketArr7.length;
                        int i4 = repeatedFieldArrayLength4 + length4;
                        HistogramBucket[] histogramBucketArr8 = new HistogramBucket[i4];
                        if (length4 != 0) {
                            System.arraycopy(this.cpuMeasurementsPercent, 0, histogramBucketArr8, 0, length4);
                        }
                        while (length4 < i4 - 1) {
                            histogramBucketArr8[length4] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr8[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        histogramBucketArr8[length4] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(histogramBucketArr8[length4]);
                        this.cpuMeasurementsPercent = histogramBucketArr8;
                    } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                Integer num = this.renderingMode;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.sampleRate;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                Integer num3 = this.framesPerBuffer;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num3.intValue());
                }
                HistogramBucket[] histogramBucketArr = this.renderingTimePerBufferMilliseconds;
                int i = 0;
                if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                    int i2 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr2 = this.renderingTimePerBufferMilliseconds;
                        if (i2 >= histogramBucketArr2.length) {
                            break;
                        }
                        HistogramBucket histogramBucket = histogramBucketArr2[i2];
                        if (histogramBucket != null) {
                            codedOutputByteBufferNano.writeMessage(4, histogramBucket);
                        }
                        i2++;
                    }
                }
                HistogramBucket[] histogramBucketArr3 = this.numberOfSimultaneousSoundObjects;
                if (histogramBucketArr3 != null && histogramBucketArr3.length > 0) {
                    int i3 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr4 = this.numberOfSimultaneousSoundObjects;
                        if (i3 >= histogramBucketArr4.length) {
                            break;
                        }
                        HistogramBucket histogramBucket2 = histogramBucketArr4[i3];
                        if (histogramBucket2 != null) {
                            codedOutputByteBufferNano.writeMessage(5, histogramBucket2);
                        }
                        i3++;
                    }
                }
                HistogramBucket[] histogramBucketArr5 = this.numberOfSimultaneousSoundFields;
                if (histogramBucketArr5 != null && histogramBucketArr5.length > 0) {
                    int i4 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr6 = this.numberOfSimultaneousSoundFields;
                        if (i4 >= histogramBucketArr6.length) {
                            break;
                        }
                        HistogramBucket histogramBucket3 = histogramBucketArr6[i4];
                        if (histogramBucket3 != null) {
                            codedOutputByteBufferNano.writeMessage(6, histogramBucket3);
                        }
                        i4++;
                    }
                }
                HistogramBucket[] histogramBucketArr7 = this.cpuMeasurementsPercent;
                if (histogramBucketArr7 != null && histogramBucketArr7.length > 0) {
                    while (true) {
                        HistogramBucket[] histogramBucketArr8 = this.cpuMeasurementsPercent;
                        if (i >= histogramBucketArr8.length) {
                            break;
                        }
                        HistogramBucket histogramBucket4 = histogramBucketArr8[i];
                        if (histogramBucket4 != null) {
                            codedOutputByteBufferNano.writeMessage(7, histogramBucket4);
                        }
                        i++;
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        /* loaded from: classes.dex */
        public interface Bucket {
            public static final int ELEVEN_TO_TWENTY = 11;
            public static final int FIVE = 5;
            public static final int FOUR = 4;
            public static final int ONE = 1;
            public static final int SIX_TO_TEN = 6;
            public static final int THREE = 3;
            public static final int TWENTYONE_PLUS = 21;
            public static final int TWO = 2;
            public static final int UNKNOWN_BUCKET = 0;
        }

        /* loaded from: classes.dex */
        public final class Cyclops extends ParcelableExtendableMessageNano {
            public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(Cyclops.class);
            private static volatile Cyclops[] _emptyArray;
            public Capture capture;
            public Share share;
            public View view;

            /* loaded from: classes.dex */
            public final class Capture extends ParcelableExtendableMessageNano {
                public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(Capture.class);
                private static volatile Capture[] _emptyArray;
                public Float angleDegrees;
                public Long captureTimeMs;
                public Boolean captureWarnings;
                public Long compositionTimeMs;
                public Integer outcome;
                public Long processingTimeMs;
                public Boolean withSound;

                /* loaded from: classes.dex */
                public interface Outcome {
                    public static final int FAILURE_CAPTURE = 2;
                    public static final int FAILURE_PROCESSING = 3;
                    public static final int SUCCESS = 1;
                    public static final int UNKNOWN = 0;
                    public static final int USER_CANCELLED = 4;
                }

                public Capture() {
                    clear();
                }

                public static Capture[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new Capture[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public static Capture parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    return new Capture().mergeFrom(codedInputByteBufferNano);
                }

                public static Capture parseFrom(byte[] bArr) {
                    return (Capture) MessageNano.mergeFrom(new Capture(), bArr);
                }

                public final Capture clear() {
                    this.angleDegrees = null;
                    this.withSound = null;
                    this.captureWarnings = null;
                    this.compositionTimeMs = null;
                    this.captureTimeMs = null;
                    this.processingTimeMs = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                protected final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    Integer num = this.outcome;
                    if (num != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                    }
                    Float f = this.angleDegrees;
                    if (f != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, f.floatValue());
                    }
                    Boolean bool = this.withSound;
                    if (bool != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, bool.booleanValue());
                    }
                    Boolean bool2 = this.captureWarnings;
                    if (bool2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, bool2.booleanValue());
                    }
                    Long l = this.compositionTimeMs;
                    if (l != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, l.longValue());
                    }
                    Long l2 = this.captureTimeMs;
                    if (l2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, l2.longValue());
                    }
                    Long l3 = this.processingTimeMs;
                    return l3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(7, l3.longValue()) : computeSerializedSize;
                }

                @Override // com.google.protobuf.nano.MessageNano
                public final Capture mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                                this.outcome = Integer.valueOf(readInt32);
                            }
                        } else if (readTag == 21) {
                            this.angleDegrees = Float.valueOf(codedInputByteBufferNano.readFloat());
                        } else if (readTag == 24) {
                            this.withSound = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        } else if (readTag == 32) {
                            this.captureWarnings = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        } else if (readTag == 40) {
                            this.compositionTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                        } else if (readTag == 48) {
                            this.captureTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                        } else if (readTag == 56) {
                            this.processingTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                        } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    }
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                    Integer num = this.outcome;
                    if (num != null) {
                        codedOutputByteBufferNano.writeInt32(1, num.intValue());
                    }
                    Float f = this.angleDegrees;
                    if (f != null) {
                        codedOutputByteBufferNano.writeFloat(2, f.floatValue());
                    }
                    Boolean bool = this.withSound;
                    if (bool != null) {
                        codedOutputByteBufferNano.writeBool(3, bool.booleanValue());
                    }
                    Boolean bool2 = this.captureWarnings;
                    if (bool2 != null) {
                        codedOutputByteBufferNano.writeBool(4, bool2.booleanValue());
                    }
                    Long l = this.compositionTimeMs;
                    if (l != null) {
                        codedOutputByteBufferNano.writeInt64(5, l.longValue());
                    }
                    Long l2 = this.captureTimeMs;
                    if (l2 != null) {
                        codedOutputByteBufferNano.writeInt64(6, l2.longValue());
                    }
                    Long l3 = this.processingTimeMs;
                    if (l3 != null) {
                        codedOutputByteBufferNano.writeInt64(7, l3.longValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }
            }

            /* loaded from: classes.dex */
            public final class Share extends ParcelableExtendableMessageNano {
                public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(Share.class);
                private static volatile Share[] _emptyArray;
                public Integer type;
                public Boolean withSound;

                /* loaded from: classes.dex */
                public interface Type {
                    public static final int CANCELLED = 1;
                    public static final int COPY_LINK = 2;
                    public static final int SOCIAL_FACEBOOK = 4;
                    public static final int SOCIAL_GPLUS = 6;
                    public static final int SOCIAL_OTHER = 3;
                    public static final int SOCIAL_TWITTER = 5;
                    public static final int UNKNOWN = 0;
                }

                public Share() {
                    clear();
                }

                public static Share[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new Share[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public static Share parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    return new Share().mergeFrom(codedInputByteBufferNano);
                }

                public static Share parseFrom(byte[] bArr) {
                    return (Share) MessageNano.mergeFrom(new Share(), bArr);
                }

                public final Share clear() {
                    this.withSound = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                protected final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    Integer num = this.type;
                    if (num != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                    }
                    Boolean bool = this.withSound;
                    return bool != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue()) : computeSerializedSize;
                }

                @Override // com.google.protobuf.nano.MessageNano
                public final Share mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            switch (readInt32) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                    this.type = Integer.valueOf(readInt32);
                                    break;
                            }
                        } else if (readTag == 16) {
                            this.withSound = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    }
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                    Integer num = this.type;
                    if (num != null) {
                        codedOutputByteBufferNano.writeInt32(1, num.intValue());
                    }
                    Boolean bool = this.withSound;
                    if (bool != null) {
                        codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }
            }

            /* loaded from: classes.dex */
            public final class View extends ParcelableExtendableMessageNano {
                public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(View.class);
                private static volatile View[] _emptyArray;
                public Boolean interaction;
                public Integer numPanos;
                public Integer orientation;
                public Boolean withSound;

                /* loaded from: classes.dex */
                public interface Orientation {
                    public static final int LANDSCAPE = 1;
                    public static final int PORTRAIT = 2;
                    public static final int UNKNOWN = 0;
                }

                public View() {
                    clear();
                }

                public static View[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new View[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public static View parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    return new View().mergeFrom(codedInputByteBufferNano);
                }

                public static View parseFrom(byte[] bArr) {
                    return (View) MessageNano.mergeFrom(new View(), bArr);
                }

                public final View clear() {
                    this.interaction = null;
                    this.withSound = null;
                    this.numPanos = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                protected final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    Integer num = this.orientation;
                    if (num != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                    }
                    Boolean bool = this.interaction;
                    if (bool != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue());
                    }
                    Boolean bool2 = this.withSound;
                    if (bool2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, bool2.booleanValue());
                    }
                    Integer num2 = this.numPanos;
                    return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, num2.intValue()) : computeSerializedSize;
                }

                @Override // com.google.protobuf.nano.MessageNano
                public final View mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                                this.orientation = Integer.valueOf(readInt32);
                            }
                        } else if (readTag == 16) {
                            this.interaction = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        } else if (readTag == 24) {
                            this.withSound = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        } else if (readTag == 32) {
                            this.numPanos = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    }
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                    Integer num = this.orientation;
                    if (num != null) {
                        codedOutputByteBufferNano.writeInt32(1, num.intValue());
                    }
                    Boolean bool = this.interaction;
                    if (bool != null) {
                        codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
                    }
                    Boolean bool2 = this.withSound;
                    if (bool2 != null) {
                        codedOutputByteBufferNano.writeBool(3, bool2.booleanValue());
                    }
                    Integer num2 = this.numPanos;
                    if (num2 != null) {
                        codedOutputByteBufferNano.writeInt32(4, num2.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }
            }

            public Cyclops() {
                clear();
            }

            public static Cyclops[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Cyclops[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static Cyclops parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new Cyclops().mergeFrom(codedInputByteBufferNano);
            }

            public static Cyclops parseFrom(byte[] bArr) {
                return (Cyclops) MessageNano.mergeFrom(new Cyclops(), bArr);
            }

            public final Cyclops clear() {
                this.capture = null;
                this.view = null;
                this.share = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Capture capture = this.capture;
                if (capture != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, capture);
                }
                View view = this.view;
                if (view != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, view);
                }
                Share share = this.share;
                return share != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, share) : computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final Cyclops mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                MessageNano messageNano;
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        if (this.capture == null) {
                            this.capture = new Capture();
                        }
                        messageNano = this.capture;
                    } else if (readTag == 18) {
                        if (this.view == null) {
                            this.view = new View();
                        }
                        messageNano = this.view;
                    } else if (readTag == 26) {
                        if (this.share == null) {
                            this.share = new Share();
                        }
                        messageNano = this.share;
                    } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    codedInputByteBufferNano.readMessage(messageNano);
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                Capture capture = this.capture;
                if (capture != null) {
                    codedOutputByteBufferNano.writeMessage(1, capture);
                }
                View view = this.view;
                if (view != null) {
                    codedOutputByteBufferNano.writeMessage(2, view);
                }
                Share share = this.share;
                if (share != null) {
                    codedOutputByteBufferNano.writeMessage(3, share);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        /* loaded from: classes.dex */
        public final class EmbedVrWidget extends ParcelableExtendableMessageNano {
            public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(EmbedVrWidget.class);
            private static volatile EmbedVrWidget[] _emptyArray;
            public String errorMsg;
            public Pano pano;
            public Video video;
            public Integer viewMode;

            /* loaded from: classes.dex */
            public final class Pano extends ParcelableExtendableMessageNano {
                public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(Pano.class);
                private static volatile Pano[] _emptyArray;
                public Integer heightPixels;
                public Integer stereoFormat;
                public Integer widthPixels;

                public Pano() {
                    clear();
                }

                public static Pano[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new Pano[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public static Pano parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    return new Pano().mergeFrom(codedInputByteBufferNano);
                }

                public static Pano parseFrom(byte[] bArr) {
                    return (Pano) MessageNano.mergeFrom(new Pano(), bArr);
                }

                public final Pano clear() {
                    this.widthPixels = null;
                    this.heightPixels = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                protected final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    Integer num = this.widthPixels;
                    if (num != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                    }
                    Integer num2 = this.heightPixels;
                    if (num2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                    }
                    Integer num3 = this.stereoFormat;
                    return num3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue()) : computeSerializedSize;
                }

                @Override // com.google.protobuf.nano.MessageNano
                public final Pano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            this.widthPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        } else if (readTag == 16) {
                            this.heightPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        } else if (readTag == 24) {
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                                this.stereoFormat = Integer.valueOf(readInt32);
                            }
                        } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    }
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                    Integer num = this.widthPixels;
                    if (num != null) {
                        codedOutputByteBufferNano.writeInt32(1, num.intValue());
                    }
                    Integer num2 = this.heightPixels;
                    if (num2 != null) {
                        codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                    }
                    Integer num3 = this.stereoFormat;
                    if (num3 != null) {
                        codedOutputByteBufferNano.writeInt32(3, num3.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }
            }

            /* loaded from: classes.dex */
            public interface StereoFormat {
                public static final int MONO = 1;
                public static final int STEREO_OVER_UNDER = 2;
                public static final int UNKNOWN_FORMAT = 0;
            }

            /* loaded from: classes.dex */
            public final class Video extends ParcelableExtendableMessageNano {
                public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(Video.class);
                private static volatile Video[] _emptyArray;
                public Integer heightPixels;
                public Integer stereoFormat;
                public Integer videoDurationMs;
                public Integer widthPixels;

                public Video() {
                    clear();
                }

                public static Video[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new Video[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public static Video parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    return new Video().mergeFrom(codedInputByteBufferNano);
                }

                public static Video parseFrom(byte[] bArr) {
                    return (Video) MessageNano.mergeFrom(new Video(), bArr);
                }

                public final Video clear() {
                    this.widthPixels = null;
                    this.heightPixels = null;
                    this.videoDurationMs = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                protected final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    Integer num = this.widthPixels;
                    if (num != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                    }
                    Integer num2 = this.heightPixels;
                    if (num2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                    }
                    Integer num3 = this.stereoFormat;
                    if (num3 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue());
                    }
                    Integer num4 = this.videoDurationMs;
                    return num4 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, num4.intValue()) : computeSerializedSize;
                }

                @Override // com.google.protobuf.nano.MessageNano
                public final Video mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            this.widthPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        } else if (readTag == 16) {
                            this.heightPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        } else if (readTag == 24) {
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                                this.stereoFormat = Integer.valueOf(readInt32);
                            }
                        } else if (readTag == 32) {
                            this.videoDurationMs = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    }
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                    Integer num = this.widthPixels;
                    if (num != null) {
                        codedOutputByteBufferNano.writeInt32(1, num.intValue());
                    }
                    Integer num2 = this.heightPixels;
                    if (num2 != null) {
                        codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                    }
                    Integer num3 = this.stereoFormat;
                    if (num3 != null) {
                        codedOutputByteBufferNano.writeInt32(3, num3.intValue());
                    }
                    Integer num4 = this.videoDurationMs;
                    if (num4 != null) {
                        codedOutputByteBufferNano.writeInt32(4, num4.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }
            }

            /* loaded from: classes.dex */
            public interface ViewMode {
                public static final int EMBEDDED = 1;
                public static final int FULLSCREEN_MONO = 2;
                public static final int FULLSCREEN_VR = 3;
                public static final int UNKNOWN_MODE = 0;
            }

            public EmbedVrWidget() {
                clear();
            }

            public static EmbedVrWidget[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new EmbedVrWidget[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static EmbedVrWidget parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new EmbedVrWidget().mergeFrom(codedInputByteBufferNano);
            }

            public static EmbedVrWidget parseFrom(byte[] bArr) {
                return (EmbedVrWidget) MessageNano.mergeFrom(new EmbedVrWidget(), bArr);
            }

            public final EmbedVrWidget clear() {
                this.pano = null;
                this.video = null;
                this.errorMsg = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.viewMode;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Pano pano = this.pano;
                if (pano != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, pano);
                }
                Video video = this.video;
                if (video != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, video);
                }
                String str = this.errorMsg;
                return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, str) : computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final EmbedVrWidget mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                MessageNano messageNano;
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag != 8) {
                        if (readTag == 18) {
                            if (this.pano == null) {
                                this.pano = new Pano();
                            }
                            messageNano = this.pano;
                        } else if (readTag == 26) {
                            if (this.video == null) {
                                this.video = new Video();
                            }
                            messageNano = this.video;
                        } else if (readTag == 34) {
                            this.errorMsg = codedInputByteBufferNano.readString();
                        } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                        codedInputByteBufferNano.readMessage(messageNano);
                    } else {
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                            this.viewMode = Integer.valueOf(readInt32);
                        }
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                Integer num = this.viewMode;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Pano pano = this.pano;
                if (pano != null) {
                    codedOutputByteBufferNano.writeMessage(2, pano);
                }
                Video video = this.video;
                if (video != null) {
                    codedOutputByteBufferNano.writeMessage(3, video);
                }
                String str = this.errorMsg;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(4, str);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        /* loaded from: classes.dex */
        public interface EventType {
            public static final int AUDIO_INITIALIZATION = 4000;
            public static final int AUDIO_PERFORMANCE_REPORT = 4002;
            public static final int AUDIO_SHUTDOWN = 4001;
            public static final int CYCLOPS_ACCOUNT_SWITCH = 1011;
            public static final int CYCLOPS_APPLICATION = 1000;
            public static final int CYCLOPS_CAPTURE = 1006;
            public static final int CYCLOPS_DELETE = 1003;
            public static final int CYCLOPS_FEEDBACK = 1012;
            public static final int CYCLOPS_GALLERY_CONTEXT_MENU = 1007;
            public static final int CYCLOPS_GALLERY_TO_CAPTURE = 1009;
            public static final int CYCLOPS_GALLERY_TO_GALLERY_HMD = 1008;
            public static final int CYCLOPS_RECEIVE = 1002;
            public static final int CYCLOPS_SETTINGS = 1010;
            public static final int CYCLOPS_SHARE = 1001;
            public static final int CYCLOPS_VIEW = 1004;
            public static final int CYCLOPS_VIEW_HMD = 1005;
            public static final int EMBEDVR_LOAD_ERROR = 6003;
            public static final int EMBEDVR_LOAD_SUCCESS = 6002;
            public static final int EMBEDVR_PERFORMANCE_REPORT = 6008;
            public static final int EMBEDVR_START_SESSION = 6000;
            public static final int EMBEDVR_STOP_SESSION = 6001;
            public static final int EMBEDVR_VIDEO_PAUSE = 6006;
            public static final int EMBEDVR_VIDEO_PLAY = 6005;
            public static final int EMBEDVR_VIDEO_SEEK_TO = 6007;
            public static final int EMBEDVR_VIEW_CLICK = 6004;
            public static final int FEATURED_APPS_TAB = 23;
            public static final int GET_INSTALLED_APPLICATIONS = 2;
            public static final int GO_TO_STORE = 5;
            public static final int LAUNCHER_START_APPLICATION = 3001;
            public static final int LAUNCHER_STOP_APPLICATION = 3002;
            public static final int LULLABY_MUTE = 5000;
            public static final int LULLABY_UNMUTE = 5001;
            public static final int MY_APPS_TAB = 22;
            public static final int SDK_PERFORMANCE_REPORT = 2003;
            public static final int SDK_SENSOR_REPORT = 2004;
            public static final int SETTINGS_QR_CODE_HELP = 21;
            public static final int SETTINGS_QR_CODE_SCAN = 9;
            public static final int SETTINGS_QR_CODE_SCAN_SKIP = 10;
            public static final int SETUP_HEAD_MOUNT_INSERTED = 17;
            public static final int SETUP_HEAD_MOUNT_SWITCH = 18;
            public static final int SETUP_PAIRED_NEXT = 16;
            public static final int SETUP_QR_CODE_HELP = 15;
            public static final int SETUP_QR_CODE_SCAN = 8;
            public static final int SETUP_QR_CODE_SCAN_SKIP = 7;
            public static final int SETUP_VR_INTRO_START = 19;
            public static final int SETUP_VR_INTRO_STOP = 20;
            public static final int SETUP_WELCOME_GET_VIEWER = 12;
            public static final int SETUP_WELCOME_NEXT = 11;
            public static final int SETUP_WELCOME_SWITCH_VIEWER = 13;
            public static final int SETUP_WELCOME_USE_VIEWER = 14;
            public static final int START_APPLICATION = 3;
            public static final int START_LAUNCHER = 1;
            public static final int START_SDK_APPLICATION = 2000;
            public static final int START_VR_APPLICATION = 2005;
            public static final int START_VR_LAUNCHER_COLD = 3000;
            public static final int STOP_APPLICATION = 4;
            public static final int STOP_VR_APPLICATION = 2006;
            public static final int SWITCH_HEAD_MOUNT = 6;
            public static final int TRANSITION_HEAD_MOUNT_INSERTED = 2001;
            public static final int TRANSITION_HEAD_MOUNT_SWITCH = 2002;
            public static final int UNKNOWN_EVENT_TYPE = 0;
            public static final int VRCORE_COMMON_DISABLE_VRMODE = 7001;
            public static final int VRCORE_COMMON_ENABLE_VRMODE = 7000;
            public static final int VRCORE_COMMON_ERROR = 7049;
            public static final int VRCORE_COMMON_PERMISSION_DENIED = 7204;
            public static final int VRCORE_COMMON_PERMISSION_GRANTED = 7203;
            public static final int VRCORE_NFC_ERROR = 7149;
            public static final int VRCORE_NFC_TRIGGER_INTENT = 7100;
            public static final int VRCORE_NOTIFICATION_ERROR = 7199;
            public static final int VRCORE_NOTIFICATION_POSTED = 7150;
            public static final int VRCORE_NOTIFICATION_REMOVED = 7151;
            public static final int VRCORE_PERFORMANCE_REPORT = 7999;
            public static final int VRCORE_SETTINGS_DISABLE_NOTIFICATION = 7202;
            public static final int VRCORE_SETTINGS_ENABLE_NOTIFICATION = 7201;
            public static final int VRCORE_SETTINGS_ERROR = 7249;
            public static final int VRCORE_SETTINGS_LAUNCHED = 7200;
        }

        /* loaded from: classes.dex */
        public final class HeadMount extends ParcelableExtendableMessageNano {
            public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(HeadMount.class);
            private static volatile HeadMount[] _emptyArray;
            public String model;
            public String vendor;

            public HeadMount() {
                clear();
            }

            public static HeadMount[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new HeadMount[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static HeadMount parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new HeadMount().mergeFrom(codedInputByteBufferNano);
            }

            public static HeadMount parseFrom(byte[] bArr) {
                return (HeadMount) MessageNano.mergeFrom(new HeadMount(), bArr);
            }

            public final HeadMount clear() {
                this.vendor = null;
                this.model = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                String str = this.vendor;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
                }
                String str2 = this.model;
                return str2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, str2) : computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final HeadMount mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.vendor = codedInputByteBufferNano.readString();
                    } else if (readTag == 18) {
                        this.model = codedInputByteBufferNano.readString();
                    } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                String str = this.vendor;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                String str2 = this.model;
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(2, str2);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        /* loaded from: classes.dex */
        public final class HistogramBucket extends ParcelableExtendableMessageNano {
            public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(HistogramBucket.class);
            private static volatile HistogramBucket[] _emptyArray;
            public Integer count;
            public Integer minimumValue;

            public HistogramBucket() {
                clear();
            }

            public static HistogramBucket[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new HistogramBucket[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static HistogramBucket parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new HistogramBucket().mergeFrom(codedInputByteBufferNano);
            }

            public static HistogramBucket parseFrom(byte[] bArr) {
                return (HistogramBucket) MessageNano.mergeFrom(new HistogramBucket(), bArr);
            }

            public final HistogramBucket clear() {
                this.minimumValue = null;
                this.count = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.minimumValue;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.count;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue()) : computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final HistogramBucket mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.minimumValue = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 16) {
                        this.count = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                Integer num = this.minimumValue;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.count;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        /* loaded from: classes.dex */
        public final class PerformanceStats extends ParcelableExtendableMessageNano {
            public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(PerformanceStats.class);
            private static volatile PerformanceStats[] _emptyArray;
            public Integer averageFps;
            public HistogramBucket[] frameTime;
            public Integer memoryConsumptionKilobytes;
            public Float shutdownSkinTemperatureCelsius;
            public Float throttleSkinTemperatureCelsius;
            public TimeSeriesData timeSeriesData;
            public Float vrMaxSkinTemperatureCelsius;

            public PerformanceStats() {
                clear();
            }

            public static PerformanceStats[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new PerformanceStats[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static PerformanceStats parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new PerformanceStats().mergeFrom(codedInputByteBufferNano);
            }

            public static PerformanceStats parseFrom(byte[] bArr) {
                return (PerformanceStats) MessageNano.mergeFrom(new PerformanceStats(), bArr);
            }

            public final PerformanceStats clear() {
                this.averageFps = null;
                this.frameTime = HistogramBucket.emptyArray();
                this.memoryConsumptionKilobytes = null;
                this.throttleSkinTemperatureCelsius = null;
                this.vrMaxSkinTemperatureCelsius = null;
                this.shutdownSkinTemperatureCelsius = null;
                this.timeSeriesData = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.averageFps;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                HistogramBucket[] histogramBucketArr = this.frameTime;
                if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                    int i = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr2 = this.frameTime;
                        if (i >= histogramBucketArr2.length) {
                            break;
                        }
                        HistogramBucket histogramBucket = histogramBucketArr2[i];
                        if (histogramBucket != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, histogramBucket);
                        }
                        i++;
                    }
                }
                Integer num2 = this.memoryConsumptionKilobytes;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue());
                }
                Float f = this.throttleSkinTemperatureCelsius;
                if (f != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, f.floatValue());
                }
                Float f2 = this.vrMaxSkinTemperatureCelsius;
                if (f2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(5, f2.floatValue());
                }
                Float f3 = this.shutdownSkinTemperatureCelsius;
                if (f3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(6, f3.floatValue());
                }
                TimeSeriesData timeSeriesData = this.timeSeriesData;
                return timeSeriesData != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(7, timeSeriesData) : computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final PerformanceStats mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.averageFps = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 18) {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        HistogramBucket[] histogramBucketArr = this.frameTime;
                        int length = histogramBucketArr == null ? 0 : histogramBucketArr.length;
                        int i = repeatedFieldArrayLength + length;
                        HistogramBucket[] histogramBucketArr2 = new HistogramBucket[i];
                        if (length != 0) {
                            System.arraycopy(this.frameTime, 0, histogramBucketArr2, 0, length);
                        }
                        while (length < i - 1) {
                            histogramBucketArr2[length] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(histogramBucketArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        histogramBucketArr2[length] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(histogramBucketArr2[length]);
                        this.frameTime = histogramBucketArr2;
                    } else if (readTag == 24) {
                        this.memoryConsumptionKilobytes = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 37) {
                        this.throttleSkinTemperatureCelsius = Float.valueOf(codedInputByteBufferNano.readFloat());
                    } else if (readTag == 45) {
                        this.vrMaxSkinTemperatureCelsius = Float.valueOf(codedInputByteBufferNano.readFloat());
                    } else if (readTag == 53) {
                        this.shutdownSkinTemperatureCelsius = Float.valueOf(codedInputByteBufferNano.readFloat());
                    } else if (readTag == 58) {
                        if (this.timeSeriesData == null) {
                            this.timeSeriesData = new TimeSeriesData();
                        }
                        codedInputByteBufferNano.readMessage(this.timeSeriesData);
                    } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                Integer num = this.averageFps;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                HistogramBucket[] histogramBucketArr = this.frameTime;
                if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                    int i = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr2 = this.frameTime;
                        if (i >= histogramBucketArr2.length) {
                            break;
                        }
                        HistogramBucket histogramBucket = histogramBucketArr2[i];
                        if (histogramBucket != null) {
                            codedOutputByteBufferNano.writeMessage(2, histogramBucket);
                        }
                        i++;
                    }
                }
                Integer num2 = this.memoryConsumptionKilobytes;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num2.intValue());
                }
                Float f = this.throttleSkinTemperatureCelsius;
                if (f != null) {
                    codedOutputByteBufferNano.writeFloat(4, f.floatValue());
                }
                Float f2 = this.vrMaxSkinTemperatureCelsius;
                if (f2 != null) {
                    codedOutputByteBufferNano.writeFloat(5, f2.floatValue());
                }
                Float f3 = this.shutdownSkinTemperatureCelsius;
                if (f3 != null) {
                    codedOutputByteBufferNano.writeFloat(6, f3.floatValue());
                }
                TimeSeriesData timeSeriesData = this.timeSeriesData;
                if (timeSeriesData != null) {
                    codedOutputByteBufferNano.writeMessage(7, timeSeriesData);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        /* loaded from: classes.dex */
        public final class QrCodeScan extends ParcelableExtendableMessageNano {
            public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(QrCodeScan.class);
            private static volatile QrCodeScan[] _emptyArray;
            public String headMountConfigUrl;
            public Integer status;

            /* loaded from: classes.dex */
            public interface Status {
                public static final int CONNECTION_ERROR = 3;
                public static final int OK = 1;
                public static final int UNEXPECTED_FORMAT = 2;
                public static final int UNKNOWN = 0;
            }

            public QrCodeScan() {
                clear();
            }

            public static QrCodeScan[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new QrCodeScan[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static QrCodeScan parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new QrCodeScan().mergeFrom(codedInputByteBufferNano);
            }

            public static QrCodeScan parseFrom(byte[] bArr) {
                return (QrCodeScan) MessageNano.mergeFrom(new QrCodeScan(), bArr);
            }

            public final QrCodeScan clear() {
                this.headMountConfigUrl = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.status;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                String str = this.headMountConfigUrl;
                return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, str) : computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final QrCodeScan mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                            this.status = Integer.valueOf(readInt32);
                        }
                    } else if (readTag == 18) {
                        this.headMountConfigUrl = codedInputByteBufferNano.readString();
                    } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                Integer num = this.status;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                String str = this.headMountConfigUrl;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(2, str);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        /* loaded from: classes.dex */
        public final class SensorStats extends ParcelableExtendableMessageNano {
            public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(SensorStats.class);
            private static volatile SensorStats[] _emptyArray;
            public GyroscopeStats gyroscopeStats;

            /* loaded from: classes.dex */
            public final class GyroscopeStats extends ParcelableExtendableMessageNano {
                public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(GyroscopeStats.class);
                private static volatile GyroscopeStats[] _emptyArray;
                public Vector3 bias;
                public Vector3 lowerBound;
                public Vector3 standardDeviation;
                public Vector3 upperBound;

                public GyroscopeStats() {
                    clear();
                }

                public static GyroscopeStats[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new GyroscopeStats[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public static GyroscopeStats parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    return new GyroscopeStats().mergeFrom(codedInputByteBufferNano);
                }

                public static GyroscopeStats parseFrom(byte[] bArr) {
                    return (GyroscopeStats) MessageNano.mergeFrom(new GyroscopeStats(), bArr);
                }

                public final GyroscopeStats clear() {
                    this.bias = null;
                    this.lowerBound = null;
                    this.upperBound = null;
                    this.standardDeviation = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                protected final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    Vector3 vector3 = this.bias;
                    if (vector3 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, vector3);
                    }
                    Vector3 vector32 = this.lowerBound;
                    if (vector32 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, vector32);
                    }
                    Vector3 vector33 = this.upperBound;
                    if (vector33 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, vector33);
                    }
                    Vector3 vector34 = this.standardDeviation;
                    return vector34 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, vector34) : computeSerializedSize;
                }

                @Override // com.google.protobuf.nano.MessageNano
                public final GyroscopeStats mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    Vector3 vector3;
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 10) {
                            if (this.bias == null) {
                                this.bias = new Vector3();
                            }
                            vector3 = this.bias;
                        } else if (readTag == 18) {
                            if (this.lowerBound == null) {
                                this.lowerBound = new Vector3();
                            }
                            vector3 = this.lowerBound;
                        } else if (readTag == 26) {
                            if (this.upperBound == null) {
                                this.upperBound = new Vector3();
                            }
                            vector3 = this.upperBound;
                        } else if (readTag == 34) {
                            if (this.standardDeviation == null) {
                                this.standardDeviation = new Vector3();
                            }
                            vector3 = this.standardDeviation;
                        } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                        codedInputByteBufferNano.readMessage(vector3);
                    }
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                    Vector3 vector3 = this.bias;
                    if (vector3 != null) {
                        codedOutputByteBufferNano.writeMessage(1, vector3);
                    }
                    Vector3 vector32 = this.lowerBound;
                    if (vector32 != null) {
                        codedOutputByteBufferNano.writeMessage(2, vector32);
                    }
                    Vector3 vector33 = this.upperBound;
                    if (vector33 != null) {
                        codedOutputByteBufferNano.writeMessage(3, vector33);
                    }
                    Vector3 vector34 = this.standardDeviation;
                    if (vector34 != null) {
                        codedOutputByteBufferNano.writeMessage(4, vector34);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }
            }

            /* loaded from: classes.dex */
            public final class Vector3 extends ParcelableExtendableMessageNano {
                public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(Vector3.class);
                private static volatile Vector3[] _emptyArray;
                public Float x;
                public Float y;
                public Float z;

                public Vector3() {
                    clear();
                }

                public static Vector3[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new Vector3[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public static Vector3 parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    return new Vector3().mergeFrom(codedInputByteBufferNano);
                }

                public static Vector3 parseFrom(byte[] bArr) {
                    return (Vector3) MessageNano.mergeFrom(new Vector3(), bArr);
                }

                public final Vector3 clear() {
                    this.x = null;
                    this.y = null;
                    this.z = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                protected final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    Float f = this.x;
                    if (f != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, f.floatValue());
                    }
                    Float f2 = this.y;
                    if (f2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, f2.floatValue());
                    }
                    Float f3 = this.z;
                    return f3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(3, f3.floatValue()) : computeSerializedSize;
                }

                @Override // com.google.protobuf.nano.MessageNano
                public final Vector3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 13) {
                            this.x = Float.valueOf(codedInputByteBufferNano.readFloat());
                        } else if (readTag == 21) {
                            this.y = Float.valueOf(codedInputByteBufferNano.readFloat());
                        } else if (readTag == 29) {
                            this.z = Float.valueOf(codedInputByteBufferNano.readFloat());
                        } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    }
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                    Float f = this.x;
                    if (f != null) {
                        codedOutputByteBufferNano.writeFloat(1, f.floatValue());
                    }
                    Float f2 = this.y;
                    if (f2 != null) {
                        codedOutputByteBufferNano.writeFloat(2, f2.floatValue());
                    }
                    Float f3 = this.z;
                    if (f3 != null) {
                        codedOutputByteBufferNano.writeFloat(3, f3.floatValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }
            }

            public SensorStats() {
                clear();
            }

            public static SensorStats[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new SensorStats[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static SensorStats parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new SensorStats().mergeFrom(codedInputByteBufferNano);
            }

            public static SensorStats parseFrom(byte[] bArr) {
                return (SensorStats) MessageNano.mergeFrom(new SensorStats(), bArr);
            }

            public final SensorStats clear() {
                this.gyroscopeStats = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                GyroscopeStats gyroscopeStats = this.gyroscopeStats;
                return gyroscopeStats != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, gyroscopeStats) : computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final SensorStats mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        if (this.gyroscopeStats == null) {
                            this.gyroscopeStats = new GyroscopeStats();
                        }
                        codedInputByteBufferNano.readMessage(this.gyroscopeStats);
                    } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                GyroscopeStats gyroscopeStats = this.gyroscopeStats;
                if (gyroscopeStats != null) {
                    codedOutputByteBufferNano.writeMessage(1, gyroscopeStats);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        /* loaded from: classes.dex */
        public final class TimeSeriesData extends ParcelableExtendableMessageNano {
            public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(TimeSeriesData.class);
            private static volatile TimeSeriesData[] _emptyArray;
            public TimeIntervalData[] timeIntervalData;
            public Integer timeIntervalSeconds;

            /* loaded from: classes.dex */
            public final class TimeIntervalData extends ParcelableExtendableMessageNano {
                public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(TimeIntervalData.class);
                private static volatile TimeIntervalData[] _emptyArray;
                public Integer edsThreadFrameDropCount;
                public Integer intervalStartTimeSeconds;
                public Float skinTemperature;

                public TimeIntervalData() {
                    clear();
                }

                public static TimeIntervalData[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new TimeIntervalData[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                public static TimeIntervalData parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    return new TimeIntervalData().mergeFrom(codedInputByteBufferNano);
                }

                public static TimeIntervalData parseFrom(byte[] bArr) {
                    return (TimeIntervalData) MessageNano.mergeFrom(new TimeIntervalData(), bArr);
                }

                public final TimeIntervalData clear() {
                    this.intervalStartTimeSeconds = null;
                    this.skinTemperature = null;
                    this.edsThreadFrameDropCount = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                protected final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    Integer num = this.intervalStartTimeSeconds;
                    if (num != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                    }
                    Float f = this.skinTemperature;
                    if (f != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, f.floatValue());
                    }
                    Integer num2 = this.edsThreadFrameDropCount;
                    return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue()) : computeSerializedSize;
                }

                @Override // com.google.protobuf.nano.MessageNano
                public final TimeIntervalData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            this.intervalStartTimeSeconds = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        } else if (readTag == 21) {
                            this.skinTemperature = Float.valueOf(codedInputByteBufferNano.readFloat());
                        } else if (readTag == 24) {
                            this.edsThreadFrameDropCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    }
                }

                @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                    Integer num = this.intervalStartTimeSeconds;
                    if (num != null) {
                        codedOutputByteBufferNano.writeInt32(1, num.intValue());
                    }
                    Float f = this.skinTemperature;
                    if (f != null) {
                        codedOutputByteBufferNano.writeFloat(2, f.floatValue());
                    }
                    Integer num2 = this.edsThreadFrameDropCount;
                    if (num2 != null) {
                        codedOutputByteBufferNano.writeInt32(3, num2.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }
            }

            public TimeSeriesData() {
                clear();
            }

            public static TimeSeriesData[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new TimeSeriesData[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static TimeSeriesData parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new TimeSeriesData().mergeFrom(codedInputByteBufferNano);
            }

            public static TimeSeriesData parseFrom(byte[] bArr) {
                return (TimeSeriesData) MessageNano.mergeFrom(new TimeSeriesData(), bArr);
            }

            public final TimeSeriesData clear() {
                this.timeIntervalSeconds = null;
                this.timeIntervalData = TimeIntervalData.emptyArray();
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.timeIntervalSeconds;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                TimeIntervalData[] timeIntervalDataArr = this.timeIntervalData;
                if (timeIntervalDataArr != null && timeIntervalDataArr.length > 0) {
                    int i = 0;
                    while (true) {
                        TimeIntervalData[] timeIntervalDataArr2 = this.timeIntervalData;
                        if (i >= timeIntervalDataArr2.length) {
                            break;
                        }
                        TimeIntervalData timeIntervalData = timeIntervalDataArr2[i];
                        if (timeIntervalData != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, timeIntervalData);
                        }
                        i++;
                    }
                }
                return computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final TimeSeriesData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.timeIntervalSeconds = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 18) {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        TimeIntervalData[] timeIntervalDataArr = this.timeIntervalData;
                        int length = timeIntervalDataArr == null ? 0 : timeIntervalDataArr.length;
                        int i = repeatedFieldArrayLength + length;
                        TimeIntervalData[] timeIntervalDataArr2 = new TimeIntervalData[i];
                        if (length != 0) {
                            System.arraycopy(this.timeIntervalData, 0, timeIntervalDataArr2, 0, length);
                        }
                        while (length < i - 1) {
                            timeIntervalDataArr2[length] = new TimeIntervalData();
                            codedInputByteBufferNano.readMessage(timeIntervalDataArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        timeIntervalDataArr2[length] = new TimeIntervalData();
                        codedInputByteBufferNano.readMessage(timeIntervalDataArr2[length]);
                        this.timeIntervalData = timeIntervalDataArr2;
                    } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                Integer num = this.timeIntervalSeconds;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                TimeIntervalData[] timeIntervalDataArr = this.timeIntervalData;
                if (timeIntervalDataArr != null && timeIntervalDataArr.length > 0) {
                    int i = 0;
                    while (true) {
                        TimeIntervalData[] timeIntervalDataArr2 = this.timeIntervalData;
                        if (i >= timeIntervalDataArr2.length) {
                            break;
                        }
                        TimeIntervalData timeIntervalData = timeIntervalDataArr2[i];
                        if (timeIntervalData != null) {
                            codedOutputByteBufferNano.writeMessage(2, timeIntervalData);
                        }
                        i++;
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        /* loaded from: classes.dex */
        public final class VrCore extends ParcelableExtendableMessageNano {
            public static final Parcelable.Creator CREATOR = new ParcelableMessageNanoCreator(VrCore.class);
            private static volatile VrCore[] _emptyArray;
            public Integer errorCode;
            public Application foregroundApplication;
            public Integer permission;

            /* loaded from: classes.dex */
            public interface ErrorCode {
                public static final int BAD_STATE = 1;
                public static final int DISALLOWED_WRITE = 402;
                public static final int EMPTY_PLAYLOAD = 201;
                public static final int INVALID_PLAYLOAD = 202;
                public static final int INVALID_READ = 401;
                public static final int LAUNCH_FAILURE = 203;
                public static final int NO_ZEN_RULE = 301;
                public static final int UNKNOWN_ERROR = 0;
            }

            /* loaded from: classes.dex */
            public interface Permission {
                public static final int ACCESS_COARSE_LOCATION = 1;
                public static final int ACCESS_NOTIFICATION_POLICY = 8;
                public static final int BIND_CONDITION_PROVIDER_SERVICE = 7;
                public static final int BIND_NOTIFICATION_LISTENER_SERVICE = 6;
                public static final int CAMERA = 2;
                public static final int READ_EXTERNAL_STORAGE = 3;
                public static final int SYSTEM_ALERT_WINDOW = 5;
                public static final int UNKNOWN_PERMISSION = 0;
                public static final int WRITE_EXTERNAL_STORAGE = 4;
            }

            public VrCore() {
                clear();
            }

            public static VrCore[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new VrCore[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public static VrCore parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new VrCore().mergeFrom(codedInputByteBufferNano);
            }

            public static VrCore parseFrom(byte[] bArr) {
                return (VrCore) MessageNano.mergeFrom(new VrCore(), bArr);
            }

            public final VrCore clear() {
                this.foregroundApplication = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.errorCode;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.permission;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                Application application = this.foregroundApplication;
                return application != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, application) : computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final VrCore mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 301 && readInt32 != 401 && readInt32 != 402) {
                            switch (readInt32) {
                            }
                        }
                        this.errorCode = Integer.valueOf(readInt32);
                    } else if (readTag == 16) {
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
                            case 8:
                                this.permission = Integer.valueOf(readInt322);
                                break;
                        }
                    } else if (readTag == 26) {
                        if (this.foregroundApplication == null) {
                            this.foregroundApplication = new Application();
                        }
                        codedInputByteBufferNano.readMessage(this.foregroundApplication);
                    } else if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                }
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
                Integer num = this.errorCode;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.permission;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                Application application = this.foregroundApplication;
                if (application != null) {
                    codedOutputByteBufferNano.writeMessage(3, application);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public VREvent() {
            clear();
        }

        public static VREvent[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new VREvent[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static VREvent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new VREvent().mergeFrom(codedInputByteBufferNano);
        }

        public static VREvent parseFrom(byte[] bArr) {
            return (VREvent) MessageNano.mergeFrom(new VREvent(), bArr);
        }

        public final VREvent clear() {
            this.headMount = null;
            this.application = null;
            this.durationMs = null;
            this.installedVrApplications = Application.emptyArray();
            this.cyclops = null;
            this.qrCodeScan = null;
            this.cohort = null;
            this.performanceStats = null;
            this.sensorStats = null;
            this.audioStats = null;
            this.embedVrWidget = null;
            this.vrCore = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            HeadMount headMount = this.headMount;
            if (headMount != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, headMount);
            }
            Application application = this.application;
            if (application != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, application);
            }
            Long l = this.durationMs;
            if (l != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, l.longValue());
            }
            Application[] applicationArr = this.installedVrApplications;
            if (applicationArr != null && applicationArr.length > 0) {
                int i = 0;
                while (true) {
                    Application[] applicationArr2 = this.installedVrApplications;
                    if (i >= applicationArr2.length) {
                        break;
                    }
                    Application application2 = applicationArr2[i];
                    if (application2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, application2);
                    }
                    i++;
                }
            }
            Cyclops cyclops = this.cyclops;
            if (cyclops != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, cyclops);
            }
            QrCodeScan qrCodeScan = this.qrCodeScan;
            if (qrCodeScan != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, qrCodeScan);
            }
            String str = this.cohort;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, str);
            }
            Integer num = this.lifetimeCountBucket;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, num.intValue());
            }
            PerformanceStats performanceStats = this.performanceStats;
            if (performanceStats != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, performanceStats);
            }
            SensorStats sensorStats = this.sensorStats;
            if (sensorStats != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, sensorStats);
            }
            AudioStats audioStats = this.audioStats;
            if (audioStats != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, audioStats);
            }
            EmbedVrWidget embedVrWidget = this.embedVrWidget;
            if (embedVrWidget != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, embedVrWidget);
            }
            VrCore vrCore = this.vrCore;
            return vrCore != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(13, vrCore) : computeSerializedSize;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
        @Override // com.google.protobuf.nano.MessageNano
        public final VREvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            MessageNano messageNano;
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 10:
                        if (this.headMount == null) {
                            this.headMount = new HeadMount();
                        }
                        messageNano = this.headMount;
                        codedInputByteBufferNano.readMessage(messageNano);
                    case 18:
                        if (this.application == null) {
                            this.application = new Application();
                        }
                        messageNano = this.application;
                        codedInputByteBufferNano.readMessage(messageNano);
                    case 24:
                        this.durationMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                    case 34:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        Application[] applicationArr = this.installedVrApplications;
                        int length = applicationArr == null ? 0 : applicationArr.length;
                        int i = repeatedFieldArrayLength + length;
                        Application[] applicationArr2 = new Application[i];
                        if (length != 0) {
                            System.arraycopy(this.installedVrApplications, 0, applicationArr2, 0, length);
                        }
                        while (length < i - 1) {
                            applicationArr2[length] = new Application();
                            codedInputByteBufferNano.readMessage(applicationArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        applicationArr2[length] = new Application();
                        codedInputByteBufferNano.readMessage(applicationArr2[length]);
                        this.installedVrApplications = applicationArr2;
                    case 42:
                        if (this.cyclops == null) {
                            this.cyclops = new Cyclops();
                        }
                        messageNano = this.cyclops;
                        codedInputByteBufferNano.readMessage(messageNano);
                    case 50:
                        if (this.qrCodeScan == null) {
                            this.qrCodeScan = new QrCodeScan();
                        }
                        messageNano = this.qrCodeScan;
                        codedInputByteBufferNano.readMessage(messageNano);
                    case 58:
                        this.cohort = codedInputByteBufferNano.readString();
                    case 64:
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 11 && readInt32 != 21) {
                            switch (readInt32) {
                            }
                        }
                        this.lifetimeCountBucket = Integer.valueOf(readInt32);
                        break;
                    case 74:
                        if (this.performanceStats == null) {
                            this.performanceStats = new PerformanceStats();
                        }
                        messageNano = this.performanceStats;
                        codedInputByteBufferNano.readMessage(messageNano);
                    case 82:
                        if (this.sensorStats == null) {
                            this.sensorStats = new SensorStats();
                        }
                        messageNano = this.sensorStats;
                        codedInputByteBufferNano.readMessage(messageNano);
                    case 90:
                        if (this.audioStats == null) {
                            this.audioStats = new AudioStats();
                        }
                        messageNano = this.audioStats;
                        codedInputByteBufferNano.readMessage(messageNano);
                    case 98:
                        if (this.embedVrWidget == null) {
                            this.embedVrWidget = new EmbedVrWidget();
                        }
                        messageNano = this.embedVrWidget;
                        codedInputByteBufferNano.readMessage(messageNano);
                    case 106:
                        if (this.vrCore == null) {
                            this.vrCore = new VrCore();
                        }
                        messageNano = this.vrCore;
                        codedInputByteBufferNano.readMessage(messageNano);
                    default:
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                }
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
            HeadMount headMount = this.headMount;
            if (headMount != null) {
                codedOutputByteBufferNano.writeMessage(1, headMount);
            }
            Application application = this.application;
            if (application != null) {
                codedOutputByteBufferNano.writeMessage(2, application);
            }
            Long l = this.durationMs;
            if (l != null) {
                codedOutputByteBufferNano.writeInt64(3, l.longValue());
            }
            Application[] applicationArr = this.installedVrApplications;
            if (applicationArr != null && applicationArr.length > 0) {
                int i = 0;
                while (true) {
                    Application[] applicationArr2 = this.installedVrApplications;
                    if (i >= applicationArr2.length) {
                        break;
                    }
                    Application application2 = applicationArr2[i];
                    if (application2 != null) {
                        codedOutputByteBufferNano.writeMessage(4, application2);
                    }
                    i++;
                }
            }
            Cyclops cyclops = this.cyclops;
            if (cyclops != null) {
                codedOutputByteBufferNano.writeMessage(5, cyclops);
            }
            QrCodeScan qrCodeScan = this.qrCodeScan;
            if (qrCodeScan != null) {
                codedOutputByteBufferNano.writeMessage(6, qrCodeScan);
            }
            String str = this.cohort;
            if (str != null) {
                codedOutputByteBufferNano.writeString(7, str);
            }
            Integer num = this.lifetimeCountBucket;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(8, num.intValue());
            }
            PerformanceStats performanceStats = this.performanceStats;
            if (performanceStats != null) {
                codedOutputByteBufferNano.writeMessage(9, performanceStats);
            }
            SensorStats sensorStats = this.sensorStats;
            if (sensorStats != null) {
                codedOutputByteBufferNano.writeMessage(10, sensorStats);
            }
            AudioStats audioStats = this.audioStats;
            if (audioStats != null) {
                codedOutputByteBufferNano.writeMessage(11, audioStats);
            }
            EmbedVrWidget embedVrWidget = this.embedVrWidget;
            if (embedVrWidget != null) {
                codedOutputByteBufferNano.writeMessage(12, embedVrWidget);
            }
            VrCore vrCore = this.vrCore;
            if (vrCore != null) {
                codedOutputByteBufferNano.writeMessage(13, vrCore);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }
}
