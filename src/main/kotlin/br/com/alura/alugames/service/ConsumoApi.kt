package br.com.alura.alugames.service

import br.com.alura.alugames.model.Infojogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {
    fun buscaJogo(id: String): Infojogo {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .header("User-Agent", "AluGames/1.0")
            .header("Accept", "application/json")
            .GET()
            .build()

        val response = client.send(
            request,
            HttpResponse.BodyHandlers.ofString()
        )

        val json = response.body()

        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, Infojogo::class.java)

        return meuInfoJogo
    }



}