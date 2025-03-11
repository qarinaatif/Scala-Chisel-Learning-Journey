package SingleCycle
import chisel3._
import chisel3.util._

class Alucontrol extends Module {
    val io = IO(new Bundle{
        val aluop = Input(UInt(2.W))
        val opcode = Input(UInt(7.W))
        val func7 = Input(UInt(7.W))
        val func3 = Input(UInt(3.W))
        val aluctrl = Output(UInt(6.W))
    })

    when(io.aluop === 0.U){ io.aluctrl := "b000000".U} // load store 0
    .elsewhen(io.aluop === 1.U){ io.aluctrl := "b111111".U} //branch
    .elsewhen(io.aluop === 2.U){ 
        when ( io.opcode === "b0110011".U){    
            switch(io.func3) {
                is("b000".U) { 
                    when( io.func7 === "b0000000".U){io.aluctrl := "b000000".U} // ADD 0
                    .elsewhen( io.func7 === "b0100000".U){io.aluctrl := "b000001".U}} // SUB 1
                is("b001".U) { io.aluctrl := "b000010".U } // SLL 2
                is("b111".U) { io.aluctrl := "b000011".U } // AND 3
                is("b110".U) { io.aluctrl := "b000100".U } // OR 4
                is("b100".U) { io.aluctrl := "b000101".U } // XOR 5
                is("b101".U) { 
                    when( io.func7 === "b0000000".U){io.aluctrl := "b0000110".U} // SRL 6
                    .elsewhen( io.func7 === "b001000".U){io.aluctrl := "b000111".U}} // SRA 7
                is("b010".U) { io.aluctrl := "b001000".U } // SLT 8
                is("b011".U) { io.aluctrl := "b001001".U } // SLTU 9
            }
        }
        .elsewhen ( io.opcode === "b0010011".U){    
            switch(io.func3) {
                is("b000".U) { io.aluctrl := "b000000".U } // ADDI 0
                is("b001".U) { when( io.func7 === "b0000000".U){io.aluctrl := "b000010".U}} // SLLI 2
                is("b010".U) { io.aluctrl := "b001000".U } // SLTI 8
                is("b011".U) { io.aluctrl := "b001001".U } // SLTIU 9
                is("b100".U) { io.aluctrl := "b000101".U } // XORI 5
                is("b101".U) { 
                    when( io.func7 === "b0000000".U){io.aluctrl := "b0000110".U} // SRLI 6
                    .elsewhen( io.func7 === "b0100000".U){io.aluctrl := "b000111".U}} // SRAI 7
                is("b110".U) { io.aluctrl := "b000100".U } // ORI 4
                is("b111".U) { io.aluctrl := "b000011".U } // ANDI 3
            }
        }
    }
} 
