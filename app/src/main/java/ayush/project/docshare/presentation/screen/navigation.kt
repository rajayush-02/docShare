package ayush.project.docshare.presentation.screen

import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ayush.project.docshare.presentation.newannouncement.AllAnnouncementScreen
import ayush.project.docshare.presentation.newannouncement.newAnnouncement


@Composable
fun MainNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screen.allAnnScreen
    ) {

        composable<Screen.allAnnScreen> {
            AllAnnouncementScreen(onClick = { navController.navigate(Screen.newAnnScreen){popUpToRoute} })
        }
        composable<Screen.newAnnScreen> {
            newAnnouncement(backClick = { navController.navigate(Screen.allAnnScreen){popUpToRoute} })
        }
    }
}


