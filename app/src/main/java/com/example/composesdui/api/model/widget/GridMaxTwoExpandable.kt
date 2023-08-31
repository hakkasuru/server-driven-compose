package com.example.composesdui.api.model.widget

import com.example.composesdui.api.model.component.BaseComponent

class GridMaxTwoExpandable : BaseWidget() {
    companion object {
        fun mockWidget(
            header: String = "Test Components",
            headerComponents: List<BaseComponent> = emptyList()
        ): GridMaxTwoExpandable {
            return GridMaxTwoExpandable().apply {
                this.header = Header(header, headerComponents)
            }
        }
    }
}