// IMyAidlInterface.aidl
package com.service.aidlsample;

// Declare any non-default types here with import statements

interface IMediaPlaybackService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void play();
    void pause();
    void stop();
    boolean isPlaying();
}