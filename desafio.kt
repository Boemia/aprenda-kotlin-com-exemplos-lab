enum class Nivel {Básico, Intermediário, Difícil}

data class Usuario(val nome:String, val id: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Inscricao(val aluno: Usuario, val curso: ConteudoEducacional)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario){
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
    
    val listados = mutableListOf<Inscricao>()
    
    fun incluir(inscricao: Inscricao){
        listados.add(inscricao)
    }
    
    fun show_inclusos(){
        for (inclusos in listados){
            print("\n${inclusos.aluno} se inscreveu em ${inclusos.curso}")
        }
    }
}


fun main() {
    val usuario1 = Usuario("Gabriel",1)
    val usuario2 = Usuario("Luis",2)
    val usuario3 = Usuario("Pedro",3)
    
    val opcao1 = ConteudoEducacional("Kotlin", 50, Nivel.Básico)
    val opcao2 = ConteudoEducacional("C++", 40, Nivel.Básico)
    val opcao3 = ConteudoEducacional("HTML", 10, Nivel.Intermediário)
    val opcao4 = ConteudoEducacional("Python", 90, Nivel.Intermediário)
    val opcao5 = ConteudoEducacional("Java", 110, Nivel.Difícil)
    
    val inscricao1 = Inscricao(usuario1, opcao2)
    val inscricao2 = Inscricao(usuario2, opcao1)
    val inscricao3 = Inscricao(usuario3, opcao5)

    val grade = mutableListOf<ConteudoEducacional>()
        grade.add(opcao1)
        grade.add(opcao2)
        grade.add(opcao3)
        grade.add(opcao4)
        grade.add(opcao5)
        
    val menu = Formacao("menu", Nivel.Difícil, grade)

    menu.matricular(usuario1)
    menu.matricular(usuario2) 
    menu.matricular(usuario3)
    
    menu.incluir(inscricao1)
    menu.incluir(inscricao2)
    menu.incluir(inscricao3)

    println("\nUsuários: ")
    menu.show_user()
    println("\n\nCursos:")
    menu.show_content()
    println("\n\nInscrições:")
    menu.show_inclusos()
     
    
}
