package com.example.composesdui.ui.common.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.material3.Surface
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.example.composesdui.core.delegate.action.ActionDelegate
import org.koin.android.ext.android.inject

class CommonPageFragment : Fragment() {


    companion object {
        const val TAG = "CommonPageFragment"
        const val pageArg = "x-page"
        fun newInstance(
            page: String
        ) = CommonPageFragment().apply {
            arguments = Bundle().apply {
                putString(pageArg, page)
            }
        }

        fun newInstance(
            bundle: Bundle? = null
        ) = CommonPageFragment().apply {
            arguments = bundle
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val page = requireArguments().getString(pageArg) ?: throw IllegalArgumentException("page argument cannot be null")
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Surface {
                    CommonPage(page)
                }
            }
        }
    }
}