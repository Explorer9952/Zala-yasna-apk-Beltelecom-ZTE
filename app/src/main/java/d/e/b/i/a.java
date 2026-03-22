package d.e.b.i;

import com.zte.ucs.tvcall.ocx.nabst.NabstAddContactResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstAddUserPrefResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstCompareDirectoryResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstContactNodeInDirectory;
import com.zte.ucs.tvcall.ocx.nabst.NabstDeleteContactResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstDeleteUserPrefResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstGetDirectoryResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstGroupMsgDndListOperationResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstLoadContactResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstLoadUserPrefResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstLocalEtagSynNotify;
import com.zte.ucs.tvcall.ocx.nabst.NabstSingMsgDndListOperationResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactAddressResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactBirthdayResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactCommAddrResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactGroupInfoResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactNameResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactNoteResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactOrgNameResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserCallingSettingResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserContactsSettingResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserExtendSettingResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserMsgDndSettingResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserMsgNotifySettingResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserMsgPlayModSettingResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserMsgReminSettingResp;

/* loaded from: classes2.dex */
public interface a {
    void a(NabstAddContactResp nabstAddContactResp);

    void a(NabstAddUserPrefResp nabstAddUserPrefResp);

    void a(NabstCompareDirectoryResp nabstCompareDirectoryResp, NabstContactNodeInDirectory[] nabstContactNodeInDirectoryArr);

    void a(NabstDeleteContactResp nabstDeleteContactResp);

    void a(NabstDeleteUserPrefResp nabstDeleteUserPrefResp);

    void a(NabstGetDirectoryResp nabstGetDirectoryResp, NabstContactNodeInDirectory[] nabstContactNodeInDirectoryArr);

    void a(NabstGroupMsgDndListOperationResp nabstGroupMsgDndListOperationResp);

    void a(NabstLoadContactResp nabstLoadContactResp);

    void a(NabstLoadUserPrefResp nabstLoadUserPrefResp);

    void a(NabstLocalEtagSynNotify nabstLocalEtagSynNotify);

    void a(NabstSingMsgDndListOperationResp nabstSingMsgDndListOperationResp);

    void a(NabstUpLoadContactAddressResp nabstUpLoadContactAddressResp);

    void a(NabstUpLoadContactBirthdayResp nabstUpLoadContactBirthdayResp);

    void a(NabstUpLoadContactCommAddrResp nabstUpLoadContactCommAddrResp);

    void a(NabstUpLoadContactGroupInfoResp nabstUpLoadContactGroupInfoResp);

    void a(NabstUpLoadContactNameResp nabstUpLoadContactNameResp);

    void a(NabstUpLoadContactNoteResp nabstUpLoadContactNoteResp);

    void a(NabstUpLoadContactOrgNameResp nabstUpLoadContactOrgNameResp);

    void a(NabstUpLoadContactResp nabstUpLoadContactResp);

    void a(NabstUpLoadUserCallingSettingResp nabstUpLoadUserCallingSettingResp);

    void a(NabstUpLoadUserContactsSettingResp nabstUpLoadUserContactsSettingResp);

    void a(NabstUpLoadUserExtendSettingResp nabstUpLoadUserExtendSettingResp);

    void a(NabstUpLoadUserMsgDndSettingResp nabstUpLoadUserMsgDndSettingResp);

    void a(NabstUpLoadUserMsgNotifySettingResp nabstUpLoadUserMsgNotifySettingResp);

    void a(NabstUpLoadUserMsgPlayModSettingResp nabstUpLoadUserMsgPlayModSettingResp);

    void a(NabstUpLoadUserMsgReminSettingResp nabstUpLoadUserMsgReminSettingResp);
}
