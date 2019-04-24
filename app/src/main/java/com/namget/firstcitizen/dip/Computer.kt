package com.namget.firstcitizen.dip

interface NoteBook {
    fun powerOn()
}
class SamsungNoteBook : NoteBook {
    override fun powerOn() {
        println("SamsungNoteBook powerOn")
    }
}
class LGNoteBook : NoteBook {
    override fun powerOn() {
        println("LGNoteBook powerOn")
    }
}
class MacBook : NoteBook {
    override fun powerOn() {
        println("MacBook powerOn")
    }
}
