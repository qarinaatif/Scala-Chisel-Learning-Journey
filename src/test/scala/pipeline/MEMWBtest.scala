package pipeline
import chisel3._
import chiseltest._
import org.scalatest._

class MEMWBtest extends FreeSpec with ChiselScalatestTester {
  "MEMWB" in {
    test(new MEMWB()){ c => 
    c.io.ReadData.poke(0x00000004.U)
    c.io.ALUres.poke(0X12341234.U)
    c.clock.step(1)
    c.io.ReadDataWB.expect(0x00000004.U)
    c.io.ALUresWB.expect(0X12341234.U)
    }
  }
}