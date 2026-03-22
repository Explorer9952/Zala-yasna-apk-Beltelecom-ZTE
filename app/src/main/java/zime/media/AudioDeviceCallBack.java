package zime.media;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import com.google.android.exoplayer2.util.MimeTypes;
import com.zte.ucs.tvcall.ocx.OcxEventCallBack;
import d.e.b.n.c;
import d.e.b.n.d;
import ijk.media.player.IMediaPlayer;

/* loaded from: classes2.dex */
public class AudioDeviceCallBack {
    private static final String TAG = "AudioDeviceCallBack";
    public static final int ZIME_RECORDSTATE_ERROR = 401;
    private AudioRecord mAudioRecord = null;
    private int mRecordSampleLen = 0;
    private boolean mbStereoRecord = false;
    private boolean mbRightChannel = false;
    byte[] mreadbuf = null;
    private AudioTrack mAudioTrack = null;
    private boolean mConsumerPlaying = false;

    private void stopAudioRecord() {
        AudioRecord audioRecord = this.mAudioRecord;
        if (audioRecord == null) {
            d.a(TAG, "stopAudioRecord when mAudioRecord is null, do nothing.");
            return;
        }
        try {
            int state = audioRecord.getState();
            d.a(TAG, "stopAudioRecord begin when mAudioRecord iState:" + state);
            if (state != 0) {
                this.mAudioRecord.stop();
            } else {
                d.d(TAG, "stopAudioRecord called in WRONG mAudioRecord iState:" + state);
            }
        } catch (Exception e) {
            d.b(TAG, "stopAudioRecord error when stopping mAudioRecord !", e);
        } finally {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public int ConsumerClose() {
        d.c(TAG, "Audio ConsumerClose enter.");
        if (this.mAudioTrack != null) {
            ((AudioManager) c.a().getSystemService(MimeTypes.BASE_TYPE_AUDIO)).setMode(0);
            int state = this.mAudioTrack.getState();
            d.d(TAG, "ConsumerClose mAudioTrack iState:" + state);
            if (state != 0) {
                this.mAudioTrack.stop();
            }
            this.mAudioTrack.release();
            this.mAudioTrack = null;
        }
        d.c(TAG, "Audio ConsumerClose done.");
        return 0;
    }

    public int ConsumerOpen(int i) {
        String str;
        StringBuilder sb;
        int state;
        d.c(TAG, "Audio ConsumerOpen enter.");
        try {
            int max = Math.max(AudioTrack.getMinBufferSize(i, 4, 2), ((i * 10) / 1000) * 2);
            try {
                ((AudioManager) c.a().getSystemService(MimeTypes.BASE_TYPE_AUDIO)).setMode(3);
                AudioTrack audioTrack = new AudioTrack(3, i, 4, 2, max, 1);
                this.mAudioTrack = audioTrack;
                state = audioTrack.getState();
                d.d(TAG, "ConsumerOpen mAudioTrack iState:" + state);
            } catch (Exception e) {
                e = e;
                this.mAudioTrack = null;
                str = TAG;
                sb = new StringBuilder("ConsumerOpen new AudioTrack failed,reason:");
                sb.append(e.toString());
                d.d(str, sb.toString());
                return -1;
            }
        } catch (Exception e2) {
            e = e2;
            str = TAG;
            sb = new StringBuilder("AudioTrack getMinBufferSize failed,reason:");
        }
        if (state == 1) {
            d.c(TAG, "Audio ConsumerOpen done.");
            return 0;
        }
        str = TAG;
        sb = new StringBuilder("ConsumerOpen failed,state error:");
        sb.append(state);
        d.d(str, sb.toString());
        return -1;
    }

    public int ConsumerStart() {
        d.c(TAG, "Audio ConsumerStart do nothing.");
        return 0;
    }

    public int ConsumerStop() {
        d.c(TAG, "Audio ConsumerStop enter.");
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            int state = audioTrack.getState();
            d.d(TAG, "ConsumerStop mAudioTrack iState:" + state);
            if (state != 0) {
                this.mAudioTrack.stop();
            }
        }
        this.mConsumerPlaying = false;
        d.c(TAG, "Audio ConsumerStop done.");
        return 0;
    }

    public int GetFrame(byte[] bArr, int i) {
        if (this.mAudioRecord == null) {
            return 0;
        }
        if (i < (this.mbStereoRecord ? this.mRecordSampleLen / 2 : this.mRecordSampleLen)) {
            d.d(TAG, "Audo GetFrame buffer too small:" + i + "need lenth:" + this.mRecordSampleLen);
            return 0;
        }
        if (!this.mbStereoRecord) {
            return this.mAudioRecord.read(bArr, 0, this.mRecordSampleLen);
        }
        int read = this.mAudioRecord.read(this.mreadbuf, 0, this.mRecordSampleLen);
        if (this.mbRightChannel) {
            GetRightData(this.mreadbuf, read, bArr, read / 2);
        } else {
            GetLeftData(this.mreadbuf, read, bArr, read / 2);
        }
        return read / 2;
    }

    public void GetLeftData(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            bArr2[i4] = bArr[i3];
            bArr2[i4 + 1] = bArr[i3 + 1];
            i3 += 4;
            i4 += 2;
        }
    }

    public void GetRightData(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        int i4 = 2;
        while (i4 < i) {
            bArr2[i3] = bArr[i4];
            bArr2[i3 + 1] = bArr[i4 + 1];
            i4 += 4;
            i3 += 2;
        }
    }

    public int ProducerClose() {
        d.c(TAG, "Audio ProducerClose enter.");
        stopAudioRecord();
        this.mreadbuf = null;
        d.c(TAG, "Audio ProducerClose done.");
        return 0;
    }

    public int ProducerOpen(int i) {
        d.c(TAG, "Audio ProducerOpen enter");
        try {
            int minBufferSize = AudioRecord.getMinBufferSize(i, this.mbStereoRecord ? 12 : 16, 2);
            int i2 = ((i * 10) / 1000) * 2;
            int max = Math.max(minBufferSize, i2);
            d.a(TAG, "samplerate:" + i + ",buffersize:" + max + ",minBuffersize:" + minBufferSize);
            if (this.mbStereoRecord) {
                i2 *= 2;
            }
            this.mRecordSampleLen = i2;
            this.mreadbuf = new byte[i2];
            int i3 = i2 * IMediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK;
            if (max < i3) {
                max = i3;
            }
            try {
                stopAudioRecord();
                this.mAudioRecord = new AudioRecord(0, i, this.mbStereoRecord ? 12 : 16, 2, max);
            } catch (Exception e) {
                this.mAudioRecord.release();
                this.mAudioRecord = null;
                d.d(TAG, "ProducerOpen use DEFAULT to new audioRecord failed, Reason:" + e.toString());
            }
            AudioRecord audioRecord = this.mAudioRecord;
            if (audioRecord == null || audioRecord.getState() == 0) {
                d.d(TAG, "------careful:the VOICE_COMMUNICATION  is not ok! we use the MIC!");
                AudioRecord audioRecord2 = this.mAudioRecord;
                if (audioRecord2 != null) {
                    audioRecord2.release();
                    this.mAudioRecord = null;
                }
                try {
                    this.mAudioRecord = new AudioRecord(6, i, this.mbStereoRecord ? 12 : 16, 2, max);
                } catch (Exception e2) {
                    AudioRecord audioRecord3 = this.mAudioRecord;
                    if (audioRecord3 != null) {
                        audioRecord3.release();
                        this.mAudioRecord = null;
                    }
                    d.d(TAG, "ProducerOpen use MIC to new audioRecord failed, Reason:" + e2.toString());
                }
            }
            AudioRecord audioRecord4 = this.mAudioRecord;
            if (audioRecord4 == null) {
                d.d(TAG, "mAudioRecord is null.");
                return -1;
            }
            int state = audioRecord4.getState();
            d.a(TAG, "ProducerOpen mAudioRecord iState:" + state);
            if (state == 1) {
                d.c(TAG, "Audio ProducerOpen done.");
                return 0;
            }
            d.d(TAG, "ProducerOpen failed,state error:" + state);
            return -1;
        } catch (Exception e3) {
            d.d(TAG, "ProducerOpen:getMinBufferSize failed,reason:" + e3.toString());
            return -1;
        }
    }

    public int ProducerStart() {
        d.c(TAG, "Audio ProducerStart enter.");
        AudioRecord audioRecord = this.mAudioRecord;
        if (audioRecord == null) {
            d.d(TAG, "ProducerStart failed:mAudioRecord is null!");
            return -1;
        }
        int recordingState = audioRecord.getRecordingState();
        d.a(TAG, "ProducerStart mAudioRecord getRecordingState before startRecording:" + recordingState);
        try {
            this.mAudioRecord.startRecording();
            int recordingState2 = this.mAudioRecord.getRecordingState();
            d.a(TAG, "ProducerStart mAudioRecord getRecordingState after startRecording:" + recordingState2);
            if (recordingState2 == 3) {
                d.c(TAG, "Audio ProducerStart done.");
                return 0;
            }
            d.d(TAG, "ProducerStart************************failed:" + recordingState2);
            stopAudioRecord();
            OcxEventCallBack.java_DeviceRequestStatus(401);
            return -1;
        } catch (Exception e) {
            d.b(TAG, "mAudioRecord startRecording failed,Reason:" + e.toString(), e);
            return -1;
        }
    }

    public int ProducerStop() {
        d.c(TAG, "Audio ProducerStop enter.");
        stopAudioRecord();
        d.c(TAG, "Audio ProducerStop done.");
        return 0;
    }

    public int WriteFrame(byte[] bArr, int i) {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack == null) {
            return 0;
        }
        int write = audioTrack.write(bArr, 0, i);
        if (this.mConsumerPlaying) {
            return write;
        }
        try {
            this.mAudioTrack.play();
            this.mConsumerPlaying = true;
            return write;
        } catch (Exception e) {
            d.d(TAG, "mAudioTrack.play failed, Reason:" + e.toString());
            return -1;
        }
    }
}
