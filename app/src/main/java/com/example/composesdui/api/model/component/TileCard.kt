package com.example.composesdui.api.model.component

data class TileCard(val data: Data) : BaseComponent() {
    data class Data(
        val title: String = "",
        val description: String = "",
        val imageURL: String  = ""
    )

    companion object {
        fun mockComponent(
            title: String = "Title",
            description: String = "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet",
            imageURL: String = "https://picsum.photos/seed/one/45/90"
        ): TileCard {
            val comp = TileCard(Data(
                title = title,
                description = description,
                imageURL = imageURL
            ))
            comp.type = "tile-manage"
            return comp
        }
    }
}
