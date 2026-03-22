package com.video.androidsdk.download.Linstener;

import com.video.androidsdk.download.bean.DownloadTask;
import java.util.ArrayList;

/* loaded from: classes.dex */
public interface DownloadListReturnListener extends IDownloadListener {
    void returnDownloadTaskList(String str, int i, String str2, ArrayList<DownloadTask> arrayList);
}
