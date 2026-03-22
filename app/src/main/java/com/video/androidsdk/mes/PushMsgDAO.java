package com.video.androidsdk.mes;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.video.androidsdk.b.a;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.mes.bean.MsgInfo;
import com.video.androidsdk.service.comm.ParamConst;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PushMsgDAO extends a {
    private String mAccount;

    public PushMsgDAO(SQLiteOpenHelper sQLiteOpenHelper) {
        super(sQLiteOpenHelper, "push_msginfo");
        this.mAccount = SDKLoginMgr.getInstance().getUserID();
    }

    private MsgInfo getMessageInfo(Cursor cursor) {
        MsgInfo msgInfo = new MsgInfo();
        int columnIndex = cursor.getColumnIndex("time_stamp");
        msgInfo.timestamp = columnIndex == -1 ? "" : cursor.getString(columnIndex);
        int columnIndex2 = cursor.getColumnIndex("msg_id");
        msgInfo.msgid = columnIndex2 == -1 ? "" : cursor.getString(columnIndex2);
        int columnIndex3 = cursor.getColumnIndex("msg_type");
        msgInfo.msgType = columnIndex3 == -1 ? "" : cursor.getString(columnIndex3);
        int columnIndex4 = cursor.getColumnIndex("msg_cnt_type");
        msgInfo.msgCntType = columnIndex4 == -1 ? "" : cursor.getString(columnIndex4);
        int columnIndex5 = cursor.getColumnIndex("msg_content");
        msgInfo.msgContent = columnIndex5 == -1 ? "" : cursor.getString(columnIndex5);
        int columnIndex6 = cursor.getColumnIndex("summary");
        msgInfo.summary = columnIndex6 == -1 ? "" : cursor.getString(columnIndex6);
        int columnIndex7 = cursor.getColumnIndex("title_icon_url");
        msgInfo.titleIconUrl = columnIndex7 == -1 ? "" : cursor.getString(columnIndex7);
        int columnIndex8 = cursor.getColumnIndex("isread");
        msgInfo.isRead = columnIndex8 == -1 ? "" : cursor.getString(columnIndex8);
        int columnIndex9 = cursor.getColumnIndex("msg_from");
        msgInfo.msgFrom = columnIndex9 == -1 ? "" : cursor.getString(columnIndex9);
        int columnIndex10 = cursor.getColumnIndex("msg_title");
        msgInfo.msgTitle = columnIndex10 == -1 ? "" : cursor.getString(columnIndex10);
        int columnIndex11 = cursor.getColumnIndex("service_type");
        msgInfo.serviceType = columnIndex11 == -1 ? "" : cursor.getString(columnIndex11);
        int columnIndex12 = cursor.getColumnIndex("oper_type");
        msgInfo.operType = columnIndex12 == -1 ? "" : cursor.getString(columnIndex12);
        int columnIndex13 = cursor.getColumnIndex("msg_serv_type");
        msgInfo.msgServType = columnIndex13 == -1 ? "" : cursor.getString(columnIndex13);
        int columnIndex14 = cursor.getColumnIndex("msg_bind_type");
        msgInfo.msgBindType = columnIndex14 == -1 ? "" : cursor.getString(columnIndex14);
        int columnIndex15 = cursor.getColumnIndex("msg_show_type");
        msgInfo.msgShowType = columnIndex15 == -1 ? "" : cursor.getString(columnIndex15);
        int columnIndex16 = cursor.getColumnIndex(ParamConst.LIMIT_LIST_RSP_POSITION);
        msgInfo.position = columnIndex16 == -1 ? "" : cursor.getString(columnIndex16);
        int columnIndex17 = cursor.getColumnIndex("file_url");
        msgInfo.fileUrl = columnIndex17 == -1 ? "" : cursor.getString(columnIndex17);
        int columnIndex18 = cursor.getColumnIndex("show_mode");
        msgInfo.showMode = columnIndex18 == -1 ? "" : cursor.getString(columnIndex18);
        int columnIndex19 = cursor.getColumnIndex("serv_param");
        msgInfo.servParam = columnIndex19 != -1 ? cursor.getString(columnIndex19) : "";
        return msgInfo;
    }

    private ArrayList<MsgInfo> parseCursor(Cursor cursor) {
        ArrayList<MsgInfo> arrayList = new ArrayList<>();
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                arrayList.add(getMessageInfo(cursor));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return arrayList;
    }

    public long addMessage(MsgInfo msgInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("time_stamp", msgInfo.timestamp);
        contentValues.put("msg_id", msgInfo.msgid);
        contentValues.put("msg_type", msgInfo.msgType);
        contentValues.put("msg_cnt_type", msgInfo.msgCntType);
        contentValues.put("msg_content", msgInfo.msgContent);
        contentValues.put("summary", msgInfo.summary);
        contentValues.put("title_icon_url", msgInfo.titleIconUrl);
        contentValues.put("isread", msgInfo.isRead);
        contentValues.put("msg_from", msgInfo.msgFrom);
        contentValues.put("msg_title", msgInfo.msgTitle);
        contentValues.put("service_type", msgInfo.serviceType);
        contentValues.put("oper_type", msgInfo.operType);
        contentValues.put("msg_serv_type", msgInfo.msgServType);
        contentValues.put("msg_bind_type", msgInfo.msgBindType);
        contentValues.put("msg_show_type", msgInfo.msgShowType);
        contentValues.put(ParamConst.LIMIT_LIST_RSP_POSITION, msgInfo.position);
        contentValues.put("file_url", msgInfo.fileUrl);
        contentValues.put("show_mode", msgInfo.showMode);
        contentValues.put("serv_param", msgInfo.servParam);
        contentValues.put("account", this.mAccount);
        return insert(contentValues);
    }

    public int deleteAllMsg() {
        return delete("account = ?", new String[]{this.mAccount});
    }

    public int deleteMsgById(String str) {
        if (str != null) {
            return delete("msg_id = ? and account = ?", new String[]{str, this.mAccount});
        }
        return -1;
    }

    public int getUnReadMsgCount(String str) {
        int i = 0;
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            try {
                cursor = this.mDBHelper.getWritableDatabase().rawQuery("select count(*) from push_msginfo where isread ='0' and account = '" + this.mAccount + "' and msg_type = ?", strArr);
                if (cursor.moveToNext()) {
                    i = cursor.getInt(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return i;
        } finally {
            cursor.close();
        }
    }

    public ArrayList<MsgInfo> queryAllMsg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return parseCursor(query(null, "msg_type = ? and account = ?", new String[]{str, this.mAccount}, null));
    }

    public MsgInfo queryLastMessageByTime() {
        MsgInfo msgInfo;
        Throwable th;
        Cursor cursor;
        MsgInfo msgInfo2 = null;
        msgInfo2 = null;
        msgInfo2 = null;
        Cursor cursor2 = null;
        try {
            try {
                cursor = this.mDBHelper.getWritableDatabase().rawQuery("select * from push_msginfo where  time_stamp = (select max(time_stamp) from push_msginfo where account = '" + this.mAccount + "') and account = '" + this.mAccount + "'", null);
            } catch (Throwable th2) {
                MsgInfo msgInfo3 = msgInfo2;
                th = th2;
                cursor = msgInfo3;
            }
        } catch (SQLiteException e) {
            e = e;
            msgInfo = null;
        }
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                msgInfo2 = getMessageInfo(cursor);
                cursor.moveToNext();
            }
            cursor.close();
        } catch (SQLiteException e2) {
            e = e2;
            MsgInfo msgInfo4 = msgInfo2;
            cursor2 = cursor;
            msgInfo = msgInfo4;
            e.printStackTrace();
            cursor2.close();
            msgInfo2 = msgInfo;
            return msgInfo2;
        } catch (Throwable th3) {
            th = th3;
            cursor.close();
            throw th;
        }
        return msgInfo2;
    }

    public int updateMsgStatus(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("isread", "1");
        return update(contentValues, "msg_id = ? and account = ?", new String[]{str, this.mAccount});
    }
}
