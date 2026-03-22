package ijk.media.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import ijk.media.player.misc.IMediaDataSource;
import ijk.media.player.misc.ITrackInfo;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface IMediaPlayer {
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    public static final int MEDIA_INFO_AUDIO_DECODED_START = 10003;
    public static final int MEDIA_INFO_AUDIO_RENDERING_START = 10002;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_COMPONENT_OPEN = 10007;
    public static final int MEDIA_INFO_FIND_STREAM_INFO = 10006;
    public static final int MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE = 10100;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_OPEN_INPUT = 10005;
    public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
    public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
    public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
    public static final int MEDIA_INFO_VIDEO_DECODED_START = 10004;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_RENDERING_TRACK_CHANGED = 10101;
    public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
    public static final int MEDIA_INFO_VIDEO_SEEK_RENDERING_START = 10008;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;

    /* loaded from: classes2.dex */
    public interface a {
        void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onCompletion(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean onError(IMediaPlayer iMediaPlayer, int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface d {
        boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void onPrepared(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: classes2.dex */
    public interface f {
        void onSeekComplete(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: classes2.dex */
    public interface g {
        void a(IMediaPlayer iMediaPlayer, int i, Rect rect);
    }

    /* loaded from: classes2.dex */
    public interface h {
        void a(IMediaPlayer iMediaPlayer, ijk.media.player.i iVar);
    }

    /* loaded from: classes2.dex */
    public interface i {
        void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4);
    }

    boolean GetCurrentFrame(Bitmap bitmap);

    int GetRecordStatus();

    int StartRecord(String str);

    int StopRecord();

    List<String> getAudioSeq();

    int getAudioSessionId();

    long getAudioTrackSum();

    long getCurrentPosition();

    String getDataSource();

    long getDuration();

    j getMediaInfo();

    String getPlayerProbeKPI();

    float getSpeed();

    boolean getSubBitmap(Bitmap bitmap);

    List<String> getSubtitleSeq();

    long getSubtitleTrackSum();

    ITrackInfo[] getTrackInfo();

    int getVideoHeight();

    int getVideoSarDen();

    int getVideoSarNum();

    List<String> getVideoSeq();

    long getVideoTrackSum();

    int getVideoWidth();

    float getVolume();

    boolean isLooping();

    boolean isPlayable();

    boolean isPlaying();

    void pause() throws IllegalStateException;

    void prepareAsync() throws IllegalStateException;

    void release();

    void reset();

    void seekTo(long j) throws IllegalStateException;

    void setAudioStreamSelected(String str, boolean z);

    void setAudioStreamType(int i2);

    void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDataSource(IMediaDataSource iMediaDataSource);

    void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException;

    void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDisplay(SurfaceHolder surfaceHolder);

    void setInitBufferTime(long j);

    void setKeepInBackground(boolean z);

    void setLogEnabled(boolean z);

    void setLooping(boolean z);

    void setMaxAllBufferSize(long j);

    void setMaxBufferSize(long j);

    void setMaxBufferTime(long j);

    void setOnBufferingUpdateListener(a aVar);

    void setOnCompletionListener(b bVar);

    void setOnErrorListener(c cVar);

    void setOnInfoListener(d dVar);

    void setOnPreparedListener(e eVar);

    void setOnSeekCompleteListener(f fVar);

    void setOnSubBitmapListener(g gVar);

    void setOnTimedTextListener(h hVar);

    void setOnVideoSizeChangedListener(i iVar);

    void setPlaybackBufferTime(long j);

    void setPreferBitrate(long j);

    void setScreenOnWhilePlaying(boolean z);

    void setSpeed(float f2);

    void setSubtitleStreamSelected(String str, boolean z);

    void setSurface(Surface surface);

    void setVideoStreamSelected(int i2, boolean z);

    void setVolume(float f2, float f3);

    void setWakeMode(Context context, int i2);

    void start() throws IllegalStateException;

    void stop() throws IllegalStateException;
}
