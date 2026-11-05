package br.com.alura.alugames.model

data class Jogo ( val titulo: String,
            val capa: String
           ) {
    var descricao = ""




    override fun toString(): String {
        return "Meu jogo: $titulo ,\nCapa: $capa,\nDescricao: $descricao"
    }
}