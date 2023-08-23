package com.example.composesdui.api.model.component

data class TileTextComponent(val data: Data) : BaseComponent() {
    data class Data(
        val text: String = ""
    )

    companion object {
        fun mockComponent(text: String = "This is a tile text component"): TileTextComponent {
            val comp = TileTextComponent(Data(text = text))
            comp.type = "tile-text"
            return comp
        }
    }
}
