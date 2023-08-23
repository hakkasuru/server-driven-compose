package com.example.composesdui.api.model.component

data class TileImageComponent(val data: Data) : BaseComponent() {
    data class Data(
        val imageURL: String = ""
    )

    companion object {
        fun mockComponent(imageURL: String = ""): TileImageComponent {
            val comp = TileImageComponent(Data(imageURL = imageURL))
            comp.type = "tile-image"
            return comp
        }
    }
}