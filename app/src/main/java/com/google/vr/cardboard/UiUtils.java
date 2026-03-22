package com.google.vr.cardboard;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class UiUtils {
    private static final String CARDBOARD_CONFIGURE_ACTION = "com.google.vrtoolkit.cardboard.CONFIGURE";
    private static final String CARDBOARD_WEBSITE = "http://google.com/cardboard/cfg";
    private static final String INTENT_KEY = "intent";
    public static PermissionUtils permissionUtils = new PermissionUtils();

    /* loaded from: classes.dex */
    public class ConfigureSettingsDialogFragment extends ImmersiveDialogFragment {
        private Intent intent;
        private final DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() { // from class: com.google.vr.cardboard.UiUtils.ConfigureSettingsDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    ConfigureSettingsDialogFragment.this.getActivity().startActivity(ConfigureSettingsDialogFragment.this.intent);
                } catch (ActivityNotFoundException unused) {
                    UiUtils.showInstallDialog(ConfigureSettingsDialogFragment.this.getActivity());
                }
            }
        };

        @Override // android.app.DialogFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.intent = (Intent) getArguments().getParcelable(UiUtils.INTENT_KEY);
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            AlertDialog.Builder createThemedAlertDialogBuilder = UiUtils.createThemedAlertDialogBuilder(getActivity());
            createThemedAlertDialogBuilder.setTitle(R.string.dialog_title).setMessage(R.string.dialog_message_setup).setPositiveButton(R.string.setup_button, this.listener).setNegativeButton(R.string.cancel_button, (DialogInterface.OnClickListener) null);
            return createThemedAlertDialogBuilder.create();
        }
    }

    /* loaded from: classes.dex */
    public class ImmersiveDialogFragment extends DialogFragment {
        @Override // android.app.DialogFragment, android.app.Fragment
        public void onStart() {
            if (getDialog() == null) {
                super.onStart();
                return;
            }
            getDialog().getWindow().setFlags(8, 8);
            super.onStart();
            getDialog().getWindow().getDecorView().setSystemUiVisibility(getActivity().getWindow().getDecorView().getSystemUiVisibility());
            getDialog().getWindow().clearFlags(8);
        }
    }

    /* loaded from: classes.dex */
    public class InstallSettingsDialogFragment extends ImmersiveDialogFragment {
        private final DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() { // from class: com.google.vr.cardboard.UiUtils.InstallSettingsDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    InstallSettingsDialogFragment.this.getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(UiUtils.CARDBOARD_WEBSITE)));
                } catch (ActivityNotFoundException unused) {
                    Toast.makeText(InstallSettingsDialogFragment.this.getActivity().getApplicationContext(), R.string.no_browser_text, 1).show();
                }
            }
        };

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            AlertDialog.Builder createThemedAlertDialogBuilder = UiUtils.createThemedAlertDialogBuilder(getActivity());
            createThemedAlertDialogBuilder.setTitle(R.string.dialog_title).setMessage(R.string.dialog_message_no_cardboard).setPositiveButton(R.string.go_to_playstore_button, this.listener).setNegativeButton(R.string.cancel_button, (DialogInterface.OnClickListener) null);
            return createThemedAlertDialogBuilder.create();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AlertDialog.Builder createThemedAlertDialogBuilder(Context context) {
        return new AlertDialog.Builder(context, R.style.CardboardDialogTheme);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void launchOrInstallCardboard(Context context) {
        launchOrInstallCardboard(context, true);
    }

    public static void launchOrInstallCardboard(Context context, boolean z) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        intent.setAction(CARDBOARD_CONFIGURE_ACTION);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        Integer num = null;
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (PackageUtils.isGooglePackage(str)) {
                int i = resolveInfo.priority;
                if (PackageUtils.isSystemPackage(context, str)) {
                    i++;
                }
                if (num == null) {
                    num = Integer.valueOf(i);
                } else if (i > num.intValue()) {
                    num = Integer.valueOf(i);
                    arrayList.clear();
                } else if (i >= num.intValue()) {
                }
                Intent intent2 = new Intent(intent);
                intent2.setClassName(str, resolveInfo.activityInfo.name);
                arrayList.add(intent2);
            }
        }
        if (!VrParamsProviderFactory.isContentProviderAvailable(context)) {
            permissionUtils.requestStoragePermission(context);
        }
        if (arrayList.isEmpty()) {
            showInstallDialog(context);
            return;
        }
        if (arrayList.size() == 1) {
            intent = (Intent) arrayList.get(0);
        }
        if (z) {
            showConfigureDialog(context, intent);
        } else {
            context.startActivity(intent);
        }
    }

    private static void showConfigureDialog(Context context, Intent intent) {
        FragmentManager fragmentManager = ((Activity) context).getFragmentManager();
        ConfigureSettingsDialogFragment configureSettingsDialogFragment = new ConfigureSettingsDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(INTENT_KEY, intent);
        configureSettingsDialogFragment.setArguments(bundle);
        configureSettingsDialogFragment.show(fragmentManager, "ConfigureCardboardDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showInstallDialog(Context context) {
        new InstallSettingsDialogFragment().show(((Activity) context).getFragmentManager(), "InstallCardboardDialog");
    }
}
