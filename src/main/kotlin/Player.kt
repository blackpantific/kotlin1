//этот способ записи называется главный конструктор класса
//можно объявлять поля(свойства) прямо в конструкторе класса
public class Player(
    _name: String,
    var _healthPoints: Int,
    var _isBlessed: Boolean,
    val _isImmortal: Boolean = false) {

    var name = _name
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }
    //можно присваивать значения полям внутри класса
//    var healthPoints = _healthPoints
//    val isBlessed = _isBlessed
//    val isImmortal = _isImmortal

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

}