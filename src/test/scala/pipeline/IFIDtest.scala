package pipeline
import chisel3._
import chiseltest._
import org.scalatest._

class IFIDtest extends FreeSpec with ChiselScalatestTester {
  "IFID" in {
    test(new IFID()){ c => 
    c.io.Instr.poke(0x12341234.U)
    c.io.PCout.poke(0X00000004.U)
    c.clock.step(1)
    c.io.InstrD.expect(0x12341234.U)
    c.io.PCoutD.expect(0X00000004.U)
    }
  }
}