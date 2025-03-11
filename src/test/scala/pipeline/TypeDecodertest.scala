package SingleCycle
import chiseltest._
import chisel3._
import org.scalatest._

class TypeDecodertest extends FreeSpec with ChiselScalatestTester {
    "TypeDecodertest" in{
    test(new TypeDecoder) { c =>
        c.io.opcode.poke("b0000011".U) 
        c.clock.step(1)
        c.io.load_out.expect(1.U) 
        
        
        }
    }   
}