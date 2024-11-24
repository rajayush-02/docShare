package ayush.project.docshare.presentation.newannouncement

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import ayush.project.docshare.data.Announcement


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllAnnouncementScreen(
    onClick:()->Unit,
    announcementVM: AnnouncementVM = viewModel()
){
    Scaffold (
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(top = 20.dp),
                title = {
                    Surface (
                        modifier = Modifier.fillMaxWidth(0.95f),
                        color = Color.Blue.copy(alpha = 0.3f)
                    ){
                        Column {
                            Text(text = "All Announcements")
                            Button(onClick = {
                                onClick.invoke()
                            }) {
                                Icon(imageVector = Icons.Filled.Add, contentDescription = "")
                                Text(text = "Add Announcement")
                            }
                        }
                    }
                }
            )
        }
    ) {

        Column {
            Spacer(modifier = Modifier.size(20.dp))
            LazyColumn (
                modifier = Modifier.padding(it)
            ){
                val list = announcementVM.getAllAnn()
                items(list) {
                    AnnBlock(announcement = it)
                }
            }
        }
    }
}



@Composable
fun AnnBlock(
    announcementVM: AnnouncementVM = viewModel(),
    announcement: Announcement
){
    Column {
        Surface(
            modifier = Modifier
                .heightIn(70.dp, 150.dp)
                .fillMaxWidth(),
            tonalElevation = 10.dp,
            border = BorderStroke(width = 2.dp, color = Color.Black)
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(70.dp, 150.dp)
            ) {
                Text(text = announcement.text)
            }
        }

        Row {

            Button(onClick = {

            }) {

                Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "View Pdf")
                Text(text = "View File")
            }

            Spacer(modifier = Modifier.size(5.dp))

            Button(onClick = {
                announcementVM.deleteAnn(announcement)
            }) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete")
            }
        }
    }
}





