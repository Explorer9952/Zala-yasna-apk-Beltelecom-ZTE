package zime.media;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.google.android.exoplayer2.util.MimeTypes;
import d.e.b.n.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes2.dex */
public class VideoDecodeCallBack {
    private static final String TAG = "VideoDecodeCallBack";
    private MediaFormat mdecoderformat;
    private MediaCodec mDecoder = null;
    private MediaCodec.BufferInfo mBufInfo = null;
    private ByteBuffer[] mInputBuffers = null;
    private ByteBuffer[] mOutputBuffers = null;
    boolean mIsEOS = false;
    private int mWidth = 0;
    private int mHeight = 0;
    public long mRtpTs = 0;
    private final int timeoutWaitForStartDecoderInMicroseconds = 300000;
    private final int timeoutWaitForDequeueInputBufferInMicroseconds = DefaultOggSeeker.MATCH_BYTE_RANGE;
    private final int timeoutWaitForDequeueOutputBufferInMicroseconds = 5000;
    private boolean mStartOK = false;
    private boolean mFirst = true;

    public static ArrayList<MediaCodecInfo> GetSupportDecoders() {
        ArrayList<MediaCodecInfo> arrayList = new ArrayList<>();
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder() && (codecInfoAt.getName().toUpperCase(Locale.getDefault()).contains("AVC") || codecInfoAt.getName().toUpperCase(Locale.getDefault()).contains("H264"))) {
                for (String str : codecInfoAt.getSupportedTypes()) {
                    if (str.contains("avc")) {
                        int[] iArr = codecInfoAt.getCapabilitiesForType(str).colorFormats;
                        if (iArr[0] == 19 || iArr[0] == 21) {
                            arrayList.add(codecInfoAt);
                            d.d(TAG, "name=" + codecInfoAt.getName() + ";colorFormat=" + codecInfoAt.getCapabilitiesForType(MimeTypes.VIDEO_H264).colorFormats[0]);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public int Decode(byte[] bArr, int i, byte[] bArr2, long j) {
        int fillThisBuffer;
        synchronized (this) {
            emptyThisBuffer(bArr, i, j);
            fillThisBuffer = fillThisBuffer(bArr2);
        }
        return fillThisBuffer;
    }

    public int GetFrame(byte[] bArr) {
        int fillThisBuffer;
        synchronized (this) {
            fillThisBuffer = fillThisBuffer(bArr);
        }
        return fillThisBuffer;
    }

    public int StartDecoder(int i, int i2) {
        synchronized (this) {
            if (this.mDecoder != null) {
                d.d(TAG, "StopDecoder+");
                this.mDecoder.flush();
            }
        }
        if (this.mFirst) {
            this.mDecoder = MediaCodec.createDecoderByType(MimeTypes.VIDEO_H264);
            this.mdecoderformat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H264, 1280, 720);
            if (this.mDecoder == null) {
                return -1;
            }
            this.mBufInfo = new MediaCodec.BufferInfo();
            this.mDecoder.configure(this.mdecoderformat, (Surface) null, (MediaCrypto) null, 0);
            this.mDecoder.start();
            this.mInputBuffers = this.mDecoder.getInputBuffers();
            this.mOutputBuffers = this.mDecoder.getOutputBuffers();
            int dequeueInputBuffer = this.mDecoder.dequeueInputBuffer(300000L);
            d.d(TAG, "startDecoderIdx+" + dequeueInputBuffer);
            if (dequeueInputBuffer < 0) {
                StopDecoder(0);
                return -1;
            }
            this.mDecoder.flush();
            this.mFirst = false;
        }
        d.c(TAG, "StartDecoder+");
        this.mStartOK = true;
        this.mWidth = i;
        this.mHeight = i2;
        return 0;
    }

    public int StopDecoder(int i) {
        synchronized (this) {
            if (i == 0) {
                if (this.mDecoder != null) {
                    d.d(TAG, "StopDecoder+");
                    this.mDecoder.flush();
                }
            } else if (this.mDecoder != null) {
                this.mDecoder.flush();
                this.mDecoder.stop();
                this.mDecoder.release();
            }
            this.mStartOK = false;
        }
        return 0;
    }

    public int emptyThisBuffer(byte[] bArr, int i, long j) {
        int dequeueInputBuffer;
        if (!this.mStartOK || this.mIsEOS || (dequeueInputBuffer = this.mDecoder.dequeueInputBuffer(100000L)) < 0) {
            return -1;
        }
        if (i < 0) {
            this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
            this.mIsEOS = true;
            return -1;
        }
        ByteBuffer byteBuffer = this.mInputBuffers[dequeueInputBuffer];
        byteBuffer.clear();
        byteBuffer.put(bArr, 0, i);
        this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int fillThisBuffer(byte[] r9) {
        /*
            r8 = this;
            boolean r0 = r8.mStartOK
            r1 = -1
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r8.mIsEOS
            if (r0 == 0) goto Lb
            return r1
        Lb:
            android.media.MediaCodec r0 = r8.mDecoder
            android.media.MediaCodec$BufferInfo r2 = r8.mBufInfo
            r3 = 5000(0x1388, double:2.4703E-320)
            int r0 = r0.dequeueOutputBuffer(r2, r3)
            r2 = 0
            if (r0 < 0) goto L67
            java.nio.ByteBuffer[] r1 = r8.mOutputBuffers
            r1 = r1[r0]
            android.media.MediaCodec$BufferInfo r3 = r8.mBufInfo
            long r4 = r3.presentationTimeUs
            r8.mRtpTs = r4
            int r4 = r3.size
            if (r4 <= 0) goto L55
            int r5 = r8.mWidth
            int r6 = r8.mHeight
            int r7 = r5 * r6
            int r7 = r7 * 3
            int r7 = r7 / 2
            if (r4 < r7) goto L55
            int r5 = r5 * r6
            int r5 = r5 * 3
            int r5 = r5 / 2
            r3.size = r5
            int r3 = r3.offset
            r1.position(r3)
            android.media.MediaCodec$BufferInfo r3 = r8.mBufInfo
            int r4 = r3.offset
            int r3 = r3.size
            int r4 = r4 + r3
            r1.limit(r4)
            android.media.MediaCodec$BufferInfo r3 = r8.mBufInfo
            int r3 = r3.size
            r1.get(r9, r2, r3)
            android.media.MediaCodec$BufferInfo r9 = r8.mBufInfo
            int r9 = r9.size
            goto L56
        L55:
            r9 = 0
        L56:
            android.media.MediaCodec r1 = r8.mDecoder
            r3 = 1
            r1.releaseOutputBuffer(r0, r3)
            android.media.MediaCodec$BufferInfo r0 = r8.mBufInfo
            int r0 = r0.flags
            r0 = r0 & 4
            if (r0 == 0) goto L65
            return r2
        L65:
            r2 = r9
            goto L72
        L67:
            r9 = -3
            if (r0 != r9) goto L73
            android.media.MediaCodec r9 = r8.mDecoder
            java.nio.ByteBuffer[] r9 = r9.getOutputBuffers()
            r8.mOutputBuffers = r9
        L72:
            return r2
        L73:
            r9 = -2
            if (r0 != r9) goto L77
            return r9
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zime.media.VideoDecodeCallBack.fillThisBuffer(byte[]):int");
    }
}
