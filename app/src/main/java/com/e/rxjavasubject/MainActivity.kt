package com.e.rxjavasubject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.e.rxjavasubject.databinding.ActivityMainBinding
import com.e.rxjavasubject.rxjava.RXObservable1
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val source = PublishSubject.create<Long>()

        source.subscribe(object : Observer<Long>{
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Long) {
                binding.textView.text = t.toString()
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
            }

        })

        RXObservable1.instance.getObservable().subscribe(source)

        binding.button.setOnClickListener {
            source.onNext(999)
        }

    }
}