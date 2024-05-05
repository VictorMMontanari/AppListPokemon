package com.example.applistpokemon

class Datasource {
    fun obterPokemon(): List<Pokemon> {
        return listOf(
            Pokemon(
                1,
                "Bulbasauro",
                "Por algum tempo após seu nascimento, ele utiliza os nutrientes que estão contidos na semente em seu dorso para crescer.",
                Type("Grass", "Poison"),
                listOf(
                    Evolution("Bulbasauro", R.drawable.bulbasaur),
                    Evolution("Ivysaur", R.drawable.ivysaur),
                    Evolution("Venusaur", R.drawable.venusaur)
                ),
                R.drawable.bulbasaur
            ),
            Pokemon(
                    2,
            "Charmander",
            "A chama em sua cauda mostra a força de sua força vital. Se Charmander estiver fraco, a chama também queimará fracamente.",
            Type("Fire"),
            listOf(
                Evolution("Charmander", R.drawable.charmander),
                Evolution("Charmeleon", R.drawable.charmeleon),
                Evolution("Charizard", R.drawable.charizard)
            ),
            R.drawable.charmander
            ),
            Pokemon(
                3,
                "Squirtle",
                "Após o nascimento, suas costas incha e endurece formando uma concha. Ele espalha uma espuma potente pela boca.",
                Type("Water"),
                listOf(
                    Evolution("Squirtle", R.drawable.squirtle),
                    Evolution("Wartortle", R.drawable.wartortle),
                    Evolution("Blastoise", R.drawable.blastoise)
                ),
                R.drawable.squirtle
            ),
            Pokemon(
                4,
                "Caterpie",
                "Para proteção, ele libera um fedor horrível da antena em sua cabeça para afastar os inimigos.",
                Type("Bug"),
                listOf(
                    Evolution("Caterpie", R.drawable.caterpie),
                    Evolution("Metapod", R.drawable.metapod),
                    Evolution("Butterfree", R.drawable.butterfree)
                ),
                R.drawable.caterpie
            ),
            Pokemon(
                5,
                "Weedle",
                "Para proteção, ele libera um fedor horrível da antena em sua cabeça para afastar os inimigos.",
                Type("Bug", "Poison"),
                listOf(
                    Evolution("Weedle", R.drawable.weedle),
                    Evolution("Kakuna", R.drawable.kakuna),
                    Evolution("Beedrill", R.drawable.beedrill)
                ),
                R.drawable.weedle
            ),
            Pokemon(
                6,
                "Pidgey",
                "Para proteção, ele libera um fedor horrível da antena em sua cabeça para afastar os inimigos.",
                Type("Normal","Flying"),
                listOf(
                    Evolution("Pidgey", R.drawable.pidgey),
                    Evolution("Pidgeotto", R.drawable.pidgeotto),
                    Evolution("Pidgeot", R.drawable.pidgeot)
                ),
                R.drawable.pidgey
            ),
        )
    }
}
