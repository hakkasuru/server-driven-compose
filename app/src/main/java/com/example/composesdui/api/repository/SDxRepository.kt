package com.example.composesdui.api.repository

import com.example.composesdui.api.model.SDPage
import com.example.composesdui.api.model.component.TileTextComponent
import com.example.composesdui.api.model.widget.ListWidget
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SDxRepository {

    fun getPage(page: String): Flow<SDPage> = flow {
        val pageConstruct = when (page) {
            "dashboard" -> getDashboard()
            "profile" -> getProfile()
            "settings" -> getSettings()
            else -> throw IllegalArgumentException("page argument cannot be null or doesn't exist")
        }

        emit(pageConstruct)
    }

    private fun getDashboard(): SDPage {
        val widgetOne = ListWidget.mockWidget("Widget One")
        widgetOne.components = listOf(
            TileTextComponent.mockComponent("widget one component one"),
            TileTextComponent.mockComponent("widget one component two"),
            TileTextComponent.mockComponent("widget one component three")
        )
        val widgetTwo = ListWidget.mockWidget("Widget Two")
        widgetTwo.components = listOf(
            TileTextComponent.mockComponent("widget two component one"),
            TileTextComponent.mockComponent("widget two component two"),
            TileTextComponent.mockComponent("widget two component three")
        )

        return SDPage(
            id = "dashboard",
            widgets = listOf(widgetOne, widgetTwo)
        )
    }

    private fun getProfile(): SDPage {
        val widgetOne = ListWidget.mockWidget("About Me")
        widgetOne.components = listOf(
            TileTextComponent.mockComponent("Name"),
            TileTextComponent.mockComponent("Address")
        )
        val widgetTwo = ListWidget.mockWidget("Payment Information")
        widgetTwo.components = listOf(
            TileTextComponent.mockComponent("Credit Card Information")
        )

        return SDPage(
            id = "profile",
            widgets = listOf(widgetOne, widgetTwo)
        )
    }

    private fun getSettings(): SDPage {
        val widgetOne = ListWidget.mockWidget("UI Settings")
        widgetOne.components = listOf(
            TileTextComponent.mockComponent("Dark/Light Mode"),
            TileTextComponent.mockComponent("Text Size")
        )
        val widgetTwo = ListWidget.mockWidget("About App")
        widgetTwo.components = listOf(
            TileTextComponent.mockComponent("App Version")
        )

        return SDPage(
            id = "settings",
            widgets = listOf(widgetOne, widgetTwo)
        )
    }
}