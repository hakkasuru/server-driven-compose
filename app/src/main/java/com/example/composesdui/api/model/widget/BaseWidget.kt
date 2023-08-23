package com.example.composesdui.api.model.widget

import com.example.composesdui.api.model.component.BaseComponent

abstract class BaseWidget {
    var type: String? = null
    var components: List<BaseComponent> = emptyList()
    var tag: Tag? = null

    data class Tag(
        var name: String = ""
    )
}