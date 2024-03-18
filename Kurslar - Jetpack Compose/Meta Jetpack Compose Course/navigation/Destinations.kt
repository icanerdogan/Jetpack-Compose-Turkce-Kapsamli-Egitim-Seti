package com.ibrahimcanerdogan.metajetpackcomposecourse.navigation

interface Destinations {
    val route: String
}

object Home: Destinations {
    override val route: String
        get() = "Home"
}

object MenuList: Destinations {
    override val route: String
        get() = "MenuList"

}