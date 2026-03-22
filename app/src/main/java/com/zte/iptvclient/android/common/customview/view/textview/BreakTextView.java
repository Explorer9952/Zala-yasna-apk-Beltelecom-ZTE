package com.zte.iptvclient.android.common.customview.view.textview;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes.dex */
public class BreakTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4376a;

    public BreakTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4376a = true;
    }

    private CharSequence a(TextView textView) {
        CharSequence text = textView.getText();
        String charSequence = text.toString();
        TextPaint paint = textView.getPaint();
        float width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
        String[] split = charSequence.replaceAll("\r", "").split("\n");
        StringBuilder sb = new StringBuilder();
        for (String str : split) {
            if (paint.measureText(str) <= width) {
                sb.append(str);
            } else {
                int i = 0;
                float f = 0.0f;
                while (i != str.length()) {
                    char charAt = str.charAt(i);
                    f += paint.measureText(String.valueOf(charAt));
                    if (f <= width) {
                        sb.append(charAt);
                    } else {
                        int i2 = i - 2;
                        if (i2 >= 0) {
                            int i3 = i - 1;
                            if (str.charAt(i3) >= 'A' && str.charAt(i3) <= 'z' && str.charAt(i2) >= 'A' && str.charAt(i2) <= 'z') {
                                sb.deleteCharAt(sb.length() - 1);
                                sb.append("-\n");
                                i -= 2;
                                f = 0.0f;
                            }
                        }
                        sb.append("\n");
                        i--;
                        f = 0.0f;
                    }
                    i++;
                }
            }
            sb.append("\n");
        }
        if (!charSequence.endsWith("\n")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        if (text instanceof Spanned) {
            TextUtils.copySpansFrom((Spanned) text, 0, text.length(), null, spannableString, 0);
        }
        return spannableString;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (getWidth() > 0 && getHeight() > 0 && this.f4376a) {
            CharSequence a2 = a(this);
            if (!TextUtils.isEmpty(a2)) {
                setText(a2);
            }
        }
        super.onMeasure(i, i2);
    }

    public BreakTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4376a = true;
    }
}
