package dev.manifest.redddit.commons

import androidx.fragment.app.Fragment
import rx.subscriptions.CompositeSubscription

open class RxBaseFragment: Fragment() {

    protected var subscriptions = CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        subscriptions.clear()
    }
}