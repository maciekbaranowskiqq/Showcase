package com.showcase.common

import android.app.Activity
import android.app.Application
import android.os.Bundle


open class ActivityLifecycleCallbacksAdapter : Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activity: Activity) = Unit

    override fun onActivityStarted(activity: Activity) = Unit

    override fun onActivityDestroyed(activity: Activity) = Unit

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) = Unit

    override fun onActivityStopped(activity: Activity) = Unit

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) = Unit

    override fun onActivityResumed(activity: Activity) = Unit
}