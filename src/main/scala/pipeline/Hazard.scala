/*package SingleCycle
import chisel3._
import chisel3.util._

class HazardUnit extends Module {
  val io = IO(new Bundle {
    val RegWriteM = Input(Bool())
    val RegWriteW = Input(Bool())
    val RD_M      = Input(UInt(5.W))
    val RD_W      = Input(UInt(5.W))
    val Rs1_E     = Input(UInt(5.W))
    val Rs2_E     = Input(UInt(5.W))
    val ForwardAE = Output(UInt(2.W))
    val ForwardBE = Output(UInt(2.W))
  })

  io.ForwardAE := MuxCase(0.U, Seq(
    (io.RegWriteM && (io.RD_M =/= 0.U) && (io.RD_M === io.Rs1_E)) -> 2.U,
    (io.RegWriteW && (io.RD_W =/= 0.U) && (io.RD_W === io.Rs1_E)) -> 1.U
  ))

  io.ForwardBE := MuxCase(0.U, Seq(
    (io.RegWriteM && (io.RD_M =/= 0.U) && (io.RD_M === io.Rs2_E)) -> 2.U,
    (io.RegWriteW && (io.RD_W =/= 0.U) && (io.RD_W === io.Rs2_E)) -> 1.U
  ))
}*/