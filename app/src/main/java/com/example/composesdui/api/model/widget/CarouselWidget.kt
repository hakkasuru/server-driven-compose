package com.example.composesdui.api.model.widget

class CarouselWidget : BaseWidget() {
    companion object {
        fun mockWidget(header: String = "Test Components"): CarouselWidget {
            return CarouselWidget().apply {
                this.header = Header(header)
            }
        }
    }
}