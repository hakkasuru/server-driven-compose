package com.example.composesdui.api.model

import com.example.composesdui.api.model.widget.BaseWidget

data class SDPage(
    val id: String,
    val widgets: List<BaseWidget> = emptyList()
)
