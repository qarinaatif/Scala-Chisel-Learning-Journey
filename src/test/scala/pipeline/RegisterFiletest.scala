package SingleCycle
import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class RegisterFiletest extends FreeSpec with ChiselScalatestTester{
    "RegisterFile Test" in {
        test(new RegisterFile) { c =>
            c.io.regWrite.poke(1.U)     
            c.io.rd.poke(1.U)          
            c.io.writeData.poke(42.U)   
            c.io.rs1.poke(0.U)          
            c.io.rs2.poke(0.U)         
            c.clock.step(1)  
            c.io.rs1.poke(1.U)          
            c.io.rs2.poke(0.U)          
            c.io.writeregester1.expect(42.U)

            c.io.regWrite.poke(1.U)     
            c.io.rd.poke(2.U)           
            c.io.writeData.poke(100.U)  
            c.clock.step(1)  
            c.io.rs2.poke(2.U)        
            c.io.writeregester2.expect(100.U)

            c.io.rs1.poke(3.U)          
            c.clock.step(1) 
            c.io.writeregester1.expect(0.U) 

            c.io.regWrite.poke(1.U)     
            c.io.rd.poke(4.U)           
            c.io.writeData.poke(3.U)  
            c.clock.step(1)  
            c.io.rs1.poke(4.U)        
            c.io.writeregester1.expect(3.U)
    }
  }
}