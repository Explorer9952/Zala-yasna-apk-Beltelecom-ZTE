package tv.agama.emp.client;

import tv.agama.emp.client.a.b;
import tv.agama.emp.client.exception.AgamaException;

/* loaded from: classes2.dex */
public final class EMPClient {
    public EMPClient(String str, Definitions$LogLevel definitions$LogLevel) throws AgamaException {
        a(str, definitions$LogLevel);
    }

    private void a(String str, Definitions$LogLevel definitions$LogLevel) throws AgamaException, IllegalArgumentException {
        if (clientInit(definitions$LogLevel.ordinal())) {
            a(str);
            return;
        }
        throw new AgamaException("EMPClient was unable to initialize.");
    }

    private native void clientAbrSession(String str, int i, String str2, int i2, int i3);

    private native void clientExitSession();

    private native boolean clientInit(int i);

    private native void clientSetDeviceMetadata(int i, String str);

    private native boolean clientSetExternalConfig(String str);

    private native void clientSetMeasurement(int i, long j);

    private native void clientSetSessionMetadata(int i, int i2);

    private native void clientSetSessionMetadata(int i, String str);

    private native void clientShutdown(int i);

    private native void clientViewStateChanged(int i);

    private native void clientViewStateExtended(int i, String str, String str2);

    public void a(String str, Definitions$DsProtocol definitions$DsProtocol, String str2, Definitions$DsPlaylistType definitions$DsPlaylistType, Definitions$ViewStates definitions$ViewStates) throws IllegalArgumentException {
        if (str != null && definitions$DsProtocol != null && str2 != null && definitions$DsPlaylistType != null && definitions$ViewStates != null) {
            clientAbrSession(str, b.a(definitions$DsProtocol), str2, b.a(definitions$DsPlaylistType), b.a(definitions$ViewStates));
            return;
        }
        throw new IllegalArgumentException("Not all arguments specified.");
    }

    public void a() {
        clientExitSession();
    }

    public void a(String str) throws AgamaException, IllegalArgumentException {
        if (str != null) {
            if (clientSetExternalConfig(str)) {
                return;
            }
            throw new AgamaException("Config string is invalid: " + str);
        }
        throw new IllegalArgumentException("Config string not specified.");
    }

    public void a(Definitions$Measurement definitions$Measurement, long j) throws IllegalArgumentException {
        if (definitions$Measurement != null) {
            clientSetMeasurement(b.a(definitions$Measurement), j);
            return;
        }
        throw new IllegalArgumentException("Type not specified.");
    }

    public void a(Definitions$DeviceMetadata definitions$DeviceMetadata, String str) throws IllegalArgumentException {
        if (definitions$DeviceMetadata != null && str != null) {
            clientSetDeviceMetadata(b.a(definitions$DeviceMetadata), str);
            return;
        }
        throw new IllegalArgumentException("Not all arguments specified.");
    }

    public void a(Definitions$SessionMetadata definitions$SessionMetadata, String str) throws IllegalArgumentException {
        if (definitions$SessionMetadata != null && str != null) {
            clientSetSessionMetadata(b.a(definitions$SessionMetadata), str);
            return;
        }
        throw new IllegalArgumentException("Not all arguments specified.");
    }

    public void a(Definitions$SessionMetadata definitions$SessionMetadata, int i) throws IllegalArgumentException {
        if (definitions$SessionMetadata != null && i >= 0) {
            clientSetSessionMetadata(b.a(definitions$SessionMetadata), i);
            return;
        }
        throw new IllegalArgumentException("Not all arguments specified.");
    }

    public void a(Definitions$ShutdownType definitions$ShutdownType) throws IllegalArgumentException {
        if (definitions$ShutdownType != null) {
            clientShutdown(b.a(definitions$ShutdownType));
            return;
        }
        throw new IllegalArgumentException("Type not specified.");
    }

    public void a(Definitions$ViewStates definitions$ViewStates) throws IllegalArgumentException {
        if (definitions$ViewStates != null) {
            clientViewStateChanged(b.a(definitions$ViewStates));
            return;
        }
        throw new IllegalArgumentException("View State not specified.");
    }

    public void a(Definitions$ViewStates definitions$ViewStates, String str, String str2) throws IllegalArgumentException {
        if (definitions$ViewStates != null && str != null && str2 != null) {
            clientViewStateExtended(b.a(definitions$ViewStates), str, str2);
            return;
        }
        throw new IllegalArgumentException("Not all arguments specified.");
    }
}
