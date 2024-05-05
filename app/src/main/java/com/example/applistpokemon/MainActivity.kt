package com.example.applistpokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applistpokemon.ui.theme.AppListPokemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppListPokemonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListaDePokemons(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center),
                        pokemons = Datasource().obterPokemon()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaDePokemonsApp() {
    ListaDePokemons(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        pokemons = Datasource().obterPokemon()
    )
}

@Composable
fun getBackgroundColor(type: String?): Brush {
    return when (type?.lowercase()) {
        "grass" -> Brush.sweepGradient(
            colors = listOf(Color(0xFF04C20A),Color(0xFF04C20A))
        )
        "poison" -> Brush.sweepGradient(
            colors = listOf(Color(0xFFC448FD),Color(0xFFC448FD))
        )
        "fire" -> Brush.sweepGradient(
            colors = listOf(Color(0xFFD35F01),Color(0xFFD35F01))
        )
        "water" -> Brush.sweepGradient(
            colors = listOf(Color(0xFF42A9FD),Color(0xFF42A9FD))
        )
        "normal" -> Brush.sweepGradient(
            colors = listOf(Color(0xFFD1C590),Color(0xFFD1C590))
        )
        "bug" -> Brush.sweepGradient(
            colors = listOf(Color(0xFF4B9B4E),Color(0xFF4B9B4E))
        )
        "flying" -> Brush.sweepGradient(
            colors = listOf(Color(0xFFBDB9B8), Color(0xFF3DC7EF)),
            center = Offset(0.0f, 60.0f)
        )
        else -> Brush.sweepGradient(
            colors = listOf(Color.Blue, Color.Red)
        )
    }
}


@Composable
fun CardPokemon(pokemon: Pokemon) {
    var expanded by remember {
        mutableStateOf(false)
    }
    var angle by remember { mutableStateOf(0f) }

    Card (
        elevation = CardDefaults
            .cardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 12.dp, 12.dp, 20.dp)
        ) {
            Text(
                text = "#${pokemon.id.toString()}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier =
                Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Image(painter = painterResource(id = pokemon.imagem),
                contentDescription = pokemon.nome,
                modifier = Modifier
                    .height(180.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.FillHeight
            )
            Text(
                text = pokemon.nome,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier =
                Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ){
                if (pokemon.type.type2 != null) {
                    Box (
                        modifier = Modifier
                            .width(100.dp)
                            .height(40.dp)
                            .border(
                                BorderStroke(1.dp, Color.Black),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(
                                getBackgroundColor(pokemon.type.type1),
                                shape = RoundedCornerShape(8.dp)
                            ),
                    ){
                        Text(
                            text = pokemon.type.type1,
                            modifier = Modifier
                                .padding(4.dp, 4.dp)
                                .align(Alignment.Center),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Box (
                        modifier = Modifier
                            .width(100.dp)
                            .height(40.dp)
                            .border(
                                BorderStroke(1.dp, Color.Black),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(
                                getBackgroundColor(pokemon.type.type2),
                                shape = RoundedCornerShape(8.dp)
                            ),
                    ){
                        Text(
                            text = pokemon.type.type2,
                            modifier = Modifier
                                .padding(4.dp, 4.dp)
                                .align(Alignment.Center),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                } else {
                    Box (
                        modifier = Modifier
                            .width(100.dp)
                            .height(40.dp)
                            .border(
                                BorderStroke(1.dp, Color.Black),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(
                                getBackgroundColor(pokemon.type.type1),
                                shape = RoundedCornerShape(8.dp)
                            ),
                    ){
                        Text(
                            text = pokemon.type.type1,
                            modifier = Modifier
                                .padding(4.dp, 4.dp)
                                .align(Alignment.Center),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
            ExpandableSurface(
                title = "Descriçao",
                descricao = pokemon.descricao,
                evolutions = null
            )
            ExpandableSurface(
                title = "Evoluções",
                descricao = null,
                evolutions = pokemon.evolution,
            )
        }
    }
}

@Composable
fun ExpandableSurface(
    title: String,
    descricao: String?,
    evolutions: List<Evolution>?,
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    var angle by remember { mutableStateOf(0f) }
    Surface(
        modifier = Modifier.padding(top = 16.dp),
        color = White,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color(0xFF8F8F8F)),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable {
                    expanded = !expanded
                    angle = if (expanded) 180f else 0f // Alterado para Float
                }
        ) {
            Text(
                text = title,
                Modifier.weight(1f),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.weight(1f))
            Surface(shape = CircleShape, color = Color.Blue.copy(alpha = 0.6f)) {
                Icon(
                    Icons.Outlined.ArrowDropDown,
                    contentDescription = "arrow-down",
                    modifier = Modifier.rotate(angle),
                    tint = White
                )
            }
        }
        if (descricao != null) {
            AnimatedVisibility(visible = expanded, modifier = Modifier.animateContentSize()) {
                Text(
                    text = descricao,
                    modifier = Modifier.padding(
                        PaddingValues(top = 45.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                    )
                )
            }
        }
        if (evolutions != null) {
            AnimatedVisibility(visible = expanded, modifier = Modifier.animateContentSize()) {
                Column(
                    modifier = Modifier
                        .padding(PaddingValues(top = 45.dp, start = 16.dp, end = 16.dp, bottom = 16.dp))
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        evolutions.forEachIndexed { index, evolution ->
                            Box(
                                modifier = Modifier
                                    .height(90.dp)
                                    .padding(vertical = 4.dp),

                            ) {
                                Text(
                                    text = evolution.name,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp,
                                    modifier = Modifier.align(Alignment.TopStart).width(65.dp),
                                    textAlign = TextAlign.Center,
                                )
                                Image(
                                    painter = painterResource(id = evolution.img),
                                    contentDescription = "Imagem da Evolução",
                                    modifier = Modifier
                                        .size(65.dp)
                                        .align(Alignment.BottomCenter)
                                )
                            }
                            if (index < evolutions.size - 1) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowRight,
                                    contentDescription = "Seta de transição",
                                    modifier = Modifier
                                        .size(40.dp)
                                        .offset(y = 8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ListaDePokemons(
    modifier: Modifier = Modifier,
    pokemons: List<Pokemon>
) {
    LazyColumn(modifier = modifier) {
        items(pokemons) { pokemon ->
            CardPokemon(pokemon)
        }
    }
}
