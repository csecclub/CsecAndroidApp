package com.csec.csecandroidapp

import android.content.Context
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

@Composable
fun Home(navController: NavHostController, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn (
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
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
                    AsyncImage(
                        model = R.drawable.hackercat,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(CircleShape)
                    )
                }
            }

            item {
                Surface(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "CSEC",
                            modifier = Modifier.padding(top = 16.dp),
                            style = MaterialTheme.typography.headlineLarge
                        )
                        Text(
                            text = "Relax, connect, and enhance cybersecurity!",
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.titleLarge
                        )
                    }

                }
            }

            item {
                Surface(
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 20.dp)
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)
                    ) {
                        TextButton(
                            onClick = { openUrl("https://discord.com/invite/pjjgRC7ErT", context) }
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

        IconButton(
            onClick = { openUrl("https://youtube.com/@mobibyte", context) }
        ) {
            Icon(
                painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Youtube Icon"
            )
        }
        IconButton(
            onClick = { openUrl("https://www.instagram.com/codewithmobi", context) }
        ) {
            Icon(
                painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Instagram Icon"
            )
        }

        IconButton(
            onClick = { openUrl("https://www.github.com/mobibyte", context) }
        ) {
            Icon(
                painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Github Icon"
            )
        }

        IconButton(
            onClick = { openUrl("https://www.facebook.com/codewithmobi", context) }
        ) {
            Icon(
                painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Facebook Icon"
            )
        }
    }
}
