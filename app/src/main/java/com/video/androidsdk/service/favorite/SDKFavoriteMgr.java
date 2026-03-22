package com.video.androidsdk.service.favorite;

import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKFavoriteMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3611a;

    /* loaded from: classes.dex */
    public interface OnAddFavoriteDirReturnListener {
        void onAddFavoriteDirReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnAddFavoriteReturnListener {
        void onAddFavoriteReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnCheckIsFavoritedReturnListener {
        void onCheckIsFavoritedReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnDelFavoriteDirReturnListener {
        void onDelFavoriteDirReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnDelFavoriteReturnListener {
        void onDelFavoriteReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnRenameFavoriteDirReturnListener {
        void onRenameFavoriteDirReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnUserFavoriteDirListReturnListener {
        void onUserFavoriteDirListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnUserFavoriteListReturnListener {
        void onUserFavoriteListReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3611a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void checkIsFavorited(HashMap<String, String> hashMap, final OnCheckIsFavoritedReturnListener onCheckIsFavoritedReturnListener) {
        if (onCheckIsFavoritedReturnListener == null) {
            LogEx.w("SDKFavoriteMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKFavoriteMgr", "params == null");
            onCheckIsFavoritedReturnListener.onCheckIsFavoritedReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 2, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.CHECK_IS_FAVORITED);
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3611a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.favorite.SDKFavoriteMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onCheckIsFavoritedReturnListener.onCheckIsFavoritedReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKFavoriteMgr", "JSONException occur");
                    onCheckIsFavoritedReturnListener.onCheckIsFavoritedReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKFavoriteMgr", "SDKNetHTTPRequest onFailReturn");
                onCheckIsFavoritedReturnListener.onCheckIsFavoritedReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }

    public void doAddFavorite(HashMap<String, String> hashMap, final OnAddFavoriteReturnListener onAddFavoriteReturnListener) {
        if (onAddFavoriteReturnListener == null) {
            LogEx.w("SDKFavoriteMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKFavoriteMgr", "params == null");
            onAddFavoriteReturnListener.onAddFavoriteReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 3, 2)), ErrMessage.PARAM_IS_NULL);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_ADD_FAVORITE);
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3611a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.favorite.SDKFavoriteMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onAddFavoriteReturnListener.onAddFavoriteReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKFavoriteMgr", "JSONException occur");
                    onAddFavoriteReturnListener.onAddFavoriteReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 3, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKFavoriteMgr", "SDKNetHTTPRequest onFailReturn");
                onAddFavoriteReturnListener.onAddFavoriteReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 3, i % 1000)), str);
            }
        });
    }

    public void doAddFavoriteDir(HashMap<String, String> hashMap, final OnAddFavoriteDirReturnListener onAddFavoriteDirReturnListener) {
        if (onAddFavoriteDirReturnListener == null) {
            LogEx.w("SDKFavoriteMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKFavoriteMgr", "params == null");
            onAddFavoriteDirReturnListener.onAddFavoriteDirReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 6, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_ADD_FAVORITE_DIR);
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3611a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.favorite.SDKFavoriteMgr.6
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onAddFavoriteDirReturnListener.onAddFavoriteDirReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKFavoriteMgr", "JSONException occur");
                    onAddFavoriteDirReturnListener.onAddFavoriteDirReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 6, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKFavoriteMgr", "SDKNetHTTPRequest onFailReturn");
                onAddFavoriteDirReturnListener.onAddFavoriteDirReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 6, i % 1000)), str, null);
            }
        });
    }

    public void doDelFavorite(HashMap<String, String> hashMap, final OnDelFavoriteReturnListener onDelFavoriteReturnListener) {
        if (onDelFavoriteReturnListener == null) {
            LogEx.w("SDKFavoriteMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKFavoriteMgr", "params == null");
            onDelFavoriteReturnListener.onDelFavoriteReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 4, 2)), ErrMessage.PARAM_IS_NULL);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.DO_DEL_FAVORITE);
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3611a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.favorite.SDKFavoriteMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onDelFavoriteReturnListener.onDelFavoriteReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKFavoriteMgr", "JSONException occur");
                    onDelFavoriteReturnListener.onDelFavoriteReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 4, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKFavoriteMgr", "SDKNetHTTPRequest onFailReturn");
                onDelFavoriteReturnListener.onDelFavoriteReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 4, i % 1000)), str);
            }
        });
    }

    public void doDelFavoriteDir(HashMap<String, String> hashMap, final OnDelFavoriteDirReturnListener onDelFavoriteDirReturnListener) {
        if (onDelFavoriteDirReturnListener == null) {
            LogEx.w("SDKFavoriteMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKFavoriteMgr", "params == null");
            onDelFavoriteDirReturnListener.onDelFavoriteDirReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 7, 2)), ErrMessage.PARAM_IS_NULL);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_DEL_FAVORITE_DIR);
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3611a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.favorite.SDKFavoriteMgr.7
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onDelFavoriteDirReturnListener.onDelFavoriteDirReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKFavoriteMgr", "JSONException occur");
                    onDelFavoriteDirReturnListener.onDelFavoriteDirReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 7, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKFavoriteMgr", "SDKNetHTTPRequest onFailReturn");
                onDelFavoriteDirReturnListener.onDelFavoriteDirReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 7, i % 1000)), str);
            }
        });
    }

    public void doRenameFavoriteDir(HashMap<String, String> hashMap, final OnRenameFavoriteDirReturnListener onRenameFavoriteDirReturnListener) {
        if (onRenameFavoriteDirReturnListener == null) {
            LogEx.w("SDKFavoriteMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKFavoriteMgr", "params == null");
            onRenameFavoriteDirReturnListener.onRenameFavoriteDirReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 8, 2)), ErrMessage.PARAM_IS_NULL);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_RENAME_FAVORITE_DIR);
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3611a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.favorite.SDKFavoriteMgr.8
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onRenameFavoriteDirReturnListener.onRenameFavoriteDirReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKFavoriteMgr", "JSONException occur");
                    onRenameFavoriteDirReturnListener.onRenameFavoriteDirReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 8, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKFavoriteMgr", "SDKNetHTTPRequest onFailReturn");
                onRenameFavoriteDirReturnListener.onRenameFavoriteDirReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 8, i % 1000)), str);
            }
        });
    }

    public void getUserFavoriteDirList(HashMap<String, String> hashMap, final OnUserFavoriteDirListReturnListener onUserFavoriteDirListReturnListener) {
        if (onUserFavoriteDirListReturnListener == null) {
            LogEx.w("SDKFavoriteMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKFavoriteMgr", "params == null");
            onUserFavoriteDirListReturnListener.onUserFavoriteDirListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 5, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_USER_FAVORITE_DIR_LIST);
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3611a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.favorite.SDKFavoriteMgr.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUserFavoriteDirListReturnListener.onUserFavoriteDirListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKFavoriteMgr", "JSONException occur");
                    onUserFavoriteDirListReturnListener.onUserFavoriteDirListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 5, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKFavoriteMgr", "SDKNetHTTPRequest onFailReturn");
                onUserFavoriteDirListReturnListener.onUserFavoriteDirListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 5, i % 1000)), str, null);
            }
        });
    }

    public void getUserFavoriteList(HashMap<String, String> hashMap, final OnUserFavoriteListReturnListener onUserFavoriteListReturnListener) {
        if (onUserFavoriteListReturnListener == null) {
            LogEx.w("SDKFavoriteMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_USER_FAVORITE_LIST);
        if (hashMap != null) {
            sb.append("?");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                sb.append((Object) key);
                sb.append("=");
                sb.append((Object) value);
                sb.append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3611a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.favorite.SDKFavoriteMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUserFavoriteListReturnListener.onUserFavoriteListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKFavoriteMgr", "JSONException occur");
                    onUserFavoriteListReturnListener.onUserFavoriteListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKFavoriteMgr", "SDKNetHTTPRequest onFailReturn");
                onUserFavoriteListReturnListener.onUserFavoriteListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_FAVORITE_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }
}
