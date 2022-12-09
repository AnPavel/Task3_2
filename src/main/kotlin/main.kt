
interface Storage<T> {
    fun add(item: T)
    fun get(): T
    fun update(item: T)
    fun delete(item: T)
    fun read(): List<T>

    //fun add(entity: E): Long
    //fun delete(id: Long)
    //fun edit(entity: E)
    //fun read(): List<E>
    //fun getById(id: Long): E
    //fun restore(id: Long)

}

open class IdItem(val id: Int)

class Case<T: IdItem, E>(var item: T, var item2: E) : Storage<T> {

    private var numbersOne = mutableListOf<T>()

    override fun add(item: T) {
        println("-add------------------")
        this.item = item
        numbersOne.add(this.item)
        println(this.item)
    }

    override fun read(): List<T> {
        println("-read------------------")
        val numbersIterator = numbersOne.iterator()
        while (numbersIterator.hasNext()) {
            println(numbersIterator.next())
        }
        //notesCase.filterNotNull().forEach {
        //    println(it.length)
        //}
        return listOfNotNull()
    }
    //fun <T> listof(vararg elements: T): List<T> {
    //    if ( elements.size > 0) elements.asList() else emptyList()
    //    println(elements.asList())
    //    return elements.asList()
    //}

    override fun get(): T {
        println("-get------------------")
        println(this.item)
        return item
    }

    override fun update(item: T) {
        println("-update------------------")
        numbersOne[numbersOne.indexOfFirst { it.id == item.id }] = item
        //this.item = item
        //for(item in numbersOne) {
        //    println("for = $item")
        //}
        //numbersOne.forEach {Notes ->
        //    println("element = ${Notes}")
        //}
    }

    override fun delete(item: T) {
        println("-delete-------------------")
        numbersOne.removeIf { it.id == item.id }
        //numbersOne.remove(item)
        //for(item in numbersOne)
        //numbersOne.removeAt(0)
        //println(item)
    }

}


data class Notes(
    var noteId: String,
    var userId: Int,
    var ownerId: Int,
    var title: String,
    var text: String,
    var privacy: Int,
    var commentPrivacy: Int,
    var delStatus: Boolean
)


fun main() {

    println("++ 1-ый вариант ++++++++++")
    val mutable: MutableList<Notes> = mutableListOf()
    //mutable = mutableListOf(Notes(noteId = "0", userId = 0, ownerId = 0, title = "Заголовок 0", text = "Заметка 0", privacy = 0, commentPrivacy = 0, delStatus = false))
    println("++ mutable добавить ++++++++++")
    mutable.add(0, (Notes(noteId = "1", userId = 1, ownerId = 1, title = "Заголовок 1", text = "Заметка 1", privacy = 0, commentPrivacy = 0, delStatus = false)))
    mutable.add(1, (Notes(noteId = "2", userId = 2, ownerId = 2, title = "Заголовок 2", text = "Заметка 2", privacy = 0, commentPrivacy = 0, delStatus = false)))
    mutable.add(2, (Notes(noteId = "3", userId = 2, ownerId = 2, title = "Заголовок 3", text = "Заметка 3", privacy = 0, commentPrivacy = 0, delStatus = false)))
    println(mutable)
    println("++ mutable найти ++++++++++")
    println(mutable.getOrNull(1) ?: "No element")
    println(mutable.getOrNull(3) ?: "No element")
    println("++ mutable изменить ++++++++++")
    mutable.set(0, (Notes(noteId = "1", userId = 1, ownerId = 1, title = "Заголовок 111", text = "Заметка 111", privacy = 0, commentPrivacy = 0, delStatus = false)))
    println(mutable.getOrNull(0) ?: "No element")
    println("++ mutable удалить ++++++++++")
    mutable.removeAt(0)
    println(mutable)
    println("++ mutable скрыть по фильтру ++++++++++")
    mutable.set(0, (Notes(noteId = "1", userId = 1, ownerId = 1, title = "Заголовок 111", text = "Заметка 111", privacy = 0, commentPrivacy = 0, delStatus = true)))
    println(mutable.filter { !it.delStatus })
    println("++ mutable восстановить по фильтру ++++++++++")
    mutable.set(0, (Notes(noteId = "1", userId = 1, ownerId = 1, title = "Заголовок 111", text = "Заметка 111", privacy = 0, commentPrivacy = 0, delStatus = false)))
    println(mutable.filter { !it.delStatus })
    println("++ mutable очистить ВСЕ ++++++++++")
    //mutable.clear()
    //println(mutable)


    println("")
    println("++ 2-ый вариант ++++++++++")
    //val notesCase = Case(Notes("Идентификатор заметки 00",1,1,"Заголовок 00","Заметка 00",1, 1, delStatus = false),0)

    //ОШИБКА
    //The integer literal does not conform to the expected type IdItem
    val notesCase = Case(0, (Notes("Идентификатор заметки 00",1,1,"Заголовок 00","Заметка 00",1, 1, delStatus = false)))

    //ОШИБКА
    //Type mismatch: inferred type is Notes but Int was expected
    //здесь, предполагаю изменить на первый параметр номер, второй параметр Notes в add
    notesCase.add(Notes("Идентификатор заметки 01",1,1,"Заголовок 01","Заметка 1", 2, 2, delStatus = false))
    //notesCase.add(Notes("Идентификатор заметки 11",1,1,"Заголовок 11","Заметка 1", 2, 2, delStatus = false))
    //notesCase.add(Notes("Идентификатор заметки 21",1,1,"Заголовок 21","Заметка 1", 2, 2, delStatus = false))

    //notesCase.read()
    //notesCase.delete(Notes("Идентификатор заметки 01",1,1,"Заголовок 01","Заметка 1", 2, 2, delStatus = false))
    //notesCase.read()

    //notesCase.update(Notes("Идентификатор заметки 11",1,1,"Заголовок 22","Заметка 2", 2, 2, delStatus = false))
    //notesCase.read()

}

