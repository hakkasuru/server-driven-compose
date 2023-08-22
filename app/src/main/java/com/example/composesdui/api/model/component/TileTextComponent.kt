package com.example.composesdui.api.model.component

data class TileTextComponent(
    val text: String = ""
) : BaseComponent() {
    companion object {
        fun mockComponent(text: String = "This is a tile text component"): TileTextComponent {
            val comp = TileTextComponent(text = text)
            comp.type = "tile-text"
            return comp
        }
    }
}
