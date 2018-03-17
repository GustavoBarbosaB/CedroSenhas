package com.example.gustavobarbosab.minhassenhas.util.rx;

import io.reactivex.Scheduler;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

public interface RxScheduler {
    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();
}
