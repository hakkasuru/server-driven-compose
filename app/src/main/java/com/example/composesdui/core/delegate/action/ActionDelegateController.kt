package com.example.composesdui.core.delegate.action

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.composesdui.api.model.action.Action

class ActionDelegateController {
    private val delegates: MutableList<BaseActionDelegate> = mutableListOf()

    fun nextActionDelegate(action: Action): BaseActionDelegate? {
        return delegates.firstOrNull { it.canHandle(action) }
    }

    fun registerDelegate(delegate: BaseActionDelegate, lifecycleOwner: LifecycleOwner? = null) {
        if (lifecycleOwner == null) {
            delegates.add(delegate)
        } else {
            delegates.add(0, delegate)
            lifecycleOwner.lifecycle.addObserver(DelegateObserver {
                delegates.remove(delegate)
            })
        }
    }

    inner class DelegateObserver(val onDestroyBlock: () -> Unit) : DefaultLifecycleObserver {
        override fun onDestroy(owner: LifecycleOwner) {
            super.onDestroy(owner)
            onDestroyBlock()
        }
    }
}