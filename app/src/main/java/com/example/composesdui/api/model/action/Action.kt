package com.example.composesdui.api.model.action

data class Action(
    val type: String = "",
    val data: Data = Data.EMPTY
) {
    data class Data(
        val nav: NavActionData? = null
    ) {
        companion object {
            internal val EMPTY: Data = Data()
        }
    }
}
