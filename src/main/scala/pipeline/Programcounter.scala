package SingleCycle
import chisel3._
import chisel3.util._

class Programcounter extends Module{
    val io = IO(new Bundle{
        val in = Input(SInt(32.W))
        val pcout = Output(SInt(32.W))
        val pc4 = Output(SInt(32.W))
    })
    val reg = RegInit(0.S(32.W))
    reg := io.in
    io.pcout := reg
    io.pc4 := reg + 4.S
}