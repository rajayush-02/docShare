package ayush.project.docshare.presentation.newannouncement

import android.net.Uri
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ayush.project.docshare.data.Announcement



@Composable
fun newAnnouncement(
    backClick:()->Unit,
    announcementVM: AnnouncementVM = viewModel()
){
    var text by remember {
        mutableStateOf("")
    }
    val pdf by remember {
        mutableStateOf<Uri?>(null)
    }
    Column {
        Spacer(modifier = Modifier.size(50.dp))
        Row {
            IconButton(onClick = { backClick.invoke() }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Spacer(modifier = Modifier.size(90.dp))
            Button(onClick = {
                if (text.isNotBlank()){
                    announcementVM.addAnn(Announcement(text,pdf))
                }
            }) {
                Icon(imageVector = Icons.Filled.Check, contentDescription = "Add file")
                Text(text = "Post File")
            }
        }

        TextField(
            value = text,
            onValueChange ={text=it},
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(16.dp),
            label = { Text(text = "Announcement")}
        )

        pdf?.let {
            Text(text = "Pdf selected")
        } ?: Text(text = "No file selected")

        Row {
            Spacer(modifier = Modifier.size(125.dp))
            Button(onClick = {
                announcementVM.addAnn(Announcement(text , pdf))
            }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add file")
                Text(text = "Add File")
            }
        }
    }
}