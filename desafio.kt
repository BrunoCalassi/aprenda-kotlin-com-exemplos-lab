enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(var nome: String, var idade: Int) {
}

data class ConteudoEducacional(var nome: String, var descricao: String = "", val duracao: Int = 60, val nivel: Nivel = Nivel.BASICO) {
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("${usuario.nome} matriculado na formação $nome de nível $nivel.")
        } else {
            println("${usuario.nome} já está matriculado na formação $nome de nível $nivel.")
        }
    }

}

fun main() {

    val usuario1 = Usuario("João", 25)
    val usuario2 = Usuario("Maria", 30)

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", "Curso introdutório de Kotlin para iniciantes.", 90, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", "Aprenda os conceitos fundamentais de POO.", 120, Nivel.INTERMEDIARIO)

    val formacao = Formacao("Desenvolvimento Kotlin", listOf(conteudo1, conteudo2), Nivel.INTERMEDIARIO)
    val formacao2 = Formacao("Desenvolvimento Kotlin", listOf(conteudo1, conteudo2), Nivel.BASICO)

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao2.matricular(usuario1)
    println("Inscritos na formação ${formacao.nome} (${formacao.nivel}):")
    for (usuario in formacao.inscritos) {
        println("- ${usuario.nome} com ${usuario.idade} anos de idade")
    }
    println("Inscritos na formação ${formacao2.nome} (${formacao2.nivel}):")
    for (usuario in formacao2.inscritos) {
        println("- ${usuario.nome} com ${usuario.idade} anos de idade")
    }
}
