package SingleCycle
import chisel3._
import chisel3.util._

class AluopGeneration extends Module {
    val io = IO(new Bundle{
        val opcode = Input(UInt(7.W))        
        val aluop = Output(UInt(2.W))    
    })

    io.aluop := "b00".U   

    switch(io.opcode) {
        is("b0110011".U) {io.aluop := "b10".U } //R TYPE
        is("b0010011".U) {io.aluop := "b10".U } //I TYPE
        is("b1100011".U) {io.aluop := "b01".U } //BRANCH
        is("b0000011".U) {io.aluop := "b00".U } //LOAD
        is("b0100011".U) {io.aluop := "b00".U } //STORE
        is("b0010111".U) {io.aluop := "b11".U } //UJ TYPE
        is("b0110111".U) {io.aluop := "b11".U } //U TYPE
    }
}
