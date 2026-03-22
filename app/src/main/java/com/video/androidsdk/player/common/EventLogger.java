package com.video.androidsdk.player.common;

import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.agama.AgamaIntegration;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import tv.agama.emp.client.Definitions$Measurement;
import tv.agama.emp.client.Definitions$SessionMetadata;

/* loaded from: classes.dex */
public class EventLogger implements ExoPlayer.EventListener, AudioRendererEventListener, DefaultDrmSessionManager.EventListener, MetadataRenderer.Output, AdaptiveMediaSourceEventListener, ExtractorMediaSource.EventListener, VideoRendererEventListener {

    /* renamed from: a, reason: collision with root package name */
    private static final NumberFormat f3343a;

    /* renamed from: b, reason: collision with root package name */
    private final MappingTrackSelector f3344b;

    /* renamed from: c, reason: collision with root package name */
    private final Timeline.Window f3345c = new Timeline.Window();

    /* renamed from: d, reason: collision with root package name */
    private final Timeline.Period f3346d = new Timeline.Period();
    private final long e = SystemClock.elapsedRealtime();
    private AgamaIntegration f;

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        f3343a = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        f3343a.setMaximumFractionDigits(2);
        f3343a.setGroupingUsed(false);
    }

    public EventLogger(MappingTrackSelector mappingTrackSelector) {
        this.f3344b = mappingTrackSelector;
    }

    private static String a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "E" : "R" : "B" : "I";
    }

    private static String a(int i, int i2) {
        return i < 2 ? "N/A" : i2 != 0 ? i2 != 8 ? i2 != 16 ? "?" : "YES" : "YES_NOT_SEAMLESS" : "NO";
    }

    private static String a(boolean z) {
        return z ? "[X]" : "[ ]";
    }

    private void a(String str, Exception exc) {
        LogEx.e("EventLogger", "internalError [" + a() + ", " + str + "]" + exc.getMessage());
    }

    private static String b(int i) {
        return i != 0 ? i != 1 ? i != 3 ? i != 4 ? "?" : "YES" : "NO_EXCEEDS_CAPABILITIES" : "NO_UNSUPPORTED_TYPE" : "NO";
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioDecoderInitialized(String str, long j, long j2) {
        LogEx.d("EventLogger", "audioDecoderInitialized [" + a() + ", " + str + "]");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioDisabled(DecoderCounters decoderCounters) {
        LogEx.d("EventLogger", "audioDisabled [" + a() + "]");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioEnabled(DecoderCounters decoderCounters) {
        LogEx.d("EventLogger", "audioEnabled [" + a() + "]");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioInputFormatChanged(Format format) {
        LogEx.d("EventLogger", "audioFormatChanged [" + a() + ", " + Format.toLogString(format) + "]");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioSessionId(int i) {
        LogEx.d("EventLogger", "audioSessionId [" + i + "]");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioSinkUnderrun(int i, long j, long j2) {
    }

    @Override // com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener
    public void onDownstreamFormatChanged(int i, Format format, int i2, Object obj, long j) {
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
    public void onDrmKeysLoaded() {
        LogEx.d("EventLogger", "drmKeysLoaded [" + a() + "]");
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
    public void onDrmKeysRemoved() {
        LogEx.d("EventLogger", "drmKeysRemoved [" + a() + "]");
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
    public void onDrmKeysRestored() {
        LogEx.d("EventLogger", "drmKeysRestored [" + a() + "]");
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
    public void onDrmSessionManagerError(Exception exc) {
        a("drmSessionManagerError", exc);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onDroppedFrames(int i, long j) {
        LogEx.d("EventLogger", "droppedFrames [" + a() + ", " + i + "]");
        AgamaIntegration agamaIntegration = this.f;
        if (agamaIntegration != null) {
            agamaIntegration.setMeasurement(Definitions$Measurement.NR_OF_FRAMES_DROPPED, i);
        }
    }

    @Override // com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener
    public void onLoadCanceled(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        LogEx.d("EventLogger", "onLoadCanceled() ");
        AgamaIntegration agamaIntegration = this.f;
        if (agamaIntegration != null) {
            agamaIntegration.setMeasurement(Definitions$Measurement.BYTES_RECEIVED, j5);
        }
    }

    @Override // com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener
    public void onLoadCompleted(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        LogEx.d("EventLogger", "onLoadCompleted() ");
        if (i == 1 && ((i2 == 2 || i2 == 1 || i2 == 0) && format != null && format.bitrate != -1)) {
            long j6 = (8 * j5) / j4;
            AgamaIntegration agamaIntegration = this.f;
            if (agamaIntegration != null) {
                agamaIntegration.setMeasurement(Definitions$Measurement.SEGMENT_READ_BITRATE, j6);
                this.f.setSessionMetadata(Definitions$SessionMetadata.DS_INITIAL_PROFILE, Integer.toString(format.bitrate));
                this.f.setMeasurement(Definitions$Measurement.SEGMENT_PROFILE_BITRATE, format.bitrate / 1000);
            }
        }
        AgamaIntegration agamaIntegration2 = this.f;
        if (agamaIntegration2 != null) {
            agamaIntegration2.setMeasurement(Definitions$Measurement.BYTES_RECEIVED, j5);
            this.f.updatePlayerPosition();
        }
    }

    @Override // com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener, com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
    public void onLoadError(IOException iOException) {
        a("loadError", iOException);
    }

    @Override // com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener
    public void onLoadStarted(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onLoadingChanged(boolean z) {
        LogEx.d("EventLogger", "loading [" + z + "]");
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataOutput
    public void onMetadata(Metadata metadata) {
        LogEx.d("EventLogger", "onMetadata [");
        a(metadata, "  ");
        LogEx.d("EventLogger", "]");
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        LogEx.e("EventLogger", "playerFailed [" + a() + "]" + exoPlaybackException.getMessage());
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(String str, String str2) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(boolean z, int i) {
        LogEx.d("EventLogger", "state [" + a() + ", " + z + ", " + a(i) + "]");
        if (i == 1) {
            LogEx.d("EventLogger", "Playback[STATE]: idle");
            AgamaIntegration agamaIntegration = this.f;
            if (agamaIntegration != null) {
                agamaIntegration.setViewState(0, null, null);
                return;
            }
            return;
        }
        if (i == 2) {
            LogEx.d("EventLogger", "Playback[STATE]: Buffering");
            AgamaIntegration agamaIntegration2 = this.f;
            if (agamaIntegration2 != null) {
                agamaIntegration2.setViewState(8, null, null);
                return;
            }
            return;
        }
        if (i != 3) {
            if (i != 4) {
                return;
            }
            LogEx.d("EventLogger", "End of file");
            AgamaIntegration agamaIntegration3 = this.f;
            if (agamaIntegration3 != null) {
                agamaIntegration3.setViewState(5, "session/endOfStreamReached", "");
                return;
            }
            return;
        }
        if (z) {
            LogEx.d("EventLogger", "Playback[STATE]: Playing");
            AgamaIntegration agamaIntegration4 = this.f;
            if (agamaIntegration4 != null) {
                agamaIntegration4.setViewState(3, null, null);
                return;
            }
            return;
        }
        LogEx.d("EventLogger", "Playback[STATE]: Paused");
        AgamaIntegration agamaIntegration5 = this.f;
        if (agamaIntegration5 != null) {
            agamaIntegration5.setViewState(4, "session/userAction", "");
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPositionDiscontinuity(int i) {
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onRenderedFirstFrame(Surface surface) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onRepeatModeChanged(int i) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onSeekProcessed() {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onSeektoTimeShift(boolean z) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onShuffleModeEnabledChanged(boolean z) {
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTimelineChanged(Timeline timeline, Object obj) {
        if (timeline == null) {
            return;
        }
        int periodCount = timeline.getPeriodCount();
        int windowCount = timeline.getWindowCount();
        LogEx.d("EventLogger", "sourceInfo [periodCount=" + periodCount + ", windowCount=" + windowCount);
        for (int i = 0; i < Math.min(periodCount, 3); i++) {
            timeline.getPeriod(i, this.f3346d);
            LogEx.d("EventLogger", "  period [" + a(this.f3346d.getDurationMs()) + "]");
        }
        if (periodCount > 3) {
            LogEx.d("EventLogger", "  ...");
        }
        for (int i2 = 0; i2 < Math.min(windowCount, 3); i2++) {
            timeline.getWindow(i2, this.f3345c);
            LogEx.d("EventLogger", "  window [" + a(this.f3345c.getDurationMs()) + ", " + this.f3345c.isSeekable + ", " + this.f3345c.isDynamic + "]");
        }
        if (windowCount > 3) {
            LogEx.d("EventLogger", "  ...");
        }
        LogEx.d("EventLogger", "]");
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        EventLogger eventLogger;
        EventLogger eventLogger2 = this;
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = eventLogger2.f3344b.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo == null) {
            LogEx.d("EventLogger", "Tracks []");
            return;
        }
        LogEx.d("EventLogger", "Tracks [");
        int i = 0;
        while (true) {
            String str = "  ]";
            String str2 = " [";
            if (i >= currentMappedTrackInfo.length) {
                break;
            }
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i);
            TrackSelection trackSelection = trackSelectionArray.get(i);
            if (trackGroups.length > 0) {
                LogEx.d("EventLogger", "  Renderer:" + i + " [");
                int i2 = 0;
                while (i2 < trackGroups.length) {
                    TrackGroup trackGroup = trackGroups.get(i2);
                    TrackGroupArray trackGroupArray2 = trackGroups;
                    String str3 = str;
                    LogEx.d("EventLogger", "    Group:" + i2 + ", adaptive_supported=" + a(trackGroup.length, currentMappedTrackInfo.getAdaptiveSupport(i, i2, false)) + str2);
                    int i3 = 0;
                    while (i3 < trackGroup.length) {
                        LogEx.d("EventLogger", "      " + a(trackSelection, trackGroup, i3) + " Track:" + i3 + ", " + Format.toLogString(trackGroup.getFormat(i3)) + ", supported=" + b(currentMappedTrackInfo.getTrackFormatSupport(i, i2, i3)));
                        i3++;
                        str2 = str2;
                    }
                    LogEx.d("EventLogger", "    ]");
                    i2++;
                    trackGroups = trackGroupArray2;
                    str = str3;
                }
                String str4 = str;
                if (trackSelection != null) {
                    for (int i4 = 0; i4 < trackSelection.length(); i4++) {
                        Metadata metadata = trackSelection.getFormat(i4).metadata;
                        if (metadata != null) {
                            LogEx.d("EventLogger", "    Metadata [");
                            eventLogger = this;
                            eventLogger.a(metadata, "      ");
                            LogEx.d("EventLogger", "    ]");
                            break;
                        }
                    }
                }
                eventLogger = this;
                LogEx.d("EventLogger", str4);
            } else {
                eventLogger = eventLogger2;
            }
            i++;
            eventLogger2 = eventLogger;
        }
        String str5 = " [";
        TrackGroupArray unassociatedTrackGroups = currentMappedTrackInfo.getUnassociatedTrackGroups();
        if (unassociatedTrackGroups.length > 0) {
            LogEx.d("EventLogger", "  Renderer:None [");
            int i5 = 0;
            while (i5 < unassociatedTrackGroups.length) {
                StringBuilder sb = new StringBuilder();
                sb.append("    Group:");
                sb.append(i5);
                String str6 = str5;
                sb.append(str6);
                LogEx.d("EventLogger", sb.toString());
                TrackGroup trackGroup2 = unassociatedTrackGroups.get(i5);
                int i6 = 0;
                while (i6 < trackGroup2.length) {
                    TrackGroupArray trackGroupArray3 = unassociatedTrackGroups;
                    LogEx.d("EventLogger", "      " + a(false) + " Track:" + i6 + ", " + Format.toLogString(trackGroup2.getFormat(i6)) + ", supported=" + b(0));
                    i6++;
                    unassociatedTrackGroups = trackGroupArray3;
                }
                LogEx.d("EventLogger", "    ]");
                i5++;
                str5 = str6;
            }
            LogEx.d("EventLogger", "  ]");
        }
        LogEx.d("EventLogger", "]");
    }

    @Override // com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener
    public void onUpstreamDiscarded(int i, long j, long j2) {
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoDecoderInitialized(String str, long j, long j2) {
        LogEx.d("EventLogger", "videoDecoderInitialized [" + a() + ", " + str + "]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoDisabled(DecoderCounters decoderCounters) {
        LogEx.d("EventLogger", "videoDisabled [" + a() + "]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoEnabled(DecoderCounters decoderCounters) {
        LogEx.d("EventLogger", "videoEnabled [" + a() + "]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoInputFormatChanged(Format format) {
        b.a().put("lastbitrate", String.valueOf(format.bitrate));
        LogEx.d("EventLogger", "videoFormatChanged [" + a() + ", " + Format.toLogString(format) + "]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
    }

    public void setAgamaIntegration(AgamaIntegration agamaIntegration) {
        this.f = agamaIntegration;
    }

    public void vodMsgReport(String str) {
    }

    private void a(Metadata metadata, String str) {
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                LogEx.d("EventLogger", str + String.format("%s: value=%s", textInformationFrame.id, textInformationFrame.value));
            } else if (entry instanceof UrlLinkFrame) {
                UrlLinkFrame urlLinkFrame = (UrlLinkFrame) entry;
                LogEx.d("EventLogger", str + String.format("%s: url=%s", urlLinkFrame.id, urlLinkFrame.url));
            } else if (entry instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) entry;
                LogEx.d("EventLogger", str + String.format("%s: owner=%s", privFrame.id, privFrame.owner));
            } else if (entry instanceof GeobFrame) {
                GeobFrame geobFrame = (GeobFrame) entry;
                LogEx.d("EventLogger", str + String.format("%s: mimeType=%s, filename=%s, description=%s", geobFrame.id, geobFrame.mimeType, geobFrame.filename, geobFrame.description));
            } else if (entry instanceof ApicFrame) {
                ApicFrame apicFrame = (ApicFrame) entry;
                LogEx.d("EventLogger", str + String.format("%s: mimeType=%s, description=%s", apicFrame.id, apicFrame.mimeType, apicFrame.description));
            } else if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                LogEx.d("EventLogger", str + String.format("%s: language=%s, description=%s", commentFrame.id, commentFrame.language, commentFrame.description));
            } else if (entry instanceof Id3Frame) {
                LogEx.d("EventLogger", str + String.format("%s", ((Id3Frame) entry).id));
            } else if (entry instanceof EventMessage) {
                EventMessage eventMessage = (EventMessage) entry;
                LogEx.d("EventLogger", str + String.format("EMSG: scheme=%s, id=%d, value=%s", eventMessage.schemeIdUri, Long.valueOf(eventMessage.id), eventMessage.value));
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener
    public void onLoadError(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
        a("loadError", iOException);
        AgamaIntegration agamaIntegration = this.f;
        if (agamaIntegration != null) {
            agamaIntegration.setMeasurement(Definitions$Measurement.BYTES_RECEIVED, j5);
        }
    }

    private String a() {
        return a(SystemClock.elapsedRealtime() - this.e);
    }

    private static String a(long j) {
        return j == C.TIME_UNSET ? "?" : f3343a.format(((float) j) / 1000.0f);
    }

    private static String a(TrackSelection trackSelection, TrackGroup trackGroup, int i) {
        return a((trackSelection == null || trackSelection.getTrackGroup() == null || !trackSelection.getTrackGroup().equals(trackGroup) || trackSelection.indexOf(i) == -1) ? false : true);
    }
}
