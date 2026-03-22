package ijk.media.player;

import android.graphics.Rect;
import ijk.media.player.IMediaPlayer;
import ijk.media.player.misc.IMediaDataSource;

/* compiled from: AbstractMediaPlayer.java */
/* loaded from: classes2.dex */
public abstract class a implements IMediaPlayer {
    private IMediaPlayer.a mOnBufferingUpdateListener;
    private IMediaPlayer.b mOnCompletionListener;
    private IMediaPlayer.c mOnErrorListener;
    private IMediaPlayer.d mOnInfoListener;
    private IMediaPlayer.e mOnPreparedListener;
    private IMediaPlayer.f mOnSeekCompleteListener;
    private IMediaPlayer.g mOnSubBitmapListener;
    private IMediaPlayer.h mOnTimedTextListener;
    private IMediaPlayer.i mOnVideoSizeChangedListener;

    @Override // ijk.media.player.IMediaPlayer
    public long getAudioTrackSum() {
        return 0L;
    }

    @Override // ijk.media.player.IMediaPlayer
    public long getSubtitleTrackSum() {
        return 0L;
    }

    @Override // ijk.media.player.IMediaPlayer
    public long getVideoTrackSum() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnBufferingUpdate(int i) {
        IMediaPlayer.a aVar = this.mOnBufferingUpdateListener;
        if (aVar != null) {
            aVar.onBufferingUpdate(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnCompletion() {
        IMediaPlayer.b bVar = this.mOnCompletionListener;
        if (bVar != null) {
            bVar.onCompletion(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean notifyOnError(int i, int i2) {
        IMediaPlayer.c cVar = this.mOnErrorListener;
        return cVar != null && cVar.onError(this, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean notifyOnInfo(int i, int i2) {
        IMediaPlayer.d dVar = this.mOnInfoListener;
        return dVar != null && dVar.onInfo(this, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnPrepared() {
        IMediaPlayer.e eVar = this.mOnPreparedListener;
        if (eVar != null) {
            eVar.onPrepared(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnSeekComplete() {
        IMediaPlayer.f fVar = this.mOnSeekCompleteListener;
        if (fVar != null) {
            fVar.onSeekComplete(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnSubBitmap(int i, Rect rect) {
        IMediaPlayer.g gVar = this.mOnSubBitmapListener;
        if (gVar != null) {
            gVar.a(this, i, rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnTimedText(i iVar) {
        IMediaPlayer.h hVar = this.mOnTimedTextListener;
        if (hVar != null) {
            hVar.a(this, iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnVideoSizeChanged(int i, int i2, int i3, int i4) {
        IMediaPlayer.i iVar = this.mOnVideoSizeChangedListener;
        if (iVar != null) {
            iVar.onVideoSizeChanged(this, i, i2, i3, i4);
        }
    }

    public void resetListeners() {
        this.mOnPreparedListener = null;
        this.mOnBufferingUpdateListener = null;
        this.mOnCompletionListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnVideoSizeChangedListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mOnTimedTextListener = null;
        this.mOnSubBitmapListener = null;
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setAudioStreamSelected(String str, boolean z) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }

    @Override // ijk.media.player.IMediaPlayer
    public final void setOnBufferingUpdateListener(IMediaPlayer.a aVar) {
        this.mOnBufferingUpdateListener = aVar;
    }

    @Override // ijk.media.player.IMediaPlayer
    public final void setOnCompletionListener(IMediaPlayer.b bVar) {
        this.mOnCompletionListener = bVar;
    }

    @Override // ijk.media.player.IMediaPlayer
    public final void setOnErrorListener(IMediaPlayer.c cVar) {
        this.mOnErrorListener = cVar;
    }

    @Override // ijk.media.player.IMediaPlayer
    public final void setOnInfoListener(IMediaPlayer.d dVar) {
        this.mOnInfoListener = dVar;
    }

    @Override // ijk.media.player.IMediaPlayer
    public final void setOnPreparedListener(IMediaPlayer.e eVar) {
        this.mOnPreparedListener = eVar;
    }

    @Override // ijk.media.player.IMediaPlayer
    public final void setOnSeekCompleteListener(IMediaPlayer.f fVar) {
        this.mOnSeekCompleteListener = fVar;
    }

    @Override // ijk.media.player.IMediaPlayer
    public final void setOnSubBitmapListener(IMediaPlayer.g gVar) {
        this.mOnSubBitmapListener = gVar;
    }

    @Override // ijk.media.player.IMediaPlayer
    public final void setOnTimedTextListener(IMediaPlayer.h hVar) {
        this.mOnTimedTextListener = hVar;
    }

    @Override // ijk.media.player.IMediaPlayer
    public final void setOnVideoSizeChangedListener(IMediaPlayer.i iVar) {
        this.mOnVideoSizeChangedListener = iVar;
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setSubtitleStreamSelected(String str, boolean z) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setVideoStreamSelected(int i, boolean z) {
    }
}
