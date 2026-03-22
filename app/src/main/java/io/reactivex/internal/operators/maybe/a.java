package io.reactivex.internal.operators.maybe;

import io.reactivex.b;
import io.reactivex.d;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

/* compiled from: MaybeToFlowable.java */
/* loaded from: classes2.dex */
public final class a<T> extends b<T> {

    /* renamed from: a, reason: collision with root package name */
    final e<T> f8132a;

    /* compiled from: MaybeToFlowable.java */
    /* renamed from: io.reactivex.internal.operators.maybe.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0414a<T> extends DeferredScalarSubscription<T> implements d<T> {
        private static final long serialVersionUID = 7603343402964826922L;

        /* renamed from: a, reason: collision with root package name */
        io.reactivex.i.a f8133a;

        C0414a(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f8133a.dispose();
        }

        @Override // io.reactivex.d
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.d
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.d
        public void onSubscribe(io.reactivex.i.a aVar) {
            if (DisposableHelper.validate(this.f8133a, aVar)) {
                this.f8133a = aVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public a(e<T> eVar) {
        this.f8132a = eVar;
    }

    @Override // io.reactivex.b
    protected void a(Subscriber<? super T> subscriber) {
        this.f8132a.a(new C0414a(subscriber));
    }
}
