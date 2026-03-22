package io.reactivex;

import com.zte.ucs.tvcall.Commons;
import io.reactivex.internal.subscribers.StrictSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: Flowable.java */
/* loaded from: classes2.dex */
public abstract class b<T> implements Publisher<T> {
    static {
        Math.max(1, Integer.getInteger("rx2.buffer-size", Commons.MSG_MCSP_INIT_SUCCESS).intValue());
    }

    public final void a(c<? super T> cVar) {
        io.reactivex.l.a.b.a(cVar, "s is null");
        try {
            Subscriber<? super T> a2 = io.reactivex.n.a.a(this, cVar);
            io.reactivex.l.a.b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            a(a2);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            io.reactivex.n.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    protected abstract void a(Subscriber<? super T> subscriber);

    @Override // org.reactivestreams.Publisher
    public final void subscribe(Subscriber<? super T> subscriber) {
        if (subscriber instanceof c) {
            a((c) subscriber);
        } else {
            io.reactivex.l.a.b.a(subscriber, "s is null");
            a((c) new StrictSubscriber(subscriber));
        }
    }
}
