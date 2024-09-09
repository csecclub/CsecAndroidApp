package com.csec.csecandroidapp

import android.graphics.Paint.Style
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun About(navController: NavHostController, modifier: Modifier = Modifier) {

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Title
        Text(
            "Participate In Our Activities",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        //Description
        Text(
            text = "CSEC tries to host at least one activity per week. Check our Discord server or calendar for more information!",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 20.dp, end = 10.dp, bottom = 20.dp)
        )

        //3 button row
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text("Meetings")
            }
            Button(onClick = { /*TODO*/ }) {
                Text("Workshops")
            }
            Button(onClick = { /*TODO*/ }) {
                Text("      CTFS")
            }

        }
    }



}



