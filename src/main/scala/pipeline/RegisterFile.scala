package SingleCycle
import chisel3._
import chisel3.util._

class RegisterFile extends Module{
    val io = IO(new Bundle{
        val regWrite = Input(UInt(1.W))
        val rs1 = Input(UInt(5.W))
        val rs2 = Input(UInt(5.W))
        val rd = Input(UInt(5.W))
        val writeData = Input(UInt(32.W))
        val writeregester1 = Output(UInt(32.W))
        val writeregester2 = Output(UInt(32.W))
    })
    
    val reg = Reg(Vec(32, UInt(32.W)))

    io.writeregester1 := Mux((io.rs1.orR),reg(io.rs1),0.U)
    io.writeregester2 := Mux((io.rs2.orR),reg(io.rs2),0.U)
    
    when(io.regWrite === 1.U && io.rd =/= 0.U) {
        reg(io.rd) := io.writeData
    }
}
