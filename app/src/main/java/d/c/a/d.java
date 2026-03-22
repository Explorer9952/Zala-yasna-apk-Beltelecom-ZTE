package d.c.a;

/* compiled from: FloatEvaluator.java */
/* loaded from: classes.dex */
public class d implements l<Number> {
    @Override // d.c.a.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float evaluate(float f, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + (f * (number2.floatValue() - floatValue)));
    }
}
