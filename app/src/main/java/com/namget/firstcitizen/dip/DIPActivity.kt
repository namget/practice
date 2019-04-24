package com.namget.firstcitizen.dip

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.namget.firstcitizen.R

class DIPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val developer: Developer = Developer(SamsungNoteBook())
        developer.develop()
        developer.noteBook = MacBook()
        developer.develop()
        developer.noteBook = LGNoteBook()
        developer.develop()

    }

    data class Developer(var noteBook: NoteBook) {
        fun develop() {
            noteBook.powerOn()
        }
    }

}