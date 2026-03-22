package com.video.androidsdk.common;

import android.os.AsyncTask;

/* loaded from: classes.dex */
public class AsyncTaskEx extends AsyncTask<Integer, Integer, Integer> {
    private int m_iWorkType;
    private IAsyncTaskEx m_instanceIAsyncTaskEx;

    /* loaded from: classes.dex */
    public interface IAsyncTaskEx {
        int onDoOperation(int i);

        int onDoOperationFinish(int i, int i2);

        void onUpdateProgress(Integer... numArr);
    }

    public AsyncTaskEx(IAsyncTaskEx iAsyncTaskEx, int i) {
        this.m_instanceIAsyncTaskEx = null;
        this.m_iWorkType = 0;
        this.m_instanceIAsyncTaskEx = iAsyncTaskEx;
        this.m_iWorkType = i;
        execute(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Integer doInBackground(Integer... numArr) {
        IAsyncTaskEx iAsyncTaskEx = this.m_instanceIAsyncTaskEx;
        if (iAsyncTaskEx == null) {
            return 0;
        }
        return Integer.valueOf(iAsyncTaskEx.onDoOperation(this.m_iWorkType));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Integer num) {
        IAsyncTaskEx iAsyncTaskEx = this.m_instanceIAsyncTaskEx;
        if (iAsyncTaskEx != null) {
            iAsyncTaskEx.onDoOperationFinish(this.m_iWorkType, num.intValue());
        }
        super.onPostExecute((AsyncTaskEx) num);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate((Object[]) numArr);
    }
}
