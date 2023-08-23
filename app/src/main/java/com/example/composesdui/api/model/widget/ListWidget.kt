package com.example.composesdui.api.model.widget

class ListWidget : BaseWidget() {
    companion object {
        fun mockWidget(header: String = "Test Components"): ListWidget {
            return ListWidget().apply {
                this.header = Header(header)
            }
        }
    }
}
