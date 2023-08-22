package com.example.composesdui.ui.common.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Surface
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject

class CommonPageFragment : Fragment() {

    companion object {
        const val pageArg = "x-page"
        fun newInstance(
            page: String
        ) = CommonPageFragment().apply {
            arguments = Bundle().apply {
                putString(pageArg, page)
            }
        }
    }

    private val vm: CommonViewModel by inject()

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