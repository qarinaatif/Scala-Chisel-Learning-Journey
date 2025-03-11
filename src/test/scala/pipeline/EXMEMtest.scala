package pipeline
import chisel3._
import chiseltest._
import org.scalatest._

class EXMEMtest extends FreeSpec with ChiselScalatestTester {
  "EXMEM" in {
    test(new EXMEM()){ c => 
    c.io.Jump.poke(0x00000004.U)
    c.io.Zero.poke(0.B)
    c.io.ALUres.poke(0x12351234.U)
    c.io.ReadData2.poke(0X44444444.U)
    c.clock.step(1)
    c.io.JumpMEM.expect(0x00000004.U)
    c.io.ZeroMEM.expect(0.B)
    c.io.ALUresMEM.expect(0x12351234.U)
    c.io.ReadData2MEM.expect(0X44444444.U)
    }
  }
}

