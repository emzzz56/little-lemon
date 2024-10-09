package com.emz.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            MenuDatabase::class.java,
            "menu.db"
        ).build()
    }
    private val client = HttpClient(Android){
        install(ContentNegotiation){
            json(contentType = ContentType("Text", "Plain"))
        }
    }
    private val menuItemsLiveData = MutableLiveData<List<MenuItemNetwork>>(emptyList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            val menuItemsC = getMenu()
            runOnUiThread {
                menuItemsLiveData.value = menuItemsC
            }
        }
        setContent {
            MyNavigation()
//            val menuItems by database.menuDao().getAllMenuItems()
//                .observeAsState(emptyList())
//            ItemsList(menuItems)
        }
    }
    private suspend fun getMenu(): List<MenuItemNetwork> {
        val baseUrl =
            "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"
        val response: MenuNetwork =
            client.get(baseUrl)
                .body()

        return response.menuItems
    }

}


