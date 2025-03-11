package SingleCycle
import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._


class ImmediateGenerationtest extends FreeSpec with ChiselScalatestTester {
  "ImmediateGeneration Test" in {
    test(new ImmediateGeneration) { c =>
      //I-type 
      c.io.instruction.poke("b00000000000000000000000000000011".U)  
      c.clock.step(1)
      c.io.immd_se.expect("b00000000000000000000000000000000".U)  
      // S-type 
      c.io.instruction.poke("b01000000000000000000000001000111".U)  
      c.clock.step(1)
      c.io.immd_se.expect("b00000000000000000000000000000000".U)  
      // SB-type
      c.io.instruction.poke("b11000000000000000000000001000011".U)  
      c.clock.step(1)
      c.io.immd_se.expect("b00000000000000000000000000000000".U) 
      // U-type 
      c.io.instruction.poke("b01101110000000000000000000000000".U)  
      c.clock.step(1)
      c.io.immd_se.expect("b00000000000000000000000000000000".U)  
      // UJ-type 
      c.io.instruction.poke("b11011110000000000000000000000001".U)  
      c.clock.step(1)
      c.io.immd_se.expect("b00000000000000000000000000000000".U) 
    }
  }
}
