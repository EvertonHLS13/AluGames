import br.com.alura.alugames.model.Gamer

fun main() {
    val gamer1 = Gamer("Jacque", "jacque@example.com")
    println(gamer1)

    val gamer2 = Gamer("Maria",
        "maria@example.com",
        "19/19/1992",
        "mariaDB")

    println(gamer2)

    gamer1.let {
        it.dataNascimento = "18/09/2000"
        it.usuario = "jacqueSkywalker"

    }.also {
        println(gamer1.idInterno)
    }


    println(gamer1)
    gamer1.usuario = "jqSkywalker"
    println(gamer1)
}