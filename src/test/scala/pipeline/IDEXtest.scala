package pipeline
import chisel3._
import chiseltest._
import org.scalatest._

class IDEXtest extends FreeSpec with ChiselScalatestTester {
  "IDEX" in {
    test(new IDEX()){ c => 
    c.io.PC.poke(0x00000004.U)
    c.io.Read1.poke(0X12341234.U)
    c.io.Read2.poke(0x12351234.U)
    c.io.Immd.poke(0X44444444.U)
    c.clock.step(1)
    c.io.PCEX.expect(0x00000004.U)
    c.io.Read1EX.expect(0X12341234.U)
    c.io.Read2EX.expect(0x12351234.U)
    c.io.ImmdDEX.expect(0X44444444.U)
    }
  }
}
