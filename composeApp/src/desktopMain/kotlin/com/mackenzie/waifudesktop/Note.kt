package com.mackenzie.waifudesktop

data class Note(
    val title: String,
    val desc : String,
    val content: String,
    val type: Type = Type.NORMAL
) {
    enum class Type { NORMAL, AUDIO, TEXT }

    private enum class Shapes(val id: Int, val shapeName: String) {
        TRIANGLE(10, "Triangle"),
        SQUARE(20, "square"),
        CIRCLE(30, "Circle"),
        RECTANGLE(40, "Rectangle"),
        PENTAGON(50, "Pentagon"),
        HEXAGON(60, "Hexagon"),
        HEPTAGON(70, "Heptagon"),
        OCTAGON(80, "Octagon"),
        OVAL(90, "Oval")
    }

    private fun generateMockedNotes(): List<Note> {
        val list = (1..50).map {
            Note(
                title = "Note $it",
                desc = "Description $it",
                content = "Content $it",
                type = getRandomtype(it)
            )
        }
        return list
    }

    private fun getRandomtype(it: Int): Type {
        when(it % 5) {
            0 -> return Type.AUDIO
            1 -> return Type.NORMAL
            else -> return Type.TEXT
        }
    }

    fun getMockedNotes(): List<Note> = listOf(
        Note(title = "Note 1", desc = "Description 1", content = "Content 1", type = Type.TEXT),
        Note(title = "Note 2", desc = "Description 2", content = "Content 2", type = Type.TEXT),
        Note(title = "Note 3", desc = "Description 3", content = "Content 3", type = Type.AUDIO),
        Note(title = "Note 4", desc = "Description 4", content = "Content 4", type = Type.TEXT),
        Note(title = "Note 5", desc = "Description 5", content = "Content 5", type = Type.AUDIO),
        Note(title = "Note 6", desc = "Description 6", content = "Content 6", type = Type.TEXT),
        Note(title = "Note 7", desc = "Description 7", content = "Content 7", type = Type.AUDIO),
        Note(title = "Note 8", desc = "Description 8", content = "Content 8"),
        Note(title = "Note 9", desc = "Description 9", content = "Content 9"),
        Note(title = "Note 10", desc = "Description 10", content = "Content 10")
    )

    fun getMockedNotesSets(): Set<Note> = setOf(
        Note(title = "Note 1", desc = "Description 1", content = "Content 1", type = Type.TEXT),
        Note(title = "Note 2", desc = "Description 2", content = "Content 2", type = Type.TEXT),
        Note(title = "Note 3", desc = "Description 3", content = "Content 3", type = Type.AUDIO),
        Note(title = "Note 4", desc = "Description 4", content = "Content 4", type = Type.TEXT),
        Note(title = "Note 5", desc = "Description 5", content = "Content 5", type = Type.AUDIO),
        Note(title = "Note 6", desc = "Description 6", content = "Content 6", type = Type.TEXT),
        Note(title = "Note 7", desc = "Description 7", content = "Content 7", type = Type.AUDIO),
        Note(title = "Note 8", desc = "Description 8", content = "Content 8"),
        Note(title = "Note 9", desc = "Description 9", content = "Content 9"),
        Note(title = "Note 10", desc = "Description 10", content = "Content 10")
    )

    fun getMockedNotesMaps(): Map<Int, Note> = mapOf(
        Pair(1, Note(title = "Note 1", desc = "Description 1", content = "Content 1", type = Type.TEXT)),
        Pair(1, Note(title = "Note 2", desc = "Description 2", content = "Content 2", type = Type.TEXT)),
        Pair(1, Note(title = "Note 3", desc = "Description 3", content = "Content 3", type = Type.AUDIO)),
        Pair(1, Note(title = "Note 4", desc = "Description 4", content = "Content 4", type = Type.TEXT)),
        Pair(1, Note(title = "Note 5", desc = "Description 5", content = "Content 5", type = Type.AUDIO)),
        Pair(1, Note(title = "Note 6", desc = "Description 6", content = "Content 6", type = Type.TEXT)),
        Pair(1, Note(title = "Note 7", desc = "Description 7", content = "Content 7", type = Type.AUDIO)),
        Pair(1, Note(title = "Note 8", desc = "Description 8", content = "Content 8")),
        Pair(1, Note(title = "Note 9", desc = "Description 9", content = "Content 9")),
        Pair(1, Note(title = "Note 10", desc = "Description 10", content = "Content 10"))
    )

    fun getMockedNotesMapsInline(): Map<Int, Note> = mapOf(
        1 to Note(title = "Note 1", desc = "Description 1", content = "Content 1", type = Type.TEXT),
        2 to Note(title = "Note 2", desc = "Description 2", content = "Content 2", type = Type.TEXT),
        3 to Note(title = "Note 3", desc = "Description 3", content = "Content 3", type = Type.AUDIO),
        4 to Note(title = "Note 4", desc = "Description 4", content = "Content 4", type = Type.TEXT),
        5 to Note(title = "Note 5", desc = "Description 5", content = "Content 5", type = Type.AUDIO),
        6 to Note(title = "Note 6", desc = "Description 6", content = "Content 6", type = Type.TEXT),
        7 to Note(title = "Note 7", desc = "Description 7", content = "Content 7", type = Type.AUDIO),
        8 to Note(title = "Note 8", desc = "Description 8", content = "Content 8"),
        9 to Note(title = "Note 9", desc = "Description 9", content = "Content 9"),
        10 to Note(title = "Note 10", desc = "Description 10", content = "Content 10")
    )
}