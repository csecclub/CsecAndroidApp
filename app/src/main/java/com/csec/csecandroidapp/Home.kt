package com.csec.csecandroidapp

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.CSEC.csecandroidapp.R
import com.csec.csecandroidapp.ui.theme.CsecAndroidAppTheme
import com.csec.csecandroidapp.ui.theme.dark_blue_csec
import com.csec.csecandroidapp.ui.theme.light_blue_csec
import com.csec.csecandroidapp.ui.theme.med_blue_csec
import com.csec.csecandroidapp.ui.theme.teal_csec

@Composable
fun Home(navController: NavHostController, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val colors = if (isSystemInDarkTheme()) {
        listOf(
            med_blue_csec,
            light_blue_csec,
            dark_blue_csec
        )
    } else {
        listOf(
            light_blue_csec,
            teal_csec,
            teal_csec
        )
    }

    Surface() {
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors
                    )
                )
        ) {
            LazyColumn (
                modifier = modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                //Michi logo (soon to be button)
                item {
                    Box(
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp)
                            .scale(1.5f)
                            .size(150.dp)
                            // 2. Box for Image Shaping
                            .clip(CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        //image of michi
                        AsyncImage(
                            model = R.drawable.hackercat,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(5.dp)
                                .clip(CircleShape)
                        )
                        //michi's invisible button
                        IconButton(
                            onClick = { /*TODO: Meow when clicked*/ },
                            modifier = Modifier.scale(5.0f),
                        ) { }

                    }
                }

                //CSEC short description
                item {
                    Column (
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Welcome to CSEC",
                            modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = "Relax, connect, and enhance cybersecurity!",
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.headlineLarge
                        )
                    }

                }

                //Join CSEC discord button
                item {
                    val discordPad = intArrayOf(40, 20)

                    Surface(
                        color = med_blue_csec.copy(alpha = 0.8f),
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = discordPad[0].dp,
                                end = discordPad[0].dp,
                                top = discordPad[1].dp,
                                bottom = discordPad[0].dp
                            )
                    ) {
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)
                        ) {
                            TextButton(
                                onClick = { openUrl("https://discord.gg/8YuGKecGU4", context) }
                            ) {
                                Text(
                                    text = "Become a member",
                                    modifier = Modifier.padding(16.dp),
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "button")
                            }
                        }
                    }
                }

                item {
                    AppButtons()
                }
            }
        }

    }
}

//Appbuttons is used to display social media links
//Each IconButton is a seperate link followed by a Icon
@Composable
fun AppButtons(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val context = LocalContext.current

        //Instagram
        IconButton(
            onClick = { openUrl("https://www.instagram.com/uta.csec/", context) }
        ) {
            // <a href="https://www.flaticon.com/free-icons/instagram" title="instagram icons">Instagram icons created by Freepik - Flaticon</a>
            Icon(
                painterResource(id = R.drawable.instagram),
                contentDescription = "Instagram Icon"
            )
        }
        //Twitter
        IconButton(
            onClick = { openUrl("https://twitter.com/UTA_CSEC", context) }
        ) {
            // <a href="https://www.flaticon.com/free-icons/twitter" title="twitter icons">Twitter icons created by Pixel perfect - Flaticon</a>
            Icon(
                painterResource(id = R.drawable.twitter),
                contentDescription = "Twitter Icon"
            )
        }
    }
}
