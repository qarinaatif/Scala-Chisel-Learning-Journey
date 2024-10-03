//Write Chisel code for a 5-to-1 multiplexer with specifications given in Table 2.3. A skeleton
//code is also given in Listing 2.13; use it as a starting point and remember: only write your code is the
//space specified.
/*
import chisel3 . _
class LM_IO_Interface extends Bundle {
    val s0 = Input ( Bool () )
val s1 = Input ( Bool () )
val s2 = Input ( Bool () )
val out = Outpututput ( UInt (32. W ) )
}
class mux_onehot_5to1 extends Module {
  val io = IO(new Bundle {
    val in0 = Input(UInt(32.W))
    val in1 = Input(UInt(32.W))
    val in2 = Input(UInt(32.W))
    val in3 = Input(UInt(32.W))
    val in4 = Input(UInt(32.W))
    val sel = Input(UInt(3.W))
    val out = Output(UInt(32.W))
  })

  io.out := MuxLookup(io.sel, Seq(
    0.U(3.W) -> io.in0,
    1.U(3.W) -> io.in1,
    2.U(3.W) -> io.in2,
    3.U(3.W) -> io.in3,
    4.U(3.W) -> io.in4
  ))
}

println((new chisel3.stage.ChiselStage).emitVerilog(new mux_onehot_5to1()))
*/