package SingleCycle
import chisel3._
import chisel3.util._

class Alu extends Module {
    val io = IO(new Bundle {
        val op1 = Input(UInt(32.W))  
        val op2 = Input(UInt(32.W))  
        val aluctrl = Input(UInt(6.W)) 
        val aluout = Output(UInt(32.W)) 
        val zero = Output(Bool()) 
    })
    io.aluout := 0.U  
   
    switch(io.aluctrl) {
        is("b000000".U) { io.aluout := io.op1 + io.op2 } // ADD
        is("b000001".U) { io.aluout := io.op1 - io.op2 } // SUB
        is("b000010".U) { io.aluout := io.op1 << io.op2(4,0) } // SLL 
        is("b000011".U) { io.aluout := io.op1 & io.op2 } // AND
        is("b000100".U) { io.aluout := io.op1 | io.op2 } // OR
        is("b000101".U) { io.aluout := io.op1 ^ io.op2 } // XOR
        is("b000110".U) { io.aluout := io.op1 >> io.op2(4,0) } // SRL (
        is("b000111".U) { io.aluout := (io.op1.asSInt >> io.op2(4,0)).asUInt } // SRA 
        is("b001000".U) { io.aluout := Mux(io.op1.asSInt < io.op2.asSInt, 1.U, 0.U) } // SLT 
        is("b001001".U) { io.aluout := Mux(io.op1 < io.op2, 1.U, 0.U) } // SLTU 
        //is("b000011".U) { io.aluout := io.op1 & io.op2 } // AND
        is("b111111".U) {
            when(io.branch){
                switch ( io.fnct3) {
                    is ("b0000".U){
                        if (io.br_taken := (io.op1 === io.op2)){
                           io.zero := (io.aluout === 1.U) 
                        }.elsewhen{io.zero := (io.aluout === 0.U)}
                    }
                    is ("b0001".U){
                        if (io.br_taken := (io.op1 =/= io.op2)){
                           io.zero := (io.aluout === 1.U) 
                        }.elsewhen{io.zero := (io.aluout === 0.U)}
                    }
                    is ("b0010".U){
                        if (io.br_taken := (io.op1 < io.op2)){
                           io.zero := (io.aluout === 1.U) 
                        }.elsewhen{io.zero := (io.aluout === 0.U)}
                    }
                    is ("b0100".U){
                        if (io.br_taken := (io.op1 >= io.op2)){
                           io.zero := (io.aluout === 1.U) 
                        }.elsewhen{io.zero := (io.aluout === 0.U)}
                    } 
                }
            }
        }      
    }
}
