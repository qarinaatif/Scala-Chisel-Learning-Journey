/*
package lab1
import chisel3._

class Mux_2to1_IO extends Bundle {
  val in_A = Input(UInt(32.W))
  val in_B = Input(UInt(32.W))
  val select = Input(Bool())
  val out = Output(UInt(32.W))
}

class Mux_2to1 extends Module {
  val io = IO(new Mux_2to1_IO)

  io.out := (io.select & io.in_A) | (~io.select & io.in_B)
}

println((new chisel3.stage.ChiselStage).emitVerilog(new Mux_2to1()))
*/