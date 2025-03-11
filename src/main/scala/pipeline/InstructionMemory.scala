package SingleCycle
import chisel3._
import chisel3.util._
import chisel3.util.experimental.loadMemoryFromFile
import scala.io.Source

class InstructionMemory (initFile : String)extends Module {
    val io = IO(new Bundle{
        val readadress = Input(UInt(24.W))
        val readdata = Output(UInt(32.W))
    })
    val mem = Mem(1024,UInt(32.W))
    loadMemoryFromFile ( mem , initFile )
    io.readdata := mem( io.readadress )
}