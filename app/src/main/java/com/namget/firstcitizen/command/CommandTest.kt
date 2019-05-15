package com.namget.firstcitizen.command

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class CommandTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        main()


    }
}

fun main() {
    val remote = SimpleRemoteControl()
    val light = Light()
    val garage = Garage()
    val lightCommand = LightOnCommand(light)
    val garageCommand = GarageOnCommand(garage)
    remote.setCommand(lightCommand)
    remote.buttonPressed()
    remote.setCommand(garageCommand)
    remote.buttonPressed()
}

interface Command {
    fun execute()
//    fun undo()
}

class MacroCommand(val commands : Array<Command>) : Command{
    override fun execute() {
        for (command in commands)
            command.execute()
    }
}

class NoCommand : Command{
    override fun execute() = println("No Command execute")
}

class Light {
    fun on() = println("light on")
    fun off() = println("light off")
}

class Garage() {
    fun up() = println("garage up")
    fun down() = println("garage down")
    fun stop() = println("garage stop")
}

class LightOnCommand(val light: Light) : Command {
    override fun execute() {
        light.on()
    }

//    override fun undo() {
//        light.off
//    }
}

class LightOffCommand(val light: Light) : Command {
    override fun execute() {
        light.off()
    }
}

class GarageOnCommand(val garage: Garage) : Command {
    override fun execute() {
        garage.up()
    }
}

class GarageOffCommand(val garage: Garage) : Command {
    override fun execute() {
        garage.down()
    }
}

class RemoteControl {
    var onCommands = arrayOfNulls<Command>(7)
    var offCommands = arrayOfNulls<Command>(7)

    init {
        val noCommand = NoCommand()
        for (i in 0 until 7) {
            onCommands[i] = noCommand
            offCommands[i] = noCommand
        }
    }

    fun setCommand(slot: Int, onCommand: Command, offCommand: Command) {
        for (i in 0 until 7) {
            onCommands[i] = onCommand
            offCommands[i] = offCommand
        }
    }
    fun onButtonPressed(slot: Int){
        onCommands[slot]?.execute()
    }
    fun offButtonPressed(slot: Int){
        offCommands[slot]?.execute()
    }

}


class SimpleRemoteControl {
    private lateinit var slot: Command
    fun setCommand(command: Command) {
        slot = command
    }

    fun buttonPressed() = slot.execute()
}
