package com.example.composesdui.api.model.component

data class SectionExpander(val data: Data) : BaseComponent() {
    data class Data(
        val collapseImageURL: String = "",
        val expandImageURL: String = "",
        val collapseText: String = "",
        val expandText: String = ""
    )

    companion object {
        fun mockComponent(): SectionExpander {
            val comp = SectionExpander(Data(
                collapseImageURL = "https://picsum.photos/seed/caretup/24",
                expandImageURL = "https://picsum.photos/seed/caretdown/24",
                collapseText = "See less",
                expandText = "See all"
            ))
            comp.type = "section-expander"
            return comp
        }
    }
}
