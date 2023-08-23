package com.example.composesdui.api.model.component

data class TileTextComponent(val data: Data) : BaseComponent() {
    data class Data(
        val title: String = "",
        val subtitle: String = ""
    )

    companion object {
        fun mockComponent(
            title: String = "Tile Text",
            subtitle: String = "This is a tile text component"
        ): TileTextComponent {
            val comp = TileTextComponent(Data(title = title, subtitle = subtitle))
            comp.type = "tile-text"
            return comp
        }
    }
}
