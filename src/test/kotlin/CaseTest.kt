import org.junit.Assert.*
import org.junit.Test

class CaseTest {

    private val mutable: MutableList<Notes> = mutableListOf()

    @Test
    fun add() {
        mutable.add(0, (Notes(noteId = 1, userId = 1, ownerId = 1, title = "Заголовок 1", text = "Заметка 1", privacy = 0, commentPrivacy = 0, delStatus = false)))
        assertEquals("["+Notes(noteId = 1, userId = 1, ownerId = 1, title = "Заголовок 1", text = "Заметка 1", privacy = 0, commentPrivacy = 0, delStatus = false)+"]", mutable.toString())
    }

    @Test
    fun read() {
        var i = 0
        mutable.add(0, (Notes(noteId = 1, userId = 1, ownerId = 1, title = "Заголовок 1", text = "Заметка 1", privacy = 0, commentPrivacy = 0, delStatus = false)))
        val resultOne = mutable.getOrNull(0) ?: "No element"
        mutable.add(1, (Notes(noteId = 2, userId = 2, ownerId = 1, title = "Заголовок 2", text = "Заметка 2", privacy = 0, commentPrivacy = 0, delStatus = false)))
        val resultTwo = mutable.getOrNull(1) ?: "No element"
        val numbersIterator = mutable.iterator()
        while (numbersIterator.hasNext()) {
            i += 1
            //println("---------- $i")
            if (i == 1 )
                assertEquals(Notes(noteId = 1, userId = 1, ownerId = 1, title = "Заголовок 1", text = "Заметка 1", privacy = 0, commentPrivacy = 0, delStatus = false), resultOne)
            if (i == 2 )
                assertEquals(Notes(noteId = 2, userId = 2, ownerId = 1, title = "Заголовок 2", text = "Заметка 2", privacy = 0, commentPrivacy = 0, delStatus = false), resultTwo)
            if (i > 2)
                break
        }
    }

    @Test
    fun get() {
        mutable.add(0, (Notes(noteId = 11, userId = 1, ownerId = 1, title = "Заголовок 1", text = "Заметка 1", privacy = 0, commentPrivacy = 0, delStatus = false)))
        //НЕ найдены данные
        var resultGet = mutable.getOrNull(1) ?: "No element"
        assertEquals("No element", resultGet)
        //найдены данные
        resultGet = mutable.getOrNull(0) ?: "No element"
        assertEquals(Notes(noteId = 11, userId = 1, ownerId = 1, title = "Заголовок 1", text = "Заметка 1", privacy = 0, commentPrivacy = 0, delStatus = false), resultGet)
    }

    @Test
    fun update() {
        mutable.add(0, (Notes(noteId = 11, userId = 1, ownerId = 1, title = "Заголовок 1", text = "Заметка 1", privacy = 0, commentPrivacy = 0, delStatus = false)))
        mutable.set(0, (Notes(noteId = 111, userId = 1, ownerId = 1, title = "Заголовок 111", text = "Заметка 111", privacy = 0, commentPrivacy = 0, delStatus = false)))
        var resultUpdate = mutable.getOrNull(0) ?: "No element"
        assertEquals(Notes(noteId = 111, userId = 1, ownerId = 1, title = "Заголовок 111", text = "Заметка 111", privacy = 0, commentPrivacy = 0, delStatus = false), resultUpdate)
        resultUpdate = mutable.getOrNull(1) ?: "No element"
        assertNotEquals(Notes(noteId = 111, userId = 1, ownerId = 1, title = "Заголовок 111", text = "Заметка 111", privacy = 0, commentPrivacy = 0, delStatus = false), resultUpdate)
    }

    @Test
    fun delete() {
        mutable.add(0, (Notes(noteId = 1, userId = 1, ownerId = 1, title = "Заголовок 1", text = "Заметка 1", privacy = 0, commentPrivacy = 0, delStatus = false)))
        //mutable.add(1, (Notes(noteId = 2, userId = 2, ownerId = 1, title = "Заголовок 2", text = "Заметка 2", privacy = 0, commentPrivacy = 0, delStatus = false)))
        val numberRecord = mutable.removeAt(0)
        assertEquals(Notes(noteId = 1, userId = 1, ownerId = 1, title = "Заголовок 1", text = "Заметка 1", privacy = 0, commentPrivacy = 0, delStatus = false), numberRecord)
        assertEquals("No first entry",mutable.removeFirstOrNull() ?: "No first entry")
    }

}