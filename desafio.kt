enum class Nivel {Básico, Intermediário, Difícil}

data class Usuario(val nome:String, val id: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun show_user(){
        for(user in inscritos){
            print("\nUser ${user.id} -> ${user.nome}")
        }
    }

    fun show_content(){
        for(content in conteudos){
            println("Curso: ${content.nome} , Duração: ${content.duracao} , Nivel: ${content.nivel}.")
        }
    }
}


fun main() {
    val aluno1 = ConteudoEducacional("Kotlin", 50, Nivel.Básico)
    val aluno2 = ConteudoEducacional("C++", 40, Nivel.Básico)
    val aluno3 = ConteudoEducacional("HTML", 10, Nivel.Intermediário)
    val aluno4 = ConteudoEducacional("Python", 90, Nivel.Intermediário)
    val aluno5 = ConteudoEducacional("Java", 110, Nivel.Difícil)
    
    val usuario1 = Usuario("Gabriel",1)
    val usuario2 = Usuario("Luis",2)
    val usuario3 = Usuario("Pedro",3)

    val grade = mutableListOf<ConteudoEducacional>()
        grade.add(aluno1)
        grade.add(aluno2)
        grade.add(aluno3)
        grade.add(aluno4)
        grade.add(aluno5)

    
    val menu = Formacao("menu", Nivel.Difícil, grade)

    menu.matricular(usuario1)
    menu.matricular(usuario2) 
    menu.matricular(usuario3)

    println("\nUsuários: ")
    menu.show_user()
    println("\n\nCursos:")
    menu.show_content()
}