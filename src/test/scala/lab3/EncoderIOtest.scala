/*
import chiseltest._
import chisel3._
import org.scalatest._

class EncoderIOtest.scala extends FreeSpec with ChiselScalatestTester{
    test(new Encoder4to2()) { c =>
      c.io.in.poke("b0001".U)
      c.io.out.expect("b00".U)
      
      c.io.in.poke("b0010".U)
      c.io.out.expect("b01".U)
      
      c.io.in.poke("b0100".U)
      c.io.out.expect("b10".U)

      c.io.in.poke("b1000".U)
      c.io.out.expect("b11".U)
      
    }
}
*/