package com.csec.csecandroidapp

sealed class Screens(val screen: String) {

    // main app data objects
    data object Home : Screens("home")
    data object About : Screens("about")

    data object Calendar : Screens("calendar")
    data object Officers : Screens("officers")
}