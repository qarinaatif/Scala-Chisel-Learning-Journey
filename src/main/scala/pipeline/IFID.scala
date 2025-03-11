package pipeline
import chisel3._
import chisel3.util._

class IFID extends Module {
  val io = IO(new Bundle {
    val Instr = Input(UInt(32.W))
    val PCout = Input(UInt(32.W))
    val InstrD = Output(UInt(32.W))
    val PCoutD = Output(UInt(32.W))
  })

  val Instr_reg = RegNext(io.Instr,0.U(32.W))
  val PCout_reg = RegNext(io.PCout,0.U(32.W))

  io.InstrD := Instr_reg
  io.PCoutD := PCout_reg

}



