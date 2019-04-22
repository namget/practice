package com.namget.firstcitizen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.reactivex.BackpressureStrategy
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit

class RxKotlinTest : AppCompatActivity() {

    val compositeDisposable = CompositeDisposable()


    suspend fun test() {
        val a: Observable<String> = Observable.fromCallable {

            "a"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        Observable.empty()
//        Observable.defer()
//        Observable.fromCallable{}
//        Observable.interval()
//        Observable.range()
//        Observable.repeat()
//        Observable.timer()

//        Observable.just()
//        Observable.throw()

        q1()


    }

    abstract class test<T> : DisposableObserver<T>() {


        override fun onNext(t: T) {

        }

        override fun onComplete() {

        }

        override fun onError(e: Throwable) {

        }
    }


    val backButtonSubject = BehaviorSubject.createDefault(0L).toSerialized()


//    private val backButtonSubjectDisposable : Disposable =
//        backButtonSubject.toFlowable(BackpressureStrategy.BUFFER)
//            .observeOn(AndroidSchedulers.mainThread())
//            .buffer(2, 1)
//            .map { it[0] to it[1] }
//            .subscribeWith(object : test<Pair<Long, Long>>(){
//                override fun onNext(t: Pair<Long, Long>) {
//                    if(t.second - t.first < TimeUnit.SECONDS.toMillis(2000)){
//                        finish()
//                    }else{
//                        Toast.makeText(applicationContext,"다시 누르면 종료함",Toast.LENGTH_SHORT).show()
//                    }
//                }
//            })

    private val backButtonSubjectDisposable: Disposable =
        backButtonSubject.toFlowable(BackpressureStrategy.BUFFER)
            .observeOn(AndroidSchedulers.mainThread())
            .buffer(2, 1)
            .map { it[0] to it[1] }
            .subscribe {
                if (it.second - it.first < TimeUnit.SECONDS.toMillis(2)) {
                    finish()
                } else {
                    Toast.makeText(applicationContext, "뒤로가기 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
                }
            }


    override fun onBackPressed() {
        backButtonSubject.onNext(System.currentTimeMillis())
    }


    fun q1() {
        val observable1: Observable<String> = Observable.create {
            it.onNext("a")
            it.onNext("b")
            it.onComplete()
        }


//        val observable2: Observable<String> = Observable.defer {
//            loge("createTest CreateObservable :")
//            Observable.just("1", "2", "3", "4")
//        }
//
//        observable2.subscribeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { loge("onNext : ${it}") },
//                { loge("onError : ${it}") },
//                { loge("onComplete") }
//            )

//        val intervalObservable: Observable<Long> =
//            Observable.interval(2, TimeUnit.SECONDS)

        val start = 5
        val count = 3
        val timerObservable: Observable<Long> =
            Observable.timer(5, TimeUnit.SECONDS)
                .doOnSubscribe { loge("onSubscribe") }
        timerObservable.subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { loge("onNext : ${it}") },
                { loge("onError : ${it}") },
                { loge("onComplete") }
            )


//        val observableJust: Observable<String> = Observable.just("1", "2","abc","1234","aaa")

//        val fromCallableObservable: Observable<Int> = Observable.fromCallable {
//            1
//        }
//        fromCallableObservable
//            .subscribeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { loge("onNext : ${it}") },
//                { loge("onError : ${it}") },
//                { loge("onComplete") }
//            )

//
//        observable2
//            .subscribeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { loge("createTest onNext : ${it}") },
//                { loge("createTest onError : ${it}") },
//                { loge("createTest onComplete") }
//            )


        val single: Single<String> = Single.just("1")
        val observable = Observable.just("1", "2")
        //
        val subject = AsyncSubject.just("1", "2", "3")
        val maybe = Maybe.just("")
        val maybe2 = Maybe.fromCallable {
            val nullableStr: String? = null
            nullableStr
        }

//        Observable.interval(3,TimeUnit.SECONDS,Schedulers.io())
//
//        AsyncSubject.fromCallable {
//
//        }

//        val flowable = Flowable.just("")
//
//        compositeDisposable.add(subject.subscribeOn(AndroidSchedulers.mainThread())
//            .flatMap {
//                AsyncSubject.just("123${it}")
//            }.observeOn(Schedulers.io())
//            .subscribe(
//                { this@RxKotlinTest.loge("Subject onNext : ${it}") },
//                { this@RxKotlinTest.loge("Subject onError : ${it}") },
//                { this@RxKotlinTest.loge("Subject onComplete : ") }
//            )
//        )


//        val completeable = Completable.
//        compositeDisposable.add(maybe2.subscribeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { this@RxKotlinTest.loge("onSuccess : ${it}") },
//                { this@RxKotlinTest.loge("onError : ${it}") },
//                { this@RxKotlinTest.loge("onComplete : ") }
//            )
//        )
//        compositeDisposable.add(
//            maybe.subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                    { this@RxKotlinTest.loge("onSuccess : ${it}") },
//                    { this@RxKotlinTest.loge("onError : ${it}") },
//                    { this@RxKotlinTest.loge("onComplete : ") }
//                )
//        )
//
//        compositeDisposable.add(
//            Maybe.fromCallable {
//                val nullableStr: String? = null
//                nullableStr
//            }.flatMapSingle {
//                Single.just(it)
//            }.subscribe(
//                ::println,
//                { this.loge("3 : ${it}") }
//            )
//        )
//
//        compositeDisposable.add(
//            Maybe.fromCallable {
//                val nullableStr: String? = null
//                nullableStr
//            }.flatMap {
//                Maybe.just("Maybe")
//            }.subscribe(
//                ::println,
//                { loge("4 : ${it}") },
//                { loge("4 : onComplete") }
//            )
//        )


    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}