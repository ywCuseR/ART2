package com.example.art2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "topicCard") {
                composable("topicCard") {
                    TopicCard(navController = navController)
                }
                composable("P1") {
                    P1(navController = navController)
                }
                composable("P2") {
                    P2(navController = navController)
                }
                composable("P3") {
                    P3(navController = navController)
                }

            }
        }
    }
}

@Composable
fun TopicCard(navController: NavController) {
    val texts = listOf("Taipei 101", "Eluanbi Park", "Alishan Forest Railways")
    LazyColumn {
        items(texts.size) { index ->
            val text = texts[index]
            TopicCardItem(text = text, navController = navController)
        }
    }
}

@Composable
fun TopicCardItem(text: String, navController: NavController) {
    Card {
        Button(
            onClick = {
                when (text) {
                    "Taipei 101" -> {
                        navController.navigate("P1")
                    }
                    "Eluanbi Park" -> {
                        navController.navigate("P2")
                    }
                    "Alishan Forest Railways" -> {
                        navController.navigate("P3")
                    }
                }
            },
            modifier = Modifier.padding(end = 100.dp)
        ) {
            BasicText(text = text)
        }
    }
}

@Composable
fun P1(navController: NavController) {
    val context = LocalContext.current // 獲取當前的 Context

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Button(
                onClick = {
                    navController.navigateUp()
                },
                modifier = Modifier.padding(end = 200.dp)
            ) {
                BasicText(text = "home")
            }
            Image(
                painter = painterResource(id = R.drawable._1),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Taipei 101 introduction\nLocated in the finest district Taipei has to offer, " +
                        "TAIPEI 101 is the largest engineering project ever i" +
                        "n the history of the Taiwan construction business. " +
                        "Supported by a dozen or so domestic businesses, the TFC Corp. " +
                        "was fortunate to have local and international experts in charge of " +
                        "the planning, and world-class architect C.Y. Lee was responsible for " +
                        "the design of the project. The design transcends the unit-body concept " +
                        "and is based on the Chinese number 8, a numeral long " +
                        "considered lucky in Chinese culture. " +
                        "Eight-floor structural units are connected " +
                        "one by one on top of each other to form the whole. " +
                        "This kind of rhythmic aesthetic is new to skyscrapers." +
                        "The sectional TAIPEI 101 employs a Mega Structure System for " +
                        "disaster and wind damage prevention. As every eight floor constitutes " +
                        "an autonomous space, wind effects on the surface seen in high-rise " +
                        "buildings are eliminated. The design of the foundation guarantees " +
                        "pedestrian safety and comfort. Resembling the flexible yet persistent " +
                        "bamboo that rises into the sky, the building is a reflection of " +
                        "traditional Chinese building philosophy. Inclining 7 degrees inwards, " +
                        "the structure increases in size as it gets higher. The transparent " +
                        "and non-reflective curtain walls are energy efficient and heat reflective, " +
                        "enabling those in Taiwan's tallest building to have a clear view of " +
                        "the world around them. High-tech materials and innovative illumination... " +

                        "environment.About TAIPEI 101 Observatory\n" +
                        "At 382 meters above the ground the 89F Observation Floor offers " +
                        "visitors a commanding view of the city and Taipei Basin at all " +
                        "directions. The damper, weighing 660 metric tons, is also exhibited " +
                        "at this level. The Observatory is equipped with high-power binoculars, " +
                        "drinks bar, image services, pre-recorded audio tour guides in seven " +
                        "languages, & souvenir shops.\n" +
                        "\n" +
                        "About TAIPEI 101 MALL\n" +
                        "Taiwan's premier international shopping destination, " +
                        "featuring luxury goods, fashions, and fine dining.\n" +
                        "Taipei 101 Mall has gathered together the finest in " +
                        "fashion and refined dining from around the world. Our " +
                        "customers' wishes are thoughtfully catered to in a " +
                        "orld-class space that brings together sensory delights, " +
                        "a wonderful atmosphere, and architectural aesthetics, " +
                        "giving form to limitless imagination. Here, you can enjoy your " +
                        "shopping experience in comfort and total relaxation. Taipei 101 " +
                        "Mall joins the ranks of world-class shopping districts such as" +
                        "New York's Fifth Avenue, Paris' Champs-Elysees, and Rome's Via " +
                        "Condotti, with flagship stores and all-new design concepts to " +
                        "offer consumers the richest array of shopping choices. Whether " +
                        "from the perspective of its high-end goods, design flair, trend-setting " +
                        "lifestyles, or sumptuous cuisine, Taipei 101 offers consumers " +
                        "101% fresh choices in fashion and dining from around the world.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1",
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            Button(
                onClick = {
                    val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/3Tc4gynox1PTjnHZ6"))
                    if (mapIntent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(mapIntent)
                    }
                },
                modifier = Modifier.padding(end = 50.dp)
            ) {
                BasicText(text = "google map")
            }
        }
    }
}

@Composable
fun P2(navController: NavController) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Button(
                onClick = {
                    navController.navigateUp()
                },
                modifier = Modifier.padding(end = 200.dp)
            ) {
                BasicText(text = "home")
            }
            Image(
                painter = painterResource(id = R.drawable._2),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Eluanbi Park introductionKenting's rugged coastline provides " +
                        "\n" +
                        "some of the area's most outstanding attractions. " +
                        "\n" +
                        "The most prominent of these must be Eluanbi, also known as " +
                        "\n" +
                        "\"Taiwan's Tail.\" This is the island's southernmost point.\n" +
                        "\n" +
                        "Eluanbi Park was created in 1982 to provide an " +
                        "appropriate venue for people coming to visit Taiwan's " +
                        "southernmost point and one of the peninsula's most notable " +
                        "landmarks, the Eluanbi Lighthouse, also called \"The Light " +
                        "of East Asia.\" It stands 21.4 meters high and is reputedly " +
                        "the brightest lighthouse in Asia. The park covers ..." +
                        "cultures.Starting from January 19, Klook, Forest Pass, Lion Travel, " +
                        "Ibon, GOMAJI, and Taiking Ticket Platform will be selling e-tickets" +
                        " for Eluanbi Park. Visitors can go to these websites to purchase either" +
                        " Eluanbi Park Full Ticket or Joint Ticket to Kenting National Forest" +
                        "Recreation Area + Eluanbi Park.\n" +
                        "\n" +
                        "Located in the south of Taiwan, Eluanbi Park is not only famous" +
                        "\n" +
                        " for its lighthouse. The trails in the park crisscross like a maze " +
                        "and some of the most fascinating attractions include Heroes Stone," +
                        " Ocean Pavilion, Youyi Village, Twisted Banyan, Silent Valley, and " +
                        "Welcome Pavilion.\n" +
                        "\n" +
                        "In addition, the nearby \"southernmost point\" is equipped with" +
                        "a wooden observation platform and signs, allowing visitors to stand" +
                        "\n" +
                        " on the southern border and gaze out at the world. They can also observe " +
                        "\n" +
                        "the special flora of the waterfront. Of course, this is also a secret " +
                        "\n" +
                        "location where the residents of the Hengchun Peninsula go to watch the " +
                        "\n" +
                        "sunset. All of the above are rated by CNN as must-see places when you " +
                        "\n" +
                        "visit Kenting, waiting for you to go explore.Kenting forest recreation area\n" +
                        "The Shirding tribe of the people used to live near the recreation area, " +
                        "and during the Japanese Occupation period, over 513 tropical plant " +
                        "species were brought in, and after retrocession, the Hengchun branch " +
                        "of the Taiwan Forestry Research Institute, Council of Agriculture, " +
                        "Executive Yuan took over, and named it the Kenting tropical botanical " +
                        "garden. In 1967, the Forestry Research institute established the Kenting " +
                        "forest recreation area, which allows academic research while still able" +
                        " to provide education and entertainment to the public.\n" +
                        "\n" +
                        "The area is 200-300m above sea level and covers 435 hectares, accounting " +
                        "for 2.5% of the land mass in all of Taiwan’s national park. Currently, 76" +
                        " hectares of the land has been developed.Remains of coral reefs can be" +
                        " found throughout the area, and as the reefs are formed from accumulation " +
                        "and deposits of coral shellfish and algae, This area was certainly at the " +
                        "bottom of the sea some time in the past ten thousand years ago. Over 1200 " +
                        "species of plants can be found spread between the coconut, grease, rubber," +
                        " medicinal, and tropical fruit areas. Abundant shades flanks the paths with" +
                        "the colorful plants everywhere, giving you no time to rest as you take in " +
                        "all the sights.\n" +
                        "Information: Kenting National Park website!!!!!!!!!!!!!!!!!!!!!!!!!!",
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            Button(
                onClick = {
                    val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/b3Z9ymUdGiruxGBX6"))
                    if (mapIntent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(mapIntent)
                    }
                },
                modifier = Modifier.padding(end = 50.dp)
            ) {
                BasicText(text = "google map")
            }
        }
    }
}

@Composable
fun P3(navController: NavController) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Button(
                onClick = {
                    navController.navigateUp()
                },
                modifier = Modifier.padding(end = 200.dp)
            ) {
                BasicText(text = "home")
            }
            Image(
                painter = painterResource(id = R.drawable._3),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Alishan Forest Railways introductionMain Duty\n" +
                        "Devote to investigate, educate, research, promote, preserve, " +
                        "and revitalize of Alishan forest railway and cultural heritage.\n" +
                        "Assess, integrate, and re-develop the forest railway and cultural heritage.\n" +
                        "Promote and market domestic and foreign tourism affairs of forest railway.\n" +
                        "Boost international cooperation and interaction.\n" +
                        "Maintain Forestry Culture Park, railway line, and stations' facilities.\n" +
                        "Transport passengers and goods.\n" +
                        "Operate the forest railway line and relative equipment.\n" +
                        "Construct and manage bridges, tunnels, buildings, " +
                        "and engineering along the line.\n" +
                        "Other duties relative to Alishan forest railway and cultural heritage.\n" +
                        "Location and Area\n" +
                        "Alishan Forest Railway is located at the south-western part of the " +
                        "Central Mountain Range on Taiwan Island. It starts from Chiayi City," +
                        " passes through Zhuqi and Meishan Townships, and ends at Alishan Township.... " +
                        "Village.Types of Forest\n" +
                        "In the area along the railway line, the biomes of forests vary greatly from tropical, " +
                        "subtropical, temperate to cold belts at different altitudes, forming vertical forest belts" +
                        " which constitute different forest types such as broad-leaved forests, coniferous " +
                        "mixed with broad-leaved forests and coniferous forests. The main species of coniferous " +
                        "forests include cedar, Taiwania, peacock pine, Chinese fir, and other pines; " +
                        "broad-leaved trees mainly contain sorghum, Taiwan Incense Cedar, and oak.\n" +
                        "Climate\n" +
                        "Alishan Forest is at the center of the subtropical climate area." +
                        " The altitude of the area elevates" +
                        " from average 40 meters to the highest peak, Yushan, which up to 3,952 meters." +
                        " The temperature decreases follow the increase of altitude, which forms " +
                        "tropical, subtropical, temperate, and frigid climates. The average annual " +
                        "rainfall is around 3,000 millimeters. The monsoon season is from May to September, " +
                        "and the rest of the months are in the dry season.History\n" +
                        "Taiwan's forest exploitation began in the prehistoric era. During the period " +
                        "of the Japanese colonial period, the Office of the Taiwan Governor-General " +
                        "established the organizations and forestry decrees for the completion of the" +
                        " forestry management system in Taiwan. The period can be divided into nine stages" +
                        " as follows: Department of Production (1896-1897), Production Division (1898-1900), " +
                        "Production Bureau (1901-1914), Production and Forestry Bureau (1915-1918), Forestry " +
                        "Bureau (1919), Production Bureau (1920-1939), Forestry Office and Production Bureau (1940-1942), " +
                        "Production Bureau (1943), and Agricultural and Commercial Bureau (1944-1945).!!!!!!!!!!!!!!!!!!!!!!!!!!!!!",
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            Button(
                onClick = {
                    val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/a5ncvnAcpb5J7wbR9"))
                    if (mapIntent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(mapIntent)
                    }
                },
                modifier = Modifier.padding(end = 50.dp)
            ) {
                BasicText(text = "google map")
            }
        }
    }
}
