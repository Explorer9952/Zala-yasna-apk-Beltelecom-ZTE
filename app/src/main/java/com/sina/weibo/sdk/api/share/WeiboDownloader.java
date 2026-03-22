package com.sina.weibo.sdk.api.share;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.Utility;

/* loaded from: classes.dex */
public class WeiboDownloader {
    private static final String CANCEL_CHINESS = "以后再说";
    private static final String CANCEL_ENGLISH = "Download Later";
    private static final String OK_CHINESS = "现在下载";
    private static final String OK_ENGLISH = "Download Now";
    private static final String PROMPT_CHINESS = "未安装微博客户端，是否现在去下载？";
    private static final String PROMPT_ENGLISH = "Sina Weibo client is not installed, download now?";
    private static final String TITLE_CHINESS = "提示";
    private static final String TITLE_ENGLISH = "Notice";

    public static Dialog createDownloadConfirmDialog(final Context context, final IWeiboDownloadListener iWeiboDownloadListener) {
        String str;
        String str2;
        String str3;
        String str4;
        if (Utility.isChineseLocale(context.getApplicationContext())) {
            str = TITLE_CHINESS;
            str2 = PROMPT_CHINESS;
            str3 = OK_CHINESS;
            str4 = CANCEL_CHINESS;
        } else {
            str = TITLE_ENGLISH;
            str2 = PROMPT_ENGLISH;
            str3 = OK_ENGLISH;
            str4 = CANCEL_ENGLISH;
        }
        return new AlertDialog.Builder(context).setMessage(str2).setTitle(str).setPositiveButton(str3, new DialogInterface.OnClickListener() { // from class: com.sina.weibo.sdk.api.share.WeiboDownloader.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                WeiboDownloader.downloadWeibo(context);
            }
        }).setNegativeButton(str4, new DialogInterface.OnClickListener() { // from class: com.sina.weibo.sdk.api.share.WeiboDownloader.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IWeiboDownloadListener iWeiboDownloadListener2 = IWeiboDownloadListener.this;
                if (iWeiboDownloadListener2 != null) {
                    iWeiboDownloadListener2.onCancel();
                }
            }
        }).create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void downloadWeibo(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(WBConstants.WEIBO_DOWNLOAD_URL));
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
