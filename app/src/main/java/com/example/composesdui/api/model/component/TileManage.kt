package com.example.composesdui.api.model.component

data class TileManage(val data: Data) : BaseComponent() {
    data class Data(
        val title: String = "",
        val description: String = "",
        val imageURL: String  = ""
    )

    companion object {
        fun mockComponent(
            title: String = "",
            description: String = "",
            imageURL: String = ""
        ): TileManage {
            val comp = TileManage(Data(
                title = title,
                description = description,
                imageURL = imageURL
            ))
            comp.type = "tile-manage"
            return comp
        }
    }
}
