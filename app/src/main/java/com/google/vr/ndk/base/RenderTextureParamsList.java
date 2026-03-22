package com.google.vr.ndk.base;

import com.google.protobuf.nano.MessageNano;
import com.google.vr.ndk.base.proto.nano.GvrApiData;

/* loaded from: classes.dex */
public class RenderTextureParamsList {
    private final RenderTextureParams[] renderTextureParamsList;

    public RenderTextureParamsList(GvrApiData.RenderTextureParamsListData renderTextureParamsListData) {
        this.renderTextureParamsList = new RenderTextureParams[renderTextureParamsListData.paramsData.length];
        int i = 0;
        while (true) {
            GvrApiData.RenderTextureParamsListData.RenderTextureParamsData[] renderTextureParamsDataArr = renderTextureParamsListData.paramsData;
            if (i >= renderTextureParamsDataArr.length) {
                return;
            }
            this.renderTextureParamsList[i] = new RenderTextureParams(renderTextureParamsDataArr[i]);
            i++;
        }
    }

    public int count() {
        return this.renderTextureParamsList.length;
    }

    public RenderTextureParams getRenderTextureParams(int i) {
        return this.renderTextureParamsList[i];
    }

    public byte[] toByteArray() {
        return MessageNano.toByteArray(toProtobuf());
    }

    public GvrApiData.RenderTextureParamsListData toProtobuf() {
        GvrApiData.RenderTextureParamsListData renderTextureParamsListData = new GvrApiData.RenderTextureParamsListData();
        renderTextureParamsListData.paramsData = new GvrApiData.RenderTextureParamsListData.RenderTextureParamsData[this.renderTextureParamsList.length];
        for (int i = 0; i < this.renderTextureParamsList.length; i++) {
            renderTextureParamsListData.paramsData[i] = new GvrApiData.RenderTextureParamsListData.RenderTextureParamsData().setNativePtr(this.renderTextureParamsList[i].getNativePtr());
        }
        return renderTextureParamsListData;
    }
}
