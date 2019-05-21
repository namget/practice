package com.namget.firstcitizen.facade

import android.os.Bundle
import android.support.v4.app.TaskStackBuilder
import android.support.v7.app.AppCompatActivity

class FacadeTest : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}


class HomeTheatherFacade(val amplifier: Amplifier,
                         val tuner: Tuner,
                         val dvdPlayer: DvdPlayer,
                         val cdPlayer: CdPlayer,
                         val projector: Projector,
                         val theaterLights: TheaterLights,
                         val screen: Screen,
                         val popcornPopper: PopcornPopper
                         ){
    fun watchMovie(){
        popcornPopper.on()
        projector.on()
        screen.down()
        theaterLights.dim(10)
    }
    fun endMovie(){
        popcornPopper.off()
        projector.off()
        screen.up()
        theaterLights.dim(0)
    }
}

class Amplifier{
}

class Tuner{
}
class DvdPlayer{
}
class CdPlayer{
}
class Projector{
    fun on() = println("projecter on")
    fun off() = println("projecter on")
}
class TheaterLights{
    fun dim(value: Int) = println("light dim $value")
}
class Screen{
    fun up() = println("screen up")
    fun down() = println("screen down")
}
class PopcornPopper{
    fun on()= println("popcorn on")
    fun off()= println("popcorn off")
}