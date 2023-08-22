package com.example.composesdui.api.model.widget

class ListWidget(
    val header: Header? = null
) : BaseWidget() {
    data class Header(
        val title: String? = null
    )

    companion object {
        fun mockWidget(header: String = "Test Components"): ListWidget {
            return ListWidget(header = Header(header))
        }
    }
}
