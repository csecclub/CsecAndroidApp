package com.csec.csecandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.CSEC.csecandroidapp.R
import com.csec.csecandroidapp.ui.theme.CsecAndroidAppTheme
import com.csec.csecandroidapp.ui.theme.dark_blue_csec
import com.csec.csecandroidapp.ui.theme.light_blue_csec
import com.csec.csecandroidapp.ui.theme.med_blue_csec
import com.csec.csecandroidapp.ui.theme.teal_csec
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CsecAndroidAppTheme(dynamicColor = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CsecNav()
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CsecNav() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val navigationController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    //Navigation
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            //nav drawer
            ModalDrawerSheet {
                LazyColumn (
                    modifier = Modifier.padding(top = 16.dp, end = 30.dp, bottom = 16.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    //items within drawer

                    //home
                    item {
                        NavigationDrawerItem(
                            label = { Text("Home") },
                            selected = currentRoute(navigationController) == Screens.Home.screen,
                            onClick = {
                                scope.launch {
                                    drawerState.close()
                                    navigationController.navigate(Screens.Home.screen)
                                }
                            },
                            icon = { Icon(Icons.Default.Home, contentDescription = "Home") }
                        )
                    }

                    //about
                    item {
                        NavigationDrawerItem(
                            label = { Text("About") },
                            selected = currentRoute(navigationController) == Screens.About.screen,
                            onClick = {
                                scope.launch {
                                    drawerState.close()
                                    navigationController.navigate(Screens.About.screen)
                                }
                            },
                            icon = { Icon(Icons.Default.Share, contentDescription = "About") }
                        )
                    }

                    //officers
                    item {
                        NavigationDrawerItem(
                            label = { Text("Officers") },
                            selected = currentRoute(navigationController) == Screens.Officers.screen,
                            onClick = {
                                scope.launch {
                                    drawerState.close()
                                    navigationController.navigate(Screens.Officers.screen)
                                }
                            },
                            icon = { Icon(Icons.Default.Person, contentDescription = "Officers") }
                        )
                    }

                    //calendar
                    item {
                        NavigationDrawerItem(
                            label = { Text("Calendar") },
                            selected = false,
                            onClick = {
                                scope.launch {
                                    drawerState.close()
                                    navigationController.navigate(Screens.Calendar.screen)
                                }
                            },
                            icon = { Icon(Icons.Default.DateRange, contentDescription = "Calendar") }
                        )
                    }

                }
            }
        }
    ) {
        //top bar navigation
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                val darkTheme = isSystemInDarkTheme()

                CenterAlignedTopAppBar(
                    //colors for nav bar
                    colors = TopAppBarDefaults.topAppBarColors(
//                        containerColor = if (darkTheme) { dark_blue_csec } else { teal_csec  },

                        containerColor = Color.Transparent
                    ),

                    //title for bar
                    title = {
                        Text(
                            "",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },

                    //previous screen button
                    navigationIcon = {
                        IconButton(onClick = { navigationController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = null
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "localized Desc"
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior,
                )
            },
        ) { paddingValues ->
            //navigation composable
            NavHost(
                navController = navigationController,
                startDestination = Screens.Home.screen,
                modifier = Modifier.padding(paddingValues),
            ) {
                //main app navigation
                composable(Screens.Home.screen) { Home(navController = navigationController) }
                composable(Screens.About.screen) { About(navController = navigationController) }
                composable(Screens.Officers.screen) { Officers(navController = navigationController) }
            }
        }

    }
}

// Helper function to get the current route
@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}