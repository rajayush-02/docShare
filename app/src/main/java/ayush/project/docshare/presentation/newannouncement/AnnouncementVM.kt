package ayush.project.docshare.presentation.newannouncement

import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import ayush.project.docshare.data.Announcement

class AnnouncementVM : ViewModel() {
    private var allann = mutableStateListOf<Announcement>()

    init {
        allann.addAll(
            listOf(
                Announcement(text = "Welcome to the class"),
                Announcement(text = "Please sumbit assignment on time")
            )
        )
    }

    fun getAllAnn() : List<Announcement>{
        return allann
    }

    fun addAnn (announcement: Announcement){
        allann.add(announcement)
    }

    fun deleteAnn (announcement: Announcement){
        allann.remove(announcement)
    }
}