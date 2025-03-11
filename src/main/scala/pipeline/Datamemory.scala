package SingleCycle
import chisel3._
import chisel3.util._

class Datamemory extends Module {
    val io = IO(new Bundle{
        val memwrite = Input(Bool())
        val memread = Input(Bool())
        val memaddress = Input(UInt(24.W))
        val memdata = Input(SInt(32.W))     
        val memout = Output(SInt(32.W))     
    }) 
    val mem = Mem(1024, SInt(32.W))
    io.memout := 0.S
    when(io.memwrite === 1.B && io.memread === 0.B) {
        mem.write(io.memaddress, io.memdata)
        io.memout := 0.S   
    }
    when(io.memwrite === 0.B && io.memread === 1.B) {
        io.memout := mem.read(io.memaddress)  
    }
    when(io.memwrite === 0.B && io.memread === 0.B) {
        io.memout := 0.S  
    }
}
