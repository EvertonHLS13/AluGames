package br.com.alura.alugames.main
import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.model.Jogo
import java.util.*
import br.com.alura.alugames.service.ConsumoApi
import transformarEmIdade

fun main() {

    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)

    println("Cadastro concluído com sucesso. Dados do gamer:")
    println(gamer)
    println("Idade do gamer: " + gamer.dataNascimento?.transformarEmIdade())

    do {
        println("Digite o ID do jogo que deseja buscar: ")
        val busca = leitura.nextLine()

        val buscaApi = ConsumoApi()
        val iformacaoJogo =  buscaApi.buscaJogo(busca)

        val resultado = runCatching {

            val meuJogo = Jogo(
                iformacaoJogo.info.title,
                iformacaoJogo.info.thumb
            )
            println(meuJogo)
        }.onFailure { e ->
            println("Erro ao criar o objeto br.com.alura.alugames.model.Jogo: ${e.message}")
        }.onSuccess {e ->
            println("Deseja inserir uma descrição personalizada? S/N")
            val opcao = leitura.nextLine()
            if (opcao.equals("S", ignoreCase = true)) {
                println("Digite a descrição personalizada: ")
                val descricaoPersonalizada = leitura.nextLine()
                val meuJogo = Jogo(
                    iformacaoJogo.info.title,
                    iformacaoJogo.info.thumb
                )
                meuJogo.descricao = descricaoPersonalizada
                println(meuJogo)
            } else {
                val meuJogo = Jogo(
                    iformacaoJogo.info.title,
                    iformacaoJogo.info.thumb
                )
                meuJogo.descricao = "${iformacaoJogo.info.title} É do krl!"

                gamer.jogosBuscados.add(meuJogo)
            }
        }
        println("Deseja buscar outro jogo? S/N")
        val reposta = leitura.nextLine()
    } while (reposta.equals("S", ignoreCase = true))

    println("Jogos buscados do ${gamer.nome} :")
    println(gamer.jogosBuscados)

    println("Jogos ordenados por titulo:")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach {
        println("Titulo: " + it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman", true) ?: false
    }

    println("\n Jogos filtrados: ")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original? S/N")
    val opcao = leitura.nextLine()
    if (opcao.equals("S", ignoreCase = true)) {
        println(gamer.jogosBuscados)
        println("\nInforme a posição do jogo que deseja exlcuir: ")
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
    }

    println("\n Lista atualizada:")
    println(gamer.jogosBuscados)

    println("Operação concluída com sucesso!")


}
