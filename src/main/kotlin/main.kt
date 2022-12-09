
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

    println("++ 1-�� ������� ++++++++++")
    val mutable: MutableList<Notes> = mutableListOf()
    //mutable = mutableListOf(Notes(noteId = "0", userId = 0, ownerId = 0, title = "��������� 0", text = "������� 0", privacy = 0, commentPrivacy = 0, delStatus = false))
    println("++ mutable �������� ++++++++++")
    mutable.add(0, (Notes(noteId = "1", userId = 1, ownerId = 1, title = "��������� 1", text = "������� 1", privacy = 0, commentPrivacy = 0, delStatus = false)))
    mutable.add(1, (Notes(noteId = "2", userId = 2, ownerId = 2, title = "��������� 2", text = "������� 2", privacy = 0, commentPrivacy = 0, delStatus = false)))
    mutable.add(2, (Notes(noteId = "3", userId = 2, ownerId = 2, title = "��������� 3", text = "������� 3", privacy = 0, commentPrivacy = 0, delStatus = false)))
    println(mutable)
    println("++ mutable ����� ++++++++++")
    println(mutable.getOrNull(1) ?: "No element")
    println(mutable.getOrNull(3) ?: "No element")
    println("++ mutable �������� ++++++++++")
    mutable.set(0, (Notes(noteId = "1", userId = 1, ownerId = 1, title = "��������� 111", text = "������� 111", privacy = 0, commentPrivacy = 0, delStatus = false)))
    println(mutable.getOrNull(0) ?: "No element")
    println("++ mutable ������� ++++++++++")
    mutable.removeAt(0)
    println(mutable)
    println("++ mutable ������ �� ������� ++++++++++")
    mutable.set(0, (Notes(noteId = "1", userId = 1, ownerId = 1, title = "��������� 111", text = "������� 111", privacy = 0, commentPrivacy = 0, delStatus = true)))
    println(mutable.filter { !it.delStatus })
    println("++ mutable ������������ �� ������� ++++++++++")
    mutable.set(0, (Notes(noteId = "1", userId = 1, ownerId = 1, title = "��������� 111", text = "������� 111", privacy = 0, commentPrivacy = 0, delStatus = false)))
    println(mutable.filter { !it.delStatus })
    println("++ mutable �������� ��� ++++++++++")
    //mutable.clear()
    //println(mutable)


    println("")
    println("++ 2-�� ������� ++++++++++")
    //val notesCase = Case(Notes("������������� ������� 00",1,1,"��������� 00","������� 00",1, 1, delStatus = false),0)

    //������
    //The integer literal does not conform to the expected type IdItem
    val notesCase = Case(0, (Notes("������������� ������� 00",1,1,"��������� 00","������� 00",1, 1, delStatus = false)))

    //������
    //Type mismatch: inferred type is Notes but Int was expected
    //�����, ����������� �������� �� ������ �������� �����, ������ �������� Notes � add
    notesCase.add(Notes("������������� ������� 01",1,1,"��������� 01","������� 1", 2, 2, delStatus = false))
    //notesCase.add(Notes("������������� ������� 11",1,1,"��������� 11","������� 1", 2, 2, delStatus = false))
    //notesCase.add(Notes("������������� ������� 21",1,1,"��������� 21","������� 1", 2, 2, delStatus = false))

    //notesCase.read()
    //notesCase.delete(Notes("������������� ������� 01",1,1,"��������� 01","������� 1", 2, 2, delStatus = false))
    //notesCase.read()

    //notesCase.update(Notes("������������� ������� 11",1,1,"��������� 22","������� 2", 2, 2, delStatus = false))
    //notesCase.read()

}

