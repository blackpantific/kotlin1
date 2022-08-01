import java.io.File

//этот способ записи называется главный конструктор класса
//можно объявлять поля(свойства) прямо в конструкторе класса
public class Player(
    _name: String,
    var _healthPoints: Int,
    var _isBlessed: Boolean,
    val _isImmortal: Boolean = false) {

    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }
    //можно присваивать значения полям внутри класса
//    var healthPoints = _healthPoints
//    val isBlessed = _isBlessed
//    val isImmortal = _isImmortal

    // Без начального значения свойство может быть null, что недопустимо,
    // если свойство имеет тип, не поддерживающий null.
    //val hometown: String
    //зато можно сделать так
    val hometown = selectHometown()

    //блок инициализации, выполняется после вызова конструктора и присваиванием полей, но перед телом конструктора
    init {
        if(name == "some") {
            require(_healthPoints > 0, { "healthPoints must be greater than zero." })
            require(name.isNotBlank(), { "Player must have a name." })
        }
    }

    //это ВТОРИЧНЫЙ конструктор, в нем нельзя определить свойства
    constructor(name: String) : this(
        name,
        _healthPoints = 100,
        _isBlessed = true,
        _isImmortal = false){
        //можно прописать альтернативную логику инициализации
        if (name.toLowerCase() == "kar")
            _healthPoints = 40
    }

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()

}