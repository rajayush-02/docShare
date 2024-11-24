package ayush.project.docshare.presentation.screen

import kotlinx.serialization.Serializable

sealed class Screen {

    @Serializable
    data object allAnnScreen: Screen()

    @Serializable
    data object newAnnScreen: Screen()
}
